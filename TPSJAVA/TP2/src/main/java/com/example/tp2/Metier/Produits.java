package com.example.tp2.Metier;

public class Produits {
    public int id_prod;
    public String name;
    public double prix;
    public int quantite;

    public Produits(){
        super();
    }

    public Produits(int id_prod, String name, double prix, int quantite) {
        this.id_prod = id_prod;
        this.name = name;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
