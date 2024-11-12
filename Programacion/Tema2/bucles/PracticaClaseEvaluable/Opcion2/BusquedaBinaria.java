package Programacion.Tema2.bucles.PracticaClaseEvaluable.Opcion2;

import java.util.Scanner;

public class BusquedaBinaria {
    //El usuario piensa un número, y el programa debe averiguarlo. Pide al usuario que piense un
    //número entre el 1 y el 100. El programa mostrará un número por pantalla y preguntará al
    //usuario si el número que ha pensado es menor, igual o mayor al número mostrado. Este
    //proceso lo repetirá hasta encontrar el número que ha pensado el usuario. Al finalizar el
    //proceso, mostrará el número de intentos probados hasta encontrar el número.
    public static int generarnumAleatorio(int menor, int mayor) {
        int numero = (int) (Math.random() * (menor - mayor) + mayor);
        return numero;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero=0;
        int intentos = 0;
        int menor = 1;
        int mayor = 100;
        System.out.println("Piensa en un numero del 1 al 100 ");
           numero= generarnumAleatorio(1,100);
        System.out.println("Estoy pensando en el "+ numero+", ¿Es correcto? si/no");
        String sino = sc.nextLine().toLowerCase();
        System.out.println(sino);
        while(sino.equals("no")){
            System.out.println("De acuerdo, ¿tu numero es menor o mayor al "+numero+" ?");
            String masmenos = sc.nextLine().toLowerCase();
            if (masmenos.equals("menor")){
                mayor = numero + 1;
                numero= generarnumAleatorio(menor,mayor);
                System.out.println("Estoy pensando en el "+ numero+", ¿Es correcto? si/no");
                sino = sc.nextLine().toLowerCase();
                intentos++;
            } else if (masmenos.equals("mayor")) {
                menor = numero - 1;
                numero = generarnumAleatorio(mayor,menor);
                System.out.println("Estoy pensando en el "+ numero+", ¿Es correcto? si/no");
                sino = sc.nextLine().toLowerCase();
                intentos++;
            }
        }
        System.out.println("Genial, lo he encontrado!!"+ " He necesitado "+intentos+" intentos");
    }

}
