package br.com.letscodemarketplace.marketplace.dto;

import lombok.Data;

import java.lang.String;
import java.util.UUID;

@Data
public class NovoProdutoNoCarrinhoRequest {
    private UUID idProduto;
    private String idCarrinho;

}
