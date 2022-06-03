package br.com.letscodemarketplace.marketplace.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CarrinhoResponse {

    private String idCarrinhoResponse;
    private List<Produto> listaProdutos = new ArrayList<>();

    public CarrinhoResponse(String id, List<Produto> listaProdutos) {
        this.idCarrinhoResponse = id;
        this.listaProdutos = listaProdutos;
    }
}
