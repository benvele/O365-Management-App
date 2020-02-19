import javax.swing.*;
import java.awt.*;

public class encryptionDisplay extends JPanel {



    public encryptionDisplay()
    {
        super();

        setLayout(new BorderLayout());

        encryptionMenuBar mainBar = new encryptionMenuBar();
        encryptionContent mainContent = new encryptionContent();

        add(mainBar,"North");
        add(mainContent, "Center");
    }

}
