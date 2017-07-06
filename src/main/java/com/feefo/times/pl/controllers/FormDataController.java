package com.feefo.times.pl.controllers;

import com.feefo.times.bl.*;
import com.feefo.times.service.AnswerServ;
import com.feefo.times.service.CategoryServ;
import com.feefo.times.service.ParticipantServ;
import com.feefo.times.service.QuestionServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 03/06/13
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */

@Controller
//@RequestMapping("/index.htm")
@SessionAttributes("responseFormBean")
public class FormDataController {
    static Logger log = Logger.getLogger("FormDataController");

    Map<String, String> questionMap = new HashMap<String, String> ();



    @Autowired
    FormItemLoader formItemLoader;

    @Autowired
    QuestionServ questionServ;


    @Autowired
    AnswerServ answerServ;

    @Autowired
    CategoryServ categoryServ;


    @Autowired
    ParticipantServ participantServ;


    @ModelAttribute("responseFormBean")
    public ResponseFormBean createFormBean() {
        return new ResponseFormBean();
    }

    @RequestMapping(value="/responseFormBean")
    public ModelAndView submitFormData() {
        ModelAndView model = new ModelAndView("timesQuestionList.jsp");


        return model;
    }

    @RequestMapping(value="index.htm", method = RequestMethod.GET)
    public ModelAndView viewFormData() {

        Map<String, String> answerMapText = new HashMap<String, String> ();
        Map<String, String> answerMapDropDown = new HashMap<String, String> ();
        Map<String, String> answerMapCmt = new HashMap<String, String> ();

        int i=1;
        LinkedList<FormItem> formItemList= questionServ.getAllQuestions();
        LinkedList<CategoryItem> categoryItemList=categoryServ.getCategoryItems();
       // populateQuestionsMap(formItemList);
        //populateItemsMap(formItemList);

        SurveyFormBean surveyFormBean = new SurveyFormBean();
        // contactForm.setContactMap(contactMap);
        surveyFormBean.setQuestionsMap(questionMap);
        surveyFormBean.setAnswerMapText(answerMapText);
        surveyFormBean.setAnswerMapCmt(answerMapCmt);
        surveyFormBean.setAnswerMapDropDown(answerMapDropDown);
       // surveyFormBean.setFormItemsList(formItemList);
        surveyFormBean.setCategoryItemList(categoryItemList);

        // ModelAndView model = new ModelAndView("timesQuestionList.jsp");

        ModelAndView model=  new ModelAndView("timesQuestionList.jsp" , "surveyFormBean", surveyFormBean);

        model.addObject("categoryItemList",categoryItemList)  ;
        model.addObject("spendingBandList",surveyFormBean.getSpendingBandList())  ;
        return model;
    }


    @RequestMapping(value="feefo.htm")
    public ModelAndView gotoFeefoLink(){
        return (new ModelAndView(new RedirectView("http://www.feefo.com")));
    }

    @RequestMapping(value="tc.htm")
    public String handleTermConditionsLink(){
         return "TCs.jsp";
    }

//    @Autowired
//    public void setFormItemLoader(FormItemLoader formItemLoader) {
//        this.formItemLoader = formItemLoader;
//    }


