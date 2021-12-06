package be.condorcet.projetarnaudlecuyer2.services;

import be.condorcet.projetarnaudlecuyer2.entities.Formateur;

import java.util.List;

public interface InterfFormateurService extends InterfService<Formateur>{

    public List<Formateur> readNPM(String nom, String prenom, String mail);
    public List<Formateur> read(String nom);
    public List<Formateur> read_mail(String mail);
    public List<Formateur> read_prenom(String prenom);

}
