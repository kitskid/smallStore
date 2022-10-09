import java.math.BigDecimal;

public class TOYS extends Product implements ProductInterface  {

    private ProductCategory productCategory;
    private String nameOfProduct;
    private String descriptionOfProduct;
    private BigDecimal price;
    private int id;

    public TOYS(int id, String nameOfProduct, String descriptionOfProduct, BigDecimal price) {
        this.id = id;
        this.productCategory = ProductCategory.TOYS;
        this.nameOfProduct = nameOfProduct;
        this.descriptionOfProduct = descriptionOfProduct;
        this.price = price;
    }

    @Override
    public void sale() {
        System.out.println("Продажа TOYS");
    }

    @Override
    public void delivery() {
        System.out.println("Доставка TOYS");
    }

    @Override
    public void returnProduct() {
        System.out.println("Возврат TOYS");
    }
    @Override
    public int getId() {
        return id;
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
}
