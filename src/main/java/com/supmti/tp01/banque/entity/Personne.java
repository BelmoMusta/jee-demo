package com.supmti.tp01.banque.entity;

public class Personne {
    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissance;

    private Personne() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public static class PersonneBuilder {
        final Personne personne;

        public PersonneBuilder() {
            personne = new Personne();
        }

        public PersonneBuilder nom(String nom) {
            this.personne.setNom(nom);
            return this;
        }


        public PersonneBuilder prenom(String prenom) {
            this.personne.setPrenom(prenom);
            return this;
        }

        public Personne build() {
            return this.personne;
        }

        public PersonneBuilder dateNaissance(String dateNaissance) {
            this.personne.setDateNaissance(dateNaissance);
            return this;
        }
    }
}
