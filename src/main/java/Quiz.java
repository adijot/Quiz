import json.JsonService;
import java.util.*;

public class Quiz {
    private JsonService jsonService;
    private String userAnswer;
    private String correctAnswer;
    private String question;
    private ArrayList<String> answers = new ArrayList<String>();
    private int randomQuestion;
    private int amountOfpoints;
    private int numberOfQuestions;

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public Quiz(JsonService jsonService, int numberOfQuestions){
        this.jsonService = jsonService;
        this.numberOfQuestions = numberOfQuestions;
        setRandomQuestion();
        amountOfpoints = 0;
        setQuestion();
        setAnswers();
        setCorrectAnswer();
    }
    public Quiz(JsonService jsonService){
        this.jsonService = jsonService;
        setRandomQuestion();
        numberOfQuestions = 30;
        amountOfpoints = 0;
        setQuestion();
        setAnswers();
        setCorrectAnswer();
    }

    public Integer getRandomQuestion(){
        return randomQuestion;
    }
    public void setRandomQuestion(){
        randomQuestion = new Random().nextInt(getSize() - 1);
    }

    public String getUserAnswer() {
        return userAnswer;
    }
    public void setUserAnswer(){
        System.out.print("Wybierz prawidłową odpowiedź 1, 2 lub 3: ");
        Scanner scanner = new Scanner(System.in);
        int answer = Integer.valueOf(scanner.nextLine()) - 1;
        userAnswer = answers.get(answer);
    }

    public void checkCorrectAnswer(String userAnswer){
        if (userAnswer.equals(correctAnswer)){
            System.out.println("Prawidłowa odpowiedź, otrzymujesz 1 punkt.");
            setPoints();
            System.out.println("Ilość punktów : " + getPoints());

        }
        else
            System.out.println("ZLA odpowiedz, prawidłowa :" + getCorrectAnswer());
    }

    public void setPoints (){
        amountOfpoints++;
    }
    public Integer getPoints (){
        return amountOfpoints;
    }

    public int getSize(){
        return jsonService.getJsonNode().size();
    }

    public void setQuestion(){
        question = jsonService.getJsonNode().get(String.valueOf(randomQuestion)).get("question").asText();
    }

    public String getQuestion(){
        return question;
    }

    public void setCorrectAnswer(){
        correctAnswer = jsonService.getJsonNode().get(String.valueOf(randomQuestion)).get("correctAnswer").asText();
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }
    public void setAnswers(){
        answers = new ArrayList<String>();
        int sizeOfAnswer = jsonService.getJsonNode().get(String.valueOf(randomQuestion)).get("answers").size();
        for (int i = 0; i < sizeOfAnswer; i++){
            answers.add(jsonService.getJsonNode().get(String.valueOf(randomQuestion)).get("answers").get(i).asText());
        }
        Collections.shuffle(answers);
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Wybierz prawidłową odpowiedź 1,2 lub 3: ");
        // userAnswer = jsonService.getJsonNode().get(String.valueOf(randomQuestion)).get("answers").get(scanner.nextInt() - 1).asText();
    }

    public ArrayList<String> getAnswers(){
        return answers;
    }

    public void displayAnswers(){
        Collections.shuffle(answers);
        for (int i = 0; i < answers.size(); i++){
            int number = i + 1;
            System.out.println("\t" + number  + ". " + answers.get(i));
        }
    }

    public void displayQuiz(){
        for (int i = 0; i < numberOfQuestions; i++){
            setRandomQuestion();
            getQuestion();
            displayAnswers();
            setUserAnswer();
            checkCorrectAnswer(getUserAnswer());
        }
    }

}