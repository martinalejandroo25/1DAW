package Programacion.Tema4.EjerciciosObjetosPOO.Ejercicio4;

public class test {
    public static void main(String[] args) {
        Finanzas f1 = new Finanzas();
        Finanzas f2 = new Finanzas();
        double eurToDolar = 1000;
        double dolarToEur = 1000;

       System.out.println(f1.eurosToDolares(eurToDolar));
        System.out.println(f2.dolaresToEuros(dolarToEur));
    }
}
