package File_Manager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Manager {

    private static final Scanner sharedScanner = new Scanner(System.in); // Shared scanner

    public static Scanner getSharedScanner() {
        return sharedScanner;
    }

    public static void main(String[] args) {
        boolean stop = false;

        while (!stop) {
            System.out.println("What operation would you like to perform?");
            System.out.println("List Files -> Enter: 1");
            System.out.println("Rename Files -> Enter: 2");
            System.out.println("Move Files -> Enter: 3");
            System.out.println("Delete Files -> Enter: 4");
            System.out.println("Exit -> Enter: 5");

            int choice;
            if (sharedScanner.hasNextInt()) {
                choice = sharedScanner.nextInt();
                sharedScanner.nextLine(); // Consume newline left by nextInt()
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sharedScanner.next(); // Discard invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    listAllFiles();
                    break;
                case 2:
                    renameFiles();
                    break;
                case 3:
                    moveFiles();
                    break;
                case 4:
                    deleteFiles();
                    break;
                case 5:
                    stop = true;
                    break;
                default:
                    System.out.println("Sorry, option not available");
            }
        }

        System.out.println("Thanks for dropping by!");
        sharedScanner.close(); // Close scanner at the end of the program
    }

    public static void listAllFiles() {
        System.out.println("Enter full folder path you want to list:");
        String folderPath = sharedScanner.nextLine(); // Use shared scanner
        File directory = new File(folderPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found or invalid directory.");
        }
        System.out.println("---------------------------------");
    }

    public static void renameFiles() {
        try {
            System.out.println("Enter source file/folder path you want to rename from:");
            String sourcePath = sharedScanner.nextLine();
            System.out.println("Enter new file/folder name:");
            String destinationPath = sharedScanner.nextLine();

            File file1 = new File(sourcePath);
            File file2 = new File(destinationPath);

            if (file2.exists()) {
                throw new IOException("File already exists.");
            }

            boolean success = file1.renameTo(file2);

            if (!success) {
                System.out.println("Failed to rename file.");
            } else {
                System.out.println("File renamed successfully.");
            }
            System.out.println("---------------------------------");
        } catch (Exception e) {
            System.out.println("Error occurred while renaming: " + e.getMessage());
        }
    }

    public static void moveFiles() {
        System.out.println("Enter full source path you want to move from:");
        String source = sharedScanner.nextLine();

        System.out.println("Enter full destination path you want to move to:");
        String destination = sharedScanner.nextLine();
        File file1 = new File(source);
        File file2 = new File(destination);

        boolean success = file1.renameTo(file2);

        if (!success) {
            System.out.println("Failed to move file/folder.");
        } else {
            System.out.println("File/folder moved successfully.");
        }
        System.out.println("---------------------------------");
    }

    public static void deleteFiles() {
        System.out.println("Enter full folder/file path you want to delete:");
        String folderPath = sharedScanner.nextLine();
        File directory = new File(folderPath);

        boolean success = directory.delete();
        if (!success) {
            System.out.println("Failed to delete folder/file.");
        } else {
            System.out.println("Folder/File deleted successfully.");
        }
        System.out.println("---------------------------------");
    }
}
