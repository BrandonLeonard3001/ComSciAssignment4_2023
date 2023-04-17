import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TokTikUtility {
    
    public static String findProfileDecription(String accountName, BinarySearchTree<Account> BT)
    {
        Account placeholder = new Account(accountName);
						BinaryTreeNode<Account> node = BT.find(placeholder);
                        if (node != null)
                        {
						Account account = node.data;
						String description = account.getProfileDescription();
						return description;
                        }
                        else{
                            return "Cannot Find Account";
                        }
							
    }

    public static void createNewAccount(String accountName, String profileDescription, BinarySearchTree<Account> BT)
    {
        Account placeholder = new Account(accountName,profileDescription);
        BinaryTreeNode<Account> node = BT.find(placeholder);
                if (node != null)
                {
                    //do nothing
                }
                else{
                    BT.insert(placeholder);
                }
    }

    public static String deleteAccount(String accountName, BinarySearchTree<Account> BT)
    {   

        Account placeholder = new Account(accountName);
        BinaryTreeNode<Account> node = BT.find(placeholder);
        if (node != null) 
        {
                BT.delete(placeholder);
                return "Account Deleted";
        }
        else
        {
            return "No Account found";
        }

    }

    public static String getAllPosts(String accountName, BinarySearchTree<Account> BT)
    {
        Account placeholder = new Account(accountName);
		BinaryTreeNode<Account> node = BT.find(placeholder);
		if (node != null) 
        {
				Account account = node.data;
                String posts = account.getPosts();
                return posts;
        }
        else
        {
            return "No Account found";
        }
    }

    public static void insterNewPost(String accountName, BinarySearchTree<Account> BT, String videoFileName, String numberOfLikes, String title)
    {
        Account placeholder = new Account(accountName);
        BinaryTreeNode<Account> node = BT.find(placeholder);
			if (node != null) {
				Account account = node.data;
				Post post = new Post(videoFileName, Integer.parseInt(numberOfLikes), title);
				account.addPost(post);
			} else {
							//TO DO handle the case when accountName is not found in the BST
			}
    }
    
    public static boolean accountExists(String accountName, BinarySearchTree<Account> BT)
    {
        Account placeholder = new Account(accountName);
        BinaryTreeNode<Account> node = BT.find(placeholder);
			if (node != null) {
				return true;
			} else {
				return false;
			}
    }

    public static void processData(String fileName, BinarySearchTree<Account> BT)
    {
        //Load a file of actions from disk and process this
				try
				{	
					File dataSet = new File(fileName);
					Scanner scanner = new Scanner(dataSet);
					
					while (scanner.hasNextLine())
					{
						String line = scanner.nextLine();
						String[] tokens = line.split(" ", 3);

						String action = tokens[0];
						String accountName = tokens[1];
						if (action.equals("Create"))
						{
							String profileDescription = tokens[2];
							Account newAccount = new Account(accountName,profileDescription);
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
                    System.out.println("Actions loaded succesfully!");
				} catch (FileNotFoundException f)
				{
					System.out.println("File not found!");
				}
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
