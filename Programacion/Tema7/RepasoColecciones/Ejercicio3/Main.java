package Programacion.Tema7.RepasoColecciones.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        LogBuffer buffer = new LogBuffer(3);

        buffer.addLog("Inicio del programa");
        buffer.addLog("Cargando configuracion");
        buffer.addLog("Configuracion cargada");
        buffer.mostrarLogs();

        System.out.println("------------");

        buffer.addLog("Nueva accion realizada");
        buffer.mostrarLogs();
    }
}
