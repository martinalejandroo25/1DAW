package Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models;

import java.io.FileWriter;
import java.io.IOException;

// ProductoBase.java
public class ProductoBase extends Producto {
    private double largo;
    private double ancho;
    private double alto;
    private double peso;
    private boolean esRegalo;
    private static final double COSTE_ENVOLTORIO = 2.0;

    public ProductoBase(String sku, double precioBase, IVA iva, DetalleProducto detalle,
                        double largo, double ancho, double alto, double peso, boolean esRegalo) {
        super(sku, precioBase, iva, detalle);
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.peso = peso;
        this.esRegalo = esRegalo;
    }

    public double getLargo() { return largo; }
    public void setLargo(double largo) { this.largo = largo; }
    public double getAncho() { return ancho; }
    public void setAncho(double ancho) { this.ancho = ancho; }
    public double getAlto() { return alto; }
    public void setAlto(double alto) { this.alto = alto; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public boolean isEsRegalo() { return esRegalo; }
    public void setEsRegalo(boolean esRegalo) { this.esRegalo = esRegalo; }

    @Override
    public boolean toPDF() {
        boolean ok = super.toPDF();
        try (FileWriter writer = new FileWriter(sku + ".txt", true)) {
            writer.write("Dimensiones (LxAxH): " + largo + "x" + ancho + "x" + alto + System.lineSeparator());
            writer.write("Peso: " + peso + System.lineSeparator());
            writer.write("Es Regalo: " + esRegalo + System.lineSeparator());
            return ok;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public double gastoTransporte(double costeFlete, double pesoFlete) {
        double tarifa;
        if (pesoFlete < 10) tarifa = 5;
        else if (pesoFlete <= 50) tarifa = 10;
        else tarifa = 20;
        return pesoFlete * tarifa;
    }

    @Override
    public double getImporte() {
        double transporte = gastoTransporte(0, peso);
        if (esRegalo) transporte += COSTE_ENVOLTORIO;
        return (precioBase + transporte) + calculoIVA();
    }
}
