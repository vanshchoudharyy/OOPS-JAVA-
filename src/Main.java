import java.util.*;
public class Main {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4);
        try{
            Thread.sleep(5000);
        }catch (Exception e) {}
        list.stream()
                .map(n -> n*2)
                .forEach(System.out::println);
    }
}