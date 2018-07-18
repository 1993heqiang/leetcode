package com.heqiang.test;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author heqiang
 * @date 18-7-17 下午7:45
 * @description
 * @modified by
 */
public class TrainsTest{
    public Trains trains;

    @Before
    public void setUp() {
        String defaultInput = " AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        String path = "";
        String input = file2String(path);
        if("".equals(input)){
            input = defaultInput;
        }
        trains = new Trains(input);
    }
    @Test
    public void test() {
        testDistanceOfRoute();
        testNumberOfRouteMaxStops();
        testNumberOfRouteExactlyStops();
        testLengthOfShortestRoute();
        testNumberOfRoutes();
    }

    public void testDistanceOfRoute() {
        String q1Answer = trains.distanceOfRoute("A", "B", "C");
        System.out.println("Output #1: " + q1Answer);
        String q2Answer = trains.distanceOfRoute("A", "D");
        System.out.println("Output #2: " + q2Answer);
        String q3Answer = trains.distanceOfRoute("A", "D", "C");
        System.out.println("Output #3: " + q3Answer);
        String q4Answer = trains.distanceOfRoute("A", "E", "B", "C", "D");
        System.out.println("Output #4: " + q4Answer);
        String q5Answer = trains.distanceOfRoute("A", "E", "D");
        System.out.println("Output #5: " + q5Answer);
    }

    public void testNumberOfRouteMaxStops() {
        Deque<String> routes = new ArrayDeque<>();
        String q6Answer = trains.numberOfRouteMaxStops("C", "C", 3, routes);
        System.out.println("Output #6: " + q6Answer);
//        printRoutes(routes);
    }

    public void testNumberOfRouteExactlyStops() {
        Deque<String> routes = new ArrayDeque<>();
        String q7Answer = trains.numberOfRouteExactlyStops("A", "C", 4, routes);
        System.out.println("Output #7: " + q7Answer);
//        printRoutes(routes);
    }

    public void testLengthOfShortestRoute() {
        Deque<String> routes = new ArrayDeque<>();
        String shortest = trains.lengthOfShortestRoute("A", "C", routes);
        if ("-1".equals(shortest)) {
            System.out.println("Output #8: " + "NO SUCH ROUTE");
        } else {
            System.out.println("Output #8: " + shortest);
//            printRoutes(routes);
        }
        routes.clear();
        shortest = trains.lengthOfShortestRoute("B", "B", routes);
        if ("-1".equals(shortest)) {
            System.out.println("Output #9: " + "NO SUCH ROUTE");
        } else {
            System.out.println("Output #9: " + shortest);
//            printRoutes(routes);
        }
    }

    public void testNumberOfRoutes() {
        Deque<String> routes = new ArrayDeque<>();
        String numberOfRoute = trains.numberOfRoutes("C", "C", 30, routes);
        System.out.println("Output #10: " + numberOfRoute);
//        printRoutes(routes);
    }

    private void printRoutes(Deque<String> routes) {
        System.out.println("Routes:");
        while (!routes.isEmpty()) {
            System.out.println("    " + routes.pollLast());
        }
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

}
