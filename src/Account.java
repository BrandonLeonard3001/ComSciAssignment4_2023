// Account Class to Store information about an account for TokTik
// 18-04-2023
// Brandon Leonard LNRBRA001

import java.util.ArrayList;

//Account implements the Comparable interface so that it can be compared to other accounts when being stored in the binary tree
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
	public String getAccountName()	//standard getters and setters below
	{
		return accountName;
	}
	
	public String getProfileDescription()
	{
		return profileDescription;
	}
	
	public void setProfileDescription(String profileDescription)
	{
		profileDescription = this.profileDescription;
	}
	
	public String getPosts()
	{
		String postsString = "";
		for(Post item : posts) 
		{
			postsString = postsString + item.toString() + "\n";
		}
		return postsString;
	}
	
	public void addPost(Post post)
	{
		posts.add(post);
	}
	
	public boolean removePost(Post post)
	{
		return posts.remove(post);
	}
	
	public int compareTo(Account other) {	//compareTo method for when it get compared in the Binary Tree
	    return this.accountName.compareTo(other.accountName);
	}
	
	public String toString()	//standard toString method
	{
		return ("Account Name: "+ accountName + "\n" + "Profile Description: " + profileDescription);

	}
}
