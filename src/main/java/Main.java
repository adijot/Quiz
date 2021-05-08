import json.JsonService;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception{
        try {
            JsonService jsonService = new JsonService("koncowe.json");
            Quiz quiz = new Quiz(jsonService, 6);
            for (int i = 0; i < quiz.getNumberOfQuestions(); i++){
                System.out.println(quiz.getQuestion());
                quiz.displayAnswers();
                quiz.setUserAnswer();
                quiz.checkCorrectAnswer(quiz.getUserAnswer());
                quiz.setRandomQuestion();
                quiz.setQuestion();
                quiz.setAnswers();
            }

            if (quiz.getPoints() == 1){
                System.out.println("Zdobyłeś: " + quiz.getPoints() + " pnkkt.");
            }
            else if (quiz.getPoints() <= 4){
                System.out.println("Zdobyłeś: " + quiz.getPoints() + " punkty.");
            }
            else {
                System.out.println("Zdobyłeś: " + quiz.getPoints() + " punktów.");

            }

        }
        catch (Exception e){
            System.out.println(e);
        }

        }
    }
