package com.orangehrm.automation.stepdefinition;

import com.orangehrm.automation.questions.TheUserProfile;
import com.orangehrm.automation.tasks.SearchUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class SearchUserStepDefinitions {

    String name;
    String lastName;

    @When("él busca al usuario en el modulo Directory con los datos {string} y {string}")
    public void heSearchesForTheEmployeeInTheDirectory(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        theActorInTheSpotlight().attemptsTo(
                SearchUser.inTheDirectory(name)
        );
    }

    @Then("él debería ver el perfil del usuario en la tarjeta")
    public void theNewEmployeeSProfileShouldBeVisibleInTheSearchResults() {
        String fullName = name + "  " + lastName + " ";
        theActorInTheSpotlight().should(
                seeThat("the user profile card", TheUserProfile.isVisible(fullName), is(true))
        );
    }
}
