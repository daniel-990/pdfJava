package org.example.Ui;

import org.example.Data.datosPro;
import org.example.Data.generarPdf;

import java.io.IOException;

public class Menu {

    public static int respuesta = 0;

    public static void mostrarMenu() throws IOException {

        System.out.println("Generador de ficha en PDF para productos");
        System.out.println("***************************");
        System.out.println("1. Ingresar datos del producto");
        System.out.println("2. Generar factura pdf");
        System.out.println("0. Salir");
        System.out.println("***************************");

        do {
            switch (respuesta){
                case 1:
                    datosPro.crearProducto();
                    break;
                case 2:
                    generarPdf.Pdf();
                    break;
            }
        }while(respuesta != 0);
    }
}
