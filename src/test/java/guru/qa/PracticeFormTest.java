package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PracticeFormTest {

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successTest() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userEmail = "ivanov@company.org";
        String gender = "Other";
        String userNumber = "9157770707";
        String day = "01";
        String month = "January";
        String year = "2000";
        String hobby = "Sports";
        String subject = "Maths";
        String picture = "img/image.png";
        String someAddress = "Some address";
        String state = "Rajasthan";
        String city = "Jaiselmer";

        new PracticeFormPage().openPage()
                .checkPageHeader()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setHobby(hobby)
                .setSubject(subject)
                .uploadPicture(picture)
                .setCurrentAddress(someAddress)
                .setStateAndCity(state, city)
                .submit()

                .checkFormHeader()
                .checkFormParam("Student Name", firstName + " " + lastName)
                .checkFormParam("Student Email", userEmail)
                .checkFormParam("Gender", gender)
                .checkFormParam("Mobile", userNumber)
                .checkFormParam("Date of Birth", String.format("%s %s,%s", day, month, year))
                .checkFormParam("Subjects", subject)
                .checkFormParam("Hobbies", hobby)
                .checkFormParam("Picture", picture.replaceFirst(".*/", ""))
                .checkFormParam("Address", someAddress)
                .checkFormParam("State and City", state + " " + city);
    }
}
