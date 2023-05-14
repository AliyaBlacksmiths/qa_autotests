package com.autoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{

    //https://demoqa.com/text-box

    @Test
    void successfulFillFormTest() {
        open("/text-box");

        $("[id=userName]").setValue("Alyona");
        $("#userEmail").setValue("al.kz@yandex.ru");
        $("#currentAddress").setValue("no address");
        $("#permanentAddress").setValue("no address too");
        $("#submit").click();
        $("#output").shouldHave(text("Alyona"), text("al.kz@yandex.ru"), text("no address"), text("no address too"));
    }

}
