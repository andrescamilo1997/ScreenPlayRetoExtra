package com.orangehrmlive.stepdefinitions;

import com.orangehrmlive.exceptions.ValidationTextDoNotMatch;
import com.orangehrmlive.models.OrangehrmLiveModel;
import com.orangehrmlive.stepdefinitions.setUp.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.orangehrmlive.exceptions.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static com.orangehrmlive.question.DeleteGradeQuestion.deleteGradeQuestion;
import static com.orangehrmlive.task.landingpage.DeleteCurrency.deleteCurrency;
import static com.orangehrmlive.task.landingpage.FillCurrencyPayGrades.fillCurrencyPayGrades;
import static com.orangehrmlive.task.landingpage.FillLogIn.fillLogIn;
import static com.orangehrmlive.task.landingpage.GoAndFillPayGrades.goAndFillPayGrades;
import static com.orangehrmlive.task.landingpage.OpenLandingPage.openLandingPage;
import static com.orangehrmlive.userinterface.assignedcuerrencies.AssignedCurrencies.MSG_DELETE_OK;
import static com.orangehrmlive.util.Comparator.MSG_ALL_OK_TEXT;
import static com.orangehrmlive.util.GeneralData.generalDates;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteCurrencyStepDefinition extends SetUp {
    private static final Logger LOGGER = Logger.getLogger(DeleteCurrencyStepDefinition.class);
    private static final String ACTOR_NAME = "Admin";
    private OrangehrmLiveModel orangehrmLiveModel;



    @Given("enter with your credentials and Currencies were created")
    public void enterWithYourCredentialsAndCurrenciesWereCreated() {
        try{
            orangehrmLiveModel = generalDates();


            actorSetupTheBrowser(ACTOR_NAME);
            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage(),
                    fillLogIn()
                            .useEmail("Admin")
                            .usePassword("admin123"),
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

    @When("delete created currencies")
    public void deleteCreatedCurrencies() {
        try{
            theActorInTheSpotlight().attemptsTo(
                    deleteCurrency()
            );

        }catch (Exception exception){
            LOGGER.error(exception.getMessage(), exception);
        }
    }

    @Then("displays a No records found message")
    public void displaysAMessage() {
        theActorInTheSpotlight().should(
                seeThat(
                        deleteGradeQuestion()
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
                + MSG_DELETE_OK.resolveFor(theActorInTheSpotlight()).getText();
    }
}