package be.condorcet.projetarnaudlecuyer2.services;

import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
import be.condorcet.projetarnaudlecuyer2.entities.SessionCours;

import java.util.Date;
import java.util.List;

public interface InterfSessioncoursService extends InterfService<SessionCours>{

    public SessionCours readDDDFI(Date datedebut, Date datefin, int nbrinscrits);
    public SessionCours read (int id);
    public List<SessionCours> getSessionCours(Formateur fo);
    public List<SessionCours> read_nbrInscrits (int nbreinscrits);
}
