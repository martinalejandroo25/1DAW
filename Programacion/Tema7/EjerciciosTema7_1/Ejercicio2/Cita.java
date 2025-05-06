package Programacion.Tema7.EjerciciosTema7_1.Ejercicio2;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    // Crear una clase Cita, con Persona, fecha, hora, tipo (PRIMERA,
    //REVISION, CONSULTA). Constructor, getters, setters, toString
    private Persona persona;
    private LocalDate fecha;
    private LocalTime hora;
    private enum tipo {PRIMERA, REVISION, CONSULTA}

    public Cita(Persona persona, LocalDate fecha, LocalTime hora) {
        this.persona = persona;
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cita{");
        sb.append("persona=").append(persona);
        sb.append(", fecha=").append(fecha);
        sb.append(", hora=").append(hora);
        sb.append('}');
        return sb.toString();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
