/*
 * This page is the pagge in which the user will enter to choose which
 *folder/category of pictures he/she wants to use, an Add Group button to add a
 *new folder/category, exit the program, Upload an image, create a caption, and
 *save the folder with it's proper caption in the folder...
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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        throw new UnsupportedOperationException("Not supported yet.");

    } // End ImageEditor1()...

    private void initPanel() {

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GREEN);

        pnl1 = new JPanel();

        int gridx = 0;
        // Set pnl1 background color...
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

        cboSelectGroup.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            
                btnImagesActionPerformed(evt);

            }
            
        });

        // Set Select Group as component in navigation panel...
        gbc = new GridBagConstraints();
        gbc.gridx = gridx++;

        gbc.gridy = 0; // Up and down...

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
        gbc.gridy = 0; // Set spacer above button in navigation panel...

        // BOTH instead of VERTICAL accomodates for the combo box if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.NONE;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = 0;

        // Up and down...
        gbc.weighty = 0;

        pnl1.add(pnlSpacer, gbc);

        // Create the AddGroup button, and add it to the navigation panel:        
        btnAddGroup = new JButton("Add Category");
        btnAddGroup.setPreferredSize(new Dimension(150, 40));
        btnAddGroup.setMinimumSize(new Dimension(150, 40));

        btnAddGroup.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                btnAddGroupActionPerformed(evt);
                
            }
            
        });
        
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
        gbc.fill = GridBagConstraints.NONE;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = 0;

        gbc.weighty = 0;
        pnl1.add(pnlSpacer, gbc);

        //Create the btnExit button, and add it to the navigation panel:
        btnExit = new JButton("Exit");
        btnExit.setPreferredSize(new Dimension(150, 40));
        btnExit.setMinimumSize(new Dimension(150, 40));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                btnExitActionPerformed(evt);
                
            }
            
        });

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
        gbc.gridy = 0; // Set spacer above button in navigation panel...

        // BOTH instead of VERTICAL accomodates for the combo box if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .5;

        // Up and down...
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

        ////////////////////////////////////////////////////////////////////////
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

        // Set spacer above button in navigation panel...
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

        /*hint for refering/calling variables from another 
        class (within the mmlgame package):
        classname | variable
        CropImage.icon;
        */

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
        lblCaption.setFont(new Font("Algerian", Font.BOLD, 12));

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

        // Set spacer above button in navigation panel...
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
        ////////////////////////////////////////////////////////////////////////

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
        gbc.gridy = 0; // Set spacer above button in navigation panel...

        // BOTH instead of VERTICAL accomodates for the combo box if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .5;

        // Up and down...
        gbc.weighty = 0;

        pnl3.add(pnlSpacer, gbc);

        //Create the btnUpload button, and add it to the navigation panel:
        btnUpload = new JButton("Upload");
        btnUpload.setPreferredSize(new Dimension(150, 40));
        btnUpload.setMinimumSize(btnUpload.getPreferredSize()); 
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                btnUploadActionPerformed(evt);
                
            }
            
        });

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
            
            }
        
        });

        txtCaption.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                
                ((JTextField) e.getSource()).selectAll();
                
            }

            @Override
            public void focusLost(FocusEvent e) {}
            
        });

        gbc = new GridBagConstraints();
        // Set txtCaption as component in pnl3:
        gbc.gridx = gridx++;

        gbc.gridy = 0; // Up and down...

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

        // Set spacer above button in navigation panel...
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
                
                btnSaveActionPerformed(evt);
            
            }
        
        });

        gbc = new GridBagConstraints();
        // Set Caption as component in navigation panel...
        gbc.gridx = gridx++;

        gbc.gridy = 0; // Up and down...

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
        gbc.gridy = 0; // Set spacer above button in navigation panel...

        // BOTH instead of VERTICAL accomodates for the combo box if it needs to
        //stretch when we start populating it...
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Takes up 10% of the width of the Navigation panel...
        gbc.weightx = .5;

        // Up and down...
        gbc.weighty = 0;

        pnl3.add(pnlSpacer, gbc);

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
        ////////////////////////////////////////////////////////////////////////

    } // End initPanel()...

   // @Override
   public void actionPerformed(ActionEvent e) {
       
   //     btnSaveActionPerformed(e);

   } // End actionPerformed(ActionEvent e)...

    // Combobox...
    private void btnImagesActionPerformed(java.awt.event.ActionEvent evt) {

    }

    // Exit screen...
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        
            this.setVisible(false);

    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    private void btnAddGroupActionPerformed(java.awt.event.ActionEvent evt) {
        
       
        // Get a guess from the user...
        String strCat = JOptionPane.showInputDialog("Please enter a new folder/category name: ");
        
        //Validate (cant save same category names)...
        
        
        System.out.println(strCat);
        
        // Needs to generate new table in DB so combobox displays new
        //folder/category...
        final String DB_URL = ("jdbc:sqlite:ImageEditTable.sqlite");
        Connection conn = null;
        try {
            
            // Create a connection to the dattabase...
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DB_URL);
            
            Statement stmt = null;
            String sql = "INSERT INTO ImageTble VALUES ('"+strCat+"')";
            
            //
            
            try {
                stmt = conn.createStatement();
                if (stmt.executeUpdate(sql)!=1) {
                    // Something wrong with INSERT statement...
                     System.out.println("This is wrong somehow: >>" + sql + "<<");
                }
               stmt.close();
            } catch (SQLException e ) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                if (stmt != null) { stmt.close(); }
            }
            
            conn.close();
            conn = null;
///////////////////////////JTable table = newJTable(data, columnNames);//////////////////////////////////
            
        }
        
        catch(Exception ex) {
            
            System.out.println("Error: " + ex.getMessage());

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException ex) {}
            }
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

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
            lblIcon.setIcon(imageView);

        }

    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        
        // Save ImageIcon...
        ImageIcon sveImage = (ImageIcon) lblIcon.getIcon();

        // Save Caption...
        String sveCaption = lblCaption.getText();
        
        // Save dialog...
        JOptionPane.showMessageDialog(null, "Folder/Category/Image has been saved!!!");
        
    } // End BtnSave...
    
} // End ImageEditor1 extends JDialog implements ActionListener...