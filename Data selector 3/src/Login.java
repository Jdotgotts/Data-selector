
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;  // My imports 
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jackg
 */
public class Login extends javax.swing.JFrame { // class extends JFrame 

    private ArrayList<String> users = new ArrayList<String>(); // Declaring new arraylist of strings called users
    protected String username; // creating string variable called username 
    protected String password; // creating string variable called password
    protected String email; // creating string variable called email
    JFrame frame = new JFrame(); // creating new frame for dialog boxes
    User user = new User(username, password, email); //instanting new user object with parameters 
    File file = new File("Users.txt"); //creating file object with file name 
    ActivityLogger logger = new ActivityLogger(); // instanting new ActivityLogger object 

    /**
     * Creates new form Login
     */
    public Login() { // login constructor 

        initComponents(); // initates components on create, e.g. buttons, lables, textfield and frame.
      

    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginLbl = new javax.swing.JLabel();
        loginPasswordTxt = new javax.swing.JPasswordField();
        loginUsernameLbl = new javax.swing.JLabel();
        loginPasswordLbl = new javax.swing.JLabel();
        loginUsernameTxt = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        backRegisterBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginLbl.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        loginLbl.setText("Login");

        loginPasswordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordTxtActionPerformed(evt);
            }
        });

        loginUsernameLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginUsernameLbl.setText("Username:");

        loginPasswordLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginPasswordLbl.setText("Password:");

        loginBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        backRegisterBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backRegisterBtn.setText("Need to register? Click here");
        backRegisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backRegisterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginPasswordLbl)
                            .addComponent(loginUsernameLbl))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginUsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(loginLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loginPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backRegisterBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginUsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginUsernameLbl))
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginPasswordLbl))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backRegisterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        if (authenticate()) { // when loginButton is clicked checks if autenticated method has returned true
            GUI guiFrame; // if returned true, create new GUI object
            try {
                guiFrame = new GUI(); // assign GUI object to GUI class 

                user.setUser(username); // call setUser method from user class and assign the username variable to it 
                guiFrame.getUsername(user); // call getUsername method from GUI class and set username variable to it 
               // logger.getUsername(user); // class getUsername method from ActivityLogger class, do not use anymore 
                guiFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // makes GUI frame full screen on create 
                guiFrame.setVisible(true); // sets the GUI frame to visible 
                this.setVisible(false); // sets this frame to close 
            } catch (IOException ex) { // catch if input output error 
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        }


    }//GEN-LAST:event_loginBtnActionPerformed

    private void backRegisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backRegisterBtnActionPerformed
        Register registerFrame = new Register(); // creating register object for register class
        registerFrame.setVisible(true); // opening the object frame
        this.setVisible(false); // closing this login frame 
    }//GEN-LAST:event_backRegisterBtnActionPerformed

    private void loginPasswordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginPasswordTxtActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Login().setVisible(true); // on create open this frame 

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backRegisterBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JLabel loginPasswordLbl;
    private javax.swing.JPasswordField loginPasswordTxt;
    private javax.swing.JLabel loginUsernameLbl;
    private javax.swing.JTextField loginUsernameTxt;
    // End of variables declaration//GEN-END:variables

    private boolean authenticate() { // authenticate boolean method 
        username = loginUsernameTxt.getText(); // gets the username variable from the textfield 
        password = String.valueOf(loginPasswordTxt.getPassword()); // gets the password variable from the password textfield 
        if (username.equals("") || password.equals("")) { // if the username or password variables equal empty
            JOptionPane.showMessageDialog(frame, "No username or password entered."); // diaglog box to let user and developer know that no username or password was entered
            return false; // returns false which doesn't let the user log in 
        }
        if (user.checkUserExist(username) && user.passwordMatch(password)) { // if the methods checkUserExist and password match from the user class return true 
            JOptionPane.showMessageDialog(frame, "Successful login!"); // show diaglog box to let user and developer know login was successful
            return true; // returns true if methods return true
        } else { // else if methods return false 
            JOptionPane.showMessageDialog(frame, "Username or password wrong, please try again."); // show dialog box to let user or developer know that the username or password entered did not match
            return false; // returns false 
        }

    }
}
