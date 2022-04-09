package com.orangehrmlive.userinterface.paygrades;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PayGrades extends PageObject {
    public static final Target GOT_TO_ADMIN = Target
            .the("go to admin")
            .located(By.id("menu_admin_viewAdminModule"));

    public static final Target GOT_TO_JOB = Target
            .the("go to job")
            .located(By.id("menu_admin_Job"));

    public static final Target GOT_TO_PAY_GRADES = Target
            .the("go to pay grades")
            .located(By.id("menu_admin_viewPayGrades"));

    public static final Target BTN_ADD = Target
            .the("Add pay grades")
            .located(By.id("btnAdd"));

    public static final Target ADD_NAME_TO_GRADE = Target
            .the("Add name grade")
            .located(By.id("payGrade_name"));

    public static final Target BTN_SAVE = Target
            .the("Save the name")
            .located(By.id("btnSave"));
}
