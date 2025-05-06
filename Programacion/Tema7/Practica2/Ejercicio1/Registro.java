package Programacion.Tema7.Practica2.Ejercicio1;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;

public class Registro {
    LocalDateTime fechaHora;
    Double temperatura;
    Double humedad;

    //Debes crear una colección de 100 registros (genéralo con un metodo que en un for
    //cree objetos Registro poniendo valores aleatorios de temperatura y humedad, y la fecha le añada un
    //minuto a cada registro

    public void crearRegistro(){

    }

    Collection<Registro> registros = new Collection<Registro>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Registro> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            return null;
        }

        @Override
        public boolean add(Registro registro) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Registro> collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {

        }
    };
}
