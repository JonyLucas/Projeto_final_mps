package view;

import business.control.UserControl;
import business.model.exceptions.UserNotExistException;
import infra.adaptee.StorageReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserForm extends javax.swing.JPanel {

    /**
     * Creates new form UserForm
     */
    public UserForm() {
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

        TextFieldFile = new javax.swing.JTextField();
        TextFieldPassword = new javax.swing.JTextField();
        TextFieldLogin = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ListAllButton = new javax.swing.JButton();
        LoadButton = new javax.swing.JButton();
        ListButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();

        AddButton.setText("Adicionar");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        RemoveButton.setText("Remover");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Login");

        jLabel2.setText("Senha");

        jLabel3.setText("Arquivo");

        ListAllButton.setText("Listar Todos");
        ListAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListAllButtonActionPerformed(evt);
            }
        });

        LoadButton.setText("Carregar");
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButtonActionPerformed(evt);
            }
        });

        ListButton.setText("Listar");
        ListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("Salvar");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ListAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldPassword)
                            .addComponent(TextFieldFile)
                            .addComponent(TextFieldLogin))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(RemoveButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListAllButton)
                    .addComponent(ListButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoadButton)
                    .addComponent(SaveButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        String login = TextFieldLogin.getText();
        String password = TextFieldPassword.getText();
        
        UserControl.add_user(login, password);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        // TODO add your handling code here:
        String login = TextFieldLogin.getText();
        try {
            UserControl.remove_user(login);
        } catch (UserNotExistException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void ListAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListAllButtonActionPerformed
        // TODO add your handling code here:
        UserControl.list_all();
    }//GEN-LAST:event_ListAllButtonActionPerformed

    private void ListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListButtonActionPerformed
        // TODO add your handling code here:
        String login = TextFieldLogin.getText();
        UserControl.list(login);
    }//GEN-LAST:event_ListButtonActionPerformed

    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
        // TODO add your handling code here:
        String path = TextFieldFile.getText();
    }//GEN-LAST:event_LoadButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        JFrame jf = new OverwriteFrame(TextFieldFile.getText());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }//GEN-LAST:event_SaveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton ListAllButton;
    private javax.swing.JButton ListButton;
    private javax.swing.JButton LoadButton;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField TextFieldFile;
    private javax.swing.JTextField TextFieldLogin;
    private javax.swing.JTextField TextFieldPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
