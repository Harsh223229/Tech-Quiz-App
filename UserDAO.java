/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuiz.dao;

import TechQuiz.dbutil.DbConnection;
import TechQuiz.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Harsh
 */
public class UserDAO {
    public static boolean validateUser(UserPojo user)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        return rs.next();
        
       
        
        }
    public static boolean addUser(UserPojo user) throws SQLException
    {
        String qry="Select * from users where userid=?";
        boolean status=true;
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, user.getUserid());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            status=false;
        else
        {
            qry="Insert into users values(?,?,?)";
            ps=conn.prepareStatement(qry);
            ps.setString(1,user.getUserid());
            ps.setString(2,user.getPassword());
            ps.setString(3, user.getUserType());
            ps.executeUpdate();
        }
        return status;
}
    public static boolean changePassword(String userid,String password)throws SQLException{
        String qry="Update users set password=? where userid=?";
        boolean status=true;
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,password);
        ps.setString(2,userid);
        int ans=ps.executeUpdate();
        if(ans==0)
               status=false;
     return status;
     } 

}
