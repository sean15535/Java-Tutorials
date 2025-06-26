import java.util.Scanner;

public class QuizGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array of questions
        String[] questions = {
            "1. What is the capital of France?\nA. Berlin\nB. Madrid\nC. Paris\nD. Rome",
            "2. What is the largest planet in our Solar System?\nA. Earth\nB. Mars\nC. Jupiter\nD. Saturn",
            "3. Who wrote 'Romeo and Juliet'?\nA. Charles Dickens\nB. William Shakespeare\nC. Mark Twain\nD. Jane Austen",
            "4. What is the chemical symbol for water?\nA. H2O\nB. CO2\nC. NaCl\nD. O2",
            "5. How many continents are there on Earth?\nA. 5\nB. 6\nC. 7\nD. 8"
        };

        // Array of correct answers
        char[] correctAnswers = {'C', 'C', 'B', 'A', 'C'};

        int score = 0;

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Enter your answer (A, B, C, or D): ");
            String input = scanner.nextLine().toUpperCase(); // Convert input to uppercase
            char answer = input.length() > 0 ? input.charAt(0) : ' ';

            // Input validation
            if (answer != 'A' && answer != 'B' && answer != 'C' && answer != 'D') {
                System.out.println("Invalid input. Please enter A, B, C, or D only.");
                i--; // Repeat the same question
                continue;
            }

            // Use switch-case for processing answer
            switch (answer) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                    if (answer == correctAnswers[i]) {
                        System.out.println("Correct!\n");
                        score++;
                    } else {
                        System.out.println("Wrong! The correct answer was " + correctAnswers[i] + ".\n");
                    }
                    break;
            }
        }

        // Calculate and display final score
        double percentage = ((double) score / questions.length) * 100;
        System.out.println("Quiz Completed!");
        System.out.println("You answered " + score + " out of " + questions.length + " questions correctly.");
        System.out.printf("Your final score: %.2f%%\n", percentage);

        scanner.close();
    }
}
