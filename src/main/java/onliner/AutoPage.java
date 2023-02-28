package onliner;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AutoPage {
    private final SelenideElement name = $x("//h1");
    private final SelenideElement price = $x("//div[contains(@class,'jest-year')]");
    private final SelenideElement year = $x("//div[contains(@class,'jest-price-byn')]");

    public Car getTmpCar() {
        return tmpCar;
    }

    private Car tmpCar = new Car();



    @Step ("Save auto data")
    public AutoPage saveData(){
        tmpCar.setName(name.getText());
        tmpCar.setPrice(price.getText());
        tmpCar.setYear(year.getText());
        return this;
    }

}
