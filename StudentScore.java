/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuiz.pojo;

/**
 *
 * @author Harsh
 */
public class StudentScore {
  private String Language;
 private double per;  

    public StudentScore(String Language, double per) {
        this.Language = Language;
        this.per = per;
    }
     public StudentScore() {
       
    }
   

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }
}
