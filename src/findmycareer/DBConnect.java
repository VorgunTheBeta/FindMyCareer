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
 * @author Kyle
 * @author Trai
 * @author Tadd
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycareer","root","");
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
            String sql = "SELECT * FROM users WHERE email = '"+user+"' AND password = '"+password+"'";
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
            
            String SQL ="UPDATE users SET loggedIn = '1', lastLogin = '"+df.format(date)+"', accountExpire = '"+df.format(expireDate)+"' WHERE email = '"+user+"' AND password = '"+password+"'";
            st.execute(SQL);
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
        return check;
    }
    public void logout(String user, String password){
        try{
            st = con.createStatement();
            String sql = "UPDATE users SET loggedIn = '0' WHERE email = '"+user+"' AND password = '"+password+"'";
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
           
           String insertStatement = "INSERT INTO users(email, password, accountLevel, fName, lName, loggedIn, DoB, active, phoneNumber) "
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
            String sql = "SELECT * FROM industries";
            rs=st.executeQuery(sql); 
            while(rs.next()){
                MainPage.cbxIndustry.addItem(rs.getString(2));
                System.out.println(rs.getString(2));
            }
        }catch(SQLException e){
            System.out.println("Nope: "+e.getMessage());
        }
        return rs.toString();
    }
    public String categorySearch(int id){
        try{
            
            
            System.out.println(id);
            id = id+1;
            st=con.createStatement();
            String catSearch = "SELECT * FROM categories WHERE industries_industry_id = '"+id+"'";
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
            
            // find the id of the search category , industy
            System.out.println(id);
            id = id+1;//category
            //business
            id2 = id2 + 1;//industry
            if(id2 == 1&&id == 2){
            id = id + 1;
            }
            //Creative Industries
            if(id2 == 2){
                id = id+5;
            }
            if(id2 == 2&&id == 2){
                id = id+5;
            }
            //Health
            if(id2 == 3){
                id = id+10;
            }
            if(id2 == 3&&id == 2){
                id=id+10;
            }
            //Community Services
            if(id2 == 4){
                id=id+15;
            }
            if(id2==4&&id==2){
                id=id+15;
            }
            st=con.createStatement();
            String catSearch = "SELECT * FROM career_path WHERE categories_category_id = '"+id+"' AND industries_industry_id = '"+id2+"'";
            
            
            rs=st.executeQuery(catSearch);
            while(rs.next()){
                MainPage.cbxPathway.addItem(rs.getString(2));
            }
        }catch(Exception e){
            System.out.println("Nope: "+e.getMessage());
        }
        return rs.toString();
    }
    //<editor-fold defaultstate="collapsed" desc="Profile Queries Kyle Swanenberg">
     public void profileItems(String user){
        try{
            st = con.createStatement();
            String sql = "SELECT * FROM users WHERE email = '"+user+"'";
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
//        Date dob = Date.valueOf(Dob);
        try{
           st = con.createStatement();
           String editStatement = "UPDATE users SET email =  '"+user+"', password = '"+password+"', fName = '"+fName+"', lName = '"
                   +lName+"', DoB = '"+Dob+"' WHERE userID = '"+userID+"'";
          st.execute(editStatement);
           System.out.println("Profile changed");
        }catch(Exception e){
            System.out.println("You done goofed"+e.getMessage());
        }
    }
    public void showUsers(){
        try{
           st = con.createStatement();
           String sql = "SELECT UserID, email, accountLevel AS 'Account Level', fName AS 'First Name', lName, accountExpire FROM users";
           rs = st.executeQuery(sql);
           adminPage.tblUsers.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.println("Something went wrong "+e.getMessage());
        }
    }
    public void adminProfileItems(String user){
        try{
            st = con.createStatement();
            String sql = "SELECT * FROM users WHERE userId = '"+user+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
            AdminProfileEdit.txtUserID.setText(rs.getString(1));
            AdminProfileEdit.txtEmail.setText(rs.getString(2));
            AdminProfileEdit.txtPasswordOne.setText(rs.getString(3));
            AdminProfileEdit.txtPasswordTwo.setText(rs.getString(3));
            AdminProfileEdit.txtFname.setText(rs.getString(6));
            AdminProfileEdit.txtLname.setText(rs.getString(7));
            AdminProfileEdit.txtDoB.setValue(rs.getDate(9));
            if(rs.getInt(4)==1){
                AdminProfileEdit.rdBtnPersonal.setSelected(true);
            }
            if(rs.getInt(4)==2){
                AdminProfileEdit.rdBtnAdmin.setSelected(true);
            }
            if(rs.getBoolean(10)==true){
                AdminProfileEdit.btnActive.setSelected(true);
            }else{
                AdminProfileEdit.btnActive.setSelected(false);
            }

            }
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    public void editProfileAdmin(String userID, String user, String password, String fName, String lName, String Dob, String accountlvl, int active){
//        Date dob = Date.valueOf(Dob);
        try{
           st = con.createStatement();
           String editStatement = "UPDATE users SET email =  '"+user+"', password = '"+password+"', fName = '"+fName+"', lName = '"
                   +lName+"', DoB = '"+Dob+"', accountLevel = '"+accountlvl+"', active = '"+active+"' WHERE userID = '"+userID+"'";
          st.execute(editStatement);
           System.out.println("Profile changed");
        }catch(Exception e){
            System.out.println("You done goofed "+e.getMessage());
        }
    }
//</editor-fold>
   
    public String jobSearch(int id, int id2, int id3) {
        try {

            System.out.println(id);
            id = id + 1;
            id2 = id2 +1;
            id3=id3+1;
     
            st = con.createStatement();
            String jobSearch = "SELECT Salary, Job_Description AS 'Job Description' FROM job_outcomes WHERE career_path_career_path_id = '" + id+"' AND career_path_categories_category_id = '"+id2+"' AND Industry_industryID = '"+id3+"'";

            rs = st.executeQuery(jobSearch);
            SearchPage.tblJob.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println("Error jobSearch: " + e.getMessage());
        }
        return rs.toString();
    }
    public String courseSearch(int id, int id2) {
        try {
            
            
            id = id + 1;
            id2 = id2 + 1;
            System.out.println("Pathway index: "+id);
            System.out.println("Category index: "+id2);
            st = con.createStatement();
            String courseSearch = "SELECT * FROM skilled_occupations WHERE categories_category_id = '" + id+"' AND Industry_industryID = '"+id2+"'" ;

            rs = st.executeQuery(courseSearch);
            
            SearchPage.tblSkilled.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println("Error courseSearch: " + e.getMessage());
        }
        return rs.toString();
    }
    public void deleteAccount(String id){
        try{
            st=con.createStatement();
            String sql = "UPDATE users SET active = '0' WHERE userID = '"+id+"'";
            st.execute(sql);
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public void empSkills(int id, int id2){
        try{
            st=con.createStatement();
            if(id2==0){
                id=id+1;
            }
            if(id2==1){
                id=id+7;
            }
            if(id2==2){
                id=id+10;
            }
            if(id2==3){
                id=id+13;
            }
            id2=id2+1;
            String sql = "SELECT Employability_Skills FROM emp_skills WHERE categories_category_id = '"+id+"'AND Industry_industryID = '"+id2+"'";
            rs = st.executeQuery(sql);
            Emp.tblEmpSkills.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException e){
            System.out.println("Errror: "+e.getMessage());
        }
    }
     public void empSkillsReq(int id, int id2){
        try{
            st=con.createStatement();
            if(id2==0){
                id=id+1;
            }
            if(id2==1){
                id=id+7;
            }
            if(id2==2){
                id=id+10;
            }
            if(id2==3){
                id=id+13;
            }
            id2=id2+1;
            String sql = "SELECT Employability_Skilled_Requirements FROM emp_skill_req WHERE emp_skills_categories_category_id = '"+id+"'AND Industry_industryID = '"+id2+"'";
            rs = st.executeQuery(sql);
            Emp.tblEmpSkillsReq.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException e){
            System.out.println("Errror: "+e.getMessage());
        }
    }
}
