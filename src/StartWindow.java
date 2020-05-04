import javax.swing.*;

public class StartWindow extends JFrame {

    powershellSession psSession = new powershellSession();

    public StartWindow()
    {
        super ("Office 365 Management App");
        psSession.checkPSModules();
        StartMainPanel mainWindow = new StartMainPanel();
        getContentPane().add(mainWindow, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1600,840);
        setVisible(true);

    }

}
