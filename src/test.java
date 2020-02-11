import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static java.awt.Color.*;

public class test extends JPanel {


    public test()
    {
        super();
        setLayout(null);
        setBackground(GRAY);


        Border border = BorderFactory.createLineBorder(Color.darkGray);
        JLabel mainContentTitle = new JLabel("Not currently logged in");
        mainContentTitle.setBackground(BLACK);
        mainContentTitle.setBorder(border);
        mainContentTitle.setBounds(400,100,1200,50);
        mainContentTitle.setForeground(WHITE);
        JLabel mainContent = new JLabel("Nothing to Display Yet!");
        JScrollPane mainScroller = new JScrollPane(mainContent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainScroller.setBounds(400,150,1200,650);
        JLabel banner1 = new JLabel("Not Logged In", SwingConstants.CENTER);
        banner1.setBackground(GRAY);
        banner1.setBounds(0,0,400,100);
        banner1.setBorder(border);
        JButton logInAZBut = new JButton("Log In To Azure AD");
        logInAZBut.setBackground(GRAY);
        logInAZBut.setBounds(400,0,400,100);
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
                    String newTitle = "Users for " + displayName.getCommandOutput();
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

                    mainContentTitle.setText(newTitle);
                    mainContent.setText(newContent);


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton logInEXBut = new JButton("Log In to Exchange Online");
        logInEXBut.setBackground(GRAY);
        logInEXBut.setBounds(800,0,400,100);
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
                    banner1.setText("Logged in to: " + displayName.getCommandOutput());
                    String middleTitle = "Users for " + displayName.getCommandOutput();
                    FileWriter newWriter = new FileWriter("users.txt");
                    newWriter.write(licensedUsers.getCommandOutput());
                    newWriter.close();
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

                    mainContentTitle.setText(middleTitle);
                    mainContent.setText(middleContent);


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton logOutBut = new JButton("Log Out");
        logOutBut.setBounds(1200,0,400,100);
        logOutBut.setBorder(border);
        logOutBut.setBackground(GRAY);
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

        JButton action1 = new JButton("Action 1");
        action1.setBounds(0, 100,400, 100);
        action1.setBorder(border);
        action1.setBackground(GRAY);

        JButton action2 = new JButton("Action 2");
        action2.setBounds(0, 200,400, 100);
        action2.setBorder(border);
        action2.setBackground(GRAY);

        JButton action3 = new JButton("Action 3");
        action3.setBounds(0, 300,400, 100);
        action3.setBorder(border);
        action3.setBackground(GRAY);

        JButton action4 = new JButton("Action 4");
        action4.setBounds(0, 400,400, 100);
        action4.setBorder(border);
        action4.setBackground(GRAY);

        JButton action5 = new JButton("Action 5");
        action5.setBounds(0, 500,400, 100);
        action5.setBorder(border);
        action5.setBackground(GRAY);

        JButton action6 = new JButton("Action 6");
        action6.setBounds(0, 600,400, 100);
        action6.setBorder(border);
        action6.setBackground(GRAY);

        JButton action7 = new JButton("Action 7");
        action7.setBounds(0, 700,400, 100);
        action7.setBorder(border);
        action7.setBackground(GRAY);


        add(banner1);
        add(logInAZBut);
        add(logInEXBut);
        add(logOutBut);
        add(mainContentTitle);
        add(mainScroller);
        add(action1);
        add(action2);
        add(action3);
        add(action4);
        add(action5);
        add(action6);
        add(action7);

    }
}
