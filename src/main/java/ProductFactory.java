import java.math.BigDecimal;

public class ProductFactory {
    public Product getProduct(int id, ProductCategory productCategory, String nameOfProduct, String descriptionOfProduct, BigDecimal price) {
        Product product = null;
        System.out.println("Зашли в кейс со значением категории:" + productCategory.toString());

        switch (productCategory) {

            case TOYS -> product = new TOYS(id, nameOfProduct, descriptionOfProduct, price);
            case COMPUTERS -> product = new COMPUTERS(id, nameOfProduct, descriptionOfProduct, price);
            case FURNITURE -> product = new FURNITURE(id, nameOfProduct, descriptionOfProduct, price);
        }
        System.out.println(product.getId() + " " + product.getNameOfProduct() + " " + product.getDescriptionOfProduct() + " " + product.getProductCategory() + " " + product.getPrice());
        return product;
    }
}
