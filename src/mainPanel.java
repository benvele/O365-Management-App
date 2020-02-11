import javax.swing.*;
import java.awt.*;

public class mainPanel extends JPanel {
    String mainPanelTitle = "Nothing to Display Yet";
    String mainPanelContent = "Nothing to Display Yet";
    public mainPanelDisplay middle = new mainPanelDisplay(mainPanelTitle, mainPanelContent);
    public mainPanel()
    {
        super();
        setLayout(null);
        setBackground(Color.darkGray);

        menuBar top = new menuBar();
        top.setBounds(0,0,1600, 100);
        actionsList left = new actionsList();
        left.setBounds(0, 100, 400,700);
        middle.setBounds(400, 100, 1200, 700);

        add(top);
        add(left);
        add(middle);

    }


    public void refreshMiddle(String newTitle, String newContent)
    {
        middle = new mainPanelDisplay(newTitle,newContent);
        middle.repaint();
    }

}
