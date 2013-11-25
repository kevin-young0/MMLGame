/*
 * This class will intantiate each card, giving the properties that
 * every card should have. In the "printCells()" method of the MemoryGame.java
 * class, each card will be referenced as an "aCard" object of datatype "Card".
 * Providing this datatype is the main purpose of this class.
 */

package mmlgame;

import javax.swing.ImageIcon;

/**
 * http://www.youtube.com/watch?v=H_2m1qdzfvg
 * @author speterson86
 */
public class Card {
    boolean showing;//indicates if the card is flipped
    boolean matched;//if two cards are matched, don't allow them to be flipped 
    //back over until game reset
    static ImageIcon backImage;//back of the card (replace with the card.png image later)
    static ImageIcon frontImage;//front of the card (replace with images later)
    
    /*construtor*/
    public Card(ImageIcon theBack, ImageIcon theFront){
        showing = false;
        backImage = theBack;
        frontImage = theFront;
    }
    /*empty construtor (to create a fresh, unpopulated card object)*/
    public Card(){
        showing = false;
        backImage = null;
        frontImage = null;
    }
    
   public void setbackImage(ImageIcon theBack)
   {
      backImage = theBack;
      //ImageIcon backImage = new ImageIcon("E:\\Capstone\\MMLGame\\MMLGame\\src\\mmlgame\\images\\card.png");
   }    
   public ImageIcon getbackImage()
   {
      return backImage;
   }
    
   public void setfrontImage(ImageIcon frontImage)
   {
      this.frontImage = frontImage;
   }    
   public ImageIcon getfrontImage()
   {
      return frontImage;
   }
    
//    public void setShowingStatus(){//whether or not the card has been flipped yet.
//        if(showing){
//            showing = false;//when the card is still face down and has not been
//            //clicked on (flipped) yet.
//        }            
//        else{
//            showing = true;//show the hidden word on the facing-down-front-side
//            //of the card when the player clicks on the card (flips it).
//        }
//    }


}//end of Card.java class
