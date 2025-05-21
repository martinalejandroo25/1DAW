package Programacion.Tema7.Practica2Streams.BancoSmart;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cuenta {

    private UUID id;
    private Cliente propietario;
    private Double saldo; // (se actualiza al registrar transacciones)
    private List<Transaccion> transacciones;

    public Cuenta(Cliente propietario) {
        this.id = UUID.randomUUID();
        this.propietario = propietario;
        this.saldo = 0.0;
        this.transacciones = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public void addTransaccion(Transaccion t){
        transacciones.add(t);
    }
}