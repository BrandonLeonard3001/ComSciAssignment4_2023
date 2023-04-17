import static org.junit.Assert.*;
import org.junit.Test;

public class TokTikUtilityTest {

    @Test
    public void testFindProfileDescription() {
        BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
        Account account1 = new Account("user1", "This is user 1's profile.");
        Account account2 = new Account("user2", "This is user 2's profile.");
        BT.insert(account1);
        BT.insert(account2);
        assertEquals("This is user 1's profile.", TokTikUtility.findProfileDecription("user1", BT));
        assertEquals("This is user 2's profile.", TokTikUtility.findProfileDecription("user2", BT));
        assertEquals("Cannot Find Account", TokTikUtility.findProfileDecription("user3", BT));
    }

    @Test
    public void testCreateNewAccount() {
        BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
        TokTikUtility.createNewAccount("user1", "This is user 1's profile.", BT);
        assertTrue(TokTikUtility.accountExists("user1", BT));
        assertEquals("This is user 1's profile.", TokTikUtility.findProfileDecription("user1", BT));
        TokTikUtility.createNewAccount("user1", "This is a new description.", BT);
        assertEquals("This is user 1's profile.", TokTikUtility.findProfileDecription("user1", BT));
    }

    @Test
    public void testDeleteAccount() {
        BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
        TokTikUtility.createNewAccount("user1", "This is user 1's profile.", BT);
        assertTrue(TokTikUtility.accountExists("user1", BT));
        TokTikUtility.deleteAccount("user1", BT);
        assertFalse(TokTikUtility.accountExists("user1", BT));
    }

    @Test
    public void testGetAllPosts() {
        BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
        Account account1 = new Account("user1", "This is user 1's profile.");
        Account account2 = new Account("user2", "This is user 2's profile.");
        account1.addPost(new Post("video1.mp4", 10, "Video 1"));
        account2.addPost(new Post("video2.mp4", 5, "Video 2"));
        BT.insert(account1);
        BT.insert(account2);
        assertEquals("Video 1 (10 likes)\n", TokTikUtility.getAllPosts("user1", BT));
        assertEquals("Video 2 (5 likes)\n", TokTikUtility.getAllPosts("user2", BT));
        assertEquals("No Account found", TokTikUtility.getAllPosts("user3", BT));
    }

    @Test
    public void testInsterNewPost() {
        BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
        Account account1 = new Account("user1", "This is user 1's profile.");
        BT.insert(account1);
        TokTikUtility.insterNewPost("user1", BT, "video1.mp4", "10", "Video 1");
        assertEquals("Video 1 (10 likes)\n", account1.getPosts());
        TokTikUtility.insterNewPost("user2", BT, "video1.mp4", "10", "Video 1");
        assertEquals("", account1.getPosts());
    }
}