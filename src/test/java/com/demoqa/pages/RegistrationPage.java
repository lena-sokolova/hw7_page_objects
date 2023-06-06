package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        userEmailInput = $("#userEmail"),
        genderWrapper = $("#genterWrapper"),
        userNumberInput = $("#userNumber"),
        birthDayInput = $("#dateOfBirthInput");

    public RegistrationPage openPage () {
        open ("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender (String value) {
        genderWrapper.$(byText(value)).click();;

        return this;
    }

    public RegistrationPage setUserNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay (String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

}
