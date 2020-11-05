import citrus.steps.HomePageStep;
import citrus.steps.ProductListPageStep;
import citrus.steps.ProductPageStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class TestBasketBySearchTwo extends BaseUITest {
    HomePageStep homePageStep;
    ProductListPageStep productListPageStep;
    ProductPageStep productPageStep;

    @BeforeMethod
    private void executeClasses() {
        homePageStep = new HomePageStep();
        productListPageStep = new ProductListPageStep();
        productPageStep = new ProductPageStep();
    }

    @Test
    private void ExercizeThree() {
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> productPrices = new ArrayList<>();
        homePageStep.searchProductUsingSearchField("Apple iPhone 11");
        productListPageStep.foundTwoFirstProductsByName(productNames);
        productListPageStep.saveProductsPrices(productPrices);
        productListPageStep.addProductsToBasket();
        productPageStep.verifyContentInBasketWithTwoProducts(productNames, productPrices);

    }
}
