package Programacion.Tema5.EjercicioEqualsCopia;

import java.util.Objects;

public class TelefonoMovil {
    private String modelo;
    private String numero;
    private String codigoPais;
    private Double peso;

    public TelefonoMovil(String modelo, String numero, String codigoPais, Double peso) {
        this.modelo = modelo;
        this.numero = numero;
        this.codigoPais = codigoPais;
        this.peso = peso;
    }

    public TelefonoMovil(TelefonoMovil copia) {
        this.modelo = copia.modelo;
        this.numero = copia.numero;
        this.codigoPais = copia.codigoPais;
        this.peso = copia.peso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "TelefonoMovil{" +
                "modelo='" + modelo + '\'' +
                ", numero='" + numero + '\'' +
                ", codigoPais='" + codigoPais + '\'' +
                ", peso=" + peso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonoMovil that = (TelefonoMovil) o;
        return Objects.equals(modelo, that.modelo) && Objects.equals(numero, that.numero) && Objects.equals(codigoPais, that.codigoPais) && Objects.equals(peso, that.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, numero, codigoPais, peso);
    }
}
