package Programacion.Tema7.Practica2Streams.BancoSmart;

import java.time.LocalDate;

public class Transaccion {

    private Long id;
    private Cuenta cuenta;
    private Double importe;
    private LocalDate fecha;
    private TipoTransaccion tipoTransaccion;
    private String descripcion;

    public Transaccion(Cuenta cuenta, Double importe, LocalDate fecha, TipoTransaccion tipoTransaccion, String descripcion) {
        this.cuenta = cuenta;
        this.importe = importe;
        this.fecha = fecha;
        this.tipoTransaccion = tipoTransaccion;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaccion{");
        sb.append("id=").append(id);
        sb.append(", cuenta=").append(cuenta);
        sb.append(", importe=").append(importe);
        sb.append(", fecha=").append(fecha);
        sb.append(", tipoTransaccion=").append(tipoTransaccion);
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
}