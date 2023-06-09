package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexionBD {
    
    private static Connection conexion = null;

    public static Connection getConexionBD(){
        try{    
            String url = "jdbc:mysql://localhost/banco";
            String user = "banco";
            String password = "bancony";
            conexion = (Connection) DriverManager.getConnection(url, user, password);

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.exit(0);
        }
        return conexion;
    }

}
