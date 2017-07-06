package com.feefo.times.bl;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 20/06/13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class CategoryItem {
    private LinkedList<FormItem> formItemsList = new LinkedList<FormItem>();
    private int categoryId;
    private String categoryDetail;
    private String categoryName;



    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public LinkedList<FormItem> getFormItemsList() {
        return formItemsList;
    }

    public void setFormItemsList(LinkedList<FormItem> formItemsList) {
        this.formItemsList = formItemsList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(String categoryDetail) {
        this.categoryDetail = categoryDetail;
    }
}
