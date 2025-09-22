package Project;

public class rules {



    public int computertotalscore;
    public int yourtotalscore;

    public rules (int computertotalscore, int yourtotalscore) {

        this.computertotalscore = computertotalscore;
        this.yourtotalscore = yourtotalscore;
    }

//The below code is showing the different possible outcomes that can occur in the game.

    public static String Score(int computertotalscore, int yourtotalscore){

        int limit = 33;
        if (yourtotalscore > limit && computertotalscore > limit) {

            return "There is no winner";

        } 
        if (limit-computertotalscore > limit-yourtotalscore){
            return "Computer Won";
    
            }
    
        if (limit-yourtotalscore > limit-computertotalscore){
            return "Player Won";
        }
        if (computertotalscore > limit) {
            return "The Computer Lost";
        } 

        if (yourtotalscore > limit) {
            return "You Lost";
        } 



    else {

        return "There is no winner";
    }
   


}

}