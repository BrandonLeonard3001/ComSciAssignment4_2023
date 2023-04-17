
public class Post {

	String title;
	String videoFileName;
	int numberOfLikes;

	public Post(String videoFileName, int numberOfLikes, String title)
	{
		this.videoFileName = videoFileName;
		this.numberOfLikes = numberOfLikes;
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getVideoFileName()
	{
		return videoFileName;
	}
	
	public int getNumberOfLikes()
	{
		return numberOfLikes;
	}

	public String toString()
	{
		return "Video File Name: "+ videoFileName + "\nNumber Of Likes: " + numberOfLikes + "\nTitle: " + title + "\n";
	}
}
