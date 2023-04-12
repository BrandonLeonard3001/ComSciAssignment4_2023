import java.util.List;

public class Account implements Comparable<Account> {

	private String accountName;
	private String profileDescription;
	List<Post> posts;
	
	public Account(String accountName, String profileDescription)
	{
		this.accountName = accountName;
		this.profileDescription = profileDescription;
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
	
	public List<Post> getPosts()
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
}
