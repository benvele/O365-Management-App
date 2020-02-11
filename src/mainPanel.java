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
        add(top);

    }

}
