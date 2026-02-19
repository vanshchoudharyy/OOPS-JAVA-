import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class GenerateLogFile {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("application log");

        Files.write(path, Arrays.asList(
                "INFO Application started",
                "INFO User logged in",
                "WARN Disk space low",
                "ERROR Database connection failed",
                "INFO Task completed",
                "ERROR Null pointer exception"
        ));

        System.out.println("application log created.");
    }
}
