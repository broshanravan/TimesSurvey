package com.feefo.times.service;

import com.feefo.times.bl.SubmittedAnswer;
import com.feefo.times.dl.FormDataDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 12/06/13
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
public class AnswerServImpl implements AnswerServ{

    @Autowired
    FormDataDAOImpl formDataDAO;


    public void saveAnswerSet(int participantId,LinkedList<SubmittedAnswer> answerList) {
        String a ="";
        Iterator<SubmittedAnswer> iter = answerList.iterator();
        while(iter.hasNext()) {
            SubmittedAnswer submittedAnswer= iter.next();

            submittedAnswer.setParticipantId(participantId);
            formDataDAO.saveAnswer(submittedAnswer);

        }

    }


}
