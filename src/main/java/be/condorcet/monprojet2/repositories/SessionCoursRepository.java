package be.condorcet.monprojet2.repositories;

import be.condorcet.monprojet2.entities.Formateur;
import be.condorcet.monprojet2.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository

public interface SessionCoursRepository extends JpaRepository<SessionCours,Integer> {

    public List<SessionCours> findByDateDLikeAndDateFLikeAndNbrILike(Date dateDebut, Date dateFin, int nbreinscrits);


}
