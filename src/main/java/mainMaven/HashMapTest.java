package mainMaven;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating a HashMap
        HashMap<String, Integer> hm = new HashMap<>();
 
        // Adding key-value pairs to the HashMap
        hm.put("apple", 10);
        hm.put("banana", 20);
        hm.put("orange", 30);
 
        // Accessing values using keys
        System.out.println("Value associated with key 'apple': " + hm.get("apple"));
        System.out.println("Value associated with key 'banana': " + hm.get("banana"));
 
        // Iterating over the HashMap
        for (String key : hm.keySet()) {
            System.out.println("Key: " + key + ", Value: " + hm.get(key));
        }
}
}