package com.orangehrmlive.task.landingpage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrmlive.userinterface.assignedcuerrencies.AssignedCurrencies.*;
import static com.orangehrmlive.util.Constants.Ten;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillCurrencyPayGrades implements Task {

    private String  currency;
    private String  maximum;
    private String  minimum;

    public FillCurrencyPayGrades useCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public FillCurrencyPayGrades useMaximum(String maximum) {
        this.maximum = maximum;
        return this;
    }

    public FillCurrencyPayGrades useMinimum(String minimum) {
        this.minimum = minimum;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ADD_ASSIGNED,isVisible()).forNoMoreThan(Ten).seconds(),

                Scroll.to(ADD_ASSIGNED),
                Click.on(ADD_ASSIGNED),

                Scroll.to(NAME_CURRENCY),
                Enter.theValue(currency).into(NAME_CURRENCY),

                Scroll.to(MAXIMUM_SALARY),
                Enter.theValue(maximum).into(MAXIMUM_SALARY),

                Scroll.to(MINIMUM_SALARY),
                Enter.theValue(minimum).into(MINIMUM_SALARY),

                Scroll.to(BTN_SAVE_CURRENCY),
                Click.on(BTN_SAVE_CURRENCY)
        );

    }

    public static FillCurrencyPayGrades fillCurrencyPayGrades(){
        return new FillCurrencyPayGrades();
    }
}
