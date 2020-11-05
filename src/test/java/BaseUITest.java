
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class BaseUITest {

    @BeforeClass
    public void startUp(){
        Configuration.baseUrl = "https://www.citrus.ua";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open("/");
    }

    @AfterClass
    public void clearDataOnSite(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
