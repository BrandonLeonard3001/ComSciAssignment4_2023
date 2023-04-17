import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;


public class TokTikGUI implements ActionListener {

    private BinarySearchTree<Account> BT;
    private String accountName;
    private String profileDescription;
    private JFrame frame;
    private JTextField accountNameField;
    private String choice;
    private JTextArea outputArea;

    public TokTikGUI() {
        BT = new BinarySearchTree<Account>();
        frame = new JFrame("TokTik");
        frame.setLayout(new FlowLayout());
        //frame.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(false);
        outputArea.setWrapStyleWord(false);
        JScrollPane scrollPane = new JScrollPane(outputArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        outputArea.setPreferredSize(new Dimension(500, 100000));
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14)); // set font to Arial, size 14
        scrollPane.setPreferredSize(new Dimension(500, 400));

        PrintStream printStream = new PrintStream(new JTextAreaOutputStream(outputArea));
        System.setOut(printStream);
        //String choice;

        // Add button for finding profile description
        JButton button1 = new JButton("Find Profile Description");
        button1.setActionCommand("1");
        button1.addActionListener(this);
        frame.add(button1);

        // Add button for listing all accounts
        JButton button2 = new JButton("List All Accounts");
        button2.setActionCommand("2");
        button2.addActionListener(this);
        frame.add(button2);

        // Add button for creating an account
        JButton button3 = new JButton("Create an Account");
        button3.setActionCommand("3");
        button3.addActionListener(this);
        frame.add(button3);

        // Add button for deleting an account
        JButton button4 = new JButton("Delete an Account");
        button4.setActionCommand("4");
        button4.addActionListener(this);
        frame.add(button4);

        // Add button for displaying all posts for an account
        JButton button5 = new JButton("Display All Posts");
        button5.setActionCommand("5");
        button5.addActionListener(this);
        frame.add(button5);

        // Add button for adding a new post for an account
        JButton button6 = new JButton("Add a New Post");
        button6.setActionCommand("6");
        button6.addActionListener(this);
        frame.add(button6);

        // Add button for loading a file of actions
        JButton button7 = new JButton("Load a File of Actions");
        button7.setActionCommand("7");
        button7.addActionListener(this);
        frame.add(button7);

        // Add button for quitting the program
        JButton button8 = new JButton("Quit");
        button8.setActionCommand("8");
        button8.addActionListener(this);
        frame.add(button8);

        //frame.add(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }

    public static void main(String[] args) {
        new TokTikGUI();
    }

    public void actionPerformed(ActionEvent e) {
        choice = e.getActionCommand();
        //Scanner keyboard = new Scanner(System.in);
        switch (choice) {
			case "1":
			case "3":
			case "4":
			case "5":
			case "6":
            // Create a new JFrame for the text input window
            JFrame inputFrame = new JFrame("Enter Account Name");
                
            // Create a new JTextField
            JTextField textField = new JTextField();
            
            // Create a new JButton to submit the entered text
            JButton submitButton = new JButton("Submit");
            
            // Add an ActionListener to the submit button
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Get the text entered by the user
                    String text = textField.getText();
                    
                    // Do something with the entered text, such as store it in a variable or display it in a message dialog
                    //JOptionPane.showMessageDialog(null, "You entered: " + text);
                    accountName = text;

                    // Dispose of the inputFrame
                    inputFrame.dispose();
                

				//System.out.println("Enter the account name:");
				//String accountName = keyboard.nextLine();
				switch (choice){
					case "1":
						System.out.println(TokTikUtility.findProfileDecription(accountName, BT));
						//Account placeholder = new Account(accountName);
						//BinaryTreeNode<Account> node = BT.find(placeholder);
							//if (node != null) {
								//Account account = node.data;
								//String description = account.getProfileDescription();
								//System.out.println(description);
							//} else {
								//TO DO handle the case when accountName is not found in the BST
							//}
						break;
					case "3":
                        //need to get profile description somehow...
						if (TokTikUtility.accountExists(accountName, BT))
						{
							System.out.println("Account name already exists");
						} else {
							TokTikUtility.createNewAccount(accountName, profileDescription, BT);
							System.out.println("Account added");
						}
						break;
					case "4":
						//delete an account
						//Account placeholder = new Account(accountName);
						//BT.delete(placeholder);
						TokTikUtility.deleteAccount(accountName, BT);
						break;
					case "5":
						//get all the posts from a particular account
						Account placeholder = new Account(accountName);
						BinaryTreeNode<Account> node1 = BT.find(placeholder);
							if (node1 != null) {
								Account account = node1.data;
								System.out.println(account.getPosts());
								// maybe could setup case if the account has no posts?
							} else {
								//TO DO handle the case when accountName is not found in the BST
							}
						break;
					case "6":
						//insert a new post to an account
						placeholder = new Account(accountName);
						node1 = BT.find(placeholder);
						if (node1 != null) {
							Account account = node1.data;
							System.out.println("Please give the video file name:");
							//String videoFileName = keyboard.nextLine();
                            String videoFileName = "";
							System.out.println("Please give the number of likes:");
							//String numberOfLikes = keyboard.nextLine();
                            String numberOfLikes = "0";
							System.out.println("Please give the title:");
							//String title = keyboard.nextLine();
                            String title = "";
							Post post = new Post(videoFileName, Integer.parseInt(numberOfLikes), title);
							account.addPost(post);
						} else {
							//TO DO handle the case when accountName is not found in the BST
						}
					break;
				}
            }
            });
            
            // Add the JTextField and the submit button to the inputFrame
            inputFrame.getContentPane().add(textField);
            inputFrame.getContentPane().add(submitButton);
        
            // Set the layout and size of the inputFrame
            inputFrame.getContentPane().setLayout(new BoxLayout(inputFrame.getContentPane(), BoxLayout.Y_AXIS));
            inputFrame.setSize(200, 100);
        
            // Make the inputFrame visible
            inputFrame.setVisible(true);
			break;
			case "2":
				//List all accounts
				BT.inOrder();
				break;

			case "7":	
				//Load a file of actions from disk and process this
				try
				{	
					System.out.println("Please enter the file Name:");
					String fileName = "dataset.txt";
					File dataSet = new File(fileName);
					Scanner scanner = new Scanner(dataSet);
					
					while (scanner.hasNextLine())
					{
						String line = scanner.nextLine();
						//Also this is case 7
						String[] tokens = line.split(" ", 3);

						String action = tokens[0];
						accountName = tokens[1];
						if (action.equals("Create"))
						{
							String profileDescription = tokens[2];
							Account newAccount = new Account(accountName,profileDescription);
							BT.insert(newAccount);
						}
						else if (action.equals("Add"))
						{
							String[] remainder = tokens[2].split(" ",3);
							String videoFileName = remainder[0];
							String numberOfLikes = remainder[1];
							String title = remainder[2];
							Account placeholder = new Account(accountName);
							BinaryTreeNode<Account> node = BT.find(placeholder);
							if (node != null) {
								Account account = node.data;
								Post post = new Post(videoFileName,(Integer.parseInt(numberOfLikes)), title);
								if (account != null)
								{
									account.addPost(post);	
								}
							} else {
								System.out.println("account not found");
							}
							//add post to account
						}
					}
					scanner.close();
				} catch (FileNotFoundException f)
				{
					System.out.println("File not found!");
				}
				break;
			case "8":
				//keyboard.close();
				System.out.println("Bye!");
                System.exit(0);
				break;
			default:
				System.out.println("Please give valid input");
    }
}
}