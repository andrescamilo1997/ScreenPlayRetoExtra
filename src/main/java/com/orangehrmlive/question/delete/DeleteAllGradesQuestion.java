package com.orangehrmlive.question.delete;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.orangehrmlive.userinterface.paygrades.PayGrades.MSG_BEFOR_DELETE_THE_GRADES;
import static com.orangehrmlive.util.Comparator.MSG_DELETE;

public class DeleteAllGradesQuestion implements Question<Boolean> {
    public DeleteAllGradesQuestion is(){
        return this;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return (
                MSG_BEFOR_DELETE_THE_GRADES.resolveFor(actor).containsOnlyText(MSG_DELETE.getValue())
                );
    }
    public static DeleteAllGradesQuestion deleteAllGradesQuestion(){
        return new DeleteAllGradesQuestion();
    }
}
