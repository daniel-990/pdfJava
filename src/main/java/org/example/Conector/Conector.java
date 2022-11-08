package org.example.Conector;
import org.example.Models.ModelConector;

//dependencias
import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {

    public static final ModelConector datosConeccionMysql = new ModelConector();

    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(datosConeccionMysql.getURL(), datosConeccionMysql.getUSER(), datosConeccionMysql.getPASS());
            //System.out.println("se conecto a la base de datos");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

}
