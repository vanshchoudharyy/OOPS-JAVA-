public class Main1 {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.set("hello");

        Box<Integer> box2 = new Box<>();
        box2.set(101);

        System.out.println(box1.get());
        System.out.println(box2.get());

        System.out.println(box1);
        System.out.println(box2);
    }
}