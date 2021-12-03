package be.condorcet.projetarnaudlecuyer2.webservices;

import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
import be.condorcet.projetarnaudlecuyer2.entities.SessionCours;
import be.condorcet.projetarnaudlecuyer2.services.FormateurServiceImpl;
import be.condorcet.projetarnaudlecuyer2.services.SessionCoursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")

@RestController
@RequestMapping("/sessioncours")

public class RestSessionCours {

    @Autowired
    private SessionCoursServiceImpl sessionCoursServiceImpl;
    @Autowired
    private FormateurServiceImpl formateurServiceImpl;

    //-------------------Retrouver la session de cours correspondant à un num donné----------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SessionCours> getSessionCours(@PathVariable(value = "id") int id)  throws Exception {
        System.out.println("Recherche de la session de cours num " + id);
        SessionCours scours = sessionCoursServiceImpl.read(id);
        return new ResponseEntity<>(scours, HttpStatus.OK);
    }

        //-------------------Retrouver la session de cours correspondant à un num donné-------------------------------
        @RequestMapping(value = "/fk_idformateur={id}", method = RequestMethod.GET)
        public ResponseEntity<List<SessionCours>> getSessionCoursFormateur ( @PathVariable(value = "id") int id)  throws
        Exception {
            System.out.println("Recherche des locations du client d'id " + id);
            Formateur fo = formateurServiceImpl.read(id);
            List<SessionCours> lsc = sessionCoursServiceImpl.getSessionCours(fo);
            return new ResponseEntity<>(lsc, HttpStatus.OK);
        }

    //-------------------Créer une session de cours-------------------------------------------------------
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SessionCours> createLocation(@RequestBody SessionCours session) throws Exception {
        System.out.println("Création de la session de cours  du formateur" + session.getFormateur());
        sessionCoursServiceImpl.create(session);
        return new ResponseEntity<>(session, HttpStatus.OK);
    }

    //-------------------Mettre à jour d'une session de cours d'un num donné--------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SessionCours> majFormateur(@PathVariable(value = "id") int id,@RequestBody SessionCours nouvsessioncours) throws Exception{
        System.out.println("Maj de la session de cours num" + id);
        nouvsessioncours.setId(id);
        SessionCours csess = sessionCoursServiceImpl.update(nouvsessioncours);
        return new ResponseEntity<>(csess, HttpStatus.OK);
    }

    //-------------------Effacer un formateur d'un id donné-------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSessioncours(@PathVariable(value = "id") int id) throws Exception{
        System.out.println("Effacement de la session de cours num" + id);
        SessionCours se = sessionCoursServiceImpl.read(id);
        sessionCoursServiceImpl.delete(se);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Gérer les erreurs--------------------------------------------------------
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void>  handleIOException(Exception ex) {
        System.out.println("Erreur : "+ex.getMessage());
        return ResponseEntity.notFound().header("error",ex.getMessage()).build();
    }


}





