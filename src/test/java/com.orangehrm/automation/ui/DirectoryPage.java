package com.orangehrm.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DirectoryPage {

    public static final Target USER_NAME_INPUT  = Target.the("Campo nombre usuario busqueda")
            .located(By.xpath("//input[@placeholder='Type for hints...']"));
    public static final Target SEARCH_BUTTON  = Target.the("Boton de busqueda")
            .located(By.xpath("//button[@type='submit']"));
    public static final Target OPEN_SEARCH_BUTTON_D = Target.the("Boton para abrir la busqueda")
            .located(By.xpath("//h5/../..//i[contains(@class, 'bi-caret-down-fill')]"));
    public static final Target USER_NAME_LIST = Target.the("Nombre en la lista")
                .located(By.xpath("//div[@role='listbox']/div[1]/span"));

    public static Target USER_PROFILE_CARD(String user) {
        return Target.the("Perfil del usuario " + user)
                .located(By.xpath(String.format("//p[text()='%s']", user)));
    }

}