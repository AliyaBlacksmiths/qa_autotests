package com.autoqa.tests;

import com.autoqa.pages.RegistrationPages;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationPages registrationPages = new RegistrationPages();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "none";
        Configuration.browserSize = "1920x1080";
    }
}
