package com.adventure_Game;

import java.io.*;
import java.util.*;

public class NewLocations implements Map<Integer,Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        try (DataOutputStream data = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("location.dat")))) {
            for (Location location : locations.values()) {
                data.writeInt(location.getLocationID());
                data.writeUTF(location.getDescription());
                data.writeInt(location.getExits().size() - 1);
                System.out.println(location.getLocationID() + " " + location.getDescription() + " - " + (location.getExits().size() - 1));
                for (String exit : location.getExits().keySet()) {
                    if (!exit.equalsIgnoreCase("Q")) {
                        data.writeUTF(exit);
                        data.writeInt(location.getExits().get(exit));
                        System.out.println(location.getLocationID() + " has " + exit + " : " + location.getExits().get(exit));
                    }
                }
            }
        }
    }
    static {
        //binary reading
        try (DataInputStream data = new DataInputStream(new BufferedInputStream(new FileInputStream("location.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Map<String, Integer> exists = new LinkedHashMap<>();
                    int locID = data.readInt();
                    String description = data.readUTF();
                    int numExits = data.readInt();
                    System.out.println(locID + " " + description + " " + numExits);
                    for (int i = 0; i < numExits; i++) {
                        String direction = data.readUTF();
                        int destinations = data.readInt();
                        exists.put(direction, destinations);
                    }
                    locations.put(locID, new Location(locID, description, exists));
                } catch (EOFException e) {
                    eof = true;
                    System.out.println("eof exception");
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("ioe exception");
        }
    }
    @Override
    public int size () {
        return locations.size();
    }

    @Override
    public boolean isEmpty () {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey (Object key){
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue (Object value){
        return locations.containsValue(value);
    }

    @Override
    public Location get (Object key){
        return locations.get(key);
    }

    @Override
    public Location put (Integer key, Location value){
        return locations.put(key, value);
    }

    @Override
    public Location remove (Object key){
        return locations.remove(key);
    }

    @Override
    public void putAll (Map < ? extends Integer, ? extends Location > m){

    }

    @Override
    public void clear () {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet () {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values () {
        return locations.values();
    }
    @Override
    public Set<Map.Entry<Integer, Location>> entrySet () {
        return locations.entrySet();
    }

}

