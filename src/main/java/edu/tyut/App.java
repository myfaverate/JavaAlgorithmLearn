package edu.tyut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        // ["MinStack","push","push","push","getMin","pop","top","getMin"]
        // [[],[-2],[0],[-3],[],[],[],[]]

        // ["MinStack","push","push","push","getMin","pop","getMin"]
        // [[],[0],[1],[0],[],[],[]]
        minStack.push(0);
        minStack.push(1);
        minStack.push(2);
        minStack.push(1);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println("最小值：" + minStack.getMin()); // -3 0 -2

        var list = new ArrayList<String>();

    }
}

class MinStack {
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (min >= val) { // 等号也有问题
            stack.push(min); // 这的问题
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if (min == val) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

class MinStack1 {//push方法可能会加入很多min
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        //如果加入的值小于最小值，要更新最小值
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        //如果把最小值出栈了，就更新最小值
        if (stack.pop() == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
