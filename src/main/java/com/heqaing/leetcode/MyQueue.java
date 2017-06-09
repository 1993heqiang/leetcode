package com.heqaing.leetcode;

import java.util.Stack;

/**
 * Created by HeQiang on 2017-06-09 13:13.
 */
public class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    private int size;
    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
        size = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(pushStack.empty()){
            while (!popStack.empty()){
                pushStack.push(popStack.pop());
            }
        }
        pushStack.push(x);
        size = pushStack.size();
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop(){
        if(size!=0){
            if(popStack.empty()){
                while (!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
            }
            size = popStack.size()-1;
            return popStack.pop();
        }else{
            throw new RuntimeException("Queue is Empty!");
        }
    }

    /** Get the front element. */
    public int peek() {
        if(size!=0){
            if(popStack.empty()){
                while (!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }else{
            throw new RuntimeException("Queue is Empty!");
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size==0;
    }
}
