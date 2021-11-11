package be.condorcet.monprojet2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.soap.Name;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="sessioncours",schema="public",catalog="d6m1q13bi9o7ol")

public class SessionCours {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateDebut;
    private Date dateFin;
    private Integer nbreinscrits;
    @ManyToOne
    @JoinColumn(name="fk_idformateur")
    private Formateur formateur;
}
