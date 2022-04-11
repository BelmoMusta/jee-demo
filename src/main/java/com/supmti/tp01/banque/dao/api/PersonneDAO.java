package com.supmti.tp01.banque.dao.api;

import com.supmti.tp01.banque.entity.Personne;

public interface PersonneDAO {
    void creerPersonne(Personne p);

    void supprimerParId(Long id);
}
