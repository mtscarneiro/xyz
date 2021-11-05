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
@Table(name = "TB_CLIENTS")
public class Clients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Orders> orders;

    public Clients(Long id, String email, String name, List<Orders> orders) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.orders = orders;
    }
}
