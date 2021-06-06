package a.vkube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int carsID;

    @Column
    private String stamp;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private Year yearOfRelease;

    @Column
    private String vin;

    @Column
    private String registrationMark;

    @ManyToMany(mappedBy = "carSet")
    private Set<Driver> driverSet;

    @Override
    public String toString() {
        return "Car{" +
                "carsID=" + carsID +
                ", stamp='" + stamp + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", vin='" + vin + '\'' +
                ", registrationMark='" + registrationMark + '\'' +
                '}';
    }
}
