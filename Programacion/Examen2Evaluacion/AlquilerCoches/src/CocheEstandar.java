package Programacion.Examen2Evaluacion.AlquilerCoches.src;

public class CocheEstandar extends Coche{
    //atributos
    private boolean aireAcondicionado;


    //constructor

    public CocheEstandar(long id, String marca, String modelo, String matricula, int year, TipoCombustible combustible, TipoCoche tipo, Double precioBase, boolean aireAcondicionado) {
        super(id, marca, modelo, matricula, year, combustible, tipo, precioBase);
        this.setTipo(TipoCoche.SEDAN);
        this.aireAcondicionado = aireAcondicionado;
    }


    //getters y setters

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    //metodos

    @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("\"CocheEstandar{\"");
            sb.append("id=").append(super.getId());
            sb.append(", marca='").append(super.getMarca()).append('\'');
            sb.append(", modelo='").append(super.getModelo()).append('\'');
            sb.append(", matricula='").append(super.getMatricula()).append('\'');
            sb.append(", year=").append(super.getYear());
            sb.append(", combustible=").append(super.getCombustible());
            sb.append(", tipo=").append(super.getTipo());
            sb.append(", precioBase=").append(super.getPrecioBase());
            sb.append(", disponible=").append(super.isDisponible());
        sb.append("aireAcondicionado=").append(aireAcondicionado);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        return this.isDisponible()
                ? (this.getPrecioBase() * dias + (5*dias))
                : (this.getPrecioBase() * dias);
    }
}
