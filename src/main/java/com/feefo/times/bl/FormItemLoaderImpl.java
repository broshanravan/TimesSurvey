package com.feefo.times.bl;

import com.feefo.times.dl.FormDataDAOImpl;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 05/06/13
 * Time: 10:06
 * To change this template use File | Settings | File Templates.
 */


public class FormItemLoaderImpl implements FormItemLoader  {

    @Autowired
    FormDataDAOImpl formDataDAO;


    public LinkedList<FormItem> getAllQuestions (){
        LinkedList<FormItem> formItemList =new  LinkedList<FormItem>();// constructItemsList();


        LinkedList<Question> questionList= formDataDAO.getAllQuestions();
        Iterator<Question> iter= questionList.iterator();
        while(iter.hasNext()){
            Question question=  iter.next();
            FormItem formItem = new FormItem();
            formItem.setQuestion(question);

            PresetAnswer potentialAnswer = new PresetAnswer();
            if(question.isAnswerPreset()){
                potentialAnswer.setAnswerType("dropDown");
                LinkedList<String> answerList= formDataDAO.getPresetAnswers(question.getQuestionId()) ;
                potentialAnswer.setAnswerList(answerList);

            }else{
                potentialAnswer.setAnswerType("text");
            }

            formItem.setPresetAnswer(potentialAnswer);


            formItemList.add(formItem);
        }


        //formItemList=this.constructItemsList() ;
        return formItemList;
    }

    public void setFormDataDAO(FormDataDAOImpl formDataDAO) {
        this.formDataDAO = formDataDAO;
    }


    private  LinkedList<FormItem>  constructItemsListFromDB(){
        LinkedList<FormItem> formItemList = new LinkedList<FormItem>();



        return formItemList;
    }


//   private  LinkedList<FormItem>  constructItemsList(){
//
//        List<String> questionTextList= new ArrayList<String>()   ;
//        questionTextList.add("Best overall travel company") ;
//        questionTextList.add("Best family travel company")  ;
//        questionTextList.add( "Best adventure travel company") ;
//        questionTextList.add("Best specialist travel company (for example: art, safari, sport, country [such as Africa, Japan])")  ;
//        questionTextList.add( "Best ski company") ;
//        questionTextList.add("Best ocean cruise company");
//        questionTextList.add("Best river cruise company");
//        questionTextList.add("Best short haul airline");
//        questionTextList.add("Best long haul airline");
//        questionTextList.add("Best UK hotel");
//        questionTextList.add("Best European hotel");
//        questionTextList.add("Best hotel worldwide");
//        questionTextList.add("Best European destination") ;
//        questionTextList.add("Best worldwide destination");
//        questionTextList.add("Best Uk city") ;
//        questionTextList.add("Best overseas city") ;
//        questionTextList.add("Best spa");
//        questionTextList.add("Best travel booking website") ;
//        questionTextList.add("Plus three editors awards");
//
//        LinkedList<FormItem> formItemList = new LinkedList<FormItem>();
//
//        Iterator<String> iter= questionTextList.iterator();
//        int id=1;
//        while(iter.hasNext())  {
//            String QuestionTxt=iter.next();
//            Question question= new Question();
//
//            question.setQuestionId(id);
//            question.setText(QuestionTxt);
//
//            FormItem formItem = new FormItem();
//            formItem.setQuestion(question);
//
//            formItemList.add(formItem);
//
//            id++;
//
//        }
//
//
//
//
//        return formItemList;
//    }

}
