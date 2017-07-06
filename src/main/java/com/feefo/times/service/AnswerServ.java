package com.feefo.times.service;

import com.feefo.times.bl.SubmittedAnswer;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 12/06/13
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
public interface AnswerServ {

    public void saveAnswerSet( int articipantId, LinkedList<SubmittedAnswer> answerList);


}
