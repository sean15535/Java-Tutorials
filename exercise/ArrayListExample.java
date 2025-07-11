import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(85);
        scores.add(90);
        scores.add(78);
        scores.add(92);
        scores.add(88);
        scores.add(95); // dynamically added

        System.out.println("Student Scores:");
        for (int score : scores) {
            System.out.println(score);
        }
    }
}
