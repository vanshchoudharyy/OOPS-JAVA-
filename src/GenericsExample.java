import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericsExample {
    public static void main(String[] args){
        List<Integer> intlist = new ArrayList<>();
        intlist.add(100);
        intlist.add(200);
        intlist.add(300);
        List<? extends Number> numListExtends = intlist;

        System.out.println("reading ? extends number:");
        for (Number n : numListExtends) {
            System.out.println(n);
        }
        List<Number> numberList = new ArrayList<>();
        List<? super Integer> numListSuper = numberList;

        numListSuper.add(100);
        numListSuper.add(200);
        System.out.println("reading using ? super integer");
        for (Object obj : numberList){
            System.out.println(obj);
        }
    }
}