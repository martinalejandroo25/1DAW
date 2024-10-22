package Programacion.Tema2.bucles;

import java.util.Scanner;

public class EjercicioBucle {
    public static void main(String[] args) {
        /*
        * Hay que pedir numeros hasta que introduzcamos el cero.
        * El resultado es la suma y la media de los numeros introducidos
        * Acumulador(la suma) y contador (El total de numeros introducidos, sin el cero final)

        * 6,7,10,11,1 --> Suma = 35, Media = 35/5
        * * */

        //VARIABLES
        int num= -1, suma=0, media=0, conta=0;
        Scanner sc = new Scanner(System.in);



        while(num !=0){
            System.out.println("Introduce el numero");
            num = Integer.parseInt(sc.nextLine());
            if(num !=0) {
                conta++;
                suma = suma + num;
            }
        }
        media = suma / conta;
        System.out.println(suma);
        System.out.println(media);
        System.out.println(conta);

    }
}
