package com.orangehrm.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PimPage {

    public static final Target ADD_USER_BUTTON = Target.the("Boton agregar usuario")
            .located(By.xpath("//button[text()=' Add ']"));
}
