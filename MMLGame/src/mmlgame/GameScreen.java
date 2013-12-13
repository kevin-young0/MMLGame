package mmlgame;

import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.*;
import mmlgame.ActionListeners.TimerAction;

/**
 * This class demonstrates how to use a FlowLayout manager
 * with a JFrame object's content pane.
 */

public class GameScreen extends JDialog
{
   private JButton btnNewGame;//Some button
   private JComboBox cboImages;//Images for game screen cards
   private JComboBox cboDifficulty;
   private final int WINDOW_WIDTH = 650;//default window width
   private final int WINDOW_HEIGHT = 498;//default window height
   //private Card [][] board;//two dimensional array of card objects
   private Random r;//declare field for a random object
   private JPanel pnlGameScreen;
   private HashMap<JPanel, Card> cardsMap;
   private JPanel firstCardClicked;
   static final File baseDir = new File("images/");
   private Image cardBackImage = new ImageIcon(this.getClass().getResource(baseDir + "/card.png")).getImage();
   private int allMatch;
   private int gameDiff;

   

   //Start of Constructor
   public GameScreen(JFrame owner)
   {
       //setPreferredSize(new Dimension(600,400));
       setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));//don't allow
      //main window to scale any smaller than the default height and width
       setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

       
       //Set the GameScreen to open to full screen at default:
       this.setUndecorated(false);//remove borders if true
       this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
       setPreferredSize(new Dimension(this.getBounds().width,this.getBounds().height));       

       setLocationRelativeTo(owner);
       
       
       
      //shuffle();//randomly swap each card's hidden words (the words on it's 
        //front side that the player never sees at the start of each game)
        //setCells();//after shuffling completes, randomly select each cell as a
        //new position for each card from the newly shuffled list of card objects.
        //printCells();//repopulate each cell with it's randomly chosen new card object 
        //playGame();
      // r = new Random();//initialize the random object field
      firstCardClicked = null;
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
      GridBagConstraints gbc = new GridBagConstraints();
      JPanel pnlSpacer = new JPanel();    
      
      //spacer above Image Category combo box
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      //GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;//set spacer above button in navigation panel      
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = .2;
      pnlNavigation.add(pnlSpacer, gbc); 
      
      
      


      //Create the Images Combo Box, and add it to the navigation panel:      
      cboImages = new JComboBox();
      cboImages.setPreferredSize(new Dimension(150, 40));
      cboImages.setMinimumSize(new Dimension(150, 40));
      
      //Position and set the scaling properties for the Images ComboBox:
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 1;//set position for Images Combo Box in navigation panel
      gbc.fill = GridBagConstraints.HORIZONTAL;//Gives the combobox some room to 
      //stretch for when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.anchor = GridBagConstraints.NORTH;      
      pnlNavigation.add(cboImages, gbc);//add the combobox to the navigation panel
      
      //spacer between Images combo box and difficulty combo box:
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      //GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 2;//set spacer above button in navigation panel      
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = .2;
      pnlNavigation.add(pnlSpacer, gbc);
      
      

      /*CBO DIFFICULTY HERE, GRIDY = 3*/
      //Create the Difficulty Combo Box, and add it to the navigation panel:
      String[] difficulty = {"Beginner", "Easy"};
      cboDifficulty = new JComboBox(difficulty);
      cboDifficulty.setSelectedIndex(0);//Beginner      
      cboDifficulty.setSelectedIndex(1);//Easy
      //cboDifficulty.addActionListener(this);
      
      cboDifficulty.setPreferredSize(new Dimension(150, 40));
      cboDifficulty.setMinimumSize(new Dimension(150, 40));
      
      //Position and set the scaling properties for the Difficulty ComboBox:
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 3;//set position for Images Combo Box in navigation panel
      gbc.fill = GridBagConstraints.HORIZONTAL;//Gives the combobox some room to 
      //stretch for when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.anchor = GridBagConstraints.NORTH;      
      pnlNavigation.add(cboDifficulty, gbc);//add the combobox to the navigation panel
      
      //spacer between difficulty combo box and button
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      //GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 4;//set spacer above button in navigation panel      
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = .2;
      pnlNavigation.add(pnlSpacer, gbc);
      
      //Create the New Game button, and add it to the navigation panel:
      btnNewGame = new JButton("New Game");
      btnNewGame.setPreferredSize(new Dimension(150, 40));
      btnNewGame.setMinimumSize(new Dimension(150, 40)); 
      
      btnNewGame.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              btnNewGameActionPerformed(e);
          }
      });
      
      gbc.gridx = 0;
      gbc.gridy = 5;//set New Game button as 2nd component in navigation panel    
      gbc.fill = GridBagConstraints.NONE;//don't allow button to resize
      gbc.weightx = 0;
      gbc.weighty = 0;      
      pnlNavigation.add(btnNewGame, gbc);
      
      
      //Spacer at bottom of nav panel
      pnlSpacer = new JPanel();
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 7;//set spacer under combobox in navigation panel      
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = 0;
      gbc.weighty = .2;
      pnlNavigation.add(pnlSpacer, gbc);
   }
   
   private void createGameScreen(ArrayList <Card> cards) {
      pnlGameScreen.removeAll();
      
      pnlGameScreen.setBackground(Color.CYAN);
      allMatch = 0;
      
      //Add a GridBagLayout manager to the Game Screen Panel:      
      pnlGameScreen.setLayout(new GridBagLayout());
      
      //Beginner difficulty will have 6 cards:
      Insets cardPadding = new Insets(3,3,3,3);
      int a = 0;
      /////////////
      //1: determine number of rows and columns from array of cards
      int rows = cards.size() / 3;//NOTE: cards.size specified by selected game difficulty
      int cols = cards.size() / rows;
      for(int row = 0; row < rows; row++){
            
            for(int col = 0; col < cols; col++){              
            Card card = cards.get(a);
            if (cardsMap == null) {
                cardsMap = new HashMap<>();
            }
            /*
             * "board[row][col]" is a single cell in the two dimensional array;
             * "words[a]" parameter is the word on the front (face) of each card;
             * "a" parameter is the integer on the back of each card;
             */
                JPanel pnlCard = new JPanel();
                // Save card relation to JPanel
                cardsMap.put(pnlCard, card);//save pnlCard object is the key to retieve the 'card' object
                //mouse listener:
                pnlCard.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        flipCardEvent(e);
                    }

                    //show hidden card face on hover in Beginner difficulty:
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                    }

                    //un-show hidden card face on mouse move away in Beginner difficulty:
                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                    }

                    
                });
                
                pnlCard.setLayout(new GridBagLayout());
                JLabel lblImage = new JLabel();        
                                
                if (card.isShowing()) {
                    lblImage.setIcon(card.getfrontImage());
                } else {
                    lblImage.setIcon(card.getbackImage());
                    
                }
                lblImage.addComponentListener(new ComponentListener() {

                    @Override
                    public void componentResized(ComponentEvent e) {
                        JLabel lbl = ((JLabel) e.getSource());
                        ImageIcon imgIcon = (ImageIcon) lbl.getIcon();
                        Image dimg = imgIcon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(),
                            Image.SCALE_SMOOTH);
                        lbl.setIcon(new ImageIcon(dimg));
                        lbl.revalidate();
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {}

                    @Override
                    public void componentShown(ComponentEvent e) {}

                    @Override
                    public void componentHidden(ComponentEvent e) {}
                });
                
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridy = 0;
                gbc.gridx = 0;           
                gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
                //for the combobox if it needs to stretch when we start populating it.
                gbc.weightx = 1;
                gbc.weighty = 1;
                
                pnlCard.add(lblImage, gbc);
                
                pnlCard.setBackground(Color.RED);
                //JFileChooser fc = new JFileChooser();
                //File file = new File("../images/card.png");
                
                //ImageIcon imageView = cards[a];
                //lblCard.setIcon(imageView);      
                gbc = new GridBagConstraints();
                gbc.gridy = row;//row 1
                gbc.gridx = col;//column 1           
                gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
                //for the combobox if it needs to stretch when we start populating it.
                gbc.weightx = .1;
                gbc.weighty = .1;
                gbc.insets = cardPadding;
                pnlGameScreen.add(pnlCard, gbc);
                
                
                //board[row][col] = new (Arraylist) Card(Card.frontImage[backImage], backImage);
                a++;//increment a, so that the loop will increment each new card
                //object (by incrementing each card's integer number on the back
                //of it) before it proceeds to pull the next card from the newly
                //shuffled list of card objects.               
            
          }//end of col for loop
        }//end of r
      //board = new Card [2][3];//2 rows by 3 columns matrix that can hold card
      //objects. In other words, we're building the array here that will hold
      //the card objects for the Beginner Difficulty.
      
      //http://stackoverflow.com/questions/14558959/adding-images-to-cells-in-a-gridlayout
      
       pnlGameScreen.revalidate();
       }//end of createGameScreen
   
   
      //2: Use For loop to dynamically create rows and columns
      //  for (rows) {
      //     for (cols) {
   
   
   //public void printCells(){
