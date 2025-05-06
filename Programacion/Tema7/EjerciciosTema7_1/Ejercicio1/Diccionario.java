package Programacion.Tema7.EjerciciosTema7_1.Ejercicio1;

import java.util.Comparator;
import java.util.TreeSet;

public class Diccionario {
    TreeSet<Entrada> entradas;
    Comparator<Entrada> EntradasComparator;

    public Diccionario() {
        this.entradas = new TreeSet<>(Comparator.comparing(Entrada::getSpanish));
    }

    public TreeSet<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(TreeSet<Entrada> entradas) {
        this.entradas = entradas;
    }

    public Comparator<Entrada> getEntradasComparator() {
        return EntradasComparator;
    }

    public void setEntradasComparator(Comparator<Entrada> entradasComparator) {
        EntradasComparator = entradasComparator;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Diccionario{");
        sb.append("entradas=").append(entradas);
        sb.append(", EntradasComparator=").append(EntradasComparator);
        sb.append('}');
        return sb.toString();
    }
    public void addEntrada(Entrada entrada){
        entradas.add(entrada);
    }
    public void removeEntrada(Entrada entrada){
        entradas.remove(entrada);
    }
    public void listarPalabra(){
        System.out.println("DICCIONARIO...................");
        for (Entrada e : entradas){
            System.out.println(e.getSpanish() + " -> "+ e.getEnglish());
        }
    }
    public String buscarEntrada(String palabra){
        for (Entrada en : entradas){
            if (en.getSpanish().equalsIgnoreCase(palabra)){
                return en.getEnglish();
            }
        }
        return "No encontrado en el Diccionario";
    }
}
