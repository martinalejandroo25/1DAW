package Programacion.Examen2Evaluacion.AlquilerCoches.src;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler {
    //atributos
    private long id;
    private Cliente cliente;
    private Coche coche;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double precioTotal;
    private int dias;

    //constructores

    public Alquiler(Cliente cliente, Coche coche, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.coche = coche;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = coche.calcularPrecioAlquiler((int)fechaInicio.until(fechaFin, ChronoUnit.DAYS));
    }


    //getters y setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Alquiler{");
        sb.append("id=").append(id);
        sb.append(", cliente=").append(cliente);
        sb.append(", coche=").append(coche);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaFin=").append(fechaFin);
        sb.append(", precioTotal=").append(precioTotal);
        sb.append('}');
        return sb.toString();
    }

    public void cancelarAlquiler(){
        coche.setDisponible(true);
    }

    public String crearEmail(){
        return "Estimado Cliente " +
                getCliente().getNombre() + " " +
                getCliente().getApellido()+ '\'' +
                "Su coche de Alquiler "
                + getCoche().getMarca() +
                getCoche().getModelo() +
                " de matrícula: " +
                getCoche().getMatricula() +
                "alquilado el día " +
                getFechaInicio().toString() +
                "Finalizará su período de alquiler el " +
                getFechaFin().toString() + '\'' +
                "El precio Total del servicio es de: " +
                getPrecioTotal() + '\'' +"Muchas gracias por confiar en nosotros";
    }

}
