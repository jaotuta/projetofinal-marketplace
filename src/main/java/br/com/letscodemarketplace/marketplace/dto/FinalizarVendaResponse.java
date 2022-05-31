package br.com.letscodemarketplace.marketplace.dto;

import br.com.letscodemarketplace.marketplace.Utils.AprovacaoPagamento;
import br.com.letscodemarketplace.marketplace.Utils.MetodoPagamento;

import java.lang.String;

public class FinalizarVendaResponse {

    private String idVenda;
    private String idCLiente;
    private String idCarrinho;
    private MetodoPagamento metodoPagamento;
    private AprovacaoPagamento aprovacaoPagamento;

    public FinalizarVendaResponse(String idVenda, String idCLiente, String idCarrinho, MetodoPagamento metodoPagamento, AprovacaoPagamento aprovacaoPagamento) {
        this.idVenda = idVenda;
        this.idCLiente = idCLiente;
        this.idCarrinho = idCarrinho;
        this.metodoPagamento = metodoPagamento;
        this.aprovacaoPagamento = aprovacaoPagamento;
    }
}
