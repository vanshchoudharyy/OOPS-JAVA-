import java.util.*;
class Greaterthan10{
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(5,15,44,2,55);

        list.stream()
                .filter(n -> n >10)
                .forEach(System.out::println);
    }
}