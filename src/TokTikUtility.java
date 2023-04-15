import java.util.ArrayList;

public class TokTikUtility {
    
    public String findProfileDecription(String accountName, BinarySearchTree<Account> BT)
    {
        Account placeholder = new Account(accountName);
						BinaryTreeNode<Account> node = BT.find(placeholder);
						Account account = node.data;
						String description = account.getProfileDescription();
						return description;
							
    }

    public String listAllAccounts(BinarySearchTree<Account> BT)
    {
        BT.inOrder();
        ArrayList<Account> list = BT.getList();
        String accounts = "";
		for (int i = 0; i < list.size(); i++) {
            Account account = list.get(i);
            accounts = accounts + account.getAccountName() + "\n";
        }
        return accounts;
    }

    public void createNewAccount(String accountName, String profileDescription, BinarySearchTree<Account> BT)
    {
		Account account = new Account(accountName,profileDescription);
		BT.insert(account);
    }

    public void deleteAccount(String accountName, BinarySearchTree<Account> BT)
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
}
