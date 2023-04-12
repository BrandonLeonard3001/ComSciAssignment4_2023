import java.util.ArrayList;

public class Account implements Comparable<Account> {

	private String accountName;
	private String profileDescription;
	ArrayList<Post> posts = new ArrayList<Post>();
	
	public Account(String accountName, String profileDescription)
	{
		this.accountName = accountName;
		this.profileDescription = profileDescription;
	}

	public Account(String accountName)
	{
		this.accountName = accountName;
	}
	public String getAccountName()
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
	
	public ArrayList<Post> getPosts()
	{
		return posts;
	}
	
	public void addPost(Post post)
	{
		posts.add(post);
	}
	
	public boolean removePost(Post post)
	{
		return posts.remove(post);
	}
	
	public int compareTo(Account other) {
	    return this.accountName.compareTo(other.accountName);
	}
	
	public String toString()
	{
		return ("Account Name: "+ accountName + "\n" + "Profile Description: " + profileDescription);

	}
}
