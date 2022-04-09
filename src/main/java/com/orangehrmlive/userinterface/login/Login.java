package com.orangehrmlive.userinterface.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Login extends PageObject {

    public static final Target USER_NAME = Target
            .the("Username")
            .located(By.id("txtUsername"));

    public static final Target PASSWORD = Target
            .the("Password")
            .located(By.id("txtPassword"));

    public static final Target LOGIN_BTN = Target
            .the("Login")
            .located(By.id("btnLogin"));

}
