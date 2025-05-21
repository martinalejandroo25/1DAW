package Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models;// Producto.java
import Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.io.VistaPDF;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public abstract class Producto implements VistaPDF, Comparable<Producto> {
    protected String sku;
    protected double precioBase;
    protected IVA iva;
    protected DetalleProducto detalleProducto;

    public Producto(String sku, double precioBase, IVA iva, DetalleProducto detalleProducto) {
        this.sku = sku;
        this.precioBase = precioBase;
        this.iva = iva;
        this.detalleProducto = detalleProducto;
    }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public IVA getIva() { return iva; }
    public void setIva(IVA iva) { this.iva = iva; }
    public DetalleProducto getDetalleProducto() { return detalleProducto; }
    public void setDetalleProducto(DetalleProducto detalleProducto) { this.detalleProducto = detalleProducto; }

    /**
     * Genera un fichero <sku>.txt con información básica y detalleProducto.
     */
    @Override
    public boolean toPDF() {
        try (FileWriter writer = new FileWriter(sku + ".txt")) {
            writer.write("SKU: " + sku + System.lineSeparator());
            writer.write("Precio Base: " + precioBase + System.lineSeparator());
            writer.write("IVA: " + iva + "%" + System.lineSeparator());
            writer.write(detalleProducto.toString() + System.lineSeparator());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Calcula importe total, implementado en subclases.
     */
    public abstract double getImporte();

    protected double calculoIVA() {
        return precioBase * iva.getPorcentaje() / 100.0;
    }

    @Override
    public int compareTo(Producto o) {
        return this.sku.compareTo(o.sku);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "sku='" + sku + '\'' +
                ", precioBase=" + precioBase +
                ", iva=" + iva +
                ", detalle=" + detalleProducto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(sku, producto.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}
