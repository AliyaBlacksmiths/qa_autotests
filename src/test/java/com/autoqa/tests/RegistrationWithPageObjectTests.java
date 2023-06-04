package com.autoqa.tests;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectTests extends TestBase{

    @Test
        void successfulRegistrationTest() {

            registrationPages.openPage()
                    .setFirstNameInput("Alex")
                    .setLastNameInput("Egorov")
                    .setUserEmailInput("alex@egorov.com")
                    .setGender("Other")
                    .setNumber("1234567890")
                    .setBirthDate("30", "July", "2008")
                    .setSubjectsInput("Math")
                    .setHobbiesInput("Sports")
                    .setAddressInput("Some address 1");

//        $("#uploadPicture").uploadFromClasspath("img/1.png");
//        $("#state").click();
//        registrationPages.openPage().setStateCityInput("NCR");
//        $("#city").click();
//        registrationPages.openPage().setStateCityInput("Delhi");
//        $("#submit").click();

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


//        $("#gender-radio-1").click(); // wrong
//        $("#gender-radio-3").parent().click(); // good
//        $(byText("Other")).click(); // not very good
//        $("#genterWrapper").$(byText("Other")).click(); // best
//        $("label[for=gender-radio-3]").click(); // good


        registrationPages.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "Alex Egorov")
                .verifyResult("Student Email", "alex@egorov.com")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "30 July,2008")
                .verifyResult("Subjects", "Math")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Address", "Some address 1")
                .verifyResult("State and City", "NCR Delhi");

    }
}
