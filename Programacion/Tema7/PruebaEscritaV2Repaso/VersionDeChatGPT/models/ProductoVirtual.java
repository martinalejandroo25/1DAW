package Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models;// ProductoVirtual.java
import java.io.FileWriter;
import java.io.IOException;

public class ProductoVirtual extends Producto {
    private long pesoBytes;
    private String urlDescarga;
    private TipoVirtual tipo;

    public ProductoVirtual(String sku, double precioBase, IVA iva, DetalleProducto detalle,
                           long pesoBytes, String urlDescarga, TipoVirtual tipo) {
        super(sku, precioBase, iva, detalle);
        this.pesoBytes = pesoBytes;
        this.urlDescarga = urlDescarga;
        this.tipo = tipo;
    }

    public long getPesoBytes() { return pesoBytes; }
    public void setPesoBytes(long pesoBytes) { this.pesoBytes = pesoBytes; }
    public String getUrlDescarga() { return urlDescarga; }
    public void setUrlDescarga(String urlDescarga) { this.urlDescarga = urlDescarga; }
    public TipoVirtual getTipo() { return tipo; }
    public void setTipo(TipoVirtual tipo) { this.tipo = tipo; }

    @Override
    public boolean toPDF() {
        boolean ok = super.toPDF();
        try (FileWriter writer = new FileWriter(sku + ".txt", true)) {
            writer.write("Peso (bytes): " + pesoBytes + System.lineSeparator());
            writer.write("URL Descarga: " + urlDescarga + System.lineSeparator());
            writer.write("Tipo Virtual: " + tipo + System.lineSeparator());
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
