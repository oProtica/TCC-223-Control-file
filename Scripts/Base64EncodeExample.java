import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64EncodeExample {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        
        // Convert the original string to bytes (UTF-8 is recommended)
        byte[] originalBytes = originalString.getBytes(StandardCharsets.UTF_8);

        // Get a Base64 Encoder instance
        Base64.Encoder encoder = Base64.getEncoder();

        // Encode the byte array to a Base64 string
        String encodedString = encoder.encodeToString(originalBytes);
        
        System.out.println("Original: " + originalString);
        System.out.println("Encoded: " + encodedString); 
        // Output: SGVsbG8sIFdvcmxkIQ==
    }
}
