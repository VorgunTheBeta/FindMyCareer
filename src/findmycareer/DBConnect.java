/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmycareer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author 5100006815
 */
public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public static boolean admin = false;
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
        boolean active = true;
        admin = false;
        try{
            st = con.createStatement();
            String sql = "SELECT * FROM user WHERE email = '"+user+"' AND password = '"+password+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                
                accountLvl = rs.getInt(4);
                active = rs.getBoolean(10);
                if(accountLvl == 1){
                    admin = false;
                }
                if(accountLvl == 2){
                    admin = true;
                }
                if(active){
                    check = true;
                }else{
                    check = false;
                }
            }
            if(check == false){
                System.out.println("User Does Not Exist");
            }
            String SQL ="UPDATE user SET loggedIn = '1' WHERE email = '"+user+"'";
            st.execute(SQL);
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
        return check;
    }
    public void signUp(String user, String password, int accountlvl, String fName, String lName, String Dob){
        accountlvl = 1;
        int loggedIn = 0;
        Date dob = Date.valueOf(Dob);
        try{
           
           String insertStatement = "INSERT INTO user(email, password, accountLevel, fName, lName, loggedIn, DoB) "
                   +"VALUES (?,?,?,?,?,?,?)";
           PreparedStatement preState = con.prepareStatement(insertStatement);
           preState.setString(1,user);
           preState.setString(2,password);
           preState.setInt(3, accountlvl);
           preState.setString(4,fName);
           preState.setString(5,lName);
           preState.setInt(6, loggedIn);
           preState.setDate(7,dob);
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
    public void profileItems(String user){
        try{
            st = con.createStatement();
            String sql = "SELECT * FROM user WHERE email = '"+user+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
            ProfileEdit.txtUserID.setText(rs.getString(1));
            ProfileEdit.txtEmail.setText(rs.getString(2));
            ProfileEdit.txtPasswordOne.setText(rs.getString(3));
            ProfileEdit.txtPasswordTwo.setText(rs.getString(3));
            ProfileEdit.txtFname.setText(rs.getString(6));
            ProfileEdit.txtLname.setText(rs.getString(7));
            ProfileEdit.txtDoB.setValue(rs.getDate(9));
            

            }
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    public void editProfile(String userID, String user, String password, String fName, String lName, String Dob){
        Date dob = Date.valueOf(Dob);
        try{
           st = con.createStatement();
           String editStatement = "UPDATE user SET email =  '"+user+"', password = '"+password+"', fName = '"+fName+"', lName = '"
                   +lName+"', DoB = '"+dob+"' WHERE userID = '"+userID+"'";
          st.execute(editStatement);
           System.out.println("Profile changed");
        }catch(Exception e){
            System.out.println("You done goofed"+e.getMessage());
        }
    }
    public void showUsers(){
        try{
           st = con.createStatement();
           String sql = "SELECT email, accountLevel, fName, lName FROM user";
           rs = st.executeQuery(sql);
           adminPage.tblUsers.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println("Something went wrong "+e.getMessage());
        }
    }
}
