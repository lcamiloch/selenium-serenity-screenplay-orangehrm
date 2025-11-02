package com.orangehrm.automation.questions;

import com.orangehrm.automation.ui.AddUserPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class SuccessMessage {

    public static Question<Boolean> isVisible() {
        return Question.about("Mensaje de creacion de usuario exitoso")
                .answeredBy(actor -> Visibility.of(AddUserPage.SUCCESS_TOAST).answeredBy(actor));
    }
}
