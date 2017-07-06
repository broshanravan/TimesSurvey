package com.feefo.times.bl;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 20/06/13
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
public class Category {

    private int categoryId;
    private String categoryName;
    private String categoryDetail;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(String categoryDetail) {
        this.categoryDetail = categoryDetail;
    }
}
