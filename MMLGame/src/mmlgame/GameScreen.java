package mmlgame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class demonstrates how to use a FlowLayout manager
 * with a JFrame object's content pane.
 */

public class GameScreen extends JDialog implements ActionListener
{
   private JButton btnNewGame;//Some button
   private JComboBox cboImages;//Images for game screen cards
   private final int WINDOW_WIDTH = 600;//default window width
   private final int WINDOW_HEIGHT = 400;//default window height

   //Start of Constructor
   public GameScreen(JFrame owner)
   {
       setPreferredSize(new Dimension(600,400));
       setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));//don't allow
      //main window to scale any smaller that the default height and width
       setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
       setLocationRelativeTo(owner);
      // Set the title bar text.
      //super("MMLG");

      // Set the default size of the main window:
      //setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      //setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));//don't allow
      //main window to scale any smaller that the default height and width

      // Specify what happens when the close button is clicked.
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      initPanel();
        
      pack();

      //Display the window:
      //setVisible(true);
   }
   //End of Constructor
   
   
   //"createNavigationPanel" method:
   private void createNavigationPanel(JPanel pnlNavigation) {
      pnlNavigation.setBackground(Color.GREEN);
      
      //Add a GridBagLayout manager to the navigation panel:      
      pnlNavigation.setLayout(new GridBagLayout());
      
          
      JPanel pnlSpacer = new JPanel();
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;//set spacer above button in navigation panel      
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = .45;
      pnlNavigation.add(pnlSpacer, gbc); 
      
      
      //Create the New Game button, and add it to the navigation panel:
      btnNewGame = new JButton("New Game");
      btnNewGame.setPreferredSize(new Dimension(150, 40));
      btnNewGame.setMinimumSize(new Dimension(150, 40)); 
      
      btnNewGame.addActionListener(this);
      
      gbc.gridx = 0;
      gbc.gridy = 1;//set New Game button as 2nd component in navigation panel    
      gbc.fill = GridBagConstraints.NONE;//don't allow button to resize
      gbc.weightx = 0;
      gbc.weighty = 0;      
      pnlNavigation.add(btnNewGame, gbc);
      
      
      //Put spacer between button and combo box:
      pnlSpacer = new JPanel();
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 2;//set spacer between button and combo box in navigation panel      
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = .1;
      pnlNavigation.add(pnlSpacer, gbc); 
      
      
      //Create the Images Combo Box, and add it to the navigation panel:
      cboImages = new JComboBox();
      cboImages.setPreferredSize(new Dimension(150, 40));
      cboImages.setMinimumSize(new Dimension(150, 40));
      
      //Position and set the scaling properties for the Images ComboBox:
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 3;//set position for Images Combo Box in navigation panel
      gbc.fill = GridBagConstraints.HORIZONTAL;//Gives the combobox some room to 
      //stretch for when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.anchor = GridBagConstraints.NORTH;      
      pnlNavigation.add(cboImages, gbc);//add the combobox to the navigation panel 
      
      
      //Spacer at bottom of nav panel
      pnlSpacer = new JPanel();
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 4;//set spacer under combobox in navigation panel      
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = .45;
      pnlNavigation.add(pnlSpacer, gbc);
   }
   
   private void createGameScreen(JPanel pnlGameScreen) {
       pnlGameScreen.setBackground(Color.CYAN);
      
      //Add a GridBagLayout manager to the Game Screen Panel:      
      pnlGameScreen.setLayout(new GridBagLayout());
      
      /*
      Beginner difficulty will have 6 cards:
      */
      //
      Insets cardPadding = new Insets(3,3,3,3);
      
      //Beginner Card 1 (row 1, column 1):
      JPanel pnlBeginnerCard1 = new JPanel();
      pnlBeginnerCard1.setBackground(Color.RED);
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridy = 0;//row 1
      gbc.gridx = 0;//column 1           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard1, gbc);
      
      //Beginner Card 2 (row 1, column 2):
      JPanel pnlBeginnerCard2 = new JPanel();
      pnlBeginnerCard2.setBackground(Color.BLUE);
      gbc = new GridBagConstraints();
      gbc.gridy = 0;//row 1
      gbc.gridx = 1;//column 2           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard2, gbc);
      
      //Beginner Card 3 (row 1, column 3):
      JPanel pnlBeginnerCard3 = new JPanel();
      pnlBeginnerCard3.setBackground(Color.MAGENTA);
      gbc = new GridBagConstraints();
      gbc.gridy = 0;//row 1
      gbc.gridx = 2;//column 3           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard3, gbc);
      
      //Beginner Card 4 (row 2, column 1):
      JPanel pnlBeginnerCard4 = new JPanel();
      pnlBeginnerCard4.setBackground(Color.ORANGE);
      gbc = new GridBagConstraints();
      gbc.gridy = 1;//row 2
      gbc.gridx = 0;//column 1           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard4, gbc);
      
      //Beginner Card 5 (row 2, column 2):
      JPanel pnlBeginnerCard5 = new JPanel();
      pnlBeginnerCard5.setBackground(Color.WHITE);
      gbc = new GridBagConstraints();
      gbc.gridy = 1;//row 2
      gbc.gridx = 1;//column 2           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard5, gbc);
      
      //Beginner Card 1 (row 2, column 3):
      JPanel pnlBeginnerCard6 = new JPanel();
      pnlBeginnerCard6.setBackground(Color.DARK_GRAY);
      gbc = new GridBagConstraints();
      gbc.gridy = 1;//row 2
      gbc.gridx = 2;//column 3           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard6, gbc);
      
      
      
   }
   
   private void createGameScreen2(JPanel pnlGameScreen) {
       pnlGameScreen.setBackground(Color.CYAN);
      
      //Add a GridBagLayout manager to the Game Screen Panel:      
      pnlGameScreen.setLayout(new GridBagLayout());
      
      /*
      Beginner difficulty will have 6 cards:
      */
      //
      Insets cardPadding = new Insets(3,3,3,3);
      
      //Beginner Card 1 (row 1, column 1):
      JPanel pnlBeginnerCard1 = new JPanel();
      pnlBeginnerCard1.setBackground(Color.RED);
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridy = 0;//row 1
      gbc.gridx = 0;//column 1           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard1, gbc);
      
      //Beginner Card 2 (row 1, column 2):
      JPanel pnlBeginnerCard2 = new JPanel();
      pnlBeginnerCard2.setBackground(Color.BLUE);
      gbc = new GridBagConstraints();
      gbc.gridy = 0;//row 1
      gbc.gridx = 1;//column 2           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard2, gbc);
      
      //Beginner Card 3 (row 1, column 3):
      JPanel pnlBeginnerCard3 = new JPanel();
      pnlBeginnerCard3.setBackground(Color.MAGENTA);
      gbc = new GridBagConstraints();
      gbc.gridy = 0;//row 1
      gbc.gridx = 2;//column 3           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard3, gbc);
      
      //Beginner Card 4 (row 2, column 1):
      JPanel pnlBeginnerCard4 = new JPanel();
      pnlBeginnerCard4.setBackground(Color.ORANGE);
      gbc = new GridBagConstraints();
      gbc.gridy = 1;//row 2
      gbc.gridx = 0;//column 1           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard4, gbc);
      
      //Beginner Card 5 (row 2, column 2):
      JPanel pnlBeginnerCard5 = new JPanel();
      pnlBeginnerCard5.setBackground(Color.WHITE);
      gbc = new GridBagConstraints();
      gbc.gridy = 1;//row 2
      gbc.gridx = 1;//column 2           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard5, gbc);
      
      //Beginner Card 1 (row 2, column 3):
      JPanel pnlBeginnerCard6 = new JPanel();
      pnlBeginnerCard6.setBackground(Color.DARK_GRAY);
      gbc = new GridBagConstraints();
      gbc.gridy = 1;//row 2
      gbc.gridx = 2;//column 3           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard6, gbc);
      
      
      
   }
   
   
   
   public static void main(String[] args)
   {
      //new GameScreen();//New instance ignored?
   }
   
   private void initPanel(){
            //Add a GridBagLayout manager to the main window (content pane):      
      this.setLayout(new GridBagLayout());      
      
      
      //Create Cards panel
      JPanel pnlGameScreen = new JPanel();
      
      //Call the "createGameScreen" method to build the navigation
      //panel in the main window:
      createGameScreen(pnlGameScreen);
      
          
      //Add Game Screen panel to main window:
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.fill = GridBagConstraints.BOTH;//automatically scale the Game Screen
      //panel BOTH horizontally and vertically upon window resize
      gbc.weightx = 1;
      gbc.weighty = 1;//scale navigation panel component 100% vertically upon 
      //window resizing (for example, when the window resizes 50px vertically, 
      //resize the navigation panel 50px vertically)
      this.add(pnlGameScreen, gbc);      
      
      
      //Create the Navigatin panel:
      JPanel pnlNavigation = new JPanel();
      
      //Call the "createNavigationPanel" method to build the navigation
      //panel in the main window:
      createNavigationPanel(pnlNavigation);
      
      //Add navigation panel to main window:
      gbc = new GridBagConstraints();
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.fill = GridBagConstraints.VERTICAL;
      gbc.weightx = 0;
      gbc.weighty = 1;
      this.add(pnlNavigation, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked");
        
        //Create array of cards
        
        //use for loop to loop through array-list of cards
        
        //place cards in gridy, gridx
   }
}