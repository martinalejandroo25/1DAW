package Programacion.Tema5.BladeOfDarkness;

public class Jugador extends Personaje{
    private enum clase{MAGO, BRUJO, BARBARO, CABALLERO}
    private int experiencia;
    private Arma armaDerecha;
    private Arma armaIzquierda;

    public Jugador(String nombre, int nivel, double salud  ) {
        super(nombre, nivel,salud);
        this.experiencia=0;
        this.armaDerecha=null;
        this.armaIzquierda=null;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Arma getArmaDerecha() {
        return armaDerecha;
    }

    public void setArmaDerecha(Arma armaDerecha) {
        this.armaDerecha = armaDerecha;
    }

    public Arma getArmaIzquierda() {
        return armaIzquierda;
    }

    public void setArmaIzquierda(Arma armaIzquierda) {
        this.armaIzquierda = armaIzquierda;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jugador{");
        sb.append("experiencia=").append(experiencia);
        sb.append(", armaDerecha=").append(armaDerecha);
        sb.append(", armaIzquierda=").append(armaIzquierda);
        sb.append('}');
        return sb.toString();
    }

    public boolean equiparArma(Arma arma){
        if (armaDerecha==null){
            armaDerecha=arma;
            return true;
        } else if (armaIzquierda==null) {
            armaIzquierda=arma;
            return true;
        } else if (arma.isDosManos() && armaIzquierda==null && armaDerecha==null) {
            armaIzquierda=arma;
            armaDerecha=arma;
            return true;
        } else {
            System.out.println("Ya estas cargado, no puedes llevar más armas");
             return false;
            }
        }

        public void tomarPocion(int puntosS){
            Personaje.getSalud()+=puntosS;
            if (salud>10000){
                salud=10000;
            }
        }



        public void golpear(Monstruo monstruo) throws Exception {

            if (getSalud() <= 0) {
                throw new Exception("El jugador fallecido no puede atacar");
            }
            else {
            //comprobar si has matado al monstruo
            //Subir la experiencia y el nivel si corresponde
                if(monstruo.getSalud() <= 0) {
                    System.out.println("Monstruo derrotado, sumas experiencia!!");
                    experiencia = 10 * monstruo.getNivel();
                    nivel = experiencia / 100;
                    if (experiencia >= 1000) {
                        experiencia = 1000;
                        nivel = 10;
                        System.out.println("Nivel y Experiencia máximos alcanzado");
                    }
                }
            }
        }
}
