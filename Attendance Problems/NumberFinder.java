import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class NumberFinder {
    public static void main(String[] args) throws IOException {
        // Read numbers from text file
        File file = new File("C:\\Users\\Ryujin\\Documents\\numbers.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String numbersAsString = br.readLine();
        int[] numbers = Arrays.stream(numbersAsString.split(","))
          .mapToInt(Integer::parseInt)
          .toArray();

        // Get number to search for from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to search for: ");
        int searchNumber = scanner.nextInt();

        // Search for number in array
        boolean found = false;
        for (int number : numbers) {
            if (number == searchNumber) {
                found = true;
                break;
            }
        }

        // Print result
        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
    }
}
