package Stacks;

//        Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        Implement the MinStack class:
//
//        MinStack() initializes the stack object.
//        void push(int val) pushes the element val onto the stack.
//        void pop() removes the element on the top of the stack.
//        int top() gets the top element of the stack.
//        int getMin() retrieves the minimum element in the stack.
//        You must implement a solution with O(1) time complexity for each function.
//
//
//
//        Example 1:
//
//        Input
//        ["MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]
//
//        Output
//        [null,null,null,null,-3,null,0,-2]
//
//        Explanation
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin(); // return -3
//        minStack.pop();
//        minStack.top();    // return 0
//        minStack.getMin(); // return -2
//
//
//        Constraints:
//
//        -231 <= val <= 231 - 1
//        Methods pop, top and getMin operations will always be called on non-empty stacks.
//        At most 3 * 104 calls will be made to push, pop, top, and getMin.

import java.util.*;
public class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            this.stack.push(val);

            if (this.minStack.isEmpty() || val <= this.minStack.peek()) {
                this.minStack.push(val);
            }
        }

        public void pop() {
            int popped = this.stack.pop();

            if (popped == this.minStack.peek()) {
                this.minStack.pop();
            }
        }

        public int top() {
            return this.stack.peek();
        }

        public int getMin() {
            return this.minStack.peek();
        }


        // First Solution
        // private int min;
        // private int topIndex;
        // private List<Integer> stack;

        // public MinStack() {
        //     this.min = Integer.MAX_VALUE;
        //     this.topIndex = -1;
        //     this.stack = new ArrayList<>();
        // }

        // public void push(int val) {
        //     this.stack.add(val);
        //     this.topIndex++;

        //     if (val < this.min) {
        //         this.min = val;
        //     }
        // }

        // public void pop() {
        //     boolean needNewMin = false;

        //     if (this.min == this.stack.get(this.topIndex)) {
        //         needNewMin = true;
        //     }

        //     this.stack.remove(this.topIndex);
        //     this.topIndex--;

        //     if (needNewMin) {
        //         setNewMin();
        //     }
        // }

        // public int top() {
        //     return this.stack.get(this.topIndex);
        // }

        // public int getMin() {
        //     return this.min;
        // }

        // private void setNewMin() {
        //     this.min = Integer.MAX_VALUE;

        //     for (int num : this.stack) {
        //         if (num < this.min) {
        //             this.min = num;
        //         }
        //     }
        // }
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
