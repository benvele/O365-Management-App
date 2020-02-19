import javax.swing.*;
import java.awt.*;

public class encryptionContent extends JPanel {

    public static JLabel mainContent = new JLabel("Main Content will Go Here");

    public encryptionContent()
    {
        setLayout(new GridLayout(1,1));

        mainContent.setBackground(Color.GRAY);
        mainContent.setForeground(Color.BLACK);

        add(mainContent);
    }
}
