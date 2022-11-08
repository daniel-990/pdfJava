package org.example.Data;

import org.example.Models.Producto;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;

public class datosPro {

        public static void crearProducto(){

                Scanner input = new Scanner(System.in);

                String nombreProducto;
                double precioProducto;
                String descripcionProducto;
                String categoriaProducto;

                System.out.println("porfavor ingrese los datos del producto:");
                System.out.println("*******************");
                System.out.println("nombre:");
                nombreProducto = input.nextLine();
                System.out.println("precio:");
                precioProducto = input.nextDouble();
                System.out.println("descripcion:");
                descripcionProducto = input.nextLine();
                System.out.println("categorias:");
                categoriaProducto = input.nextLine();

                Producto producto = new Producto();
                producto.setNombreProducto(nombreProducto);
                producto.setPrecioProducto(precioProducto);
                producto.setDescripcionProducto(descripcionProducto);
                producto.setCategoriaProducto(categoriaProducto);

        }

}
