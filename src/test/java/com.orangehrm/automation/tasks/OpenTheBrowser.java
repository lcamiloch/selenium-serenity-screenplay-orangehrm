package com.orangehrm.automation.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;



import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheBrowser implements Task {

    @Override
    @Step("{0} abre el navegador en la página de inicio configurada")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("page.orangehrm_home"));
    }

    public static OpenTheBrowser atTheHomePage() {
        return instrumented(OpenTheBrowser.class);
    }
}