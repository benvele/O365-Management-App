import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow ()
    {
        super ("Office 365 Management App");
        PowerShellResponse connect = PowerShell.executeSingleCommand("if ((Get-Module -ListAvailable -Name AzureAD) -and (Get-Module -ListAvailable -Name MSOnline)){ Write-Host 'Module exists'} else {Write-Host 'Module does not exist'}");
        mainPanel mainWindow = new mainPanel();
        getContentPane().add(mainWindow, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1600,840);
        setVisible(true);

        if (connect.getCommandOutput().equals("Module does not exist"))
        {
            startError errorWindow = new startError();
        }
    }

}
