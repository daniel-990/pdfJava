package org.example.Data;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;


public class generarTxt {


    public static void crearTxtFinal(){

        Scanner input = new Scanner(System.in);
        
        String nombre;
        String descripcion;
        String categoria;
        int precio;

        System.out.println("por favor ingresa el nombre: ");
        nombre = input.nextLine();

        System.out.println("por favor ingresa la descripcion: ");
        descripcion = input.nextLine();

        System.out.println("por favor ingresa la categoria: ");
        categoria = input.nextLine();

        System.out.println("por favor ingresa el precio: ");
        precio = input.nextInt();

        try {
            String ruta = "_txt/final_factura_"+nombre+".txt";
            String contenido = "Factura articulo: "+nombre+"\n" +
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
                    "nombre: "+nombre+"\n" +
                    "-------------------------------\n" +
                    "descripcion: "+descripcion+"\n" +
                    "-------------------------------\n" +
                    "categoria: "+categoria+"\n" +
                    "-------------------------------\n" +
                    "precio: "+precio+"\n" +
                    "-------------------------------\n";

            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }else{
                System.out.println("el archivo existe!!");
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
