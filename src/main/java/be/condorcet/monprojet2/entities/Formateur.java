package be.condorcet.monprojet2.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "formateur", schema = "public", catalog = "d6m1q13bi9o7ol")

public class Formateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mail;
    private String nom;
    private String prenom;

    @OneToMany @JoinColumn(name="formateur")
    private Collection<SessionCours> sessionCours;

}
