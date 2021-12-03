package be.condorcet.projetarnaudlecuyer2.repositories;


import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur,Integer> {

public List<Formateur> findByNomLikeAndPrenomLikeAndMailLike(String nom, String prenom, String mail);
public List<Formateur> findByNomLike(String nom);
public List<Formateur> findByPrenomLike(String prenom);
public List<Formateur> findByMail(String mail);
}
