/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findmycareer;



/**
 *
 * @author 5100006815
 */
public class FindMyCareer {
    //<editor-fold defaultstate="collapsed" desc=" GUI Entities DO NOT RENAME!!! ">
    public static bootPage bP;
    public static SignUpSuccess sUS;
    public static SignUpPage sUP;
    public static Login lgn;
    public static MainPage mPG;
    public static ProfileEdit pfEdt;
    public static adminPage admnPg;
    public static AdminProfileEdit admnPfEdt;
    public static SignUpConfirmPage sUC;
    public static SearchPage sPG;
    public static Emp emp;
    //</editor-fold>
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        bP = new bootPage();
        bP.setVisible(true);
        DBConnect db = new DBConnect();
    }
    //<editor-fold defaultstate="collapsed" desc=" Button Functions ">
    public static void signUpSubmit(){
        if(sUC == null){
            sUC = new SignUpConfirmPage();
        }
        sUC.setVisible(true);
        sUP.dispose();
    }
    public static void signUpConfirm(){
        if(sUS == null){
            sUS = new SignUpSuccess();
        }
        sUS.setVisible(true);
        sUC.dispose();
    }
    public static void signUpShow(){
        if(sUP == null){
            sUP = new SignUpPage();
        }
        sUP.setVisible(true);
        bP.dispose();
    }
    public static void logInShow(String st){
        if(lgn == null){
            lgn = new Login();
        }
        lgn.setVisible(true);
        if(st.equals("bootPage")){
            bP.dispose();
        }
        if(st.equals("SignUpSuccess")){
            sUS.dispose();
        }
        if(st.equals("MainPage")){
            mPG.dispose();
        }
        if(st.equals("Profile Edit")){
            pfEdt.dispose();
        }
    }
    public static void mainPageShow(String st){
        if(mPG == null){
            mPG = new MainPage();
        }
        mPG.setVisible(true);
        if(st.equals("login")){
        lgn.dispose();    
        }
        if(st.equals("edit")){
            pfEdt.dispose();
        }
        if(st.equals("admin")){
            admnPg.dispose();
        }
        if(st.equals("adminEdit")){
            admnPfEdt.dispose();
        }
        if(st.equals("search")){
            sPG.dispose();
        }
        if(st.equals("emp")){
            emp.dispose();
        }
    }
    public static void bootPageShow(String st){
        if(bP == null){
            bP = new bootPage();
        }
        bP.setVisible(true);
        if(st.equals("login")){
            lgn.dispose();
        }
        if(st.equals("SignUpPage")){
            sUP.dispose();
        }
        if(st.equals("SignUpConfirmPage")){
            sUC.dispose();
        }
    }
    public static void ResetPageComponents(String st){
        if(st.equals("SignUpPage")){
        sUP.getContentPane().removeAll();
        
        }
        if(st.equals("Login")){
            lgn.getContentPane().removeAll();
        }
        if(st.equals("AdminProfileEdit")){
            admnPfEdt.getContentPane().removeAll();
        }
        if(st.equals("Profile Edit")){
            pfEdt.getContentPane().removeAll();
        }
    }
    public static void ProfileEdit(){
        if(pfEdt==null){
            pfEdt = new ProfileEdit();
        }
        pfEdt.setVisible(true);
        mPG.dispose();
    }
    public static void AdminPageShow(String st){
        if(admnPg==null){
            admnPg = new adminPage();
        }
        admnPg.setVisible(true);
        if(st.equals("login")){
        lgn.dispose();    
        }
        if(st.equals("AdminEdit")){
            admnPfEdt.dispose();
        }
    }
    public static void AdminProfileEdit(){
        if(admnPfEdt==null){
            admnPfEdt = new AdminProfileEdit();
        }
        admnPfEdt.setVisible(true);
        admnPg.dispose();
    }
    public static void searchPageShow(String st){
         if(sPG == null){
            sPG = new SearchPage();
        }
        sPG.setVisible(true);
        mPG.dispose();
     }
    public static void empPageShow(){
        if(emp==null){
            emp = new Emp();
        }
        emp.setVisible(true);
        sPG.dispose();
    } 
    //</editor-fold>
    
}
