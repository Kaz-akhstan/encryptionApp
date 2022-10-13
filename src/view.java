import javax.swing.*;

public class view {
    private JButton browseButton;
    private JTextField Filepath;
    private JRadioButton fromFileRadioButton;
    private JPanel panel;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new view().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
