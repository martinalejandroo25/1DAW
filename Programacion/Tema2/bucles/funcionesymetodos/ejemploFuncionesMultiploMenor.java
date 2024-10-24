package Programacion.Tema2.bucles.funcionesymetodos;

import java.util.Scanner;

public class ejemploFuncionesMultiploMenor {
    public static boolean multiplo (int a, int b){
        return a % b == 0;
    }

    public static void main(String[] args) {
        //Pinta todos los multiplos de un numero
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero: ");
        num = Integer.parseInt(sc.nextLine());
        for (int i = num; i <=num ; i--) {
            if (multiplo(num,i) == true){
                System.out.println(i);
            }
        }
    }

}
