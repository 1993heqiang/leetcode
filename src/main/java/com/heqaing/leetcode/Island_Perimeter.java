package com.heqaing.leetcode;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class Island_Perimeter {
    public static void main(String args[]){
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        long t1 = System.nanoTime();
        int ret = islandPerimeter(grid);
        long t2 = System.nanoTime();
        System.out.println(t2-t1);
        System.out.println(ret);
    }
    public static int islandPerimeter(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int count = 0;
        int sub = 0;
        if(width==1&&height==1){
            if(grid[0][0]==1){
                count++;
            }
        }else if(height==1&&width!=1){
            for(int i=0;i<width-1;i++){
                if(grid[0][i]==1){
                    count++;
                    sub += grid[0][i+1];
                }
            }
            if(grid[0][width-1]==1) count++;
        }else if(height!=1&&width==1){
            for(int i=0;i<height-1;i++){
                if(grid[i][0]==1){
                    count++;
                    sub += grid[i+1][0];
                }
            }
            if(grid[height-1][0]==1) count++;
        }else {
            for(int i=0;i<height-1;i++){
                for(int j=0;j<width-1;j++){
                    if(grid[i][j]==1){
                        count++;
                        sub += grid[i][j+1];
                        sub += grid[i+1][j];
                    }
                }
            }
            for(int i=0;i<width-1;i++){
                if(grid[height-1][i]==1) {
                    count++;
                    sub += grid[height-1][i+1];
                }
            }
            for(int i=0;i<height-1;i++){
                if(grid[i][width-1]==1){
                    count++;
                    sub += grid[i+1][width-1];
                }
            }
            if(grid[height-1][width-1]==1) count++;
        }
        return 4*count-2*sub;
    }

}
