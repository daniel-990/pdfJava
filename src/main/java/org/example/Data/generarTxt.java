package org.example.Data;
import org.example.Conector.Conector;
import org.example.Models.Producto;

import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static org.example.Controllers.ControllerDatos.con;


public class generarTxt {

    public static Conector conectar = new Conector();
    public static Producto producto = new Producto();

    public static Scanner input = new Scanner(System.in);
    public static String sql;
    public static PreparedStatement ps;
    public static String HTMlRender;

    public static void crearTxtFinal(){

        try {

            sql = "SELECT * FROM producto";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            System.out.println("se obtienen datos de la DB: ");

            while(rs.next()){

                String ruta = "_txt/final_factura_"+rs.getInt("id")+".txt";
                String contenido = "Factura articulo: "+rs.getString("nombre")+"\n" +
                        "-------Factura-----" +
                        "\n" +
                        "             _.-````'-,_\n" +
                        "   _,.,_ ,-'`           `'-.,_\n" +
                        " /)     (\\                   '``-.\n" +
                        "((      ) )                      `\\\n" +
                        " \\)    (_/                        )\\\n" +
                        "  |       /)           '    ,'    / \\\n" +
                        "  `\\    ^'            '     (    /  ))\n" +
                        "    |      _/\\ ,     /    ,,`\\   (  \"`\n" +
                        "     \\Y,   |  \\  \\  | ````| / \\_ \\\n" +
                        "       `)_/    \\  \\  )    ( >  ( >\n" +
                        "                \\( \\(     |/   |/\n" +
                        "    Factura - Bison  /_(/_(    /_(  /_(\n" +
                        "\n" +
                        "------------------------------------------------\n" +
                        "* Daniel Arango Villegas *\n" +
                        "* Sistema de notificacion y factura *\n" +
                        "* https://github.com/daniel-990 *\n" +
                        "--\n" +
                        "Nombre: "+rs.getString("nombre")+"\n" +
                        "-------------------------------\n" +
                        "Descripcion: "+rs.getString("descripcion")+"\n" +
                        "-------------------------------\n" +
                        "Categoria: "+rs.getString("categoria")+"\n" +
                        "-------------------------------\n" +
                        "Precio: "+rs.getInt("precio")+"\n" +
                        "-------------------------------\n";

                File file = new File(ruta);
                // Si el archivo no existe es creado
                if (file.exists()) {
                    //System.out.println("esto existe");
                    file.createNewFile();
                    System.out.println("El TXT [" + rs.getInt("id") + "] se creo con exito");
                }

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
