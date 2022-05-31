package br.com.letscodemarketplace.marketplace;

import br.com.letscodemarketplace.marketplace.models.Carrinho;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MarketplaceApplication {


	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}

}
