package To_do_App;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {

    private ArrayList<String> tasks = new ArrayList<String>();
    private Scanner sc = new Scanner(System.in);
    public static void main(String [] args)
    {
        ToDo option = new ToDo();
        boolean stop = false;

        while(!stop)
        {
            System.out.println("1. List my tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");

            int choice;
            if (option.sc.hasNextInt()) {
                choice = option.sc.nextInt();
                option.sc.nextLine(); // Clear the buffer
            } else {
                System.out.println("Invalid input. Please enter a number.");
                option.sc.nextLine(); // Consume the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    option.listTasks();
                    break;
                case 2:
                    option.addTask();
                    break;
                case 3:
                    option.removeTask();
                    break;
                case 4:
                    System.out.println("Exiting Program......");
                    stop = true;
                    break;
            
                default:
                    System.out.println("Looks like you entered an invalid option");
                    break;
            }
        }
        option.sc.close();
    }

    public void listTasks()
    {
        System.out.println("Listing Tasks:");
        int counter = 1;
        for(String task: tasks)
        {
            System.out.println("ID: " + counter + ". " + task);
            counter++;
        }
        System.out.println("---------------------------");
    }

    public void addTask()
    {
        System.out.println("Add Tasks:");
        System.out.println("Enter Task name: ");
        String task = sc.nextLine();
        tasks.add(task);
        System.out.println("Task Added"); 
        System.out.println("---------------------------");
    }

    public void removeTask()
    {
        System.out.println("Remove Tasks:");
        System.out.println("Enter Task id: ");
        Integer task = sc.nextInt();
        tasks.remove(task - 1);
        System.out.println("Task Removed"); 
        System.out.println("---------------------------");
    }
}