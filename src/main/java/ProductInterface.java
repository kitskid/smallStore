import java.math.BigDecimal;

public interface ProductInterface {
    void sale(); // продукт может быть продасться
    void delivery(); // продукт может доставляться
    void returnProduct(); // возврат товара

    public ProductCategory getProductCategory();


    public void setProductCategory(ProductCategory productCategory);

    public String getNameOfProduct();

    public void setNameOfProduct(String nameOfProduct);

    public String getDescriptionOfProduct();

    public void setDescriptionOfProduct(String descriptionOfProduct);

    public BigDecimal getPrice();

    public void setPrice(BigDecimal price);

    public int getId();

}
