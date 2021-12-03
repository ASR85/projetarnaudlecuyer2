package be.condorcet.projetarnaudlecuyer2.services;

import be.condorcet.projetarnaudlecuyer2.entities.Formateur;

import java.util.List;

public interface InterfFormateurService extends InterfService<Formateur>{

    public List<Formateur> read(String nom);
    public Formateur read(String nom, String prenom, String mail);
    public List<Formateur> read_mail(String mail);
}
