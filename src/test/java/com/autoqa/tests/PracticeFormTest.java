package com.autoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends TestBase {
    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Alyona");
        $("#lastName").setValue("Kuznetsova");
        $("#userEmail").setValue("al.kz@yandex.ru");
        $("value=Female").click();
        $("#userNumber").setValue("8904859489");
        $("#dateOfBirthInput").click();

        $("#permanentAddress").setValue("no address too");
        $("#dateOfBirthInput").click();
        $("#output").shouldHave(text("Alyona"), text("al.kz@yandex.ru"), text("no address"), text("no address too"));
    }
}
