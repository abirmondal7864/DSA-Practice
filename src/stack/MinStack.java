package stack;

import java.util.Stack;

/**
 * MinStack supports push, pop, top, and getMin operations in O(1) time.
 * Uses an auxiliary stack to track minimum elements.
 */
class MinStack {

    private Stack<Integer> stack;     // Main stack storing values
    private Stack<Integer> minStack;  // Stack storing current minimums

    /** Initialize data structure. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Push element onto stack.
     * Also update minStack if new value is <= current minimum.
     */
    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * Remove top element from stack.
     * If removed element equals current minimum, remove from minStack.
     */
    public void pop() {
        int removed = stack.pop();

        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
        }
    }

    /** Return top element without removing it. */
    public int top() {
        return stack.peek();
    }

    /** Retrieve current minimum element in constant time. */
    public int getMin() {
        return minStack.peek();
    }
}