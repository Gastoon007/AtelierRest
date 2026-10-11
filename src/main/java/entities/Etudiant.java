package entities;

import java.util.Objects;

public class Etudiant {
    private String identifiant,nom,prenom,email;
    private int anneeEtude;
    private Option option;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return anneeEtude == etudiant.anneeEtude && Objects.equals(identifiant, etudiant.identifiant) && Objects.equals(nom, etudiant.nom) && Objects.equals(prenom, etudiant.prenom) && Objects.equals(email, etudiant.email) && Objects.equals(option, etudiant.option);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant, nom, prenom, email, anneeEtude, option);
    }

    public Etudiant() {
    }

    public Etudiant(String identifiant, String nom, String prenom, String email, int anneeEtude, Option option) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.anneeEtude = anneeEtude;
        this.option = option;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnneeEtude() {
        return anneeEtude;
    }

    public void setAnneeEtude(int anneeEtude) {
        this.anneeEtude = anneeEtude;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
