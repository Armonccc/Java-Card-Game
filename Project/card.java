
package Project;


public class card {

    private int val; // value of the card
    private String suit; //suit of the card
    public String img_path; // file image path for each card
    public String rank; // The cards rank 



  public card(String suit, String rank, int val, String img_path) {
      this.suit = suit;
      this.rank = rank;
      this.val = val;
      this.img_path = img_path;
  }


  public void setVal(int val) {

    this.val = val;
  }


  
  public void setImg_path(String img_path) {

    this.img_path = img_path;
  }



  
  public void setSuit(String suit) {

    this.suit = suit;
  }


  
  public void setRank(String rank) {

    this.rank = rank;
  }

  public int getVal() {
      return val;
  }

  public String getImg_path() {
      return img_path;
  }


  public String getSuit() {
    return suit;
}

public String getRank() {
    return rank;
}
  
  

  public String toString() {
      return rank + " of " + suit; //Format is return in a plain-english format
  }
}



















