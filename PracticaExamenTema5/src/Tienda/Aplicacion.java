package Tienda;

import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner sc = new Scanner(System.in);

        ProductoBase ropa1 = new RopaDeportiva("R101", "Sweatpants", 25.0, 100, "L", "Algodón");
        ProductoBase ropa2 = new RopaDeportiva("R102", "Jogging Pants", 30.0, 50, "XL", "Cotton");
        ProductoBase ropa3 = new RopaDeportiva("R103", "Running Shirt", 15.0, 150, "M", "Poliester");
        ProductoBase equipo1 = new Equipamiento("E101", "Golf Club", 200.0, 20, "UltraGolf", "Golf");
        ProductoBase equipo2 = new Equipamiento("E102", "Tennis Racquet", 150.0, 30, "nike", "Tennis");
        ProductoBase equipo3 = new Equipamiento("E103", "Basketball Shoes", 100.0, 40, "Adidas", "basketball");

        tienda.addProducto(ropa1);
        tienda.addProducto(ropa2);
        tienda.addProducto(ropa3);
        tienda.addProducto(equipo1);
        tienda.addProducto(equipo2);
        tienda.addProducto(equipo3);

        System.out.println("Bienvenido a la Tienda!");
        int opcion = 0;
        while (opcion!= 7) {
            System.out.println(
                    """
                    ///////////////////////////////////////
                    //  1. Mostrar inventario.          //
                    //  2. Agregar producto.            //
                    //  3. Eliminar producto.           //                     1
                    //  4. Actualizar producto.         //
                    //  5. Realizar compra.             //
                    //  6. Mostrar historial de compras.//
                    //  7. Salir.                       //
                    /////////////////////////////////////
                    """
            );

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Inventario:");
                        Tienda.mostrarInventario();
                        break;
                    case 2:
                        System.out.println("Ingrese código del producto:");
                        String codigo = sc.nextLine();
                        System.out.println("Ingrese nombre del producto:");
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese precio del producto:");
                        double precio = Double.parseDouble(sc.nextLine());
                        System.out.println("Ingrese stock del producto:");
                        int stock = Integer.parseInt(sc.nextLine());
                        System.out.println("1. Ropa Deportiva" + "2. Equipación");
                        int tipoProducto = Integer.parseInt(sc.nextLine());
                        switch (tipoProducto) {
                            case 1:
                                System.out.println("Ingrese talla:");
                                String talla = sc.nextLine();
                                System.out.println("Ingrese material:");
                                String material = sc.nextLine();
                                RopaDeportiva nuevaRopa = new RopaDeportiva(codigo, nombre, precio, stock, talla, material);
                                tienda.addProducto(nuevaRopa);
                                break;
                            case 2:
                                System.out.println("Ingrese marca del equipamiento:");
                                String marca = sc.nextLine();
                                System.out.println("Ingrese el deporte del equipamiento:");
                                String deporte = sc.nextLine();
                                Equipamiento nuevoEquipo = new Equipamiento(codigo, nombre, precio, stock, marca, deporte);
                                tienda.addProducto(nuevoEquipo);
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                    case 3:
                        System.out.println("Ingrese código del producto a eliminar:");
                        String codigoDel = sc.nextLine();
                        tienda.eliminarProducto(codigoDel);
                        break;
                    case 4:
                        System.out.println("Actualizar producto");
                        System.out.println("Codigo del producto a modificar");
                        String codigoAModificar = sc.nextLine();

                        break;
                    case 5:
                        System.out.println("Realizar compra:");
                        break;
                    case 6:
                        System.out.println("Mostrar historial de compras:");
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción incorrecta, prueba de nuevo");
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Has introducido un valor incorrecto, prueba de nuevo, solo números!");
            }
        }
        System.out.println("Gracias por usar mi intento de Aplicacion xd");

    }
}
