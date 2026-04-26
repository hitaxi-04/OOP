import java.io.*;
import java.util.Scanner;

public class StudentFileInput {
    public static void main(String[] args) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Create file and writer
            fw = new FileWriter("students.txt");
            bw = new BufferedWriter(fw);

            // Ask number of students
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            // Take input from user
            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details for student " + i);

                System.out.print("Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Marks: ");
                int marks = sc.nextInt();
                sc.nextLine(); // consume newline

                // Write to file
                bw.write(roll + ", " + name + ", " + marks);
                bw.newLine();
            }

            System.out.println("\nStudent records written successfully.\n");

            bw.close(); // close before reading

            // Read from file
            br = new BufferedReader(new FileReader("students.txt"));
            String line;

            System.out.println("Student Records:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
                if (br != null) br.close();
                sc.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
/* output 
Enter number of students: 2

Enter details for student 1
Roll Number: 101
Name: Rahul
Marks: 88

Enter details for student 2
Roll Number: 102
Name: Priya
Marks: 92

Student records written successfully.

Student Records:

101, Rahul, 88
102, Priya, 92*/

    
