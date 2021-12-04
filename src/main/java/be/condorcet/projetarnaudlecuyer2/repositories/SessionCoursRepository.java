package be.condorcet.projetarnaudlecuyer2.repositories;

import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
import be.condorcet.projetarnaudlecuyer2.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SessionCoursRepository extends JpaRepository<SessionCours,Integer> {

    public List<SessionCours> findByDatedebutLikeAndDatefinLikeAndNbreinscritsLike(Date datedebut, Date datefin, int nbreinscrits);
    public List<SessionCours> findByDatedebutLike(Date datedebut);
    public List<SessionCours> findByDatefinLike(Date datefin);
    public List<SessionCours> findBynbreinscrits(int nbreinscrits);
    public List<SessionCours> findSessionCoursByFormateur(Formateur fo);

}
