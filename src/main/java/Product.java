import java.math.BigDecimal;

public class Product {

    private ProductCategory productCategory;
    private String nameOfProduct;
    private String descriptionOfProduct;
    private BigDecimal price;
    private int id;

    public Product(int id, ProductCategory productCategory, String nameOfProduct, String descriptionOfProduct, BigDecimal price) {
        this.id = id;
        this.productCategory = productCategory;
        this.nameOfProduct = nameOfProduct;
        this.descriptionOfProduct = descriptionOfProduct;
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getDescriptionOfProduct() {
        return descriptionOfProduct;
    }

    public void setDescriptionOfProduct(String descriptionOfProduct) {
        this.descriptionOfProduct = descriptionOfProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }
}
