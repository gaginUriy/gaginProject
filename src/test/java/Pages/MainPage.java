package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.SetValueOptions.withText;

public class MainPage {
    final private String BaseUrl = "https://polis812.ru/";

    final private ElementsCollection menuBlock = $$(".menu-block__item");
 //  final private ElementsCollection dropElements= $$("div.menu-block__item-dropdown--column [href]");
    final private ElementsCollection dropElements=  $$("[href]");

    @Step("Выбирает тип услуги из верхнего блока")
    public void  getMenuBlock(String insuranceType, String insuranceTypeOptions) {

        menuBlock.findBy(text(insuranceType)).hover().click();
        dropElements
                .findBy(text(insuranceTypeOptions))
                .hover()
                .click();


    }

    public String getBaseUrl() {
        return BaseUrl;
    }
}
