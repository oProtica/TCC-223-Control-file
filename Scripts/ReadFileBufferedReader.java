import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileBufferedReader {
    public static void main(String[] args) {
        String fileName = "sample.txt"; // Replace with your file path

        // Use try-with-resources to ensure the reader is closed
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read lines one by one until the end of the file (readLine() returns null)
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Process the line (e.g., print it)
            }
        } catch (IOException e) {
            // Handle exceptions such as FileNotFoundException or other I/O errors
            e.printStackTrace();
        }
    }
}
