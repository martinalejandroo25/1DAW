package Programacion.Examen2Evaluacion.AlquilerCoches.src;

import java.util.Objects;
import java.util.UUID;

public abstract class Coche {
    //ATRIBUTOS
    private Long id = 0L;
    private String marca;
    private String modelo;
    private String matricula;
    private int year;
    private TipoCombustible combustible;
    private TipoCoche tipo;
    private Double precioBase;
    private boolean disponible;


    //CONSTRUCTORES

    //Constructor vacío
    public Coche(long id, String marca, String modelo, String matricula, int year, TipoCombustible combustible, TipoCoche tipo, Double precioBase) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.year = year;
        this.combustible = combustible;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.disponible = true;
    }


//Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public TipoCombustible getCombustible() {
        return combustible;
    }

    public void setCombustible(TipoCombustible combustible) {
        this.combustible = combustible;
    }

    public TipoCoche getTipo() {
        return tipo;
    }

    public void setTipo(TipoCoche tipo) {
        this.tipo = tipo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //METODOS

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coche{");
        sb.append("id=").append(id);
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", matricula='").append(matricula).append('\'');
        sb.append(", year=").append(year);
        sb.append(", combustible=").append(combustible);
        sb.append(", tipo=").append(tipo);
        sb.append(", precioBase=").append(precioBase);
        sb.append(", disponible=").append(disponible);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return Objects.equals(id, coche.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public abstract double calcularPrecioAlquiler(int dias);

}
