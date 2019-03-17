/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuiz.dao;

import TechQuiz.dbutil.DbConnection;
import TechQuiz.pojo.PerformancePojo;
import TechQuiz.pojo.StudentScore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Harsh
 */
public class PerformanceDAO {
   public static ArrayList<String>getAllStudent() throws SQLException
   {
    String qry="Select distinct userid from performance";
    ArrayList<String> studentIdList=new ArrayList<>();
    Connection conn=DbConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery(qry);
    while(rs.next())
    {
        String id=rs.getString(1);
        studentIdList.add(id);
        
    }
    return studentIdList;
       
}
    public static ArrayList<String>getAllExamId(String studentId) throws SQLException
    {
        String qry="select examid from performance where userid=? ";
         ArrayList<String> examIdList=new ArrayList<>();
         Connection conn=DbConnection.getConnection();
   PreparedStatement ps=conn.prepareStatement(qry);
   ps.setString(1,studentId);
    ResultSet rs=ps.executeQuery();
    while(rs.next())
    {
        String id=rs.getString(1);
        examIdList.add(id);
        
    }
    return examIdList;
}
 public static StudentScore getScore(String studentId,String examId) throws SQLException
 {
  String qry="Select language,per from Performance where userid=? and examid=?";
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,studentId);
        ps.setString(2,examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        String rt=rs.getString(1);
        Double rm=rs.getDouble(2);
        StudentScore scoreObj=new StudentScore();
        scoreObj.setLanguage(rt);
        scoreObj.setPer(rm);
        return scoreObj;

     
 }
 public static void addPerformance(PerformancePojo performance)throws SQLException
 {   
     String qry="Insert into performance values(?,?,?,?,?,?,?)";
     Connection conn=DbConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement(qry);
     ps.setString(1, performance.getUserId());
     ps.setString(2,performance.getExamid());
     ps.setInt(3,performance.getRight());
     ps.setInt(4,performance.getWrong());
     ps.setInt(5,performance.getUnattempted());
     ps.setDouble(6,performance.getPer());
     ps.setString(7,performance.getLanguage());
     ps.executeUpdate();


 }
 public static ArrayList<PerformancePojo>getAllData()throws SQLException{
     String qry="Select * from Performance";
     ArrayList<PerformancePojo>performanceList=new ArrayList<PerformancePojo>();
     Connection conn=DbConnection.getConnection();
     Statement st=conn.createStatement();
     ResultSet rs=st.executeQuery(qry);
     while(rs.next()){
         String userId=rs.getString("userid");
         String examId=rs.getString("examid");
          String language=rs.getString("language");
           int right=rs.getInt("right");
           int wrong=rs.getInt("wrong");
           int unattempted=rs.getInt("unattempted");
         double per=rs.getDouble("per");
         PerformancePojo p=new PerformancePojo(examId,language,userId,right,wrong,unattempted,per);
         performanceList.add(p);
         
         
}
     return performanceList;
 }
}