//        Card aCard;//"aCard" is a local variable (of datatype "Card", thanks to 
//        //the Card.java class). Each cell will be dynamically poplulated with 
//        //the card that was randomly assigned to it in the "setCells()" method.
//        for(int row = 0; row < board.length; row++){
//            
//            for(int col = 0; col < board[0].length; col++){              
//            {
//                aCard = board [row][col];//let each cell be populated with its
//                //new card (the aCard object)
//                aCard.showCard();//show the card face down in it's new cell. It
//                //should also be noted that this statment is using the 
//                //"showCard()" method in the Card.java class.
//            }
//            System.out.println();
//          }//end of col for loop
//        }//end of row for loop
      //}//end of printCells()
   
   
      //change "words" to frontImage (the hidden front of the card)
    public void shuffle(ArrayList<Card> cards){//shuffle the randomly selected hidden images
        r = new Random();//initialize the random object field
        for(int a = 0; a < cards.size(); a++){//loop through the array of words
            //(that is, the "Colors" from the String Array field)
            int rndPos = r.nextInt(cards.size()-1);//randomly choose a new position
            //for the words on the front of each card. Just to clarify, we 
            //always see the back of the card (the side with the integer number)
            //at the start of each game, so technically, randomly rearranging
            //the words hidden on the already-facing-down-front-side of the 
            //cards is the exact same thing as rearranging the cards themselves.
            
             
            Card waffles = cards.get(a);//cut out the card in 
            //index position a in our cards array list (note that "int a = 0;", 
            //as specifed in our for loop declaration), and store (paste) that 
            //card in "waffles". This clears the card array list's index position 
            //0 for another random card to take it's place. 
            
            Card pancakes = cards.get(rndPos);//select (cut) another
            //card in the cards array list (from a random index position, "rndPos"),
            //and store (paste) it in "pancakes". This clears that index position
            //(rndPos) for the card in "waffles" to take it's place.
            
            cards.set(a, pancakes);//replace "a" (which is always 0 in the first 
            //for loop iteration) with the card stored in "pancakes".
            
            cards.set(rndPos, waffles);//replace "rndPos" with the card stored 
            //in "waffles".               
            
        }//end of a for loop
    }//end of shuffle()
      /*
      JPanel pnlBeginnerCard1 = new JPanel();
      JLabel lblBeginnerCard1 = new JLabel();        
      lblBeginnerCard1.setPreferredSize(new Dimension(144,216));
      lblBeginnerCard1.setMaximumSize(new Dimension(144,216));
      pnlBeginnerCard1.add(lblBeginnerCard1);
      pnlBeginnerCard1.setBackground(Color.RED);
      //JFileChooser fc = new JFileChooser();
      //File file = new File("../images/card.png");
      ImageIcon imageView = new ImageIcon("E:\\Capstone\\MMLGame\\MMLGame\\src\\mmlgame\\images\\card.png");
      lblBeginnerCard1.setIcon(imageView);      
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridy = 0;//row 1
      gbc.gridx = 0;//column 1           
      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
      //for the combobox if it needs to stretch when we start populating it.
      gbc.weightx = .1;
      gbc.weighty = .1;
      gbc.insets = cardPadding;
      pnlGameScreen.add(pnlBeginnerCard1, gbc);      
      */
      //////////
      
      
    
