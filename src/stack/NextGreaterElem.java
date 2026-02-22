package stack;

import java.util.*;
class NextGreaterElem{

    /**
     * Finds the next greater element for each value in nums1 based on their
     * position in nums2.
     *
     * Approach: 1. Use a monotonic decreasing stack on nums2 to find next
     * greater elements. 2. Store results in a HashMap. 3. Build answer for
     * nums1 using map lookup.
     *
     * Time Complexity: O(n + m) Space Complexity: O(n)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>(); // stores element -> next greater
        Stack<Integer> stack = new Stack<>();        // monotonic decreasing stack

        // preprocess nums2 to compute next greater elements
        for (int num : nums2) {                      // iterate through nums2

            // while current number is greater than stack top
            // it becomes next greater for stack elements
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);           // assign next greater and remove from stack
            }

            stack.push(num);                         // push current number to stack (waiting for its NGE)
        }

        // remaining elements in stack have no next greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);                // assign -1 for those elements
        }

        int[] ans = new int[nums1.length];           // result array for nums1

        // build final answer using hashmap lookup
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);              // fetch precomputed next greater
        }

        return ans;                                  // return final result
    }
}
