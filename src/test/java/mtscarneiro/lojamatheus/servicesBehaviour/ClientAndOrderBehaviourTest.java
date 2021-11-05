package mtscarneiro.lojamatheus.servicesBehaviour;

import com.github.javafaker.Faker;
import mtscarneiro.lojamatheus.model.entities.Clients;
import mtscarneiro.lojamatheus.model.entities.Items;
import mtscarneiro.lojamatheus.model.entities.Orders;
import mtscarneiro.lojamatheus.model.repositories.ClientsRepository;
import mtscarneiro.lojamatheus.services.ClientsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClientAndOrderBehaviourTest {

    private ClientsService clientsService;
    Faker faker = new Faker();

    @Mock
    private ClientsRepository clientsRepository;

    @BeforeEach
    void init() {
        clientsService = Mockito.mock(ClientsService.class);
    }

    @Test
    @DisplayName("A client can have one or more orders")
    void assertThatTheClientCanHaveAnOrderOrTwo() {
        Long clientId = faker.random().nextLong() * 1;
        List<Orders> orders = clientsService.findAllOrders(clientId);

        Assertions.assertTrue(orders.isEmpty());
    }

    @Test
    @DisplayName("A order needs to be filled with one or more items")
    void assertThatTheOrderHasOneOrMoreItems() {
        Orders order = createOrder();

        Assertions.assertTrue(order.getItemsList() != null);
    }

    private Orders createOrder() {
        return new Orders(faker.random().nextLong(), createListOfItems(), new Clients(
                faker.random().nextLong(),
                faker.address().city(),
                faker.ancient().god(),
                new ArrayList<>()));
    }

    private List<Items> createListOfItems() {
        Items items = createItems();
        Items items1 = createItems();
        Items items2 = createItems();
        Items items3 = createItems();

        return Arrays.asList(items, items1, items2, items3);
    }

    private Items createItems() {
        return new Items(
                faker.random().nextLong(),
                faker.ancient().god(),
                faker.ancient().hero(),
                faker.random().nextDouble(),
                new Orders()
        );
    }
}
