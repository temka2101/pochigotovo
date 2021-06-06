package a.vkube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int driverID;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "driverslicense_ID")
    private DriverLicense driverLicense;

    @ManyToOne
    @JoinColumn(name = "status_ID")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "passports_ID")
    private Passport passport;

    @ManyToMany
    @JoinTable(name = "drivers_has_cars",
        joinColumns = @JoinColumn(name = "drivers_id"),
        inverseJoinColumns = @JoinColumn(name = "cars_id"))
    private Set<Car> carSet;

    @ManyToMany
    @JoinTable(name = "orders_has_drivers",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "drivers_id"))
    private Set<Order> orderSet;

    @Override
    public String toString() {
        return "Driver{" +
                "driverID=" + driverID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", driverLicense=" + driverLicense +
                ", status=" + status +
                ", passport=" + passport +
                '}';
    }
}