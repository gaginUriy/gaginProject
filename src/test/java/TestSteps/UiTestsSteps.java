package TestSteps;

import Pages.BasePage;
import com.codeborne.pdftest.PDF;
import io.qameta.allure.Step;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UiTestsSteps {
    BasePage basePage = new BasePage();

   @Step("На главной странице выбрать туризм Для поезнок в крым")
    public UiTestsSteps getInsuranceOptions(){
       basePage.mainPage
               .getMenuBlock("Ещё","Для поездок в Крым");
       return this;
    }

    @Step("Заролнить данные поездки")
    public UiTestsSteps tripDetails(){
       basePage.crimeaTravelInsurancePage

               .setTripStartDate("20")
               .setReturnDate("21")
        .setTravelerAge("42")
        .getInsuranceButtonClic();
        return this;
    }

    @Step("Выбрать страхователя")
    public UiTestsSteps getInsurance(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }        basePage.policyHolderSelectionlicyHolderSelect.selectInsurensList("Русский Стандарт")
        ;
        return this;
    }
    @Step("Заполнить данные страхуемого")
    public UiTestsSteps fillInsurancePolicyData(){
        basePage.policyInsurence.InputInsuredLastName("Батова")
                .InputInsuredFirstName("Ирина")
                .InputInsuredMiddleName("Анатольевна")
                .InputInsuredBirdDay("30.04.1999");
        return this;
    }
    @Step("Заполнить данные Страхователя-Покупателя")
    public UiTestsSteps holderPolicyData(){
       basePage.holderTable.InputHolderFirstName("Инна")
               .InputHolderLastName("Петрова")
               .InputHolderMiddleName("Антоновна")
               .InputHolderBirthDate("10.12.1979")
               .InputHolderMail("Antolewha@Mail.ru")
               .InputHolderPhone("9377771221");
        return this;
    }
    @Step("Нажать на кнопку перейти к оплате")
    public UiTestsSteps clickBattonPayment(){
        basePage.holderTable.PaymondButtonClick();
        return this;
    }

    @Step("Нажать на кнопку 'Подробнее'")
    public UiTestsSteps clickButtonDetails() {
        basePage.orderInfo.ditailsBattonClick();
        return this;
    }
    @Step("скачть и проверить пример полиса")
    public UiTestsSteps downloadExamplePolicy() throws Exception {
        File file= basePage.orderInfo.downloadExamplePolicy();
         PDF content = new PDF(file);




        assertThat(content.text).contains("Страховая компания: АО «Русский Стандарт Страхование»");


        return this;
    }


}
