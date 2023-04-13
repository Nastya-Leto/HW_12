package leto.nastya.pages;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class FormTest extends TestData {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        TestBase.beforeAll();
    }
    @Test
    void fillFormTest() {

        step("Open form", () -> {
            new RegistrationPage().openPage()
                    .closeBanner();
        });

        step("Fill form", () -> {
            new RegistrationPage().setFirstName(userName)
                    .setLastName(userLastName)
                    .setEMail(email)
                    .setGender(gender)
                    .setPhone(phone)
                    .setBirthDate(userBirthDate, userBirthMonth, userBirthYear)
                    .setSubjects(userSubjects)
                    .setHobbies(userHobbies)
                    .setAddress(address)
                    .setState(userState)
                    .setCity(userCity)
                    .addFile(file)
                    .setSubmit();
        });


        step("Verify results", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResults("Student Name", userLastName + " " + userName)
                    .verifyResults("Student Email", email)
                    .verifyResults("Gender", gender)
                    .verifyResults("Mobile", phone)
                    .verifyResults("Date of Birth", userBirthDate + " " + userBirthMonth + "," + userBirthYear)
                    .verifyResults("Subjects", userSubjects)
                    .verifyResults("Hobbies", userHobbies)
                    .verifyResults("Picture", "img1.png")
                    .verifyResults("Address", address)
                    .verifyResults("State and City", userState + " " + userCity);

        });
    }
}