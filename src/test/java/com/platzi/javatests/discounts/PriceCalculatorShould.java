package com.platzi.javatests.discounts;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PriceCalculatorShould {

    @Test
    public void total_zer_when_there_are_prices() {

        PriceCalculator priceCalculator = new PriceCalculator();
        assertThat(priceCalculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {
        PriceCalculator priceCalculator = new PriceCalculator();

        priceCalculator.addPrice(10.0);
        priceCalculator.addPrice(15.0);
        assertThat(priceCalculator.getTotal(), is(25.0));
    }

    @Test
    public void apply_discount_to_prices() {
        PriceCalculator priceCalculator = new PriceCalculator();

        priceCalculator.addPrice(9.0);
        priceCalculator.addPrice(12.0);
        priceCalculator.setDiscount(50);
        assertThat(priceCalculator.getTotal(), is(21.0));
    }
}