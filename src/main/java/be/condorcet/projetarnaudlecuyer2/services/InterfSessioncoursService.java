package be.condorcet.projetarnaudlecuyer2.services;

import be.condorcet.projetarnaudlecuyer2.entities.SessionCours;

import java.sql.Date;

public interface InterfSessioncoursService extends InterfService<SessionCours>{

    public SessionCours read (int nbreinscrits);
}
