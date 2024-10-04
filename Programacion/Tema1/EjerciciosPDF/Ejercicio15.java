package Programacion.Tema1.EjerciciosPDF;

public class Ejercicio15 {
    public static void main(String[] args) {
        //Escriba un programa que escriba en la pantalla cuánto le dará su banco después de seis meses si pone 2000€ en una cuenta a plazo fijo al 2,75% anual. Recuerde que al pagarle los intereses el banco le retendrá el 18% para hacienda.
        double t = 0.5; //medio año
        double Cinicial = 2000; //capital inicial
        double plazoFijo = (2.75/100);
        double hacienda = 0.18;
        double interes, retencion, cfinal;
        //formula del interes simple, interes = Cinicial * plazoFijo * t
        //retencion = interes * 0.18
        // monto final = C + (interesFinal - retencion)
        interes = Cinicial * plazoFijo * t;
        retencion = interes * hacienda;
        cfinal = Cinicial + (interes - retencion);
        System.out.println("El Monto final obtenido después de 6 meses sería de: "+ cfinal);



    }
}
