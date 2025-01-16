package Programacion.Tema4.EjerciciosObjetosPOO.Ejercicio1;

public class Temperatura {
    public static double celsiusToFarenheit(double celsius) {
        return (1.8)*celsius + 32;
    }

    public static double farenheitToCelsius(double farenheit) {
        return (farenheit - 32)/1.8;
    }
}
