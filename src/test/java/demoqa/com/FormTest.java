package demoqa.com;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("#uploadPicture").uploadFromClasspath("testimage.jpeg");
    }
}
