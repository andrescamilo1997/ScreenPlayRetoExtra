package com.orangehrmlive.task.go;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouseToTarget;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.orangehrmlive.userinterface.paygrades.PayGrades.*;
import static com.orangehrmlive.util.Constants.Ten;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoPayGrades implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the           (GOT_TO_ADMIN,isVisible()).forNoMoreThan(Ten).seconds(),

                Scroll.to               (GOT_TO_ADMIN),
                Click.on                (GOT_TO_ADMIN),

                Scroll.to               (GOT_TO_JOB),
                new MoveMouseToTarget   (GOT_TO_JOB),

                Click.on                (GOT_TO_PAY_GRADES)
        );

    }

    public static GoPayGrades goPayGrades(){
        return new GoPayGrades();
    }
}
