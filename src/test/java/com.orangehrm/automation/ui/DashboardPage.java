package com.orangehrm.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {

    public static final Target DASHBOARD_TITLE = Target.the("título del dashboard")
            .located(By.xpath("//*[contains(@class, 'oxd-topbar-header-breadcrumb-module')]"));

}
