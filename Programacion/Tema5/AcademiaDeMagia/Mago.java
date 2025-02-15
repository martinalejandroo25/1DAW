package Programacion.Tema5.AcademiaDeMagia;

import java.util.ArrayList;
import java.util.List;

public class Mago {
    private String nombre;
    private int energia;
    private List<Hechizo> hechizos;

    public Mago(String nombre, int energia, List<Hechizo> hechizos) {
        this.nombre = nombre;
        this.energia = energia;
        this.hechizos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public List<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mago{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", energia=").append(energia);
        sb.append(", hechizos=").append(hechizos);
        sb.append('}');
        return sb.toString();
    }

    public void aprenderHechizo(Hechizo hechizo) {
        this.hechizos.add(hechizo);
    }

    public void lanzarHechizo(String nombreHechizo, Prueba prueba) {

        }
    }

    //Metodo extra buscar

    public Hechizo buscar(String  nombreHechizo) {
        for (Hechizo hechizo : hechizos) {
            if (hechizo.getNombre().equalsIgnoreCase(nombreHechizo)) {
                return hechizo;
            }
        }
        return null; //si no se encuentra devuelve null
    }

    public void recargarEnergia(int cantidad) {
        setEnergia(cantidad);
        if (getEnergia() > 100) {
            setEnergia(100);
        }
    }
}
