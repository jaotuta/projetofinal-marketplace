package br.com.letscodemarketplace.marketplace.models;

import br.com.letscodemarketplace.marketplace.Utils.AprovacaoPagamento;
import br.com.letscodemarketplace.marketplace.Utils.MetodoPagamento;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.lang.String;

@Data

public class FinalizarVenda {

    @Id
    private String idVenda;
    private String idCLiente;
    private String idCarrinho;
    private MetodoPagamento metodoPagamento;
    private AprovacaoPagamento aprovacaoPagamento = AprovacaoPagamento.AGUARDANDOAPROVACAO;

}
