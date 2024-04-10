import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class FileProcessor {
    public static void processFiles(String directory) throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            paths.filter(Files::isRegularFile)
                 .filter(path -> path.toString().endsWith(".op"))
                 .forEach(FileProcessor::processFile);
        }
    }

    private static void processFile(Path path) {
        String outputPath = path.toString().replace(".op", ".res");
        try (BufferedReader reader = Files.newBufferedReader(path);
             PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(outputPath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(";");
                    if (parts.length != 3) throw new IllegalArgumentException("Invalid syntax");
                    double num1 = Double.parseDouble(parts[0]);
                    double num2 = Double.parseDouble(parts[1]);
                    String operator = parts[2];
                    double result;
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        default:
                            throw new IllegalArgumentException("Unsupported operator");
                    }
                    writer.println(result);
                } catch (Exception e) {
                    writer.println("ERROR");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileProcessor <file>");
            System.exit(1);
        }
        Path path = Paths.get(args[0]);
        processFile(path);
    }
}