import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class menuBar extends JPanel {

    public JLabel banner1 = new JLabel("Not Logged In", SwingConstants.CENTER);

    public menuBar()
    {

        super();
        GridLayout grid = new GridLayout(1, 4);
        setLayout(grid);
        setBackground(Color.GRAY);
        Border border = BorderFactory.createLineBorder(Color.darkGray);

        banner1.setBorder(border);

        JButton logInAZBut = new JButton("Log In To Azure AD");
        logInAZBut.setBackground(Color.GRAY);
        logInAZBut.setBorder(border);
        logInAZBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PowerShell powerShell = PowerShell.openSession())
                {
                    PowerShellResponse connect = powerShell.executeCommand("Connect-AzureAD");
                    PowerShellResponse setVariable = powerShell.executeCommand("$tenant = Get-AzureADTenantDetail");
                    PowerShellResponse displayName = powerShell.executeCommand("$tenant.DisplayName");
                    PowerShellResponse users = powerShell.executeCommand("Get-AzureADUser | Select DisplayName,UserPrincipalName");
                    FileWriter newWriter = new FileWriter("users.txt");
                    newWriter.write(users.getCommandOutput());
                    newWriter.close();
                    banner1.setText("Logged in to: " + displayName.getCommandOutput());
                    mainPanelDisplay.mainContentTitle.setText("Users for " + displayName.getCommandOutput());
                    String newContent = "<html>";

                    BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
                    String line = reader.readLine();
                    while (line != null) {
                        newContent = newContent.concat(line);
                        newContent = newContent.concat("<br>");
                        line = reader.readLine();
                    }
                    reader.close();
                    newContent = newContent.concat("</html>");

                    mainPanelDisplay.mainContent.setText(newContent);

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
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
                    PowerShellResponse licensedUsers = powerShell.executeCommand("Get-MsolUser | Where-Object {$_.isLicensed -eq $True}");
                    FileWriter newWriter = new FileWriter("users.txt");
                    newWriter.write(licensedUsers.getCommandOutput());
                    newWriter.close();
                    banner1.setText("Logged in to: " + displayName.getCommandOutput());
                    String middleTitle = "Users for " + displayName.getCommandOutput();

                    String middleContent = "<html>";

                    BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
                    String line = reader.readLine();
                    while (line != null) {
                        middleContent = middleContent.concat(line);
                        middleContent = middleContent.concat("<br>");
                        line = reader.readLine();
                    }
                    reader.close();
                    middleContent = middleContent.concat("</html>");
                    mainPanelDisplay.mainContent.setText(middleContent);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
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
