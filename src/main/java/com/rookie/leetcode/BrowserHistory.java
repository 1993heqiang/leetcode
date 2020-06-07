package com.rookie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
    private List<String> history;
    private int curIndex;

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("leetcode.com");
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");
        System.out.println(browser.back(1));
        System.out.println(browser.back(1));
        System.out.println(browser.forward(1));
        browser.visit("linkedin.com");
        System.out.println(browser.forward(2));
        System.out.println(browser.back(2));
        System.out.println(browser.forward(7));

    }

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curIndex = 0;
    }

    public void visit(String url) {
        int removeElementCount = history.size() - (curIndex + 1);
        while (removeElementCount > 0) {
            history.remove(curIndex + 1);
            removeElementCount--;
        }
        history.add(url);
        curIndex = history.size() - 1;
    }

    public String back(int steps) {
        if (curIndex == 0) {
            return null;
        }
        curIndex = Math.max(curIndex - steps, 0);
        return history.get(curIndex);
    }

    public String forward(int steps) {
        if (curIndex == history.size() - 1) {
            return null;
        }
        curIndex = Math.min(curIndex + steps, history.size() - 1);
        return history.get(curIndex);
    }
}
