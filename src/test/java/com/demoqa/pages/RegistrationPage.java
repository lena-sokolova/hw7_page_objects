package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.RegistrationResultComponent;

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
        birthDayInput = $("#dateOfBirthInput"),
        subjectInput = $("#subjectsInput"),
        hobbiesWrapper = $("#hobbiesWrapper"),
        uploadFileBtn = $("#uploadPicture"),
        currentAddressInput = $("#currentAddress"),
        state = $("#state"),
        stateCityWrapper = $("#stateCity-wrapper"),
        city = $("#city"),
        submitBtn = $("#submit");

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

    public RegistrationPage setSubject (String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby (String value) {
        hobbiesWrapper.$(byText(value)).click();;

        return this;
    }

    public RegistrationPage uploadPicture (String value) {
        uploadFileBtn.uploadFromClasspath(value);
        ;

        return this;
    }

    public RegistrationPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState (String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity (String value) {
        city.click();
        city.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmitBtn() {
        submitBtn.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        RegistrationResultComponent.verifyResult(key, value);

        return this;
    }

    public RegistrationPage closeTableResponsive() {
        RegistrationResultComponent.clickCloseBtn();

        return this;
    }
}



