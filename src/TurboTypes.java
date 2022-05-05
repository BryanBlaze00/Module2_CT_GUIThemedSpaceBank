
public enum TurboTypes {
    SAVINGS("Savings"), CHECKING("Checking"), DEPOSIT("Deposit"), WITHDRAW("Withdraw"), TRANSFER("Transfer"), ALIEN("Alien"), HUMANOID("Humanoid"), SPACEPIRATE("Space Pirate"), REPUBLICAN("Republican"), IMPERIAL("Imperial"), HOLOGRAM("Hologram"), HYPERSPEECH("Hyperspeech"), VOIDMAIL("VoidMail");

    private final String name;
    TurboTypes(String s) {
        name = s;
    }

    @Override
    public String toString( ) {
        return this.name;
    }
}
