/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 *and open the template in the editor...
*/

package mmlgame;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author TBuchliLap
 */
public class ImageEditor1 extends JDialog implements ActionListener {
    
    private JButton btnUpload;
    private JTextField txtCaption;
    private JComboBox cboSelectGroup;
    private JButton btnAddGroup;
    private JButton btnSave;
    private JButton btnExit;
    private JLabel lblImage;
    
    private final int WINDOW_WIDTH = 485;
    private final int WINDOW_HEIGHT = 470;
    
    private JPanel pnl1;
    private JPanel pnl2;
    private JPanel pnl3;
    
    // Start of Constructor...
    public ImageEditor1(JFrame owner) {
        
        setMinimumSize(new Dimension(485,470));
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(owner);        
        
        initPanel();
        
        pack();
        
    } // End ImageEditor1() Constructor...
    
    private ImageEditor1() {
        
        throw new UnsupportedOperationException("Not supported yet.");
        
    } // End ImageEditor1()...
    
    private void initPanel() {
        
        this.setLayout(new GridBagLayout());
        
        pnl1 = new JPanel();
        
        // Set pnl1 background color...
        pnl1.setBackground(Color.GREEN);
        pnl1.setLayout(new GridBagLayout());        
        
        int gridx = 0;
        
        //Start of pnl1...
        pnl1.setBackground(Color.GREEN);
        
        // Create the cboSelectGroup, and add it to the navigation panel:
        cboSelectGroup = new JComboBox();
        cboSelectGroup.setPreferredSize(new Dimension(150, 40));
        cboSelectGroup.setMinimumSize(new Dimension(150, 40));
           
        cboSelectGroup.addActionListener(this);
        
        // Set Select Group as component in navigation panel...
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        
        gbc.gridy = 0; // Up and down...
        
        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;
        
        gbc.weightx = 0;
        gbc.weighty = 0;      
        pnl1.add(cboSelectGroup, gbc);
        
        // Spacer between cboSelectGroup and btnAddGroup:
        // Get the same GREEN background as...
        JPanel pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl1.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0; // Set spacer above button in navigation panel...
        
        // BOTH instead of VERTICAL accomodates for the combo box if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;
        
        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .1;
        
        // Up and down...
        gbc.weighty = 0;
        
        pnl1.add(pnlSpacer, gbc);
        
        // Create the AddGroup button, and add it to the navigation panel:        
        btnAddGroup = new JButton("Add Group");
        btnAddGroup.setPreferredSize(new Dimension(150, 40));
        btnAddGroup.setMinimumSize(new Dimension(150, 40));
        
        btnAddGroup.addActionListener(this);
        
        // Set Add Group as component in navigation panel...
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        
        gbc.gridy = 0; // Up & down...
        
        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;
        
        // No weight setting for components (only spacers
        //should have weights)...
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        pnl1.add(btnAddGroup, gbc);
        
        // Spacer between btnAddGroup and btnExit:
        // Get the same GREEN background as pnlNavigation...
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl1.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        
        // Set spacer above button in navigation panel...
        gbc.gridy = 0;
        
        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;
        
        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .1;
        
        gbc.weighty = 0;
        pnl1.add(pnlSpacer, gbc);
        
        //btnExit
        btnExit = new JButton("Exit");
        btnExit.setPreferredSize(new Dimension(150, 40));
        btnExit.setMinimumSize(new Dimension(150, 40));
        
        btnExit.addActionListener(this);
        
        //Create the btnExit button, and add it to the navigation panel:
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;
        
        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;
        
        // No weight setting for components (only spacers should have
        //weights)...
        gbc.weightx = 0;
        gbc.weighty = 0;
        pnl1.add(btnExit, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;
        
        // No weight setting for components (only spacers should have
        //weights)...
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        this.add(pnl1, gbc);
        
        //End of Row1 Panel...
        
        
        
        //Start of Row2 Panel...
        pnl2 = new JPanel();
        
        gridx = 0;
        
        // Set pnl2 background color and layout...
        pnl2.setBackground(Color.MAGENTA);        
        pnl2.setLayout(new GridBagLayout());
        
        // Spacer between border and imgImage (gridx = 0):
        // Get the same GREEN background as pnlNavigation...
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl2.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        
        // Set spacer above button in navigation panel...
        gbc.gridy = 0;
        
        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;
        
        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .1;
        
        gbc.weighty = 0;
        pnl2.add(pnlSpacer, gbc);
        
        //lblImage (grid = 1)...
        lblImage = new JLabel();
        lblImage.setPreferredSize(new Dimension(150, 40));
        lblImage.setMinimumSize(new Dimension(150, 40));
                
        //Create the btnExit button, and add it to the navigation panel:
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        
        
        gbc.gridy = 0;
        
        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;
        
        // No weight setting for components (only spacers should have
        //weights)...
        gbc.weightx = 0;
        gbc.weighty = 0;
        pnl2.add(lblImage, gbc);
        
        
        // Spacer between imgImage and border (gridx = 3):
        // Get the same GREEN background as pnlNavigation...
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl2.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        
        // Set spacer above button in navigation panel...
        gbc.gridy = 0;
        
        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;
        
        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .1;
        
        gbc.weighty = 0;
        pnl2.add(pnlSpacer, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        
        // Set spacer above button in navigation panel...
        gbc.gridy = 0;
        
        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;
        
        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .1;
        
        gbc.weighty = 0;
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        
        // Set spacer above button in navigation panel...
        gbc.gridy = 1;
        
        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;
        
        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .1;
        
        gbc.weighty = 1; 
        
        this.add(pnl2, gbc);
        
        /*End of Row2 Panel*/
        
        
        
        
        /*Start of Row3 Panel*/
        pnl3 = new JPanel();
        
        gridx = 0;
        
        pnl3.setBackground(Color.YELLOW);
        
        //Create the btnUpload button, and add it to the navigation panel:
        btnUpload = new JButton("Upload");
        btnUpload.setPreferredSize(new Dimension(150, 40));
        btnUpload.setMinimumSize(btnUpload.getPreferredSize()); 
        btnUpload.addActionListener(this);
        
        // Set Upload as component in navigation panel...
        gbc.gridx = gridx++;  // gridx++ is the same as gridx = gridx + 1;
         
        gbc.gridy = 0; // Up & down...
        
        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;
        
        // No weight setting for components (only spacers
        //should have weights)...
        gbc.weightx = 0;
        gbc.weighty = 0;
        pnl3.add(btnUpload, gbc);
        
        // Spacer between btnUpload and btnCaption:
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl3.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        
        // Set spacer above button in navigation panel...
        gbc.gridy = 0;
        
        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;
        
        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .1;
        
        gbc.weighty = 0;
        pnl3.add(pnlSpacer, gbc);
        
        
        
        // Create the txtCaption, and add it to pnl3:
        txtCaption = new JTextField("Caption");
        txtCaption.setPreferredSize(new Dimension(150, 40));
        txtCaption.setMinimumSize(new Dimension(75, 40)); 
        txtCaption.addActionListener(this);
        
        gbc = new GridBagConstraints();
        // Set txtCaption as component in pnl3:
        gbc.gridx = gridx++;
        
        gbc.gridy = 0; // Up and down...
        
        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;
        
        gbc.weightx = .8;
        gbc.weighty = 0;      
        pnl3.add(txtCaption, gbc);
        
        // Spacer between btnAddGroup and btnSave:
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl3.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        
        // Set spacer above button in navigation panel...
        gbc.gridy = 0;
        
        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;
        
        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .1;
        
        gbc.weighty = 0;
        pnl3.add(pnlSpacer, gbc);
        
        // Create the btnSave, and add it to pnl3:
        btnSave = new JButton("Save");
        btnSave.setPreferredSize(new Dimension(150, 40));
        btnSave.setMinimumSize(new Dimension(75, 40)); 
        btnSave.addActionListener(this);
        
        gbc = new GridBagConstraints();
        // Set Caption as component in navigation panel...
        gbc.gridx = gridx++;
        
        gbc.gridy = 0; // Up and down...
        
        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;
        
        gbc.weightx = 0;
        gbc.weighty = 0;      
        pnl3.add(btnSave, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        
        // Set spacer above button in navigation panel...
        gbc.gridy = 2;
        
        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;
        
        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .1;
        
        gbc.weighty = 0; 
        
        this.add(pnl3, gbc);
        /*End of Row3 Panel*/
            
    } // End initPanel()...
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // To change body of generated methods, choose Tools | Templates...
        throw new UnsupportedOperationException("Not supported yet.");
        
    } // End actionPerformed(ActionEvent e)...
//    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                           
//            this.setVisible(false);
//    }        
    
} // End ImageEditor1 extends JDialog implements ActionListener...