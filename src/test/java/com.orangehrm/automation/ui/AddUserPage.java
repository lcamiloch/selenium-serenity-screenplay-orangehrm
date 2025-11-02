package com.orangehrm.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddUserPage {

    public static final Target FIRST_NAME_FIELD  = Target.the("Campo primer nombre")
            .located(By.xpath("//input[@name='firstName']"));
    public static final Target LAST_NAME_FIELD  = Target.the("Campo apellido")
            .located(By.xpath("//input[@name='lastName']"));
    public static final Target ID_FIELD  = Target.the("Campo Id")
            .located(By.xpath("//label[@class='oxd-label']/..//following-sibling::div/input"));
    public static final Target SAVE_BUTTON  = Target.the("Boton save")
            .located(By.xpath("//button[@type='submit']"));
    public static final Target SUCCESS_TOAST = Target.the("Mensaje de creacion exitosa")
            .located(By.xpath("//*[contains(@class, 'oxd-toast-content--success')]"));
}
