package com.orangehrmlive.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.orangehrmlive.userinterface.assignedcuerrencies.AssignedCurrencies.MSG_LIST_OK;
import static com.orangehrmlive.util.Comparator.MSG_ALL_OK_TEXT;

public class PayGradeQuestion implements Question<Boolean> {
    public PayGradeQuestion is(){
        return this;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return (
                MSG_LIST_OK.resolveFor(actor).containsOnlyText(MSG_ALL_OK_TEXT.getValue())
                );
    }
    public static PayGradeQuestion payGradeQuestion(){
        return new PayGradeQuestion();
    }
}
