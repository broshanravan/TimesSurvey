package com.feefo.times.bl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 12/06/13
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */



public interface FormItemLoader {

    public LinkedList<FormItem> getAllQuestions ();


}
