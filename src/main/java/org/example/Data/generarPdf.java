package org.example.Data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.html2pdf.HtmlConverter;

import org.example.Models.Producto;
import org.example.Conector.Conector;

import javax.swing.text.html.HTMLEditorKit;

public class generarPdf {

    public static Conector conectar = new Conector();
    public static Producto producto = new Producto();
    public static String sql;
    public static PreparedStatement ps;
    public static String HTMlRender;

    public static Connection con = conectar.getConexion();
    public static void Pdf() throws IOException {

        //obtener datos par generar el pdf
        try{
            sql = "SELECT * FROM producto";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            System.out.println("se obtienen datos de la DB: ");

            while(rs.next()){

                System.out.println("*******************************");
                System.out.println("id: "+rs.getInt("id"));
                System.out.println("nombre: "+rs.getString("nombre"));

                HTMlRender = "<table>\n" +
                        "  <tr>\n" +
                        "    <th>Nombre</th>\n" +
                        "    <th>Precio</th>\n" +
                        "    <th>descripcion</th>\n" +
                        "    <th>categoria</th>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>"+rs.getString("nombre")+"</td>\n" +
                        "    <td>"+rs.getInt("precio")+"</td>\n" +
                        "    <td>"+rs.getString("descripcion")+"</td>\n" +
                        "    <td>"+rs.getString("categoria")+"</td>\n" +
                        "  </tr>\n" +
                        "</table>";

                HtmlConverter.convertToPdf(HTMlRender, new FileOutputStream("_pdf/producto_"+rs.getInt("id")+".pdf"));
                System.out.println( "El PDF ["+rs.getInt("id")+"] se creo con exito" );

            }
            //se obtiene un dato - el ultimo
            //HtmlConverter.convertToPdf(HTMlRender, new FileOutputStream("final.pdf"));
            //System.out.println( "El PDF se creo con exito" );

        }catch (Exception e){
            System.out.println("Error al obtener datos: "+e.getMessage());
        }

    }

}
