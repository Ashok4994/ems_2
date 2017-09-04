/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ashok
 */
public class SQLInsert {
    
     public static void main(String[] args) throws ClassNotFoundException, SQLException {

  
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/practice", "root", "root");
        String city;
        int zipcode,salary=20000;
        for(int i=1;i<=200000;i++) {
            if(i>=1 &&i<50000){
                city="Los Angeles";
                zipcode=93065;
                salary=i%2==0?50000:100000;
            }
            else if(i>50000 && i<100000){
                city="New York";
                zipcode=12206;
                salary=i%3==0?40000:90000;
            }else if(i>100000 && i<150000){
                city="San Fransisco";
                zipcode=80315;
                salary=i%4==0?60000:120000;
            }else {
                city="Boston";
                zipcode=22065;
            }
        String sql = "insert into employee values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setInt(1, i);
        pstm.setString(2, "Ashok"+i);
        pstm.setString(3,"243 Manning");
        pstm.setString(4,"Apt 216");
        pstm.setString(5,city);
        pstm.setInt(6, zipcode);
        pstm.setInt(7, salary);
        pstm.setInt(8, i);
        pstm.setString(9,city);
        pstm.executeUpdate();
        System.out.println("insert completed at row"+i);
        }
        con.close();

    }
    
}
