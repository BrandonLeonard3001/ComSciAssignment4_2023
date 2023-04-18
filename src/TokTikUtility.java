// Utility Class for the TokTik app
// 18-04-2023
// Brandon Leonard LNRBRA001

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Utility Class for the TokTik app
 * @author Brandon Leonard
 * @version 1.0.0
 */

public class TokTikUtility {
    
    
    /** 
     * Method to find a profile description from a given account name from a given BinaryTree
     * @param accountName
     * @param BT
     * @return String
     */
    public static String findProfileDecription(String accountName, BinarySearchTree<Account> BT) 
    {
        Account placeholder = new Account(accountName);     //Creation of a temporary account in order to locate the associated node in the binary tree
						BinaryTreeNode<Account> node = BT.find(placeholder);    
                        if (node != null)   //checking if it was found or not
                        {
						Account account = node.data;    //get the account from the node
						String description = account.getProfileDescription();   //get the description from the account
						return description;
                        }
                        else{
                            return "Cannot Find Account";   //case for when the account is not found in the binary tree
                        }
							
    }

    
    /** 
     * method to create a new full account
     * @param accountName
     * @param profileDescription
     * @param BT
     */
    public static void createNewAccount(String accountName, String profileDescription, BinarySearchTree<Account> BT)    //method to create a new full account
    {
        Account placeholder = new Account(accountName,profileDescription);  //creation of a temporary account to help locate it in the binary tree
        BinaryTreeNode<Account> node = BT.find(placeholder);    
                if (node != null)   //checking if the account already exists, if it doesnt exist we create a new account.
                {
                    System.out.println("Account Already exists");   //case for when account already exists
                }
                else{
                    BT.insert(placeholder); //case for when account doesnt exist
                    System.out.println("Account creation successful");
                }
    }

    
    /** 
     * method to delete an account from the binary tree
     * @param accountName
     * @param BT
     */
    public static void deleteAccount(String accountName, BinarySearchTree<Account> BT)    //method to delete an account from the binary tree
    {   

        Account placeholder = new Account(accountName);     //first we check if the account exists or not
        BinaryTreeNode<Account> node = BT.find(placeholder);
        if (node != null) 
        {
            BT.delete(placeholder);     //if account exists we delete it
            System.out.println("Account Deleted");
        }
        else
        {
            System.out.println("No Account found");      //if the account doesnt exist
        }

    }

    
    /** 
     * returns all the posts of a given account
     * @param accountName
     * @param BT
     * @return String
     */
    public static String getAllPosts(String accountName, BinarySearchTree<Account> BT)  //returns all the posts of a given account
    {
        Account placeholder = new Account(accountName);     //check if the given account exists
		BinaryTreeNode<Account> node = BT.find(placeholder);
		if (node != null) 
        {
				Account account = node.data;    //if it exists, we grab the account and then grab the posts of the account
                String posts = account.getPosts();
                return posts;
        }
        else
        {
            return "No Account found";  //case when account is not in the binary tree
        }
    }

    
    /** 
     * method to insert a new post into a pre-existing account
     * @param accountName
     * @param BT
     * @param videoFileName
     * @param numberOfLikes
     * @param title
     */
    public static void insterNewPost(String accountName, BinarySearchTree<Account> BT, String videoFileName, String numberOfLikes, String title)    //method to insert a new post into a pre-existing account
    {
        Account placeholder = new Account(accountName);     //check if account is pre-existing in our binary tree
        BinaryTreeNode<Account> node = BT.find(placeholder);
			if (node != null) {
				Account account = node.data;
				Post post = new Post(videoFileName, Integer.parseInt(numberOfLikes), title);    //if it exists, we create the post item and add it to the account
				account.addPost(post);
                System.out.println("Post added successfully");                                //We do the check if the numberOfLikes string is numeric in the GUI
			} else {
				//case when accountName is not found in the BST
                System.out.println("Account: "+accountName+" does not exist");
			}
    }
    
    
    /** 
     * method to check if an account exists in a given Binary Tree
     * @param accountName
     * @param BT
     * @return boolean
     */
    public static boolean accountExists(String accountName, BinarySearchTree<Account> BT)   //a boolean method to check if an account exists
    {
        Account placeholder = new Account(accountName);
        BinaryTreeNode<Account> node = BT.find(placeholder);
			if (node != null) {
				return true;
			} else {
				return false;
			}
    }

    
    /** 
     * method to grab a set of actions and add it to the binary tree from a file
     * @param fileName
     * @param BT
     */
    public static void processData(String fileName, BinarySearchTree<Account> BT)   //a method to grab a set of actions and add it to the binary tree from a file
    {
        //Load a file of actions from disk and process this
				try
				{	
					File dataSet = new File(fileName);
					Scanner scanner = new Scanner(dataSet);
					
					while (scanner.hasNextLine())
					{
						String line = scanner.nextLine();   
						String[] tokens = line.split(" ", 3);   //Use of String splitting to grab the appropriate actions from the text

						String action = tokens[0];
						String accountName = tokens[1];
						if (action.equals("Create"))    //case for create action
						{
							String profileDescription = tokens[2];  //grab the remainder of the String as it is the description
							Account newAccount = new Account(accountName,profileDescription);
							BT.insert(newAccount);
						}
						else if (action.equals("Add"))  //case for add action
						{
							String[] remainder = tokens[2].split(" ",3);    //need to further split to grab the last 3 attributes
							String videoFileName = remainder[0];
							String numberOfLikes = remainder[1];
							String title = remainder[2];
							Account placeholder = new Account(accountName);
							BinaryTreeNode<Account> node = BT.find(placeholder);
							if (node != null) { //check if account is pre-existing
								Account account = node.data;
								Post post = new Post(videoFileName,(Integer.parseInt(numberOfLikes)), title);
								if (account != null)
								{
									account.addPost(post);	//adding the newly created post item
								}
							} else {
								System.out.println("account not found");    //error msg for when add is trying to add to an account not in the BT
							}
						}
					}
					scanner.close();    //close scanner for memory reasons
                    System.out.println("Actions loaded succesfully!");  //success msg
				} catch (FileNotFoundException f)
				{
					System.out.println("File not found!");  //error msg for file not found
				}
    }

    
    /** 
     * method to check if a given String value is numeric or not
     * @param strNum
     * @return boolean
     */
    public static boolean isNumeric(String strNum) {    //method to check if a given String value is numeric or not
        if (strNum == null) {   //first checking if it is null
            return false;
        }
        try {
            Integer.parseInt(strNum); //use of try to see if we can parse it
        } catch (NumberFormatException nfe) {   //if we cannot parse it then it is not numeric
            return false;
        }
        return true;
    }
}
