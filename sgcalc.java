import java.util.Scanner;

public class sgcalc {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String choice;

    do {
      int numsubjects = getNumberOfSubjects(sc);
      int totalmarks = getTotalMarks(sc, numsubjects);
      String grade = calculateGrade(totalmarks, numsubjects);

      System.out.println("Total Marks: " + totalmarks);
      System.out.println("Average Percentage: " + (double) totalmarks / numsubjects);
      System.out.println("Grade: " + grade);

      System.out.print("Do you want to calculate for another student? (yes/no): ");
      choice = sc.next();
    } while (choice.equalsIgnoreCase("yes"));

    sc.close();
  }

  public static int getNumberOfSubjects(Scanner sc) {
    System.out.print("Enter the number of subjects: ");
    return sc.nextInt();
  }

  public static int getTotalMarks(Scanner sc, int numsubjects) {
    int totalmarks = 0;
    for (int i = 0; i < numsubjects; i++) {
      int marks;
      do {
        System.out.print("Enter marks for subject " + (i + 1) + ": ");
        marks = sc.nextInt();
        if (marks < 0 || marks > 100) {
          System.out.println("Invalid input: Marks should be between 0 and 100");
        }
      } while (marks < 0 || marks > 100);
      totalmarks += marks;
    }
    return totalmarks;
  }

  public static String calculateGrade(int totalmarks, int numsubjects) {
    if (totalmarks > numsubjects * 100) {
      return "Invalid input: Total marks cannot exceed the maximum possible marks (number of subjects * 100)";
    }

    double averagepercentage = (double) totalmarks / numsubjects;

    if (averagepercentage <= 100 && averagepercentage > 90) {
      return "O";
    } else if (averagepercentage <= 90 && averagepercentage > 80) {
      return "A+";
    } else if (averagepercentage <= 80 && averagepercentage > 70) {
      return "A";
    } else if (averagepercentage <= 70 && averagepercentage > 60) {
      return "B+";
    } else if (averagepercentage <= 60 && averagepercentage > 50) {
      return "B";
    } else if (averagepercentage <= 50 && averagepercentage > 45) {
      return "C";
    } else {
      return "F";
    }
  }
}







