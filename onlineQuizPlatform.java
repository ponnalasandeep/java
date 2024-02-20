import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private ArrayList<String> options;
    private int correctOption;

    public Question(String questionText, ArrayList<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            question.displayQuestion();
            System.out.println("Enter your choice (1-" + question.getOptions().size() + "): ");
            int userChoice = scanner.nextInt();
            if (question.isCorrect(userChoice)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " +
                        question.getOptions().get(question.getCorrectOption() - 1) + "\n");
            }
        }
        System.out.println("Quiz completed. Your score: " + score + "/" + questions.size());
    }
}

class OnlineQuizPlatform {
    public static void main(String[] args) {
        // Create questions
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new ArrayList<>(List.of("Berlin",
                "Paris", "Madrid", "Rome")), 2));
        questions.add(new Question("Which planet is known as the Red Planet?", new
                ArrayList<>(List.of("Mars", "Jupiter", "Venus", "Saturn")), 1));
        questions.add(new Question("What is the largest mammal in the world?", new
                ArrayList<>(List.of("Elephant", "Blue Whale", "Giraffe", "Hippopotamus")), 2));
        // Create a quiz
        Quiz quiz = new Quiz(questions);
        // Start the quiz
        quiz.startQuiz();
    }
}
