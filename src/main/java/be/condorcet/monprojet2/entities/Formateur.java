package be.condorcet.monprojet2.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "formateur", schema = "public", catalog = "d6m1q13bi9o7ol")

public class Formateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mail;
    private String nom;
    private String prenom;
    private Integer fk_idsessioncours;

    @ManyToOne @JoinColumn(name="id")
    private SessionCours sessionCours;

}
