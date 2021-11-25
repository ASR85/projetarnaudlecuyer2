package be.condorcet.projetarnaudlecuyer2.repositories;

import be.condorcet.projetarnaudlecuyer2.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SessionCoursRepository extends JpaRepository<SessionCours,Integer> {

    public List<SessionCours> findByDateDebutLikeAndDateFinLikeAndNbreinscritsLike(Date dateDebut, Date dateFin, int nbreinscrits);
    public List<SessionCours> findByDateDebutLike(Date dateDebut);
    public List<SessionCours> findByDateFinLike(Date dateFin);
    public List<SessionCours> findBynbreinscrits(int nbreinscrits);

}
