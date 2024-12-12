package Programacion.Examen1Evaluacion;

import java.util.Scanner;

public class Ejercicio3 {
    /* Codificador de mensajes
Crea un metodo en Java que tome una frase como parámetro y aplique varias
transformaciones para codificar un mensaje de salida según las siguientes reglas:
a. Primera letra al final: Mueve la primera letra de cada palabra al final de la palabra.
b. Reemplazo de vocales: Reemplaza las vocales de la palabra con caracteres
especiales: a -> @, e -> &, i -> $, o -> o, u -> #.
c. Invertir cada palabra: Si la longitud de la palabra es impar, invierte la palabra
resultante antes de añadirla al mensaje codificado.
Realiza otro metodo para desencriptar el mensaje y comprueba que funciona
desencriptando el mismo mensaje encriptado, y viendo que el resultado es el original.*/
    public static void main(String[] args) {
        String mensaje;
        Scanner sc = new Scanner(System.in);
        System.out.println("Cual es el mensaje a codificar?:");
        mensaje = sc.nextLine();
        StringBuffer sb = new StringBuffer(mensaje);
        System.out.println("El mensaje original es: "+mensaje);
        System.out.println("El mensaje codificado quedaría de la siguiente forma: ");
        System.out.println(codificar(sb));
    }

    public static String codificar(StringBuffer frase) {
        //Primera letra al final: Mueve la primera letra de cada palabra al final de la palabra
        //Solucionar luego
        String[] palabras = frase.toString().split("");
        for (int i = 0; i < palabras.length; i++) {
            char letra = palabras[i].charAt(0);
            palabras[i] = palabras[i].substring(1) + letra;
        }
        //Reemplazo de vocales: Reemplaza las vocales de la palabra con caracteres especiales
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equals("a")) {
                palabras[i] = "@"; //a -> @
            } else if (palabras[i].equals("e")) {
                palabras[i] = "&"; //e -> &
            } else if (palabras[i].equals("i")) {
                palabras[i] = "$"; //i -> $
            } else if (palabras[i].equals("o")) {
                palabras[i] = "º"; //o -> º
            } else if (palabras[i].equals("u")) {
                palabras[i] = "#"; //u -> #
            }
        }
        //Invertir cada palabra: Si la longitud de la palabra es impar, invierte la palabra resultante antes de añadirla al mensaje codificado
        for (int i = 0; i < palabras.length; i++) {
            int longitud = palabras[i].length();
            if (longitud % 2!= 0) {
                palabras[i] = new StringBuffer(palabras[i]).reverse().toString();

            }
        }
        return String.join("", palabras);
    }
}
