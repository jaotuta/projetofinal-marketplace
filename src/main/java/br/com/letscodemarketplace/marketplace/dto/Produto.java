package br.com.letscodemarketplace.marketplace.dto;

import lombok.Data;

import java.util.UUID;
@Data
public class Produto {

    private UUID id;

    private String nome;

    private String fabricante;

    private String valor;
}
