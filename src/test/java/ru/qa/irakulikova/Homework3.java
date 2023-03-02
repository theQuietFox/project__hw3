package ru.qa.irakulikova;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homework3 {

        @BeforeAll
        static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        }

        String name = "Jennie";
        String lastName = "Kim";
        String email = "Jennie@Kim.com";
        String number = "7894561230";
        String address = "Kannam street";
        String subjects = "Arts";
        String gender = "Female";


        @Test
        void practiceForm() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1996");
        $x("//div[@class='react-datepicker__month-container']//div[@aria-label='Choose Tuesday, January 16th, 1996']").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        File fileToUpload = new File("src/test/resources/pictures/test.jpg");
        $("#uploadPicture").uploadFile(fileToUpload);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();
        $(".table-responsive table").$(byText("Student Name")).parent().shouldHave(text(name + " " + lastName));
        $(".table-responsive table").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive table").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive table").$(byText("Mobile")).parent().shouldHave(text(number));
        $(".table-responsive table").$(byText("Date of Birth")).parent().shouldHave(text("16 January,1996"));
        $(".table-responsive table").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $(".table-responsive table").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive table").$(byText("Picture")).parent().shouldHave(text("test.jpg"));
        $(".table-responsive table").$(byText("Address")).parent().shouldHave(text(address));
        $(".table-responsive table").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));

        }
 }