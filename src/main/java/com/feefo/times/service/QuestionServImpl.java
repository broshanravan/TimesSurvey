package com.feefo.times.service;

import com.feefo.times.bl.FormItem;
import com.feefo.times.bl.PresetAnswer;
import com.feefo.times.bl.Question;
import com.feefo.times.dl.FormDataDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 12/06/13
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
public class QuestionServImpl implements QuestionServ {

    @Autowired
    FormDataDAOImpl formDataDAO;

    public LinkedList<FormItem> getCategoryQuestions (int categoryId){
        LinkedList<FormItem> formItemList =new  LinkedList<FormItem>();
        LinkedList<Question> questionList= formDataDAO.getAllCategoriesQuestions(categoryId);
        Iterator<Question> iter= questionList.iterator();
        while(iter.hasNext()){
            Question question=  iter.next();
            FormItem formItem = new FormItem();
            formItem.setQuestion(question);

            PresetAnswer potentialAnswer = new PresetAnswer();

            LinkedList<String> answerList= formDataDAO.getPresetAnswers(question.getQuestionId()) ;
            potentialAnswer.setAnswerList(answerList);

            formItem.setPresetAnswer(potentialAnswer);

            formItemList.add(formItem);
        }


        //formItemList=this.constructItemsList() ;
        return formItemList;


    }

    public LinkedList<FormItem> getAllQuestions (){

        LinkedList<FormItem> formItemList =new  LinkedList<FormItem>();// constructItemsList();


        LinkedList<Question> questionList= formDataDAO.getAllQuestions();
        Iterator<Question> iter= questionList.iterator();
        while(iter.hasNext()){
            Question question=  iter.next();
            FormItem formItem = new FormItem();
            formItem.setQuestion(question);

            PresetAnswer potentialAnswer = new PresetAnswer();

            LinkedList<String> answerList= formDataDAO.getPresetAnswers(question.getQuestionId()) ;
             potentialAnswer.setAnswerList(answerList);

            formItem.setPresetAnswer(potentialAnswer);

            formItemList.add(formItem);
        }


        //formItemList=this.constructItemsList() ;
        return formItemList;
    }

}
