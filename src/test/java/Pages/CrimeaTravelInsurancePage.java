package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CrimeaTravelInsurancePage {
    final private String baseUrlCrimeaTravelInsurancePage = "https://polis812.ru/vzr-crimea";
    private final SelenideElement tripStartDate = $("[placeholder=Туда]");
    private final SelenideElement returnDate = $("[placeholder=Обратно]");
    private final SelenideElement travelerAge  = $(".age-selection input");
    private final SelenideElement addTraveler  = $(".age-selection__add-btn-text");
    private final SelenideElement getInsuranceButton  = $(".calculator-base__next-step-btn");
    private final ElementsCollection setDate = $$(".cell.day");
    private final ElementsCollection nextMounth = $$("span.next");

    @Step("Задаёт дату начала поездки")
    public CrimeaTravelInsurancePage setTripStartDate(String date){
        tripStartDate.click();
        nextMounth.findBy(text(">")).click();
        setDate.findBy(text(date)).click();
        return this;
    }

    @Step("Задаёт дату окончания поездки")
    public CrimeaTravelInsurancePage setReturnDate(String date){
        returnDate.click();
        setDate.findBy(text(date)).click();
        return this;
    }

    @Step("Задаёт возраст туриста")
    public CrimeaTravelInsurancePage setTravelerAge(String age) {
       // executeJavaScript("arguments[0].value = arguments[1];", travelerAge, age);
        actions()
                .moveToElement(travelerAge)  // наводим курсор на элемент
                .click()                     // кликаем в поле
                .keyDown(Keys.CONTROL)       // зажимаем Ctrl
                .sendKeys("a")               // отправляем "A" (выделить всё)
                .keyUp(Keys.CONTROL)         // отпускаем Ctrl
                .sendKeys(Keys.DELETE)       // удаляем выделенное
                .sendKeys(age)
                .perform();// вводим новое значение
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return this;
    }

    @Step("нажимает кнопку Найти страховку")
    public void getInsuranceButtonClic(){
        getInsuranceButton.click();
    }




}
