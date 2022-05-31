package br.com.letscodemarketplace.marketplace.Repositories;

import br.com.letscodemarketplace.marketplace.models.Carrinho;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaRepository extends MongoRepository<Carrinho, String> {
}
