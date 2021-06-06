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
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int statusID;

    @Column
    private String name;

    @OneToMany(mappedBy = "status")
    Set<Driver> driverSet;

    @OneToMany(mappedBy = "status")
    Set<Order> orderSet;

    @Override
    public String toString() {
        return String.format(name);
    }
}
