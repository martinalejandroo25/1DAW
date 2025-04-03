package Programacion.Tema7.HobbiesTreeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Hobbie {
 //Crear la Clase Principal (GestionHobbies):
    //
    //    Declarar un atributo TreeMap<Persona, List<String>> para guardar los hobbies.
    //    Crear el constructor para inicializar el TreeMap.

    TreeMap<Persona, List<String>> Hobbies;

    public Hobbie() {
        Hobbies = new TreeMap<>();
    }

    // realizar metodo addPersona
    public void addPersona(Persona p){
        List<String> hobbies = Hobbies.getOrDefault(p, new ArrayList<>());
        hobbies.add("..."); // Añadir un nuevo hobby a la persona
        Hobbies.put(p, hobbies);

    }

    public void removePersona(Persona p){
        Hobbies.remove(p);
    }

}
