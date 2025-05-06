package Programacion.Tema7.RepasoColecciones.Ejercicio2;

public class Test {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();

        Task t1 = new Task(2, "Limpiar casa");
        Task t2 = new Task(1, "Limpiar baño");
        Task t3 = new Task(3, "Hacer Tareas");
        Task t4 = new Task(4, "Carnet de conducir");
        Task t5 = new Task(5, "programar");

        tasks.addTarea(t1);
        tasks.addTarea(t2);
        tasks.addTarea(t3);
        tasks.addTarea(t4);
        tasks.addTarea(t5);

        tasks.MostrarTarea();
        tasks.MostrarTodasTareas();
        tasks.EliminarTarea(t2);
        System.out.println();
        tasks.MostrarTarea();
    }
}