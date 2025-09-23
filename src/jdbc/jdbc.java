package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jdbc {
    public static void main(String[] args) {
        try {
            //Carregar o drive
            
            
            Class.forName("com.mysql.jdbc.Driver");
                      
            
            //Conexão própriamente dita
            
            
            String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = "";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            System.out.println("conectou");
            
            System.out.println("Executou");

               
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
