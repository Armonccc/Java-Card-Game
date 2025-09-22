package Project;

import java.util.ArrayList;

public class game {
    
    private int points_amount;
    private ArrayList<card> deal;

    public game() {
        points_amount = 0;
        deal = new ArrayList<card>();
      
    }

    public void drawCard(card card) {
        deal.add(card); //Think of it as the card is being added to the players hand (Arraylist)
        points_amount += card.getVal();

    }

    public int getTotalPoints() {
        return points_amount;
        
    }
   
    public ArrayList<card> getDeal() {
        return deal;

    }
}
