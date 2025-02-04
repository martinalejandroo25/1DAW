package Programacion.Tema5.AgendaTelefonica;

import java.util.List;
import java.util.Scanner;

public class Agenda {
    private List<Contacto> contactos;

    public boolean existeContacto(Contacto c) {
        /*for (Contacto contacto : contactos) {
            if (c.equals(contacto)) {
                System.out.println("Contacto encontrado");
                return true;
            }
            else {
                System.out.println("Contacto no encontrado");
                return false;
            }
        }
        return false;*/
    return this.contactos.contains(c);
    }

    public boolean addContacto(Contacto c) {
       /* System.out.println("Nombre del nuevo contacto");
        String nombre = sc.nextLine();
        System.out.println("Cual es el número de teléfono de "+nombre);
        String numero = sc.nextLine();
        contactos.add(new Contacto(nombre, numero));
        System.out.println("Contacto creado");*/
        if (!this.existeContacto(c)) {
            this.contactos.add(c);
            return true;
        } else {
            return false;
        }
    }
    public void listarContactos() {
        System.out.println(contactos.toString());
    }
    public Contacto buscarContacto(String nombre) {
   /*     for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
                System.out.println("Contacto encontrado con número de teléfono: ");
                System.out.println(contacto.getTelefono());
                return true;
            } else
                return false;
        }
        return false;*/
    int posicion = this.contactos.indexOf(new Contacto(nombre, ""));
    if (posicion < 0)
        return null;
    else
        return this.contactos.get(posicion);
    }

    public boolean eliminarContacto(Contacto c) {
        /*if (existeContacto(c)){
            contactos.remove(c);
        } else {
            System.out.println("Contacto no existe");
        }*/
        return this.contactos.remove(c);
    }
}
