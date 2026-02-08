import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64DecoderExample {
    public static void main(String[] args) {
        // The Base64 encoded string
        String encodedString = "dGVzdCBpbnB1dA==";

        // 1. Get a Base64 Decoder instance
        Base64.Decoder decoder = Base64.getDecoder();

        // 2. Decode the string into a byte array
        byte[] decodedBytes = decoder.decode(encodedString);

        // 3. Convert the byte array back to the original string, specifying the character encoding (e.g., UTF-8)
        String originalString = new String(decodedBytes, StandardCharsets.UTF_8);

        System.out.println("Original: " + originalString);
        // Output: Original: test input
    }
}
