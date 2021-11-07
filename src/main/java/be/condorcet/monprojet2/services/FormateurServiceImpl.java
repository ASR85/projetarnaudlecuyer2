package be.condorcet.monprojet2.services;

import be.condorcet.monprojet2.entities.Formateur;
import be.condorcet.monprojet2.repositories.FormateurRepository;
import be.condorcet.monprojet2.repositories.SessionCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Service
@Transactional(rollbackOn = Exception.class)
public class FormateurServiceImpl implements InterfFormateurService{

        @Autowired
        private FormateurRepository formateurRepository;

        @Autowired
        private SessionCoursRepository sessionCoursRepository;

        @Override
        public Formateur create(Formateur formateur) throws Exception{
            formateurRepository.save(formateur);
            return formateur;
        }

    @Override
    public Formateur read(Integer id) throws Exception {
        return null;
    }

    @Override
        public Formateur read(String nom, String prenom, String mail) {
            return formateurRepository.findByNomLikeAndPrenomLikeAndMailLike(nom, prenom, mail).stream().findFirst().get();
        }


    @Override
        public Formateur update(Formateur formateur) throws Exception{
            Integer id = formateur.getId();
            Formateur oldCl= read(id);
            oldCl.setNom(formateur.getNom());
            oldCl.setPrenom(formateur.getPrenom());
            oldCl.setMail(formateur.getMail());

            formateurRepository.save(oldCl);
            return read(oldCl.getId());
        }
        @Override
        public void delete(Formateur formateur) throws Exception {
            formateurRepository.deleteById(formateur.getId());
        }

    }



