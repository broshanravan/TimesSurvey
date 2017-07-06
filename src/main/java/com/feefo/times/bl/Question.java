package com.feefo.times.bl;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 04/06/13
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class Question {

    private int questionId;
    private int order;
    private String text;
    private Date createDate;
    private boolean isAnswerPreset=false;
    private String txtId;
    private String cmtId;
    private int categoryId;
    private String placeHolder;

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    public String getCmtId() {
        return cmtId;
    }

    public void setCmtId(String cmtId) {
        this.cmtId = cmtId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isAnswerPreset() {
        return isAnswerPreset;
    }

    public void setAnswerPreset(boolean answerPreset) {
        isAnswerPreset = answerPreset;
    }
}
