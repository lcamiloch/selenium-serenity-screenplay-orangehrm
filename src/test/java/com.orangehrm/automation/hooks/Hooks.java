package com.orangehrm.automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class Hooks {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void reportTestStatusToBrowserStack(Scenario scenario) {

        String environment = System.getProperty("environment", "");
        if (environment.startsWith("bs_")) {

            try {

                WebDriver driver = ThucydidesWebDriverSupport.getDriver();

                JavascriptExecutor jse = (JavascriptExecutor) driver;

                String reason = "El escenario ha finalizado correctamente.";
                String status = "passed";

                if (scenario.isFailed()) {
                    status = "failed";

                    try {
                        reason = Serenity.getCurrentSession().get("current.exception").toString();
                    } catch (Exception e) {
                        reason = "El escenario fallo, pero no se pudo obtener la excepción específica.";
                    }
                }

                String script = String.format("browserstack_executor: " +
                        "{\"action\": \"setSessionStatus\", " +
                        "\"arguments\": {\"status\": \"%s\", " +
                        "\"reason\": \"%s\"}}", status, reason);

                jse.executeScript(script);

            } catch (Exception e) {
                System.out.println("No se pudo reportar el estado a BrowserStack. Error: " + e.getMessage());
            }
        }
    }
}
