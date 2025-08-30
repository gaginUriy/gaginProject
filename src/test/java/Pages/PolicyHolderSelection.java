package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PolicyHolderSelection {
    private final ElementsCollection insurensList = $$(" DIV.list-complete-item");
    private final String onlineBuyBatton  = "Купить онлайн";

    @Step("выбирает страхователя из списка и нажимает кнопку купить онлайн")
    public PolicyHolderSelection selectInsurensList(String bankName){

        SelenideElement bankOnly = insurensList.findBy(text(bankName)).find(byText(onlineBuyBatton));
        bankOnly.click();

        return this;
    }


}
