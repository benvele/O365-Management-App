import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

public class exchangeLogin {

    public exchangeLogin() {

        try (PowerShell powerShell = PowerShell.openSession())
        {
            PowerShellResponse response = powerShell.executeCommand("Connect-MsolService");


        }

    }

}
