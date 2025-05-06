package Programacion.Tema7.EjerciciosTema7_1.Ejercicio1;

import java.util.Objects;

public class Entrada {
    private String spanish;
    private String english;

    public Entrada(String spanish, String english) {
        this.spanish = spanish;
        this.english = english;
    }

    public String getSpanish() {
        return spanish;
    }

    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entrada{");
        sb.append("spanish='").append(spanish).append('\'');
        sb.append(", english='").append(english).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return Objects.equals(spanish, entrada.spanish);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(spanish);
    }
}
