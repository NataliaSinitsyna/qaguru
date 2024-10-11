
package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
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
        File photo = new File("src/test/resources/photo.jpg");
        $("#uploadPicture").uploadFile(photo);
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Alla Ivanova"), text("alla.ivanova@test.com"),
                text("Female"), text("8900123122"), text("18 February,2000"), text("Physics"), text("Reading, Sports"),
                text("photo.jpg"), text("Moscow"), text("NCR Delhi"));
    }
}


