package Tienda;

import java.time.LocalDate;

public class Compra {
    private LocalDate fecha;
    private Producto producto;
    private Integer cantidad;
    private double precioTotal;

    public Compra(LocalDate fecha, Producto producto, Integer cantidad, double precioTotal) {
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Compra{");
        sb.append("fecha=").append(fecha);
        sb.append(", producto=").append(producto);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", precioTotal=").append(precioTotal);
        sb.append('}');
        return sb.toString();
    }
}
