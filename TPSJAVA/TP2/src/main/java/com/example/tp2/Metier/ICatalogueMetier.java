package com.example.tp2.Metier;

import java.util.List;

public interface ICatalogueMetier {
    public List<Produits> AllProduits();
    public List<Produits> produitsMC(String mc);
    public void addProduits(Produits p);
}