/*  public static void main(String[] args)
{
//new GameScreen(this);//New instance ignored?
}*/
   
   private void initPanel(){
            //Add a GridBagLayout manager to the main window (content pane):      
      this.setLayout(new GridBagLayout());      
      GridBagConstraints gbc = new GridBagConstraints();   
      
      
      
      
      // End Test Cards            

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
      
      
      //Create the GameScreen Panel:
      pnlGameScreen = new JPanel();
      
      ///////////////////////////////
      ArrayList <Card> gameCards = new ArrayList();
      // Test Cards


      for (int numCards = 0; numCards < 6; numCards++) {
        Card gameCard = new Card();
        gameCard.setbackImage(new ImageIcon(cardBackImage));
        gameCards.add(gameCard);
      }
      ////////////////////////////////
      //Call the "createGameScreen" method to build the navigation
      //panel in the main window:
      createGameScreen(gameCards);
      
      //Add Game Screen panel to main window:      
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.fill = GridBagConstraints.BOTH;//automatically scale the Game Screen
      //panel BOTH horizontally and vertically upon window resize
      gbc.weightx = 1;
      gbc.weighty = 1;
      this.add(pnlGameScreen, gbc);
      
    }//end of initPanel()

    public void btnNewGameActionPerformed(ActionEvent e) {
        System.out.println("Button Clicked");
        
        //Create array of cards
        
        
        ArrayList <Card> cardsList = new ArrayList();
                   
        //cboDifficulty.addActionListener(this);
        String difficulty =  cboDifficulty.getSelectedItem().toString();
        
            gameDiff = 0;//initialize gameDiff to 0
        
        if(difficulty.equals("Beginner")){//Beginnner
        /*place 3 cards and 1 copy of each card (total of 6 cards) on gamescreen*/
            gameDiff = 3;
        }
        else if(difficulty.equals("Easy")){//Easy
        /*place 6 cards and 1 copy of each card (total of 12 cards) on gamescreen*/
            gameDiff = 6;
        }
        
            
            // Load random list of images to use
            int test = 1;
            for (int c = 0; c < gameDiff; c++) {//WHAT IS "c"?
                // Call database for pictures
                // Query to pick "gamediff" number of images
                 Card card = new Card();
                 card.setbackImage(new ImageIcon(cardBackImage));
                 
                     //File f1 = new File("/images/defaults/farm/farm001.png");
                     //String path = f1.getPath();
                     //FileInputStream fis = new FileInputStream(path);
                     Image img = null;
                     if (test == 1) {


                             img = new ImageIcon(this.getClass().getResource("images/default/duck.png")).getImage();
                             test = 2;
                     }else if (test == 2) {
                         //new File("./images/defaults/farm/farm002.png"
                         img = new ImageIcon(this.getClass().getResource("images/default/dog.png")).getImage();
                         test = 3;
                     } else {
                         //new File("./images/defaults/farm/farm003.png")
                         img = new ImageIcon(this.getClass().getResource("images/default/HappyDog.png")).getImage();

                         test = 1;
                     }
                     Image dimg = img.getScaledInstance(144, 216,
                            Image.SCALE_SMOOTH);
                 card.setfrontImage(new ImageIcon(dimg));
                
                 // Populate card with db results
                 cardsList.add(card);
            }
            

            // Clone list of cards for game
            for(int counter = 0; counter < gameDiff && counter < cardsList.size(); counter++){
                // Pull out current card from the loop
                Card orgCard = cardsList.get(counter);
                
                
                // Make new card to populate (clone it)
                  Card cloneCard =  new Card();
                  cloneCard.setfrontImage(orgCard.getfrontImage());
                  cloneCard.setbackImage(orgCard.getbackImage());
                  
                  cardsList.add(cloneCard);
                  
              }                   
        
        //use for loop to loop through array-list of cards
        shuffle(cardsList);
        //place cards in gridy, gridx
        createGameScreen(cardsList);
     }     
   
    //if the card is not showing:
    //card.setbackImage(cardBackImage);
    
    //else if the card is showing:
    //card.setfrontImage(new ImageIcon(dimg));
    
