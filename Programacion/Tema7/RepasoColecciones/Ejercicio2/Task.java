package Programacion.Tema7.RepasoColecciones.Ejercicio2;

public class Task implements Comparable<Task>{
    private Integer prioridad;
    private String descripcion;

    public Task(Integer prioridad, String descripcion) {
        this.prioridad = prioridad;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("prioridad=").append(prioridad);
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int compareTo(Task o) {
        return this.prioridad.compareTo(o.prioridad);
    }
}
