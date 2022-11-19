package org.example.Data;

import org.example.Models.Producto;
import java.util.Scanner;
import org.example.Controllers.ControllerDatos;

import javax.swing.*;

public class datosPro {

        public static void crearProducto(){

                Scanner input = new Scanner(System.in);

                String nombre;
                String descripcion;
                double precio;
                String categorias;

                //System.out.println("Ingrese los datos del producto");

                nombre = JOptionPane.showInputDialog("Nomrbe: ");
                descripcion = JOptionPane.showInputDialog("Descripcion: ");
                categorias = JOptionPane.showInputDialog("Categoria: ");
                precio = Integer.parseInt(JOptionPane.showInputDialog("Precio: "));

                //System.out.println("nombre:");
                //nombre = input.nextLine();

                //System.out.println("descripcion:");
                //descripcion = input.nextLine();

                //System.out.println("categorias");
                //categorias = input.nextLine();

                //System.out.println("precio");
                //precio = input.nextDouble();

                //ingresar datos productos
                ControllerDatos enviar = new ControllerDatos();
                enviar.insertar(nombre,descripcion,precio,categorias);

        }

}
