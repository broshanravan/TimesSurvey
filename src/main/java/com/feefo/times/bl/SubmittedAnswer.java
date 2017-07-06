package com.feefo.times.bl;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 03/06/13
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
public class SubmittedAnswer {




    private int submittedAnswerId;
    private int questionId;
    private int participantId;
    private String  submittedAnswerComments;
    private String  submittedAnswerText;

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getSubmittedAnswerComments() {
        return submittedAnswerComments;
    }

    public void setSubmittedAnswerComments(String submittedAnswerComments) {
        this.submittedAnswerComments = submittedAnswerComments;
    }

    public int getSubmittedAnswerId() {
        return submittedAnswerId;
    }

    public void setSubmittedAnswerId(int submittedAnswerId) {
        this.submittedAnswerId = submittedAnswerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getSubmittedAnswerText() {
        return submittedAnswerText;
    }

    public void setSubmittedAnswerText(String submittedAnswerText) {
        this.submittedAnswerText = submittedAnswerText;
    }


}
