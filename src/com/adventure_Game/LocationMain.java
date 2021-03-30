package com.adventure_Game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LocationMain {
    /*i'll be creating a file to let input data to the locations class*/
    //private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Locations locations = new Locations();
    private static Map <String, String> vocabulary = new HashMap<String,String>();
    //private static Map<String, Integer> tempExit = new HashMap<>();

    public static void main(String[] args) {
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
            /*test to see if class is immutable
            tempExit.remove("W");
             */
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

