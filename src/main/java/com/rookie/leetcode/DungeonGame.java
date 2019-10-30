package com.rookie.leetcode;

public class DungeonGame {
    private static int minimumHP;
    public int calculateMinimumHP(int[][] dungeon) {
        minimumHP = Integer.MIN_VALUE;
        int rowNum = dungeon.length;
        int colNum = dungeon[0].length;
        int curHP = dungeon[0][0];
        traverse(dungeon, rowNum - 1, colNum - 1, curHP < 0 ? curHP : 0,curHP);
        return minimumHP>0?0:Math.abs(minimumHP)+1;
    }

    private void traverse(int[][] dungeon, int moveDownNum, int moveRightNum, int curMinimumHP,int curHP) {
        int rowNum = dungeon.length;
        int colNum = dungeon[0].length;
        if (moveRightNum == 0 && moveDownNum == 0) {
            minimumHP = curMinimumHP>minimumHP?curMinimumHP:minimumHP;
            return;
        }
        if (moveRightNum > 0) {
            int tempMoveRightNum = moveRightNum - 1;
            int tempHP = dungeon[rowNum - moveDownNum - 1][colNum - tempMoveRightNum - 1] + curHP;
            int tempCurMinimumHP = tempHP < curMinimumHP ? tempHP : curMinimumHP;
            if(tempCurMinimumHP<0&&tempCurMinimumHP<minimumHP){
                return;
            }
            traverse(dungeon, moveDownNum, tempMoveRightNum,tempCurMinimumHP ,tempHP);
        }
        if (moveDownNum > 0) {
            int tempMoveDownNum = moveDownNum - 1;
            int tempHP = dungeon[rowNum - tempMoveDownNum - 1][colNum - moveRightNum - 1] + curHP;
            int tempCurMinimumHP = tempHP < curMinimumHP ? tempHP : curMinimumHP;
            if(tempCurMinimumHP<0&&tempCurMinimumHP<minimumHP){
                return;
            }
            traverse(dungeon, tempMoveDownNum, moveRightNum, tempCurMinimumHP,tempHP);
        }
    }
    public static void main(String[] args) {
        DungeonGame dungeonGame = new DungeonGame();
        int[][] dungeon = {{0,-3},{-10,0}};
        System.out.println( dungeonGame.calculateMinimumHP(dungeon));
    }
}
