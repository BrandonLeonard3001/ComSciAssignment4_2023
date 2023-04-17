import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TokTik {

	private String choice;
	private BinarySearchTree<Account> BT;

	public static void main(String[] args) {
		new TokTikGUI();
	}

	//public void actionPerformed(ActionEvent e) {
        //choice = e.getActionCommand();
		//String choice = "0";
		//Scanner keyboard = new Scanner(System.in);
		//while (!choice.equals("8"))
		
		//{
			//System.out.println(gui.getChoice());
			//System.out.println("Choose an action from the menu:\r\n"
					//+ "1. Find the profile description for a given account\r\n"
					//+ "2. List all accounts\r\n"
					//+ "3. Create an account\r\n"
					//+ "4. Delete an account\r\n"
					//+ "5. Display all posts for a single account\r\n"
					//+ "6. Add a new post for an account\r\n"
					//+ "7. Load a file of actions from disk and process this\r\n"
					//+ "8. Quit\r\n"
					//+ "Enter your choice: ");
			//choice = keyboard.nextLine();
			//choice = gui.getChoice();
			//switch (choice) {
			//case "1":
			//case "3":
			//case "4":
			//case "5":
			//case "6":
				//System.out.println("Enter the account name:");
				//String accountName = keyboard.nextLine();
				//switch (choice){
					//case "1":
						//System.out.println(TokTikUtility.findProfileDecription(accountName, BT));
						//Account placeholder = new Account(accountName);
						//BinaryTreeNode<Account> node = BT.find(placeholder);
							//if (node != null) {
								//Account account = node.data;
								//String description = account.getProfileDescription();
								//System.out.println(description);
							//} else {
								//TO DO handle the case when accountName is not found in the BST
							//}
						//break;
					//case "3":
						//create new account
						//System.out.println("Please Enter your profile description");
						//String profileDescription = keyboard.nextLine();
						//Account account = new Account(accountName,profileDescription);
						//BT.insert(account);
						//if (TokTikUtility.accountExists(accountName, BT))
						//{
							//System.out.println("Account name already exists");
						//} else {
							//TokTikUtility.createNewAccount(accountName, profileDescription, BT);
							//System.out.println("Account added");
						//}
						//break;
					//case "4":
						//delete an account
						//Account placeholder = new Account(accountName);
						//BT.delete(placeholder);
						//TokTikUtility.deleteAccount(accountName, BT);
						//break;
					//case "5":
						//get all the posts from a particular account
						//Account placeholder = new Account(accountName);
						//BinaryTreeNode<Account> node1 = BT.find(placeholder);
							//if (node1 != null) {
								//Account account = node1.data;
								//System.out.println(account.getPosts());
								// maybe could setup case if the account has no posts?
							//} else {
								//TO DO handle the case when accountName is not found in the BST
							//}
						//break;
					//case "6":
						//insert a new post to an account
						//placeholder = new Account(accountName);
						//node1 = BT.find(placeholder);
						//if (node1 != null) {
							//Account account = node1.data;
							//System.out.println("Please give the video file name:");
							//String videoFileName = keyboard.nextLine();
							//System.out.println("Please give the number of likes:");
							//String numberOfLikes = keyboard.nextLine();
							//System.out.println("Please give the title:");
							//String title = keyboard.nextLine();
							//Post post = new Post(videoFileName, Integer.parseInt(numberOfLikes), title);
							//account.addPost(post);
						//} else {
							//TO DO handle the case when accountName is not found in the BST
						//}
					//break;
				//}
			//break;
			//case "2":
				//List all accounts
				//BT.inOrder();
				//break;

			//case "7":	
				//Load a file of actions from disk and process this
				//try
				//{	
					//System.out.println("Please enter the file Name:");
					//String fileName = keyboard.nextLine();
					//File dataSet = new File(fileName);
					//Scanner scanner = new Scanner(dataSet);
					
					//while (scanner.hasNextLine())
					//{
						//String line = scanner.nextLine();
						//Also this is case 7
						//String[] tokens = line.split(" ", 3);

						//String action = tokens[0];
						//accountName = tokens[1];
						//if (action.equals("Create"))
						//{
							//String profileDescription = tokens[2];
							//Account newAccount = new Account(accountName,profileDescription);
							//BT.insert(newAccount);
						//}
						//else if (action.equals("Add"))
						//{
							//String[] remainder = tokens[2].split(" ",3);
							//String videoFileName = remainder[0];
							//String numberOfLikes = remainder[1];
							//String title = remainder[2];
							//Account placeholder = new Account(accountName);
							//BinaryTreeNode<Account> node = BT.find(placeholder);
							//if (node != null) {
								//Account account = node.data;
								//Post post = new Post(videoFileName,(Integer.parseInt(numberOfLikes)), title);
								//if (account != null)
								//{
									//account.addPost(post);	
								//}
							//} else {
								//System.out.println("account not found");
							//}
							//add post to account
						//}
					//}
					//scanner.close();
				//} catch (FileNotFoundException f)
				//{
					//System.out.println("File not found!");
				//}
				//break;
			//case "8":
				//keyboard.close();
				//System.out.println("Bye!");
				//break;
			//default:
				//System.out.println("Please give valid input");				
			
			//}
		//}
		

	//}
	

}
