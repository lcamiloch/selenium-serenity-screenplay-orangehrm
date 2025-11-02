package com.orangehrm.automation.tasks;

import com.orangehrm.automation.ui.AddUserPage;
import com.orangehrm.automation.ui.PimPage;
import com.orangehrm.automation.ui.PrincipalMenuPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class CreateAnUser implements Task {

    private final String firstName;
    private final String lastName;

    public CreateAnUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(PrincipalMenuPage.PIM_MODULE),
                Click.on(PimPage.ADD_USER_BUTTON),
                Enter.theValue(firstName).into(AddUserPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(AddUserPage.LAST_NAME_FIELD),
                Click.on(AddUserPage.SAVE_BUTTON),
                WaitUntil.the(AddUserPage.SUCCESS_TOAST, isVisible()).forNoMoreThan(5).seconds()
        );
    }

    public static CreateAnUser withTheDetails(String firstName, String lastName) {
        return instrumented(CreateAnUser.class, firstName, lastName);
    }
}
