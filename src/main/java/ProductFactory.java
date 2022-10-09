import java.math.BigDecimal;

public class ProductFactory {
    private static ProductFactory instance;
    public static ProductFactory getInstance() {
        if (instance == null) {
            instance = new ProductFactory();
        }
        return instance;
    }
    public Product getProduct(int id, ProductCategory productCategory, String nameOfProduct, String descriptionOfProduct, BigDecimal price) {
        Product product = null;

        switch (productCategory) {

            case TOYS -> product = new TOYS(id, nameOfProduct, descriptionOfProduct, price);
            case COMPUTERS -> product = new COMPUTERS(id, nameOfProduct, descriptionOfProduct, price);
            case FURNITURE -> product = new FURNITURE(id, nameOfProduct, descriptionOfProduct, price);
        }
        return product;
    }
    private ProductFactory() {

    }
}
