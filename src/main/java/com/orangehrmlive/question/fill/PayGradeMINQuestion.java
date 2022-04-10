package com.orangehrmlive.question.fill;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.orangehrmlive.userinterface.assignedcuerrencies.AssignedCurrencies.MSG_LIST_OK_MIN_CURRENCY;
import static com.orangehrmlive.util.GeneralData.reformatNumber;

public class PayGradeMINQuestion implements Question<Boolean> {
    private String MIN_CURRENCY;

    public PayGradeMINQuestion useMinCurrency(String MIN_CURRENCY) {
        this.MIN_CURRENCY = MIN_CURRENCY;
        return this;
    }

    public PayGradeMINQuestion is(){
        return this;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return (
                MSG_LIST_OK_MIN_CURRENCY.resolveFor(actor).containsOnlyText(reformatNumber(MIN_CURRENCY))
                );
    }

    public static PayGradeMINQuestion payGradeMINQuestion(){
        return new PayGradeMINQuestion();
    }
}
