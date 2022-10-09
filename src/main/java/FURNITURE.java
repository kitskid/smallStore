import java.math.BigDecimal;

public class FURNITURE extends Product implements ProductInterface {
    private ProductCategory productCategory;
    private String nameOfProduct;
    private String descriptionOfProduct;
    private BigDecimal price;
    private int id;

    public FURNITURE(int id, String nameOfProduct, String descriptionOfProduct, BigDecimal price) {
        this.id = id;
        this.productCategory = ProductCategory.FURNITURE;
        this.nameOfProduct = nameOfProduct;
        this.descriptionOfProduct = descriptionOfProduct;
        this.price = price;
    }

    @Override
    public void sale() {
        System.out.println("Продажа FURNITURE");
    }

    @Override
    public void delivery() {
        System.out.println("Доставка FURNITURE");
    }

    @Override
    public void returnProduct() {
        System.out.println("Возврат FURNITURE");
    }
}
