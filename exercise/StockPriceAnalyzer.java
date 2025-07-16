import java.util.ArrayList;
import java.util.Arrays;

/**
 * StockPriceAnalyzer.java
 * 
 * This program analyzes stock prices over a 10-day period using both
 * arrays and ArrayLists. It includes functionalities such as:
 * - Calculating the average stock price
 * - Finding the maximum stock price
 * - Counting the occurrence of a specific stock price
 * - Computing the cumulative sum of stock prices

 */

public class StockPriceAnalyzer {

    /**
     * Calculates the average stock price from a float array.
     *
     * @param prices An array of float stock prices.
     * @return The average stock price as a float.
     */
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price; // Add each price to the sum
        }
        return sum / prices.length; // Calculate average
    }

    /**
     * Finds the maximum stock price in the array.
     *
     * @param prices An array of float stock prices.
     * @return The maximum stock price as a float.
     */
    public static float findMaximumPrice(float[] prices) {
        float max = prices[0]; // Initialize max with the first element
        for (float price : prices) {
            if (price > max) {
                max = price; // Update max if current price is greater
            }
        }
        return max;
    }

    /**
     * Counts how many times a specific stock price appears in the array.
     *
     * @param prices An array of float stock prices.
     * @param targetPrice The price to count occurrences of.
     * @return The number of times targetPrice occurs in the array.
     */
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;
        for (float price : prices) {
            if (price == targetPrice) {
                count++; // Increment count for every match
            }
        }
        return count;
    }

    /**
     * Computes the cumulative sum of stock prices using an ArrayList.
     *
     * @param prices An ArrayList of float stock prices.
     * @return A new ArrayList containing the cumulative sums.
     */
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : prices) {
            sum += price; // Add current price to running total
            cumulativeSum.add(sum); // Store the cumulative sum
        }
        return cumulativeSum;
    }

    /**
     * The main method to demonstrate and test the functionalities.
     *
     * @param args Command-line arguments (not used here).
     */
    public static void main(String[] args) {
        // Sample stock prices for 10 days stored in both array and ArrayList
        float[] stockPricesArray = {100.5f, 102.3f, 101.2f, 99.8f, 103.4f, 105.1f, 104.6f, 100.0f, 99.8f, 102.3f};
        ArrayList<Float> stockPricesList = new ArrayList<>(Arrays.asList(
            100.5f, 102.3f, 101.2f, 99.8f, 103.4f, 105.1f, 104.6f, 100.0f, 99.8f, 102.3f));

        // Calculate and display the average stock price
        float average = calculateAveragePrice(stockPricesArray);
        System.out.println("Average Stock Price: " + average);

        // Find and display the maximum stock price
        float max = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum Stock Price: " + max);

        // Count and display occurrences of a specific stock price
        float target = 102.3f;
        int count = countOccurrences(stockPricesArray, target);
        System.out.println("Occurrences of " + target + ": " + count);

        // Compute and display cumulative sum of stock prices
        ArrayList<Float> cumulative = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulative);
    }
}
