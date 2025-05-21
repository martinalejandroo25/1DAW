package Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models;// ProductoSubasta.java
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
        import java.util.function.Predicate;

public class ProductoSubasta extends Producto {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Map<String, Puja> pujas = new HashMap<>();

    public ProductoSubasta(String sku, double precioBase, IVA iva, DetalleProducto detalle,
                           LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        super(sku, precioBase, iva, detalle);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }

    // Añadir o modificar puja
    public boolean pujar(Puja puja) {
        LocalDateTime ahora = LocalDateTime.now();
        double maxActual = pujas.values().stream()
                .mapToDouble(Puja::getPuja)
                .max().orElse(precioBase);
        if (puja.getPuja() >= Math.max(precioBase, maxActual) && ahora.isBefore(fechaFin)) {
            pujas.put(puja.getCliente(), puja);
            return true;
        }
        return false;
    }

    // Borrar puja
    public void borrarPuja(String cliente) {
        pujas.remove(cliente);
    }

    // Consultar puja por cliente
    public Puja getPujaCliente(String cliente) {
        return pujas.get(cliente);
    }

    public Puja buscarPuja(Predicate<Puja> criterio) {
        return pujas.values().stream().filter(criterio).findFirst().orElse(null);
    }

    public Puja getPujaMaxima() {
        return pujas.values().stream()
                .max(Comparator.comparingDouble(Puja::getPuja))
                .orElse(null);
    }

    @Override
    public boolean toPDF() {
        boolean ok = super.toPDF();
        try (FileWriter writer = new FileWriter(sku + ".txt", true)) {
            writer.write("Precio Inicial Subasta: " + precioBase + System.lineSeparator());
            Puja ganadora = getPujaMaxima();
            writer.write("Precio Final Subasta: " + (ganadora != null ? ganadora.getPuja() : 0) + System.lineSeparator());
            return ok;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public double getImporte() {
        return precioBase + calculoIVA();
    }
}
