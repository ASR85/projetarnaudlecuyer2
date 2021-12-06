package be.condorcet.projetarnaudlecuyer2.services;

        import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
        import be.condorcet.projetarnaudlecuyer2.entities.SessionCours;
        import be.condorcet.projetarnaudlecuyer2.repositories.FormateurRepository;
        import be.condorcet.projetarnaudlecuyer2.repositories.SessionCoursRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;
        import org.springframework.stereotype.Service;

        import javax.transaction.Transactional;
        import java.sql.Date;
        import java.util.List;

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
        return sessionCoursRepository.findById(id).get();
    }

    @Override
    public SessionCours read(int id)  {
        return sessionCoursRepository.findById(id).get();
    }


    @Override
    public SessionCours update(SessionCours sessionCours) throws Exception{
        Integer id = sessionCours.getId();
        SessionCours oldCl= read(id);
        oldCl.setDatedebut(sessionCours.getDatedebut());
        oldCl.setDatefin(sessionCours.getDatefin());
        oldCl.setNbreinscrits(sessionCours.getNbreinscrits());
        sessionCoursRepository.save(oldCl);
        return read(oldCl.getId());
    }
    @Override
    public void delete(SessionCours sessionCours) throws Exception {
        sessionCoursRepository.deleteById(sessionCours.getId());
    }

    @Override
    public List<SessionCours> getSessionCours(Formateur fo) {
        List<SessionCours> lsc = sessionCoursRepository.findSessionCoursByFormateur(fo);
        return lsc;
    }

    @Override
    public List<SessionCours> read_dateDebut(Date datedebut){
        return sessionCoursRepository.findByDatedebutLike(datedebut);
    }

    @Override
    public List<SessionCours> read_dateFin(Date datefin){
        return sessionCoursRepository.findByDatefinLike(datefin);
    }

    @Override
    public List<SessionCours> read_nbrInscrits(int nbreinscrits)  {
        return sessionCoursRepository.findBynbreinscrits(nbreinscrits);
    }

}


