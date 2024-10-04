package Programacion.Tema1.EjerciciosPDF;

public class Ejercicio16 {
    public static void main(String[] args) {
        //Escriba un programa para calcular el área y el volumen de un cilindro. Para ello declare una constante que guarde el valor de Pi. Declare, también, variables para el diámetro y la altura del cilindro. Suponga para el ejemplo que el cilindro tiene un diámetro de 15,5cm y una altura de 42,4cm.
        double area, volumen;
        double diametro = 15.5;
        double radio = diametro / 2;
        double altura = 42.4;
        area = Math.PI * radio * altura;
        volumen = Math.PI * Math.pow(radio, 2) * altura;

        System.out.println("El area del cilindro es de: "+area+"cm");
        System.out.println("El volumen del cilindro es de: "+volumen+"cm");
    }
}
