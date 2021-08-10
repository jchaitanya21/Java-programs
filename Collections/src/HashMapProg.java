
import java.util.*;

public class HashMapProg {

    public static void main(String args[]) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Chaitanya");
        map.put(2, "Abhijeet");
        map.put(3, "Prateek");
        map.put(4, "Aneesh");

        System.out.println("Iterating Hashmap:");
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        map.put(1, "Sagar"); //trying to insert duplicate key

        System.out.println("Iterating Hashmap after trying duplication of key:");
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        //key-based removal  
        map.remove(1);
        System.out.println("Updated list of elements after key based removal: " + map);
        //key-value pair based removal  
        map.remove(2, "Abhijeet");
        System.out.println("Updated list of elements key-value pair based removal: " + map);

        //replace
        map.replace(4, "Siddharth");
        System.out.println("Iterating Hashmap after replacing value of key 4:");
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        //replacing one value with another value
        map.replace(3,"Prateek","Padmesh");
        System.out.println("Iterating Hashmap after replacing value of key 3 and its old value with new value:");
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        
        map.replaceAll((k,v)->"Chaitanya");
        System.out.println("Iterating Hashmap after replacing value of all keys with same value:");
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
