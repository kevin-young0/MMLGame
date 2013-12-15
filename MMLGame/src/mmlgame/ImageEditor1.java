/*
 * This page is the pagge in which the user will enter to choose which
 *folder/category of pictures he/she wants to use, an Add Group button to add a
 *new folder/category, exit back to the main program, Upload an image, create a 
 * caption, and save the folder with it's proper caption in the folder...
 *
 * @author TBuchli
*/

package mmlgame;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.SwingConstants;

/**
 *
 * Beginning of page...
 * 
 */
public class ImageEditor1 extends JDialog implements ActionListener {
    
    private JButton btnUpload;
    private JTextField txtCaption;
    private JLabel lblCaption;
    private JComboBox cboSelectGroup;
    private JButton btnAddGroup;
    private JButton btnSave;
    private JButton btnExit;
    private JLabel lblImage;
    private JLabel lblIcon;
    private JLabel lblLogo;
   static final File baseDir = new File("images/");
   File[] comboFile;
    
    private final int WINDOW_WIDTH = 570;
    private final int WINDOW_HEIGHT = 470;
    
    private JPanel pnl1;
    private JPanel pnl2;
    private JPanel pnl3;
    
    // Start of Constructor...
    public ImageEditor1(JFrame owner) {

        setMinimumSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(owner);        

        initPanel();

        pack();

    } // End ImageEditor1() Constructor...

    private ImageEditor1() {

        throw new UnsupportedOperationException("Not supported yet!!!");

    } // End ImageEditor1()...

    private void initPanel() {

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GREEN);
        
        // Create panel:
        pnl1 = new JPanel();

        int gridx = 0;
        
        // Set background color, and layout...
        pnl1.setBackground(this.getBackground());
        pnl1.setLayout(new GridBagLayout());

