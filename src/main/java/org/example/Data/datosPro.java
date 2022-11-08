package org.example.Data;

import org.example.Models.Producto;
import java.util.Scanner;
import org.example.Controllers.ControllerDatos;

public class datosPro {

        public static void crearProducto(){

                Scanner input = new Scanner(System.in);

                String nombre;
                String descripcion;
                double precio;
                String categorias;

                System.out.println("Ingrese los datos del producto");

                System.out.println("nombre:");
                nombre = input.nextLine();

                System.out.println("descripcion:");
                descripcion = input.nextLine();

                System.out.println("categorias");
                categorias = input.nextLine();

                System.out.println("precio");
                precio = input.nextDouble();

                //ingresar datos productos
                ControllerDatos enviar = new ControllerDatos();
                enviar.insertar(nombre,descripcion,precio,categorias);

        }

}
