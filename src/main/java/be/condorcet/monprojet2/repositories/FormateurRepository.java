package be.condorcet.monprojet2.repositories;


import be.condorcet.monprojet2.entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur,Integer> {

public List<Formateur> findByNomLikeAndPrenomLikeAndMailLike(String nom, String prenom, String mail);

}
