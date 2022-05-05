import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Objects;

public class WelcomeScreen extends WindowAdapter implements ActionListener {
    private final JDialog           welcome      = new JDialog();
    private       CosmicClient      cosmicClient = new CosmicClient();
    private final JTextField        userText;
    private final JPasswordField    passText;
    // Registration Components
    private final CardLayout        card;
    private final JPanel            cardPL;
    private final JPanel            regCardPL;
    private final JPanel            botPanel;
    private       JPanel            gbp;
    private       JTextField        userNameText;
    private       JPasswordField    passWText;
    private       JTextField        nameText;
    private       JComboBox<String> cosComBox;
    private       JTextField        cOORDSText;
    private       JComboBox<String> cyberCommTypeCombo;
    private       JTextField        cyberCommValText;
    private       JComboBox<String> cyberCommTypeCombo2;
    private       JTextField        cyberCommValText2;

    public static void main(String... WarpSpeed) { new WelcomeScreen(); }

    public WelcomeScreen( ) {
        cardPL    = new JPanel();
        card      = new CardLayout();
        regCardPL = new JPanel();
        JPanel welCardPL = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        JSeparator separator = new JSeparator();
        botPanel = new JPanel(null);
        JLabel welMSG = new JLabel("Welcome to Blaster Bank!");
        welMSG.setFont(new Font(Font.SERIF , Font.BOLD , 40));
        welMSG.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(welMSG , BorderLayout.CENTER);
        welCardPL.add(topPanel , BorderLayout.NORTH);
        topPanel.add(separator , BorderLayout.SOUTH);
        welCardPL.add(botPanel , BorderLayout.SOUTH);
        topPanel.setPreferredSize(new Dimension(500 , 325));
        botPanel.setPreferredSize(new Dimension(500 , 175));
        topPanel.setBackground(Color.GRAY);
        botPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setVisible(true);
        botPanel.setVisible(true);
        separator.setVisible(true);

        //Bottom half
        // Welcome Components
        JLabel userLB = new JLabel("Username:");
        userLB.setBounds(115 , 20 , 80 , 25);
        botPanel.add(userLB);
        userText = new JTextField();
        userText.setBounds(200 , 20 , 165 , 25);
        botPanel.add(userText);
        JLabel pwLB = new JLabel("Password:");
        pwLB.setBounds(115 , 50 , 80 , 25);
        botPanel.add(pwLB);
        passText = new JPasswordField(20);
        passText.setBounds(200 , 50 , 165 , 25);
        passText.setEditable(true);
        botPanel.add(passText);
        JButton logBTN = new JButton("Login");
        logBTN.setBounds(100 , 100 , 90 , 25);
        logBTN.addActionListener(this);
        botPanel.add(logBTN);
        JButton regBTN = new JButton("Register");
        regBTN.setBounds(200 , 100 , 90 , 25);
        regBTN.addActionListener(this);
        botPanel.add(regBTN);
        JButton exitBTN = new JButton("Exit");
        exitBTN.setBounds(300 , 100 , 90 , 25);
        exitBTN.addActionListener(this);
        botPanel.add(exitBTN);
        JLabel success = new JLabel("");
        success.setBounds(177 , 140 , 50 , 25);
        botPanel.add(success);

        launchRegistration();

        //Frame
        welCardPL.setPreferredSize(new Dimension(500 , 500));
        cardPL.setLayout(card);
        cardPL.add(welCardPL);
        cardPL.add(regCardPL);
        welcome.add(cardPL);
        welCardPL.setVisible(true);

        welcome.setTitle("Welcome");
        welcome.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        welcome.setLocation(600 , 250);
        welcome.setAlwaysOnTop(true);
        welcome.setResizable(false);
        welcome.setVisible(true);
        welcome.addWindowStateListener(this);
        welcome.pack();
        welcome.revalidate();
    }

