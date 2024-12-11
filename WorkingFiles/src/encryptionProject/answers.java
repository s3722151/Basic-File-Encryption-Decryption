package encryptionProject;

import java.io.*;
import java.util.Scanner;
public class answers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user's choice for encryption or decryption
        int choice = getEncryptionOption(scanner);

        // Get the input file path
        String inputFilePath = getFilePath(scanner, "Enter the file name to encrypt or decrypt:");

        // Get the shift key for the Caesar cipher
        int shiftKey = getShiftKey(scanner);

        // Read the content of the input file
        String fileText = readFileContent(inputFilePath);
        if (fileText == null || fileText.isEmpty()) {
            System.out.println("Error: The file is empty or could not be read.");
            return;
        }

        // Perform encryption or decryption based on user's choice
        String result;
        if (choice == 1) {
            result = encrypt(fileText, shiftKey);
            System.out.println("Encrypted content:\n" + result);
        } else {
            result = decrypt(fileText, shiftKey);
            System.out.println("Decrypted content:\n" + result);
        }

        // Get the output file path and save the result
        String outputFilePath = getFilePath(scanner, "Enter the name for the output file:");
        writeFileContent(outputFilePath, result);
        System.out.println("Operation completed successfully. Output saved to " + outputFilePath);
    }

    // Prompt the user for encryption or decryption choice
    private static int getEncryptionOption(Scanner scanner) {
        int option = 0;
        while (option != 1 && option != 2) {
            System.out.println("Press 1 for encryption or 2 for decryption:");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
            } else {
                scanner.next(); // Clear invalid input
            }
        }
        return option;
    }

    // Prompt the user for a file path
    private static String getFilePath(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.next();
    }

    // Prompt the user for the shift key
    private static int getShiftKey(Scanner scanner) {
        System.out.println("Enter the shift key (positive integer):");
        while (!scanner.hasNextInt()) {
            scanner.next(); // Clear invalid input
            System.out.println("Invalid input. Please enter a positive integer.");
        }
        return scanner.nextInt();
    }

    // Read the content of a file and return it as a string
    private static String readFileContent(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n"); // Append a newline to preserve structure
            }
            return content.toString();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    // Write a string to a file
    private static void writeFileContent(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Encrypt the text using the Caesar cipher
    public static String encrypt(String fileText, int shift) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : fileText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encryptedMessage.append(c);
        }
        return encryptedMessage.toString();
    }

    // Decrypt the text using the Caesar cipher
    public static String decrypt(String fileText, int shift) {
        return encrypt(fileText, 26 - shift % 26); // Reuse encrypt for decryption
    }
}

/*
Explanation of BufferedReader and StringBuilder:

1. BufferedReader:
   - `BufferedReader` is a Java class used to efficiently read text from an input stream, such as a file.
   - It reads larger chunks of data at once (buffering), reducing the number of read operations and improving performance.
   - In this program, `BufferedReader` reads the file line by line using the `readLine()` method, which is memory efficient for large files.

2. StringBuilder:
   - `StringBuilder` is a Java class used for creating and manipulating strings efficiently.
   - Unlike regular string concatenation (`+` operator), which creates a new string object every time, `StringBuilder` modifies the same object, making it faster for multiple string operations.
   - In this program, `StringBuilder` is used to append lines from the file and build the complete file content as a single string.

Benefits:
- `BufferedReader` ensures efficient file reading.
- `StringBuilder` reduces memory overhead and speeds up string concatenation.
*/
