package br.com.letscodemarketplace.marketplace.dto;

import br.com.letscodemarketplace.marketplace.Utils.AprovacaoPagamento;
import br.com.letscodemarketplace.marketplace.Utils.MetodoPagamento;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.String;
import java.util.List;
@Data
@Document
public class FinalizarVendaResponse {

    @Id
    private String idVenda;
    private Cliente cliente;
    private List<Produto> idCarrinho;
    private MetodoPagamento metodoPagamento;
    private AprovacaoPagamento aprovacaoPagamento;

    public FinalizarVendaResponse(String idVenda, Cliente cliente, List<Produto> idCarrinho, MetodoPagamento metodoPagamento, AprovacaoPagamento aprovacaoPagamento) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.idCarrinho = idCarrinho;
        this.metodoPagamento = metodoPagamento;
        this.aprovacaoPagamento = aprovacaoPagamento;
    }
}
