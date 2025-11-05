package Tienda;

import java.util.List;

public interface Producto
{
    //Métodos a implementar:

    String getCodigo();
    String getNombre();
    String getInfo(); // Devuelve información detallada
    double getPrecio();
    int getStock();
    void descontarStock(int cantidad);
    void setStock(Integer stock); // Cambia el stock del producto
    void setPrecio(double precio); // Cambia el precio del producto
}
