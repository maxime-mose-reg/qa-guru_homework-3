package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.exactOwnText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    private final CalendarComponent calendar = new CalendarComponent();

    private final SelenideElement
            pageHeader = $(byTagAndText("h5", "Student Registration Form")),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            subjectsContainer = $("#subjectsContainer"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateBlock = $("#state"),
            cityBlock = $("#city"),
            submitButton = $("#submit"),
            formHeader = $(byText("Thanks for submitting the form"));

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage checkPageHeader() {
        pageHeader.should(appear);
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        genderWrapperInput.$(byTagAndText("label", gender)).click();
        return this;
    }

    public PracticeFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setHobby(String hobby) {
        hobbiesWrapper.$(byTagAndText("label", hobby)).click();
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        subjectsInput.setValue(subject.substring(0, 1));
        subjectsContainer.$(byText(subject)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String picture) {
        uploadPictureInput.uploadFromClasspath(picture);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        stateBlock.click();
        stateBlock.$(byText(state)).click();
        cityBlock.click();
        cityBlock.$(byText(city)).click();
        return this;
    }

    public PracticeFormPage submit() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkFormHeader() {
        formHeader.should(appear);
        return this;
    }

    public PracticeFormPage checkFormParam(String label, String value) {
        $(byTagAndText("td", label)).sibling(0).shouldHave(exactOwnText(value));
        return this;
    }
}
