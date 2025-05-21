package Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.services;// Productos.java
import Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
        import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Productos {
    private List<Producto> productos = new ArrayList<>();

    public void abrirFromCSV() {
        cargarCSV("productos_base.csv", true);
        cargarCSV("productos_virtual.csv", false);
    }

    private void cargarCSV(String nombreFichero, boolean esBase) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(nombreFichero))) {
            String linea = br.readLine(); // cabecera
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                // campos comunes: sku,precioBase,iva,url,foto,categorias,marca,descripcion
                DetalleProducto det = new DetalleProducto(campos[3], campos[4], campos[5], campos[6], campos[7]);
                if (esBase) {
                    double largo = Double.parseDouble(campos[8]);
                    double ancho = Double.parseDouble(campos[9]);
                    double alto = Double.parseDouble(campos[10]);
                    double peso = Double.parseDouble(campos[11]);
                    boolean esRegalo = Boolean.parseBoolean(campos[12]);
                    productos.add(new ProductoBase(campos[0], Double.parseDouble(campos[1]),
                            IVA.valueOf(campos[2]), det, largo, ancho, alto, peso, esRegalo));
                } else {
                    long pesoBytes = Long.parseLong(campos[8]);
                    String urlDescarga = campos[9];
                    TipoVirtual tipo = TipoVirtual.valueOf(campos[10]);
                    productos.add(new ProductoVirtual(campos[0], Double.parseDouble(campos[1]),
                            IVA.valueOf(campos[2]), det, pesoBytes, urlDescarga, tipo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buscar(Predicate<Producto> criterio) {
        productos.stream().filter(criterio).forEach(System.out::println);
    }

    public Producto getProducto(String sku) {
        return productos.stream()
                .filter(p -> p.getSku().equals(sku))
                .findFirst().orElse(null);
    }

    public List<Producto> getProductosSubasta() {
        return productos.stream()
                .filter(p -> p instanceof ProductoSubasta)
                .collect(Collectors.toList());
    }

    public List<Producto> getProductosPrecio() {
        return productos.stream()
                .sorted(Comparator.comparingDouble(Producto::getImporte))
                .collect(Collectors.toList());
    }

    public Map<String, List<Producto>> getProductosPorCategoria() {
        return productos.stream()
                .collect(Collectors.groupingBy(p -> p.getDetalleProducto().getCategorias(),
                        Collectors.collectingAndThen(Collectors.toList(), lista -> {
                            lista.sort(Comparator.comparing(Producto::getSku).reversed());
                            return lista;
                        })));
    }

    public Map<String, Long> getProductosTotalPorCategoria() {
        return productos.stream()
                .collect(Collectors.groupingBy(p -> p.getDetalleProducto().getCategorias(),
                        Collectors.counting()));
    }
}
