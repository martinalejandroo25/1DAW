package Tienda;

public abstract class ProductoBase implements Producto{
    private String codigo;
    private String nombre;
    private Double precio;
    private Integer stock;

    public ProductoBase(String codigo, String nombre, Double precio, Integer stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public ProductoBase(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public abstract String getInfo();
    public void descontarStock(int cantidad) {
        if(stock >= cantidad){
            stock -= cantidad;
        } else {
            System.out.println("No hay suficiente stock");
        }
    };

}
