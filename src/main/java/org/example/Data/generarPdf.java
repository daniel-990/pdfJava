package org.example.Data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.html2pdf.HtmlConverter;

import org.example.Models.Producto;
public class generarPdf {

    public static void Pdf() throws IOException {

        Producto producto = new Producto();

        String HTMlRender = "<table>\n" +
                "  <tr>\n" +
                "    <th>Nombre</th>\n" +
                "    <th>Precio</th>\n" +
                "    <th>descripcion</th>\n" +
                "    <th>categoria</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>"+producto.getNombreProducto()+"</td>\n" +
                "    <td>"+producto.getPrecioProducto()+"</td>\n" +
                "    <td>"+producto.getDescripcionProducto()+"</td>\n" +
                "    <td>"+producto.getCategoriaProducto()+"</td>\n" +
                "  </tr>\n" +
                "</table>";


        HtmlConverter.convertToPdf(HTMlRender, new FileOutputStream("final.pdf"));

        System.out.println( "El PDF se creo con exito" );

    }

}
