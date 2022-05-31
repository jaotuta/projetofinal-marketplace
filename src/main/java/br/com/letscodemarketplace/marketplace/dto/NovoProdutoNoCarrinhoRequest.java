package br.com.letscodemarketplace.marketplace.dto;

import lombok.Data;

import java.lang.String;

@Data
public class NovoProdutoNoCarrinhoRequest {
    private String idProduto;
    private String idCarrinho;

}
