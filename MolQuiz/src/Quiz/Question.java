package Quiz;
import bagel.Input;
import bagel.Keys;
import bagel.util.Colour;
import bagel.util.Point;
import bagel.util.Vector2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Question {
    private String question;
    private String answer;
    private String type;
    private boolean answeredCorrectly;
    private ColouredString qString;
    private AnswerSpace answerSpace;

    public Question(int QNum){
        this.answeredCorrectly = false;
        parseQuestion(QNum);
        System.out.println(question);
        System.out.println(answer);
        this.qString = new ColouredString(question, Colour.RED);
        this.answerSpace = new AnswerSpace();
    }

    private void parseQuestion(int QNum) {
        try {
            String[] QLines = getQLines(String.format("res/questions/%d.txt", QNum));
            this.type = QLines[0];
            this.question = QLines[1];
            this.answer = QLines[2];
        } catch (IOException e) {
            System.out.println("ERROR Reading Question");
            System.exit(1);
        }
    }

    private String[] getQLines(String QPath) throws IOException {
        return Files.readAllLines(Paths.get(QPath)).toArray(new String[0]);
    }

    public void update(Input input){
        answerSpace.update(input);
        qString.render(new Vector2(20,20));
        if (input.wasPressed(Keys.ENTER)){
            double percentage = checkAnswer();
            System.out.println(percentage);
            qString.setMessage(String.format("Result: %f%%", percentage * 100));
        }
    }

    private double checkAnswer() {
        String[] answerEntered = answerSpace.getDisplay().replaceAll("\\s+","").split("");
        String[] stdAnswer = answer.replaceAll("\\s+","")
                .substring(2,answer.replaceAll("\\s+","").length()).toLowerCase().split("");
        System.out.println(answer);
        int numcorrect = 0;
        for (int i = 0; i< stdAnswer.length - 1; i ++){
            if (i >= answerEntered.length){
                return ((double) numcorrect)/stdAnswer.length;
            }
            else if (stdAnswer[i].equals(answerEntered[i])){
                    numcorrect ++;
            }
        }
        return ((double) numcorrect)/stdAnswer.length;
    }
}