    @RequestMapping(value="index.htm", method=RequestMethod.POST)
    public ModelAndView processForm(HttpServletRequest request,@ModelAttribute(value="surveyFormBean") SurveyFormBean surveyFormBean,BindingResult result){

        Map<String, String>  retrunAnswerMapText = new HashMap<String, String> ();
        Map<String, String>  retrunAnswerMapDropDown = new HashMap<String, String> ();
        Map<String, String>  retrunAnswerMapCmt = new HashMap<String, String> () ;

        Map<String, String> answerMapText = new HashMap<String, String> ();
        Map<String, String> answerMapDropDown = new HashMap<String, String> ();
        Map<String, String> answerMapCmt = new HashMap<String, String> ();

        ModelAndView model=new ModelAndView("timesQuestionList.jsp" , "surveyFormBean", surveyFormBean);

        Participant participant = getParticipantDetais(surveyFormBean);

        LinkedList<SubmittedAnswer> answerList= new   LinkedList<SubmittedAnswer>();
        LinkedList<String>  addedAnswersList= new LinkedList<String>();
        answerMapText=surveyFormBean.getAnswerMapText() ;
        //surveyFormBean.getAnswerMapCmt();
        answerMapCmt=  surveyFormBean.getAnswerMapCmt();
        answerMapDropDown=surveyFormBean.getAnswerMapDropDown();

        retrunAnswerMapText=surveyFormBean.getAnswerMapText()  ;
        retrunAnswerMapDropDown= surveyFormBean.getAnswerMapDropDown();
        retrunAnswerMapCmt=surveyFormBean.getAnswerMapCmt();


        Iterator iterTxt =answerMapText.entrySet().iterator();
        while (iterTxt.hasNext()) {

            Map.Entry pairs = (Map.Entry)iterTxt.next();

            String txtKey=(String) pairs.getKey() ;
            String answerTxt=  (String)pairs.getValue() ;
            int lenght= txtKey.length() ;
            txtKey= txtKey.substring(0,lenght-4);


            String presetText="Please Enter" ;
            if( answerTxt!=null && !"".equalsIgnoreCase(answerTxt.trim()) && !(answerTxt.contains(presetText)) && !addedAnswersList.contains(txtKey)){

                if(answerTxt.length()>250) {
                    answerTxt=answerTxt.substring(0,250);
                }

                SubmittedAnswer answer = new SubmittedAnswer() ;
                answer.setQuestionId(Integer.parseInt(txtKey));
                answer.setSubmittedAnswerText(answerTxt);


                Iterator commentIter= answerMapCmt.entrySet().iterator();
                while(commentIter.hasNext()){
                    Map.Entry commentPairs = (Map.Entry)commentIter.next();


                    String commentKey=(String) commentPairs.getKey() ;
                    String commentTxt=  (String)commentPairs.getValue() ;

                    commentKey= commentKey.substring(0,lenght-4);
                     String presetTextCmt="COMMENTS (" ;
                     if(commentKey.equalsIgnoreCase(txtKey)&& !(commentTxt.contains(presetTextCmt)) ){
                            answer.setSubmittedAnswerComments(commentTxt);
                     }

                }

                answerList.add(answer);
                addedAnswersList.add(txtKey);
            }

        }

        boolean commentsTooLong= false;
        String presetChoice="Or select" ;
        Iterator iterDropDown =answerMapDropDown.entrySet().iterator();
        while (iterDropDown.hasNext()) {
                    Map.Entry pairs = (Map.Entry)iterDropDown.next();
                    String dropDownKey=(String) pairs.getKey() ;
                    String dropDownTxt=  (String)pairs.getValue() ;

                    if(dropDownTxt!=null && !dropDownTxt.contains(presetChoice) && !addedAnswersList.contains(dropDownKey)){
                        SubmittedAnswer answer = new SubmittedAnswer() ;
                        answer.setQuestionId(Integer.parseInt(dropDownKey));
                        answer.setSubmittedAnswerText(dropDownTxt);

                        Iterator commentIter= answerMapCmt.entrySet().iterator();
                        while(commentIter.hasNext()){
                                Map.Entry commentPairs = (Map.Entry)commentIter.next();


                                String commentKey=(String) commentPairs.getKey() ;
                                String commentTxt=  (String)commentPairs.getValue() ;
                                int lenght= commentKey.length();
                                commentKey= commentKey.substring(0,lenght-4);
                                String presetTextCmt="COMMENTS (" ;
                                if(commentKey.equalsIgnoreCase(dropDownKey)&& !(commentTxt.contains(presetTextCmt)) ){
                                    if(commentTxt!=null &&commentTxt.length()>5000){
                                        commentTxt=  commentTxt.substring(0,5000);
                                    }
                                    answer.setSubmittedAnswerComments(commentTxt);

                                }
                        }

                        answerList.add(answer);
                    }

            }
            int numQuesAns=getNumberanswered(answerList) ;
            LinkedList<CategoryItem> categoryItemList=categoryServ.getCategoryItems();
            if (answerList.size()>9){
                 surveyFormBean.setErorMsg("");
                    try{
                            if(participantServ.alreadyVoted(participant)){
                                request.getSession().setAttribute("alreadyEntered","Y");
                                request.setAttribute("hasError","Y");
                                String errorMsg="The vote for this email has already been entered, only one vote per email"  ;
                                result.addError(new ObjectError("question",errorMsg)) ;
                            }else{
                                request.getSession().removeAttribute("alreadyEntered");
                                String errorMsg="";
                                if(commentsTooLong){
                                    request.setAttribute("hasError","Y");
                                    errorMsg= "Thank you for your nomination. There is a limit on comments fields. Comment more that 100 words could not be accommodated for! " ;
                                    model=  new ModelAndView("timesQuestionList.jsp" , "surveyFormBean", surveyFormBean);
                                    result.addError(new ObjectError("question",errorMsg));
                                }else{
                                    int participantId=   participantServ.saveParticipant(participant) ;
                                    answerServ.saveAnswerSet(participantId, answerList);
                                    boolean termsAgreed= surveyFormBean.isTermsAgreed();
                                    if(termsAgreed){
                                        model=  new ModelAndView("thankYou.jsp" , "surveyFormBean", surveyFormBean);
                                    } else{
                                        errorMsg="You need to agree to Terms and Conditions before proceeding"  ;
                                        request.setAttribute("hasError","Y");
                                        result.addError(new ObjectError("question",errorMsg));
                                    }

                                }

                        }

                        surveyFormBean.setQuestionsMap(questionMap);
                        surveyFormBean.setAnswerMapText(answerMapText);
                        surveyFormBean.setAnswerMapCmt(answerMapCmt);




                }catch(Exception e){
                    try{
                        PrintWriter pw = new PrintWriter(new FileOutputStream("times_Log"));
                        e.printStackTrace(pw);
                    } catch(Exception ex){
                        e.printStackTrace() ;
                        ex.printStackTrace();
                    }
                    request.setAttribute("hasError","Y");
                    String errorMsg= "A network error has accord while submitting the form. Please try again later! " ;
                    model=  new ModelAndView("timesQuestionList.jsp" , "surveyFormBean", surveyFormBean);

                }

            }else{

                 surveyFormBean.setAnswerMapText(answerMapText);
                 surveyFormBean.setAnswerMapCmt(answerMapCmt);
                 surveyFormBean.setAnswerMapDropDown(answerMapDropDown);
                 surveyFormBean.setCategoryItemList(categoryItemList);
                 int remainder= 10-numQuesAns;
                 String ans= "questions have";

                 String errorMsg="";

                 if (numQuesAns==0){
                    request.setAttribute("hasError","Y");
                    errorMsg="In addition to your personal details, please answer 10 or more questions before next submitting";
                 }else if(numQuesAns==1) {
                    request.setAttribute("hasError","Y");
                    ans= "question has" ;
                    errorMsg= "Thank you for your nomination. Only "+ numQuesAns+" " +ans+ "  been answered so please answer "+ remainder +" more before next submitting" ;
                 }else if(1<numQuesAns &&numQuesAns<10){
                    request.setAttribute("hasError","Y");
                    errorMsg= "Thank you for your nominations. Only "+ numQuesAns+" " +ans+ "  been answered so please answer "+ remainder +" more before next submitting";
                 }

                result.addError(new ObjectError("question",errorMsg));
                surveyFormBean.setErorMsg("Please answer at least nine question (N/A will not be qualified as an answer)");
                model=  new ModelAndView("timesQuestionList.jsp" , "surveyFormBean", surveyFormBean);
                request.getRequestURL();
                StringBuffer url=request.getRequestURL() ;

            }

        Map objectMap = new HashMap();
        objectMap.put("surveyFormBean", surveyFormBean);
        model.addObject("categoryItemList",categoryItemList);
        model.addObject("spendingBandList",surveyFormBean.getSpendingBandList())  ;
        return model ;
    }

