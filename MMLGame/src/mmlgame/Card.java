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
    private boolean showing;//indicates if the card is flipped
    private boolean matched;//if two cards are matched, don't allow them to be flipped 
    //back over until game reset
    private boolean hover = false;
    private ImageIcon backImage;//back of the card (replace with the card.png image later)
    private ImageIcon frontImage;//front of the card (replace with images later)
    
    private String caption; // Store image caption
    
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
    
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    public String getCaption() {
        return caption;
    }
    
    public void setShowing(boolean showing) {
        this.showing = showing;
    }
    
    public boolean isShowing() {
        return showing;
    }
    
    public void setMatched(boolean matched) {
        this.matched = matched;
    }
    //with getters and setters, booleans are always "is", not get.
    public boolean isMatched() {
        return matched;
    }
    
    public void setHover(boolean hover){
        this.hover = hover;
    }
    
    public boolean isHover(){
        return hover;
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
    
   //Flip the card:
   public void setShowingStatus(){//flip the card
       showing = !showing;
   }


}//end of Card.java class
