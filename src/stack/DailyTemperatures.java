package stack;

import java.util.Stack;

class DailyTemperatures {

    /**
     * Returns an array where each element represents the number of days until a
     * warmer temperature.
     *
     * Approach: - Use monotonic decreasing stack (stores indices). - When
     * current temperature is greater than stack top, we found the next warmer
     * day.
     *
     * Time Complexity: O(n) Space Complexity: O(n)
     */
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {

            // If current temp is greater than temp at stack top
            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return result;
    }
}