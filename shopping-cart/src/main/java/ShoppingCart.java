import model.Product;

import java.util.List;

public class ShoppingCart {

    private List<Product> products;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }


    public double getTotalCost() {
        return products.stream()
                .map(product -> product.getPrice())
                .reduce(0.0, (totPrice, price) -> totPrice + price);
    }

    public int getTotalLoyalty() {
        return products.stream()
                .mapToInt(product -> product.getLoyalty())
                .sum();
    }

    public int size() {
        return products.size();
    }

    public void removeProduct(String productId) {
        products.removeIf(p -> p.getProductId().equals(productId));
    }
}
