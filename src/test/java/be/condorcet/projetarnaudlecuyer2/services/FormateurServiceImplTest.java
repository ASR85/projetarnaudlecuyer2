package be.condorcet.projetarnaudlecuyer2.services;

import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
import be.condorcet.projetarnaudlecuyer2.entities.SessionCours;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FormateurServiceImplTest {

    @Autowired
    private InterfFormateurService formateurServiceImpl;

    @Autowired
    private InterfSessioncoursService sessionCoursServiceImpl;

    Formateur fo;

    @BeforeEach
    void setUp() {

        try{
            fo = new Formateur(null, "nomtest.prenomtest@gmail.be", "NomTest","PrenomTest",null);
            formateurServiceImpl.create(fo);
            System.out.println("Création du formateur: "+fo+" effectuée avec succès!");
        }
        catch (Exception e){
            System.out.println("Erreur de création du formateur: "+fo+" erreur : "+e);
        }
    }

    @AfterEach
    void tearDown() {

        try {
            formateurServiceImpl.delete(fo);
            System.out.println("Effacement du formateur: "+fo);
        }
        catch (Exception e){
            System.out.println("Erreur d'effacement du formateur :"+fo+" erreur : "+e);
        }
    }

    @Test
    void create() {
       assertNotEquals(0,fo.getId(),"id formateur non incrémenté!");
    }

    @Test
    void creationDoublon(){
        Formateur fo2 = new Formateur(null, "nomtest.prenomtest@gmail.be", "NomTest","PrenomTest",null);
        Assertions.assertThrows(Exception.class, () -> {
            formateurServiceImpl.create(fo2);
        },"Création d'un doublon");
    }
    @Test
    void read() {

        try{
            int numfo=fo.getId();
            Formateur fo2=formateurServiceImpl.read(numfo);
            assertEquals("NomTest",fo2.getNom(),"noms différents "+"NomTest"+"-"+fo2.getNom());
            assertEquals("PrenomTest",fo2.getPrenom(),"prénoms différents"+"NomTest"+"-"+fo2.getPrenom());
        }
        catch (Exception e){
            fail("Recherche Infructueuse "+e);
        }
    }

    @Test
    void update() {

        try{
            fo.setNom("NomTest2");
            fo.setPrenom("PrenomTest2");
            //etc
            fo = formateurServiceImpl.update(fo);
            assertEquals("NomTest2",fo.getNom(),"noms différents"+"NomTest2-"+fo.getNom());
            assertEquals("PrenomTest2",fo.getPrenom(),"prénoms différents "+"PrenomTest2-"+fo.getPrenom());
            //etc
        }
        catch(Exception e){
            fail("Erreur de mise à jour!"+e);
        }

    }

    @Test
    void delete() {

        try{
            formateurServiceImpl.delete(fo);
            Assertions.assertThrows(Exception.class, () -> {
                formateurServiceImpl.read(fo.getId());
            },"Enregistrement non effacé!");
        }
        catch(Exception e){
            fail("Erreur d'effacement "+e);
        }
    }

    @Test
    void delAvecSessionCours(){
        try{
            SessionCours sc = new SessionCours(null, Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()),50,fo);
            sessionCoursServiceImpl.create(sc);
            sessionCoursServiceImpl.delete(sc);
            formateurServiceImpl.delete(fo);
        }catch (Exception e){
            fail("Effacement réalisé malgrès la session de cours liée... " + e);

        }
    }

    @Test
    void rechNom() {
        List<Formateur> lf = formateurServiceImpl.read("NomTest");
        boolean trouve=false;
        for(Formateur f : lf){
            if(f.getNom().equals("NomTest")) trouve=true;
            else fail("Un record ne correspond pas , nom = "+f.getNom());
        }
        assertTrue(trouve,"Record non trouvé dans la liste");
    }

    @Test
    void rechPrenom() {
        List<Formateur> lf = formateurServiceImpl.read_prenom("PrenomTest");
        boolean trouve=false;
        for(Formateur f : lf){
            if(f.getPrenom().equals("PrenomTest")) trouve=true;
            else fail("Un record ne correspond pas , Prenom = "+f.getPrenom());
        }
        assertTrue(trouve,"Record non trouvé dans la liste");
    }

    @Test
    void rechMail(){
        List<Formateur> lf = formateurServiceImpl.read_mail("nomtest.prenomtest@gmail.be");
        boolean trouve=false;
        for(Formateur f : lf){
            if(f.getMail().equals("nomtest.prenomtest@gmail.be")) trouve=true;
            else fail("Un record ne correspond pas , Mail = "+f.getMail());
        }
        assertTrue(trouve,"Record non trouvé dans la liste");
    }


}
