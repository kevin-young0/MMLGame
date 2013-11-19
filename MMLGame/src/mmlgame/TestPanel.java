/*
 * This Gui will be designed to upload images, place images automatically, and
 *use a combo box to choose between default images, and/or create new categories
 *to choose from. Keeping in mind the panels re-sizing abilities...
 */

package mmlgame;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 *
 * @author KYoung, TBuchli
 */
public class TestPanel extends JDialog {
    private JPanel btnPanel;
    private JButton btnUpload;
    private JButton btnExit;
    private JComboBox cboSelectGroup;
    private JLabel icon;
    private JLabel lblLogo;
    private JPanel imgPanel;
    private JButton btnSaveImage;
    private JButton btnAddGroup;
    private JTextField txtCaption;

    TestPanel(JFrame owner) {
        
        setMinimumSize(new Dimension(490,470));
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(owner);        
        
        initPanel();
        
        pack();
        
    }    
    
    public void initPanel() {
        
        btnPanel = new JPanel();
        btnUpload = new JButton();
        btnExit = new JButton();
        cboSelectGroup = new JComboBox();
        icon = new JLabel();
        lblLogo = new JLabel();
        imgPanel = new JPanel();
        btnSaveImage = new JButton();
        btnAddGroup = new JButton();
        txtCaption = new JTextField();

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbtnExitActionPerformed(evt);
            }
        });

        cboSelectGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default" }));
        cboSelectGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagesActionPerformed(evt);
            }
        });
        
        txtCaption.setText("Caption");

        btnSaveImage.setText("Save");

        btnAddGroup.setText("Add Group");

        GroupLayout btnPanelLayout = new GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addComponent(btnUpload)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCaption, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboSelectGroup, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnAddGroup)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveImage)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit))
        );
        
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
               .addGroup(GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpload)
                    .addComponent(btnExit)
                    .addComponent(cboSelectGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCaption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveImage)
                    .addComponent(btnAddGroup))
                .addContainerGap())
        );

        lblLogo.setBackground(java.awt.SystemColor.window);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        GroupLayout imgPanelLayout = new GroupLayout(imgPanel);
        imgPanel.setLayout(imgPanelLayout);
        imgPanelLayout.setHorizontalGroup(
            imgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(icon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        imgPanelLayout.setVerticalGroup(
            imgPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(icon, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(imgPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 
                                GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );       
    }
    
        private void btnbtnExitActionPerformed(java.awt.event.ActionEvent evt) {                                           
            this.setVisible(false);
    }                                          

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {                                          
        //Create a file chooser...
        JFileChooser fc = new JFileChooser();

        //In response to a button click:
        int returnVal = fc.showOpenDialog(null);

        fc.setFileSelectionMode(fc.DIRECTORIES_ONLY);
        if (returnVal == fc.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            String filename = selectedFile.getPath();
            JOptionPane.showMessageDialog(null, "You selected " + filename);
            ImageIcon imageView = new ImageIcon(filename);
            icon.setIcon(imageView);
            
            
        }
    
    }                                         

    private void btnImagesActionPerformed(java.awt.event.ActionEvent evt) {                                          

    }                                         
                
}
