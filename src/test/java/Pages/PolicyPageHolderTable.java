package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PolicyPageHolderTable {

    final private String baseUrlCrimeaTravelPage = "https://polis812.ru/vzr-crimea/policy";


    private final SelenideElement policyholderLastName  = $x("//span[contains(text(),'Страхователь-Покупатель')]/ancestor::div[@class='calculator-form__vzr-inputs']//input[@dadatatype='surname']");
    private final SelenideElement policyholderFirstName = $x("//span[contains(text(),'Страхователь-Покупатель')]/ancestor::div[@class='calculator-form__vzr-inputs']//input[@dadatatype='name']");
    private final SelenideElement policyholderMiddleName = $x("//span[contains(text(),'Страхователь-Покупатель')]/ancestor::div[@class='calculator-form__vzr-inputs']//input[@dadatatype='middleName']");
    private final SelenideElement policyholderBirthDate = $x("//span[contains(text(),'Страхователь-Покупатель')]/ancestor::div[@class='calculator-form__vzr-inputs']//label[contains(text(),'Дата рождения')]/..//input");
    private final SelenideElement policyholderMail  = $x("//span[contains(text(),'Страхователь-Покупатель')]/ancestor::div[@class='calculator-form__vzr-inputs']//input[@name='email']");
    private final SelenideElement policyholderPhone = $x("//span[contains(text(),'Страхователь-Покупатель')]/ancestor::div[@class='calculator-form__vzr-inputs']//input[@class='phone-number-input__phone-input']");
    private final SelenideElement paymontBatton = $(byText("Перейти к оплате"));


    @Step("Вносит фамилию покупателя")
    public PolicyPageHolderTable InputHolderLastName(String lastName){
        policyholderLastName.setValue(lastName).pressTab();
        return this;
    }
    @Step("Вносит имя покупателя")
    public PolicyPageHolderTable InputHolderFirstName(String firstName){
        policyholderFirstName.setValue(firstName).pressTab();
        return this;
    }
    @Step("Вносит отчество покупателя")
    public PolicyPageHolderTable InputHolderMiddleName(String middleName){
        policyholderMiddleName.setValue(middleName).pressTab();
  return this;
    }
    @Step("Вносит День рождение покупателя")
    public PolicyPageHolderTable InputHolderBirthDate(String birthDate){
        policyholderBirthDate.setValue(birthDate).pressTab();
        return this;
    }
    @Step("Вносит почту покупателя")
    public PolicyPageHolderTable InputHolderMail(String mail){
        policyholderMail.setValue(mail).pressTab();
        return this;
    }
    @Step("Вносит телефон покупателя")
    public PolicyPageHolderTable InputHolderPhone(String phone){

        policyholderPhone.setValue(phone);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Step("Нажимает на кнопку перейти к оплате")
    public PolicyPageHolderTable PaymondButtonClick(){
        paymontBatton.click();
        return this;
    }




}


