package com.orangehrm.automation.stepdefinition;

import com.orangehrm.automation.questions.TheDashboard;
import com.orangehrm.automation.tasks.Login;
import com.orangehrm.automation.tasks.OpenTheBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class LoginStepDefinitions {

    private EnvironmentVariables env;

    @Given("el usuario abre la página de inicio de sesión de OrangeHRM")
    public void userOpensTheOrangeHrmLoginPage() {
        theActorCalled("User").wasAbleTo(
                OpenTheBrowser.atTheHomePage()
        );
    }

    @Given("el administrador se encuentra en la pagina inicial de la empresa")
    public void adminIsOnHomePage(){
        userOpensTheOrangeHrmLoginPage();
        heEntersTheAdminUserCredentials();
    }

    @When("él ingresa las credenciales validas")
    public void heEntersTheAdminUserCredentials() {

        String username =  EnvironmentSpecificConfiguration.from(env)
                .getProperty("credentials.username");
        String password =  EnvironmentSpecificConfiguration.from(env)
                .getProperty("credentials.password");

        theActorInTheSpotlight().attemptsTo(
                Login.withValidCredentials(username, password)
        );
    }

    @Then("él debería ver el panel principal de la pagina")
    public void heShouldSeeTheApplicationsMainDashboard() {
        theActorInTheSpotlight().should(
                seeThat("the dashboard title", TheDashboard.title(),
                        equalToIgnoringCase("Dashboard"))
        );
    }
}