private void flipCardEvent(MouseEvent e) {

    JPanel pnlClicked = (JPanel)e.getSource();
    Card cardToCheck = cardsMap.get(pnlClicked);
    
    JLabel icon = (JLabel) pnlClicked.getComponent(0);
    
    if(cardToCheck.isMatched()){
        return;
    }
    
    // Toggle showing status
    cardToCheck.setShowing(!cardToCheck.isShowing());
    
    // Compare to previous card, if any
    if (firstCardClicked == null) {
        // No card currently showing
        firstCardClicked = pnlClicked;
    } else {
        // A card is already showing on the screen
        if (firstCardClicked == pnlClicked) {
            // Clicked same card
            firstCardClicked = null;
        } else {
            Card previousCard = cardsMap.get(firstCardClicked);
            
            if (previousCard.getfrontImage() == cardToCheck.getfrontImage()) {
                // Clicked match
                // Do Stuff
                cardToCheck.setMatched(true);
                previousCard.setMatched(true);
                
                allMatch++;//increment each card match, NOT each card!

                firstCardClicked = null;
            } else {
                // Clicked a non-match
                icon.setIcon(cardToCheck.getfrontImage());
                
                // Show front image for a few seconds
//                try {
//                  icon.setIcon(cardToCheck.getfrontImage());
//                  Thread.sleep(1000);
//                  
//                } 
//                catch(InterruptedException ex) {
//                  Thread.currentThread().interrupt();
//                }
                JLabel previousIcon = (JLabel) firstCardClicked.getComponent(0);
                previousCard.setShowing(false);
                cardToCheck.setShowing(false);
                
                TimerAction ta = new TimerAction( previousCard, cardToCheck, icon, previousIcon);
                Timer t = new Timer(1000, ta);
                t.setRepeats(false);
                t.start();               
                
                // Put timer to delay flip here
                
                //Reset firstCardClicked
                firstCardClicked = null;
                return;
            }
        }
    }
    
    // Flip the Card image for the card clicked
    if (cardToCheck.isShowing()) {
        icon.setIcon(cardToCheck.getfrontImage());
    } else {
        icon.setIcon(cardToCheck.getbackImage());
    }
    
    if(allMatch == gameDiff){
        JOptionPane.showMessageDialog (null, "Congratulations, you got them all right!");
    }
}

} // End of GameScreen class..
