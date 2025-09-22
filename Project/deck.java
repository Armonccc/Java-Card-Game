package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class deck {
    private List<card> cards;

    public deck() {
        cards = new ArrayList<>();
      
        Deck_setup();
        rearrange(); 
       
    }

    // cards are randomly shuffled/swapped in the deck
    public void rearrange() {
        Random rand = new Random();
        for (int x = 0; x < cards.size(); x++) {



            int preshuffler = rand.nextInt(cards.size());

            card card_shuffler = cards.get(preshuffler);



            card present = cards.get(x);

            
            cards.set(preshuffler,present); 
            cards.set(x,card_shuffler); 
        }
    }
    
//Every card has an image path and there are 52 cards in a deck hence this method sets the deck up with 52 cards

    private void Deck_setup() {
        
        String[] type_suit_oneletter = {"C", "S", "D", "H"}; 
        

        for (int x = 0; x < 4; x++) {
            
            String suit_oneletter = type_suit_oneletter[x];
            
            for (int card_values = 1; card_values <= 13; card_values++) {
                
                String rank_oneletter = "";
                
                //Assigning values based on the letter

                if (card_values == 13) {
                   
                    rank_oneletter = "K" ;
                  


                } 
                
                else if (card_values == 12){

                    rank_oneletter = "Q" ;
                    


                }  
                
                else if (card_values == 11){

                    rank_oneletter = "J" ;
                  

                }

                else if (card_values == 1){

                    rank_oneletter = "A" ;
               

                } else {

                    rank_oneletter = String.valueOf(card_values); 
                   
                }

                

                String card_structure = suit_oneletter + "-" + rank_oneletter; 
                String path_for_img = "C:\\Users\\ascch\\Desktop\\Cards\\" + card_structure + ".png"; //Path to the cards and images must only be png
                
                cards.add(new card(rank_oneletter,suit_oneletter, card_values, path_for_img));

            
             }
        }
    }

      



    //Draws the card that is on the top of the deck and makes in present in the game
    public card drawCard()  {
        if (cards.size() > 0) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    
    }

    public int getLeft_Over_Cards() {
        return cards.size();
    }
}
