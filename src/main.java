import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");

        System.out.println("Student List: " + students);
        System.out.println("First Student: " + students.get(0));

        students.set(1, "David");
        students.remove("Charlie");

        System.out.println("Updated List:");
        for (String name : students) {
            System.out.println(name);
        }

        System.out.println("Total Students: " + students.size());
    }
}
