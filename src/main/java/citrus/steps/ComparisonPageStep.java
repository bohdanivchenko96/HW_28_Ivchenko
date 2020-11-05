package citrus.steps;

import citrus.pages.ComparisonPage;
import io.qameta.allure.Step;

public class ComparisonPageStep {
    ComparisonPage comparisonPage = new ComparisonPage();
    @Step("Add products to basket after comparison")
    public void addToBasket() {
        comparisonPage.checkVisibilityOComparisonfPage()
                .addToBasket(0)
                .closeBasket()
                .checkCountOfBasket("1")
                .addToBasket(2);
    }
}
