package Programacion.Tema4.EjerciciosObjetosPOO.Ejercicio3;

public class Pajaro {
    public void setedad(int e) { edad=e;} //le da una edad
    public void printedad() { // pinta la edad del pajaro
        System.out.println(edad);
    }
    public void setcolor(char c) { color=c;} //aplica un color al pajaro

    public void printcolor(){
        System.out.println(color);
    }
    private int edad;
    private char color;
}
