package encryptionProject;
import java.util.Scanner;  // https://www.w3schools.com/java/java_user_input.asp
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.io.FileWriter;   // Import the FileWriter class


public class encryption {
	
	   //METHODS
	   static void breakLineMethod() {
		   System.out.println("---------------------------------------------------------------------------------------");
	   }
	   static void encryptionMethod() {
		   //Place encryption code here 
	   }
	   
	   static void decryptionMethod() {
		   //Place de-cryption code here		   
	   }
	   //https://www.youtube.com/watch?v=soEQI-aUWGo
	   public static String encrypt(String fileText, int shift) 
	   {
		   StringBuilder encryptedMessage = new StringBuilder();
		   fileText = fileText.toLowerCase();
		   
		   for (int i = 0; i < fileText.length(); i++) 
		   {
			   char c = fileText.charAt(i);
			   if (Character.isLetter(c)) 
			   {
				   //Explanation:https://youtu.be/soEQI-aUWGo?t=194   
				   c = (char)((c - 'a' + shift + 26 ) % 26 + 'a');
			   }
			   encryptedMessage.append(c);     
		   }
		  return encryptedMessage.toString();
	   }
	   
	
	   public static void main(String[] args) {
           //Step 1: Take User input	        
	        Scanner myObj = new Scanner(System.in); //Create a scanner to store input for how many characters they want to shift
	        Scanner encryptionPreference = new Scanner(System.in);
	        Scanner selectFileStorage = new Scanner(System.in);
	        Scanner shiftKeysStorage = new Scanner(System.in);
	        
	        boolean encryptionCheck = false; // Check for each input
	        boolean selectFileCheck = false;
	        boolean shiftKeyCheck = false;
	        
	        while (!encryptionCheck) {
	            System.out.println("Press 1 to encrypt or press 2 to encrypt");
		        try {
		        	int encryptionOption = encryptionPreference.nextInt();
		        	
		        	if (encryptionOption == 1) {
		        	System.out.println("You have selected 1 - Encryption.");
		        	encryptionCheck = true;
		        	}
		        	else if (encryptionOption == 2) {
		        	System.out.println("You have selected 2 - Decryption.");
		        	encryptionCheck = true;
		        	}
		        	else {
	                    System.out.println("Invalid choice. Please enter 1 or 2.");
	                }
		        	
		        } catch (Exception e) {
		            System.out.println("You entered a wrong value. Only enter 1 or 2.");
		            encryptionPreference.next(); // Clear invalid input
		        }	        	
	        }	
	        
	        breakLineMethod();
	        String selectFile = "";
	        while (!selectFileCheck) {
		        System.out.println("What file do you want to encrypt or decrypt?");
		        try {
			        selectFile = selectFileStorage.nextLine();
			        if (!selectFile.isEmpty()) {
	                    System.out.println("You selected the file: " + selectFile);
	                    selectFileCheck = true;
	                } 
			        else {
	                    System.out.println("File name cannot be empty. Please try again.");
	                }
		        } catch (Exception e) {
		            System.out.println("You entered a wrong value. Please try again - second line");
		        }	        	
	        }
	        
	        breakLineMethod();
	        int shiftKeys = 0;
	        while (!shiftKeyCheck) {
		        System.out.println("Specify number for shifting characters. E.g. if 3, house will become krxvh");
		        try {
		        	shiftKeys = shiftKeysStorage.nextInt();
	                if (shiftKeys > 0) {
	                    System.out.println("You selected a shift key of: " + shiftKeys);
	                    shiftKeyCheck = true;
	                } else {
	                    System.out.println("Shift key must be a positive integer. Please try again.");
	                }
		        } catch (Exception e) {
		            System.out.println("You entered a wrong value - second line");
		            shiftKeysStorage.nextInt();
		        }	        	
	        }

	        String fileText = "";	        
	        breakLineMethod();
	        //Step 2: Read the input file: https://www.w3schools.com/java/java_files_read.asp
	        try {
	            File readObj = new File("C:\\Users\\JC\\Documents\\Programming Projects\\Basic-File-Encryption-Decryption\\files\\" + selectFile);
	            Scanner myReader = new Scanner(readObj);
	            while (myReader.hasNextLine()) {
	              fileText = myReader.nextLine();
	              System.out.println(fileText);
	            }
	            //myReader.close();
	          } catch (FileNotFoundException e) {
	            System.out.println("An error occurred. Could not find the file that was entered.");
	            e.printStackTrace();
	          }
	        //OR: https://www.javatpoint.com/how-to-open-a-file-in-java
	        	        
	        //Variable to track if we have encrypted the file
	        boolean encodedState = false; 
	        
	        //Step 3 Encryption: https://www.youtube.com/watch?v=soEQI-aUWGo 
	        //Explanation: https://www.baeldung.com/java-caesar-cipher
	        String encryptedMessage = encrypt(fileText, shiftKeys);
	        System.out.println("Encrypted message is as follows:" + encryptedMessage);
	        
	        //Decryption: https://www.youtube.com/watch?v=ZNRd_Yb9Ujw
	        
	        
	        //Step 4 Create a new file: https://www.w3schools.com/java/java_files_create.asp
	        breakLineMethod();
	        try {
	            File saveObj = new File("C:\\Users\\JC\\Documents\\Programming Projects\\Basic-File-Encryption-Decryption\\files\\encrypted.txt");
	            if (saveObj.createNewFile()) {
	              System.out.println("File created: " + saveObj.getName());
	            } else {
	              System.out.println("File already exists.");
	            }
	          } catch (IOException e) {
	            System.out.println("An error occurred. The file could not be created.");
	            e.printStackTrace();
	          }
	        
	        //Step 5: Write to the file: https://www.w3schools.com/java/java_files_create.asp
	        breakLineMethod();
	        try {
	        	//("C:\\Users\\JC\\Documents\\Programming Projects\\Basic-File-Encryption-Decryption\\files\\filename.txt");
	            FileWriter myWriter = new FileWriter("C:\\Users\\JC\\Documents\\Programming Projects\\Basic-File-Encryption-Decryption\\files\\encrypted.txt");
	            myWriter.write(encryptedMessage); //Replace this with the encryption method in step 3. This needs to be appended.
	            myWriter.close();
	            System.out.println("Successfully wrote to the file.");
	            System.out.println("Program is now finished.");
	          } catch (IOException e) {
	            System.out.println("An error occurred. The file could not be written to.");
	            e.printStackTrace();
	          }

	    } // End of MAIN method
	   



} //End of class




/* 
REFERENCES

//Step 1: Take User input
//Find the file path of the file 
		//Only gets the file: https://youtu.be/gMVkp8108f0
Step 3
This was my original idea:
https://www.geeksforgeeks.org/java-program-to-modify-a-string-by-performing-given-shift-operations/
- Scrapped as it you needed to manually specify the shift. 

Step 5:
Not using absolute paths: https://stackoverflow.com/questions/63618663/java-using-relative-path-instead-of-absolute-path
 */
