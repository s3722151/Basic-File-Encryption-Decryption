package encryptionProject;
import java.util.Scanner;  // https://www.w3schools.com/java/java_user_input.asp

public class encryption {
	   public static void main(String[] args) {
	        System.out.println("Please enter a value. E.g.'Hello World'");
	        Scanner myObj = new Scanner(System.in); // Create a Scanner object

	        // Step 1: User enters a value
	        String userName = myObj.nextLine(); // Read user input        

	        // Step 2: Initialize variables
	        boolean encodedState = false; // To track if the string is encodedState
	        

	        while (true) { // Loop until the user chooses to exit
	            System.out.println("What you entered as a value is: " + userName);
	            System.out.println("The Status of the encodedState is:" +encodedState);
	            System.out.println("Press 1 to encode the string");
	            System.out.println("Press 2 to decode the string");
	            System.out.println("Press 3 to exit the program");

	            int optionChosen = -1; // Default invalid option

	            try {
	                optionChosen = myObj.nextInt(); // Read user's choice
	            } catch (Exception e) {
	                System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
	                myObj.nextLine(); // Clear the invalid input from the scanner buffer
	                continue; // Restart the loop to prompt again
	            }

	            switch (optionChosen) {
	                case 1: // Encode the string: https://www.geeksforgeeks.org/print-given-sentence-equivalent-ascii-form/
	                    if (!encodedState) {
	                        System.out.println("Entered 1: You want to encode the string");

	                        System.out.println("The encoded string is: " + userName);
	                        encodedState = true;
	                    } else {
	                        System.out.println("You cannot encode as it is already encodedState.");
	                    }
	                    break;

	                case 2: // Decode the string: https://www.geeksforgeeks.org/convert-the-ascii-value-sentence-to-its-equivalent-string/?ref=oin_asr1
	                    if (encodedState) {
	                        System.out.println("You chose to decode the string.");	

	                        System.out.println("The decoded value is: " + userName);
	                        encodedState = false; // Mark as decoded
	                        
	                    } else {
	                        System.out.println("You cannot decode as it is already decoded.");
	                    }
	                    break;
	                    
	                case 3: // Exit the program
	                    System.out.println("Entered 3: You want to exit this program.");
	                    System.out.println("Thank you for using this program.");
	                    myObj.close(); //https://www.w3schools.com/java/ref_scanner_close.asp
	                    return;

	                default: // Invalid option
	                    System.out.println("Invalid option. Please try again.");
	                    break;
	            }
	        }
	    }

}
