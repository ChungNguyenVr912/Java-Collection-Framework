package product_management;

import java.util.Comparator;

public class DescendingProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return (int) (product2.getPrice() - product1.getPrice());
    }
}
