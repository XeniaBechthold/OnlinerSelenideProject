package onliner;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;

public class BasePage {
    protected final ElementsCollection headerMenu = $$x("//a[@class='b-main-navigation__link']");

    @Step ("Open menu item '{itemName}'")
    public BasePage openHeaderMenuItem(String itemName){
        headerMenu.findBy(text(itemName)).click();
        return this;
    }
}
