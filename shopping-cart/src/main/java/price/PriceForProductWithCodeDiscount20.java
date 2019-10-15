package price;

public class PriceForProductWithCodeDiscount20 extends PriceCalculator {
    @Override
    public double getDiscount(double grossPrice) {
        return grossPrice * 0.20;
    }
}
