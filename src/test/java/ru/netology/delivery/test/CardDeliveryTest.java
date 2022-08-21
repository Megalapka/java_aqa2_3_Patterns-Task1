package ru.netology.delivery.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @BeforeEach
    void setUP() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");

    }

    @AfterEach
    void tearDown() {
        closeWindow();
    }


    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {

        $("[data-test-id='city'] .input__control").setValue(DataGenerator.generateCity());
        $(".menu-item__control").click();

        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);

        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(firstMeetingDate);

        $("[data-test-id='name'] .input__control").setValue(DataGenerator.generateName("ru"));
        $("[data-test-id='phone'] .input__control").setValue(DataGenerator.generatePhone("ru"));
        $("[data-test-id='agreement']").click();

        $(".button__text").click();

        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(secondMeetingDate);

        $(".button__text").click();
        $(".notification__content .button__content").click();
        $(".notification__content")
                .shouldHave(text("Встреча успешно запланирована на " + secondMeetingDate), Duration.ofSeconds(4))
                .shouldBe(Condition.visible);


    }

}
