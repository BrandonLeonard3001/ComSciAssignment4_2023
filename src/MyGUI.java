import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.io.PrintStream;

public class MyGUI extends JFrame implements ActionListener {
    
    // Declare components
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    private JTextArea outputArea;
    public BinarySearchTree<Account> BT = new BinarySearchTree<Account>();
    
    // Constructor
    public MyGUI() {

        // Initialize and configure the output window
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
    
    // Button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            outputArea.setText("");
            String accountName = JOptionPane.showInputDialog("Enter account name:");
            if (accountName != null)
            {
                System.out.println(TokTikUtility.findProfileDecription(accountName, BT));
            } else {
                System.out.println("Action Cancelled.");
            }
        } else if (e.getSource() == btn2) {
            outputArea.setText("");
            // store that button 2 was clicked
            BT.inOrder();
            if (outputArea.getText().length() == 0)
            {
                System.out.println("No Accounts Loaded");
            }
        } else if (e.getSource() == btn3) {
            outputArea.setText("");
            String accountName = JOptionPane.showInputDialog("Enter account name:");
            String profileDescription = JOptionPane.showInputDialog("Enter profile description:");
            if ((accountName != null) && (profileDescription != null))
            {
                if (TokTikUtility.accountExists(accountName, BT))
						{
							System.out.println("Account name already exists");
						} else {
							TokTikUtility.createNewAccount(accountName, profileDescription, BT);
							System.out.println("Account added");
						}
            } else {
                System.out.println("Account Creation Cancelled");
            }
            // store that button 3 was clicked and then ask for the account name and store the account name. 
            // It then needs to ask for the profile description and store that.
        } else if (e.getSource() == btn4) {
            outputArea.setText("");
            String accountName = JOptionPane.showInputDialog("Enter account name:");
            if (accountName != null)
            {
                TokTikUtility.deleteAccount(accountName, BT);
            } else {
                System.out.println("Action Cancelled.");
            }
            // store that button 4 was clicked and then ask for the account name and store that account name.
        } else if (e.getSource() == btn5) {
            outputArea.setText("");
            String accountName = JOptionPane.showInputDialog("Enter account name:");
            if (accountName != null){
                System.out.println(TokTikUtility.getAllPosts(accountName, BT));
            } else {
                System.out.println("Action Cancelled.");
            }

            // store that button 5 was clicked and then ask for the account name and store that account name.
        } else if (e.getSource() == btn6) {
            outputArea.setText("");
            String accountName = JOptionPane.showInputDialog("Enter account name:");
            String videoFileName = JOptionPane.showInputDialog("Enter the video file name:");
            String numberOfLikes = JOptionPane.showInputDialog("Enter the number of likes:");
            String title = JOptionPane.showInputDialog("Enter the video title:");
            if ((accountName != null) && (videoFileName != null) && (numberOfLikes != null) && (title != null))
            {
                if (TokTikUtility.isNumeric(numberOfLikes)){
                    TokTikUtility.insterNewPost(accountName, BT, videoFileName, numberOfLikes, title);
                } else {
                    System.out.println("Please give a numeric value for number of likes :)");
                }
            } else {
                System.out.println("Insertion of posts cancelled");
            }
            // store that button 6 was
        } else if (e.getSource() == btn7) {
            outputArea.setText("");
            // store that button 7 was
            String fileName = JOptionPane.showInputDialog("Enter the file name:");
            if (fileName != null)
            {
                TokTikUtility.processData(fileName, BT); 
            }else {
                System.out.println("Action loading cancelled.");
            }
            
        } else if (e.getSource() == btn8) {
            outputArea.setText("");
            // store that button 8 was
            System.out.println("Bye!");
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new MyGUI();
    }
}