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
@Table(name = "administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int adminID;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String patronymic;

    @Column
    private String login;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "passports_ID")
    private Passport passport;

    @OneToMany(mappedBy = "administrator")
    Set<Dispather> dispatherSet;

    @Override
    public String toString() {
        return "Administrator{" +
                "adminID=" + adminID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", passport=" + passport +
                '}';
    }
}
