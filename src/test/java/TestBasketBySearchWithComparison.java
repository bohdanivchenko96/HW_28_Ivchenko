import citrus.pages.ComparisonPage;
import citrus.pages.HomePage;
import citrus.pages.ProductListPage;
import citrus.pages.ProductPage;
import citrus.steps.ComparisonPageStep;
import citrus.steps.HomePageStep;
import citrus.steps.ProductListPageStep;
import citrus.steps.ProductPageStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class TestBasketBySearchWithComparison extends BaseUITest{
    HomePageStep homePageStep;
    ProductListPageStep productListPageStep;
    ProductPageStep productPageStep;
    ComparisonPageStep comparisonPageStep;

    @BeforeMethod
    private void executeClasses() {
        homePageStep = new HomePageStep();
        productListPageStep = new ProductListPageStep();
        productPageStep = new ProductPageStep();
        comparisonPageStep = new ComparisonPageStep();
    }

    @Test
    private void ExercizeFour() {
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> productPrices = new ArrayList<>();
        homePageStep.searchProductUsingSearchField("Apple iPhone 11");
        productListPageStep.foundTwoFirstProductsByName(productNames);
        productListPageStep.saveProductsPrices(productPrices);
        productListPageStep.addToComparison();
        comparisonPageStep.addToBasket();
        productPageStep.verifyContentInBasketWithTwoProductsFromComparison(productNames, productPrices);
    }
}
