package mtscarneiro.lojamatheus.model.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "TB_ITENS")
public class Items implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    public Items(Long id, String name, String description, Double price, Orders orders) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.orders = orders;
    }
}
