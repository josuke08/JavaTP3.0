package com.example.tp2.Metier;

import java.sql.Connection;

public class SingletonConnection {
    private static Connection connection;
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/catalogue_bd","root", "");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
