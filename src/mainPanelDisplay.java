import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class mainPanelDisplay extends JPanel {

    public static JLabel mainContentTitle = new JLabel("Nothing to display yet!");
    public static JLabel mainContent = new JLabel("Nothing to display yet!");
    JScrollPane mainScroller = new JScrollPane(mainContent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public mainPanelDisplay()
    {
        super();
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);

        mainContentTitle.setForeground(Color.WHITE);
        mainContentTitle.setBorder(border);

        mainContent.setForeground(Color.BLACK);


        add(mainContentTitle, "North");
        add(mainScroller, "Center");

    }

}
