package Programacion.Tema7.Practica2Streams.SensoresPlantacion;

import java.time.LocalDateTime;
import java.util.List;

public class Registro {
    private LocalDateTime fechaHora;
    private Double temperatura;
    private Double humedad;

    public Registro(LocalDateTime fechaHora, Double temperatura, Double humedad) {
        this.fechaHora = fechaHora;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getHumedad() {
        return humedad;
    }

    public void setHumedad(Double humedad) {
        this.humedad = humedad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Registro{");
        sb.append("fechaHora=").append(fechaHora);
        sb.append(", temperatura=").append(temperatura);
        sb.append(", humedad=").append(humedad);
        sb.append('}');
        return sb.toString();
    }
}
