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
				if (action.equals("Create"))
				{
					String profileDescription = tokens[2];
					Account newAccount = new Account(accountName,profileDescription);
					//Post testPost = new Post("video1123.mp4",5000,"cock and balls");
					//newAccount.addPost(testPost);
					BT.insert(newAccount);
				}
				else if (action.equals("Add"))
				{
					String[] remainder = tokens[2].split(" ",3);
					String videoFileName = remainder[0];
					String numberOfLikes = remainder[1];
					String title = remainder[2];
					Account placeholder = new Account(accountName);
					BinaryTreeNode<Account> node = BT.find(placeholder);
					if (node != null) {
    					Account account = node.data;
    					Post post = new Post(videoFileName,(Integer.parseInt(numberOfLikes)), title);
						if (account != null)
						{
							account.addPost(post);	
						}
					} else {
    					System.out.println("account not found");
					}
					//add post to account
				}
			}
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
				Account placeholder = new Account(accountName);
				BinaryTreeNode<Account> node = BT.find(placeholder);
					if (node != null) {
    					Account account = node.data;
    					String description = account.getProfileDescription();
    					System.out.println(description);
					} else {
    					// handle the case when accountName is not found in the BST
					}
				break;
			case "2":
				//List all accounts
				BT.inOrder();
				break;
			case "3":
				//Create an account
				break;
			case "4":
				//Delete an account
				break;
			case "5":
				//Display all posts for a single account
				System.out.println("Enter the account name:");
				String accountName1 = keyboard.nextLine();
				Account placeholder1 = new Account(accountName1);
				BinaryTreeNode<Account> node1 = BT.find(placeholder1);
					if (node1 != null) {
    					Account account = node1.data;
    					System.out.println(account.getPosts());
					} else {
    					// handle the case when accountName is not found in the BST
					}
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