    private  Map<String, String>  populateQuestionsMap( LinkedList <FormItem> formItemList){
        //LinkedList<FormItem> questionsList= formItemLoader. getAllGuestions();

        Iterator<FormItem> iter =  formItemList.iterator();
        while(iter.hasNext()){
            FormItem formItem = iter.next();
            questionMap.put(String .valueOf(formItem.getQuestion().getQuestionId()), formItem.getQuestion().getText());
           // answerMap.put(String .valueOf(formItem.getQuestion().getQuestionId()),"") ;

        }
        return  questionMap;

    }

    private boolean isValidemail(String email){
        boolean isValid= false;

        if( email!=null && !"".equalsIgnoreCase(email.trim())&&email.contains("@")) {
            isValid= true;
        }


        return isValid;
    }

    private boolean isValidPhone(String phoneNo){
        boolean isValid= true;

        if( phoneNo!=null && !"".equalsIgnoreCase(phoneNo.trim())){

            try{
                Long.parseLong(phoneNo)  ;
            }catch (NumberFormatException e){
                isValid= false;
            } catch (Exception e){
                isValid= false;
            }

        }

        return isValid;
    }

    private int  getNumberanswered(LinkedList<SubmittedAnswer> answerList){
        int num=0;

        if(!answerList.isEmpty())  {

            Iterator<SubmittedAnswer> iter = answerList.iterator();
            while(iter.hasNext()) {
                SubmittedAnswer submittedAnswer= iter.next();

                String answerText=submittedAnswer.getSubmittedAnswerText() ;

                 if(answerText!=null /*&& !"N/A".equalsIgnoreCase(answerText)*/){
                     num++;
                 }
            }
        }


        return num;

    }

    private Participant getParticipantDetais(SurveyFormBean surveyFormBean){

        Participant participant = new Participant();



        String title= surveyFormBean.getParticipantTitle();
        String firstName=surveyFormBean.getParticipantFirstName();
        String surname=surveyFormBean.getParticipantSruname() ;
        String telephone= surveyFormBean.getParticipantTelephone();
        String email=surveyFormBean.getParticipantEmail();
        String ageBand= surveyFormBean.getParticipantAgeBand();
        boolean optIn=surveyFormBean.isParticipantOptIn();
        String spending=surveyFormBean.getParticipantSpendingBand();
        String sex =   surveyFormBean.getParticipantSex();
        String town =  surveyFormBean.getParticipantTown() ;
        String postcode=surveyFormBean.getParticipantPostCode();

        boolean termsAgreed= surveyFormBean.isTermsAgreed();


        if(termsAgreed){
            participant.setTermsAgreed("Y");
        } else{
            participant.setTermsAgreed("N");
        }

        participant.setTitle(title);
        participant.setFirstName(firstName);
        participant.setSurname(surname);
        participant.setEmail(email);
        participant.setAgeBand(ageBand);


        String participantOptIn= "N";
        if(optIn)  {
            participantOptIn="Y"  ;
        }
        participant.setOptIn(participantOptIn);

        participant.setTelephone(telephone);
        participant.setTown(town);
        participant.setSex(sex);
        participant.setSpending(spending);
        participant.setPostCode(postcode);

        return participant;



    }


}
