package com.orangehrmlive.stepdefinitions;

import com.orangehrmlive.exceptions.ValidationTextDoNotMatch;
import com.orangehrmlive.models.OrangehrmLiveModel;
import com.orangehrmlive.stepdefinitions.setUp.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.orangehrmlive.exceptions.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static com.orangehrmlive.question.PayGradeMINQuestion.payGradeMINQuestion;
import static com.orangehrmlive.question.PayGradeMaxQuestion.payGradeMaxQuestion;
import static com.orangehrmlive.question.PayGradeQuestion.payGradeQuestion;
import static com.orangehrmlive.task.landingpage.FillCurrencyPayGrades.fillCurrencyPayGrades;
import static com.orangehrmlive.task.landingpage.FillLogIn.fillLogIn;
import static com.orangehrmlive.task.landingpage.GoAndFillPayGrades.goAndFillPayGrades;
import static com.orangehrmlive.task.landingpage.OpenLandingPage.openLandingPage;
import static com.orangehrmlive.userinterface.assignedcuerrencies.AssignedCurrencies.*;
import static com.orangehrmlive.util.Comparator.MSG_ALL_OK_TEXT;
import static com.orangehrmlive.util.Constants.pass;
import static com.orangehrmlive.util.Constants.user;
import static com.orangehrmlive.util.GeneralData.generalDates;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static org.hamcrest.CoreMatchers.equalTo;

public class PayGradesStepDefinition extends SetUp {
    private static final Logger LOGGER = Logger.getLogger(PayGradesStepDefinition.class);
    private static final String ACTOR_NAME = "Admin";
    private OrangehrmLiveModel orangehrmLiveModel = generalDates();


    @Given("enter with your credentials and enter the pay grades section")
    public void enterWithYourCredentialsAndEnterThePayGradesSection() {
        try{
            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
            );

        }catch (Exception exception){
            LOGGER.error(exception.getMessage(), exception);
        }

    }

    @When("enters a new degree, and assigns it a currencies")
    public void entersANewDegreeAndAssignsItACurrencies() {
        try{
            theActorInTheSpotlight().attemptsTo(
                    fillLogIn()
                            .useEmail(user)
                            .usePassword(pass),
                    goAndFillPayGrades()
                            .useName(orangehrmLiveModel.getName()),
                    fillCurrencyPayGrades()
                            .useCurrency(orangehrmLiveModel.getCurrency())
                            .useMaximum(orangehrmLiveModel.getMaximum())
                            .useMinimum(orangehrmLiveModel.getMinimum())
            );

        }catch (Exception exception){
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("Currencies are added to a list")
    public void currenciesAreAddedToAList() {

        theActorInTheSpotlight().should(
                seeThat(
                        payGradeQuestion()
                                .useMSG_CURRENCY(MSG_ALL_OK_TEXT.getValue())
                                .is(), equalTo(true)
                ),
                seeThat(
                        payGradeMINQuestion()
                                .useMinCurrency(orangehrmLiveModel.getMinimum())
                                .is(), equalTo(true)
                ),
                seeThat(
                        payGradeMaxQuestion()
                                .useMaxCurrency(orangehrmLiveModel.getMaximum())
                                .is(), equalTo(true)
                )
                        .orComplainWith(ValidationTextDoNotMatch.class,
                                String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome()))
        );

    }

    private String compareInWithSystemOutcome(){
        return "\n"
                + "Data for test : System outcome" + "\n"
                + MSG_ALL_OK_TEXT.getValue() + " : "
                + MSG_LIST_OK_CURRENCY.resolveFor(theActorInTheSpotlight()).getText() + "\n"
                + orangehrmLiveModel.getMaximum() + " : "
                + MSG_LIST_OK_MAX_CURRENCY.resolveFor(theActorInTheSpotlight()).getText() + "\n"
                + orangehrmLiveModel.getMinimum() + " : "
                + MSG_LIST_OK_MIN_CURRENCY.resolveFor(theActorInTheSpotlight()).getText();
    }

}
