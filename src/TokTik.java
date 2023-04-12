import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TokTik {

	public static void main(String[] args) {
		BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
		
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
				System.out.println("Please Enter your username");
				accountName = keyboard.nextLine();
				System.out.println("Please Enter your profile description");
				String profileDescription = keyboard.nextLine();
				Account account = new Account(accountName,profileDescription);
				BT.insert(account);
				break;
			case "4":
				//Delete an account
				System.out.println("Enter the account name:");
				accountName = keyboard.nextLine();
				placeholder = new Account(accountName);
				BT.delete(placeholder);
				break;
			case "5":
				//Display all posts for a single account
				System.out.println("Enter the account name:");
				accountName = keyboard.nextLine();
				placeholder = new Account(accountName);
				BinaryTreeNode<Account> node1 = BT.find(placeholder);
					if (node1 != null) {
    					account = node1.data;
    					System.out.println(account.getPosts());
					} else {
    					// handle the case when accountName is not found in the BST
					}
				break;
			case "6":
				//Add a new post for an account
				System.out.println("Enter the account name:");
				accountName =keyboard.nextLine();
				placeholder = new Account(accountName);
				node1 = BT.find(placeholder);
					if (node1 != null) {
						account = node1.data;
						System.out.println("Please give the video file name:");
						String videoFileName = keyboard.nextLine();
						System.out.println("Please give the number of likes:");
						String numberOfLikes = keyboard.nextLine();
						System.out.println("Please give the title:");
						String title = keyboard.nextLine();
						Post post = new Post(videoFileName, Integer.parseInt(numberOfLikes), title);
						account.addPost(post);
					} else {
						// handle the case when accountName is not found in the BST
					}
				break;
			case "7":	
				//Load a file of actions from disk and process this
				try
				{	
					System.out.println("Please enter the file Name:");
					String fileName = keyboard.nextLine();
					File dataSet = new File(fileName);
					Scanner scanner = new Scanner(dataSet);
					
					while (scanner.hasNextLine())
					{
						String line = scanner.nextLine();
						//Also this is case 7
						String[] tokens = line.split(" ", 3);

						String action = tokens[0];
						accountName = tokens[1];
						if (action.equals("Create"))
						{
							profileDescription = tokens[2];
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
							placeholder = new Account(accountName);
							node = BT.find(placeholder);
							if (node != null) {
								account = node.data;
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
