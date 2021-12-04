package be.condorcet.projetarnaudlecuyer2.webservices;

import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
import be.condorcet.projetarnaudlecuyer2.services.FormateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")


@RestController
@RequestMapping("/formateurs")

public class RestFormateur {
    @Autowired
    private FormateurServiceImpl formateurServiceImpl;


    //-------------------Retrouver le formateur correspondant à un id donné--------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Formateur> getFormateur(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("recherche du client d' id " + id);
        Formateur formateur = formateurServiceImpl.read(id);
        return new ResponseEntity<>(formateur, HttpStatus.OK);
    }

    //-------------------Retrouver les formateurs portant un nom donné---------------------------------------------------
    @RequestMapping(value = "/nom={nom}", method = RequestMethod.GET)
    public ResponseEntity<List<Formateur>> listFormateursNom(@PathVariable(value = "nom") String nom) throws Exception {
        System.out.println("recherche de " + nom);
        List<Formateur> formateurs;
        formateurs = formateurServiceImpl.read(nom);
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }

    //-------------------Retrouver le client correspondant à un mail donné------------------------------
    @RequestMapping(value = "/mail={mail}", method = RequestMethod.GET)
    public ResponseEntity<List<Formateur>> getMailUnique(@PathVariable(value = "mail") String mail) throws Exception {
        System.out.println("Recherche du mail " + mail);
        List<Formateur> formateurs = formateurServiceImpl.read_mail(mail);
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }

    //-------------------Créer un formateur--------------------------------------------------------
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Formateur>createFormateur(@RequestBody Formateur formateur) throws Exception {
        System.out.println("Création de formateur " + formateur.getNom());
        formateurServiceImpl.create(formateur);
        return new ResponseEntity<>(formateur, HttpStatus.OK);
    }

    //-------------------Mettre à jour un formateur d'un id donné-----------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Formateur> majFormateur(@PathVariable(value = "id") int id, @RequestBody Formateur nouvformateur) throws Exception {
        System.out.println("Maj de formateur id =  " + id);
        nouvformateur.setId(id);
        Formateur foact = formateurServiceImpl.update(nouvformateur);
        return new ResponseEntity<>(foact, HttpStatus.OK);
    }


    //-------------------Effacer un formateur d'un id donné--------------------------------------------------------
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFormateur(@PathVariable(value = "id") int id) throws Exception {
        System.out.println("Effacement du formateur d'id " + id);
        Formateur formateur = formateurServiceImpl.read(id);
        formateurServiceImpl.delete(formateur);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Gestion des erreurs--------------------------------------------------------
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void> handleIOException(Exception ex) {
        System.out.println("Erreur : " + ex.getMessage());
        return ResponseEntity.notFound().header("error", ex.getMessage()).build();
    }


}
