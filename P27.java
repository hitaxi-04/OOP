import java.io.*;

public class StudentFileExample {
    public static void main(String[] args) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            // Step 1: Create and write to file
            fw = new FileWriter("students.txt");
            bw = new BufferedWriter(fw);

            bw.write("101, John, 85");
            bw.newLine();
            bw.write("102, Alice, 90");
            bw.newLine();
            bw.write("103, Bob, 78");
            bw.newLine();

            System.out.println("Student records written successfully.\n");

            // Close writer before reading
            bw.close();

            // Step 2: Read from file
            br = new BufferedReader(new FileReader("students.txt"));
            String line;

            System.out.println("Student Records:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Step 3: Close resources safely
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
 /*output 
  Student records written successfully.

Student Records:
101, John, 85
102, Alice, 90
103, Bob, 78 */
