import bagel.AbstractGame;
import bagel.Input;
import Quiz.*;
import java.io.IOException;

public class Quiz extends AbstractGame{
    private int currQNum;
    private Question currQuestion;
    /**
     * The main function call for the quiz, create's a new instance of the quiz
     * and runs it
     * @param args: The Command line arguments passed into the function when ran
     * @throws IOException: Exception thrown if there is an error in game Input/Output
     */
    public static void main(String[] args) throws IOException{
        new Quiz().run();
    }

    /**
     * Creates a new instance of Quiz
     */
    public Quiz(){
        // Start the game at level 1
        this.currQNum = 1;
        this.currQuestion = new Question(currQNum);
    }

    /**
     * Updates the game state
     * @param input: Input from the player's keyboard/mouse
     */
    protected void update(Input input){
        currQuestion.update(input);
    }
}
