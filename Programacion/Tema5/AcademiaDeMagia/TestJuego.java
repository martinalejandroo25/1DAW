package tema5.academiaMagia;

public class TestJuego {
    public static void main(String[] args) {

        //Crear mago y tres hechizos
        Mago gandalf = new Mago("Gandalf", 100);
        Hechizo h1 = new Hechizo("Bola de fuego", 4, 40);
        Hechizo h2 = new Hechizo("Escudo mágico", 15, 90);
        Hechizo h3 = new Hechizo("Rayo eléctrico", 5, 30);

        //Añadir hechizos al mago
        gandalf.aprenderHechizo(h1);
        gandalf.aprenderHechizo(h2);
        gandalf.aprenderHechizo(h3);

        //Crear tres pruebas
        Prueba pr1 = new Prueba("Romper muro", 10, 5);
        Prueba pr2 = new Prueba("Lucha contra orco", 15, 8);
        Prueba pr3 = new Prueba("Lucha contra elfo oscuro", 20, 10);

        //Superar pruebas
        try {
            System.out.println("El mago usa Bola de fuego contra " + pr1.getDescripcion());
            gandalf.lanzarHechizo("bola de fuego", pr1);
            System.out.println("Superada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("El mago usa Rayo eléctrico contra " + pr2.getDescripcion());
            gandalf.lanzarHechizo("rayo eléctrico", pr2);
            System.out.println("Superada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("El mago usa Escudo mágico contra " + pr3.getDescripcion());
            gandalf.lanzarHechizo("escudo mágico", pr3);
            System.out.println("Superada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(gandalf);





    }
}