# Basic-File-Encryption-Decryption
This is a project to help me get ready for Cloud Security (university course). 

Deadline: Two weeks from today: December 15, 2024.

Project Details: Basic File Encryption/Decryption
Goal:
Create a program in Java that:
1.	Reads a text file.
2.	Applies a simple encryption method (e.g., Caesar cipher).
3.	Writes the encrypted output to another file.
4.	Provides a decryption option to reverse the process.
Key Features:
•	Input: User specifies the file to encrypt/decrypt and the shift key for the cipher.
•	Output: Encrypted/Decrypted text is written to a new file.
•	Options: User can choose between encryption or decryption.
Skills Covered:
•	File handling.
•	String manipulation.
•	Loops and conditionals.
•	Basic command-line interaction (optional).

Tasks to Complete:
1.	Day 1-3: Learn or review file handling in Java.
o	Practice reading and writing text files.
o	Ensure your development environment is set up.
2.	Day 4-7: Implement basic Caesar cipher logic.
o	Create functions for encryption and decryption.
3.	Day 8-10: Integrate file handling and encryption logic.
o	Allow the program to read from and write to files.
o	Test using small text files.
4.	Day 11-13: Add a user-friendly menu for interaction.
o	Let users choose encryption or decryption, input shift key, etc.
5.	Day 14: Final testing and polish.



Other NOTES
src folder:

src stands for source. It's where you put all your Java code (the classes and files you write). When you create a project, Eclipse automatically creates a src folder to organize your code.
JRE System Library:

JRE stands for Java Runtime Environment. It's a set of tools and libraries that Java needs to run your programs. The JRE System Library in Eclipse lets your project use these tools so you can run your Java code. It includes things like basic math functions, input/output handling, and more.


DIARY LOG
1/12/2024
Started the project - created the repository.

2/12/2024
Was diagnosing how to clone the repository from remote to local.
- Had to update the java JDK
- Had to change the workspace
- Had to update the GIT extension

3/4/2024
Made the menu. Just copied code from previous project.

4/4/2024
Trying to clarify the steps of the project.

5/4/2024 
Realised I should get the filePath based on specifying user input: 
https://stackoverflow.com/questions/13509822/get-the-filepath-from-filename-using-java

6/12/2024
I am kinda stuck on getting different user inputs. 
Fixed it. I had the idea of using a while loop and using multiple scanner objects.

7/12/2024
Kinda tired. I still feel like specifying the file path would be more better than letting a user type a file. 

8/12/2024
Found this helpful: https://www.javatpoint.com/how-to-open-a-file-in-java
Deleting the menu as it was optional and wasn't needed. 

9/12/2024
Added the encryption method

10/12/2024
Added the decryption method.
Created and moved the decryption and encryption main method code in a while statement. 
This ensures it is only executed based on step 2.
