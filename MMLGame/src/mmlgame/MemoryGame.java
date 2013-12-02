/*
 * Remember, at the start of each game, the cards are all face-down, meaning 
 * that the back of the card is always facing up at first. So try very hard not
 * to confuse the back of the cards from the front of the cards!
 */
//package mmlgame;
//
//import java.util.Random;
//import java.util.Scanner;//enable keyboard input
//
///**
// * NOTE: later on, we should create a dynamic matrix for both of the
// * difficulties. The following link may help us with that:
// * http://introcs.cs.princeton.edu/java/95linear/Matrix.java.html
// * 
// * @author speterson86
// */
//public class MemoryGame {
//    
//    private Card [][] board;//two dimensional array matrix to hold card objects
//    private String[] words = {"Blue", "Blue", "Red", "Red", "Green", "Green",
//                              "Yellow", "Yellow"};
//    /*private String[] words = {"Red", "Red", "Blue", "Blue", "Magenta", "Magenta",
//                              "Orange", "Orange", "White", "White", "Dark_Gray",
//                              "Dark_Gray"}*/
//    private Random r;//declare field for a random object
//    private Scanner reader;//declare field for scanner object
//    
//    /*constructor*/
//    MemoryGame(){
//        r = new Random();//initialize the random object field
//        reader = new Scanner(System.in);//initialize the scanner object field
//        board = new Card [4][4];//build a 4x4 matrix array for holding card objects
//        /*board = new Card [2][6];//2 rows by 6 columns matrix that can hold card
//        objects. In other words, we're building the array here that will hold
//        the card objects for the Beginner Difficulty.*/
//        shuffle();//randomly swap each card's hidden words (the words on it's 
//        //front side that the player never sees at the start of each game)
//        setCells();//after shuffling completes, randomly select each cell as a
//        //new position for each card from the newly shuffled list of card objects.
//        printCells();//repopulate each cell with it's randomly chosen new card object 
//        playGame();
//    }
//    
//    public void playGame(){
//        choosePairOfCards();
//        /*
//        We will still need to add more to this method.
//        */
//    }
//    
//    public void choosePairOfCards(){
//        int cardChoice, row1, col1, row2, col2;
//        System.out.println();
//        System.out.println("Enter the number on the card.");
//        System.out.print("First Card Choice? >");
//        //you can use div and mod to obtain the row and column:
//        cardChoice = getInputAsInt();//cardChoice uses a call to the 
//        //"getInputAsInt()" method.
//        row1 = cardChoice / 4;
//        col1 = cardChoice % 4;
//        board[row1][col1].setShowingStatus();
//        
//        System.out.print("Second Card Choice? >");
//        cardChoice = getInputAsInt();
//        row2 = cardChoice / 4;
//        col2 = cardChoice % 4;
//        board[row2][col2].setShowingStatus();
//        
//        System.out.print('\u000C');//clears the screen (the terminal window)
//        
//        printCells();//More work to do here. We need to check to see if the 
//        //cards match. If they don't, call each card's setShowingStatus to 
//        //flip them.
//    }
//    
//    public void setCells(){
//        int a = 0;//initialize to 0 so that the for loop can have a fresh start
//        //at incrementing each cell that it randomly selects for placing a card
//        //from the newly shuffled list of card objects.
//        
//        for(int row = 0; row < board.length; row++){
//            
//            for(int col = 0; col < board[0].length; col++){              
//            
//            /*
//             * "board[row][col]" is a single cell in the two dimensional array;
//             * "words[a]" parameter is the word on the front (face) of each card;
//             * "a" parameter is the integer on the back of each card;
//             */
//            {    
//                board[row][col] = new Card(words[a], a);
//                a++;//increment a, so that the loop will increment each new card
//                //object (by incrementing each card's integer number on the back
//                //of it) before it proceeds to pull the next card from the newly
//                //shuffled list of card objects.               
//            }
//        }//end of col for loop
//    }//end of row for loop    
//}//end of setCells()
//    
//    //To print the cells is more like saying "repopulate each cell with a card
//    //from the shuffled list of card objects" by showing the card in its new 
//    //randomly selected position (cell):
//    public void printCells(){
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
//        }//end of col for loop
//    }//end of row for loop
//}//end of printCells()
//    
//    public void shuffle(){
//        for(int a = 0; a < words.length; a++){//loop through the array of words
//            //(that is, the "Colors" from the String Array field)
//            int pos = r.nextInt(words.length);//randomly choose a new position
//            //for the words on the front of each card. Just to clarify, we 
//            //always see the back of the card (the side with the integer number)
//            //at the start of each game, so technically, randomly rearranging
//            //the words hidden on the already-facing-down-front-side of the 
//            //cards is the exact same thing as rearranging the cards themselves.
//            
//            //Swap the words from their for loop position to 
//            //their new random position:             
//            String temp = words[a];//what is "temp"?
//            words[a] = words[pos];
//            words [pos] = temp;
//        }//end of a for loop
//    }//end of shuffle()
//    
//    public int getInputAsInt(){
//        String temp = reader.nextLine();
//        return Integer.parseInt(temp);//Example: Integer.parseInt("34") returns
//        //the "34" seperately from the rest of the string, and treats it as an
//        //integer, (even though it was once part of a string).
//    }
//    
//    public String getInputAsString(){
//        return reader.nextLine();
//    }
//    
//    
//    
//}//end of MemoryGame.java class

