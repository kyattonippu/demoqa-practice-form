package demoqa.com.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class FormTestPageObject extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = "test@test.com",
            gender = "Female",
            number = "0987654321",
            subject = "Biology",
            hobby = "Reading",
            path = "src/test/resources/", fileName = "testimage.jpg",
            streetAddress = faker.address().streetAddress(),
            state = "Rajasthan", city = "Jaipur";

    @Test
    void fullFormTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeUserEmail(email)
                        .chooseGender(gender);
        registrationPage.calendar.setDate("10", "January", "1998");
        registrationPage.typeUserNumber(number)
                        .typeSubjects(subject)
                        .setHobbies(hobby)
                        .uploadFile(path + fileName)
                        .typeAddress(streetAddress)
                        .selectState(state)
                        .selectCity(city)
                        .submit()
                        .checkModalForm();


        registrationPage
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", number)
                .checkResultsValue("Date of Birth", "10 January,1998")
                .checkResultsValue("Subjects", subject)
                .checkResultsValue("Hobbies", hobby)
                .checkResultsValue("Picture", fileName)
                .checkResultsValue("Address", streetAddress)
                .checkResultsValue("State and City", state + " " + city);
    }
}
