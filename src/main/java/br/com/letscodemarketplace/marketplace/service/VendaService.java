package br.com.letscodemarketplace.marketplace.service;

import br.com.letscodemarketplace.marketplace.Repositories.VendaRepository;
import br.com.letscodemarketplace.marketplace.Utils.AprovacaoPagamento;
import br.com.letscodemarketplace.marketplace.Utils.VerificarPagamentoAprovado;
import br.com.letscodemarketplace.marketplace.dto.CarrinhoResponse;
import br.com.letscodemarketplace.marketplace.dto.FinalizarVendaRequest;
import br.com.letscodemarketplace.marketplace.dto.NovoProdutoNoCarrinhoRequest;
import br.com.letscodemarketplace.marketplace.dto.FinalizarVendaResponse;
import br.com.letscodemarketplace.marketplace.models.Carrinho;
import br.com.letscodemarketplace.marketplace.models.FinalizarVenda;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class VendaService {


    VendaRepository vendaRepository;
    VerificarPagamentoAprovado verificarPagamentoAprovado;

    public CarrinhoResponse addAoCarrinho(NovoProdutoNoCarrinhoRequest novoProdutoNoCarrinhoRequest) {
        Optional<Carrinho> carrinhoOptional = vendaRepository.findById(novoProdutoNoCarrinhoRequest.getIdCarrinho());

        if (!carrinhoOptional.isPresent()) {
            Carrinho carrinho = new Carrinho();
            List<String> listaProdutos = new ArrayList<>();
            listaProdutos.add(novoProdutoNoCarrinhoRequest.getIdProduto());
            carrinho.setListaProdutos(listaProdutos);
            vendaRepository.save(carrinho);
            CarrinhoResponse carrinhoResponse = new CarrinhoResponse(
                    carrinho.getIdCarrinho(),
                    carrinho.getListaProdutos());

            return carrinhoResponse ;
        }else {

            List<String> listaProdutos = carrinhoOptional.get().getListaProdutos();
            listaProdutos.add(novoProdutoNoCarrinhoRequest.getIdProduto());
            carrinhoOptional.get().setListaProdutos(listaProdutos);
            CarrinhoResponse carrinhoResponse = new CarrinhoResponse(
                    carrinhoOptional.get().getIdCarrinho(),
                    carrinhoOptional.get().getListaProdutos());
            vendaRepository.save(carrinhoOptional.get());
            return carrinhoResponse;

        }


    }

    public List<Object> geraCarrinhoComProdutos (ArrayList<String> listaIdProdutos) {

        //List<Object> carrinhoComProdutos =  listaIdProdutos.forEach();

        return null;
    }

    public FinalizarVendaResponse finalizarVenda(FinalizarVendaRequest finalizarVendaRequestRequest) {
        Random gerador = new Random();

        FinalizarVenda finalizarVenda = new FinalizarVenda();
        BeanUtils.copyProperties(finalizarVendaRequestRequest, finalizarVenda);
        //TODO VERIFICAR SE PAGAMENTO APROVADO(NOVO SERVIÇO)

        if ((verificarPagamentoAprovado.verificaPagamentoAprovado())) {
            finalizarVenda.setAprovacaoPagamento(AprovacaoPagamento.APROVADO);
        } else {
            finalizarVenda.setAprovacaoPagamento(AprovacaoPagamento.REPROVADO);
        }

        FinalizarVendaResponse finalizarVendaResponse = new FinalizarVendaResponse(
                finalizarVenda.getIdVenda(),
                finalizarVenda.getIdCLiente(),
                finalizarVenda.getIdCarrinho(),
                finalizarVenda.getMetodoPagamento(),
                finalizarVenda.getAprovacaoPagamento());

        return finalizarVendaResponse;
    }
    public List<Carrinho> findAllCarrinhos() {
        return vendaRepository.findAll();
    }
}
