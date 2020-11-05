package citrus.steps;

import citrus.pages.ProductPage;
import static org.testng.Assert.*;
import io.qameta.allure.Step;

import java.util.ArrayList;

public class ProductPageStep {
    ProductPage productPage = new ProductPage();
    int productPrice;
    @Step("Add product to Basket")
    public int addProductToBasket() {
        productPrice = Integer.parseInt(productPage.getProductPrice().replaceAll(" ", ""));
        productPage.clickBuyButton()
                .checkVisibleOfBasket();
        return productPrice;
    }
    @Step("Verify content in basket")
    public void assertProductEquals(String productName) {
        assertEquals(productPage.verifyCountOfProductInBasket(), 1);
        assertTrue(productPage.checkProductNameInBasket(productName), productName);
        assertEquals(productPage.getProductPriceInBasket(), productPrice);
        assertEquals(productPage.getTotalPriceInBasket(), productPrice);
    }

    @Step("Verify content in basket on list")
    public void assertProductEqualsOnList(String productName, int productPriceValue) {
        productPage.checkVisibleOfBasket();
        assertEquals(productPage.verifyCountOfProductInBasket(), 1);
        assertTrue(productPage.checkProductNameInBasketOnList(productName));
        assertEquals(productPage.getProductPriceInBasket(), productPriceValue);
        assertEquals(productPage.getTotalPriceInBasket(), productPriceValue);
    }
    @Step("Verify content in basket with two products")
    public void verifyContentInBasketWithTwoProducts(ArrayList<String> productNames, ArrayList<Integer> productPrices) {
        productPage.checkVisibleOfBasket();
        assertEquals(productPage.verifyCountOfProductInBasket(), 2);
        assertTrue(productPage.getProductNameFromListInBasket(0, productNames.get(0)));
        assertTrue(productPage.getProductNameFromListInBasket(1, productNames.get(1)));
        assertEquals(productPage.getProductPriceFromListInBasket(0), productPrices.get(0));
        assertEquals(productPage.getProductPriceFromListInBasket(1), productPrices.get(1));
        assertEquals(productPage.getTotalPriceInBasket(), productPrices.get(0) + productPrices.get(1));

    }

    @Step("Verify content in basket with two products from comparison")
    public void verifyContentInBasketWithTwoProductsFromComparison(ArrayList<String> productNames, ArrayList<Integer> productPrices) {
        productPage.checkVisibleOfBasket();
        assertEquals(productPage.verifyCountOfProductInBasket(), 2);
        assertTrue(productPage.getProductNameFromListInBasket(0, productNames.get(1)));
        assertTrue(productPage.getProductNameFromListInBasket(1, productNames.get(0)));
        assertEquals(productPage.getProductPriceFromListInBasket(0), productPrices.get(0));
        assertEquals(productPage.getProductPriceFromListInBasket(1), productPrices.get(1));
        assertEquals(productPage.getTotalPriceInBasket(), productPrices.get(0) + productPrices.get(1));
    }
}
