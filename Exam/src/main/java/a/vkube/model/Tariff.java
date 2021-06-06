package a.vkube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int tariffID;

    @Column
    private String name;

    @Column
    private String cost;

    @OneToMany(mappedBy = "tariff")
    Set<Order> orderSet;

    @Override
    public String toString() {
        return String.format(name);
    }
}
