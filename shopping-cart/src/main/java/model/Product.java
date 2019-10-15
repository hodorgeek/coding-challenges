package model;

import price.PriceCalculator;
import price.PriceCalculatorFactory;

public class Product {

    private String productName;
    private String productCode;

    private String productId;

    private double price;

    private PriceCalculator priceCalculator;

    public Product(String productName, String productCode, String productId, double price) {
        this.productName = productName;
        this.productCode = productCode;
        this.productId = productId;
        this.price = price;
        priceCalculator = PriceCalculatorFactory.getPriceCalculator(productCode);
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price - priceCalculator.getDiscount(price);
    }

    public int getLoyalty() {
        return priceCalculator.getLoyalty();
    }
}
