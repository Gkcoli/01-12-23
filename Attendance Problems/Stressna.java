import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
// This is the tough one to code T^T
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path: ");// Write the destination of the file
        String filePath = sc.nextLine();
        System.out.println("Enter the string to be replaced: ");// This will remove the string that you like to get over with
        String oldString = sc.nextLine();
        System.out.println("Enter the new string: ");// Input the new string that you like to put
        String newString = sc.nextLine();

        File fileToBeModified = new File(filePath);// To search the file if the file is literally thereC
        String oldContent = "";

        BufferedReader reader = null;
// i use the try method to read the file and the string line
// and also it will replace the oldcontent of the file to a new one
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            String newContent = oldContent.replaceAll(oldString, newString);

            if (!oldContent.equals(newContent)) { // this section shows to change the old string into a new one. and it reads the specific file you input
                FileWriter writer = new FileWriter(fileToBeModified);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write(newContent);
                bufferWriter.close();
                System.out.println("File modified successfully!");// it means the file is found
                System.out.println("New Content : ");
                System.out.println(newContent);
            } else {
                System.out.println("The specified string was not found in the text.");// If you put a string that's not there it will error 
            }
// This last section of the code tracks the handle exceptions and errors
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
