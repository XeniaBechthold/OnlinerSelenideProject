import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import jdk.jfr.Description;
import onliner.AutoPage;
import onliner.AutosPage;
import onliner.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class FindAutoTest {

    private static final String URL = "https://www.onliner.by";

    @BeforeMethod
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true));
        open(URL);

    }

    @Test
    @Description("Find Auto and remember his features")
    public void findAutoAndGetFeatures(){
        new HomePage().openHeaderMenuItem("Автобарахолка");
        new AutosPage().openFilter("Марка")
                .enter("Найти марку", "Mercedes-Benz")
                .chooseMark("Mercedes-Benz")
                .openFilter("Модель")
                .enter("Найти модель", "E-Класс")
                .chooseModel("E-Класс")
                .saveAutoData(18)
                .openAutoPage(18);
        new AutoPage().saveData();
        Assert.assertEquals(new AutoPage().getTmpCar(), new AutosPage().getTmpCar());
    }
}
