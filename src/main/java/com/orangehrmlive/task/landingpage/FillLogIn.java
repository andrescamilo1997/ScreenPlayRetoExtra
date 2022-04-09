package com.orangehrmlive.task.landingpage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrmlive.userinterface.login.Login.*;
import static com.orangehrmlive.util.Constants.Ten;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillLogIn implements Task {

    private  String email;
    private  String password;

    public FillLogIn useEmail(String email) {
        this.email = email;
        return this;
    }

    public FillLogIn usePassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(USER_NAME,isVisible()).forNoMoreThan(Ten).seconds(),

                Scroll.to(USER_NAME),
                Enter.theValue(email).into(USER_NAME),

                Scroll.to(PASSWORD),
                Enter.theValue(password).into(PASSWORD),

                Scroll.to(LOGIN_BTN),
                Click.on(LOGIN_BTN)
        );

    }

    public static FillLogIn fillLogIn(){
        return new FillLogIn();
    }
}
