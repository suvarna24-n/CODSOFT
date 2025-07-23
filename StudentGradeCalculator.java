import java.util.Scanner;

public class StudentGradeCalculator {

    // Method to input marks with validation
    public static int[] inputMarks(int numSubjects, Scanner scanner) {
        int[] marks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (0 - 100): ");
            int mark = scanner.nextInt();

            while (mark < 0 || mark > 100) {
                System.out.print("Invalid! Enter marks between 0 and 100: ");
                mark = scanner.nextInt();
            }
            marks[i] = mark;
        }

        return marks;
    }

    // Method to calculate total marks
    public static int calculateTotal(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Method to calculate average percentage
    public static double calculateAverage(int total, int numSubjects) {
        return (double) total / numSubjects;
    }

    // Method to determine grade
    public static String determineGrade(double average) {
        if (average >= 90) return "A (Excellent)";
        else if (average >= 80) return "B (Very Good)";
        else if (average >= 70) return "C (Good)";
        else if (average >= 60) return "D (Satisfactory)";
        else return "F (Fail)";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Student Grade Calculator =====");

        // Input student name
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Input marks
        int[] marks = inputMarks(numSubjects, scanner);

        // Calculate total, average, and grade
        int total = calculateTotal(marks);
        double average = calculateAverage(total, numSubjects);
        String grade = determineGrade(average);

        // Display results
        System.out.println("\n===== Report Card =====");
        System.out.println("Student Name     : " + name);
        System.out.println("Number of Subjects: " + numSubjects);
        System.out.println("Total Marks      : " + total);
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Final Grade      : " + grade);

        scanner.close();
    }
}