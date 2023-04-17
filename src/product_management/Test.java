package product_management;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "T-shirt", 199000));
        list.add(new Product(2, "Jeans", 399000));
        list.add(new Product(3, "Belt", 299000));
        list.add(new Product(4, "Coat", 599000));
        list.add(new Product(5, "Shoes", 1899000));
        productManager.addProduct(list);
        System.out.println("Before sorting");
        productManager.showProductList();
        System.out.println("After descending sorting");
        productManager.sortProductByPriceDescending();
        productManager.showProductList();
        System.out.println("After ascending sorting");
        productManager.sortProductByPriceAscending();
        productManager.showProductList();
    }
}
