package com.feefo.times.bl;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 05/06/13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class FormItem {

    Question question;
    PresetAnswer presetAnswer= new PresetAnswer() ;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public PresetAnswer getPresetAnswer() {
        return presetAnswer;
    }

    public void setPresetAnswer(PresetAnswer presetAnswer) {
        this.presetAnswer = presetAnswer;
    }
}
