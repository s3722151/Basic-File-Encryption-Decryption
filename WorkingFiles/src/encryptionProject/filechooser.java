package encryptionProject;
//Java program to create open or
//save dialog using JFileChooser
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

//Where this is from: https://stackoverflow.com/questions/40255039/how-to-choose-file-in-java
public class filechooser {
    public static void main(String[] args){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif","txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }
    }
}





/*
What this tutorial does
- It a file name.
- Issue it does not save path directory 


What is file chooser:
https://www.javatpoint.com/java-jfilechooser#:~:text=JFileChooser%20is%20a%20class%20that,%2C%20panels%2C%20dialogs%2C%20etc. 
 */
