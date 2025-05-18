package Programacion.Tema7.RepasoColecciones.Ejercicio4;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class AgendaCitas {
        //TreeMap. Agenda de Citas. Las claves seran
        //LocalDateTime
        //y el valor una descripcion de la cita.
        //Metodos para agregar, y para mostrar ordenados por fecha(reversed tambien).
        //Tambien eliminar una cita
    TreeMap<LocalDateTime, String> citas;
    LocalDateTime fecha;
    private String descripcion;

    public AgendaCitas() {
        this.citas = new TreeMap<>();
    }

    public void addCita(LocalDateTime fechaHora, String descripcion) {
        citas.put(fechaHora, descripcion);
    }
    public void delCita(LocalDateTime fechaHora) {
        citas.remove(fechaHora);
    }
    public void mostrarCitasOrdenadas() {
        for (Map.Entry<LocalDateTime, String> entrada : citas.entrySet()) {
            System.out.println(entrada.getKey() + " --> " + entrada.getValue());
        }
    }
    public void mostrarCitasOrdenadasDesc() {
        NavigableMap<LocalDateTime, String> reverso = citas.descendingMap();
            for (Map.Entry<LocalDateTime, String> entrada : reverso.entrySet()) {
                System.out.println(entrada.getKey() + " --> " + entrada.getValue());
        }
    }
}
