import javax.swing.*;
import java.awt.*;

public class encryptionMenuBar extends JPanel {

    JButton irmCheck = new JButton("Check IRM Config");
    JButton irmConfig = new JButton("Setup IRM");

    public encryptionMenuBar()
    {
        super();

        irmCheck.setBackground(Color.darkGray);
        irmCheck.setForeground(Color.WHITE);
        irmConfig.setBackground(Color.darkGray);
        irmConfig.setForeground(Color.WHITE);

        add(irmCheck);
        add(irmConfig);

    }


}
