package com.adventure_Game;

import java.io.*;
import java.util.*;

/* class for input files*/
public class Locations implements Map<Integer,Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream data = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("location.dat")))) {
            for (Location location : locations.values())
                data.writeObject(location);
        }
    }
        static {
            try(ObjectInputStream data = new ObjectInputStream(new BufferedInputStream(new FileInputStream("location.dat")))) {
                boolean eof = false;
                while (!eof) {
                    try {
                        Location location = (Location) data.readObject();
                        System.out.println(location.getLocationID() + " " + location.getDescription());
                        System.out.println(location.getExits().size());

                        locations.put(location.getLocationID(), location);

                    } catch (EOFException e) { //end of file exception apply b/c there is no condition to end the while loop
                        eof = true;
                    }
                }
            }catch (InvalidClassException in){
                System.out.println("invalid class exception "+in.getMessage() );
            }catch (IOException io ){
                System.out.println("io exception "+io.getMessage());
            }catch(ClassNotFoundException e){//for data.readObject  in case not file found class Location
                System.out.println("class not found exception "+e.getMessage() );
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
    public Set<Entry<Integer, Location>> entrySet () {
        return locations.entrySet();
    }

}


