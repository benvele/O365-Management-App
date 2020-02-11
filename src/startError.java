import javax.swing.*;

public class startError extends JFrame {

    public startError () {
        super ("ERROR: Powershell Module Does Not Exist");

        startErrorPanel errorPage = new startErrorPanel();
        getContentPane().add(errorPage, "Center");
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

}
