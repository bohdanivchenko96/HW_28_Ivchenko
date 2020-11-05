import citrus.pages.HomePage;
import citrus.pages.ProductListPage;
import citrus.pages.ProductPage;
import citrus.steps.HomePageStep;
import citrus.steps.ProductListPageStep;
import citrus.steps.ProductPageStep;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestBasketBySearch extends BaseUITest {
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
    private void ExercizeTwo(){
        int productPriceValue;
        String productName = "Apple iPhone 11 128Gb Black";
        homePageStep.searchProductUsingSearchField("Apple iPhone 11");
        productPriceValue = productListPageStep.findProductOnList(productName);
        productListPageStep.addToBasket();
        productPageStep.assertProductEqualsOnList(productName, productPriceValue);
    }
}
