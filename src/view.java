import javax.swing.*;
import java.awt.event.ActionListener;

public class view {
    private JButton browseButton;
    private JTextField Filepath;
    private JRadioButton fromFileRadioButton;
    public JPanel panel;
    private JRadioButton fromInput;
    private JTextField inputField;
    private JButton send1;
    private JLabel enterMsg;
    private JLabel enterKey;
    private JRadioButton fromFile2;
    private JTextField filePath2;
    private JButton browse2;
    private JRadioButton fromInput2;
    private JTextField fromKey2;
    private JButton send2;
    private JRadioButton msgEncrypted;
    private JRadioButton msgNotEncrypted;
    private JRadioButton saveToFile;
    private JRadioButton notSaveToFile;
    private JButton Save;
    private JTextField output;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setContentPane(new view().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }



    public String getMessage()
    {
        return inputField.getText();
    }

    public String getKey()
    {
        return fromKey2.getText();
    }

    public void setText(String msg)
    {
        output.setText(msg);
    }

    void addCryptListener(ActionListener listenForSave)
    {
        Save.addActionListener(listenForSave);
    }
}
