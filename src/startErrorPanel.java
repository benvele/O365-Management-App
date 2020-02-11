import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

import javax.swing.*;
import java.awt.*;

public class startErrorPanel extends JPanel {

    public startErrorPanel()
    {
        super();
        PowerShellResponse connect;
        connect = PowerShell.executeSingleCommand("if (Get-Module -ListAvailable -Name AzureAD, MSOnline){ Write-Host 'Module exists'}");

        GridLayout grid = new GridLayout(2,1);
        setLayout(grid);
        setBackground(Color.darkGray);
        JLabel errorMSG = new JLabel("ERROR: One or more required Powershell Modules are not Installed");
        errorMSG.setForeground(Color.RED);
        JLabel psResponse = new JLabel(connect.getCommandOutput() + ".");
        psResponse.setForeground(Color.RED);
        add(errorMSG);
        add(psResponse);

    }
}
