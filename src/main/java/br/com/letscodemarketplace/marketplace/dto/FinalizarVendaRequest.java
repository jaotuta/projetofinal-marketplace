package br.com.letscodemarketplace.marketplace.dto;

import br.com.letscodemarketplace.marketplace.Utils.MetodoPagamento;
import lombok.Data;

import java.lang.String;
@Data
public class FinalizarVendaRequest {

    private String idCliente;
    private String idCarrinho;
    private MetodoPagamento metodoPagamento;

}
