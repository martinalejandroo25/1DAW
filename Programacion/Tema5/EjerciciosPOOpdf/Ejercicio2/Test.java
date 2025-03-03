package Programacion.Tema5.EjerciciosPOOpdf.Ejercicio2;

public class Test {
    public static void main(String[] args) {
        Password p1 = new Password();
        Password p2 = new Password(4);

        System.out.println(p1);
        System.out.println(p1.esFuerte());
        System.out.println(p2);
        System.out.println(p2.esFuerte());
    }
}
