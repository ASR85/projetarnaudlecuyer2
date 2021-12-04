package be.condorcet.projetarnaudlecuyer2.services;

import be.condorcet.projetarnaudlecuyer2.entities.Formateur;
import be.condorcet.projetarnaudlecuyer2.entities.SessionCours;

import java.sql.Date;
import java.util.List;

public interface InterfSessioncoursService extends InterfService<SessionCours>{

    public SessionCours read (int id);
    public List<SessionCours> getSessionCours(Formateur fo);
}
