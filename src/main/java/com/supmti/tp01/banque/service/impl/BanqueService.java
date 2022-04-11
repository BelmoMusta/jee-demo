package com.supmti.tp01.banque.service.impl;

import com.supmti.tp01.banque.entity.Personne;
import com.supmti.tp01.banque.service.api.BanqueServiceInterface;

import javax.inject.Inject;

public class BanqueService implements BanqueServiceInterface {
    @Inject
    Personne p;

    public void creerCompte(Personne personne) {
        System.out.println(p);
    }
}
