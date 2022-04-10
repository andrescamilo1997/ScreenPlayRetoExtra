package com.orangehrmlive.task.delete;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrmlive.userinterface.assignedcuerrencies.AssignedCurrencies.*;
import static com.orangehrmlive.util.Constants.Ten;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DeleteCurrency implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the   (CHECK_DELETE,isVisible()).forNoMoreThan(Ten).seconds(),

                Scroll.to       (CHECK_DELETE),
                Click.on        (CHECK_DELETE),

                Scroll.to       (BTN_DELETE),
                Click.on        (BTN_DELETE)
        );

    }

    public static DeleteCurrency deleteCurrency(){
        return new DeleteCurrency();
    }
}
