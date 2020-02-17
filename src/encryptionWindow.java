import javax.swing.*;

public class encryptionWindow extends JFrame {

    public encryptionWindow()
    {
        super("Encryption Management Settings");
        encryptionDisplay mainEncrypt = new encryptionDisplay();
        getContentPane().add(mainEncrypt, "Center");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,800);
        setVisible(true);

    }

}
