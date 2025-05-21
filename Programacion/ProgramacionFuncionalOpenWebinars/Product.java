package Programacion.ProgramacionFuncionalOpenWebinars;

public class  Product{

    private String sku;
    private String name;
    private Double price;
    private boolean discount;

    public Product() {
    }

    public Product(String sku, String name, Double price, boolean discount) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("sku='").append(sku).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", discount=").append(discount);
        sb.append('}');
        return sb.toString();
    }
}