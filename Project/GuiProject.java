package Project;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class GuiProject extends JFrame {

   
    private JPanel contentPane;
    private int rounds = 0;
    private deck game_of_deck;
    private game player_1;
    private game player_2;
    

    private JLabel lbl_player1_score;
    private JLabel lbl_player2_score;
    private JLabel[] card_labels_player1 = new JLabel[5];
    private JLabel[] card_labels_player2 = new JLabel[5];
   

    public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					GuiProject frame = new GuiProject();

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

    public GuiProject() {
        player_1 = new game();
        player_2 = new game();
        game_of_deck = new deck();
       

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton Skip_button = new JButton("Skip");
                Skip_button.setForeground(Color.RED);
        Skip_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                  if (rounds < 5) {
                    
                    Random random = new Random();
                    boolean cardchoice = random.nextBoolean();
                    
                    player_1.drawCard(new card("skipped", "skip", 0, "C:\\Users\\ascch\\Desktop\\backofcard.png"));
                    
                      if (cardchoice){ 
                //If the cardchoice is true this block will run, hence the else statement will run instead.
                   card computerCard = game_of_deck.drawCard(); 
                   player_2.drawCard(computerCard);
                   card_labels_player2[rounds].setIcon(new ImageIcon(new ImageIcon(computerCard.getImg_path()).getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH)));

                }
            else {
                //If false, the back of the card will just be shown.
                player_2.drawCard(new card("skipped", "skip", 0, "C:\\Users\\ascch\\Desktop\\backofcard.png"));
                }
                    
                    
            
                    rounds++;

                    Label_total_scoreLabels();

                    if (rounds == 5) {

                        Skip();
                    } else {

                        GameOver();

                    }
                } 

            }
        });
        Skip_button.setBounds(319, 645, 223, 74);
        contentPane.add(Skip_button);


        

        JButton reveal_card_button = new JButton("Reveal Card");
        reveal_card_button.setForeground(Color.RED);
        reveal_card_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (rounds < 5) {

                    Random random = new Random();
                    boolean cardchoice = random.nextBoolean(); //True or false, we are essentially randomly getting a true or false value at random. Which will decide if the card is shown or not, hence the need for this piece of code.

                    card playerCard = game_of_deck.drawCard(); //Drawing cards for both player and computer
                  
                    player_1.drawCard(playerCard); //adds the card to the players hand

                    card_labels_player1[rounds].setIcon(new ImageIcon(new ImageIcon(playerCard.getImg_path()).getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH)));
                


            if (cardchoice){ 
                //If the cardchoice is true this block will run, hence the else statement will run instead.
                   card computerCard = game_of_deck.drawCard(); 
                   player_2.drawCard(computerCard);
                   card_labels_player2[rounds].setIcon(new ImageIcon(new ImageIcon(computerCard.getImg_path()).getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH)));

                }
            else {
                //If false, the back of the card will just be shown.
                player_2.drawCard(new card("skipped", "skip", 0, "C:\\Users\\ascch\\Desktop\\backofcard.png"));
                }



                rounds++;


                
                Label_total_scoreLabels();

                GameOver();

               
                
                if (rounds == 5) {
                    String whoever_wins = rules.Score(player_1.getTotalPoints(), player_2.getTotalPoints());
                    int repatgame = JOptionPane.showConfirmDialog(null, whoever_wins + "\nWould you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION);

                    if (repatgame == JOptionPane.YES_OPTION) {
                        new_game();
                    } else {
                        System.exit(0);
                    }
                }
            }
        }});
        reveal_card_button.setBounds(584, 645, 223, 74);
        contentPane.add(reveal_card_button);

   
        

        lbl_player1_score = new JLabel("Your Score: 0");
        lbl_player1_score.setBounds(111, 559, 200, 16);
        contentPane.add(lbl_player1_score);

        lbl_player2_score = new JLabel("Computer's Score: 0");
        lbl_player2_score.setBounds(111, 267, 200, 16);
        contentPane.add(lbl_player2_score);

        ImageIcon backCardIcon = new ImageIcon("C:\\Users\\ascch\\Desktop\\backofcard.png");
        Image scaledBack = backCardIcon.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
        ImageIcon backCard = new ImageIcon(scaledBack);

        for (int i = 0; i < 5; i++) {
            card_labels_player1[i] = new JLabel();
            card_labels_player1[i].setIcon(backCard);
            card_labels_player1[i].setBounds(111 + i * 227, 282, 100, 140);
            contentPane.add(card_labels_player1[i]);

            card_labels_player2[i] = new JLabel();
            card_labels_player2[i].setIcon(backCard);
            card_labels_player2[i].setBounds(111 + i * 227, 17, 100, 140);
            contentPane.add(card_labels_player2[i]);
        }
    }

    private void Label_total_scoreLabels() {
        lbl_player1_score.setText("Your Score: " + player_1.getTotalPoints());
        lbl_player2_score.setText("Computer's Score: " + player_2.getTotalPoints());
    }

    private void new_game() {
        game_of_deck = new deck();
        rounds = 0;
        player_1 = new game();
        
        player_2 = new game();
        

        ImageIcon backCardIcon = new ImageIcon("C:\\Users\\ascch\\Desktop\\backofcard.png");
        Image scaledBack = backCardIcon.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
        ImageIcon backCard = new ImageIcon(scaledBack);

        for (int i = 0; i < 5; i++) {
            card_labels_player1[i].setIcon(backCard);
            card_labels_player2[i].setIcon(backCard);
        }

        Label_total_scoreLabels();
    
    }

    private void GameOver() {

        // This method is used for when someone goes over 33 hence the game stops

        int playerScore = player_1.getTotalPoints();
        int computerScore = player_2.getTotalPoints();
    
        if (playerScore > 33 || computerScore > 33) {
            String whoever_wins = rules.Score(playerScore, computerScore);
            int repatgame = JOptionPane.showConfirmDialog(null, whoever_wins + "\nWould you like to play again?", "The Game is Finished!", JOptionPane.YES_NO_OPTION);
    
            if (repatgame == JOptionPane.YES_OPTION) {
                new_game();
            } else {
                System.exit(0);
            }
        }
    }

    private void Skip() {

//This method is used for when the match reaches 5 rounds then the match will stop 

        int playerscore = player_1.getTotalPoints();
        int computerscore = player_2.getTotalPoints();

    String whoever_wins = rules.Score(playerscore, computerscore);
    int repatgame = JOptionPane.showConfirmDialog(null, whoever_wins + "\nWould you like to play again?", "The Game is Finished!", JOptionPane.YES_NO_OPTION);

   
    if (repatgame == JOptionPane.YES_OPTION) {
        new_game();
    } else {
        System.exit(0);
    }
} 

    

}
