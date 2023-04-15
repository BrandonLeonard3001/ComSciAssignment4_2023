import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TokTikGUI implements ActionListener {

    private BinarySearchTree<Account> BT;
    private JFrame frame;
    private JTextField accountNameField;
    private String choice;

    public TokTikGUI() {
        BT = new BinarySearchTree<Account>();
        frame = new JFrame("TokTik");
        frame.setLayout(new FlowLayout());
        //String choice;

        // Add label and text field for entering account name
        JLabel accountNameLabel = new JLabel("Enter the account name:");
        frame.add(accountNameLabel);
        accountNameField = new JTextField(20);
        frame.add(accountNameField);

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
    }

    public String getChoice()
    {
        if (choice == null)
        {
            return "0";
        }
        else{
            return choice;
        }
    }
}