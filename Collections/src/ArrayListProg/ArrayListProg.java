package ArrayListProg;

import java.util.*;
public class ArrayListProg {
    public static void main(String args[]) {
     
      ArrayList<String> obj = new ArrayList<String>();

      
      obj.add("Chaitanya");
      obj.add("Prateek");
      obj.add("Abhijeet");
      obj.add("Aneesh");
      obj.add("Sagar");

      // Displaying elements
      System.out.println("Original ArrayList:");
      for(String str:obj)
         System.out.println(str);

      
      obj.add(0, "Siddharth");
      obj.add(1, "Padmesh");

      // Displaying elements
      System.out.println("ArrayList after add operation ::");
      for(String str:obj)
         System.out.println(str);

      //Remove elements from ArrayList like this
      obj.remove("Siddharth"); 
      obj.remove("Padmesh"); 

      // Displaying elements
      System.out.println("ArrayList after remove operation ::");
      for(String str:obj)
         System.out.println(str);

      //Remove element from the specified index
      obj.remove(1); 

      // Displaying elements
      System.out.println("Final ArrayList :: ");
      for(String str:obj)
         System.out.println(str);
      
      // Displaying elements in sorted fromat
      Collections.sort(obj);
      System.out.println("Sorted ArrayList :: ");
      for (String str : obj) {
         System.out.println(str);
   }
}
}