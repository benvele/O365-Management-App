import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

public class powershellSession {

    PowerShell powerShell = PowerShell.openSession();

    public powershellSession()
    {

    }

    public void checkPSModules()
    {
        PowerShellResponse modCheck;
        modCheck = powerShell.executeSingleCommand("if ((Get-Module -ListAvailable -Name AzureAD) -and (Get-Module -ListAvailable -Name MSOnline)){ Write-Host 'Module exists'} else {Write-Host 'Module does not exist'}");

        if (modCheck.getCommandOutput().equals("Module does not exist"))
        {
            startError errorWindow = new startError();
        }

    }

}
