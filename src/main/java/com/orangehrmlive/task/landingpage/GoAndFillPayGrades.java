package com.orangehrmlive.task.landingpage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouseToTarget;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.orangehrmlive.userinterface.paygrades.PayGrades.*;
import static com.orangehrmlive.util.Constants.Ten;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoAndFillPayGrades implements Task {
    private String name;

    public GoAndFillPayGrades useName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(GOT_TO_ADMIN,isVisible()).forNoMoreThan(Ten).seconds(),

                Scroll.to(GOT_TO_ADMIN),
                Click.on(GOT_TO_ADMIN),

                Scroll.to(GOT_TO_JOB),
                new MoveMouseToTarget(GOT_TO_JOB),

                //Scroll.to(GOT_TO_PAY_GRADES),
                Click.on(GOT_TO_PAY_GRADES),

                Scroll.to(BTN_ADD),
                Click.on(BTN_ADD),

                Scroll.to(ADD_NAME_TO_GRADE),
                Enter.theValue(name).into(ADD_NAME_TO_GRADE),

                Scroll.to(BTN_SAVE),
                Click.on(BTN_SAVE)

        );

    }

    public static GoAndFillPayGrades goAndFillPayGrades(){
        return new GoAndFillPayGrades();
    }
}
