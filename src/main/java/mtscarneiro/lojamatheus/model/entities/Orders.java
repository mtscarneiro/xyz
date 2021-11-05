package mtscarneiro.lojamatheus.model.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "TB_ORDERS")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "orders")
    private List<Items> itemsList;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    public Orders(Long id, List<Items> itemsList, Clients client) {
        this.id = id;
        this.itemsList = itemsList;
        this.client = client;
    }
}
