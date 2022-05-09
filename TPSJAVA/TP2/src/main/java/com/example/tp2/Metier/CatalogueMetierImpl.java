package com.example.tp2.Metier;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetierImpl implements  ICatalogueMetier {

    @Override
    public List<Produits> AllProduits() {
        List<Produits> products = new ArrayList<>();
        try {
            Connection connect = SingletonConnection.getConnection();
            PreparedStatement p = connect.prepareStatement("select * from PRODUITS");
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
                Produits p1 = new Produits(resultSet.getInt("ID_PROD"),
                        resultSet.getString("Name"),
                        resultSet.getDouble("Prix"),
                        resultSet.getInt("Quantite"));
                products.add(p1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Produits> produitsMC(String mc) {
        List<Produits> products = new ArrayList<>();
        try {
            Connection connect = SingletonConnection.getConnection();
            PreparedStatement p = connect.prepareStatement("select * from PRODUITS where name like ?");
            p.setString(1, "%" + mc + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Produits pr = new Produits();
                pr.setId_prod(r.getInt("ID_PROD"));
                pr.setName(r.getString("Name"));
                pr.setPrix(r.getDouble("Prix"));
                pr.setQuantite(r.getInt("Quantite"));
                products.add(pr);
            }
            p.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void addProduits(Produits prod) {
        try {
            Connection connect = SingletonConnection.getConnection();
            PreparedStatement p = connect.prepareStatement("insert into produits (name, prix, quantite) values (?, ?, ?)");
            p.setString(1, String.valueOf(prod.getName()));
            p.setString(2, String.valueOf(prod.getPrix()));
            p.setString(3, String.valueOf(prod.getQuantite()));
            int nmbr = p.executeUpdate();
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
