package be.condorcet.projetarnaudlecuyer2.services;

import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
import be.condorcet.projetarnaudlecuyer2.entities.SessionCours;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SessionCoursServiceImplTest {

    private Formateur fo;
    private SessionCours sc;

    @Autowired
    private FormateurServiceImpl formateurServiceImpl;

    @Autowired
    private SessionCoursServiceImpl sessionCoursServiceImpl;


    @BeforeEach
    void setUp() {
        try{
            fo = new Formateur(null, "nomtest2.prenomtest2@gmail.be", "Walem","Hugo",null);
            formateurServiceImpl.create(fo);
            System.out.println("Création du formateur: "+fo);
            sc = new SessionCours(null, Date.valueOf(LocalDate.now()), Date.valueOf("2020-07-20"), 20, null);
            sessionCoursServiceImpl.create(sc);
            System.out.println("Création de la session de cours! : "+fo);
        }
        catch (Exception e){
            System.out.println("Erreur de la création de la session de cours! "+e);
        }
    }

    @AfterEach
    void tearDown() {
        try{
            sessionCoursServiceImpl.delete(sc);
        }
        catch(Exception e){
            System.out.println("Erreur d''effacement d'une session de cours "+e);
        }
        try{
            formateurServiceImpl.delete(fo);
        }
        catch(Exception e){
            System.out.println("Erreur d'effacement d'un formateur "+e);
        }
    }

    @Test
    void create() {
        assertNotEquals(0,sc.getId(),"Numéro de seesion de cours non incrémenté!");
    }

    @Test
    void read() {/*
        try{
            int numsc.getId();
            SessionCours sc2=sessionCoursServiceImpl.read(numsc);
            assertEquals(sc2.getMontant(),new
                    BigDecimal(1000).setScale(2, RoundingMode.HALF_UP),"montants différents "+co2.getMontant()+"-"+new BigDecimal(1000));
            //etc
        }
        catch (Exception e){
            fail("recherche infructueuse "+e);
        }*/
    }
/*
    @Test
    void testRead() {
    }*/

    @Test
    void update() {/*
        cf.setMontant(new BigDecimal(50.25).setScale(2,
                RoundingMode.HALF_UP));
        //etc
        try{
            cf= comfactServiceImpl.update(cf);
            assertEquals(cf.getMontant(),new BigDecimal(50.25).setScale(2,
                    RoundingMode.HALF_UP),"montants différents "+cf.getMontant()+"-"+new
                    BigDecimal(50.25));
            //etc
        }
        catch(Exception e){
            fail("erreur de mise à jour "+e);
        }*/
    }

    @Test
    void delete() {
        try{
            sessionCoursServiceImpl.delete(sc);
            Assertions.assertThrows(Exception.class, () -> {
                sessionCoursServiceImpl.read(sc.getId());
            },"record non effacé");
        }
        catch(Exception e){
            fail("erreur d'effacement "+e);
        }
    }
    @Test
    void affSessionCours(){
        try {
            Collection<SessionCours> csc = sessionCoursServiceImpl.getSessionCours(fo);
            boolean trouve = false;
            for(SessionCours c:csc){
                if(c.getId()==sc.getId()){
                    trouve=true;
                    break;
                }
            }
            assertTrue(trouve,"Session de cours absente de la liste des formateurs");
        }
        catch(Exception e){
            fail("Erreur de recherche "+e);
        }
    }
}