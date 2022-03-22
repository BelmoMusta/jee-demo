package com.supmti.tp01.banque.entity;

public class PersonneAvecDateNaissance {
    private Personne personne;
    private String dateNaissance;

    public PersonneAvecDateNaissance(Personne personne, String dateNaissance) {
        this.personne = personne;
        this.dateNaissance = dateNaissance;
    }
}
