package price;

public abstract class PriceCalculator {

    public int getLoyalty() {
        return 1;
    }

    public abstract double getDiscount(double grossPrice);
}
