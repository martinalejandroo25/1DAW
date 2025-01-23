package Programacion.Tema4.EjerciciosObjetosPOO.Ejercicio4;

public class Finanzas {
    /*Realiza una clase Finanzas que convierta dólares a euros y viceversa. Como propiedad se almacena únicamente el
cambio dólar-euro, no se almacena una cantidad sino el tipo de cambio. Codifica los métodos
dolaresToEuros(double dolares) y eurosToDolares(double euros). Prueba que dicha clase funciona
correctamente haciendo conversiones entre euros y dólares. La clase debe tener:
- Un constructor Finanzas() por defecto el cual establecerá el cambio dólar-euro en 1.36.
- Un constructor Finanzas(double), el cual permitirá configurar el cambio dólar-euro.
- Getters y setters
Prueba la clase en otra clase TestFinanzas*/
    Double cambiodolarEuro;

    public Finanzas() {
        this.cambiodolarEuro = 1.36;
    }
    public Finanzas(Double cambiodolarEuro) {
        this.cambiodolarEuro = cambiodolarEuro;
    }

    public Double getCambiodolarEuro() {
        return cambiodolarEuro;
    }

    public void setCambiodolarEuro(Double cambiodolarEuro) {
        this.cambiodolarEuro = cambiodolarEuro;
    }

   public double dolaresToEuros(double dolares){
    return (dolares * getCambiodolarEuro());
    }
    public double eurosToDolares(double euros) {
        return euros / getCambiodolarEuro();

    }


}
