package a.vkube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "driverslicense")
public class DriverLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int driverLicenseID;

    @Column
    private String number;

    @Column
    private Date dateOfReceipt;

    @OneToMany(mappedBy = "driverLicense")
    Set<Driver> driverSet;

    @Override
    public String toString() {
        return "DriverLicense{" +
                "driverLicenseID=" + driverLicenseID +
                ", number='" + number + '\'' +
                ", dateOfReceipt=" + dateOfReceipt +
                '}';
    }
}
