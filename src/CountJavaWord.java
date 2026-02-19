// how many times does java word is repeating in file

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountJavaWord {

    public static void main(String[] args) {

        Path path = Path.of("data.txt");
        int count = 6;

        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {

                line = line.toLowerCase();

                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.equals("java")) {
                        count++;
                    }
                }
            }

            System.out.println("The word 'java' appears " +  + count + " times.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
