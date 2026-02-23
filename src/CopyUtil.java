import java.util.ArrayList;
import java.util.List;

public class CopyUtil {
    public static <T> void copy(
            List<? super T> destination,
            List<? extends T> source)
     {
    for (T element : source){
        System.out.println(element);
    }
    }
}
