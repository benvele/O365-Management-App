import javax.swing.*;
import java.awt.*;

public class encryptionDisplay extends JPanel {

    public static JButton irmCheck = new JButton("Check IRM Config");

    public encryptionDisplay()
    {
        super();

        setLayout(new BorderLayout());

        irmCheck.setBackground(Color.darkGray);
        irmCheck.setForeground(Color.WHITE);

        add(irmCheck,"North");
    }

}
