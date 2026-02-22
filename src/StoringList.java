import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StoringList {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(10,20,30);

        List<Integer> result =
        list.stream()
                .map(n -> n + 5)
                .collect(Collectors.toList());


    }
}