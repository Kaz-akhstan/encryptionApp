import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller {
    private view theView;
    private model theModel;
    public controller(view theView, model theModel) {
        this.theModel = theModel;
        this.theView = theView;

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setContentPane(theView.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

        this.theView.addCryptListener(new cryptListener());
    }

    private class cryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            String msg, key = "";
            msg = theView.getMessage();
            key = theView.getKey();
            theModel.encryptMessage(msg, key);
            System.out.println(msg + key);
            String s = "";
            for (int i = 0; i < theModel.CRYPT.length; i++) {
                s+= (char)theModel.CRYPT[i];
            }
            theView.setText(s);
        }
    }
}
