package onliner;

import io.qameta.allure.Step;

public class HomePage extends BasePage {


    @Override
    @Step("Open menu item '{itemName}'")
    public HomePage openHeaderMenuItem(String itemName) {
        return (HomePage) super.openHeaderMenuItem(itemName);
    }
}
