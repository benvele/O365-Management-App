import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class menuBar extends JPanel {

    public menuBar()
    {

        super();
        GridLayout grid = new GridLayout(1, 4);
        setLayout(grid);
        setBackground(Color.GRAY);
        Border border = BorderFactory.createLineBorder(Color.darkGray, 1);
        JLabel banner1 = new JLabel("Logged in as: ");
        banner1.setBounds(0,0,400,100);
        banner1.setBorder(border);
        JButton logInBut = new JButton("Log In");
        logInBut.setBackground(Color.GRAY);
        logInBut.setBounds(401,0,400,100);
        logInBut.setBorder(border);
        JButton logOutBut = new JButton("Log Out");
        logOutBut.setBackground(Color.GRAY);
        logOutBut.setBounds(801,0,400,100);
        logOutBut.setBorder(border);
        JLabel blankLabel1 = new JLabel();
        blankLabel1.setBounds(1201,0,400,100);
        blankLabel1.setBorder(border);
        add(banner1);
        add(logInBut);
        add(logOutBut);
        add(blankLabel1);

    }


}
