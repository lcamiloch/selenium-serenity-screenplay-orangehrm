package com.orangehrm.automation.tasks;

import com.orangehrm.automation.ui.AddUserPage;
import com.orangehrm.automation.ui.PrincipalMenuPage;
import com.orangehrm.automation.ui.DirectoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchUser implements Task {

    private final String firstName;

    public SearchUser(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(PrincipalMenuPage.DIRECTORY_MODULE),

                Check.whether(WebElementQuestion.the(DirectoryPage.OPEN_SEARCH_BUTTON_D), isVisible())
                        .andIfSo(Click.on(DirectoryPage.OPEN_SEARCH_BUTTON_D)),

                Enter.theValue(firstName).into(DirectoryPage.USER_NAME_INPUT),
                WaitUntil.the(DirectoryPage.USER_NAME_LIST, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(DirectoryPage.USER_NAME_LIST),
                Click.on(DirectoryPage.SEARCH_BUTTON)
        );
    }

    public static SearchUser inTheDirectory(String firstName) {
        return instrumented(SearchUser.class, firstName);
    }
}
