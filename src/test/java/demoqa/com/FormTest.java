package demoqa.com;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fullFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Test");
        $("#lastName").setValue("User");
        $("#userEmail").setValue("test@test.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("0987654321");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("testimage.jpg");
        $("#currentAddress").setValue("DC, Universe");
        $("#submit").scrollTo();
        $(byText("Select State")).click();
        $(byText("Rajasthan")).click();
        $(byText("Select City")).click();
        $(byText("Jaipur")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name Test User"), text ("Student Email test@test.com"),
                text("Gender Female"), text("Mobile 0987654321"), text("Date of Birth 01 January,1990"), text("Subjects Biology"),
                text("Hobbies Reading"), text("Picture testimage.jpg"), text("Address DC, Universe"), text("State and City Rajasthan Jaipur"));
    }
}
