package TP1;

import java.sql.*;

public class App {

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/catalogue_bd","root","");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from PRODUITS");

            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                System.out.print(resultSetMetaData.getColumnName(i)+"\t");
            }
            System.out.println();
            while(rs.next()){
                for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
