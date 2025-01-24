package Programacion.Tema5.EjercicioEqualsCopia;

public class TestTelefonoMovil {
    public static void main(String[] args) {
        TelefonoMovil t1 = new TelefonoMovil("test1", "123456789", "ES", 234.0);
        TelefonoMovil t2 = new TelefonoMovil(t1);
        TelefonoMovil t3 = t1;

        System.out.println(t1.toString());
        System.out.println(t2);
        System.out.println(t3);

        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(t3));
        System.out.println(t1 == t2);
        System.out.println(t1 == t3);

    }
}
