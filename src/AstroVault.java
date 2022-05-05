import javax.management.InvalidAttributeValueException;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AstroVault extends BlasterBank {
    private       String                vaultType;
    private       int                   vaultNum;
    private       double                balance;
    private final ArrayList<AstroVault> allVaults = new ArrayList<>();

    public AstroVault( ) {
        this.vaultType = "";
        this.vaultNum  = 1000;
        this.balance   = 0.00;
    }

    public AstroVault(String vType , int vNum , double vBal) {
        this.vaultType = vType;
        this.vaultNum  = vNum;
        this.balance   = round(vBal);
    }

    public void addVault(String vType , int vNum , double vBal) {
        try {
            if (round(vBal) > 0) {
                allVaults.add(new AstroVault(vType , vNum , round(vBal)));
                successMSG("Successfully added vault with" , "Added Astro Vault" , round(vBal));
            }
            else if (round(vBal) < .01) throw new InvalidAttributeValueException("Unable to create a vault that is 0 or less.");
        }
        catch (Throwable e) {
            warnMSG(e.getMessage() , "Unable to add Astro Vault!");
        }
    }

    public void removeVault(AstroVault tempVault) {
        boolean removed = false;
        try {
            for (int i = 0 ; i < allVaults.size() ; i++) {
                if (tempVault == allVaults.get(i) && round(tempVault.getBalance()) == 0) {
                    allVaults.remove(i);
                    removed = true;
                    successMSG("Successfully removed vault with" , "Removed Astro Vault" , round(tempVault.getBalance()));
                }
                else if (tempVault.getBalance() != 0) throw new InvalidAttributeValueException("Unable to remove "
                                                                                               + tempVault.getVaultType()
                                                                                               + " Vault ID "
                                                                                               + tempVault.getVaultNum()
                                                                                               + ", because the balance is not 0.");
            }
            if (allVaults.isEmpty() && !removed) throw new InvalidAttributeValueException("There are no vaults to remove.");
        }
        catch (Throwable e) {
            warnMSG(e.getMessage() , "Unable to remove Astro Vault!");
        }
    }

    // Warning Message
    public void warnMSG(String msg , String title) {
        JOptionPane.showMessageDialog(this.getParent() , msg , title , JOptionPane.WARNING_MESSAGE);
    }

    // Success Message
    public void successMSG(String msg , String title , double amt) {
        JOptionPane.showMessageDialog(this.getParent() , msg + " ₡" + round(amt) + " Credits" , title , JOptionPane.INFORMATION_MESSAGE);
    }

    // Round to Decimal
    protected double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2 , RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }

    public String getVaultType( ) { return vaultType; }

    public void setVaultType(String vaultType) { this.vaultType = vaultType; }

    public int getVaultNum( ) { return vaultNum; }

    public void setVaultNum(int vaultNum) { this.vaultNum = vaultNum; }

    public double getBalance( ) { return round(balance); }

    public void setBalance(double balance) { this.balance = round(balance); }

    public ArrayList<AstroVault> getAllVaults( ) { return allVaults; }

    public String printAllVaults( ) {
        String print = "";
        for (AstroVault vault: allVaults) {
            print = print.concat(vault.toString() + "\n\n");
        }
        return print;
    }

    @Override
    public String toString( ) {
        return "AstroVault: " + vaultType + ", Vault ID: " + vaultNum + ", Balance: ₡" + round(balance) + " Credits";
    }

}
