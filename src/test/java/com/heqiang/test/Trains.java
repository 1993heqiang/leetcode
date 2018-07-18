package com.heqiang.test;

import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Trains {

    public int minLength = -1;
    public Stack<String> stack = new Stack<>();
    public int[][] data;
    public List<String> cities;

    public static void main(String[] args) {
        String input;
/*        String path = "file_path";
        input = Trains.file2String(path);
        if("".equals(input)){
            System.out.println("Reading file has a Exception!");
            System.exit(0);
        }*/
        input = " AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        Trains trains = new Trains(input);
        Stack<String> stack = trains.stack;
        System.out.println(trains.distanceOfRoute("A", "B", "C"));
        System.out.println("-------------------------------------------------------------");
        System.out.println(trains.distanceOfRoute("A", "D"));
        System.out.println("-------------------------------------------------------------");
        System.out.println(trains.distanceOfRoute("A", "D", "C"));
        System.out.println("-------------------------------------------------------------");
        System.out.println(trains.distanceOfRoute("A", "E", "B", "C", "D"));
        System.out.println("-------------------------------------------------------------");
        System.out.println(trains.distanceOfRoute("A", "E", "D"));
        System.out.println("-------------------------------------------------------------");
        System.out.println(trains.numberOfRouteMaxStops("C", "C", 3));
        System.out.println("详细路径:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println(trains.numberOfRouteExactlyStops("A", "C", 4));
        System.out.println("详细路径:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("-------------------------------------------------------------");
        String shortest = trains.lengthOfShortestRoute("A", "C");
        if ("-1".equals(shortest)) {
            System.out.println("NO SUCH ROUTE");
        } else {
            System.out.println(shortest);
            System.out.println("详细路径:");
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println(trains.numberOfRoutes("C", "C", 30));
        System.out.println("详细路径:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public Trains(String input) {
        cities = new ArrayList<>();
        data = parseInput(input);
    }

    public int[][] parseInput(String input) {
        //筛选出city
        Set<String> citiesTemp = new HashSet<>();
        char[] letterArr = input.toCharArray();
        for (int i = 0; i < letterArr.length; i++) {
            char letter = letterArr[i];
            if ('A' <= letter && letter <= 'Z') {
                citiesTemp.add(String.valueOf(letterArr[i]));
            }
        }
        //存入cities 集合
        citiesTemp.stream().forEach(e -> cities.add(e));
        int size = cities.size();
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(result[i], -1);
        }
        List<String> points = Arrays.stream(input.split(",")).map(e -> e.trim()).collect(Collectors.toList());
        points.stream().forEach(e -> {
            //标出所有的有关系的点
            String pointA = String.valueOf(e.charAt(0));
            String pointB = String.valueOf(e.charAt(1));
            Integer distance = Integer.valueOf((e.substring(2)));
            result[cities.indexOf(pointA)][cities.indexOf(pointB)] = distance;
        });
        return result;
    }

    public static String file2String(String path){
        File input = new File(path);
        if(!input.exists()||!input.isFile()){
            throw new RuntimeException("File not exist");
        }
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(input);
            int fileLen = (int)input.length();
            char[] chars = new char[fileLen];
            fileReader.read(chars);
            return String.valueOf(chars);
        }catch (Exception e){

        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                }catch (Exception e){

                }
            }
        }
        return "";
    }

    /**
     * A -> B 点,距离小于 maxLength 的所有路径数
     *
     * @param pointA
     * @param pointB
     * @param maxLength
     * @return
     */
    public String numberOfRoutes(String pointA, String pointB, int maxLength) {
        stack.clear();
        int a = cities.indexOf(pointA);
        if(a==-1) return pointA + "is not exist";
        int b = cities.indexOf(pointB);
        if(b==-1) return pointB + "is not exist";
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1 && a != i) {
                if (i == b) {
                    if (line[i] < maxLength) {
                        stack.push(String.valueOf(pointA + "-" + pointB));
                    }
                }
                traverse1(i, b, pointA + "-" + cities.get(i), line[i], maxLength);
            }
        }
        return String.valueOf(stack.size());
    }

    private void traverse1(int a, int b, String route, int curLength, int maxLength) {
        int[] line = data[a];
        int temp;
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1) {
                temp = curLength + line[i];
                if (maxLength <= temp) {
                    continue;
                }
                if (i == b) {
                    if (maxLength > temp) {
                        stack.push(route + "-" + cities.get(i));
                    }
                }
                traverse1(i, b, route + "-" + cities.get(i), temp, maxLength);
            }
        }
    }

    /**
     * 所给路径的距离
     *
     * @param args
     * @return
     */
    public String distanceOfRoute(String... args) {
        int len = args.length;
        if (len < 2) return "NO SUCH ROUTE";
        int[] points = new int[len];
        int index;
        for (int i = 0; i < len; i++) {
            index = cities.indexOf(args[i]);
            if(index==-1){
                return args[i]+" is not exist;";
            }
            points[i] = index;
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

    /**
     * 两点之间最短路径的长度
     *
     * @param pointA
     * @param pointB
     * @return
     */
    public String lengthOfShortestRoute(String pointA, String pointB) {
        minLength = -1;
        stack.clear();
        int a = cities.indexOf(pointA);
        if(a==-1) return pointA + "is not exist";
        int b = cities.indexOf(pointB);
        if(b==-1) return pointB + "is not exist";
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1 && a != i) {
                if (i == b) {
                    minLength = line[i];
                    stack.push(String.valueOf(pointA + "-" + pointB));
                }
                traverse(i, b, pointA + "-" + cities.get(i), line[i]);
            }
        }
        return String.valueOf(minLength);
    }

    private void traverse(int a, int b, String route, int curLength) {
        int[] line = data[a];
        int temp;
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1) {
                temp = curLength + line[i];
                if (minLength != -1 && temp > minLength) {
                    continue;
                }
                if (i == b) {
                    if (minLength == -1) {
                        minLength = temp;
                        stack.push(route + "-" + cities.get(i));
                    } else if (minLength == temp) {
                        stack.push(route + "-" + cities.get(i));
                    } else if (minLength > temp) {
                        minLength = temp;
                        stack.clear();
                        stack.push(route + "-" + cities.get(i));
                    }
                    continue;
                } else if (route.contains(cities.get(i))) {
                    continue;
                }
                traverse(i, b, route + "-" + cities.get(i), temp);
            }
        }
    }

    /**
     * A -> B 步数为特定值的路径数
     *
     * @param pointA
     * @param pointB
     * @param stops
     * @return
     */
    public String numberOfRouteExactlyStops(String pointA, String pointB, int stops) {
        stack.clear();
        int a = cities.indexOf(pointA);
        if(a==-1) return pointA + "is not exist";
        int b = cities.indexOf(pointB);
        if(b==-1) return pointB + "is not exist";
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1 && a != i) {
                if (stops == 1 && i == b) {
                    stack.push(String.valueOf(pointA + "-" + pointB));
                }
                traverse2(i, b, pointA + "-" + cities.get(i), stops - 1);
            }
        }
        return String.valueOf(stack.size());
    }

    private void traverse2(int a, int b, String route, int stops) {
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1) {
                if (stops > 1) {
                    traverse2(i, b, route + "-" + cities.get(i), stops - 1);
                } else {
                    if (i == b) {
                        stack.push(route + "-" + cities.get(i));
                        return;
                    }
                }
            }
        }
    }

    /**
     * A -> B 点步数不大于给定值的路径数
     *
     * @param pointA
     * @param pointB
     * @param maxStops
     * @return
     */
    public String numberOfRouteMaxStops(String pointA, String pointB, int maxStops) {
        stack.clear();
        int ret = 0;
        int a = cities.indexOf(pointA);
        if(a==-1) return pointA + "is not exist";
        int b = cities.indexOf(pointB);
        if(b==-1) return pointB + "is not exist";
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1 && a != i) {
                if (i == b) ret++;
                ret += handleNumberOfRoute(i, b, maxStops - 1, pointA + "-" + cities.get(i));
            }
        }
        return String.valueOf(ret);
    }

    private int handleNumberOfRoute(int a, int b, int maxStops, String route) {
        int ret = 0;
        if (maxStops == 0) return ret;
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1) {
                if (i == b) {
                    ret++;
                    stack.push(route + "-" + cities.get(i));
                }
                ret += handleNumberOfRoute(i, b, maxStops - 1, route + "-" + cities.get(i));
            }
        }
        return ret;
    }


}
