package com.orangehrm.automation.questions;

import com.orangehrm.automation.ui.DirectoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheUserProfile {

    public static Question<Boolean> isVisible(String user) {
        return Question.about("La tarjeta del empleado es visible")
                .answeredBy(actor -> Visibility.of(DirectoryPage.USER_PROFILE_CARD(user)).answeredBy(actor));
    }
}
