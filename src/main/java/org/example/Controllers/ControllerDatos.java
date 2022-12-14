package org.example.Controllers;

//dependencias

import org.example.Conector.Conector;
import org.example.Models.Producto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControllerDatos {

    public static Producto producto = new Producto();
    public static Conector conectar = new Conector();
    public static String sql;
    public static PreparedStatement ps;
    public static Connection con = conectar.getConexion();
    public void insertar(String nombre, String descripcion, double precio, String categoria){

        producto.setNombreProducto(nombre);
        producto.setDescripcionProducto(descripcion);
        producto.setPrecioProducto(precio);
        producto.setCategoriaProducto(categoria);

        try{

            sql = "INSERT INTO producto (nombre, descripcion, precio, categoria) VALUES ('"+producto.getNombreProducto()+"','"+producto.getDescripcionProducto()+"','"+producto.getPrecioProducto()+"','"+producto.getCategoriaProducto()+"')";
            ps = con.prepareStatement(sql);

            ps.executeUpdate();
            //System.out.println("se cargan datos");
            JOptionPane.showMessageDialog(null, "Se cargan datos",
                    "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception e){
            //System.out.println("Error al guardar datos: "+e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al guardar datos: "+e.getMessage(),
                    "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
