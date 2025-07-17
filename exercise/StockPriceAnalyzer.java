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
     * Calculates the average stock price from an array.
     */
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    /**
     * Calculates the average stock price from an ArrayList.
     */
    public static float calculateAveragePrice(ArrayList<Float> prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.size();
    }

    /**
     * Finds the maximum stock price in an array.
     */
    public static float findMaximumPrice(float[] prices) {
        float max = prices[0];
        for (float price : prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    /**
     * Finds the maximum stock price in an ArrayList.
     */
    public static float findMaximumPrice(ArrayList<Float> prices) {
        float max = prices.get(0);
        for (float price : prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    /**
     * Counts how many times a specific stock price appears in the array.
     */
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;
        for (float price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    /**
     * Computes the cumulative sum of stock prices from an ArrayList.
     */
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : prices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    /**
     * Main method to run and test all functionalities.
     */
    public static void main(String[] args) {
        float[] stockPricesArray = {100.5f, 102.3f, 101.2f, 99.8f, 103.4f, 105.1f, 104.6f, 100.0f, 99.8f, 102.3f};
        ArrayList<Float> stockPricesList = new ArrayList<>(Arrays.asList(
            100.5f, 102.3f, 101.2f, 99.8f, 103.4f, 105.1f, 104.6f, 100.0f, 99.8f, 102.3f));

        // Average prices
        float avgArray = calculateAveragePrice(stockPricesArray);
        float avgList = calculateAveragePrice(stockPricesList);
        System.out.println("Average Stock Price (Array): " + avgArray);
        System.out.println("Average Stock Price (ArrayList): " + avgList);

        // Maximum prices
        float maxArray = findMaximumPrice(stockPricesArray);
        float maxList = findMaximumPrice(stockPricesList);
        System.out.println("Maximum Stock Price (Array): " + maxArray);
        System.out.println("Maximum Stock Price (ArrayList): " + maxList);

        // Occurrence count
        float target = 102.3f;
        int occurrences = countOccurrences(stockPricesArray, target);
        System.out.println("Occurrences of " + target + ": " + occurrences);

        // Cumulative sum
        ArrayList<Float> cumulative = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulative);
    }
}