    private void launchRegistration( ) {
        welcome.setTitle("Registration");
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        gbp = new JPanel(gbl);
        gbp.setBackground(Color.LIGHT_GRAY);
        regCardPL.setPreferredSize(new Dimension(500 , 500));
        regCardPL.setBackground(Color.LIGHT_GRAY);
        regCardPL.add(gbp);

        JTextPane regInfo = new JTextPane();
        regInfo.setText("""
                        Thanks for registering at Blaster Bank!
                                                     
                        Please fill out this form by selecting your desired 'User Name', 'Cosmic Race',
                        and also select at least two types of 'Cyber Communication' options. Just enter
                        your common value and we will append the appropriate format.
                        """);
        regInfo.setEditable(false);
        regInfo.setBackground(Color.LIGHT_GRAY);
        JLabel userNameLB = new JLabel("Username:");
        userNameText = new JTextField(25);
        JLabel passWLB = new JLabel("Password:");
        passWText = new JPasswordField(25);
        JLabel nameLB = new JLabel("Name:");
        nameText = new JTextField(25);
        JLabel cosmicLB = new JLabel("Cosmic Race:");
        cosComBox = new JComboBox<>();
        JButton confirmBTN = new JButton("Confirm");
        JLabel cOORDSLB = new JLabel("Coordinates/Address:");
        cOORDSText = new JTextField(25);
        JLabel cyberCommTypeLB = new JLabel("CyberComm Preference:");
        cyberCommTypeCombo = new JComboBox<>();
        JLabel cyberCommValLB = new JLabel("CyberComm Value:");
        cyberCommValText = new JTextField(25);
        JLabel cyberCommTypeLB2 = new JLabel("CyberComm Preference:");
        cyberCommTypeCombo2 = new JComboBox<>();
        JLabel cyberCommValLB2 = new JLabel("CyberComm Value:");
        cyberCommValText2 = new JTextField(25);

        addGridItem(gbp , regInfo , gbc , gbl , 0 , 0 , GridBagConstraints.NONE , 2 , 1);
        addGridItem(gbp , userNameLB , gbc , gbl , 0 , 1 , GridBagConstraints.NONE , 1 , 1);
        addGridItem(gbp , userNameText , gbc , gbl , 1 , 1 , GridBagConstraints.HORIZONTAL , 1 , 1);
        addGridItem(gbp , passWLB , gbc , gbl , 0 , 2 , GridBagConstraints.NONE , 1 , 1);
        addGridItem(gbp , passWText , gbc , gbl , 1 , 2 , GridBagConstraints.HORIZONTAL , 1 , 1);
        addGridItem(gbp , nameLB , gbc , gbl , 0 , 3 , GridBagConstraints.NONE , 1 , 1);
        addGridItem(gbp , nameText , gbc , gbl , 1 , 3 , GridBagConstraints.HORIZONTAL , 1 , 1);
        addGridItem(gbp , cosmicLB , gbc , gbl , 0 , 4 , GridBagConstraints.NONE , 1 , 1);
        addGridItem(gbp , cosComBox , gbc , gbl , 1 , 4 , GridBagConstraints.HORIZONTAL , 1 , 1);
        addGridItem(gbp , cOORDSLB , gbc , gbl , 0 , 5 , GridBagConstraints.NONE , 1 , 1);
        addGridItem(gbp , cOORDSText , gbc , gbl , 1 , 5 , GridBagConstraints.HORIZONTAL , 1 , 1);
        addGridItem(gbp , cyberCommTypeLB , gbc , gbl , 0 , 6 , GridBagConstraints.NONE , 1 , 1);
        addGridItem(gbp , cyberCommTypeCombo , gbc , gbl , 1 , 6 , GridBagConstraints.HORIZONTAL , 1 , 1);
        addGridItem(gbp , cyberCommValLB , gbc , gbl , 0 , 7 , GridBagConstraints.NONE , 1 , 1);
        addGridItem(gbp , cyberCommValText , gbc , gbl , 1 , 7 , GridBagConstraints.HORIZONTAL , 1 , 1);
        addGridItem(gbp , cyberCommTypeLB2 , gbc , gbl , 0 , 8 , GridBagConstraints.NONE , 1 , 1);
        addGridItem(gbp , cyberCommTypeCombo2 , gbc , gbl , 1 , 8 , GridBagConstraints.HORIZONTAL , 1 , 1);
        addGridItem(gbp , cyberCommValLB2 , gbc , gbl , 0 , 9 , GridBagConstraints.NONE , 1 , 1);
        addGridItem(gbp , cyberCommValText2 , gbc , gbl , 1 , 9 , GridBagConstraints.HORIZONTAL , 1 , 1);
        addGridItem(gbp , new JSeparator() , gbc , gbl , 0 , 10 , GridBagConstraints.HORIZONTAL , 2 , 1);
        addGridItem(gbp , confirmBTN , gbc , gbl , 0 , 11 , GridBagConstraints.HORIZONTAL , 2 , 1);

        confirmBTN.addActionListener(this);

        cyberCommTypeCombo.addItem(TurboTypes.HOLOGRAM.toString());
        cyberCommTypeCombo.addItem(TurboTypes.HYPERSPEECH.toString());
        cyberCommTypeCombo.addItem(TurboTypes.VOIDMAIL.toString());
        cyberCommTypeCombo2.addItem(TurboTypes.HOLOGRAM.toString());
        cyberCommTypeCombo2.addItem(TurboTypes.HYPERSPEECH.toString());
        cyberCommTypeCombo2.addItem(TurboTypes.VOIDMAIL.toString());
        cyberCommTypeCombo2.setSelectedIndex(2);
        cosComBox.addItem(TurboTypes.ALIEN.toString());
        cosComBox.addItem(TurboTypes.HUMANOID.toString());
        cosComBox.addItem(TurboTypes.REPUBLICAN.toString());
        cosComBox.addItem(TurboTypes.IMPERIAL.toString());
        cosComBox.addItem(TurboTypes.SPACEPIRATE.toString());
    }

