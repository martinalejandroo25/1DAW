import java.time.LocalDate;
import java.util.ArrayList;

public class Agencia {
    //atributos
    private ArrayList<Coche> coches;
    private ArrayList<Alquiler> alquileres;

    //constructores
    public Agencia() {
        this.coches = new ArrayList<>();
        this.alquileres = new ArrayList<>();
    }

    //metodos

    public void addCoche(Coche c){
        coches.add(c);
    }
    public void removeCoche(Coche c){
        coches.remove(c);
    }

    //Si coche isDisponible es True, imprime coche
    public void listarCochesDisponibles(){
        for (Coche coche : coches)  {
            if (coche.isDisponible()){
                System.out.println(coche);
            }
        }
    }
    //si la fechaFin es Después de Hoy, imprime el Alquiler
    public void listarAlquileresActivos(){
        for(Alquiler al : alquileres){
            if (al.getFechaFin().isAfter(LocalDate.now())){
                System.out.println(al);
            }
        }
    }


    //Dado un Tipo de coche se busca el primer coche de ese tipo disponible
    public Coche buscarCocheDisponible(TipoCoche Tipo) throws NoHayCochesDisponibles{
        for (Coche co : coches){
         if (co.getTipo().equals(Tipo)){
             return co;
         };
     }
        return null;
    }



    //si el metodo buscarCocheDisponible devuelve null(no hay coche) devolverá false
    //si es distinto de null, cambiará la disponibilidad a false y añadirá el Coche al inventario de alquileres
    public boolean realizarAlquiler(Cliente cliente, TipoCoche tipo, LocalDate fechaInicio, LocalDate fechaFin) {
        if (buscarCocheDisponible(tipo) != null){
            Coche co = buscarCocheDisponible(tipo);
            co.setDisponible(false);
            alquileres.add(new Alquiler(cliente, co, fechaInicio, fechaFin));
            return true;
        }
        return false;
    }
}
