package Programacion.Tema5.AgendaTelefonica;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String nombre;
        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        agenda.addContacto(new Contacto("Juan", "123456789"));
        agenda.addContacto(new Contacto("Alicia", "987654321"));
        agenda.addContacto(new Contacto("Andressa", "765432109"));

        System.out.println("""
                AGENDA TELEFÓNICA
                -----------------
                1. Añadir nuevo contacto
                2. Listar contactos
                3. Buscar contacto
                4. Eliminar contacto
                5. Estado de la agenda
                0. Salir
                Elige una opción:
                """
        );
        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1:
                System.out.println("Nombre del nuevo contacto");
                nombre = sc.nextLine();
                System.out.println("Número de teléfono de " + nombre);
                String numero = sc.nextLine();
                agenda.addContacto(new Contacto(nombre, numero));
                break;

            case 2:
                agenda.listarContactos();
                break;

            case 3:
                System.out.println("Nombre del contacto a buscar");
                nombre = sc.nextLine();
                Contacto contacto = agenda.buscarContacto(nombre);
                System.out.println(contacto.toString());
                break;
            case 4:
                System.out.println("Nombre del contacto a eliminar");
            case 0:
                System.out.println("Muchas gracias por usar mi agenda");

        }
    }
}
