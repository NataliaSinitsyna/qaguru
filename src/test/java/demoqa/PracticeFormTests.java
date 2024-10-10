
package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true; //false
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
        //date
        //subj
        $("#subjectsContainer").click();
        $(".subjects-auto-complete__control.subjects-auto-complete__control--is-focused.subjects-auto-complete__control--menu-is-open.css-1pahdxg-control").setValue("p");
        $(byText("Physics")).click();

        $(byText("Reading")).click();
        $(byText("Sports")).click();
        File photo = new File("src/test/resources/photo.jpg");
        $("#uploadPicture").uploadFile(photo);
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
    }
}


