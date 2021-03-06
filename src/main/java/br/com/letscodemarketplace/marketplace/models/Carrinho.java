package br.com.letscodemarketplace.marketplace.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

import java.util.List;
import java.lang.String;
import java.util.UUID;

@Data
@Document
public class Carrinho {

    @Id
    private String idCarrinho;

    private List<UUID> listaProdutos = new ArrayList<>();

}
