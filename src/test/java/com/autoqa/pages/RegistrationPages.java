package com.autoqa.pages;
import com.autoqa.pages.components.ResultsModal;
import com.autoqa.pages.components.CalendarComponents;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPages {

    CalendarComponents calendarComponent = new CalendarComponents();
    ResultsModal resultsModal = new ResultsModal();

    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            stateCityInput = $("#stateCity-wrapper");


    // Actions
    public RegistrationPages openPage() {
        open("/automation-practice-form");
        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPages setFirstNameInput(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPages setLastNameInput(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPages setUserEmailInput(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPages setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationPages setNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPages setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPages verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPages verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPages setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPages setHobbiesInput(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPages setAddressInput(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPages setStateCityInput(String value) {
        stateCityInput.$(byText(value)).click();
        return this;
    }
}
