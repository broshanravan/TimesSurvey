package com.feefo.times.service;

import com.feefo.times.bl.FormItem;
import com.feefo.times.bl.Question;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 12/06/13
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public interface QuestionServ {
    public LinkedList<FormItem> getAllQuestions();
    public LinkedList<FormItem> getCategoryQuestions (int categoryId);
}
