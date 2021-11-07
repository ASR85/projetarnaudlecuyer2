package be.condorcet.monprojet2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "maitrise", schema = "public", catalog = "d6m1q13bi9o7ol")

public class Maitrise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer degremaitrise;
    private String nom;
    private String prenom;
    private Integer fk_idcours;
}

