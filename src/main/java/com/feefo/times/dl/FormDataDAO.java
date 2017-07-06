package com.feefo.times.dl;

import com.feefo.times.bl.*;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 03/06/13
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
public interface FormDataDAO {

    public void saveAnswer(SubmittedAnswer submittedAnswer);

    public LinkedList<Question> getAllQuestions();

    public LinkedList<String> getPresetAnswers(int questionId);

    public LinkedList<Category> getAllCategories();

    public LinkedList<Question> getAllCategoriesQuestions(int categoryId);

    public int saveParticipantDetail(Participant participant);

    public boolean emailExists(String email);

}
