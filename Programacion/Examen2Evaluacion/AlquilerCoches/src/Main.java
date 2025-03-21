package Programacion.Examen2Evaluacion.AlquilerCoches.src;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Atributos
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        Agencia agencia = new Agencia();
        ArrayList<Coche> coches = new ArrayList<>(20);

        for (int i = 0; i <= 20; i++) {
            if (i <= 10){
                if (i <= 5){
                    coches.add(new CocheEstandar(i, "Marca1", "modelo1", "GHF1234", 2025, TipoCombustible.GASOLINA, TipoCoche.SEDAN, 45.00, true));

                }
                else {
                    coches.add(new CocheEstandar(i, "Marca1", "modelo1", "GHF1234", 2025, TipoCombustible.DIESEL, TipoCoche.SUV, 34.00, false));
                }
            }
            else {
                if (i < 15){
                    coches.add(new CochePremium(i, "Marca1", "modelo1", "GHF1234", 2025, TipoCombustible.GASOLINA, TipoCoche.SEDAN, 45.00, true, false));
                }
                else {
                    coches.add(new CochePremium(i, "Marca1", "modelo1", "GHF1234", 2025, TipoCombustible.DIESEL, TipoCoche.SUV, 34.00, false, true));
                }
            }
        }
        for (Coche co : coches) {
            agencia.addCoche(co);
        }

        while (opcion != 5) {
               try {
                   System.out.println("""
                BIENVENIDO A MI AGENCIA DE ALQUILER DE COCHES
                
                MENÚ:
                    1. Listar Coches Disponibles
                    2. Listar Alquileres activos
                    3. Realizar alquiler
                    4. Mostrar ingresos
                    5. Salir
                Elige una opción:
                """);
                   opcion = Integer.parseInt(sc.nextLine());
               }catch (Exception e){
                   System.out.println("Opcion invalida");
               }
            switch (opcion){
                case 1:
                    System.out.println("Aquí se listan los coches disponibles:");
                    agencia.listarCochesDisponibles();
                    break;
                case 2:
                    System.out.println("Aquí se listan los alquileres activos");
                    agencia.listarAlquileresActivos();
                    break;
                case 3:
                    try {
                        System.out.println("Antes de nada, vamos a confirmar que el Tipo de Coche que buscas está disponible con nosotros");
                        System.out.println("¿Cual es el tipo de Coche que desea? (SEDAN, SUV, FURGONETA, DEPORTIVO)");
                        String tipocoche = sc.nextLine();
                        System.out.println(TipoCoche.valueOf(tipocoche.toUpperCase()));
                        Coche co = agencia.buscarCocheDisponible(TipoCoche.valueOf(tipocoche.toUpperCase()));
                        System.out.println("¡Genial! Ahora necesitaremos algunos datos...");
                        System.out.println("¿Cuales son los datos del cliente?");
                        System.out.println("Nombre (sin apellido):");
                        String nombre = sc.nextLine();
                        System.out.println("Apellidos:");
                        String apellido = sc.nextLine();
                        System.out.println("DNI");
                        String dni = sc.nextLine();
                        System.out.println("Correo Electrónico:");
                        String email = sc.nextLine();
                        System.out.println("Dirección:");
                        String direccion = sc.nextLine();
                        System.out.println("Numero de teléfono:");
                        String telefono = sc.nextLine();
                        System.out.println("Código de la Licencia de Conducir");
                        String licenciaConducir = sc.nextLine();
                        System.out.println("¿en que dia del mes se obtuvo?");
                        int dia = Integer.parseInt(sc.nextLine());
                        System.out.println("mes de la obtención de la licencia:");
                        int mes = Integer.parseInt(sc.nextLine());
                        System.out.println("Año en el que se obtuvo la licencia:");
                        int year = Integer.parseInt(sc.nextLine());

                        LocalDate fechaLicencia = LocalDate.of(year, mes, dia);
                        Cliente cli = new Cliente(nombre, apellido, dni, email, direccion, telefono, licenciaConducir, fechaLicencia);

                        System.out.println("¿En que fecha desea empezar el alquilado?");
                        System.out.println("dia:");
                        int diaIni = Integer.parseInt(sc.nextLine());
                        System.out.println("mes:");
                        int mesIni = Integer.parseInt(sc.nextLine());
                        System.out.println("Año:");
                        int yearIni = Integer.parseInt(sc.nextLine());
                        LocalDate fechaIni = LocalDate.of(yearIni, mesIni, diaIni);

                        System.out.println("¿En que fecha desea Finalizar el alquilado?");
                        System.out.println("dia:");
                        int diaFin = Integer.parseInt(sc.nextLine());
                        System.out.println("mes:");
                        int mesFin = Integer.parseInt(sc.nextLine());
                        System.out.println("Año:");
                        int yearFin = Integer.parseInt(sc.nextLine());
                        LocalDate fechaFin = LocalDate.of(yearFin, mesFin, diaFin);


                        if (agencia.realizarAlquiler(cli, TipoCoche.valueOf(tipocoche.toUpperCase()), fechaIni, fechaFin)) {
                            System.out.println("El Alquilado ha sido realizado con éxito");
                        } else
                            System.out.println("Ha ocurrido un problema y no se ha podido completar el alquilado");
                    } catch (Exception e) {
                        System.out.println("Lo sentimos, se han introducido valores inadecuados");
                        continue;
                    }
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Muchas gracias por usar la agenda :))");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}