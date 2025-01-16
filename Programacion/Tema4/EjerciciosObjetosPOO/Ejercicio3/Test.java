package Programacion.Tema4.EjerciciosObjetosPOO.Ejercicio3;

public class Test {
    public static void main(String[] args) {
        Pajaro pajaro1 = new Pajaro();
        pajaro1.setedad(5);
        System.out.println("Edad del pajaro: ");
        pajaro1.printedad();
        pajaro1.setcolor('A');
        System.out.println("Color del pajaro: ");
        pajaro1.printcolor();


    }
}
