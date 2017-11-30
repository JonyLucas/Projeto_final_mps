/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.control.UserControl;
import business.control.facade.RegisterFacade;
import business.model.exceptions.InvalidLoginException;
import business.model.users.AdministratorUser;
import business.model.users.User;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Joao
 */
public class Home extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PasswordTextField = new javax.swing.JPasswordField();
        LoginTextField = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        ShowCatalogsButton = new javax.swing.JButton();
        RegisterProductButton = new javax.swing.JButton();

        setName(""); // NOI18N

        jPanel2.setBackground(new java.awt.Color(191, 191, 191));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Logo e nome.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(167, 167, 167))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Login");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Senha");

        PasswordTextField.setBackground(new java.awt.Color(255, 255, 255));
        PasswordTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        PasswordTextField.setForeground(new java.awt.Color(102, 102, 102));
        PasswordTextField.setText("jPasswordField1");
        PasswordTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasswordTextFieldMouseClicked(evt);
            }
        });

        LoginTextField.setBackground(new java.awt.Color(255, 255, 255));
        LoginTextField.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LoginTextField.setForeground(new java.awt.Color(102, 102, 102));

        LoginButton.setBackground(new java.awt.Color(204, 204, 204));
        LoginButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(0, 0, 0));
        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        RegisterButton.setBackground(new java.awt.Color(204, 204, 204));
        RegisterButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(0, 0, 0));
        RegisterButton.setText("Registrar-se");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        ShowCatalogsButton.setBackground(new java.awt.Color(204, 204, 204));
        ShowCatalogsButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ShowCatalogsButton.setForeground(new java.awt.Color(0, 0, 0));
        ShowCatalogsButton.setText("Ver Catalogos");
        ShowCatalogsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowCatalogsButtonActionPerformed(evt);
            }
        });

        RegisterProductButton.setBackground(new java.awt.Color(204, 204, 204));
        RegisterProductButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        RegisterProductButton.setForeground(new java.awt.Color(0, 0, 0));
        RegisterProductButton.setText("Registrar Produto");
        RegisterProductButton.setEnabled(false);
        RegisterProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterProductButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RegisterButton)
                        .addGap(18, 18, 18)
                        .addComponent(ShowCatalogsButton)
                        .addGap(18, 18, 18)
                        .addComponent(RegisterProductButton))
                    .addComponent(LoginTextField)
                    .addComponent(PasswordTextField))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowCatalogsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordTextFieldMouseClicked
        // TODO add your handling code here:
        this.PasswordTextField.setText("");
    }//GEN-LAST:event_PasswordTextFieldMouseClicked

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        // TODO add your handling code here:
        String login = LoginTextField.getText();
        String password = PasswordTextField.getText();
        
        // Cria o JFrame que pergunta se o usuario e administrador ou um usuario comum
        JFrame jf = new TypeUserForm();
        ((TypeUserForm)jf).login = login;
        ((TypeUserForm)jf).password = password;
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        String login = LoginTextField.getText();
        String password = PasswordTextField.getText();
        
        User user = RegisterFacade.get_user(login);
        try{
            user.login(login, password);
            if(user instanceof AdministratorUser){
                RegisterProductButton.setEnabled(true);
            }
        }catch(InvalidLoginException ile){
            JOptionPane.showMessageDialog(null, ile.getMessage());
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void ShowCatalogsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowCatalogsButtonActionPerformed
        // TODO add your handling code here:

        JFrame jf = new SelectProductForm();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }//GEN-LAST:event_ShowCatalogsButtonActionPerformed

    private void RegisterProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterProductButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterProductButtonActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JTextField LoginTextField;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton RegisterProductButton;
    private javax.swing.JButton ShowCatalogsButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
