import java.util.*;

public class TextAnalysisTool {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) User Input
        System.out.println("Enter a paragraph or lengthy text:");
        String text = sc.nextLine();

        // 2) Character Count (total length of the string)
        int charCount = text.length();

        // 3) Word Count (assume words are separated by spaces)
        // We trim to avoid counting empty leading/trailing segments
        // and split on one-or-more spaces to be robust to extra spaces.
        String[] words = text.trim().isEmpty() ? new String[0] : text.trim().split("\\s+");
        int wordCount = words.length;

        // 4) Most Common Character (as written, including spaces and punctuation)
        char mostCommonChar = findMostCommonChar(text);

        // Display basic analysis first
        System.out.println("\n--- Basic Analysis ---");
        System.out.println("Total characters: " + charCount);
        System.out.println("Total words: " + wordCount);
        System.out.println("Most common character: '" + printable(mostCommonChar) + "'");

        // 5) Character Frequency (case-insensitive)
        System.out.print("\nEnter a character to check its frequency (case-insensitive): ");
        String charInput = sc.nextLine();
        char targetChar = charInput.isEmpty() ? '\0' : charInput.charAt(0);
        int charFreq = countCharFrequencyCaseInsensitive(text, targetChar);
        System.out.println("Frequency of '" + printable(targetChar) + "' (case-insensitive): " + charFreq);

        // 6) Word Frequency (case-insensitive)
        System.out.print("\nEnter a word to check its frequency (case-insensitive): ");
        String targetWord = sc.nextLine();
        int wordFreq = countWordFrequencyCaseInsensitive(words, targetWord);
        System.out.println("Frequency of \"" + targetWord + "\" (case-insensitive): " + wordFreq);

        // 7) Unique Words (case-insensitive)
        int uniqueWordCount = countUniqueWordsCaseInsensitive(words);
        System.out.println("\nNumber of unique words (case-insensitive): " + uniqueWordCount);

        sc.close();
    }

    /**
     * Finds the most common character in the given text.
     * If there’s a tie, returns any one of the tied characters.
     * This counts exactly what’s in the string (including spaces and punctuation).
     */
    private static char findMostCommonChar(String text) {
        if (text.isEmpty()) return '\0';

        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        char bestChar = '\0';
        int bestCount = -1;

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            char ch = e.getKey();
            int count = e.getValue();
            if (count > bestCount) {
                bestCount = count;
                bestChar = ch;
            }
        }
        return bestChar;
    }

    /**
     * Counts the frequency of a character in text, case-insensitive.
     */
    private static int countCharFrequencyCaseInsensitive(String text, char target) {
        if (text.isEmpty()) return 0;
        char t = Character.toLowerCase(target);
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (Character.toLowerCase(ch) == t) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts the frequency of a word in the array, case-insensitive.
     * Assumes words are already split by spaces (per assignment).
     */
    private static int countWordFrequencyCaseInsensitive(String[] words, String targetWord) {
        if (targetWord == null || targetWord.isEmpty() || words.length == 0) return 0;

        String t = targetWord.toLowerCase();
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(t)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts unique words (case-insensitive).
     */
    private static int countUniqueWordsCaseInsensitive(String[] words) {
        Set<String> unique = new HashSet<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                unique.add(w.toLowerCase());
            }
        }
        return unique.size();
    }

    /**
     * Nicely formats control or whitespace characters for printing in quotes.
     */
    private static String printable(char ch) {
        if (ch == '\0') return "\\0";
        if (Character.isWhitespace(ch)) {
            switch (ch) {
                case ' ': return "space";
                case '\n': return "\\n";
                case '\t': return "\\t";
                case '\r': return "\\r";
                default: return String.format("whitespace(U+%04X)", (int) ch);
            }
        }
        if (Character.isISOControl(ch)) {
            return String.format("control(U+%04X)", (int) ch);
        }
        return String.valueOf(ch);
    }
}