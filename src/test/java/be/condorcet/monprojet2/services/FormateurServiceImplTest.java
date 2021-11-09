package be.condorcet.monprojet2.services;

import be.condorcet.monprojet2.entities.Formateur;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class FormateurServiceImplTest {


    @Autowired
    private FormateurServiceImpl formateurServiceImpl;

    Formateur fo;

    @BeforeEach
    void setUp() {
        try{
            fo = new Formateur(1,"arnaud.lecuyer@ondorcet.be", "NomTest","PrenomTest",null, null);
            formateurServiceImpl.create(fo);
            System.out.println("Création du formateur: "+fo);
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
        assertNotEquals(0,fo.getId(),"id formateur non incrémenté");
    }

    @Test
    void read() {

        try{
            int numfo=fo.getId();
            Formateur fo2=formateurServiceImpl.read(numfo);
            assertEquals(",NomTest",fo2.getNom(),"noms différents "+"NomTest"+"-"+fo2.getNom());
            assertEquals("PrenomTest",fo2.getPrenom(),"prénoms différents"+"NomTest"+"-"+fo2.getNom());
            //etc
        }
        catch (Exception e){
            fail("Recherche Infructueuse "+e);
        }
    }

    @Test
    void testRead() {
    }

    @Test
    void update() {

        try{
            fo.setNom("Lecuyer");
            fo.setPrenom("Arnaud");
            //etc
            fo = formateurServiceImpl.update(fo);
            assertEquals("NomTest2",fo.getNom(),"noms différents"+"NomTest2-"+fo.getNom());
            assertEquals("PrenomTest2",fo.getPrenom(),"prénoms différents "+"PrenomTest2-"+fo.getPrenom());
            //etc
        }
        catch(Exception e){
            fail("Erreur de mise à jour "+e);
        }

    }

    @Test
    void delete() {

        try{
            formateurServiceImpl.delete(fo);
            Assertions.assertThrows(Exception.class, () -> {
                formateurServiceImpl.read(fo.getId());
            },"record non effacé");
        }
        catch(Exception e){
            fail("Erreur d'effacement "+e);
        }
    }
}