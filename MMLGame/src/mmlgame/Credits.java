/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mmlgame;

import java.awt.Dialog;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Randy Nelson
 */
public class Credits extends JDialog {

    Credits(JFrame owner) {
        
        setPreferredSize(new Dimension(600,400));
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(owner);
        
        
        initPanel();
        
        pack();
    }

    private void initPanel() {
        JPanel pnlCredits = new JPanel();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        

        GroupLayout pnlCreditsLayout = new GroupLayout(pnlCredits);
        pnlCredits.setLayout(pnlCreditsLayout);
        pnlCreditsLayout.setHorizontalGroup(
            pnlCreditsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        pnlCreditsLayout.setVerticalGroup(
            pnlCreditsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(pnlCredits, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/credits.png"))); // NOI18N

        jLabel2.setText("Kevin Young");

        jLabel3.setText("Randy Nelson");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addContainerGap(308, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("lblCreditsHead");
        jLabel1.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }
}