import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CosmicClient extends AstroVault {
    private int                     cosmicID      = 66211;
    private String                  userName;
    private String                  password;
    private String                  clientName;
    private String                  cosmicType;
    private String                  cOORDS;
    private String                  cyberCommType;
    private String                  cyberCommVal;
    private String                  cyberCommType2;
    private String                  cyberCommVal2;
    private ArrayList<CosmicClient> cosmicClients = new ArrayList<>();

    public CosmicClient( ) {
        super();
        this.cosmicID += 1;
        this.userName       = "";
        this.password       = "";
        this.clientName     = "";
        this.cosmicType     = "";
        this.cOORDS         = "";
        this.cyberCommType  = "";
        this.cyberCommVal   = "";
        this.cyberCommType2 = "";
        this.cyberCommVal2  = "";
    }

    public CosmicClient(
                        String userName ,
                        String password ,
                        String clientName ,
                        String cosmicType ,
                        String cOORDS ,
                        String cyberCommType ,
                        String cyberCommVal ,
                        String cyberCommType2 ,
                        String cyberCommVal2) {
        this.cosmicID += 1;
        this.userName       = userName;
        this.password       = password;
        this.clientName     = clientName;
        this.cosmicType     = cosmicType;
        this.cOORDS         = cOORDS;
        this.cyberCommType  = cyberCommType;
        this.cyberCommVal   = cyberCommVal;
        this.cyberCommType2 = cyberCommType2;
        this.cyberCommVal2  = cyberCommVal2;
    }

    public void addClient(CosmicClient client) {
        cosmicClients.add(client);
    }

    public boolean validateUsername(String userAlias) {
        for (CosmicClient cosmicClient:cosmicClients) {
            if (cosmicClient.getUserName().equalsIgnoreCase(userAlias)){
                return true;
            }
        }
        return false;
    }

    public boolean validateClient(String userAlias, String pw) {
        for (CosmicClient cosmicClient:cosmicClients) {
            if (cosmicClient.getUserName().equalsIgnoreCase(userAlias) && cosmicClient.getPassword().equals(pw)){
                return true;
            }
        }
        return false;
    }

    public String getClientName( ) { return clientName; }

    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getUserName( ) { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public int getCosmicID( ) { return cosmicID; }

    public void setCosmicID(int cosmicID) { this.cosmicID = cosmicID; }

    public String getPassword( ) { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getCosmicType( ) { return cosmicType; }

    public void setCosmicType(String cosmicType) { this.cosmicType = cosmicType; }

    public String getcOORDS( ) { return cOORDS; }

    public void setcOORDS(String cOORDS) { this.cOORDS = cOORDS; }

    public String getCyberCommType( ) { return cyberCommType; }

    public void setCyberCommType(String cyberCommType) { this.cyberCommType = cyberCommType; }

    public String getCyberCommVal( ) { return cyberCommVal; }

    public void setCyberCommVal(String cyberCommVal) { this.cyberCommVal = cyberCommVal; }

    public String getCyberCommType2( ) { return cyberCommType2; }

    public void setCyberCommType2(String cyberCommType2) { this.cyberCommType2 = cyberCommType2; }

    public String getCyberCommVal2( ) { return cyberCommVal2; }

    public void setCyberCommVal2(String cyberCommVal2) { this.cyberCommVal2 = cyberCommVal2; }

    public ArrayList<CosmicClient> getCosmicClients( ) { return cosmicClients; }

    public void setCosmicClients(ArrayList<CosmicClient> cosmicClients) { this.cosmicClients = cosmicClients; }


}
