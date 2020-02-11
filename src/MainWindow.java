import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow ()
    {
        super ("Office 365 Management App");
        mainPanel mainWindow = new mainPanel();
        getContentPane().add(mainWindow, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1600,800);
        setVisible(true);
    }

}
