package mtscarneiro.lojamatheus.services;

import mtscarneiro.lojamatheus.model.entities.Clients;
import mtscarneiro.lojamatheus.model.entities.Orders;
import mtscarneiro.lojamatheus.model.repositories.ClientsRepository;
import mtscarneiro.lojamatheus.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    private ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<Orders> findAllOrders(Long clientId) {
        Optional<Clients> clients = clientsRepository.findById(clientId);

        List<Orders> orders = clients
                .orElseThrow(() -> new ResourceNotFoundException(clientId))
                .getOrders();

        return orders;
    }
}
