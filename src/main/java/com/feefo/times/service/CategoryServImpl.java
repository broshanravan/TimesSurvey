package com.feefo.times.service;

import com.feefo.times.bl.*;
import com.feefo.times.dl.FormDataDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 20/06/13
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */
public class CategoryServImpl implements CategoryServ {
    @Autowired
    FormDataDAOImpl formDataDAO;

    @Autowired
    QuestionServImpl QuestionServ;

    public LinkedList<CategoryItem> getCategoryItems(){

        LinkedList<CategoryItem> categoryItemList = new LinkedList<CategoryItem>();


        LinkedList<Category> categoryList =formDataDAO.getAllCategories();

        Iterator<Category> iter=  categoryList.iterator() ;
        while(iter.hasNext())   {
            Category category = iter.next();
            CategoryItem categoryItem = new CategoryItem();

            String detail=category.getCategoryDetail() ;
            //String detail1 =detail.replaceAll("'","\'");

           // detail="We've" ;

            categoryItem.setCategoryDetail(detail);
            categoryItem.setCategoryName(category.getCategoryName());
            categoryItem.setCategoryId(category.getCategoryId());

            LinkedList<FormItem> formItemList =  QuestionServ.getCategoryQuestions(categoryItem.getCategoryId()) ;
            categoryItem.setFormItemsList(formItemList);

            categoryItemList.add(categoryItem);
        }

//        LinkedList<Question> questionList= formDataDAO.getAllQuestions();
//        LinkedList<FormItem> formItemList1 =new  LinkedList<FormItem>();
//        LinkedList<FormItem> formItemList2 =new  LinkedList<FormItem>();
//        LinkedList<FormItem> formItemList3 =new  LinkedList<FormItem>();
//        LinkedList<FormItem> formItemList4 =new  LinkedList<FormItem>();
//        LinkedList<FormItem> formItemList5 =new  LinkedList<FormItem>();
//        LinkedList<FormItem> formItemList6 =new  LinkedList<FormItem>();
//        Iterator<Question> iter= questionList.iterator();
//        while(iter.hasNext()){
//            Question question=  iter.next();
//            FormItem formItem = new FormItem();
//            formItem.setQuestion(question);
//
//            PresetAnswer potentialAnswer = new PresetAnswer();
//
//            LinkedList<String> answerList= formDataDAO.getPresetAnswers(question.getQuestionId()) ;
//            potentialAnswer.setAnswerList(answerList);
//
//            formItem.setPresetAnswer(potentialAnswer);
//
//            if (question.getCategoryId()==1) {
//                formItemList1.add(formItem);
//            }else if(question.getCategoryId()==1) {
//                formItemList1.add(formItem);
//            }else if(question.getCategoryId()==2) {
//                formItemList2.add(formItem);
//            }else if(question.getCategoryId()==3) {
//                formItemList3.add(formItem);
//            }else if(question.getCategoryId()==4) {
//                formItemList4.add(formItem);
//            }else if(question.getCategoryId()==5) {
//                formItemList5.add(formItem);
//            }else if(question.getCategoryId()==6) {
//                formItemList6.add(formItem);
//            }
//
//        }
//
//        CategoryItem categoryItem1 = new CategoryItem();
//        categoryItem1.setFormItemsList(formItemList1);
//        categoryItem1.setCategoryId(1);
//        categoryItem1.setCategoryDetail("category1");
//
//
//        CategoryItem categoryItem2 = new CategoryItem();
//        categoryItem2.setFormItemsList(formItemList2);
//        categoryItem2.setCategoryId(2);
//        categoryItem2.setCategoryDetail("category2");
//
//        CategoryItem categoryItem3 = new CategoryItem();
//        categoryItem3.setFormItemsList(formItemList3);
//        categoryItem3.setCategoryId(3);
//        categoryItem3.setCategoryDetail("category3");
//
//        CategoryItem categoryItem4 = new CategoryItem();
//        categoryItem4.setFormItemsList(formItemList4);
//        categoryItem4.setCategoryId(4);
//        categoryItem4.setCategoryDetail("category4");
//
//        CategoryItem categoryItem5 = new CategoryItem();
//        categoryItem5.setFormItemsList(formItemList5);
//        categoryItem5.setCategoryId(5);
//        categoryItem5.setCategoryDetail("category5");
//
//        CategoryItem categoryItem6 = new CategoryItem();
//
//        categoryItem6.setFormItemsList(formItemList6);
//        categoryItem6.setCategoryId(6);
//        categoryItem6.setCategoryDetail("category6");
//
//        categoryItemList.add(categoryItem1);
//        categoryItemList.add(categoryItem2);
//        categoryItemList.add(categoryItem3);
//        categoryItemList.add(categoryItem4);
//        categoryItemList.add(categoryItem5);
//        categoryItemList.add(categoryItem6);



        return categoryItemList;

    }

    //

}
