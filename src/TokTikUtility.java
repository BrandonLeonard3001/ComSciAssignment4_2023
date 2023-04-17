
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

    public static void deleteAccount(String accountName, BinarySearchTree<Account> BT)
    {
        Account placeholder = new Account(accountName);
		BT.delete(placeholder);
    }

    public String getAllPosts(String accountName, BinarySearchTree<Account> BT)
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

    public void insterNewPost(String accountName, BinarySearchTree<Account> BT, String videoFileName, String numberOfLikes, String title)
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
}
