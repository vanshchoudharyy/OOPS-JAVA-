import java.io.*;
import java.util.Scanner;

public class SimpleIOExample{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            // Write to file
            try (FileWriter writer = new FileWriter("data.txt")) {
                writer.write(name);
            }

            System.out.println("Name saved to file!");

            // Read from file
            try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
                String line = br.readLine();
                System.out.println("Reading from file: " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
