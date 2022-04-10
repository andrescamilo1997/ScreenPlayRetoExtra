package com.orangehrmlive.question.delete;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.orangehrmlive.userinterface.assignedcuerrencies.AssignedCurrencies.MSG_DELETE_OK;
import static com.orangehrmlive.util.Comparator.MSG_DELETE;

public class DeleteGradeQuestion implements Question<Boolean> {
    public DeleteGradeQuestion is(){
        return this;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return (
                MSG_DELETE_OK.resolveFor(actor).containsOnlyText(MSG_DELETE.getValue())
                );
    }
    public static DeleteGradeQuestion deleteGradeQuestion(){
        return new DeleteGradeQuestion();
    }
}
