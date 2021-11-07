package be.condorcet.monprojet2.services;

import be.condorcet.monprojet2.entities.Formateur;

import java.util.List;

public interface InterfFormateurService extends InterfService<Formateur>{

public Formateur read(String nom, String prenom, String mail);

}
