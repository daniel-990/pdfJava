package org.example.Ui;

import org.example.Data.datosPro;
import org.example.Data.generarPdf;
import org.example.Data.generarTxt;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static int respuesta = 0;
    public static Scanner input = new Scanner(System.in);

    public static void mostrarMenu() throws IOException {

        do {
            /*
                System.out.println("Generador de ficha en PDF y TXT para productos");
                System.out.println("***************************");
                System.out.println("1. Ingresar datos del producto");
                System.out.println("2. Generar documento Pdf");
                System.out.println("3. Generar documento Txt");
                System.out.println("0. Salir");
                System.out.println("***************************");
            */

            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Generador de ficha en PDF y TXT para productos \n" +
                    "******************************* \n" +
                    "1. Ingresar datos del producto \n"  +
                    "2. Generar documento Pdf \n" +
                    "3. Generar documento Txt \n" +
                    "0. Salir \n" +
                    "*******************************"));

            //respuesta = input.nextInt();

            switch (respuesta){
                case 1:
                    datosPro.crearProducto();
                    break;
                case 2:
                    generarPdf.Pdf();
                    break;
                case 3:
                    generarTxt.crearTxtFinal();
                    break;
            }
        }while(respuesta != 0);
        //System.out.println("salio del programa");
        JOptionPane.showMessageDialog(null, "Salio del programa",
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }
}
