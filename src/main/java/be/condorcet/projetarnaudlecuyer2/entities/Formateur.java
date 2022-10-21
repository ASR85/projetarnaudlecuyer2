package be.condorcet.projetarnaudlecuyer2.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name="formateur",schema="public",catalog="d6m1q13bi9o7ol")

public class Formateur{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String mail;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;


    @OneToMany(mappedBy="formateur",fetch = FetchType.LAZY)
    @ToString.Exclude
    private Collection<SessionCours> sessionCours;


}
