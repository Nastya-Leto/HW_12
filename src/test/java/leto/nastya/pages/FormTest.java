package leto.nastya.pages;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class FormTest extends TestData {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        new RegistrationPage().openPage()
                .closeBanner()
                .setFirstName(userName)
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

    }
}