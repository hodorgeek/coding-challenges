package price;

public class PriceForProductWithCodeDiscount10 extends PriceCalculator {
    @Override
    public double getDiscount(double grossPrice) {
        return grossPrice * 0.10;
    }

    @Override
    public int getLoyalty() {
        return 2;
    }
}
