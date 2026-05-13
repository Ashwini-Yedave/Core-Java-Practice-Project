import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Find Topper");
            System.out.println("4. Calculate Average");
            System.out.println("5. Search Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");

            //try catch used becouse if user enter charcater insted of num then program will be crash for that
            // purpose this is handling
            try {

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

            } catch (Exception e) {

                System.out.println("Invalid input.");

                sc.nextLine();
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt(); //taking id

                    sc.nextLine(); //for nextline after enter value

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    Student s = new Student(id, name, marks); //initialize the values/create object(call automatically constructor)

                    students.add(s);// add the student in arraylist

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {

                        for (Student student : students) { //Enhanced For Loop
                            student.display();
                        }
                    }

                    break;

                case 3:

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {

                        Student topper = students.get(0); //for store the tooper/or assume this [0] is topper /compare purpose

                        for (Student student : students) {

                            if (student.marks > topper.marks) {
                                topper = student;
                            }
                        }

                        System.out.println("Topper Details:");
                        topper.display();
                    }

                    break;

                case 4:

                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {

                        double total = 0;

                        for (Student student : students) {
                            total += student.marks;
                        }

                        double average = total / students.size();

                        System.out.println("Average Marks: " + average);
                    }

                    break;

                case 5:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student student : students) {

                        if (student.id == searchId) {

                            System.out.println("Student Found:");
                            student.display();

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;
                    case 6:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    boolean removed = false;

                    for (Student student : students) {

                        if (student.id == deleteId) {

                            students.remove(student);

                            System.out.println("Student deleted successfully.");

                            removed = true;
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Student not found.");
                    }

                    break;
                case 7:

                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}