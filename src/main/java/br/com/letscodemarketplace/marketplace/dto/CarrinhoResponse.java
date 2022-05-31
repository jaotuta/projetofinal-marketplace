package br.com.letscodemarketplace.marketplace.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CarrinhoResponse {

    private String idCarrinhoResponse;
    private List<String> listaProdutos = new ArrayList<>();

    public CarrinhoResponse(String id, List<String> listaProdutos) {
        this.idCarrinhoResponse = id;
        this.listaProdutos = listaProdutos;
    }
}
