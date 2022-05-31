package br.com.letscodemarketplace.marketplace.client;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "produtos", url = "http://localhost:8090/produtos/")
public interface ProdutoClient {
}