//BACKUP OF HARD-CODED MMLGame Cards:
//      Insets cardPadding = new Insets(3,3,3,3);
//      
//      //Beginner Card 1 (row 1, column 1):
//      JPanel pnlBeginnerCard1 = new JPanel();
//      JLabel lblBeginnerCard1 = new JLabel();        
//      lblBeginnerCard1.setPreferredSize(new Dimension(144,216));
//      lblBeginnerCard1.setMaximumSize(new Dimension(144,216));
//      pnlBeginnerCard1.add(lblBeginnerCard1);
//      pnlBeginnerCard1.setBackground(Color.RED);
//      //JFileChooser fc = new JFileChooser();
//      //File file = new File("../images/card.png");
//      ImageIcon imageView = new ImageIcon("E:\\Capstone\\MMLGame\\MMLGame\\src\\mmlgame\\images\\card.png");
//      lblBeginnerCard1.setIcon(imageView);      
//      GridBagConstraints gbc = new GridBagConstraints();
//      gbc.gridy = 0;//row 1
//      gbc.gridx = 0;//column 1           
//      gbc.fill = GridBagConstraints.BOTH;//BOTH instead of VERTICAL accomodates
//      //for the combobox if it needs to stretch when we start populating it.
//      gbc.weightx = .1;
//      gbc.weighty = .1;
//      gbc.insets = cardPadding;
//      pnlGameScreen.add(pnlBeginnerCard1, gbc);
//      
//      //Beginner Card 2 (row 1, column 2):
//      JPanel pnlBeginnerCard2 = new JPanel();
//      JLabel lblBeginnerCard2 = new JLabel();
//      lblBeginnerCard2.setPreferredSize(new Dimension(144,216));
//      lblBeginnerCard2.setMaximumSize(new Dimension(144,216));
//      pnlBeginnerCard2.add(lblBeginnerCard2);
//      pnlBeginnerCard2.setBackground(Color.BLUE);      
//      imageView = new ImageIcon("E:\\Capstone\\MMLGame\\MMLGame\\src\\mmlgame\\images\\card.png");
//      lblBeginnerCard2.setIcon(imageView);      
//      gbc = new GridBagConstraints();
//      gbc.gridy = 0;//row 1
//      gbc.gridx = 1;//column 2           
//      gbc.fill = GridBagConstraints.BOTH;
//      gbc.weightx = .1;
//      gbc.weighty = .1;
//      gbc.insets = cardPadding;
//      pnlGameScreen.add(pnlBeginnerCard2, gbc);
//      
//      //Beginner Card 3 (row 1, column 3):
//      JPanel pnlBeginnerCard3 = new JPanel();
//      JLabel lblBeginnerCard3 = new JLabel();
//      lblBeginnerCard3.setPreferredSize(new Dimension(144,216));
//      lblBeginnerCard3.setMaximumSize(new Dimension(144,216));
//      pnlBeginnerCard3.add(lblBeginnerCard3);
//      pnlBeginnerCard3.setBackground(Color.MAGENTA);      
//      imageView = new ImageIcon("E:\\Capstone\\MMLGame\\MMLGame\\src\\mmlgame\\images\\card.png");
//      lblBeginnerCard3.setIcon(imageView);      
//      gbc = new GridBagConstraints();
//      gbc.gridy = 0;//row 1
//      gbc.gridx = 2;//column 3           
//      gbc.fill = GridBagConstraints.BOTH;
//      gbc.weightx = .1;
//      gbc.weighty = .1;
//      gbc.insets = cardPadding;
//      pnlGameScreen.add(pnlBeginnerCard3, gbc);
//      
//      //Beginner Card 4 (row 2, column 1):
//      JPanel pnlBeginnerCard4 = new JPanel();
//      JLabel lblBeginnerCard4 = new JLabel();
//      lblBeginnerCard4.setPreferredSize(new Dimension(144,216));
//      lblBeginnerCard4.setMaximumSize(new Dimension(144,216));
//      pnlBeginnerCard4.add(lblBeginnerCard4);
//      pnlBeginnerCard4.setBackground(Color.ORANGE);      
//      imageView = new ImageIcon("E:\\Capstone\\MMLGame\\MMLGame\\src\\mmlgame\\images\\card.png");
//      lblBeginnerCard4.setIcon(imageView);      
//      gbc = new GridBagConstraints();
//      gbc.gridy = 1;//row 2
//      gbc.gridx = 0;//column 1           
//      gbc.fill = GridBagConstraints.BOTH;
//      gbc.weightx = .1;
//      gbc.weighty = .1;
//      gbc.insets = cardPadding;
//      pnlGameScreen.add(pnlBeginnerCard4, gbc);
//      
//      //Beginner Card 5 (row 2, column 2):
//      JPanel pnlBeginnerCard5 = new JPanel();
//      JLabel lblBeginnerCard5 = new JLabel();
//      lblBeginnerCard5.setPreferredSize(new Dimension(144,216));
//      lblBeginnerCard5.setMaximumSize(new Dimension(144,216));
//      pnlBeginnerCard5.add(lblBeginnerCard5);
//      pnlBeginnerCard5.setBackground(Color.WHITE);      
//      imageView = new ImageIcon("E:\\Capstone\\MMLGame\\MMLGame\\src\\mmlgame\\images\\card.png");
//      lblBeginnerCard5.setIcon(imageView);      
//      gbc = new GridBagConstraints();
//      gbc.gridy = 1;//row 2
//      gbc.gridx = 1;//column 2           
//      gbc.fill = GridBagConstraints.BOTH;
//      gbc.weightx = .1;
//      gbc.weighty = .1;
//      gbc.insets = cardPadding;
//      pnlGameScreen.add(pnlBeginnerCard5, gbc);
//      
//      //Beginner Card 6 (row 2, column 3):
//      JPanel pnlBeginnerCard6 = new JPanel();
//      JLabel lblBeginnerCard6 = new JLabel();
//      lblBeginnerCard6.setPreferredSize(new Dimension(144,216));
//      lblBeginnerCard6.setMaximumSize(new Dimension(144,216));
//      pnlBeginnerCard6.add(lblBeginnerCard6);
//      pnlBeginnerCard6.setBackground(Color.YELLOW);      
//      imageView = new ImageIcon("E:\\Capstone\\MMLGame\\MMLGame\\src\\mmlgame\\images\\card.png");
//      lblBeginnerCard6.setIcon(imageView);      
//      gbc = new GridBagConstraints();
//      gbc.gridy = 1;//row 2
//      gbc.gridx = 2;//column 3           
//      gbc.fill = GridBagConstraints.BOTH;
//      gbc.weightx = .1;
//      gbc.weighty = .1;
//      gbc.insets = cardPadding;
//      pnlGameScreen.add(pnlBeginnerCard6, gbc);
