package Programacion.Tema7.RepasoColecciones.Ejercicio4;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AgendaCitas agenda = new AgendaCitas();

        agenda.addCita(LocalDateTime.of(2025, 5, 20, 14, 0), "Dentista");
        agenda.addCita(LocalDateTime.of(2025, 5, 18, 12, 0), "Reunion con Juan");
        agenda.addCita(LocalDateTime.of(2025, 5, 25, 9, 0), "Entrega de proyecto");

        System.out.println("Citas en orden cronologico");
        agenda.mostrarCitasOrdenadas();
        System.out.println("En orden reverso");
        agenda.mostrarCitasOrdenadasDesc();
    }
}
