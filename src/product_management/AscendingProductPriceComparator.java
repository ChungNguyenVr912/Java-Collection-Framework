package product_management;

import java.util.Comparator;

public class AscendingProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return (int) (product1.getPrice() - product2.getPrice());
    }
}
