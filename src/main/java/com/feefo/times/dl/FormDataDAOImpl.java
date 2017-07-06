package com.feefo.times.dl;

import com.feefo.times.bl.*;

import javax.sql.DataSource;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/**
 * Created with IntelliJ IDEA.
 * User: broshanravan
 * Date: 03/06/13
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */
public class FormDataDAOImpl implements FormDataDAO,Serializable {

    private static final Logger log = Logger.getLogger(FormDataDAOImpl.class);
    private DataSource surveyDataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*public void setSurveyDataSource(DataSource surveyDataSource) {
        this.surveyDataSource = surveyDataSource;
        this.jdbcTemplateObject = new JdbcTemplate(surveyDataSource);
    } */


    public boolean emailExists(String email){
        boolean exists = false;

        String SQL = "select * from time_survey.participant where email='"+email+"'";
        try{
            List<Map<String,Object>> rows= jdbcTemplate.queryForList(SQL);

            if(rows!=null && !rows.isEmpty())  {
                exists= true;
            }

        }catch(DataAccessException e){
            log.warn(e);
        }catch(Exception e){
            log.warn(e);
        }


        return exists;

    }





    public void saveAnswer(SubmittedAnswer submittedAnswer){
       try{
            String SQL = "insert into time_survey.submitted_answer  (" +
                                                                                "QUESTION_ID," +
                                                                                "PARTICIPANT_ID," +
                                                                                "COMMENTS_TXT," +
                                                                                "SUBMITTED_ANSWER" +
                                                                       ") " +
                                                                        "values (?, ?, ?, ?)";


            int questionId=  submittedAnswer.getQuestionId();
            String text= submittedAnswer.getSubmittedAnswerText();
            int participantId= submittedAnswer.getParticipantId();
            String comments=  submittedAnswer.getSubmittedAnswerComments();

            Object[] objArray= new Object[]{questionId, participantId ,comments, text};

            jdbcTemplate.update(SQL, objArray );

       }catch(DataAccessException e){
           log.warn(e);
       }catch(Exception e){
           log.warn(e);
       }
        // int anserId=jdbcTemplate.
        //System.out.println("Answer id "+ anserId);

    }


    public LinkedList<Question> getAllQuestions(){

        String SQL = "select * from time_survey.question q order by q.question_order asc" ;
        LinkedList<Question> questionList= new   LinkedList<Question>();
       try{
            List<Map<String,Object>> rows= jdbcTemplate.queryForList(SQL);
            for (Map row : rows) {
                Question question = new Question();

                int questionId=(Integer)row.get(("QUESTION_ID")) ;
                String  questionIdStr=String.valueOf(questionId)+"_txt";
                String  cmtId=String.valueOf(questionId)+"_cmt";

                question.setQuestionId(questionId);
                question.setTxtId(questionIdStr);
                question.setCmtId(cmtId);


                question.setCategoryId((Integer)(row.get("CATEGORY_ID")));
                question.setText((String)(row.get("QUESTION_TXT")));
                question.setOrder((Integer)(row.get("QUESTION_ORDER")));
                int type=   (Integer)(row.get("IS_ANSWER_PRESET"));

                if(type!=0)   {
                    question.setAnswerPreset(true);
                }

                questionList.add(question);
            }

       }catch(DataAccessException e){
           log.warn(e);
       }catch(Exception e){
           log.warn(e);
       }
        return questionList;

    }

    public LinkedList<String> getPresetAnswers(int questionId){
        String SQL = "select * from time_survey.preset_answer where question_id= "+String.valueOf(questionId)+" ORDER BY PRESET_ANSWER_TXT ASC" ;
        LinkedList<String> answerList= new   LinkedList<String>();
        try{
                List<Map<String,Object>> rows= jdbcTemplate.queryForList(SQL);
                for (Map row : rows) {


                    String answer=(String)(row.get("PRESET_ANSWER_TXT"));
                    answerList.add(answer);
                }
        }catch(DataAccessException e){
            log.warn(e);
        }catch(Exception e){
            log.warn(e);
        }

         return  answerList;
    }




