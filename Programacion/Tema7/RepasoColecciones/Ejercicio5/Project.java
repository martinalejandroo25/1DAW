package Programacion.Tema7.RepasoColecciones.Ejercicio5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Project {
    private Integer projectId;
    private String projectName;
    Set<Employee> members;
    Map<Employee, Set<Task>> tasksByEmployee;

    public Project(Integer projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
        members = new HashSet<Employee>();
        tasksByEmployee = new HashMap<Employee, Set<Task>>();
    }

    // Agregar empleado al proyecto y crea su conjunto de tareas vacio
    public void addTeamMember(Employee emp) {
        if(members.add(emp)) {
            tasksByEmployee.put(emp, new HashSet<>());
        }
    }

    //Asigna tarea: comprueba que este en members, luego la añade
    public void assignTask(Employee emp, Task task) {
        if (!members.contains(emp)) {
            throw new IllegalArgumentException(
                    "El empleado "+ emp + "no pertenece al proyecto. "
            );
        }
        tasksByEmployee.get(emp).add(task);
    }
    // Muestra info: empleados y sus tareas
    public void ShowInfoProject(){
        System.out.println("Proyecto "+ projectName + "(ID: " +projectId + ")");

        for (Employee e : members) {
            System.out.println("- " + e.getName() + ":");
            Set<Task> tasks = tasksByEmployee.get(e);
            if(tasks.isEmpty()){
                System.out.println("      (sin tareas asignadas)");
            } else {
                for (Task t : tasks) {
                    System.out.println("       # "+ t.getDescription());
                }
            }
        }
    }
}
