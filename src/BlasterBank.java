import javax.swing.*;

public class BlasterBank extends JFrame {
    private final String name;
    private final String cOORDS;
    private final String cyberComm;
    private final String copyright;

    public BlasterBank( ) {
        this.name      = "Blaster Bank";
        this.cOORDS    = "Coordinates: X3665488, Y337, Z77884";
        this.cyberComm = TurboTypes.HOLOGRAM
                         + " Link:\n^Galax~Holo>BlasterBank<\n\n"
                         + TurboTypes.HYPERSPEECH
                         + ":\n{GALAX}-(888)552-6657\n\n"
                         + TurboTypes.VOIDMAIL
                         + ":\nBlasterBank@blasterbank*galax";
        this.copyright = this.getName() + "\n\nPowered by: CSC372 Software\nCopyright © 2022 BryanBlaze";
    }

    public String getName( ) { return name; }

    public String getcOORDS( ) { return cOORDS; }

    public String getCyberComm( ) { return cyberComm; }

    public String getCopyright( ) { return copyright; }

    @Override
    public String toString( ) {
        return this.getName() + "\n" + this.getcOORDS() + "\n\nCyber Communications:\n" + this.getCyberComm();
    }
}