    private void addGridItem(Container container ,
                             JComponent component ,
                             GridBagConstraints gbc ,
                             GridBagLayout gbl ,
                             int gx ,
                             int gy ,
                             int fill ,
                             int w ,
                             int h) {
        gbc.gridx      = gx;
        gbc.gridy      = gy;
        gbc.fill       = fill;
        gbc.gridwidth  = w;
        gbc.gridheight = h;
        gbc.ipadx      = 12;
        gbc.ipady      = 8;
        gbc.insets     = new Insets(3 , 3 , 3 , 3);
        gbl.setConstraints(component , gbc);
        container.add(component , gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        switch (source.getText()) {
            case "Login":
                if (!userText.getText().isEmpty() && !passText.getText().isEmpty()) {
                    boolean user = cosmicClient.validateClient(userText.getText() , passText.getText());
                    if (user) {
                        closeWindow();
                        new GalacticGUI(cosmicClient);
                    }
                    else JOptionPane.showMessageDialog(botPanel ,
                                                       "Unable to validate credentials." ,
                                                       "Validation" ,
                                                       JOptionPane.INFORMATION_MESSAGE ,
                                                       null);
                }
                else JOptionPane.showMessageDialog(botPanel ,
                                                   "Unable to validate credentials." ,
                                                   "Validation" ,
                                                   JOptionPane.INFORMATION_MESSAGE ,
                                                   null);
                break;
            case "Register":
                card.next(cardPL);
                break;
            case "Confirm":
                if (!cosmicClient.validateUsername(userNameText.getText())){
                    if (!userNameText.getText().isEmpty()
                        && !passWText.getText().isEmpty()
                        && !nameText.getText().isEmpty()
                        && !cOORDSText.getText().isEmpty()
                        && !cyberCommValText.getText().isEmpty()
                        && !cyberCommValText2.getText().isEmpty()) {
                        cosmicClient = new CosmicClient(nameText.getText() ,
                                                        userNameText.getText() ,
                                                        passWText.getText() ,
                                                        Objects.requireNonNull(cosComBox.getSelectedItem()).toString() ,
                                                        cOORDSText.getText() ,
                                                        Objects.requireNonNull(cyberCommTypeCombo.getSelectedItem()).toString() ,
                                                        cyberCommValText.getText() ,
                                                        Objects.requireNonNull(cyberCommTypeCombo2.getSelectedItem()).toString() ,
                                                        cyberCommValText2.getText());
                        cosmicClient.addClient(cosmicClient);
                        card.next(cardPL);
                        userNameText.setText("");
                        passWText.setText("");
                        cOORDSText.setText("");
                        cyberCommValText.setText("");
                        cyberCommValText2.setText("");
                    }
                    else JOptionPane.showMessageDialog(gbp ,
                                                       "All fields must be filled in to save an account." ,
                                                       "Unable to Register" ,
                                                       JOptionPane.INFORMATION_MESSAGE ,
                                                       null);
                }
                else JOptionPane.showMessageDialog(gbp ,
                                                   "That User Name is already taken." ,
                                                   "Unable to Register" ,
                                                   JOptionPane.INFORMATION_MESSAGE ,
                                                   null);
                break;
            case "Exit":
                closeWindow();
                break;
            default:
                break;
        }
    }

    private void closeWindow( ) {
        welcome.dispose();
    }
}