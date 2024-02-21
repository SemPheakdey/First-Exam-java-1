
import java.util.ArrayList;
import java.util.Scanner;

public class TeacherSchedule {

    private ArrayList<String> classes;

    public TeacherSchedule() {
        classes = new ArrayList<>();
    }

    public void addClass(String teacher, String subject, String time, String day) {
        String className = teacher + " / " + subject + " / " + time + " / " + day;
        classes.add(className);
        System.out.println(className + " has been added to the Teacher Teaching Schedule.");
    }

    public void deleteClass(String className) {
        if (classes.contains(className)) {
            classes.remove(className);
            System.out.println(className + " has been removed from the Teacher Teaching Schedule.");
        } else {
            System.out.println(className + " was not found in the system.");
        }
    }

    public void deleteTeacher(String teacherName) {
        // Create a list to store classes to be removed
        ArrayList<String> classesToRemove = new ArrayList<>();

        // Find classes associated with the given teacher
        for (String className : classes) {
            if (className.startsWith(teacherName + " / ")) {
                classesToRemove.add(className);
            }
        }

        // Remove the classes
        if (!classesToRemove.isEmpty()) {
            classes.removeAll(classesToRemove);
            System.out.println("All classes for " + teacherName + " have been removed.");
        } else {
            System.out.println("No classes found for " + teacherName + " in the schedule.");
        }
    }

    public void printSchedule() {
        if (classes.isEmpty()) {
            System.out.println("The schedule is empty.");
        } else {
            System.out.println("Teacher's schedule:");
            System.out.println("+-----------------------------------------+");
            System.out.printf("| %-40s |\n", "Class Details");
            System.out.println("|-----------------------------------------|");
            for (String className : classes) {
                System.out.printf("| %-40s |\n", className);
            }
            System.out.println("+-----------------------------------------+");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TeacherSchedule scheduler = new TeacherSchedule();

            while (true) {
                System.out.println("Please choose:");
                System.out.println("1. Add teacher's schedule");
                System.out.println("2. Delete teacher's classes");
                System.out.println("3. Print teacher's schedule");
                System.out.println("4. Exit");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Enter the teacher's name: ");
                        String teacher = scanner.nextLine();
                        System.out.println("Enter the teacher's teaching subject: ");
                        String subject = scanner.nextLine();
                        System.out.println("Enter the teacher's teaching time: ");
                        String time = scanner.nextLine();
                        System.out.println("Enter the teacher's teaching day: ");
                        String day = scanner.nextLine();
                        scheduler.addClass(teacher, subject, time, day);
                        break;
                    case 2:
                        System.out.println("Enter the name of the teacher to delete all classes: ");
                        String teacherToDelete = scanner.nextLine();
                        scheduler.deleteTeacher(teacherToDelete);
                        break;
                    case 3:
                        scheduler.printSchedule();
                        break;
                    case 4:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

