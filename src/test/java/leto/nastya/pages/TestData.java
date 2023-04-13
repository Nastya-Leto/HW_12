package leto.nastya.pages;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static utils.RandomUtils.getRandomInt;
import static utils.RandomUtils.getRandomItemFromArray;

public class TestData {

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    public static String[]
            genders = {"Male", "Female", "Other"},
            subjects = {"Arts", "Accounting", "English"},
            hobbies = {"Sports", "Reading", "Music"},
            city = {"Delhi", "Gurgaon", "Noida"},
            month = {"January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"};

    Faker faker = new Faker();

    String userName = faker.pokemon().name(),
            userLastName = faker.gameOfThrones().house(),
            email = faker.internet().emailAddress(),
            gender = getRandomItemFromArray(genders),
            phone = faker.number().digits(10),
            userSubjects = getRandomItemFromArray(subjects),
            userHobbies = getRandomItemFromArray(hobbies),
            userState = "NCR",
            userCity = getRandomItemFromArray(city),
            address = faker.rickAndMorty().location(),
            file = "pictures/img1.png",
            userBirthDate = String.format("%02d", faker.number().numberBetween(1, 28)),
            userBirthMonth = getRandomItemFromArray(month),
            userBirthYear = String.valueOf(getRandomInt(1900, 2100));


}
