package Programacion.Tema5.AcademiaDeMagia;

import java.util.ArrayList;

public class Mago {

    private String nombre;
    private Integer energia;
    private ArrayList<Hechizo> hechizos; //Hechizos que el mago tiene aprendidos

    public Mago(String nombre, Integer energia) {
        this.nombre = nombre;
        this.energia = energia;
        this.hechizos = new ArrayList<>(); //Iniciar el array de hechizos
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public ArrayList<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(ArrayList<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Mago{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", energia=").append(energia);
        sb.append(", hechizos=").append(hechizos);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Añadiendo el hechizo pasado como parámetro, a la lista de hechizos
     * que el mago tiene aprendidos
     * @param hechizo
     */
    public void aprenderHechizo(Hechizo hechizo) {
        this.hechizos.add(hechizo);
    }


    /**
     * Sumar esa cantidad de energía a la energía del mago.
     * No se puede superar 100 puntos de energía máximos
     * @param cantidad
     */
    public void recargarEnergia(Integer cantidad) {
        if (this.getEnergia() + cantidad >= 100) {
            this.setEnergia(100);
        } else {
            //this.energia += cantidad;
            this.setEnergia(this.getEnergia() + cantidad);
        }
    }

    public void perderEnergia(Integer cantidad) {
        if (this.getEnergia() - cantidad <= 0) {
            this.setEnergia(0);
        } else {
            //this.energia += cantidad;
            this.setEnergia(this.getEnergia() - cantidad);
        }
    }

    /**
     * El método primero busca que el Mago tenga un Hechizo con el mismo nombre
     * que se le pasa como String. Si no lo tiene devuelve false y acaba.
     * Comprobar que el mago tiene suficiente energía para lanzar el hechizo
     * Si el mago sí tiene ese Hechizo comprueba (esEfectivo) que puede superar la Prueba.
     * Si el Hechizo es efectivo suma la recompensa de la prueba a la energía del mago
     * y devuelve true.
     * Si no devuelve false y aplica una pérdida de energía (la dificultad de la prueba)
     * @param nombreHechizo
     * @param prueba
     * @return
     */
    public void lanzarHechizo(String nombreHechizo, Prueba prueba) throws Exception {
        //Buscar que el Mago tenga ese Hechizo
        Hechizo miHechizo = this.buscar(nombreHechizo);
        if (miHechizo == null) { //No encontrado
            throw new Exception("Hechizo " + nombreHechizo + " no encontrado");
        } else {
            //Comprobar que el mago tiene energía para lanzar el hechizo
            if (this.getEnergia() < miHechizo.getEnergia()) { //No energía
                throw new Exception("El mago no tiene energía (" +
                        this.energia + ") para lanzar el hechizo " + nombreHechizo +
                        " que necesita energía " + miHechizo.getEnergia());
            } else {
                //Ver si el Hechizo es efectivo
                if (!miHechizo.esEfectivo(prueba)) { //No efectivo
                    this.perderEnergia(prueba.getRecompensa());
                    throw new Exception("El hechizo "+ nombreHechizo +
                            " no es efectivo para la prueba " + prueba.getDescripcion());
                } else {
                    //Aplicar el Hechizo
                    this.recargarEnergia(prueba.getRecompensa());
                }
            }
        }
    }

    /**
     * Recorre la lista de hechizos del mago y busca alguno que tenga el mismo
     * nombre que el que se pasa como parámetro ignorando mayúsculas.
     * Devuelve el objeto Hechizo si lo encuentra, o null si no lo encuentra
     * @param nombreHechizo
     * @return
     */
    private Hechizo buscar(String nombreHechizo) {
        for(Hechizo hechizo: this.hechizos) {
            if (hechizo.getNombre().equalsIgnoreCase(nombreHechizo)) {
                return hechizo;
            }
        }
        return null;
    }

}