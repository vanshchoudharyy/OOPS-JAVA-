import java.io.*;
import java.util.*;

class AddElementsToHashMap {
    public static void main(String args[])
    {
        HashMap<Integer, String> hm1 = new HashMap<>();
        HashMap<Integer, String> hm2
                = new HashMap<Integer, String>();
        hm1.put(1, "vansh");
        hm1.put(2, "is");
        hm1.put(3, "good");

        hm2.put(1, "vansh");
        hm2.put(2, "is");
        hm2.put(3, "good");

        System.out.println("Mappings of HashMap hm1 are : "
                + hm1);
        System.out.println("Mapping of HashMap hm2 are : "
                + hm2);
    }
}