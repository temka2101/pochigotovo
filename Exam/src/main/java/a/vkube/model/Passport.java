package a.vkube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "passports")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int passportID;

    @Column
    private String passportSeries;

    @Column
    private String passportNumber;

    @Column
    private String byWhomGetting;

    @Column
    private LocalDate dateOfReceipt;

    @Column
    private String adress;

    @Column
    private LocalDate birthday;

    @OneToMany(mappedBy = "passport")
    Set<Driver> driverSet;

    @OneToMany(mappedBy = "passport")
    Set<Administrator> administratorSet;

    @OneToMany(mappedBy = "passport")
    Set<Dispather> dispatherSet;

    @Override
    public String toString() {
        return "Passport{" +
                "passportID=" + passportID +
                ", passportSeries='" + passportSeries + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", byWhomGetting='" + byWhomGetting + '\'' +
                ", dateOfReceipt=" + dateOfReceipt +
                ", adress='" + adress + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
