package Programacion.Tema4.EjerciciosObjetosPOO.Ejercicio2;

public class Coche {
        private int velocidad;

        public Coche() {
            velocidad = 0;
        }

    public int getVelocidad() {
        return velocidad;
    }

    public void acelera(int mas) {
            velocidad += mas;
    }
    public void frena(int menos) {
            velocidad -= menos;
    }
}
