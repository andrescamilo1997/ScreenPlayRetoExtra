package com.orangehrmlive.userinterface.assignedcuerrencies;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AssignedCurrencies extends PageObject {

    public static final Target ADD_ASSIGNED = Target
            .the("add assigned")
            .located(By.id("btnAddCurrency"));

    public static final Target NAME_CURRENCY = Target
            .the("add assigned")
            .located(By.id("payGradeCurrency_currencyName"));

    public static final Target MAXIMUM_SALARY = Target
            .the("Maximum Salary")
            .located(By.id("payGradeCurrency_maxSalary"));

    public static final Target MINIMUM_SALARY = Target
            .the("Minimum Salary")
            .located(By.id("payGradeCurrency_minSalary"));

    public static final Target BTN_SAVE_CURRENCY = Target
            .the("Save Currency")
            .located(By.id("btnSaveCurrency"));

    public static final Target MSG_LIST_OK = Target
            .the("save all ok")
            .located(By.xpath("//*[@id=\"tblCurrencies\"]/tbody/tr/td[2]/a"));

    public static final Target  CHECK_DELETE = Target
            .the("Delete this Currency")
            .located(By.name("delCurrencies[]"));

    public static final Target  BTN_DELETE = Target
            .the("Delete the Currency")
            .located(By.id("btnDeleteCurrency"));

    public static final Target  MSG_DELETE_OK = Target
            .the("Msg no records")
            .located(By.xpath("//*[@id=\"tblCurrencies\"]/tbody/tr/td[2]"));

}
