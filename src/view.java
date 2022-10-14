import javax.swing.*;

public class view {
    private JButton browseButton;
    private JTextField Filepath;
    private JRadioButton fromFileRadioButton;
    private JPanel panel;
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

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new view().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
