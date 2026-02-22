import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<Integer> list = Arrays.asList(10,20,30);
        int max = list.stream()
                .max(Integer::compare)
                .get();
        System.out.println("max no. is :" + max);
    }
}