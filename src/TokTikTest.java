public class TokTikTest {
    
    public static void main(String[] args)
    {
        Post testPost1 = new Post("video1.mp4", 0, "Video1");
        System.out.println("Post1 created");
        System.out.println("The Video File of Post1 is: "+testPost1.getVideoFileName());
        System.out.println("The Number Of Likes for Post1 is: "+testPost1.getNumberOfLikes());
        System.out.println("The Title for Post1 is: "+testPost1.getTitle());
        System.out.println("Post1 is: "+testPost1.toString());
        System.out.println("Test for Post creation and methods complete\n");

        Account account1 = new Account("TestName","TestProfileDescription");
        System.out.println("The Account is:\n"+account1.toString());
        account1.addPost(testPost1);
        System.out.println("Added post to account1");
        System.out.println("The posts of account 1 are:\n"+account1.getPosts());
        Post testPost2 = new Post("video2.mp4",1,"Video2");
        account1.addPost(testPost2);
        System.out.println("Added another post to account1");
        System.out.println("The posts of account 1 are:\n"+account1.getPosts());
        System.out.println("Account Creation and method testing done\n");

        BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
        System.out.println("BinarySearchTree created");
        BT.insert(account1);
        System.out.println("Added account1 to BT");
        System.out.println("Displaying all Accounts in BT:");
        BT.inOrder();
        System.out.println("\nAdding more accounts to BT");
        Account account2 = new Account("account2","description2");
        Account account3 = new Account("account3","description3");
        BT.insert(account2);
        BT.insert(account3);
        System.out.println("All accounts in BT are:");
        BT.inOrder();
        System.out.println("\nBT with accounts testing complete\n");

        System.out.println("UtilityPack Testing:\n");
        System.out.println("First Method: findProfileDecription()");
        System.out.println("Finding the profile description for account1 from the BT:");
        System.out.println(TokTikUtility.findProfileDecription("TestName", BT));
        System.out.println("\nSecond Method: createNewAccount()");
        System.out.println("Creating and adding account to BT with account name: Jimmy\nProfile Decription: I like pineapples");
        TokTikUtility.createNewAccount("Jimmy", "I like pineapples", BT);
        System.out.println("Account created and added to BT");
        System.out.println("Checking if account exists in BT:");
        BT.inOrder();
        System.out.println("\nThird Method: deleteAccount()");
        System.out.println("Attempting to remove account Jimmy");
        TokTikUtility.deleteAccount("Jimmy",BT);
        System.out.println("Checking to see if account was removed:");
        BT.inOrder();
        System.out.println("\nFourth Method: getAllPosts()");
        System.out.println("Attempting to get all posts from account1(with name TestName)");
        System.out.println(TokTikUtility.getAllPosts("TestName", BT));
        System.out.println("Fith Method: insterNewPost()");
        System.out.println("Attempting to insert post with video3.mp4,23,video3 to account1 (with name TestName)");
        TokTikUtility.insterNewPost("TestName", BT, "video3.mp4", "24", "viedo3");
        System.out.println("Checking if new post was added by calling account.getPosts():");
        System.out.println(account1.getPosts());
        System.out.println("Sixth Method: accountExists()");
        System.out.println("Checking for account1 with name: TestName");
        System.out.println(TokTikUtility.accountExists("TestName", BT));
        System.out.println("Checking for an account that doesnt exist using account name Hussein:");
        System.out.println(TokTikUtility.accountExists("Hussein", BT));
        System.out.println("\nSeventh Method: isNumeric()\nThis method should only return true if the value is an integer and is greater than 0");
        System.out.println("Trying value: 1");
        System.out.println(TokTikUtility.isNumeric("1"));
        System.out.println("Trying value: 0");
        System.out.println(TokTikUtility.isNumeric("0"));
        System.out.println("Trying value: -1");
        System.out.println(TokTikUtility.isNumeric("-1"));
        System.out.println("Trying value: hello");
        System.out.println(TokTikUtility.isNumeric("hello"));
        System.out.println("Trying value: -1.1");
        System.out.println(TokTikUtility.isNumeric("1.1"));
        System.out.println("Trying value: 2.2");
        System.out.println(TokTikUtility.isNumeric("2.2"));
    }
}
