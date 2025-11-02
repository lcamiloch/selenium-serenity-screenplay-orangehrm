package com.orangehrm.automation.questions;

import com.orangehrm.automation.ui.DashboardPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheDashboard {

    public static Question<String> title() {
        return actor -> Text.of(DashboardPage.DASHBOARD_TITLE).answeredBy(actor).trim();
    }
}
