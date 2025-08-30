package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class orderInfo {
    private final SelenideElement ditailsBatton  = $("button.simple-program__expand-btn");
    private final SelenideElement examplePolicy  = $(byText("Пример полиса"));
    private final SelenideElement policyConditions  = $("[target=_blank]").$(Selectors.byText("Условия страхования"));

    @Step("нажимает кнопку 'подробнее'")
    public orderInfo ditailsBattonClick(){
        ditailsBatton.click();
        return this;
    }


    @Step("Скачать Пример полиса")
    public File downloadExamplePolicy(){
       File x = examplePolicy.download();
        return x;
    }

}
