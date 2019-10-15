package price;

public final class PriceCalculatorFactory {

    public static PriceCalculator getPriceCalculator(final String productCode) {
        PriceCalculator priceCalculator;
        if (productCode.startsWith("DIS10")) {
            priceCalculator = new PriceForProductWithCodeDiscount10();
        } else if (productCode.startsWith("DIS20")) {
            priceCalculator = new PriceForProductWithCodeDiscount20();
        } else {
            throw new IllegalArgumentException("invalid product code:" + productCode);
        }
        return priceCalculator;
    }

}
