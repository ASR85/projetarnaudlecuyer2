package be.condorcet.monprojet2.services;

        import be.condorcet.monprojet2.entities.Formateur;
        import be.condorcet.monprojet2.entities.SessionCours;
        import be.condorcet.monprojet2.repositories.FormateurRepository;
        import be.condorcet.monprojet2.repositories.SessionCoursRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;
        import org.springframework.stereotype.Service;

        import javax.transaction.Transactional;
        import java.sql.Date;

@Component
@Service
@Transactional(rollbackOn = Exception.class)
public class SessionCoursServiceImpl implements InterfSessioncoursService{

    @Autowired
    private SessionCoursRepository sessionCoursRepository;

    @Autowired
    private FormateurRepository formateurRepository;

    @Override
    public SessionCours create(SessionCours sessionCours) throws Exception{
        sessionCoursRepository.save(sessionCours);
        return sessionCours;
    }

    @Override
    public SessionCours read(Integer id) throws Exception {
        return null;
    }

    public SessionCours read(Date dateDebut, Date dateFin, int nbreinscrits) {
        return sessionCoursRepository.findByDateDebutLikeAndDateFinLikeAndNbrILike(dateDebut, dateFin, nbreinscrits).stream().findFirst().get();
    }


    @Override
    public SessionCours update(SessionCours sessionCours) throws Exception{
        Integer id = sessionCours.getId();
        SessionCours oldCl= read(id);
        oldCl.setDateDebut(sessionCours.getDateDebut());
        oldCl.setDateFin(sessionCours.getDateFin());
        oldCl.setNbreinscrits(sessionCours.getNbreinscrits());

        sessionCoursRepository.save(oldCl);
        return read(oldCl.getId());
    }
    @Override
    public void delete(SessionCours sessionCours) throws Exception {
        sessionCoursRepository.deleteById(sessionCours.getId());
    }

}


