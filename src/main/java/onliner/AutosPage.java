package onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AutosPage {
    private final ElementsCollection filters = $$x("//div[@type]//div[@class='input-style__faux']/../..");
    private final ElementsCollection autos = $$x("//div[@class='vehicle-form__offers-list']/a");

    public Car getTmpCar() {
        return tmpCar;
    }

    private final Car tmpCar = new Car();

    @Step ("Open filter '{filterName}'")
    public AutosPage openFilter(String filterName){
        filters.findBy(Condition.text(filterName)).scrollIntoView(true).click();
        return this;
    }

    @Step ("Enter name '{searchName}'")
    public AutosPage enter(String inputName, String value){
        SelenideElement input = $x("//div[@class='dropdown-style__top']//input[@placeholder='" + inputName + "']");
        input.shouldBe(visible).sendKeys(value);
        return this;
    }

    @Step ("Choose mark from search")
    public AutosPage chooseMark(String name){
        $$x("//div[.='Все марки']/following-sibling::ul/li").findBy(Condition.text(name)).click();
        sleep(500);
        return this;
    }

    @Step ("Choose model from search")
    public AutosPage chooseModel(String name){
        $$x("//input[@placeholder='Найти модель']/../../following-sibling::div//ul[@tabindex=0]/li").findBy(Condition.text(name)).click();
        sleep(1000);
        $$x("//div[@class='button-style button-style_either button-style_small vehicle-form__button vehicle-form__button_tag']")
                .find(Condition.text(name)).shouldBe(visible);
        return this;
    }

    @Step("Save Autos data")
    public AutosPage saveAutoData(int index){
        autos.should(CollectionCondition.allMatch("", WebElement::isDisplayed));
        SelenideElement car = autos.get(index);
        String name = car.$x(".//div[@class='vehicle-form__offers-part vehicle-form__offers-part_title']/div/div[1]").getText();
        String price = car.$x(".//div[@class='vehicle-form__offers-part vehicle-form__offers-part_price']/div[1]").getText();
        String year = car.$x(".//div[@class='vehicle-form__offers-part vehicle-form__offers-part_year']/div").getText();
        tmpCar.setName(name);
        tmpCar.setPrice(price);
        tmpCar.setYear(year);

        System.out.println(name + " " + price + " " + year);
        return this;
    }

    @Step ("Open auto page")
    public AutosPage openAutoPage(int index){
        autos.get(index).click();
        return this;
    }
}
