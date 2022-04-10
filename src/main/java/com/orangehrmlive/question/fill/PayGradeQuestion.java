package com.orangehrmlive.question.fill;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.orangehrmlive.userinterface.assignedcuerrencies.AssignedCurrencies.MSG_LIST_OK_CURRENCY;

public class PayGradeQuestion implements Question<Boolean> {
    private String MSG_CURRENCY;

    public PayGradeQuestion useMSG_CURRENCY(String MSG_CURRENCY) {
        this.MSG_CURRENCY = MSG_CURRENCY;
        return this;
    }

    public PayGradeQuestion is(){
        return this;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return (
                MSG_LIST_OK_CURRENCY.resolveFor(actor).containsOnlyText(MSG_CURRENCY)
                );
    }

    public static PayGradeQuestion payGradeQuestion(){
        return new PayGradeQuestion();
    }
}
