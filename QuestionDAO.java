/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuiz.dao;

import TechQuiz.dbutil.DbConnection;
import TechQuiz.pojo.QuestionPojo;
import TechQuiz.pojo.QuestionStore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class QuestionDAO {
    public static void addQuestions(QuestionStore q) throws SQLException
    {
        String qry="Insert into questions values(?,?,?,?,?,?,?,?,?)";
        ArrayList<QuestionPojo> questionList=q.getAllQuestions();
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        for(QuestionPojo obj:questionList){
            ps.setString(1,obj.getExamId());
            ps.setInt(2,obj.getQno());
            ps.setString(3,obj.getQuestion());
            ps.setString(4,obj.getAnswer1());
            ps.setString(5,obj.getAnswer2());
            ps.setString(6,obj.getAnswer3());
            ps.setString(7,obj.getAnswer4());
            ps.setString(8,obj.getCorrectAnswer());
            ps.setString(9,obj.getLanguage());
            ps.executeUpdate();
        }
    }
 public static ArrayList <QuestionPojo> getQuestionByExamId(String examId)throws SQLException{
   String qry="select * from questions where examId=? order by qno " ;
   ArrayList<QuestionPojo> questionList=new ArrayList<>();
   Connection conn= DbConnection.getConnection();
   PreparedStatement ps=conn.prepareStatement(qry);
   ps.setString(1,examId);
   ResultSet rs=ps.executeQuery();
   while(rs.next())
   {
       int qno=rs.getInt(2);
       String question=rs.getString(3);
       String option1=rs.getString(4);
       String option2=rs.getString(5);
       String option3=rs.getString(6);
       String option4=rs.getString(7);
       String correctAnswer=rs.getString(8);
       String language=rs.getString(9);
       QuestionPojo obj=new QuestionPojo(examId,qno,language,option1,option2,option3,option4,correctAnswer,question);
       questionList.add(obj);
   }
   return questionList;
 }                
       
    

public static void updateQuestions(QuestionStore qstore)throws SQLException
{
String qry="update questions set QUESTION=?,ANSWER1=?,ANSWER2=?,ANSWER3=?,ANSWER4=?,CORRECT ANSWER=? where Language=? and examid=? " ;
ArrayList<QuestionPojo>questionLists=new ArrayList<>();
Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        for(QuestionPojo obj:questionLists){
           
            ps.setString(1,obj.getQuestion());
            ps.setString(2,obj.getAnswer1());
            ps.setString(3,obj.getAnswer2());
            ps.setString(4,obj.getAnswer3());
            ps.setString(5,obj.getAnswer4());
            ps.setString(6,obj.getCorrectAnswer());
            ps.setString(7,obj.getLanguage());
            ps.setString(8,obj.getExamId());
            ps.executeUpdate();






}
}
}