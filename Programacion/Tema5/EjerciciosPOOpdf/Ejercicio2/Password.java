package Programacion.Tema5.EjerciciosPOOpdf.Ejercicio2;

public class Password {
    private Integer longitud;
    private String password;

    //CONSTRUCTORES

    //constructor por defecto
    public Password() {
        this.longitud = 8;
        this.password = generarPassword();
    }

    //constructor con longitud y password
    public Password(Integer longitud) {
        this.longitud = longitud;
        this.password = generarPassword();
    }

    //constructor copia
    public Password(Password copia) {
        this.longitud = copia.longitud;
        this.password = copia.password;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public String getPassword() {
        return password;
    }

    //MÉTODOS

    //esFuerte indica si la contraseña es fuerte
    public boolean esFuerte() {
        int contaMayusculas = 0;
        int contaMinusculas = 0;
        int contaNumeros = 0;
        int contaCaracteresEspeciales = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
            contaMayusculas++;
            }
            if (Character.isLowerCase(c)) {
                contaMinusculas++;
            }
            if (Character.isDigit(c)) {
                contaNumeros++;
            }
            if (!Character.isLetterOrDigit(c)) {
                contaCaracteresEspeciales++;
            }
        }
        return (password.length() >= 8 && contaMayusculas > 0 && contaMinusculas > 1 && contaNumeros > 1 && contaCaracteresEspeciales > 0);
    }
    public String generarPassword() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+=-{}[]|:;<>,.?/";
        StringBuilder sb = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            int index = (int) (Math.random() * caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Password{");
        sb.append("longitud=").append(longitud);
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
