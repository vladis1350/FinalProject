package com.vladis1350.validate;

import com.vladis1350.bean.Product;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testValidateNameShouldReturnTrue() {
        boolean actualTrue = ProductValidator.validateName("ugii");
        boolean actualFalse = ProductValidator.validateName("ug");
        boolean actualFalseTwo = ProductValidator.validateName("");
        boolean actualFalseThree = ProductValidator.validateName("sdfsdfsdvfadgsdbgafdhfdhdfhdfhfdhfdhfdhfdhfdhfdhdfhfdhfdhfdhfdh");

        Assert.assertEquals(true, actualTrue);
        Assert.assertEquals(false, actualFalse);
        Assert.assertEquals(false, actualFalseTwo);
        Assert.assertEquals(false, actualFalseTwo);
    }

    @Test
    void testValidatePriceShouldReturnFalse() {
        boolean actualFalseOne = ProductValidator.validatePrice(new BigDecimal(0));
        boolean actualFalseTwo = ProductValidator.validatePrice(new BigDecimal(-26));
        boolean actualTrueThree = ProductValidator.validatePrice(new BigDecimal(13.2));

        Assert.assertEquals(false, actualFalseOne);
        Assert.assertEquals(false, actualFalseTwo);
        Assert.assertNotEquals(false, actualTrueThree);
    }

    @Test
    void testValidateDiscountShouldReturnFalse(){
        boolean actualTrueOne = ProductValidator.validateDiscount(new BigDecimal(0));
        boolean actualFalseTwo = ProductValidator.validateDiscount(new BigDecimal(-26));
        boolean actualTrueThree = ProductValidator.validateDiscount(new BigDecimal(13.2));
        boolean actualFalseFour = ProductValidator.validateDiscount(new BigDecimal(101));

        Assert.assertEquals(true, actualTrueOne);
        Assert.assertEquals(false, actualFalseTwo);
        Assert.assertNotEquals(false, actualTrueThree);
        Assert.assertEquals(false, actualFalseFour);
    }

    @Test
    void testShouldCheckValidateDataProduct() {
        boolean actualResultTestOne = ProductValidator.checkValidateDataProduct(new Product());
        boolean actualResultTestTwo = ProductValidator.checkValidateDataProduct(
                new Product("Milk", new BigDecimal(13.2), "Milk products", new BigDecimal(20)));
        boolean actualResultTestThree = ProductValidator.checkValidateDataProduct(
                new Product("Co", new BigDecimal(13.2), "Milk products", new BigDecimal(20)));
        boolean actualResultTestFour = ProductValidator.checkValidateDataProduct(
                new Product("Coffe", new BigDecimal(-3), "Milk products", new BigDecimal(20)));
        boolean actualResultTestFive = ProductValidator.checkValidateDataProduct(
                new Product("Coffe", new BigDecimal(12.2), "Milk products", new BigDecimal(150)));


        Assert.assertEquals(false, actualResultTestOne);
        Assert.assertEquals(true, actualResultTestTwo);
        Assert.assertEquals(false, actualResultTestThree);
        Assert.assertEquals(false, actualResultTestFour);
        Assert.assertEquals(false, actualResultTestFive);
    }
}