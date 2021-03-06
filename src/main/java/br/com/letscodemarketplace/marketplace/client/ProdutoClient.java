package br.com.letscodemarketplace.marketplace.client;

import br.com.letscodemarketplace.marketplace.dto.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "produto-market/produtos")
public interface ProdutoClient {

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    Produto getProdutos(@PathVariable("id") UUID id);

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<Produto> getTodosProdutos();

}
