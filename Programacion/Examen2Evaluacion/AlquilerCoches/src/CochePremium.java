public class CochePremium extends Coche{

    //atributos
    private boolean gps;
    private boolean seguroExtra;

    //constructor

    public CochePremium(long id, String marca, String modelo, String matricula, int year, TipoCombustible combustible, TipoCoche tipo, Double precioBase, boolean gps, boolean seguroExtra) {
        super(id, marca, modelo, matricula, year, combustible, tipo, precioBase);
        this.setTipo(TipoCoche.DEPORTIVO);
        this.gps = gps;
        this.seguroExtra = seguroExtra;
    }

    //getters y setters

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isSeguroExtra() {
        return seguroExtra;
    }

    public void setSeguroExtra(boolean seguroExtra) {
        this.seguroExtra = seguroExtra;
    }


    //metodos

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CochePremium{");
        sb.append("id=").append(super.getId());
        sb.append(", marca='").append(super.getMarca()).append('\'');
        sb.append(", modelo='").append(super.getModelo()).append('\'');
        sb.append(", matricula='").append(super.getMatricula()).append('\'');
        sb.append(", year=").append(super.getYear());
        sb.append(", combustible=").append(super.getCombustible());
        sb.append(", tipo=").append(super.getTipo());
        sb.append(", precioBase=").append(super.getPrecioBase());
        sb.append(", disponible=").append(super.isDisponible()).append(' ');
        sb.append("gps=").append(gps);
        sb.append(", seguroExtra=").append(seguroExtra);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        double precioTotal = ((this.getPrecioBase() * 1.2) * dias);
        if (isGps()){
            precioTotal = precioTotal + (10 * dias);
        } if (isSeguroExtra()){
            precioTotal = precioTotal + (15 * dias);
        }
        return precioTotal;
    }
}
