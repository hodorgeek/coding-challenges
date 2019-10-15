import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart(Collections.emptyList());
    }

    @Test
    public void shouldReturnTotalCostOfCart_WhenThereAreZeroProductInTheCart() {
        assertEquals(0.0, shoppingCart.getTotalCost());
        assertEquals(0.0, shoppingCart.getTotalLoyalty());
    }

    @Test
    public void shouldReturnTotalCostOfCart_WhenTHereAreMoreThanOneProductInTheCart() {
        // given
        Product p1 = new Product("Book", "DIS10", "123", 30.0);
        Product p2 = new Product("Book", "DIS20", "123", 15.0);
        shoppingCart = new ShoppingCart(Arrays.asList(p1, p2));

        // when & then
        assertEquals(39.0, shoppingCart.getTotalCost());
        assertEquals(3, shoppingCart.getTotalLoyalty());
    }

    @Test
    public void shouldBeAbleToAddTheNewProductToCart() {
        // given
        Product p1 = new Product("Book1", "DIS10", "123", 30.0);
        Product p2 = new Product("Book2", "DIS10", "124", 15.0);
        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        shoppingCart = new ShoppingCart(list);
        Product p3 = new Product("Book3", "DIS10", "125", 20.0);

        // when
        shoppingCart.addProduct(p3);

        // then
        assertEquals(3, shoppingCart.size());
    }

    @Test
    public void shouldBeAbleToRemoveAExistingProductFromCart() {
        // given
        Product p1 = new Product("Book1", "DIS10", "123", 30.0);
        Product p2 = new Product("Book2", "DIS20", "124", 15.0);
        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        shoppingCart = new ShoppingCart(list);
        Product p3 = new Product("Book3", "DIS10", "125", 20.0);
        shoppingCart.addProduct(p3);

        // when
        shoppingCart.removeProduct(p3.getProductId());

        // then
        assertEquals(2, shoppingCart.size());
    }
}