package com.autoqa.tests;

import org.junit.jupiter.api.Test;

import static com.autoqa.utils.RandomUtils.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithAllFeatureTests extends TestBase {
    @Test
    void successfulRegistrationTest() {

//        String firstName = faker.name().firstName(),
//                lastName = faker.name().lastName(),
//                email = faker.internet().emailAddress();

        //Test data
        String firstName = getRandomString(10),
                lastName = getRandomString(10),
                email = getRandomEmail(),
                userNumber = getRandomPhone(),
                address = getRandomFullAddress(),

                labelName = "Student Name",
                labelEmail = "Student Email",
                labelPhone = "Mobile",
                labelDateOfBirth = "Date of Birth",
                labelSubjects = "Subjects",
                labelHobbies = "Hobbies",
                labelAddress = "Address",
                labelStateAndCity = "State and City";
        String gender = getRandomItemFromArray(genderArray);


        registrationPages.openPage()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setUserEmailInput(email)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDate("30", "July", "2008")
                .setSubjectsInput("Math")
                .setHobbiesInput("Sports")
                .setAddressInput(address);

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
                .verifyResult(labelName, firstName + " " + lastName)
                .verifyResult(labelEmail, email)
                .verifyResult(labelPhone, userNumber)
                .verifyResult(labelDateOfBirth, "30 July,2008")
                .verifyResult(labelSubjects, "Math")
                .verifyResult(labelHobbies, "Sports")
                .verifyResult(labelAddress, address)
                .verifyResult(labelStateAndCity, "NCR Delhi");
    }
}
