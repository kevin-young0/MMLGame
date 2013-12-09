/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mmlgame.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import mmlgame.Card;

/**
 *
 * @author Kevin
 */
public class TimerAction implements ActionListener{
     private Card previousCard;
     private Card cardToCheck;
     private JLabel icon;
     private JLabel previousIcon;
     
    public TimerAction(Card previousCard, Card cardToCheck, JLabel icon, JLabel previousIcon){
      
        this.previousCard = previousCard;
        this.cardToCheck = cardToCheck;
        this.icon = icon;
        this.previousIcon = previousIcon;
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Flip cards back down by settting 'showing' to false
//        previousCard.setShowing(false);
//        cardToCheck.setShowing(false);


        // Reset pervious card to back image
        
       
        
        if (cardToCheck.isShowing()) {
          icon.setIcon(cardToCheck.getfrontImage());
        } else {
          icon.setIcon(cardToCheck.getbackImage());
        }
        
        if (previousCard.isShowing()) {
          previousIcon.setIcon(previousCard.getfrontImage());
        } else {
          previousIcon.setIcon(previousCard.getbackImage());
        }
        
        
    }
    
    
}
