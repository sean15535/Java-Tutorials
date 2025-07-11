public class ArrayExample {
    public static void main(String[] args) {
        int[] scores = new int[5];
        scores[0] = 85;
        scores[1] = 90;
        scores[2] = 78;
        scores[3] = 92;
        scores[4] = 88;

        System.out.println("Student Scores:");
        for (int score : scores) {
            System.out.println(score);
        }
    }
}
