/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmycareer;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author marcel
 */
public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public static boolean admin = false;
    public static boolean active = true;
    DBConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/findmycareer","root","");
            st = con.createStatement();
            System.out.println("Database is connected");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    public boolean login(String user, String password){
        boolean check = false;
        int accountLvl = 0;
        admin = false;
        try{
            st = con.createStatement();
            String sql = "SELECT * FROM user WHERE email = '"+user+"' AND password = '"+password+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                check = true;
                accountLvl = rs.getInt(4);
                active = rs.getBoolean(10);
                if(accountLvl == 1){
                    admin = false;
                }
                if(accountLvl == 2){
                    admin = true;
                }
            }
            if(check == false){
                System.out.println("User Does Not Exist");
            }
            if(active == false){
                JOptionPane.showMessageDialog(FindMyCareer.lgn,"Your account has expired");
            }
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, 6);
            Date expireDate = cal.getTime();
            
            String SQL ="UPDATE user SET loggedIn = '1', lastLogin = '"+df.format(date)+"', accountExpire = '"+df.format(expireDate)+"' WHERE email = '"+user+"' AND password = '"+password+"'";
            st.execute(SQL);
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
        return check;
    }
    public void logout(String user, String password){
        try{
            st = con.createStatement();
            String sql = "UPDATE user SET loggedIn = '0' WHERE email = '"+user+"' AND password = '"+password+"'";
            st.execute(sql);
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void signUp(String user, String password, int accountlvl, String fName, String lName, String Dob, String ph){
        accountlvl = 1;
        int loggedIn = 0;
//        Date dob = Date.valueOf(Dob);
        try{
           
           String insertStatement = "INSERT INTO user(email, password, accountLevel, fName, lName, loggedIn, DoB, active, phoneNumber) "
                   +"VALUES (?,?,?,?,?,?,?,?,?)";
           PreparedStatement preState = con.prepareStatement(insertStatement);
           preState.setString(1,user);
           preState.setString(2,password);
           preState.setInt(3, accountlvl);
           preState.setString(4,fName);
           preState.setString(5,lName);
           preState.setInt(6, loggedIn);
           preState.setString(7,Dob);
           preState.setBoolean(8,true);
           preState.setString(9,ph);
           preState.execute();
           System.out.println("Playa added!");
        }catch(Exception e){
            System.out.println("You done goofed"+e.getMessage());
        }
    }
    public String industrySearch(){
        try{
            st = con.createStatement();
            String sql = "SELECT * FROM industry";
            rs=st.executeQuery(sql); 
            while(rs.next()){
                MainPage.cbxIndustry.addItem(rs.getString(2));
            }
        }catch(Exception e){
            System.out.println("Nope: "+e.getMessage());
        }
        return rs.toString();
    }
    public String categorySearch(int id){
        try{
            
            
            System.out.println(id);
            id = id+1;
            st=con.createStatement();
            String catSearch = "SELECT * FROM category WHERE Industry_industryID = '"+id+"'";
            
            
            rs=st.executeQuery(catSearch);
            while(rs.next()){
                MainPage.cbxCategory.addItem(rs.getString(2));
            }
        }catch(Exception e){
            System.out.println("Nope: "+e.getMessage());
        }
        return rs.toString();
    }
    public String pathwaySearch(int id, int id2){
        try{
            
            
            System.out.println(id);
            id = id+1;
            id2 = id2 + 1;
            st=con.createStatement();
            String catSearch = "SELECT * FROM pathway WHERE Category_categoryID = '"+id+"' AND Industry_industryID = '"+id2+"'";
            
            
            rs=st.executeQuery(catSearch);
            while(rs.next()){
                MainPage.cbxPathway.addItem(rs.getString(2));
            }
        }catch(Exception e){
            System.out.println("Nope: "+e.getMessage());
        }
        return rs.toString();
    }
    
}
