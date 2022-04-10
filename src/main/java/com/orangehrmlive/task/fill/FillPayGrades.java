package com.orangehrmlive.task.fill;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrmlive.userinterface.paygrades.PayGrades.*;
import static com.orangehrmlive.util.Constants.Ten;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillPayGrades implements Task {
    private String name;

    public FillPayGrades useName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the   (BTN_ADD,isVisible()).forNoMoreThan(Ten).seconds(),

                Scroll.to       (BTN_ADD),
                Click.on        (BTN_ADD),

                Scroll.to       (ADD_NAME_TO_GRADE),
                Enter.theValue  (name).into(ADD_NAME_TO_GRADE),

                Scroll.to       (BTN_SAVE),
                Click.on        (BTN_SAVE)

        );

    }

    public static FillPayGrades fillPayGrades(){
        return new FillPayGrades();
    }
}
