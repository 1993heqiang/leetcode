package com.heqiang.test;

import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Trains {

    public int[][] data;
    public List<String> cities;


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

    /**
     * A -> B 点,距离小于 maxLength 的所有路径数
     *
     * @param pointA
     * @param pointB
     * @param maxLength
     * @return
     */
    public String numberOfRoutes(String pointA, String pointB, int maxLength, Deque<String> deque) {
        int a = cities.indexOf(pointA);
        if(a==-1) return pointA + "is not exist";
        int b = cities.indexOf(pointB);
        if(b==-1) return pointB + "is not exist";
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1 && a != i) {
                if (i == b) {
                    if (line[i] < maxLength) {
                        deque.push(String.valueOf(pointA + "-" + pointB));
                    }
                }
                traverse1(i, b, pointA + "-" + cities.get(i), line[i], maxLength, deque);
            }
        }
        return String.valueOf(deque.size());
    }

    private void traverse1(int a, int b, String route, int curLength, int maxLength, Deque<String> deque) {
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
                        deque.push(route + "-" + cities.get(i));
                    }
                }
                traverse1(i, b, route + "-" + cities.get(i), temp, maxLength, deque);
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
    public String lengthOfShortestRoute(String pointA, String pointB, Deque<String> deque) {
        int a = cities.indexOf(pointA);
        if(a==-1) return pointA + "is not exist";
        int b = cities.indexOf(pointB);
        if(b==-1) return pointB + "is not exist";
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1 && a != i) {
                if (i == b) {
                    deque.push(String.valueOf(pointA + "-" + pointB));
                }
                traverse(i, b, pointA + "-" + cities.get(i), line[i], deque);
            }
        }
        if(!deque.isEmpty()){
            String shortestRoute = deque.peekFirst();
            String[] cities = shortestRoute.split("-");
            return distanceOfRoute(cities);
        }
        return "-1";
    }

    private void traverse(int a, int b, String route, int curLength, Deque<String> deque) {
        int[] line = data[a];
        int temp;
        int minLength;
        if(!deque.isEmpty()){
            String shortestRoute = deque.peekFirst();
            String[] cities = shortestRoute.split("-");
            minLength =  Integer.valueOf(distanceOfRoute(cities));
        }else {
            minLength = -1;
        }
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1) {
                temp = curLength + line[i];
                if (minLength > 0  && temp > minLength) {
                    continue;
                }
                if (i == b) {
                    if (minLength == -1) {
                        deque.push(route + "-" + cities.get(i));
                    } else if (minLength == temp) {
                        deque.push(route + "-" + cities.get(i));
                    } else if (minLength > temp) {
                        deque.clear();
                        deque.push(route + "-" + cities.get(i));
                    }
                    continue;
                } else if (route.contains(cities.get(i))) {
                    continue;
                }
                traverse(i, b, route + "-" + cities.get(i), temp, deque);
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
    public String numberOfRouteExactlyStops(String pointA, String pointB, int stops, Deque<String> deque) {
        int a = cities.indexOf(pointA);
        if(a==-1) return pointA + "is not exist";
        int b = cities.indexOf(pointB);
        if(b==-1) return pointB + "is not exist";
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1 && a != i) {
                if (stops == 1 && i == b) {
                    deque.push(String.valueOf(pointA + "-" + pointB));
                }
                traverse2(i, b, pointA + "-" + cities.get(i), stops - 1, deque);
            }
        }
        return String.valueOf(deque.size());
    }

    private void traverse2(int a, int b, String route, int stops, Deque<String> deque) {
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1) {
                if (stops > 1) {
                    traverse2(i, b, route + "-" + cities.get(i), stops - 1, deque);
                } else {
                    if (i == b) {
                        deque.push(route + "-" + cities.get(i));
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
    public String numberOfRouteMaxStops(String pointA, String pointB, int maxStops, Deque<String> container) {
        int ret = 0;
        int a = cities.indexOf(pointA);
        if(a==-1) return pointA + "is not exist";
        int b = cities.indexOf(pointB);
        if(b==-1) return pointB + "is not exist";
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1 && a != i) {
                if (i == b) ret++;
                ret += handleNumberOfRoute(i, b, maxStops - 1, pointA + "-" + cities.get(i), container);
            }
        }
        return String.valueOf(ret);
    }

    private int handleNumberOfRoute(int a, int b, int maxStops, String route, Deque<String> container) {
        int ret = 0;
        if (maxStops == 0) return ret;
        int[] line = data[a];
        for (int i = 0; i < line.length; i++) {
            if (line[i] != -1) {
                if (i == b) {
                    ret++;
                    container.push(route + "-" + cities.get(i));
                }
                ret += handleNumberOfRoute(i, b, maxStops - 1, route + "-" + cities.get(i), container);
            }
        }
        return ret;
    }


}
