package be.condorcet.monprojet2.services;

import be.condorcet.monprojet2.entities.SessionCours;

import java.sql.Date;

public interface InterfSessioncoursService extends InterfService<SessionCours>{

    public SessionCours read (Date dateDebut, Date dateFin, int nbreinscrits);
}
