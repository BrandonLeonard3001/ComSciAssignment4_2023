// Custom OutputStream Implementation
// 18-04-2023
// Brandon Leoanrd LNRBRA001

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

class JTextAreaOutputStream extends OutputStream {  // The class is to redirect the output stream to a JTextArea. In other words all System.out.println() will go to a JTextAre rather than the terminal
    private JTextArea textArea;

    public JTextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {   //Converts the byte b to a char and adds it to the JTextArea
        textArea.append(String.valueOf((char) b));
    }
}