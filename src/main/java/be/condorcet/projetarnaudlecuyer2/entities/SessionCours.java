package be.condorcet.projetarnaudlecuyer2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="sessioncours",schema="public",catalog="d6m1q13bi9o7ol")

public class SessionCours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date datedebut;
    private Date datefin;
    private Integer nbreinscrits;
    @ManyToOne
    @JoinColumn(name="fk_idformateur")
    private Formateur formateur;
}
