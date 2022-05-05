import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TeleTransaction extends AstroVault {
    private       int                        vaultID;
    private       int                        transID;
    private       String                     transType;
    private       String                     date;
    private       double                     amount;
    private final ArrayList<TeleTransaction> teleTransactions = new ArrayList<>();

    public TeleTransaction( ) {
        this.vaultID   = 0;
        this.transID   = 0;
        this.transType = "";
        this.date      = getNow();
        this.amount    = 0.00;
    }

    public TeleTransaction(int vaultID , int tID , String tType , String now , double amt) {
        this.vaultID   = vaultID;
        this.transID   = tID;
        this.transType = tType;
        this.date      = now;
        this.amount    = round(amt);
    }

    // Make a transaction
    private TeleTransaction makeTransAct(int vaultID , String tType , String now , double amt) {
        this.transID += 1;
        return new TeleTransaction(vaultID , transID , tType , now , round(amt));
    }

    public void deposit(AstroVault vault , double amt) {
        try {
            if (vault.getBalance() + round(amt) > 0) {
                vault.setBalance(vault.getBalance() + round(amt));
                successMSG("You successfully deposited:" , "Confirmation" , round(amt));
                teleTransactions.add(makeTransAct(vault.getVaultNum() , TurboTypes.DEPOSIT.toString() , getNow() , round(amt)));
            }
            else if (vault.getBalance() + round(amt) < 0)
                throw new ArithmeticException("Unable to deposit an amount that will bring the balance to negative.");
        }
        catch (Throwable e) {
            warnMSG(e.getMessage() , "The Balance can't be Negative!");
        }
    }

    public void withdraw(AstroVault vault , double amt) {
        try {
            if (vault.getBalance() - round(amt) >= 0) {
                vault.setBalance(vault.getBalance() - round(amt));
                successMSG("You successfully withdrew:" , "Confirmation" , round(amt));
                teleTransactions.add(makeTransAct(vault.getVaultNum() , TurboTypes.WITHDRAW.toString() , getNow() , round(amt)));
            }
            else if (vault.getBalance() - round(amt) < 0)
                throw new ArithmeticException("Unable to withdraw an amount that will bring the balance to negative.");
        }
        catch (Throwable e) {
            warnMSG(e.getMessage() , "The Balance can't be Negative!");
        }
    }

    public void transfer(AstroVault fromVault , AstroVault targetVault , double amt) {
        try {
            if (round(fromVault.getBalance()) - round(amt) >= 0 && round(targetVault.getBalance()) + round(amt) > 0) {
                fromVault.setBalance(fromVault.getBalance() - round(amt));
                targetVault.setBalance(targetVault.getBalance() + round(amt));
                successMSG("You successfully transferred:" , "Confirmation" , round(amt));
                teleTransactions.add(makeTransAct(fromVault.getVaultNum() , TurboTypes.TRANSFER.toString() , getNow() , round(amt)));
                teleTransactions.add(makeTransAct(targetVault.getVaultNum() , TurboTypes.TRANSFER.toString(), getNow() , round(amt)));
            }
            else if (fromVault.getBalance() - round(amt) < 0 || round(targetVault.getBalance()) + round(amt) < 0)
                throw new ArithmeticException("Unable to transfer an amount that will bring either vault balance to negative.");
        }
        catch (Throwable e) {
            warnMSG(e.getMessage() , "The Balance can't be Negative!");
        }
    }

    // Get Time Now
    protected String getNow( ) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public int getTransID( ) { return transID; }

    public void setTransID(int transID) { this.transID = transID; }

    public String getTransType( ) { return transType; }

    public void setTransType(String transType) { this.transType = transType; }

    public String getDate( ) { return date; }

    public void setDate(String now) { this.date = now; }

    public double getAmount( ) { return round(amount); }

    public void setAmount(double amount) { this.amount = round(amount); }

    public int getVaultID( ) { return vaultID; }

    public void setVaultID(int vaultID) { this.vaultID = vaultID; }

    public ArrayList<TeleTransaction> getTeleTransactions( ) { return teleTransactions; }

    // Prints all Transactions
    public String printAllTransActs(int vaultID) {
        String print = "";
        for (TeleTransaction transActs: teleTransactions) {
            if (transActs.getVaultID() == vaultID){
                print = print.concat(transActs + "\n");
            }
        }
        return print;
    }

    @Override
    public String toString( ) {
        return "TeleTransaction: "
               + "Vault ID: "
               + getVaultID()
               + ", ID: "
               + getTransID()
               + ", Type: "
               + getTransType()
               + ", Date: "
               + getDate()
               + ", Amount: ₡"
               + round(getAmount())
               + " Credits";
    }
}
