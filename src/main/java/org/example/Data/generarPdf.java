package org.example.Data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.html2pdf.HtmlConverter;

import org.example.Models.Producto;
public class generarPdf {

    public static void Pdf() throws IOException {

        Producto producto = new Producto();

        String HTML = "<h1>Ficha de producto final</h1>"
                + "<p>Nombre: "+producto.getNombreProducto()+"</p>"
                + "<p>Precio: "+producto.getNombreProducto()+"</p>"
                + "<p>Nombre: "+producto.getNombreProducto()+"</p>"
                + "<p>Nombre: "+producto.getNombreProducto()+"</p>";

        String HTMl = "<table>\n" +
                "  <tr>\n" +
                "    <th>Nombre</th>\n" +
                "    <th>Precio</th>\n" +
                "    <th>Country</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Alfreds Futterkiste</td>\n" +
                "    <td>Maria Anders</td>\n" +
                "    <td>Germany</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Centro comercial Moctezuma</td>\n" +
                "    <td>Francisco Chang</td>\n" +
                "    <td>Mexico</td>\n" +
                "  </tr>\n" +
                "</table>";


        HtmlConverter.convertToPdf(HTML, new FileOutputStream("final.pdf"));

        System.out.println( "El PDF se creo con exito" );

    }

}
