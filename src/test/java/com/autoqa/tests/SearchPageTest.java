package com.autoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchPageTest {

    @Test
    void checkCodeForJUnit(){
        open("https://github.com/");
        $("[placeholder='Search GitHub']").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $$("#wiki-body").shouldHave(texts("Soft assertions"));
        $(byText("Soft assertions")).click();
        $$("#wiki-body").shouldHave(texts("Using JUnit5 extend test class"));

/*
 - Откройте страницу Selenide в Github
 - Перейдите в раздел Wiki проекта
 - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
 - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
*/

    }
}
