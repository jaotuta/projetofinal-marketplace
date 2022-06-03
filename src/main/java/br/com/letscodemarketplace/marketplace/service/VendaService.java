package br.com.letscodemarketplace.marketplace.service;

import br.com.letscodemarketplace.marketplace.Repositories.VendaFinalRepository;
import br.com.letscodemarketplace.marketplace.Repositories.VendaRepository;
import br.com.letscodemarketplace.marketplace.Utils.AprovacaoPagamento;
import br.com.letscodemarketplace.marketplace.Utils.VerificarPagamentoAprovado;
import br.com.letscodemarketplace.marketplace.client.ClienteClient;
import br.com.letscodemarketplace.marketplace.client.ProdutoClient;
import br.com.letscodemarketplace.marketplace.dto.*;
import br.com.letscodemarketplace.marketplace.models.Carrinho;
import br.com.letscodemarketplace.marketplace.models.FinalizarVenda;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class VendaService {


    private final VendaRepository vendaRepository;
    private final VerificarPagamentoAprovado verificarPagamentoAprovado;
    private final ProdutoClient produtoClient;
    private final ClienteClient clienteClient;
    private final VendaFinalRepository vendaFinalRepository;

    public CarrinhoResponse addAoCarrinho(NovoProdutoNoCarrinhoRequest novoProdutoNoCarrinhoRequest) {

        Optional<Carrinho> carrinhoOptional = vendaRepository.findById(novoProdutoNoCarrinhoRequest.getIdCarrinho());

        if (carrinhoOptional.isEmpty()) {
            Carrinho carrinho = new Carrinho();
            List<UUID> listaProdutos = new ArrayList<>();
            listaProdutos.add(novoProdutoNoCarrinhoRequest.getIdProduto());
            carrinho.setListaProdutos(listaProdutos);
            vendaRepository.save(carrinho);
            CarrinhoResponse carrinhoResponse = new CarrinhoResponse(
                    carrinho.getIdCarrinho(),
                    geraCarrinhoComProdutos(carrinho.getListaProdutos()));

            return carrinhoResponse ;
        }else {

            List<UUID> listaProdutos = carrinhoOptional.get().getListaProdutos();
            listaProdutos.add(novoProdutoNoCarrinhoRequest.getIdProduto());
            carrinhoOptional.get().setListaProdutos(listaProdutos);
            CarrinhoResponse carrinhoResponse = new CarrinhoResponse(
                    carrinhoOptional.get().getIdCarrinho(),
                    geraCarrinhoComProdutos(carrinhoOptional.get().getListaProdutos()));
            vendaRepository.save(carrinhoOptional.get());
            return carrinhoResponse;

        }


    }

    public Cliente buscaCliente(String idCliente){
        return clienteClient.getCliente(idCliente);
    }
    public List<Produto> geraCarrinhoComProdutos (List<UUID> listaIdProdutos) {
        List<Produto> listaCarrinhoComProdutos = new ArrayList<>();
        for (UUID produtos:listaIdProdutos) {
            Produto carrinhoComProdutos = produtoClient.getProdutos(produtos);
            listaCarrinhoComProdutos.add(carrinhoComProdutos);
        }

        return listaCarrinhoComProdutos;
    }

    public FinalizarVendaResponse finalizarVenda(FinalizarVendaRequest finalizarVendaRequestRequest) {
        Optional<Carrinho> carrinhoOptional = vendaRepository.findById(finalizarVendaRequestRequest.getIdCarrinho());
        Cliente clienteVenda = buscaCliente(finalizarVendaRequestRequest.getIdCliente());
        System.out.printf("aaaaa" + clienteVenda.getNome());
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
                clienteVenda,
                geraCarrinhoComProdutos(carrinhoOptional.get().getListaProdutos()),
                finalizarVenda.getMetodoPagamento(),
                finalizarVenda.getAprovacaoPagamento());
        vendaFinalRepository.save(finalizarVendaResponse);
        return finalizarVendaResponse;
    }
    public List<Carrinho> findAllCarrinhos() {
        return vendaRepository.findAll();
    }
}
