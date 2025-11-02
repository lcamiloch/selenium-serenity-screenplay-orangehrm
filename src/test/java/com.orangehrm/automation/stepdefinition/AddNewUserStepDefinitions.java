package com.orangehrm.automation.stepdefinition;

import com.orangehrm.automation.questions.SuccessMessage;
import com.orangehrm.automation.tasks.CreateAnUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class AddNewUserStepDefinitions {

    @When("el administrador crea un nuevo usuario con los datos {string} y {string}")
    public void theAdminCreatesANewEmployeeWithTheFollowingDetails(String firstName, String lastName) {
        theActorInTheSpotlight().attemptsTo(
                CreateAnUser.withTheDetails(firstName, lastName)
        );
    }

    @Then("el deberia ver una mensaje de creacion exitosa")
    public void heShouldSeeAMessageSuccessful() {
        theActorInTheSpotlight().should(
                seeThat("the success message", SuccessMessage.isVisible(), is(true))
        );
    }
}
