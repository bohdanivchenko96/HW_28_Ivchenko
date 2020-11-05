 import citrus.steps.HomePageStep;
import citrus.steps.ProductListPageStep;
import citrus.steps.ProductPageStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestBasketByMenu extends BaseUITest{
    HomePageStep homePageStep;
    ProductListPageStep productListPageStep;
    ProductPageStep productPageStep;

    @BeforeMethod
    private void executeClasses(){
        homePageStep = new HomePageStep();
        productListPageStep = new ProductListPageStep();
        productPageStep = new ProductPageStep();
    }
    @Test
    private void ExerciseOne(){
        String productName = "Apple iPhone 11 128Gb Black";
        homePageStep.clickOnProduct("Apple");
        productListPageStep.findDeviceByProductName(productName);
        productPageStep.addProductToBasket();
        productPageStep.assertProductEquals(productName);

    }

}
