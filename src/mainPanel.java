import javax.swing.*;
import java.awt.*;

public class mainPanel extends JPanel {

    public mainPanel()
    {
        super();
        setLayout(null);
        setBackground(Color.darkGray);
        menuBar top = new menuBar();
        top.setBounds(0, 0, 1600, 100);
        actionsList left = new actionsList();
        left.setBounds(0, 101, 400,700);
        add(top);
        add(left);

    }

}
