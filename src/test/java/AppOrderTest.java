import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AppOrderTest {

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        SelenideElement testContent = $("form");
        testContent.$("input.input__control[type=text]").setValue("Ярослав");
        testContent.$("input.input__control[type=tel]").setValue("+00123456789");
        testContent.$(".checkbox").click();
        testContent.$(".button__text").click();
        $("[data-test-id=order-success]").should(have(text("успешно")));
    }
}