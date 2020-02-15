import javax.swing.*;
import java.awt.*;

public class mainPanel extends JPanel {

    public mainPanelDisplay middle = new mainPanelDisplay();
    public actionsList left = new actionsList();
    public menuBar top = new menuBar();
    public JSplitPane centerContent = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, middle);


    public mainPanel()
    {
        super();
        setLayout(new BorderLayout());
        setBackground(Color.darkGray);

        centerContent.setDividerSize(0);
        centerContent.setDividerLocation(150);


        add(top, "North");
        add(centerContent, "Center");

    }


}