        // Spacer between cboSelectGroup and btnAddGroup:
        // Get the same GREEN background as...
        JPanel pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl1.getBackground());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0; // Set spacer above button in navigation panel...

        // BOTH instead of VERTICAL accomodates for the combo box if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .5;

        // Up and down...
        gbc.weighty = 0;

        pnl1.add(pnlSpacer, gbc);

        // Create the cboSelectGroup, and add it to the navigation panel:    
        cboSelectGroup = new JComboBox();
        cboSelectGroup.setPreferredSize(new Dimension(150, 40));
        cboSelectGroup.setMinimumSize(new Dimension(150, 40));
        
        // Populate combobox with folder/category nammes...
        comboFile = baseDir.listFiles();
        
        for(int ctr = 0; ctr < comboFile.length; ctr++) {

            if(comboFile[ctr].isDirectory()) {
                
                cboSelectGroup.addItem(comboFile[ctr].getName());

            } // End if() {}...

        } // End for() {}...
        
        // addActionListener()...
        cboSelectGroup.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            } // End actionPerformed()...
            
        }); // End addActionListener()...

        // Set Select Group as component in navigation panel...
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;

        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;

        gbc.weightx = 0;
        gbc.weighty = 0;      
        pnl1.add(cboSelectGroup, gbc);

        // Spacer between cboSelectGroup and btnAddGroup:
        // Get the same GREEN background as...
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl1.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;

        // BOTH instead of VERTICAL accomodates for the combo box if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.NONE;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = 0;
        
        gbc.weighty = 0;

        pnl1.add(pnlSpacer, gbc);

        // Create the AddGroup button, and add it to the navigation panel:        
        btnAddGroup = new JButton("Add Category");
        btnAddGroup.setPreferredSize(new Dimension(150, 40));
        btnAddGroup.setMinimumSize(new Dimension(150, 40));

        btnAddGroup.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                btnAddGroupActionPerformed(evt);
                
            } // End actionPerformed()...
            
        }); // End addActionListener()...
        
        // Set Add Group as component in navigation panel...
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;

        gbc.gridy = 0;

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
        gbc.gridy = 0;

        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.NONE;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = 0;

        gbc.weighty = 0;
        
        pnl1.add(pnlSpacer, gbc);

        // Create the btnExit button, and add it to the navigation panel:
        btnExit = new JButton("Exit");
        btnExit.setPreferredSize(new Dimension(150, 40));
        btnExit.setMinimumSize(new Dimension(150, 40));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                btnExitActionPerformed(evt);
                
            } // End actionPerformed()...
            
        }); // End addActionListener()...

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

        // Spacer between cboSelectGroup and btnAddGroup:
        // Get the same GREEN background as...
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl1.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;

        // BOTH instead of VERTICAL accomodates for the combo box if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .5;
        
        gbc.weighty = 0;

        pnl1.add(pnlSpacer, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.BOTH;

        // No weight setting for components (only spacers should have
        //weights)...
        gbc.weightx = .1;
        gbc.weighty = 0;

        this.add(pnl1, gbc);
        //End of Row1 Panel...
        
        //Start of Row2 Panel...
        pnl2 = new JPanel();

        gridx = 0;

        // Set pnl2 background color and layout...
        pnl2.setBackground(Color.RED);
        pnl2.setLayout(new GridBagLayout());

        // Spacer between border and imgImage (gridx = 0):
        // Get the same GREEN background as pnlNavigation...
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl2.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;

        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .5;

        gbc.weighty = 0;

        pnl2.add(pnlSpacer, gbc);

        // Add the icon here:
        lblIcon = new JLabel();

        lblIcon.setBackground(Color.ORANGE);
        lblIcon.setPreferredSize(new Dimension(144, 216));        
        lblIcon.setMinimumSize(new Dimension(144, 216));

        gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = 0;

        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;

        // No weight setting for components (only spacers should have
        //weights)...
        gbc.weightx = 0;
        gbc.weighty = 0;
        pnl2.add(lblIcon, gbc);

        // Caption Label...
        lblCaption = new JLabel();
        lblCaption.setFont(new Font("Bodoni MT Black", Font.BOLD, 14));

        lblCaption.setBackground(Color.WHITE);
        lblCaption.setOpaque(true);
        lblCaption.setPreferredSize(new Dimension(144, 40));        
        lblCaption.setMinimumSize(new Dimension(144, 40));
        lblCaption.setHorizontalAlignment(SwingConstants.CENTER);

        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 1;

        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;

        // No weight setting for components (only spacers should have
        //weights)...
        gbc.weightx = 0;
        gbc.weighty = 0;

        pnl2.add(lblCaption, gbc);

        // Spacer between imgImage and border (gridx = 3):
        // Get the same GREEN background as pnlNavigation...
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl2.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;

        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.BOTH;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .5;

        gbc.weighty = 0;
        
        pnl2.add(pnlSpacer, gbc);

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

        pnl3.setBackground(this.getBackground());        
        pnl3.setLayout(new GridBagLayout());

        // Spacer between cboSelectGroup and btnAddGroup:
        // Get the same GREEN background as...
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl3.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;

        // BOTH instead of VERTICAL accomodates for the combo box if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .5;
        
        gbc.weighty = 0;

        pnl3.add(pnlSpacer, gbc);

        //Create the btnUpload button, and add it to the navigation panel:
        btnUpload = new JButton("Upload");
        btnUpload.setPreferredSize(new Dimension(150, 40));
        btnUpload.setMinimumSize(btnUpload.getPreferredSize()); 
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                btnUploadActionPerformed(evt);
                
            } // End actionPerformed()...
            
        }); // End addActionListener()...

        // Set Upload as component in navigation panel...
        gbc.gridx = gridx++;

        gbc.gridy = 0;

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
        gbc.gridy = 0;

        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.NONE;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = 0;

        gbc.weighty = 0;
        
        pnl3.add(pnlSpacer, gbc);

        // Create the txtCaption, and add it to pnl3:
        txtCaption = new JTextField("Caption");
        txtCaption.setPreferredSize(new Dimension(150, 40));
        txtCaption.setMinimumSize(new Dimension(75, 40)); 
        txtCaption.addActionListener(this);
        txtCaption.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                
                lblCaption.setText(((JTextField)e.getSource()).getText());
            
            } // End keyReleased()...
        
        }); // End addKeyListener()...

        txtCaption.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                
                ((JTextField) e.getSource()).selectAll();
                
            } // End focusGained()...

            @Override
            public void focusLost(FocusEvent e) {}
            
        }); // End focusLost()...
        
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;

        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;

        gbc.weightx = 0;
        gbc.weighty = 0;      
        pnl3.add(txtCaption, gbc);

        // Spacer between btnAddGroup and btnSave:
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl3.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;

        // BOTH instead of VERTICAL accomodates for the combobox if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.NONE;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = 0;

        gbc.weighty = 0;
        
        pnl3.add(pnlSpacer, gbc);

        // Create the btnSave, and add it to pnl3:
        btnSave = new JButton("Save");
        btnSave.setPreferredSize(new Dimension(150, 40));
        btnSave.setMinimumSize(new Dimension(75, 40)); 
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSaveActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(ImageEditor1.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }        
        }); // End addActionListener()...

        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;

        // Don't allow button to resize...
        gbc.fill = GridBagConstraints.NONE;

        gbc.weightx = 0;
        gbc.weighty = 0;
        
        pnl3.add(btnSave, gbc);

        // Spacer between cboSelectGroup and btnAddGroup:
        // Get the same GREEN background as...
        pnlSpacer = new JPanel();
        pnlSpacer.setBackground(pnl3.getBackground());
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;
        gbc.gridy = 0;
        
        // Horizontal allows the combo box to stretch horizontaly when we start
        //populating it...
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .5;
        
        gbc.weighty = 0;

        pnl3.add(pnlSpacer, gbc);

        gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
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

   // @Override
   public void actionPerformed(ActionEvent e) {
//        try {
//            btnSaveActionPerformed(e);
//        } catch (IOException ex) {
//            Logger.getLogger(ImageEditor1.class.getName()).log(Level.SEVERE, null, ex);
//        }

   }
    // Combobox...
    private void btnImagesActionPerformed(java.awt.event.ActionEvent evt) {

    } // End btnImagesActionPerformed()...

    // Exit screen...
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        
            this.setVisible(false);

    } // End btnExitActionPerformed()...
    
    private void btnAddGroupActionPerformed(java.awt.event.ActionEvent evt) {

        // Get a guess from the user...
        String strCat = JOptionPane.showInputDialog("Please enter a new folder/category name: ");
        
        // Validate (can't save same category names)...
        
        // Print folder/category name...
        System.out.println(strCat);
        
        // Fill ComboBox with string name...
        cboSelectGroup.addItem(strCat);
        cboSelectGroup.setSelectedItem(strCat);
        
        String destination = "images/";
        
        File createDir = new File(destination + "/" + strCat);
        
        // Add working directory...
        createDir.mkdir();
        
    } // End btnAddGroupActionPerformed()...

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {
        
        // Create a file chooser...
        JFileChooser fc = new JFileChooser();

        // In response to a button click:
        int returnVal = fc.showOpenDialog(null);

        fc.setFileSelectionMode(fc.DIRECTORIES_ONLY);
        if (returnVal == fc.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            String filename = selectedFile.getPath();
            JOptionPane.showMessageDialog(null, "You selected " + filename);
            ImageIcon imageView = new ImageIcon(filename);
            lblIcon.setIcon(imageView);

        } // End if() {}...

    } // End btnUploadActionPerformedbtnUploadActionPerformed()...

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        
        // Save ImageIcon...
        ImageIcon sveImage = (ImageIcon)lblIcon.getIcon();

        // Save Caption...
        String sveCaption = lblCaption.getText();
        
        // Save dialog...
        JOptionPane.showMessageDialog(null, "Folder/Category/Image has been saved!!!");
        
        // Convert text in combobox to string...
        String newDir = cboSelectGroup.getSelectedItem().toString();
        
        // Convert path to string...
        String src = baseDir + "/" + newDir;
        
        // Create new file...
        File javaFilePath = new File(src, "/" + lblCaption.getText() + ".png");
        
        if (! javaFilePath.exists()){
            
            JOptionPane.showMessageDialog(null, "Folder/Category, Image and Caption saved!!!");
///////////////////////////////            File.renameTo(javaFilePath);
            
        }else{
            
            System.out.println("This is not working");
            
        } // End if(){else{}...
        
    } // End btnSaveActionPerformed()...
    
} // End ImageEditor1 extends JDialog implements ActionListener {}...