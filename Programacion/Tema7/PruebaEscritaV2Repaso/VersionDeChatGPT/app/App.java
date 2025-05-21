package Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.app;
// App.java
import Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.*;
import Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models.DetalleProducto;
import Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models.Producto;
import Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models.ProductoSubasta;
import Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models.Puja;
import Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.services.Productos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Productos catalogo = new Productos();
        catalogo.abrirFromCSV();

        // 1. Productos con precio > 3000€
        System.out.println("Productos con importe > 3000€:");
        catalogo.buscar(p -> p.getImporte() > 3000);

        // 2. Categorías y número de productos
        System.out.println("\nNúmero de productos por categoría:");
        Map<String, Long> totales = catalogo.getProductosTotalPorCategoria();
        totales.forEach((cat, cnt) -> System.out.println(cat + ": " + cnt));

        // 3. Productos ordenados por precio
        System.out.println("\nProductos ordenados por importe:");
        catalogo.getProductosPrecio().forEach(System.out::println);

        // 4. 3 productos más baratos
        System.out.println("\n3 productos más baratos:");
        List<Producto> baratos = catalogo.getProductosPrecio().stream().limit(3).toList();
        baratos.forEach(System.out::println);

        // 5. Crear y añadir producto Subasta
        DetalleProducto det = new DetalleProducto("url","foto","categoria","marca","desc");
        ProductoSubasta subasta = new ProductoSubasta("SKU123", 1000, IVA.GENERAL, det,
                LocalDateTime.now(), LocalDateTime.now().plusDays(7));
        // 6. Realizar 3 pujas
        subasta.pujar(new Puja("cliente1@example.com", 1100, LocalDateTime.now()));
        subasta.pujar(new Puja("cliente2@example.com", 1200, LocalDateTime.now()));
        subasta.pujar(new Puja("cliente3@example.com", 1300, LocalDateTime.now()));

        System.out.println("\nPuja ganadora: " + subasta.getPujaMaxima());
    }
}