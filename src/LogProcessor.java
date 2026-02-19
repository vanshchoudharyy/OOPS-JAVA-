import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogProcessor {

    public static void main(String[] args) throws IOException {

        Path logPath = Paths.get("application.log");
        Path errorPath = Paths.get("error.log");
        Path summaryPath = Paths.get("summary.txt");

        int infoCount = 0;
        int warnCount = 0;
        int errorCount = 0;

        // Read all lines
        List<String> lines = Files.readAllLines(logPath);

        // Count log levels
        for (String line : lines) {
            if (line.contains("INFO")) {
                infoCount++;
            } else if (line.contains("WARN")) {
                warnCount++;
            } else if (line.contains("ERROR")) {
                errorCount++;
            }
        }

        // Extract ERROR lines
        List<String> errorLines = lines.stream()
                .filter(line -> line.contains("ERROR"))
                .collect(Collectors.toList());

        Files.write(errorPath, errorLines);

        // Create summary
        List<String> summary = List.of(
                "INFO = " + infoCount,
                "WARN = " + warnCount,
                "ERROR = " + errorCount
        );

        Files.write(summaryPath, summary);

        System.out.println("Processing completed.");
    }
}
