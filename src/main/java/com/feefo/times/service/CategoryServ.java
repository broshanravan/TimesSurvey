package com.feefo.times.service;

import com.feefo.times.bl.CategoryItem;
import com.feefo.times.bl.FormItem;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 20/06/13
 * Time: 14:22
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryServ {

     public LinkedList<CategoryItem> getCategoryItems();

    //LinkedList<CategoryItem> CategoryItem = new LinkedList<CategoryItem>;


}
