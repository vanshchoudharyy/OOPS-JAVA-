import java.util.ArrayList;
import java.util.List;

class main2{
    public static void main(String[] args){
        List<Integer> integers = List.of(1, 2, 3);
        List<Number> numbers = new ArrayList<>();

        CopyUtil.copy(numbers,integers);
        System.out.println(integers);
    }
}