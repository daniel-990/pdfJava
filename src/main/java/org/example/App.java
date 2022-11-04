package org.example;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import com.itextpdf.html2pdf.HtmlConverter;

/**
 *
 * Esto es una prueba para exportar un PDF
 * Daniel Arango Villegas
 * obtener un Pdf de un Html
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        Scanner input = new Scanner(System.in);


        String HTML = "<h1>Nombre del documento</h1>"
                    + "<p>loren ipsum</p>"
                    + "<a href='hmkcode.com'>hmkcode.com</a>";


        HtmlConverter.convertToPdf(HTML, new FileOutputStream("este-es-un-documento.pdf"));

        System.out.println( "PDF Created!" );
    }
}
