package Programacion.Tema7.PruebaEscritaV2Repaso.VersionDeChatGPT.models;// DetalleProducto.java
import java.util.Objects;

public class DetalleProducto {
    private String url;
    private String foto;
    private String categorias;
    private String marca;
    private String descripcion;

    public DetalleProducto(String url, String foto, String categorias, String marca, String descripcion) {
        this.url = url;
        this.foto = foto;
        this.categorias = categorias;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
    public String getCategorias() { return categorias; }
    public void setCategorias(String categorias) { this.categorias = categorias; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "DetalleProducto{" +
                "url='" + url + '\'' +
                ", foto='" + foto + '\'' +
                ", categorias='" + categorias + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleProducto)) return false;
        DetalleProducto that = (DetalleProducto) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(foto, that.foto) &&
                Objects.equals(categorias, that.categorias) &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, foto, categorias, marca, descripcion);
    }
}