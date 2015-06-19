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
public class ProfileEdit extends javax.swing.JFrame {
    public DBConnect db = new DBConnect();
    public boolean isSame = false;
    /**
     * Creates new form ProfileEdit
     */
    public ProfileEdit() {
        initComponents();
        db.profileItems(Login.email);
        getContentPane().setBackground(new java.awt.Color(131,111,255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPasswordCheck = new javax.swing.JTextArea();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDoB = new javax.swing.JFormattedTextField();
        txtPasswordOne = new javax.swing.JTextField();
        txtPasswordTwo = new javax.swing.JTextField();
        btnMakeChange = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRemoveAccount = new javax.swing.JButton();
        txtUserID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("FindMyCareer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel2.setText("Profile Edit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("First Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setText("Last Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel5.setText("Date of Birth:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel6.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setText("Confirm Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        getContentPane().add(jLabel8, gridBagConstraints);

        txtPasswordCheck.setColumns(20);
        txtPasswordCheck.setRows(5);
        txtPasswordCheck.setFocusable(false);
        txtPasswordCheck.setPreferredSize(new java.awt.Dimension(150, 50));
        jScrollPane1.setViewportView(txtPasswordCheck);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridheight = 5;
        getContentPane().add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtFname, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtLname, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtEmail, gridBagConstraints);

        txtDoB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtDoB, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtPasswordOne, gridBagConstraints);

        txtPasswordTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordTwoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(txtPasswordTwo, gridBagConstraints);

        btnMakeChange.setText("Make Changes");
        btnMakeChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeChangeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 20;
        getContentPane().add(btnMakeChange, gridBagConstraints);

        btnCancel.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 20;
        getContentPane().add(btnCancel, gridBagConstraints);

        btnRemoveAccount.setText("Delete Account");
        btnRemoveAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAccountActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        getContentPane().add(btnRemoveAccount, gridBagConstraints);

        txtUserID.setEditable(false);
        txtUserID.setText("jTextField1");
        txtUserID.setUI(null);
        txtUserID.setEnabled(false);
        txtUserID.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 22;
        getContentPane().add(txtUserID, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordTwoActionPerformed
        // TODO add your handling code here:
        isSame = false;
        if(txtPasswordOne.getText().equals(txtPasswordTwo.getText())){
            isSame = true;
        }
        if(isSame){
            this.txtPasswordCheck.setText("Passwords Match");
        }else{
            this.txtPasswordCheck.setText("Passwords do not match");
        }
    }//GEN-LAST:event_txtPasswordTwoActionPerformed

    private void btnMakeChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeChangeActionPerformed
        // TODO add your handling code here:
        if(!txtFname.equals("")&&!txtLname.equals("")&&!txtEmail.equals("")&&!txtPasswordOne.equals("")&&!txtPasswordTwo.equals("")&&isSame){ 
        db.editProfile(txtUserID.getText(), txtEmail.getText(), txtPasswordOne.getText(), txtFname.getText(), txtLname.getText(), txtDoB.getText());
        FindMyCareer.mainPageShow("edit");
        }
    }//GEN-LAST:event_btnMakeChangeActionPerformed

    private void btnRemoveAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAccountActionPerformed
        // TODO add your handling code here:
        db.deleteAccount(txtUserID.getText());
        FindMyCareer.logInShow("Profile Edit");
    }//GEN-LAST:event_btnRemoveAccountActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnMakeChange;
    private javax.swing.JButton btnRemoveAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JFormattedTextField txtDoB;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtFname;
    public static javax.swing.JTextField txtLname;
    private javax.swing.JTextArea txtPasswordCheck;
    public static javax.swing.JTextField txtPasswordOne;
    public static javax.swing.JTextField txtPasswordTwo;
    public static javax.swing.JTextField txtUserID;
    // End of variables declaration//GEN-END:variables
}
