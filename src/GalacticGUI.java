import javax.naming.directory.InvalidAttributeValueException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GalacticGUI extends JFrame implements ActionListener {
    private final BlasterBank       bBank     = new BlasterBank();
    private final AstroVault        aVault    = new AstroVault();
    private final TeleTransaction   teleTrans = new TeleTransaction();
    private final CosmicClient      cClient;
    private final JMenuBar          jmb       = new JMenuBar();
    private final JPanel            mainPanel = new JPanel(new BorderLayout());
    private final JTextArea         transJTA  = new JTextArea(15 , 15);
    private final JComboBox<Object> comboBox  = new JComboBox<>(aVault.getAllVaults().toArray());

    public GalacticGUI(CosmicClient user) {
        cClient = user;
        initComponents();
    }

    private void initComponents( ) {
        //Menu Bar
        initMenuBar();
        this.setJMenuBar(jmb);
        this.getContentPane().add(mainPanel , BorderLayout.CENTER);

        //Top Panel
        JPanel topPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel , BorderLayout.NORTH);
        topPanel.setPreferredSize(new Dimension(450 , 260));
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setVisible(true);
        JPanel comboPanelTop = new JPanel(new FlowLayout());
        topPanel.add(comboPanelTop , BorderLayout.NORTH);
        comboPanelTop.setBackground(Color.LIGHT_GRAY);
        comboPanelTop.setVisible(true);
        JLabel pickCombo = new JLabel("View Astro Vault:");
        comboPanelTop.add(pickCombo , BorderLayout.NORTH);
        pickCombo.setVisible(true);
        JPanel comboPanel = new JPanel();
        comboPanelTop.add(comboPanel , BorderLayout.NORTH);
        comboPanel.setPreferredSize(new Dimension(600 , 30));
        comboPanel.setBackground(Color.LIGHT_GRAY);
        comboPanel.setVisible(true);
        comboPanel.add(comboBox);
        comboBox.setPreferredSize(new Dimension(600 , 25));
        comboBox.setVisible(true);

        //Right Panel
        JPanel rightPanel = new JPanel(new GridLayout(4 , 2));
        topPanel.add(rightPanel , BorderLayout.EAST);
        rightPanel.setPreferredSize(new Dimension(300 , 250));
        rightPanel.setVisible(true);
        JButton addBTN = new JButton("Add Vault");
        JButton remBTN = new JButton("Remove Vault");
        JButton depositBTN = new JButton("Make a Deposit");
        JButton withdrawBTN = new JButton("Make a Withdraw");
        JButton transferBTN = new JButton("Make a Transfer");
        JButton printBTN = new JButton("Print All Vaults");
        JButton supportBTN = new JButton("Contact Support");
        JButton exitBTN = new JButton("Exit");
        rightPanel.add(addBTN);
        rightPanel.add(remBTN);
        rightPanel.add(depositBTN);
        rightPanel.add(withdrawBTN);
        rightPanel.add(transferBTN);
        rightPanel.add(printBTN);
        rightPanel.add(supportBTN);
        rightPanel.add(exitBTN);
        addBTN.setVisible(true);
        remBTN.setVisible(true);
        depositBTN.setVisible(true);
        withdrawBTN.setVisible(true);
        transferBTN.setVisible(true);
        printBTN.setVisible(true);
        exitBTN.setVisible(true);
        supportBTN.setVisible(true);
        addBTN.addActionListener(this);
        remBTN.addActionListener(this);
        depositBTN.addActionListener(this);
        withdrawBTN.addActionListener(this);
        transferBTN.addActionListener(this);
        printBTN.addActionListener(this);
        supportBTN.addActionListener(this);
        exitBTN.addActionListener(this);

        //Center Panel
        JPanel centerPanel = new JPanel(new FlowLayout());
        topPanel.add(centerPanel , BorderLayout.CENTER);
        centerPanel.setBackground(Color.GRAY);
        centerPanel.setVisible(true);
        //Left Center
        JPanel leftCenterPanel = new JPanel();
        BoxLayout bl = new BoxLayout(leftCenterPanel , BoxLayout.Y_AXIS);
        leftCenterPanel.setLayout(bl);
        leftCenterPanel.setBackground(Color.GRAY);
        centerPanel.add(leftCenterPanel);
        leftCenterPanel.setPreferredSize(new Dimension(225 , 210));
        leftCenterPanel.setVisible(true);
        JLabel leftName = new JLabel(cClient.getClientName());
        JLabel leftID = new JLabel(String.valueOf(cClient.getCosmicID()));
        JLabel leftType = new JLabel(cClient.getCosmicType());
        JLabel leftCOORDS = new JLabel(cClient.getcOORDS());
        JLabel leftCommType = new JLabel(cClient.getCyberCommType());
        JLabel leftComVal = new JLabel(cClient.getCyberCommVal());
        JLabel leftCommType2 = new JLabel(cClient.getCyberCommType());
        JLabel leftComVal2 = new JLabel(cClient.getCyberCommVal());
        leftCenterPanel.add(leftName);
        leftCenterPanel.add(leftID);
        leftCenterPanel.add(leftType);
        leftCenterPanel.add(leftCOORDS);
        leftCenterPanel.add(leftCommType);
        leftCenterPanel.add(leftComVal);
        leftCenterPanel.add(leftCommType2);
        leftCenterPanel.add(leftComVal2);
        leftName.setFont(new Font(Font.SERIF , Font.BOLD , 25));
        leftID.setFont(new Font(Font.SERIF , Font.PLAIN , 20));
        leftType.setFont(new Font(Font.SERIF , Font.PLAIN , 20));
        leftCOORDS.setFont(new Font(Font.SERIF , Font.PLAIN , 18));
        leftCommType.setFont(new Font(Font.SERIF , Font.PLAIN , 14));
        leftComVal.setFont(new Font(Font.SERIF , Font.PLAIN , 14));
        leftCommType2.setFont(new Font(Font.SERIF , Font.PLAIN , 14));
        leftComVal2.setFont(new Font(Font.SERIF , Font.PLAIN , 14));

        //Right Center
        JPanel rightCenterPanel = new JPanel();
        BoxLayout bl2 = new BoxLayout(rightCenterPanel , BoxLayout.Y_AXIS);
        rightCenterPanel.setLayout(bl2);
        rightCenterPanel.setBackground(Color.GRAY);
        centerPanel.add(rightCenterPanel);
        rightCenterPanel.setPreferredSize(new Dimension(225 , 210));
        rightCenterPanel.setVisible(true);
        JLabel rightTitle = new JLabel();
        JLabel rightType = new JLabel();
        JLabel rightID = new JLabel();
        JLabel rightBal = new JLabel();
        JLabel rightCred = new JLabel();
        rightCenterPanel.add(rightTitle);
        rightTitle.setFont(new Font(Font.SERIF , Font.BOLD , 35));
        rightTitle.setVisible(true);
        rightCenterPanel.add(rightType);
        rightType.setFont(new Font(Font.SERIF , Font.PLAIN , 30));
        rightType.setVisible(true);
        rightCenterPanel.add(rightID);
        rightID.setFont(new Font(Font.SERIF , Font.PLAIN , 30));
        rightID.setVisible(true);
        rightCenterPanel.add(rightBal);
        rightBal.setFont(new Font(Font.SERIF , Font.PLAIN , 25));
        rightBal.setVisible(true);
        rightCenterPanel.add(rightCred);
        rightCred.setFont(new Font(Font.SERIF , Font.PLAIN , 25));
        rightCred.setVisible(true);
        //Change label values
        comboBox.addActionListener(e -> {
            AstroVault temp = (AstroVault) comboBox.getSelectedItem();
            if (temp != null) {
                rightTitle.setText("Astro Vault:");
                rightType.setText(temp.getVaultType());
                rightID.setText(String.valueOf(temp.getVaultNum()));
                rightBal.setText("₡" + temp.getBalance());
                rightCred.setText("Credits");
            }
        });

        // Scrolling JTA
        transJTA.setEditable(false);
        transJTA.setLineWrap(true);
        transJTA.setVisible(true);
        JScrollPane bottomPane = new JScrollPane(transJTA);
        mainPanel.add(bottomPane , BorderLayout.SOUTH);
        bottomPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        bottomPane.setWheelScrollingEnabled(true);
        bottomPane.setVisible(true);
        mainPanel.setPreferredSize(new Dimension(800 , 500));
        mainPanel.setVisible(true);

        //Frame
        this.setTitle("Blaster Bank");
        this.setLocation(600 , 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.revalidate();
    }

    private void initMenuBar( ) {
        JMenu accountJM = new JMenu("Account");
        jmb.add(accountJM);
        JMenuItem profileJMI = new JMenuItem("");
        JMenuItem logoffJMI = new JMenuItem("Log Off");
        JMenuItem exitJMI = new JMenuItem("Exit");
        accountJM.add(profileJMI);
        profileJMI.addActionListener(this);
        accountJM.add(logoffJMI);
        accountJM.addSeparator();
        accountJM.add(exitJMI);
        exitJMI.addActionListener(this); // Close App
        logoffJMI.addActionListener(this);

        JMenu vaultsJM = new JMenu("Vaults");
        jmb.add(vaultsJM);
        JMenuItem addV = new JMenuItem("Add Vault");
        JMenuItem remV = new JMenuItem("Remove Vault");
        JMenuItem printV = new JMenuItem("Print All Vaults");
        vaultsJM.add(addV);
        vaultsJM.add(remV);
        vaultsJM.addSeparator();
        vaultsJM.add(printV);
        addV.addActionListener(this);
        remV.addActionListener(this);
        printV.addActionListener(this);

        JMenu transactionJM = new JMenu("Transaction");
        jmb.add(transactionJM);
        JMenuItem depositJMI = new JMenuItem("Make a Deposit");
        JMenuItem withdrawJMI = new JMenuItem("Make a Withdraw");
        JMenuItem transferJMI = new JMenuItem("Make a Transfer");
        transactionJM.add(depositJMI);
        transactionJM.add(withdrawJMI);
        transactionJM.add(transferJMI);
        depositJMI.addActionListener(this);
        withdrawJMI.addActionListener(this);
        transferJMI.addActionListener(this);

        JMenu helpJM = new JMenu("Help");
        jmb.add(helpJM);
        JMenuItem supportJMI = new JMenuItem("Contact Support");
        JMenuItem aboutJMI = new JMenuItem("About");
        helpJM.add(supportJMI);
        helpJM.add(aboutJMI);
        supportJMI.addActionListener(this);
        aboutJMI.addActionListener(this);
    }

    //Ask For Vault Message
    protected AstroVault askForVault(String msg , String title) {
        return (AstroVault) JOptionPane.showInputDialog(this ,
                                                        msg ,
                                                        title ,
                                                        JOptionPane.QUESTION_MESSAGE ,
                                                        null ,
                                                        aVault.getAllVaults().toArray() ,
                                                        null);
    }

    //Ask for amount message
    protected String askForAmt(String msg , String title) {
        return JOptionPane.showInputDialog(this , msg , title , JOptionPane.QUESTION_MESSAGE);
    }

    //Clear and Print to JTA
    protected void printJTA(String info) {
        transJTA.setText("");
        transJTA.append(info);
    }

    //Clear and Print to JTAx2
    protected void printJTA(String info , String info2) {
        transJTA.setText("");
        transJTA.append(info + "\n");
        transJTA.append(info2);
    }

    //Clear and Print to JTAx4
    protected void printJTA(String info , String info2 , String info3 , String info4) {
        transJTA.setText("");
        transJTA.append(info + "\n");
        transJTA.append(info2 + "\n");
        transJTA.append(info3 + "\n");
        transJTA.append(info4);
    }

    //Clear and Print all vaults and all transactions
    protected void printJTA( ) {
        try {
            if (aVault.getAllVaults().size() >= 1) {
                transJTA.setText("");
                for (AstroVault vault: aVault.getAllVaults()) {
                    transJTA.append(vault + "\n");
                    transJTA.append(teleTrans.printAllTransActs(vault.getVaultNum()) + "\n");
                }
            }
            else if (aVault.getAllVaults().size() < 1) throw new InvalidAttributeValueException("You need to have at least 1 vault to print.");
        }
        catch (Throwable e) {
            aVault.warnMSG(e.getMessage() , "Cancelled");
        }
    }

    private void updateCombo( ) {
        comboBox.removeAllItems();
        for (AstroVault vault: aVault.getAllVaults()) {
            comboBox.addItem(vault);
        }
    }

    // Round to Decimal
    protected double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2 , RoundingMode.HALF_EVEN);
        return bd.doubleValue();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JComponent source = (JComponent) ae.getSource();
        AstroVault tempVault;
        String vType;
        int vNum;
        double vAmt;
        String amtTemp;

        switch (source.getAccessibleContext().getAccessibleName()) {
            case "Log In":

                break;
            case "Log Off":
                new WelcomeScreen();
                this.dispose();
                break;
            case "Exit":
                System.exit(EXIT_ON_CLOSE);
                break;
            case "Add Vault":
                try {
                    //Ask for Vault type
                    vType = (String) JOptionPane.showInputDialog(this ,
                                                                 "Select what type of vault you wish to add." ,
                                                                 "Add an Astro Vault" ,
                                                                 JOptionPane.QUESTION_MESSAGE ,
                                                                 null ,
                                                                 new Object[] {TurboTypes.SAVINGS.toString() , TurboTypes.CHECKING.toString()} ,
                                                                 TurboTypes.SAVINGS);
                    if (vType != null) {
                        aVault.setVaultType(vType);
                        //Get next available Vault number
                        vNum = aVault.getVaultNum() + 1;
                        //Set default Vault number
                        aVault.setVaultNum(vNum);
                        //Ask for Vault balance
                        amtTemp = askForAmt("Please enter the total balance you wish to add." , "Add Total Balance");
                        if (amtTemp != null) {
                            vAmt = Double.parseDouble(amtTemp);
                            //Add Vault
                            aVault.setBalance(vAmt);
                            aVault.addVault(vType , vNum , round(vAmt));
                            updateCombo();
                            printJTA(aVault.printAllVaults());
                        }
                    }
                }
                catch (Throwable e) {
                    aVault.warnMSG(e.getMessage() , "Cancelled");
                }
                break;
            case "Remove Vault":
                try {
                    if (aVault.getAllVaults().size() >= 1) {
                        //Ask which vault to remove
                        tempVault = askForVault("Please select which vault to remove." , "Remove Astro Vault");
                        //Remove Vault
                        aVault.removeVault(tempVault);
                        updateCombo();
                        printJTA(aVault.printAllVaults());
                    }
                    else if (aVault.getAllVaults().size() < 1)
                        throw new InvalidAttributeValueException("You need to have at least 1 vault to remove.");
                }
                catch (Throwable e) {
                    aVault.warnMSG(e.getMessage() , "Cancelled");
                }
                break;
            case "Print All Vaults":
                printJTA();
                break;
            case "Make a Deposit":
                try {
                    if (aVault.getAllVaults().size() >= 1) {
                        //Ask which vault to deposit to
                        tempVault = askForVault("Please select which vault to deposit to." , "Make a Deposit - Select Astro Vault");
                        //Ask for amount
                        amtTemp = askForAmt("Please enter the amount you wish to deposit." , "Make a Deposit - Amount");
                        if (amtTemp != null) {
                            vAmt = Double.parseDouble(amtTemp);
                            if (vAmt > 0) {
                                //Add Deposit
                                teleTrans.deposit(tempVault , round(vAmt));
                                printJTA(tempVault.toString() , teleTrans.printAllTransActs(tempVault.getVaultNum()));
                            }
                            else if (vAmt <= 0) throw new InvalidAttributeValueException("The amount needs to be greater than 0.");
                            else throw new NumberFormatException("The number format needs to be <-#,###.##.");
                        }
                    }
                    else if (aVault.getAllVaults().size() < 1)
                        throw new InvalidAttributeValueException("You need to have at least 1 vault to do a deposit.");
                }
                catch (Throwable e) {
                    aVault.warnMSG(e.getMessage() , "Cancelled");
                }
                break;
            case "Make a Withdraw":
                try {
                    if (aVault.getAllVaults().size() >= 1) {
                        //Ask which vault to deposit to
                        tempVault = askForVault("Please select which vault to withdraw from." , "Make a Withdraw - Select Astro Vault");
                        //Ask for amount
                        amtTemp = askForAmt("Please enter the amount you wish to withdraw." , "Make a Withdraw - Amount");
                        if (amtTemp != null) {
                            vAmt = Double.parseDouble(amtTemp);
                            if (vAmt > 0) {
                                //Add Deposit
                                teleTrans.withdraw(tempVault , round(vAmt));
                                printJTA(tempVault.toString() , teleTrans.printAllTransActs(tempVault.getVaultNum()));
                            }
                            else if (vAmt <= 0) throw new InvalidAttributeValueException("The amount needs to be greater than 0.");
                            else throw new NumberFormatException("The number format needs to be <-#,###.##.");
                        }
                    }
                    else if (aVault.getAllVaults().size() < 1)
                        throw new InvalidAttributeValueException("You need to have at least 1 vault to do a withdraw.");
                }
                catch (Throwable e) {
                    aVault.warnMSG(e.getMessage() , "Cancelled");
                }
                break;
            case "Make a Transfer":
                AstroVault tempVault2;
                try {
                    if (aVault.getAllVaults().size() >= 2) {
                        //Ask which vault to transfer from
                        tempVault = askForVault("Please select which vault to transfer from." , "Transfer From - Select Astro Vault");
                        //Ask which vault to transfer to
                        tempVault2 = askForVault("Please select which vault to transfer to." , "Transfer To - Select Astro Vault");
                        //Ask for amount
                        amtTemp = askForAmt("Please enter the amount you wish to transfer." , "Transfer - Amount");
                        if (amtTemp != null) {
                            vAmt = Double.parseDouble(amtTemp);
                            if (vAmt > 0) {
                                teleTrans.transfer(tempVault , tempVault2 , round(vAmt));
                                printJTA(tempVault.toString() ,
                                         teleTrans.printAllTransActs(tempVault.getVaultNum()) ,
                                         tempVault2.toString() ,
                                         teleTrans.printAllTransActs(tempVault2.getVaultNum()));
                            }
                            else if (vAmt <= 0) throw new InvalidAttributeValueException("The amount needs to be greater than 0.");
                            else throw new NumberFormatException("The number format needs to be <-#,###.##.");
                        }
                    }
                    else if (aVault.getAllVaults().size() < 2)
                        throw new InvalidAttributeValueException("You need to have at least 2 vaults to do a transfer.");
                }
                catch (Throwable e) {
                    aVault.warnMSG(e.getMessage() , "Cancelled");
                }
                break;
            case "Contact Support":
                JOptionPane.showMessageDialog(this , bBank.toString() , "Contact Support" , JOptionPane.INFORMATION_MESSAGE);
                break;
            case "About":
                JOptionPane.showMessageDialog(this , bBank.getCopyright() , "About" , JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                break;
        }
    }
}

