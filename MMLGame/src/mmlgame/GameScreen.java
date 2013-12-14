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
   private JButton btnNewGame;
   private JComboBox cboImages;
   private JComboBox cboDifficulty;
   private final int WINDOW_WIDTH = 650;
   private final int WINDOW_HEIGHT = 498;
   private Random r;
   private JPanel pnlGameScreen;
   private HashMap<JPanel, Card> cardsMap;
   private JPanel firstCardClicked;
   static final File baseDir = new File("images/");
   private Image cardBackImage = new ImageIcon(this.getClass().getResource(baseDir + "/card.png")).getImage();
   private int allMatch;
   private int gameDiff;
   File[] comboFile;
   //ArrayList<int> randomNumbers;

   public GameScreen(JFrame owner)
   {
      
       setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
       setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

       this.setUndecorated(false);
       this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
       setPreferredSize(new Dimension(this.getBounds().width,this.getBounds().height));       

       setLocationRelativeTo(owner);
       
      firstCardClicked = null;
      initPanel();
      pack();

   }
   
      private void createNavigationPanel(JPanel pnlNavigation) {
      pnlNavigation.setBackground(Color.GREEN);
            
      pnlNavigation.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      JPanel pnlSpacer = new JPanel();    
      
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      
      gbc.gridx = 0;
      gbc.gridy = 0;    
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 0;
      gbc.weighty = .2;
      pnlNavigation.add(pnlSpacer, gbc); 
           
      cboImages = new JComboBox();
      cboImages.setPreferredSize(new Dimension(150, 40));
      cboImages.setMinimumSize(new Dimension(150, 40));
      comboFile = baseDir.listFiles();
      for(int ctr = 0; ctr < comboFile.length; ctr++){
          if(comboFile[ctr].isDirectory()){
              cboImages.addItem(comboFile[ctr].getName());
          }
      }
      
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.anchor = GridBagConstraints.NORTH;      
      pnlNavigation.add(cboImages, gbc);
      
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      
      gbc.gridx = 0;
      gbc.gridy = 2;      
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 0;
      gbc.weighty = .2;
      pnlNavigation.add(pnlSpacer, gbc);
    
      String[] difficulty = {"Beginner", "Easy"};
      cboDifficulty = new JComboBox(difficulty);
      cboDifficulty.setSelectedIndex(0);//Beginner      
      cboDifficulty.setSelectedIndex(1);//Easy
      
      
      cboDifficulty.setPreferredSize(new Dimension(150, 40));
      cboDifficulty.setMinimumSize(new Dimension(150, 40));
      
     
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.anchor = GridBagConstraints.NORTH;      
      pnlNavigation.add(cboDifficulty, gbc);
      
      
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      
      gbc.gridx = 0;
      gbc.gridy = 4;     
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 0;
      gbc.weighty = .2;
      pnlNavigation.add(pnlSpacer, gbc);
      
      
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
      gbc.gridy = 5;  
      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 0;
      gbc.weighty = 0;      
      pnlNavigation.add(btnNewGame, gbc);
      
      
     
      pnlSpacer = new JPanel();
      pnlSpacer.setBackground(pnlNavigation.getBackground());
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 7;      
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 0;
      gbc.weighty = .2;
      pnlNavigation.add(pnlSpacer, gbc);
   }
   
   private void createGameScreen(ArrayList <Card> cards) {
      pnlGameScreen.removeAll();
      
      pnlGameScreen.setBackground(Color.CYAN);
      allMatch = 0;
            
      pnlGameScreen.setLayout(new GridBagLayout());
      
      
      Insets cardPadding = new Insets(3,3,3,3);
      int a = 0;
      
      int rows = cards.size() / 3;
      int cols = cards.size() / rows;
      for(int row = 0; row < rows; row++){
            
            for(int col = 0; col < cols; col++){              
            Card card = cards.get(a);
            if (cardsMap == null) {
                cardsMap = new HashMap<>();
            }
            
            JPanel pnlCard = new JPanel();
                
            cardsMap.put(pnlCard, card);
                
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

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                    }

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
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1;
                gbc.weighty = 1;
                
                pnlCard.add(lblImage, gbc);
                
                pnlCard.setBackground(Color.RED);
                
                gbc = new GridBagConstraints();
                gbc.gridy = row;
                gbc.gridx = col;         
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = .1;
                gbc.weighty = .1;
                gbc.insets = cardPadding;
                pnlGameScreen.add(pnlCard, gbc);
                a++;
          }
        }
      
       pnlGameScreen.revalidate();
       }   
     
    public void shuffle(ArrayList<Card> cards){
        r = new Random();
        for(int a = 0; a < cards.size(); a++){
            int rndPos = r.nextInt(cards.size()-1);
            
            Card waffles = cards.get(a);
                        
            Card pancakes = cards.get(rndPos);
                        
            cards.set(a, pancakes);
                        
            cards.set(rndPos, waffles);
        }
    }
   
   private void initPanel(){
                  
      this.setLayout(new GridBagLayout());      
      GridBagConstraints gbc = new GridBagConstraints();   
      
      JPanel pnlNavigation = new JPanel();      
      
      createNavigationPanel(pnlNavigation);      
      
      gbc = new GridBagConstraints();
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.fill = GridBagConstraints.VERTICAL;
      gbc.weightx = 0;
      gbc.weighty = 1;
      this.add(pnlNavigation, gbc);
      
      pnlGameScreen = new JPanel();
      
      ///////////////////////////////
      ArrayList <Card> gameCards = new ArrayList();
      
      for (int numCards = 0; numCards < 6; numCards++) {
        Card gameCard = new Card();
        gameCard.setbackImage(new ImageIcon(cardBackImage));
        
        gameCards.add(gameCard);
      }
      ////////////////////////////////
      
      createGameScreen(gameCards);
      
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.fill = GridBagConstraints.BOTH;
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
        
        Random randInt = new Random();
        String userDir = cboImages.getSelectedItem().toString();
        File filePath = new File(baseDir + "/" + userDir);
        comboFile =  filePath.listFiles();
        for(int ctr = 0; ctr < comboFile.length; ctr++){
            if(ctr < gameDiff){
                int random = randInt.nextInt(comboFile.length);
                //randomNumbers += random;

                Card card = new Card();
                card.setbackImage(new ImageIcon(cardBackImage));
                
                Image img = null;
                
                img = new ImageIcon(this.getClass().getResource(comboFile[random].getPath())).getImage();
                      
                     
                Image dimg = img.getScaledInstance(144, 216, Image.SCALE_SMOOTH);
                card.setfrontImage(new ImageIcon(dimg));
                
                // Populate card with db results
                cardsList.add(card);
            
            }
//          if(comboFile[ctr].isDirectory()){
//              cboImages.addItem(comboFile[ctr].getName());
//          }
        }
            
            // Load random list of images to use
            //int test = 1;
//            for (int c = 0; c < gameDiff; c++) {
//                // Call database for pictures
//                // Query to pick "gamediff" number of images
//                 Card card = new Card();
//                 card.setbackImage(new ImageIcon(cardBackImage));
//                 
//                     //File f1 = new File("/images/defaults/farm/farm001.png");
//                     //String path = f1.getPath();
//                     //FileInputStream fis = new FileInputStream(path);
//                     Image img = null;
////                     if (test == 1) {
////
////                         /*
////                          http://stackoverflow.com/questions/7705059/select-an-object-at-random
////                          for (int i = 0; i < cardsArray.length; i++) {
////    cardsArray[i].setIcon(new ImageIcon("image/card/card/" + String.valueOf(array[i]) + ".png"));
////                         
////                         static final File baseDir = new File("images/");
////                         private Image cardBackImage = new ImageIcon(this.getClass().getResource(baseDir + "/card.png")).getImage();
////}
////                          */
////                         
////                        
////
////                             img = new ImageIcon(this.getClass().getResource("images/default/duck.png")).getImage();
////                             test = 2;
////                     }else if (test == 2) {
////                         //new File("./images/defaults/farm/farm002.png"
////                         img = new ImageIcon(this.getClass().getResource("images/default/dog.png")).getImage();
////                         test = 3;
////                     } else {
////                         //new File("./images/defaults/farm/farm003.png")
////                         img = new ImageIcon(this.getClass().getResource("images/default/HappyDog.png")).getImage();
////
////                         test = 1;
////                     }
//                     //for(int x = 0; x < gameDiff; x++){
//                     
//                     //files.add(new ImageIcon(getClass().getResource(Scan.next())));
//                     
//                     //baseDir = mmlgame.images/(list of directories)
//                     
//                     
//                     
//                     
////                     String selectedDir = this.baseDir.toString();
////                     new ImageIcon(getClass().getResource(selectedDir + img + ".png")); 
////                     
////                     img = new ImageIcon(this.getClass().getResource(selectedDir + "/" + img + ".png")).getImage();
//                     
//                        img = new ImageIcon(this.getClass().getResource(baseDir + "/default/HappyDog.png")).getImage();
//                      
//                     
//                        Image dimg = img.getScaledInstance(144, 216, Image.SCALE_SMOOTH);
//                        card.setfrontImage(new ImageIcon(dimg));
//                
//                        // Populate card with db results
//                        cardsList.add(card);
//                    //}
//            }
            

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
        
        shuffle(cardsList);
        
        createGameScreen(cardsList);
     }     
   
