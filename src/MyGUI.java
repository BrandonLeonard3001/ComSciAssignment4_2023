// TokTik GUI
// 18-04-2023
// Brandon Leonard LNRBRA001

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.io.PrintStream;

/**
 * GUI for TokTik application
 * @author Brandon Leonard
 * @version 1.0.0
 */

public class MyGUI extends JFrame implements ActionListener {
    
    // Declare components
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    private JTextArea outputArea;
    public BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
    
    // Constructor
    public MyGUI() {

        // Initialize and configure the output window with a scroller (this is the output window for system.out.println() statements)
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(false);
        JScrollPane scrollPane = new JScrollPane(outputArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        outputArea.setPreferredSize(new Dimension(500, 50000));
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14)); // set font to Arial, size 14
        scrollPane.setPreferredSize(new Dimension(700, 400));
        PrintStream printStream = new PrintStream(new JTextAreaOutputStream(outputArea));
        System.setOut(printStream);


        // Set window properties
        setTitle("TokTik");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Initialize components
        btn1 = new JButton("Find Profile Description");
        btn2 = new JButton("List All Accounts");
        btn3 = new JButton("Create an Account");
        btn4 = new JButton("Delete an Account");
        btn5 = new JButton("Display All Posts");
        btn6 = new JButton("Add a New Post");
        btn7 = new JButton("Load a File of Actions");
        btn8 = new JButton("Quit");
        
        // Set button actions
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        
        // Set layout and add components
        setLayout(new FlowLayout());
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(scrollPane, BorderLayout.CENTER);
        
        // Show window
        setVisible(true);
    }
    
    
    /** 
     * Action performed to determine which button was pressed.
     * @param e
     */
    // Button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {    //Find Profile Description button clicked
            outputArea.setText("");     //Clear output area
            String accountName = JOptionPane.showInputDialog("Enter account name:");    //Grab input from user
            if (accountName != null)    //check if they hit cancel (cancel returns a null value)
            {
                System.out.println(TokTikUtility.findProfileDecription(accountName, BT));   //call our findProfileDescription method
            } else {
                System.out.println("Action Cancelled.");    //they hit the cancel button
            }
        } else if (e.getSource() == btn2) { //Show All Accounts button clicked
            outputArea.setText(""); //clear the output area
            BT.inOrder();   //use of inOrder traversal
            if (outputArea.getText().length() == 0) //check if the Binary Tree actually outputted anything
            {
                System.out.println("No Accounts Loaded");   //if it outputs nothing
            }
        } else if (e.getSource() == btn3) {     //Create New Account Button was clicked
            outputArea.setText("");     //Clear output text area
            String accountName = JOptionPane.showInputDialog("Enter account name:");        //gather the account name and profile description from the user
            String profileDescription = JOptionPane.showInputDialog("Enter profile description:");
            if ((accountName != null) && (profileDescription != null))  //check that they didnt hit the cancel button
            {
				TokTikUtility.createNewAccount(accountName, profileDescription, BT);    //create new account and add to BT

            } else {
                System.out.println("Account Creation Cancelled");   //they hit the cancel button
            }
        } else if (e.getSource() == btn4) {     //Delete Account button was clicked
            outputArea.setText("");             //Clear output text area
            String accountName = JOptionPane.showInputDialog("Enter account name:");    //grab accountName from user
            if (accountName != null)    // check that they didnt cancel
            {
                TokTikUtility.deleteAccount(accountName, BT);   //delete the account

            } else {
                System.out.println("Action Cancelled.");    //case for when they cancel
            }
        } else if (e.getSource() == btn5) { //Get all posts button clicked
            outputArea.setText("");     //clear output text area
            String accountName = JOptionPane.showInputDialog("Enter account name:");    //grab the account name from the user
            if (accountName != null){   //check that they didnt click cancel
                System.out.println(TokTikUtility.getAllPosts(accountName, BT)); //print all posts from the given account or print error msg if account doesnt exist
            } else {
                System.out.println("Action Cancelled.");    //case for when they click cancel
            }
        } else if (e.getSource() == btn6) {     //Create Post button was clicked
            outputArea.setText("");
            String accountName = JOptionPane.showInputDialog("Enter account name:");    //gather the relevant input from the user
            String videoFileName = JOptionPane.showInputDialog("Enter the video file name:");
            String numberOfLikes = JOptionPane.showInputDialog("Enter the number of likes:");
            String title = JOptionPane.showInputDialog("Enter the video title:");
            if ((accountName != null) && (videoFileName != null) && (numberOfLikes != null) && (title != null)) //check that they didnt cancel at some point
            {
                if (TokTikUtility.isNumeric(numberOfLikes)){    //check that number of likes entered was numeric
                    TokTikUtility.insterNewPost(accountName, BT, videoFileName, numberOfLikes, title);  //insert new post into the account or give error if account not found
                } else {
                    System.out.println("Please give a numeric value for number of likes :)");   //case for when numberOfLikes is not numeric
                }
            } else {
                System.out.println("Insertion of posts cancelled"); //case for when they hit cancel
            }
        } else if (e.getSource() == btn7) { //Process Actions from file button was clicked
            outputArea.setText(""); //clear output text area
            String fileName = JOptionPane.showInputDialog("Enter the file name:");  //get the file name 
            if (fileName != null)   //check that they didnt cancel
            {
                TokTikUtility.processData(fileName, BT);    //run our function which will do the rest incl handling other error types
            }else {
                System.out.println("Action loading cancelled.");    //case for when they cancel
            }
            
        } else if (e.getSource() == btn8) { //The Quit button was pressed
            outputArea.setText("");
            System.out.println("Bye!");
            System.exit(0); //close the app
        }
    }
}