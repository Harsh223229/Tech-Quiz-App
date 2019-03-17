/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuiz.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Harsh
 */
public class DbConnection {
     private static Connection conn;
    static{
        
    
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-54QECE5:1521/xe","onlineexam","student");
            JOptionPane.showMessageDialog(null,"Connected Succesfully");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Disconnected Succesfully");
        }
    
}
    public static Connection getConnection()
    {
      return conn;  
    }
    public static void closeConnection(){
        try{
        conn.close();
        JOptionPane.showMessageDialog(null, "Connection closed");
    }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Cannot close the Connection");
                    }
    }
}
