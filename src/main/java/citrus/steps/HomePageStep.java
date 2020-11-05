package citrus.steps;

import citrus.pages.HomePage;
import io.qameta.allure.Step;

public class HomePageStep {
    HomePage homePage = new HomePage();

    @Step("Select an Apple type of smartp hones")
    public void clickOnProduct(String text) {
        homePage.waitForPageToLoad()
                .closePopUp()
                .openHiddenMenu("Смартфоны")
                .selectGroup(text);
    }
    @Step("Search product using search field")
    public void searchProductUsingSearchField(String text) {
        homePage.waitForPageToLoad()
                .closePopUp()
                .postValueIntoSearchField(text);
    }

    @Step("Find phones by group name")
    public void selectGroupOfPhones(String groupName, String phoneName) {
        homePage.waitForPageToLoad()
                .closePopUp()
                .openHiddenMenu(groupName)
                .selectGroup(phoneName);
    }
}
