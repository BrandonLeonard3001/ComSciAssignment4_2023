// Post Class to Store the attributes of a Post for the TokTik App
// 18-04-2023
// Brandon Leoanrd LNRBRA001

public class Post {		

	String title;
	String videoFileName;
	int numberOfLikes;

	public Post(String videoFileName, int numberOfLikes, String title)	//Standard Contructor
	{
		this.videoFileName = videoFileName;
		this.numberOfLikes = numberOfLikes;
		this.title = title;
	}
	
	public String getTitle()	//Standard Getters and Setters
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

	public String toString()	//Standard ToString
	{
		return "Video File Name: "+ videoFileName + "\nNumber Of Likes: " + numberOfLikes + "\nTitle: " + title + "\n";
	}
}
