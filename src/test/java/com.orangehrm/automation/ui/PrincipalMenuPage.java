package com.orangehrm.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PrincipalMenuPage {

    public static final Target PIM_MODULE = Target.the("Modulo PIM")
            .located(By.xpath("//span[text()='PIM']"));

    public static final Target DIRECTORY_MODULE = Target.the("Modulo Directory")
            .located(By.xpath("//span[text()='Directory']"));
}
