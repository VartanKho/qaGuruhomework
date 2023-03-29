package homework;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestStudentRegistration extends TestBase{

    @Test
    void successfulStudentRegistration() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Lyffi");
        $("#lastName").setValue("Mugivara");
        $("#userEmail").setValue("Lyffi@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__year-select").$(byText("1987")).click();
        $(".react-datepicker__day--0" + "12").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.png"));
        $("#currentAddress").setValue("Grande Line");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Lyffi"),
                text("Mugivara"),
                text("Lyffi@gmail.com"),
                text("Male"),
                text("9999999999"),
                text("12 July,1987"),
                text("Computer Science"),
                text("Sports"),
                text("cat.png"),
                text("Grande Line"),
                text("Haryana"),
                text("Karnal")
        );

    }
}
