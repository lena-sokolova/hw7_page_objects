package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.CalendarComponent;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Elena")
                .setLastName("Sokolova")
                .setUserEmail("e.sokolova@example.com")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setBirthDay("07", "July", "1989")
                .setSubject("English")
                .setHobby("Sports")
                .uploadPicture("nature.jpg")
                .setCurrentAddress("Some address")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .clickSubmitBtn();



        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Elena"), text("Sokolova"),
                text("e.sokolova@example.com"), text("1234567890"));

    }
}
