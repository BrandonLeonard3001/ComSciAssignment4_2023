import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TokTik {
    private static Scanner scanner = new Scanner(System.in);
    private static BST<User> users = new BST<>();

    public static void main(String[] args) {
        System.out.println("Welcome to TokTik!");
        loadUsersFromFile("users.txt");

        int choice;
        do {
            printMenu();
            choice = readIntInput();
            executeChoice(choice);
        } while (choice != 8);

        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\nChoose an action from the menu:");
        System.out.println("1. Find the profile description for a given account");
        System.out.println("2. List all accounts");
        System.out.println("3. Create an account");
        System.out.println("4. Delete an account");
        System.out.println("5. Display all posts for a single account");
        System.out.println("6. Add a new post for an account");
        System.out.println("7. Load a file of actions from disk and process this");
        System.out.println("8. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void executeChoice(int choice) {
        switch (choice) {
            case 1:
                findProfileDescription();
                break;
            case 2:
                listAllAccounts();
                break;
            case 3:
                createAccount();
                break;
            case 4:
                deleteAccount();
                break;
            case 5:
                displayPosts();
                break;
            case 6:
                addPost();
                break;
            case 7:
                loadActionsFromFile("actions.txt");
                break;
            case 8:
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    private static void findProfileDescription() {
        System.out.print("Enter the account name: ");
        String account = readStringInput();
        User user = users.search(new User(account, "", null));
        if (user != null) {
            System.out.println("The profile description is: " + user.getDescription());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void listAllAccounts() {
        System.out.println("Accounts:");
        for (User user : users.inOrder()) {
            System.out.println(user.getAccount());
        }
    }

    private static void createAccount() {
        System.out.print("Enter the account name: ");
        String account = readStringInput();
        User user = users.search(new User(account, "", null));
        if (user == null) {
            System.out.print("Enter the profile description: ");
            String description = readStringInput();
            users.insert(new User(account, description, null));
            System.out.println("Account created.");
        } else {
            System.out.println("Account already exists.");
        }
    }

    private static void deleteAccount() {
        System.out.print("Enter the account name: ");
        String account = readStringInput();
        User user = users.search(new User(account, "", null));
        if (user != null) {
            users.delete(user);
            System.out.println("Account deleted.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayPosts() {
        System.out.print("Enter the account name: ");
        String account = readStringInput();
        User user = users.search(new User(account, "", null));
        if (user != null) {
            System.out.println("Posts for account " + account + ":");
           
