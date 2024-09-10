package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    static {
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeAll
    static void beforeAll(){/* Всегда пишется со static. Вызывается один перед всеми тестами в этом тестовом классе*/
        Configuration.browserSize = "1920x1080";    /* Задаем разрешение браузера */
        Configuration.baseUrl = "https://demoqa.com";   /* Открывает основную страницу сайта */
        Configuration.pageLoadStrategy = "eager";   /* Не ждем, когда загрузится полностью страница, чтобы долго не ждать*/
        // Configuration.holdBrowserOpen = true; /* не дает закрыть тесту браузер */
        Configuration.timeout = 5000;   // Таймаут 5 сек; default 4000
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");    /*Открывает форму text-box*/

        $("#userName").setValue("Kate");    /*Вводит в форму Full Name. Можно сократить: для id= - #, для класса "точка" */
        $("#userEmail").setValue("kate@ivanova.ru");    /*Вводит в форму Email*/
        $("#currentAddress").setValue("Some street 1");    /*Вводит в форму currentAddress */
        $("#permanentAddress").setValue("Another street 1");    /*Вводит в форму permanentAddress */
        $("#submit").click();    /*Клик по кнопке submit*/

        /*Если бы разработчик указывал уникальные имена для currentAddress и permanentAddress, то можно было написать короче*/
        $("#output #name").shouldHave(text("Kate")); /*Проверяет имя*/
        $("#output #email").shouldHave(text("kate@ivanova.ru")); /*Проверяет Email*/
        $("#output").$("#currentAddress").shouldHave(text("Some street 1")); /*Проверяет currentAddress*/
        $("#output").$("#permanentAddress").shouldHave(text("Another street 1")); /*Проверяет permanentAddress*/
    }
}