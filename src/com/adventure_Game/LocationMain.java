package com.adventure_Game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LocationMain {

    private static Map <String, String> vocabulary = new HashMap<String,String>();
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Map<String, Integer> tempExit = new HashMap<>();

    public static void main(String[] args) {
        tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        tempExit.put("X", 6);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));


        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));


        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest",tempExit));




        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("WEST","W");
        vocabulary.put("EAST","E");
        vocabulary.put("QUIT","Q");

        command();

    }
    public static void command() {
        int val = 1;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            tempExit.remove("W");
            System.out.println(locations.get(val).getDescription());
            if(val == 0)
                break;
            Map<String, Integer> exits = locations.get(val).getExits();
            System.out.println("Available directions: ");
            for(String exit : exits.keySet())
                System.out.print(exit+" ");
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            String[] wordSplit = direction.split(" ");
            if (direction.length() > 1) {
                for (String word : wordSplit) {
                    if (vocabulary.containsKey(word)) {
                        System.out.println("i'm here");
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if(exits.containsKey(direction)) {
                val = exits.get(direction);
            }
            else
                System.out.println("You cannot go in that direction");
        }
    }

}

