package Tests;

import Pages.MainPage;
import TestSteps.BaseSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class LifeInsurancePurchaseTests {
    MainPage mainPage = new MainPage();
    BaseSteps baseSteps =new  BaseSteps();
@BeforeEach
    void setUp(){
    open(mainPage.getBaseUrl());
    Configuration.browserSize = "1440x900";



    }


    @Test
    @DisplayName("")
    public void inInsurancePurchase() throws InterruptedException, Exception { SelenideLogger.addListener("allure",new AllureSelenide());
        baseSteps.stepsLifeInsurance
                .getInsuranceOptions()
                .tripDetails()
                .getInsurance()
                .fillInsurancePolicyData()
                .holderPolicyData()
                .clickBattonPayment()
                .clickButtonDetails()
                .downloadExamplePolicy();






        Thread.sleep(1222);


    }
}
