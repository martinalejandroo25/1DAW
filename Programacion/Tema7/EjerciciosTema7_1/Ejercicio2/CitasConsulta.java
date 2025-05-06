package Programacion.Tema7.EjerciciosTema7_1.Ejercicio2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class CitasConsulta {
    //clase CitasConsulta, que tendrá un ArrayList<Cita>. Crear
    //constructor (inicializa ArrayList), getters, setters. Añade métodos para: addCita,
    //removeCita, listarCitasPorNombre, listarCitasPorApellidos,
    //listarCitasPorFechaYApellidos, listarCitasPorHora(LocalDate fecha),
    //buscarCitasFuturas(String email) que buscará las citas futuras de la persona relativa a
    //ese email
    ArrayList<Cita> citas;

    public CitasConsulta(ArrayList<Cita> citas) {
        this.citas = new ArrayList<>();
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public void addCita(Cita cita){
        this.citas.add(cita);
    }
    public void removeCita(Cita cita){
        this.citas.remove(cita);
    }
    public void listarCitasPorNombre(String nombre){
        this.citas.sort(Comparator.comparing(Cita::getPersona));
        for (Cita ci : citas){
            System.out.println(ci);
        }

    }
    public void listarCitasPorApellido(String apellido){
        this.citas.sort(new Comparator<Cita>() {
            @Override
            public int compare(Cita o1, Cita o2) {
                return o1.getPersona().getApellidos().compareTo(o2.getPersona().getApellidos());
            }
        });
        for (Cita ci : citas){
            System.out.println(ci);
        }

    }
    public void listarCitaPorFechaYApellidos(){
        this.citas.sort(new Comparator<Cita>() {
            @Override
            public int compare(Cita o1, Cita o2) {
                if (o1.getFecha().equals(o2.getFecha())){
                    return o1.getPersona().getApellidos().compareTo(o2.getPersona().getApellidos());
                } else {
                    return o1.getFecha().compareTo(o2.getFecha());
                }
            }
        });
        for (Cita cita : citas){
            System.out.println(cita);
        }
    }
    public void listarCitasPorHora(LocalDate fecha){
        //en un array meto las citas de esa fecha
        ArrayList<Cita> citasEnFecha = new ArrayList<>();
        for (Cita cita : citas){
            if (cita.getFecha().equals(fecha)){
                citasEnFecha.add(cita);
            }
        }
        citasEnFecha.sort(Comparator.comparing(Cita::getHora));
        for (Cita cita : citasEnFecha){
            System.out.println(cita);
        }
    }
    public void buscarCitasFuturas(String email){
        for (Cita cita : citas){
            if (cita.getPersona().getEmail().equals(email) &&
                    cita.getFecha().isAfter(LocalDate.now())) {
                System.out.println(cita);
            }
        }
    }
}
