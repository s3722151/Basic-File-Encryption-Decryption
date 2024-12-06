package encryptionProject;
import java.util.Scanner;  // https://www.w3schools.com/java/java_user_input.asp
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class encryption {
	   public static void main(String[] args) {
           //Step 1: Take User input	        
	        Scanner myObj = new Scanner(System.in); //Create a scanner to store input for how many characters they want to shift
	        Scanner encryptionPreference = new Scanner(System.in);
	        Scanner test = new Scanner(System.in);
	        Scanner shiftKeysStorage = new Scanner(System.in);
	        boolean encryptionCheck = false;
	        boolean selectFileCheck = false;
	        boolean shiftKeyCheck = false;
	        
	        while (!encryptionCheck) {
	            System.out.println("Press 1 to encrypt or press 2 to encrypt");
		        try {
		        	int encryptionOption = encryptionPreference.nextInt();
		        	encryptionCheck = true;
		        } catch (Exception e) {
		            System.out.println("You entered a wrong value. Only enter 1 or 2.");
		            encryptionPreference.nextInt();
		        }	        	
	        }	
	        	        
	        System.out.println("What file do you want to encrypt or decrypt?");
	        try {
		        String selectFile = test.nextLine();
	        } catch (Exception e) {
	            System.out.println("You entered a wrong value - second line");
	        }
	        	        
	        System.out.println("Specify number for shifting characters. E.g. if 3, house will become krxvh");
	        try {
	        	int shiftKeys = shiftKeysStorage.nextInt();
	        } catch (Exception e) {
	            System.out.println("You entered a wrong value - second line");
	        }
	        	     
	        
	        //Step 2: Read the input file: https://www.w3schools.com/java/java_files_read.asp
//	        try {
//	            File readObj = new File("filename.txt");
//	            Scanner myReader = new Scanner(readObj);
//	            while (myReader.hasNextLine()) {
//	              String fileText = myReader.nextLine();
//	              System.out.println(fileText);
//	            }
//	            myReader.close();
//	          } catch (FileNotFoundException e) {
//	            System.out.println("An error occurred.");
//	            e.printStackTrace();
//	          }
	        
	        //Variable to track if we have encrypted the file
	        boolean encodedState = false; 
	        

	        while (true) { // Loop until the user chooses to exit
	            System.out.println("What you entered as a value is: ");
	            System.out.println("The Status of the encodedState is:" +encodedState);
	            System.out.println("Press 1 to encode the file");
	            System.out.println("Press 2 to decode the file");
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
	                        System.out.println("Entered 1: You want to encode the file");
	                        
	                        //Use this to write to a file: https://www.w3schools.com/java/java_files_create.asp
	                        
	                        System.out.println("File is now encoded ");
	                        encodedState = true;
	                    } else {
	                        System.out.println("You cannot encode as it is already encodedState.");
	                    }
	                    break;

	                case 2: // Decode the string: https://www.geeksforgeeks.org/convert-the-ascii-value-sentence-to-its-equivalent-string/?ref=oin_asr1
	                    if (encodedState) {
	                        System.out.println("You chose to decode the string.");	

	                        System.out.println("The file is now decoded" );
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

/* 
REFERENCES

//Step 1: Take User input
//Find the file path of the file 
		//Only gets the file: https://youtu.be/gMVkp8108f0
 */
