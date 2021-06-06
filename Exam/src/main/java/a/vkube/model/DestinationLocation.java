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
@Table(name = "destinationlocation")
public class DestinationLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int destinationLocationID;

    @Column
    private String city;

    @Column
    private String village;

    @Column
    private String street;

    @Column
    private String house;

    @Column
    private String building;

    @Column
    private String entrance;

    @OneToMany(mappedBy = "destinationLocation")
    Set<Order> orderSet;

    @Override
    public String toString() {
        return String.valueOf(destinationLocationID);
    }
}
