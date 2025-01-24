package Programacion.Tema4.EjerciciosObjetosPOO.Ejercicio2;

public class Test {
    public static void main(String[] args) {
        Coche coche1 = new Coche();
        coche1.acelera(50);
        System.out.println("Velocidad de coche1 es: " + coche1.getVelocidad());
        coche1.frena(24);
        System.out.println("Velocidad de coche1 después de un frenado es: "+coche1.getVelocidad());

    }
}
