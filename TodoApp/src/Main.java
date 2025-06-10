import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> arrtask = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag=true;

        while (flag) {

            System.out.println("Enter your choice ");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                   addTask();
                    break;

                case 2:
                   TaskView();
                    break;

                case 3:
                   TaskRemove();
                    break;

                case 4:
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }}


   public static void addTask(){
        System.out.println("Enter your Task");
        String task =sc.nextLine();
        arrtask.add(task);
        System.out.println("Task added");
    }

    public static void TaskView(){
        if (arrtask.isEmpty()) {
            System.out.println("There is no task yet");
        } else {
            System.out.println("Your task are :");
            for (int i = 0; i < arrtask.size(); i++) {
                System.out.println((i + 1) + "." + arrtask.get(i));
            }
        }
    }
    public static void TaskRemove(){
        System.out.print("Enter task number to remove: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 1 && index <= arrtask.size()) {
            arrtask.remove(index - 1);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}