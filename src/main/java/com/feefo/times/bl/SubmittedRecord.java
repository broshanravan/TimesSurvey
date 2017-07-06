package com.feefo.times.bl;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 12/06/13
 * Time: 12:04
 * To change this template use File | Settings | File Templates.
 */
public class SubmittedRecord {
    private LinkedList answerList;
    private Participant participant ;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public LinkedList getAnswerList() {
        return answerList;
    }

    public void setAnswerList(LinkedList answerList) {
        this.answerList = answerList;
    }
}
