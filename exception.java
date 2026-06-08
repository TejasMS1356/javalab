import java.util.*;
import java.io.*;
class Invalid extends Exception {
    public Invalid(String msg) {
        super(msg);
    }
}
class student {
    String name;
    int marks;

    student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}
public class prgm4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        student[] stu = new student[3];
        int sum = 0;

        try {
            for (int i = 0; i < 3; i++) {

                System.out.println("Enter name:");
                String name = sc.nextLine();

                System.out.println("Enter marks:");
                int marks = sc.nextInt();

                if (marks < 0 || marks > 100) {
                    throw new Invalid("Marks must be between 0 and 100");
                }

                stu[i] = new student(name, marks);
                sum += marks;
            }

            int avg = sum / stu.length;
            System.out.println("Average: " + avg);

        } catch (Invalid e) {
            System.out.println("Custom exception: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Invalid number input");

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");

        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");
        }

        // FILE HANDLING
        try {
            FileWriter fw = new FileWriter("student.txt");

            for (student s : stu) {
                if (s != null) {
                    fw.write(s.name + " " + s.marks + "\n");
                }
            }
            fw.close();
            System.out.println("Data has been written to file");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
