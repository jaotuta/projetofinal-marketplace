package br.com.letscodemarketplace.marketplace.Repositories;

import br.com.letscodemarketplace.marketplace.dto.FinalizarVendaResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaFinalRepository extends MongoRepository<FinalizarVendaResponse, String> {
}
