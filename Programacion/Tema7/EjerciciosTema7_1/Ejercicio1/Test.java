package Programacion.Tema7.EjerciciosTema7_1.Ejercicio1;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Diccionario dic = new Diccionario();

        dic.addEntrada(new Entrada("Hola", "Hello"));
        dic.addEntrada(new Entrada("Adios", "Goodbye"));
        dic.addEntrada(new Entrada("respuesta", "replay"));
        dic.addEntrada(new Entrada("superficie", "expanse"));
        dic.addEntrada(new Entrada("disponible","available"));
        dic.addEntrada(new Entrada("cesta", "basket"));
        dic.addEntrada(new Entrada("antes", "before"));
        dic.addEntrada(new Entrada("mejor","better"));
        dic.addEntrada(new Entrada("pájaro","bird"));
        dic.addEntrada(new Entrada("rama", "branch"));
        dic.addEntrada(new Entrada("puente", "bridge"));
        dic.addEntrada(new Entrada("pastel", "cake"));
        dic.addEntrada(new Entrada("cierto", "certain"));
        dic.addEntrada(new Entrada("cereza","cherry"));
        dic.addEntrada(new Entrada("nube","cloud"));

        dic.listarPalabra();

        System.out.println("Traduccion de 'disponible' -> "+ dic.buscarEntrada("disponible"));

        System.out.println("Traduccion de 'perro' -> "+ dic.buscarEntrada("perro"));
        System.out.println("Traduccion de 'nube' -> "+ dic.buscarEntrada("nube"));

    }

}
