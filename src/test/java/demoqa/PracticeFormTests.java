
package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void configurationSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void registrationFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alla");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("alla.ivanova@test.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("89001231223");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("February")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2000")).click();
        $(byText("18")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("p");
        $(byText("Physics")).click();
        $(byText("Reading")).click();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(Condition.text("Alla Ivanova"));
        $(".modal-body").shouldHave(Condition.text("alla.ivanova@test.com"));
        $(".modal-body").shouldHave(Condition.text("Female"));
        $(".modal-body").shouldHave(Condition.text("8900123122"));
        $(".modal-body").shouldHave(Condition.text("18 February,2000"));
        $(".modal-body").shouldHave(Condition.text("Physics"));
        $(".modal-body").shouldHave(Condition.text("Reading, Sports"));
        $(".modal-body").shouldHave(Condition.text("photo.jpg"));
        $(".modal-body").shouldHave(Condition.text("Moscow"));
        $(".modal-body").shouldHave(Condition.text("NCR Delhi"));
    }
}


