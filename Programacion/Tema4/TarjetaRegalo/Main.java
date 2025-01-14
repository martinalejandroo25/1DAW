package Programacion.Tema4.TarjetaRegalo;

public class Main {
    public static void main(String[] args) {
        TarjetaRegalo tarjeta1 = new TarjetaRegalo(123456890, 1000, 50);
        TarjetaRegalo tarjeta2 = new TarjetaRegalo(987653210, 500, 30);

        tarjeta1.fusionarTarjeta(tarjeta2);

        System.out.println(tarjeta1);
        System.out.println(tarjeta2);
    }

}
