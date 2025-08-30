package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PolicyPageInsuredTable {
    final private String baseUrlCrimeaTravelInsurancePage = "https://polis812.ru/vzr-crimea/policy";

    private final SelenideElement insuredLastName  = $x("//span[contains(text(),'Застрахованный')]/ancestor::div[@class='calculator-form__inputs vzr-inputs calculator-form__vzr-inputs']//input[@dadatatype='surname']");
    private final SelenideElement insuredFirstName  = $x("//span[contains(text(),'Застрахованный')]/ancestor::div[@class='calculator-form__inputs vzr-inputs calculator-form__vzr-inputs']//input[@dadatatype='name']");
    private final SelenideElement insuredMiddleName = $x("//span[contains(text(),'Застрахованный')]/ancestor::div[@class='calculator-form__inputs vzr-inputs calculator-form__vzr-inputs']//input[@dadatatype='middleName']");
    private final SelenideElement insuredBirdDay  = $x("//span[contains(text(),'Застрахованный')]/ancestor::div[@class='calculator-form__inputs vzr-inputs calculator-form__vzr-inputs']//label[contains(text(),'Дата рождения')]/..//input");


    @Step("Вносит фамилию застрахованного")
    public PolicyPageInsuredTable InputInsuredLastName(String lastName){
        insuredLastName.setValue(lastName).pressEnter();
        return this;
    }
    @Step("Вносит имя застрахованного")
    public PolicyPageInsuredTable InputInsuredFirstName(String firstName){
        insuredFirstName.setValue(firstName).pressEnter();
        return this;
    }
    @Step("Вносит отчество застрахованного")
    public PolicyPageInsuredTable InputInsuredMiddleName(String middleName){
        insuredMiddleName.setValue(middleName).pressEnter();
        return this;
    }
    @Step("Вносит дату рождения застрахованного")
    public PolicyPageInsuredTable InputInsuredBirdDay(String birdDay){
        insuredBirdDay.setValue(birdDay).pressTab();
        return this;
    }

}
