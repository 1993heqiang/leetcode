import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Trains {
    public static void main(String[] args) {
        String input = " AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        int[][] graph = parseInput(input);
        System.out.println(distanceOfRoute(graph, "A", "B", "C"));
        System.out.println(distanceOfRoute(graph, "A", "D"));
        System.out.println(distanceOfRoute(graph, "A", "D", "C"));
        System.out.println(distanceOfRoute(graph, "A", "E", "B", "C", "D"));
        System.out.println(distanceOfRoute(graph, "A", "E", "D"));
        System.out.println(numberOfRoute("C","C",3,graph));
        System.out.println(numberOfRoute1("A","C",4,graph));
        System.out.println(lengthOfShortestRoute("A","C",graph));
        System.out.println(Arrays.deepToString(graph));
    }

    public static int[][] parseInput(String input) {
        int[][] result = new int[5][5];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(result[i], -1);
        }
        result[0][1] = 5;
        result[1][2] = 4;
        result[2][3] = 8;
        result[3][2] = 8;
        result[3][4] = 6;
        result[0][3] = 5;
        result[2][4] = 2;
        result[4][1] = 3;
        result[0][4] = 7;
        return result;
    }

    public static String distanceOfRoute(int[][] data, String... args) {
        int len = args.length;
        int[] points = new int[len];
        for (int i = 0; i < len; i++) {
            points[i] = args[i].charAt(0) - 'A';
        }
        int totalDistance = 0;
        for (int i = 1; i < len; i++) {
            int p2p = data[points[i - 1]][points[i]];
            if (p2p != -1) {
                totalDistance += p2p;
            } else {
                return "NO SUCH ROUTE";
            }
        }
        return String.valueOf(totalDistance);
    }

    public static int lengthOfShortestRoute(String pointA,String pointB,int[][] data){

        return 1;
    }

    public static int numberOfRoute1(String pointA, String pointB, int stops, int[][] data){
        int ret = 0;
        int a = pointA.charAt(0) - 'A';
        int b = pointB.charAt(0) - 'A';
        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        while (stops-->0){
            Stack<Integer> newStack = new Stack<>();
            while (!stack.empty()){
                int lineNum = stack.pop();
                for(int i=0;i<data[lineNum].length;i++){
                    if(data[lineNum][i]!=-1){
                        newStack.push(i);
                    }
                }
            }
            stack = newStack;
        }
        ret = (int)stack.stream().filter(e->e==b).count();
        return ret;
    }


    public static int numberOfRoute(String pointA, String pointB, int maxStops, int[][] data) {
        int ret = 0;
        int a = pointA.charAt(0) - 'A';
        int b = pointB.charAt(0) - 'A';
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1 && a != i) {
                if(i==b) ret++;
                ret +=handleNumberOfRoute(i, b, maxStops - 1, data);
            }
        }
        return ret;
    }

    public static int handleNumberOfRoute(int a, int b, int maxStops, int[][] data) {
        int ret = 0;
        if (maxStops == 0) return ret;
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1) {
                if(i==b) ret++;
                ret +=handleNumberOfRoute(i, b, maxStops - 1, data);
            }
        }
        return 1;
    }


}
