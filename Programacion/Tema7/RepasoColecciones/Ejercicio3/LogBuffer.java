package Programacion.Tema7.RepasoColecciones.Ejercicio3;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class LogBuffer {
    //ArrayDeque vs LinkedList. Deque(Cola de doble terminacion, puede servir de cola y pila).
    //Clase LogBuffer con
                        //Deque<String>logs,
                        //Integer capacidad, que crea un ArrayDeque, si pasas la capacidad se copia a otro,
                        //en nuestro caso no nos vamos a pasar
    //Metodos addLog(si esta lleno se borra el primero, sino se a)
    private Deque<String> logs;
    private int capacidad;

    public LogBuffer(int capacidad) {
        this.logs = new ArrayDeque<>();
        this.capacidad = capacidad;
    }

    public void addLog(String log){
        if (logs.size() == capacidad){
            logs.removeFirst(); // elimina el log mas antiguo
        }
        logs.addLast(log); //agrega el nuevo log al final
    }

    public void mostrarLogs(){
        for (String log : logs){
            System.out.println(log);
        }
    }

    public Deque<String> getLogs() {
        return logs;
    }
}
