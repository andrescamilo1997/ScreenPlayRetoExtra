package com.orangehrmlive.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.orangehrmlive.userinterface.assignedcuerrencies.AssignedCurrencies.MSG_LIST_OK_MAX_CURRENCY;
import static com.orangehrmlive.util.GeneralData.reformatNumber;

public class PayGradeMaxQuestion implements Question<Boolean> {
    private String MAX_CURRENCY;

    public PayGradeMaxQuestion useMaxCurrency(String MAX_CURRENCY) {
        this.MAX_CURRENCY = MAX_CURRENCY;
        return this;
    }

    public PayGradeMaxQuestion is(){
        return this;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return (
                MSG_LIST_OK_MAX_CURRENCY.resolveFor(actor).containsOnlyText(reformatNumber(MAX_CURRENCY))
                );
    }

    public static PayGradeMaxQuestion payGradeMaxQuestion(){
        return new PayGradeMaxQuestion();
    }
}
