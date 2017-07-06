package com.feefo.times.pl.controllers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.feefo.times.bl.CategoryItem;
import com.feefo.times.bl.FormItem;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 05/06/13
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
@SessionAttributes("surveyFormBean")
public class SurveyFormBean {

    private Map<String, String> questionsMap = new HashMap<String, String>();
    private Map<String, String> answerMapText = new HashMap<String, String>();
    private Map<String, String> answerMapCmt = new HashMap<String, String>();
    private Map<String, String> answerMapDropDown = new HashMap<String, String>() ;
    private LinkedList<FormItem> formItemsList = new LinkedList<FormItem>();
    private LinkedList<String> spendingBandList = new LinkedList<String>();
    private LinkedList<CategoryItem> categoryItemList = new LinkedList<CategoryItem>();
    private String erorMsg="error";

    private String first ="y";
    private String floater;
    private String key;

    private String participantTitle;
    private String participantFirstName;
    private String participantSruname;
    private String participantPostCode;
    private String participantAgeBand;

    private String participantEmail;
    private String participantEmailConf;
    private String participantTelephone;
    private String participantSpendingBand;
    private String participantSex;
    private String participantTown;
    private String scrollx;
    private String toBeContacted ;


    private boolean termsAgreed=false;
    private boolean participantOptIn=false;

    public SurveyFormBean(){
        populateSpendingbandlist();
    }


    public boolean isTermsAgreed() {
        return termsAgreed;
    }

    public void setTermsAgreed(boolean termsAgreed) {
        this.termsAgreed = termsAgreed;
    }

    public boolean isParticipantOptIn() {
        return participantOptIn;
    }

    public void setParticipantOptIn(boolean participantOptIn) {
        this.participantOptIn = participantOptIn;
    }

    public String getScrolly() {
        return scrolly;
    }

    public void setScrolly(String scrolly) {
        this.scrolly = scrolly;
    }

    public String getScrollx() {
        return scrollx;
    }

    public void setScrollx(String scrollx) {
        this.scrollx = scrollx;
    }

    private String scrolly;



    public String getErorMsg() {
        return erorMsg;
    }

    public void setErorMsg(String erorMsg) {
        this.erorMsg = erorMsg;
    }

    public String getParticipantEmailConf() {
        return participantEmailConf;
    }

    public void setParticipantEmailConf(String participantEmailConf) {
        this.participantEmailConf = participantEmailConf;
    }

    public String getParticipantTown() {
        return participantTown;
    }

    public void setParticipantTown(String participantTown) {
        this.participantTown = participantTown;
    }

    public String getParticipantSex() {
        return participantSex;
    }

    public void setParticipantSex(String participantSex) {
        this.participantSex = participantSex;
    }

    public String getParticipantSpendingBand() {
        return participantSpendingBand;
    }

    public void setParticipantSpendingBand(String participantSpendingBand) {
        this.participantSpendingBand = participantSpendingBand;
    }

    public String getParticipantTitle() {
        return participantTitle;
    }

    public void setParticipantTitle(String participantTitle) {
        this.participantTitle = participantTitle;
    }

    public String getParticipantPostCode() {
        return participantPostCode;
    }

    public void setParticipantPostCode(String participantPostCode) {
        this.participantPostCode = participantPostCode;
    }

    public String getParticipantAgeBand() {
        return participantAgeBand;
    }

    public void setParticipantAgeBand(String participantAgeBand) {
        this.participantAgeBand = participantAgeBand;
    }



    public LinkedList<CategoryItem> getCategoryItemList() {
        return categoryItemList;
    }

    public void setCategoryItemList(LinkedList<CategoryItem> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }

    public String getParticipantTelephone() {
        return participantTelephone;
    }

    public void setParticipantTelephone(String participantTelephone) {
        this.participantTelephone = participantTelephone;
    }

    public String getParticipantSruname() {
        return participantSruname;
    }

    public void setParticipantSruname(String participantSruname) {
        this.participantSruname = participantSruname;
    }

    public String getParticipantFirstName() {
        return participantFirstName;
    }

    public void setParticipantFirstName(String participantFirstName) {
        this.participantFirstName = participantFirstName;
    }



    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    public Map<String, String> getAnswerMapText() {
        return answerMapText;
    }

    public void setAnswerMapText(Map<String, String> answerMapText) {
        this.answerMapText = answerMapText;
    }

    public Map<String, String> getAnswerMapDropDown() {
        return answerMapDropDown;
    }

    public void setAnswerMapDropDown(Map<String, String> answerMapDropDown) {
        this.answerMapDropDown = answerMapDropDown;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFloater() {
        return floater;
    }

    public void setFloater(String floater) {
        this.floater = floater;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }



    public Map<String, String> getQuestionsMap() {
        return questionsMap;
    }

    public void setQuestionsMap(Map<String, String> questionsMap) {
        this.questionsMap = questionsMap;
    }

    public LinkedList<FormItem> getFormItemsList() {
        return formItemsList;
    }

    public void setFormItemsList(LinkedList<FormItem> formItemsList) {
        this.formItemsList = formItemsList;
    }


    public Map<String, String> getAnswerMapCmt() {
        return answerMapCmt;
    }

    public void setAnswerMapCmt(Map<String, String> answerMapCmt) {
        this.answerMapCmt = answerMapCmt;
    }


    public LinkedList<String> getSpendingBandList() {
        return spendingBandList;
    }

    public void setSpendingBandList(LinkedList<String> spendingBandList) {
        this.spendingBandList = spendingBandList;
    }

    public void populateSpendingbandlist(){
        spendingBandList.add("Please Select");
        spendingBandList.add("Under £1000");
        spendingBandList.add("£1001-£3000");
        spendingBandList.add("£3001-£5000");
        spendingBandList.add( "£5001-£10000");
        spendingBandList.add("£10001-£15000");
        spendingBandList.add("£15001-£25000");
        spendingBandList.add("Over £25000");
    }
}
