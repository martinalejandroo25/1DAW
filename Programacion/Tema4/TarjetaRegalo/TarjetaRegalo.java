package Programacion.Tema4.TarjetaRegalo;

public class TarjetaRegalo {
    private int numero;
    private double saldo;
    private double gasta;

    public TarjetaRegalo(int numero, double saldo, double gasta) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "TarjetaRegalo{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", gasta=" + gasta +
                '}';
    }

    public void fusionarTarjeta(TarjetaRegalo tr) {
        this.saldo += tr.getSaldo();
        tr.setSaldo(0.0);
    }
}
