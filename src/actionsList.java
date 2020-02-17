import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionsList extends JPanel {

    public actionsList()
    {

        super ();
        GridLayout grid = new GridLayout(7, 1);
        setLayout(grid);
        setBackground(Color.GRAY);
        Border border = BorderFactory.createLineBorder(Color.darkGray);

        JButton action1 = new JButton("<html>Single User Password <br>Reset</html>"); //will make user password reset

        action1.setBorder(border);
        action1.setBackground(Color.GRAY);

        JButton action2 = new JButton("<html>Mass User Password <br>Reset</html>"); //will make mass user password reset

        action2.setBorder(border);
        action2.setBackground(Color.GRAY);

        JButton action3 = new JButton("Encryption Settings"); //Encryption Settings will open new window where IRM can be checked and setup
        action3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                encryptionWindow mainPane = new encryptionWindow();
            }
        });
        action3.setBorder(border);
        action3.setBackground(Color.GRAY);

        JButton action4 = new JButton("Action 4");

        action4.setBorder(border);
        action4.setBackground(Color.GRAY);

        JButton action5 = new JButton("Action 5");

        action5.setBorder(border);
        action5.setBackground(Color.GRAY);

        JButton action6 = new JButton("Action 6");

        action6.setBorder(border);
        action6.setBackground(Color.GRAY);

        JButton action7 = new JButton("Action 7");

        action7.setBorder(border);
        action7.setBackground(Color.GRAY);

        add(action1);
        add(action2);
        add(action3);
        add(action4);
        add(action5);
        add(action6);
        add(action7);

    }

}
