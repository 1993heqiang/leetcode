package com.rookie.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestAbsoluteFilePath {

    private static final Pattern REGEX_PATTERN = Pattern.compile("\n([\t]*)([^\n\t]+)");

    public static void main(String[] args) {
        LongestAbsoluteFilePath test = new LongestAbsoluteFilePath();
        String input = "dir\n    file.txt";
        System.out.println(input);
        System.out.println(test.lengthLongestPath(input));
    }

/*    *//**
     *  very smart solution
     * @param input
     * @return result
     *//*
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        int[] len = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for(String s:arr){
            int ind = s.lastIndexOf("\t");
            int level = ind+1;
            int parentLen = (level==0)?0:len[level-1]+1;
            int currLen = s.length()-1-ind;
            len[level] = parentLen+currLen;
            if(s.contains(".")){
                max = Integer.max(max,len[level]);
            }
        }
        return (max==Integer.MIN_VALUE)?0:max;
    }*/

    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Matcher matcher = REGEX_PATTERN.matcher(input);
        int curLevel;
        String name;
        Deque<Node> queue = new LinkedList<>();
        while (matcher.find()) {
            curLevel = matcher.group(1).length();
            name = matcher.group(2);
            queue.addLast(new Node(curLevel, matcher.start(), name));
        }
        Node temp = queue.peekFirst();
        if (temp == null) {
            Node first = new Node(0, 0, input);
            queue.addFirst(first);
        } else {
            if (temp.start != 0) {
                Node first = new Node(0, 0, input.substring(0, temp.start));
                queue.addFirst(first);
            }
        }
        Deque<Node> tempList = new LinkedList<>();
        int maxLen = 0;
        while (!queue.isEmpty()) {
            Node curNode = queue.pollFirst();
            while (!tempList.isEmpty()) {
                Node lastNode = tempList.peekLast();
                if (lastNode.level < curNode.level) {
                    break;
                } else {
                    tempList.pollLast();
                }
            }
            if (curNode.isFile) {
                int len = tempList.stream().mapToInt(node -> node.name.length()).sum() + curNode.name.length() + curNode.level;
                maxLen = Math.max(len, maxLen);
            } else {
                tempList.addLast(curNode);
            }
        }
        return maxLen;
    }


    private static class Node {
        private int level;
        private int start;
        private String name;
        private boolean isFile;

        Node(int level, int start, String name) {
            this.level = level;
            this.start = start;
            this.name = name;
            this.isFile = isFile(name);
        }

        private boolean isFile(String name) {
            return name.matches(".+\\.[^.]+");
        }
    }
}
