package br.com.letscodemarketplace.marketplace.dto;

import br.com.letscodemarketplace.marketplace.Utils.MetodoPagamento;

import java.lang.String;

public class FinalizarVendaRequest {

    private String idCLiente;
    private String idCarrinho;
    private MetodoPagamento metodoPagamento;

}
