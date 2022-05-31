package br.com.letscodemarketplace.marketplace.controllers;

import br.com.letscodemarketplace.marketplace.dto.CarrinhoResponse;
import br.com.letscodemarketplace.marketplace.dto.FinalizarVendaRequest;
import br.com.letscodemarketplace.marketplace.dto.NovoProdutoNoCarrinhoRequest;
import br.com.letscodemarketplace.marketplace.models.Carrinho;
import br.com.letscodemarketplace.marketplace.service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/venda")
@AllArgsConstructor
public class VendaController {

    VendaService vendaService;

    @GetMapping("/health")
    public String healthAPI () {
        return "API is up";
    }

    @GetMapping("/carrinho")
    public List<Carrinho> carrinhos () {
        return vendaService.findAllCarrinhos();
    }

    @PostMapping("/add-carrinho")
    public ResponseEntity<CarrinhoResponse> venda(@RequestBody NovoProdutoNoCarrinhoRequest novoProdutoNoCarrinhoRequest) {

       return ResponseEntity.status(HttpStatus.OK).body(vendaService.addAoCarrinho(novoProdutoNoCarrinhoRequest));

    }

    @PostMapping("/finalizar")
    public ResponseEntity<Object> finalizarVenda(@RequestBody FinalizarVendaRequest finalizarVendaRequestRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(vendaService.finalizarVenda(finalizarVendaRequestRequest));

    }

}
