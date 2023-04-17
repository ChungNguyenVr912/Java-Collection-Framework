package product_management;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }
    public void addProduct(List<Product> products) {
        productList.addAll(products);
    }

    public Product getProductById(int productId) {
        for (Product product : productList) {
            if (product.getPrice() == productId) {
                return product;
            }
        }
        throw new RuntimeException("Invalid ID!");
    }
    public boolean removeProduct(int productId){
        for (Product product : productList) {
            if (product.getPrice() == productId) {
                productList.remove(product);
                return true;
            }
        }
        return false;
    }
    public void showProductList(){
        productList.forEach(System.out::println);
    }
    public Product getProductByName(String productName) {
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new RuntimeException("Invalid Name!");
    }
    public void sortProductByPriceDescending(){
        DescendingProductPriceComparator descendingProductPriceComparator = new DescendingProductPriceComparator();
        productList.sort(descendingProductPriceComparator);
    }
    public void sortProductByPriceAscending(){
        AscendingProductPriceComparator ascendingProductPriceComparator = new AscendingProductPriceComparator();
        productList.sort(ascendingProductPriceComparator);
    }
}
