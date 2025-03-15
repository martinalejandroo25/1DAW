import java.time.LocalDate;

public class Cliente extends Persona{

    //Atributos
    private String licenciaConducir;
    private LocalDate fechaObtencionLicencia;


    //Constructores
    public Cliente(String nombre, String apellido, String dni, String email, String direccion, String telefono, String licenciaConducir, LocalDate fechaObtencionLicencia) {
        super(nombre, apellido, dni, email, direccion, telefono);
        this.licenciaConducir = licenciaConducir;
        this.fechaObtencionLicencia = fechaObtencionLicencia;
    }

    public Cliente (Cliente cliente){
        this.setNombre(cliente.getNombre());
        this.setApellido(cliente.getApellido());
        this.setDni(cliente.getDni());
        this.setEmail(cliente.getEmail());
        this.setDireccion(cliente.getDireccion());
        this.setTelefono(cliente.getTelefono());
        this.setLicenciaConducir(cliente.getLicenciaConducir());
        this.setFechaObtencionLicencia(cliente.getFechaObtencionLicencia());
    }

    public String getLicenciaConducir() {
        return licenciaConducir;
    }

    public void setLicenciaConducir(String licenciaConducir) {
        this.licenciaConducir = licenciaConducir;
    }

    public LocalDate getFechaObtencionLicencia() {
        return fechaObtencionLicencia;
    }

    public void setFechaObtencionLicencia(LocalDate fechaObtencionLicencia) {
        this.fechaObtencionLicencia = fechaObtencionLicencia;
    }
}
