package org.example.Controllers;

//dependencias

import org.example.Conector.Conector;
import org.example.Models.Producto;

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

            /*
                System.out.println("nombre: "+producto.getNombreProducto());
                System.out.println("precio: "+producto.getPrecioProducto());
                System.out.println("descripcion: "+producto.getDescripcionProducto());
                System.out.println("categoria: "+producto.getCategoriaProducto());
            */

            ps.executeUpdate();
            System.out.println("se cargan datos");

            //obtener datos
            try{

                Connection con = conectar.getConexion();
                sql = "SELECT * FROM producto";
                ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);
                System.out.println("datos guardados");
                while(rs.next()){
                    System.out.println("*******************************");
                    System.out.println("id: "+rs.getInt("id"));
                    System.out.println("nombre: "+rs.getString("nombre"));
                    System.out.println("precio: "+rs.getInt("precio"));
                }

            }catch (Exception e){
                System.out.println("Error al obtener datos: "+e.getMessage());
            }

        }catch (Exception e){
            System.out.println("Error al guardar datos: "+e.getMessage());
        }
    }

}
