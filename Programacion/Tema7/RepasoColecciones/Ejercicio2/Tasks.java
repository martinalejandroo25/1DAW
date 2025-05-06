package Programacion.Tema7.RepasoColecciones.Ejercicio2;

import java.util.PriorityQueue;

public class Tasks {
    PriorityQueue<Task> prioridad;

    public Tasks() {
        this.prioridad = new PriorityQueue<>();
    }
    public void addTarea(Task task) {
        this.prioridad.offer(task);
    }
    public void MostrarTarea() {
        System.out.println("Proxima tarea: " + prioridad.peek() != null ? prioridad.peek().getDescripcion() : "No " +
                "hay tarea");
    }
    public void EliminarTarea(Task task) {
        prioridad.remove(task);
    }
    public void MostrarTodasTareas() {
        System.out.println("Proximas tareas: ");
        for (Task t : prioridad) {
            System.out.println(t.getDescripcion());
        }
    }
}
