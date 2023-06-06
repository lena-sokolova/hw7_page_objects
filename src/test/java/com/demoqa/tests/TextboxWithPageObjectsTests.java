package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextboxWithPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successTest() {
        textBoxPage.openPage()
                .setUserName("Elena Sokolova")
                .setUserEmail("e.sokolova@example.com")
                .setCurrentAddress("Some address 1")
                .setPermanentAddress("Another address 1")
                .clickSubmitBtn();

        textBoxPage
                .verifyResult("Elena Sokolova", "e.sokolova@example.com",
                        "Some address 1", "Another address 1");

    }
}

