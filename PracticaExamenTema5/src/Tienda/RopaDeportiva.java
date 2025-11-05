package Tienda;

public class RopaDeportiva extends ProductoBase{

    private String talla;
    private String material;

    public RopaDeportiva(String codigo, String nombre, Double precio, Integer stock, String talla, String material) {
        super(codigo, nombre, precio, stock);
        this.talla = talla;
        this.material = material;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void descontarStock(int stock) {
        super.descontarStock(stock);
    }

    @Override
    public String getCodigo() {
        return super.getCodigo();
    }

    @Override
    public void setCodigo(String codigo) {
        super.setCodigo(codigo);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public double getPrecio() {
        return super.getPrecio();
    }

    @Override
    public void setPrecio(Double precio) {
        super.setPrecio(precio);
    }

    @Override
    public int getStock() {
        return super.getStock();
    }

    @Override
    public void setStock(Integer stock) {
        super.setStock(stock);
    }



    public String getInfo(){
        return "Codigo: "+ getCodigo() + ", Nombre: "+ getNombre() + ", Talla: " + talla + ", Material: " + material + ", Precio: " + getPrecio() + ", Stock: " + getStock();
    }
    @Override
    public void setPrecio(double precio) {

    }
}
