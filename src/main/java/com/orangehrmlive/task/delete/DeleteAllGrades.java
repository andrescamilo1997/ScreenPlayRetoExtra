package com.orangehrmlive.task.delete;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrmlive.userinterface.paygrades.PayGrades.*;
import static com.orangehrmlive.util.Constants.Ten;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DeleteAllGrades implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CHECK_ALL_GRADES,isVisible()).forNoMoreThan(Ten).seconds(),

                Scroll.to   (CHECK_ALL_GRADES),
                Click.on    (CHECK_ALL_GRADES),

                Scroll.to   (DELETE_THE_GRADES),
                Click.on    (DELETE_THE_GRADES),

                Scroll.to   (ACEPT_THE_DIALOG),
                Click.on    (ACEPT_THE_DIALOG)
        );

    }

    public static DeleteAllGrades deleteAllGrades(){
        return new DeleteAllGrades();
    }
}
