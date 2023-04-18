// Account Class to Store information about an account for TokTik
// 18-04-2023
// Brandon Leonard LNRBRA001

import java.util.ArrayList;
/**
 * Account Class
 * Account implements the Comparable interface so that it can be compared to other accounts when being stored in the binary tree
 * @author Brandon Leonard
 * @version 1.0.0
 */

public class Account implements Comparable<Account> {

	private String accountName;
	private String profileDescription;
	ArrayList<Post> posts = new ArrayList<Post>();
	
	public Account(String accountName, String profileDescription)	//constructor of a full acc
	{
		this.accountName = accountName;
		this.profileDescription = profileDescription;
	}

	public Account(String accountName)	//constructor of account without profile description used for checks in Binary Tree
	{
		this.accountName = accountName;
	}
	
	/** 
	 * Gets the account name of an Account object
	 * @return String
	 */
	public String getAccountName()	//standard getters and setters below
	{
		return accountName;
	}
	
	
	/** 
	 * Gets the profile description of an Account object
	 * @return String
	 */
	public String getProfileDescription()
	{
		return profileDescription;
	}
	
	
	/** 
	 * Sets the profile description of an Account Object
	 * @param profileDescription
	 */
	public void setProfileDescription(String profileDescription)
	{
		profileDescription = this.profileDescription;
	}
	
	
	/** 
	 * Geta the posts of an account object
	 * @return String
	 */
	public String getPosts()
	{
		String postsString = "";
		for(Post item : posts) 
		{
			postsString = postsString + item.toString() + "\n";
		}
		return postsString;
	}
	
	
	/** 
	 * adds a Post object to an Account Object
	 * @param post
	 */
	public void addPost(Post post)
	{
		posts.add(post);
	}
	
	
	/** 
	 * removes a post from an Account Object
	 * @param post
	 * @return boolean
	 */
	public boolean removePost(Post post)
	{
		return posts.remove(post);
	}
	
	
	/** 
	 * Compares an Account to another Account by comparing their accountName String value
	 * @param toString(
	 * @return int
	 */
	public int compareTo(Account other) {	//compareTo method for when it get compared in the Binary Tree
	    return this.accountName.compareTo(other.accountName);
	}
	
	
	/** 
	 * Gives a string representation of an Account object
	 * @return String
	 */
	public String toString()	//standard toString method
	{
		return ("Account Name: "+ accountName + "\n" + "Profile Description: " + profileDescription);

	}
}
