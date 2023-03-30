package pages;

import com.codeborne.selenide.Condition;
import pages.components.CalendarComponent;
import pages.components.RegistrarionResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class RegistrationPage {

//    @BeforeAll
//    static void beforeAll(){
//        Configuration.browserSize="1920x1080";
//        Configuration.holdBrowserOpen=true;
//    }

        CalendarComponent calendarComponent = new CalendarComponent();
        RegistrarionResultsModal registrarionResultsModal = new RegistrarionResultsModal();


        private final String TITLE_TEXT = "Student Registration Form";

        public RegistrationPage openPage () {
            open("https://demoqa.com/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));
            return this;
        }


        public RegistrationPage closeBanner () {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            return this;
        }

        public RegistrationPage setFirstName (String value){
            $("[id=lastName]").setValue(value);
            return this;
        }

        public RegistrationPage setLastName (String value){
            $("[id=firstName]").setValue(value);
            return this;
        }

        public RegistrationPage setEMail (String value){
            $("[id=userEmail]").setValue(value);
            return this;
        }

        public RegistrationPage setGender (String value){
            $("#genterWrapper").$(byText(value)).click();
            return this;
        }

        public RegistrationPage setPhone (String value){
            $("[id=userNumber]").setValue(value);
            return this;
        }

        public RegistrationPage setBirthDate (String day, String month, String year){
            $(".react-datepicker-wrapper").click();
            calendarComponent.setDate(day, month, year);
            return this;
        }

        public RegistrationPage setSubjects (String value){
            $("#subjectsInput").setValue(value).pressEnter();
            return this;
        }

        public RegistrationPage setHobbies (String value){
            $("#hobbiesWrapper").$(byText(value)).click();
            return this;
        }

        public RegistrationPage setState (String value){
            $("#state").click();
            $("#stateCity-wrapper").$(byText(value)).click();
            return this;
        }

        public RegistrationPage setCity (String value){
            $("#city").click();
            $("#stateCity-wrapper").$(byText(value)).click();
            return this;
        }

        public RegistrationPage setAddress (String value){
            $("[id=currentAddress]").setValue(value);
            return this;
        }

        public RegistrationPage addFile (String value){
            $("#uploadPicture").uploadFromClasspath(value);
            return this;
        }

        public RegistrationPage setSubmit () {
            $("#submit").click();
            return this;
        }

        public RegistrationPage verifyResultsModalAppears () {
            registrarionResultsModal.verifyModalAppears();
            return this;
        }

        public RegistrationPage verifyResults (String key, String value){
            registrarionResultsModal.verifyResult(key, value);
            return this;
        }
    }
