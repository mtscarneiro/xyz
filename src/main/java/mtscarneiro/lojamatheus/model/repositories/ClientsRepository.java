package mtscarneiro.lojamatheus.model.repositories;

import mtscarneiro.lojamatheus.model.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
