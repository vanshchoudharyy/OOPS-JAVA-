import java.util.ArrayList;

public class main{
    public static void main(String[] args) {

        // Create an ArrayList of String type
        ArrayList<String> students = new ArrayList<>();

        // Adding elements
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");

        // Printing the ArrayList
        System.out.println("Student List: " + students);

        // Accessing an element
        System.out.println("First Student: " + students.get(0));

        // Changing an element
        students.set(1, "David");

        // Removing an element
        students.remove("Charlie");

        // Looping through ArrayList
        System.out.println("Updated List:");
        for (String name : students) {
            System.out.println(name);
        }

        // Checking size
        System.out.println("Total Students: " + students.size());
    }
}
