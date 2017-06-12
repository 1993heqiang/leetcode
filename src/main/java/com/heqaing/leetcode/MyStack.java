package com.heqaing.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by HeQiang on 2017-06-09 16:28.
 */
public class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int size;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(size!=0){
            if(q1.size()==0){
                q1.offer(x);
                while (q2.size()!=0){
                    q1.offer(q2.poll());
                }
            }else {
                q2.offer(x);
                while (q1.size()!=0){
                    q2.offer(q1.poll());
                }
            }
        }else {
            q1.offer(x);
        }
        size ++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(size!=0){
            size --;
            if(q1.size()!=0){
                return q1.poll();
            }else {
                return q2.poll();
            }
        }else {
            throw new RuntimeException("Stack is Empty");
        }
    }

    /** Get the top element. */
    public int top() {
        if(size!=0){
            if(q1.size()!=0){
                return q1.peek();
            }else {
                return q1.peek();
            }
        }else {
            throw new RuntimeException("Stack is Empty");
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size==0;
    }
}
