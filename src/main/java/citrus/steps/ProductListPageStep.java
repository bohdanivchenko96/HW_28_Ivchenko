package citrus.steps;

import citrus.pages.ProductListPage;
import io.qameta.allure.Step;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertTrue;

public class ProductListPageStep {

    ProductListPage productListPage = new ProductListPage();

    @Step("Find device by name")
    public void findDeviceByProductName(String productName) {

        productListPage.waitForPageToLoad()
                .closePopUp()
                .findByName(productName);
    }
    @Step("Find product on List by name and save product price")
    public int findProductOnList(String productName) {
        productListPage.waitForPageToLoad()
                .closePopUp()
                .findProductByName(productName);
        return productListPage.findPrice(productName);
    }
    @Step("Add product to basket")
    public void addToBasket() {
        productListPage.clickOnBuyButton();
    }

    @Step("Found two first products on page")
    public ArrayList<String> foundTwoFirstProductsByName(ArrayList<String> productNames) {
        productListPage.waitForPageToLoad()
                .closePopUp();
        productNames.add(productListPage.getProductNamesByIndex(0));
        productNames.add(productListPage.getProductNamesByIndex(1));

        return productNames;
    }
    @Step("add products to basket")
    public void addProductsToBasket() {
        productListPage.addProductToBasketByIndex(0)
                .closeBasketOnProductList()
                .closePopUp()
                .addProductToBasketByIndex(1);
    }

    @Step("Remember Product prices")
    public ArrayList<Integer> saveProductsPrices(ArrayList<Integer> productPrices) {
        productPrices.add(productListPage.getProductPricesByIndex(0));
        productPrices.add(productListPage.getProductPricesByIndex(1));
        return productPrices;
    }

    @Step("Add to comparison")
    public void addToComparison() {
        productListPage.addToCompariosonFromList(0)
                .checkComparisonCount("1")
                .addToCompariosonFromList(1)
                .checkComparisonCount("2")
                .goToComparison();
    }

    @Step("Set values in price filter")
    public void setPricesToFilter(int min, int max) {
        productListPage.waitForPageToLoad()
                .closePopUp()
                .setPriceValue(min, max);
    }

    @Step("Verify content after price filter")
    public void verifyContentAfterPriceFilter(String phoneName, int min, int max) {
        assertTrue(productListPage.checkThatNameContainsWord(phoneName));
        assertTrue(productListPage.checkAllPricesCorespondToTheFilter(min, max));
    }

    @Step("Add memory filter")
    public void addMemoryFilter(String memoryValueOne, String memoryValueTwo) {
        productListPage.waitForPageToLoad()
                .closePopUp()
                .filerByMemory(memoryValueOne)
                .closePopUp()
                .filerByMemory(memoryValueTwo);
    }
    @Step("Verify content after memory filter")
    public void verifyContentAfterMemoryFilter(String memoryValueOne, String memoryValueTwo) {
        assertTrue(productListPage.checkThatNameContainsWord(memoryValueOne, memoryValueTwo));
    }
}
