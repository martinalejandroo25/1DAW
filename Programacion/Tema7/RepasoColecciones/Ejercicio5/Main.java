package Programacion.Tema7.RepasoColecciones.Ejercicio5;

public class Main {
    public static void main(String[] args) {
        Project p = new Project(1, "Entrega Web");
        Employee ana = new Employee(100, "Ana");
        Employee Luis = new Employee(101, "Luis");

        p.addTeamMember(ana);
        p.addTeamMember(Luis);

        p.assignTask(ana, new Task("Diseño de interfaz"));
        p.assignTask(ana, new Task("Revision de usabilidad"));
        p.assignTask(Luis, new Task("Implementar backend"));

        p.ShowInfoProject();
    }
}
