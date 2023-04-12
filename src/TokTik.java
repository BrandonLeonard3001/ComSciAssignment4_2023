import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TokTik {

	public static void main(String[] args) {
		BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
		try
		{
			File dataSet = new File("dataset.txt");
			Scanner scanner = new Scanner(dataSet);
			
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();				
				//Need to change here so that we create and add account objects.
				//Also this might be case 7 and not done before but who knows xD
				String[] tokens = line.split(" ", 3);

				String action = tokens[0];
				String accountName = tokens[1];
				String profileDescription = tokens[2];
				if (action.equals("Create"))
				{
					Account newAccount = new Account(accountName,profileDescription);
					BT.insert(newAccount);
				}
				else if (action.equals("Add"))
				{
					//add post to account
				}
			}
			//System.out.println(BT.getSize());
			scanner.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
		
		String choice = "0";
		Scanner keyboard = new Scanner(System.in);
		while (!choice.equals("8"))
		{
			System.out.println("Choose an action from the menu:\r\n"
					+ "1. Find the profile description for a given account\r\n"
					+ "2. List all accounts\r\n"
					+ "3. Create an account\r\n"
					+ "4. Delete an account\r\n"
					+ "5. Display all posts for a single account\r\n"
					+ "6. Add a new post for an account\r\n"
					+ "7. Load a file of actions from disk and process this\r\n"
					+ "8. Quit\r\n"
					+ "Enter your choice: ");
			choice = keyboard.nextLine();
			switch (choice) {
			case "1":
				//Find the profile description for a given account
				System.out.println("Enter the account name:");
				String accountName = keyboard.nextLine();
				System.out.println(BT.find(accountName));
				break;
			case "2":
				//List all accounts
				break;
			case "3":
				//Create an account
				break;
			case "4":
				//Delete an account
				break;
			case "5":
				//Display all posts for a single account
				break;
			case "6":
				//Add a new post for an account
				break;
			case "7":
				//Load a file of actions from disk and process this
				break;
			case "8":
				keyboard.close();
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Please give valid input");				
			
			}
		}
		

	}

}
