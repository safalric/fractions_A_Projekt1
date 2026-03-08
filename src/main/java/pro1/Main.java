package pro1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path inputDir = Paths.get(System.getProperty("user.dir"), "input");
        Path outputDir = Paths.get(System.getProperty("user.dir"), "output");

        Files.createDirectories(outputDir);

        if (!Files.exists(inputDir) || !Files.isDirectory(inputDir)) {
            return;
        }

        try (Stream<Path> files = Files.list(inputDir)) {
            for (Path inputFile : files.toList()) {
                if (!Files.isRegularFile(inputFile)) {
                    continue;
                }
                if (!inputFile.getFileName().toString().toLowerCase().endsWith(".csv")) {
                    continue;
                }

                List<String> lines = Files.readAllLines(inputFile);
                List<String> outputLines = new ArrayList<>();

                for (String line : lines) {
                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    String[] parts = line.split(";", 2);
                    if (parts.length < 2) {
                        continue;
                    }

                    String personId = parts[0].trim();
                    String scoreExpression = parts[1].trim();

                    Fraction score = Fraction.parse(scoreExpression);
                    ExamRecord record = new ExamRecord(personId, score);
                    outputLines.add(record.getPersonId() + ";" + record.getScore());
                }

                Path outputFile = outputDir.resolve(inputFile.getFileName());
                Files.write(outputFile, outputLines);
            }
        }
    }
}

