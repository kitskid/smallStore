import java.math.BigDecimal;

public class COMPUTERS extends Product implements ProductInterface  {

        private ProductCategory productCategory;
        private String nameOfProduct;
        private String descriptionOfProduct;
        private BigDecimal price;
        private int id;

        public COMPUTERS(int id, String nameOfProduct, String descriptionOfProduct, BigDecimal price) {
            this.id = id;
            this.productCategory = ProductCategory.COMPUTERS;
            this.nameOfProduct = nameOfProduct;
            this.descriptionOfProduct = descriptionOfProduct;
            this.price = price;
        }

        @Override
        public void sale() {
            System.out.println("Продажа COMPUTERS");
        }

        @Override
        public void delivery() {
            System.out.println("Доставка COMPUTERS");
        }

        @Override
        public void returnProduct() {
            System.out.println("Возврат COMPUTERS");
        }
}



