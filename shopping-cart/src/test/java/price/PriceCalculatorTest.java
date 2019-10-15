package price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorTest {

    private PriceCalculator priceCalculator;

    @Test
    void shouldReturnDefaultLoyalty() {
        // given
        priceCalculator = new PriceForProductWithCodeDiscount20();

        // when & then
        assertEquals(1, priceCalculator.getLoyalty());
    }

    @Test
    void shouldReturnDiscountWhenProductCodeIsStartIngWithDiscount10() {
        // given
        priceCalculator = new PriceForProductWithCodeDiscount10();

        // when & then
        assertEquals(10.0, priceCalculator.getDiscount(100.0));
    }

    @Test
    void shouldReturnDiscountWhenProductCodeIsStartIngWithDiscount20() {
        // given
        priceCalculator = new PriceForProductWithCodeDiscount20();

        // when & then
        assertEquals(20.0, priceCalculator.getDiscount(100.0));
    }

    @Test
    void shouldReturnLoyaltyWhenProductCodeIsStartingWithDiscount10() {
        // given
        priceCalculator = new PriceForProductWithCodeDiscount10();

        // when & then
        assertEquals(2, priceCalculator.getLoyalty());
    }
}