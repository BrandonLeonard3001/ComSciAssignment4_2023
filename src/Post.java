// Post Class to Store the attributes of a Post for the TokTik App
// 18-04-2023
// Brandon Leoanrd LNRBRA001
/**
 * Post Class
 * @author Brandon Leonard
 * @version 1.0.0
 */

public class Post {		

	String title;
	String videoFileName;
	int numberOfLikes;

	/**
	* Constructor for Post
	* @param videoFileName
	* @param numberOfLikes
	* @param title
	*/
	public Post(String videoFileName, int numberOfLikes, String title)	//Standard Contructor
	{
		this.videoFileName = videoFileName;
		this.numberOfLikes = numberOfLikes;
		this.title = title;
	}
	
	
	/** 
	 * Gets the title of a particular post
	 * @return String
	 */
	public String getTitle()	//Standard Getters and Setters
	{
		return title;
	}
	
	
	/** 
	 * Gets the video file name for a particular post
	 * @return String
	 */
	public String getVideoFileName()
	{
		return videoFileName;
	}
	
	
	/** 
	 * Gets the number of likes for a particular post
	 * @return int
	 */
	public int getNumberOfLikes()
	{
		return numberOfLikes;
	}

	
	/** 
	 * Gives a String version of the Post
	 * @return String
	 */
	public String toString()	//Standard ToString
	{
		return "Video File Name: "+ videoFileName + "\nNumber Of Likes: " + numberOfLikes + "\nTitle: " + title + "\n";
	}
}
