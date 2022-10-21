package modele;


import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
import be.condorcet.projetarnaudlecuyer2.repositories.FormateurRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;
@Controller
@RequestMapping("/formateurs")
public class GestFormateurs {

    @Autowired
    private FormateurRepository formateurRepository;
    @RequestMapping("/tous")
    public String affTous(Map<String, Object> model){
        System.out.println("recherche formateur");
        try {
            Collection<Formateur> lfo= formateurRepository.findAll();
            model.put("mesFormateurs", lfo);
        } catch (Exception e) {
            System.out.println("----------erreur lors de la recherche--------- " + e);
                    model.put("error",e.getMessage());
            return "error";
        }
        return "affichagetousFormateurs";
    }
    @RequestMapping("/create")
    public String create(@RequestParam String mail, @RequestParam String nom, @RequestParam String prenom, Map<String, Object> model){
        System.out.println("création de formateur");
        Formateur fo = new Formateur(mail, nom, prenom);
        try {
            formateurRepository.save(fo);//mise à jour du formateur avec son id par l'environnement
            System.out.println(fo);
            Collection<Formateur> lfo= formateurRepository.findAll();
            model.put("nouvfo",fo);
            model.put("mesFormateurs", lfo);
        } catch (Exception e) {
            System.out.println("----------erreur lors de la création-------- " + e);
                    model.put("error",e.getMessage());
            return "error";
        }
        return "nouveauFormateur";
    }

}
