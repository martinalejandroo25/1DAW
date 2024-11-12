import java.util.Scanner;

public class CircunferenciaRadio {
    public static void main(String[] args) {
        //dado el radio obtener la longitud y circunferencia

        //definicion de variables
        Scanner sc = new Scanner(System.in);
        System.out.println("Para obtener el area y perimetro escriba el radio");
        int radio =  sc.nextInt();
        double area, perimetro;

        //Calcular la longitud
        area = Math.PI * Math.pow(radio, 2);
        perimetro= 2*Math.PI*radio;

        //Imprimir en pantalla
        System.out.println("El area del radio es: " + area);
        System.out.println("El perimetro del radio es: " + perimetro);
    }
}