    public LinkedList<Category> getAllCategories(){

        LinkedList<Category> catList = new LinkedList<Category>() ;
        try{
                String SQL = "select * from time_survey.category ORDER BY CATEGORY_ORDER ASC" ;
                LinkedList<Question> questionList= new   LinkedList<Question>();

                List<Map<String,Object>> rows= jdbcTemplate.queryForList(SQL);
                for (Map row : rows) {
                    Category category = new Category();
                    category.setCategoryId((Integer)row.get(("CATEGORY_ID")));
                    category.setCategoryDetail((String)row.get(("CATEGORY_DETAIL")));
                    category.setCategoryName((String)row.get(("CATEGORY_NAME")));
                    catList.add(category);
                }

        }catch(DataAccessException e){
            log.warn(e);
        }catch(Exception e){
            log.warn(e);
        }
        return catList;
    }

    public LinkedList<Question> getAllCategoriesQuestions(int categoryId){

        String SQL = "select * from time_survey.question" +
                      " where CATEGORY_ID=" + categoryId +
                      " order by question_order asc" ;
        LinkedList<Question> questionList= new   LinkedList<Question>();

        try{
                    List<Map<String,Object>> rows= jdbcTemplate.queryForList(SQL);
                    for (Map row : rows) {
                        Question question = new Question();

                        int questionId=(Integer)row.get(("QUESTION_ID")) ;
                        String  questionIdStr=String.valueOf(questionId)+"_txt";


                        String  cmtId=String.valueOf(questionId)+"_cmt";
                        question.setCmtId(cmtId);

                        question.setQuestionId(questionId);
                        question.setTxtId(questionIdStr);
                        question.setCategoryId((Integer)(row.get("CATEGORY_ID")));
                        question.setPlaceHolder((String)(row.get("PLACE_HOLDER")));
                        question.setText((String)(row.get("QUESTION_TXT")));
                        question.setOrder((Integer)(row.get("QUESTION_ORDER")));
                        int type=   (Integer)(row.get("IS_ANSWER_PRESET"));

                        if(type!=0)   {
                            question.setAnswerPreset(true);
                        }

                        questionList.add(question);
                    }
        }catch(DataAccessException e){
            log.warn(e);
        }catch(Exception e){
            log.warn(e);
        }
        return questionList;


    }

    public int saveParticipantDetail(Participant participant){
        int participantId=0;
        try{

                String SQL = "insert into time_survey.participant  ("+
                        "TITLE,"+
                        "FIRST_NAME,"+
                        "SURNAME,"+
                        "AGE_BAND,"+
                        "SEX,"+
                        "TOWN," +
                        "TELEPHONE,"+
                        "POST_CODE," +
                        "EMAIL,"+
                        "OPT_IN," +
                        "TERMS_AGREED," +
                        "SPENDING_BAND"+
                        ") " +
                        "values (:title,:first_name,:surname, :age_band, :sex, :town, telephone, :post_code, :email, :opt_in, :terms_agreed, :spending_band)";
                final MapSqlParameterSource namedParams = new MapSqlParameterSource();

                namedParams.addValue("title",participant.getTitle()) ;
                namedParams.addValue("first_name",participant.getFirstName())  ;
                namedParams.addValue("surname",participant.getSurname()) ;
                namedParams.addValue("age_band",participant.getAgeBand()) ;
                namedParams.addValue("sex",participant.getSex())    ;
                namedParams.addValue("town",participant.getTown()) ;
                namedParams.addValue("telephone",participant.getTelephone())  ;
                namedParams.addValue("post_code",participant.getPostCode()) ;
                namedParams.addValue("email",participant.getEmail());
                namedParams.addValue("opt_in",participant.getOptIn()) ;
                namedParams.addValue("terms_agreed",participant.getTermsAgreed()) ;
                namedParams.addValue("spending_band",participant.getSpending());

                final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder(); // to get the id back
                NamedParameterJdbcTemplate nameParamJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
                nameParamJdbcTemplate.update(SQL, namedParams , keyHolder,new String[]{"PARTICIPANT_ID"});
                participantId=  keyHolder.getKey().intValue();

        }catch(DataAccessException e){
            log.warn(e);
        }catch(Exception e){
            log.warn(e);
        }

        return  participantId;
    }


    private class ParticipantRowMapper implements RowMapper
    {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Participant participant = new Participant();
            //participant.setEmail(rs.getString("EMAIL"));
            //participant.setParticipantId(rs.getInt("PARTICIPANT_ID"));
            //participant.setName(rs.getString("NAME"));

            return participant;
        }

    }


}
