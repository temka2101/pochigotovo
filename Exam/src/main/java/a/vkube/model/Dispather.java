package a.vkube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "dispather")
public class Dispather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int dispatherID;

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

    @ManyToOne
    @JoinColumn(name = "administrator_ID")
    private Administrator administrator;

    @Override
    public String toString() {
        return String.valueOf(dispatherID);
    }
}
