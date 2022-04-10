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

    public static final Target CHECK_ALL_GRADES = Target
            .the("Select all the Grades")
            .located(By.id("ohrmList_chkSelectAll"));

    public static final Target DELETE_THE_GRADES = Target
            .the("Delete the Grades")
            .located(By.id("btnDelete"));

    public static final Target MSG_BEFOR_DELETE_THE_GRADES = Target
            .the("Msg before delete the Grades")
            .located(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td"));

    public static final Target ACEPT_THE_DIALOG = Target
            .the("acept the dialog")
            .located(By.id("dialogDeleteBtn"));
}
