package br.com.letscodemarketplace.marketplace.Utils;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class VerificarPagamentoAprovado {
    Random gerador = new Random();

    public Boolean verificaPagamentoAprovado() {

        int numero = gerador.nextInt(10);
        return numero != 5;

    }
}
