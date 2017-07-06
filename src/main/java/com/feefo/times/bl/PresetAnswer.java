package com.feefo.times.bl;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 05/06/13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class PresetAnswer {

    private String answerType;
    private LinkedList<String> answerList  ;
    private String  answerText;

    public LinkedList<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(LinkedList<String> answerList) {
        this.answerList = answerList;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
