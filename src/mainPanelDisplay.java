import javax.swing.*;
import java.awt.*;

class mainPanelDisplay extends JPanel {

    public mainPanelDisplay(String title, String content)
    {
        super();
        setLayout(null);
        setBackground(Color.BLACK);

        JLabel mainContentTitle = new JLabel(title);
        mainContentTitle.setBounds(0,0,1200, 50);
        mainContentTitle.setForeground(Color.WHITE);
        JLabel mainContent = new JLabel(content);
        mainContent.setBounds(0,50,1200, 650);
        mainContent.setForeground(Color.WHITE);

        add(mainContentTitle);
        add(mainContent);

    }

}
