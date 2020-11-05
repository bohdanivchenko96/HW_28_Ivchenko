import citrus.steps.HomePageStep;
import citrus.steps.ProductListPageStep;
import citrus.steps.ProductPageStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestByFilter extends BaseUITest{
    HomePageStep homePageStep;
    ProductListPageStep productListPageStep;
    ProductPageStep productPageStep;

    @BeforeMethod
    private void executeClasses(){
        homePageStep = new HomePageStep();
        productListPageStep = new ProductListPageStep();
        productPageStep = new ProductPageStep();
    }

    @Test(priority = 2)
    private void priceFilter(){
        homePageStep.selectGroupOfPhones("Смартфоны", "Samsung");
        productListPageStep.setPricesToFilter(5000, 15000);
        productListPageStep.verifyContentAfterPriceFilter("Samsung", 5000, 15000);
    }

    @Test(priority = 1)
    private void memoryFilter(){
        homePageStep.selectGroupOfPhones("Смартфоны", "Xiaomi");
        productListPageStep.addMemoryFilter("32 Гб", "64 Гб");
        productListPageStep.verifyContentAfterMemoryFilter("32Gb", "64Gb");
    }
}