private void flipCardEvent(MouseEvent e) {

    JPanel pnlClicked = (JPanel)e.getSource();
    Card cardToCheck = cardsMap.get(pnlClicked);
    
    JLabel icon = (JLabel) pnlClicked.getComponent(0);
    
    if(cardToCheck.isMatched()){
        return;
    }
    
    cardToCheck.setShowing(!cardToCheck.isShowing());
    
    if (firstCardClicked == null) {
     
        firstCardClicked = pnlClicked;
    } else {
        // A card is already showing on the screen
        if (firstCardClicked == pnlClicked) {
            // Clicked same card
            firstCardClicked = null;
        } else {
            Card previousCard = cardsMap.get(firstCardClicked);
            
            if (previousCard.getfrontImage() == cardToCheck.getfrontImage()) {
                
                cardToCheck.setMatched(true);
                previousCard.setMatched(true);
                
                allMatch++;//increment each card match, NOT each card!

                firstCardClicked = null;
            } else {
                // Clicked a non-match
                icon.setIcon(cardToCheck.getfrontImage());
                
                JLabel previousIcon = (JLabel) firstCardClicked.getComponent(0);
                previousCard.setShowing(false);
                cardToCheck.setShowing(false);
                
                TimerAction ta = new TimerAction( previousCard, cardToCheck, icon, previousIcon);
                Timer t = new Timer(1000, ta);
                t.setRepeats(false);
                t.start();               
                
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
} 
