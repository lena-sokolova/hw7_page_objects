package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest() {
        open ("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Sokolova");
        $("#userEmail").setValue("e.sokolova@example.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8900707070");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--007").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#uploadPicture").uploadFile(new File("src/test/resources/nature.jpg"));
        $("#uploadPicture").uploadFromClasspath("nature.jpg");
        $("#currentAddress").setValue("Some address");
        $("#stateCity-wrapper").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").$(byText("Jaipur")).click();
        $("#submit").click();


        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Elena Sokolova"));
        $(".table-responsive").shouldHave(text("e.sokolova@example.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8900707070"));
        $(".table-responsive").shouldHave(text("07 July,1989"));
        $(".table-responsive").shouldHave(text("English, Economics"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("nature.jpg"));
        $(".table-responsive").shouldHave(text("Some address"));
        $(".table-responsive").shouldHave(text("Rajasthan Jaipur"));
    }
}
