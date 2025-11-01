package array.slidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class FruitsInABasket {
    public static int totalFruit(int[] fruits) {
        // This map tracks the count of each fruit type in the current window (baskets)
        Map<Integer, Integer> baskets = new HashMap<>();

        int left = 0; // The left pointer of the sliding window
        int maxFruits = 0; // The result: maximum number of fruits collected

        // The right pointer expands the window to the right
        for (int right = 0; right < fruits.length; right++) {
            // 1. Expand the window: Add the fruit at the 'right' pointer to the baskets (map)
            int currentFruit = fruits[right];
            baskets.put(currentFruit, baskets.getOrDefault(currentFruit, 0) + 1);

            // 2. Shrink the window: If we have more than 2 distinct fruit types,
            // we must shrink the window from the left until the constraint is met.
            while (baskets.size() > 2) {
                int fruitToRemove = fruits[left];

                // Decrement the count of the fruit at the 'left' pointer
                baskets.put(fruitToRemove, baskets.get(fruitToRemove) - 1);

                // If the count of the fruit becomes 0, remove the fruit type from the map (basket)
                if (baskets.get(fruitToRemove) == 0) {
                    baskets.remove(fruitToRemove);
                }

                // Move the left pointer to the right to shrink the window
                left++;
            }

            // 3. Calculate and update the maximum length:
            // The current valid window length is (right - left + 1)
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        // Expected result for {3,3,3,1,2,1,1,2,3,3,4} is 5 (from [1,2,1,1,2])
        System.out.println(totalFruit(fruits));
    }
}