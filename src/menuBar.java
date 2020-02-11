import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBar extends JPanel {

    public menuBar()
    {

        super();
        GridLayout grid = new GridLayout(1, 4);
        setLayout(grid);
        setBackground(Color.GRAY);
        Border border = BorderFactory.createLineBorder(Color.darkGray);
        JLabel banner1 = new JLabel("Not Logged In", SwingConstants.CENTER);
        banner1.setBounds(0,0,400,100);
        banner1.setBorder(border);
        JButton logInAZBut = new JButton("Log In To Azure AD");
        logInAZBut.setBackground(Color.GRAY);
        logInAZBut.setBounds(401,0,400,100);
        logInAZBut.setBorder(border);
        logInAZBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PowerShell powerShell = PowerShell.openSession())
                {
                    PowerShellResponse connect = powerShell.executeCommand("Connect-AzureAD");
                    PowerShellResponse setVariable = powerShell.executeCommand("$tenant = Get-AzureADTenantDetail");
                    PowerShellResponse displayName = powerShell.executeCommand("$tenant.DisplayName");
                    banner1.setText("Logged in to: " + displayName.getCommandOutput());
                }
            }
        });
        JButton logInEXBut = new JButton("Log In to Exchange Online");
        logInEXBut.setBackground(Color.GRAY);
        logInEXBut.setBounds(801,0,400,100);
        logInEXBut.setBorder(border);
        logInEXBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PowerShell powerShell = PowerShell.openSession())
                {
                    PowerShellResponse response = powerShell.executeCommand("Connect-MsolService");
                    PowerShellResponse setVariable = powerShell.executeCommand("$tenant = Get-AzureADTenantDetail");
                    PowerShellResponse displayName = powerShell.executeCommand("$tenant.DisplayName");
                    banner1.setText("Logged in to: " + displayName.getCommandOutput());
                }
            }
        });
        JButton logOutBut = new JButton("Log Out");
        logOutBut.setBounds(1201,0,400,100);
        logOutBut.setBorder(border);
        logOutBut.setBackground(Color.GRAY);
        logOutBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PowerShell powerShell = PowerShell.openSession())
                {
                    PowerShellResponse response = powerShell.executeCommand("Get-PSSession | Remove-PSSession");
                    banner1.setText("Not Logged In");
                }
            }
        });
        add(banner1);
        add(logInAZBut);
        add(logInEXBut);
        add(logOutBut);

    }


}
