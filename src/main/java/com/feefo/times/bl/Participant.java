package com.feefo.times.bl;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 11/06/13
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public class Participant {

    private int participantId;
    private String title;
    private String firstName;
    private String surname;
    private String telephone;
    private String email;
    private String sex;
    private String ageBand;
    private String optIn;
    private String town;
    private String postCode;
    private String participantEmailConf;
    private String spending;
    private String termsAgreed;

    public String getTermsAgreed() {
        return termsAgreed;
    }

    public void setTermsAgreed(String termsAgreed) {
        this.termsAgreed = termsAgreed;
    }

    public String getSpending() {
        return spending;
    }

    public void setSpending(String spending) {
        this.spending = spending;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAgeBand() {
        return ageBand;
    }

    public void setAgeBand(String ageBand) {
        this.ageBand = ageBand;
    }

    public String getOptIn() {
        return optIn;
    }

    public void setOptIn(String optIn) {
        this.optIn = optIn;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getParticipantEmailConf() {
        return participantEmailConf;
    }

    public void setParticipantEmailConf(String participantEmailConf) {
        this.participantEmailConf = participantEmailConf;
    }
}
