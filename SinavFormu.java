import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class SinavFormu {
    private static JFrame f;
    private static JPanel cp, nb;
    private static CardLayout cl;
    private static String user = "Tuna", id = "240501018", pass = "Tuna";
    private static DefaultListModel<String> logs = new DefaultListModel<>();
    private static DefaultTableModel recordModel;
    
    private static final Color G = new Color(0, 255, 65);
    private static final Color B = new Color(2, 2, 2);
    private static final Color BL = new Color(0, 243, 255);
    private static final Color R = new Color(255, 0, 60);

    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } catch (Exception e) {}
        initBoot();
    }

    private static void initBoot() {
        JFrame bf = new JFrame(); bf.setUndecorated(true); bf.setSize(900, 550); bf.getContentPane().setBackground(B);
        JTextArea ba = new JTextArea(); ba.setBackground(B); ba.setForeground(G);
        ba.setFont(new Font("Monospaced", Font.PLAIN, 12)); bf.add(new JScrollPane(ba));
        bf.setLocationRelativeTo(null); bf.setVisible(true);
        String[] s = {"> INITIALIZING_OS_v30.0", "> KERNEL_STABLE", "> LOADING_GHOST_INTERFACE...", "> ACCESS_GRANTED: " + user.toUpperCase()};
        javax.swing.Timer t = new javax.swing.Timer(80, new ActionListener() {
            int i = 0; public void actionPerformed(ActionEvent e) {
                if (i < s.length) ba.append(s[i++] + "\n");
                else { ((javax.swing.Timer)e.getSource()).stop(); bf.dispose(); showLogin(); }
            }
        }); t.start();
    }

    public static void showLogin() {
        f = new JFrame("GATE_01"); 
        f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        f.setDefaultCloseOperation(3);
        f.getContentPane().setBackground(B); f.setLayout(new BorderLayout());

        JTextArea ma = new JTextArea(); 
        ma.setBackground(B); ma.setForeground(G);
        ma.setFont(new Font("Monospaced", Font.PLAIN, 9)); 
        ma.setEditable(false);

        String m = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣶⠶⠶⠶⠶⠶⠶⠶⢖⣦⣤⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡴⠞⠛⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠻⠶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⠞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⠀⠀⣴⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣆⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⣠⡞⠁⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠈⠹⣦⡀⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⢀⣼⠋⠀⠀⠀⢀⣤⣾⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣷⣦⣀⠀⠀⠀⠈⢿⣄⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⢀⡾⠁⠀⣠⡾⢁⣾⡿⡋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣆⠹⣦⠀⠀⢻⣆⠀⠀⠀⠀\n" +
                  "⠀⠀⢀⡾⠁⢀⢰⣿⠃⠾⢋⡔⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣿⠀⢹⣿⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡌⠻⠆⢿⣧⢀⠀⢻⣆⠀⠀⠀\n" +
                  "⠀⠀⣾⠁⢠⡆⢸⡟⣠⣶⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠞⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣦⡸⣿⠀⣆⠀⢿⡄⠀⠀\n" +
                  "⠀⢸⡇⠀⣽⡇⢸⣿⠟⢡⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣉⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢤⠙⢿⣿⠀⣿⡀⠘⣿⠀⠀\n" +
                  "⡀⣿⠁⠀⣿⡇⠘⣡⣾⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢷⣦⡙⠀⣿⡇⠀⢻⡇⠀\n" +
                  "⢸⡟⠀⡄⢻⣧⣾⡿⢋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣴⣿⠉⡄⢸⣿⠀\n" +
                  "⢾⡇⢰⣧⠸⣿⡏⢠⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠀⠓⢶⠶⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣆⠙⣿⡟⢰⡧⠀⣿⠀\n" +
                  "⣸⡇⠰⣿⡆⠹⣠⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣶⣿⡏⠀⠠⢺⠢⠀⠀⣿⣷⣤⣄⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣧⠸⠁⣾⡇⠀⣿⠀\n" +
                  "⣿⡇⠀⢻⣷⠀⣿⡿⠰⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⡅⠀⠀⢸⡄⠀⠀⣿⣿⣿⣿⣿⣿⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⡆⣰⣿⠁⠀⣿⠀\n" +
                  "⢸⣧⠀⡈⢿⣷⣿⠃⣰⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⡇⠀⠀⣿⣇⠀⢀⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⣸⡀⢿⣧⣿⠃⡀⢸⣿⠀\n" +
                  "⠀⣿⡀⢷⣄⠹⣿⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⣿⣿⠀⣼⣿⣿⣿⣿⣿⣿⣿⡯⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⢸⡟⢁⣴⠇⣼⡇⠀\n" +
                  "⠀⢸⡇⠘⣿⣷⡈⢰⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⣿⣿⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⢰⣿⡧⠈⣴⣿⠏⢠⣿⠀⠀\n" +
                  "⠀⠀⢿⡄⠘⢿⣿⣦⣿⣯⠘⣆⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⡎⢸⣿⣣⣾⡿⠏⠀⣾⠇⠀⠀\n" +
                  "⠀⠀⠈⢷⡀⢦⣌⠛⠿⣿⡀⢿⣆⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⢀⣿⡁⣼⡿⠟⣉⣴⠂⣼⠏⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠈⢷⡈⠻⣿⣶⣤⡁⠸⣿⣆⠡⡀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⢀⣾⡟⠀⣡⣴⣾⡿⠁⣴⠏⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⠹⣧⡀⠳⣦⣌⣉⣙⠛⠃⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠐⠛⠋⣉⣉⣤⡶⠁⣰⡿⠁⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⠀⠈⠻⣦⡀⠙⠛⠿⠿⠿⠿⠟⠛⠛⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⠙⠟⠛⠿⠿⠿⠿⠟⠛⠁⣠⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢶⣄⠙⠶⣦⣤⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣦⣤⡶⠖⣁⣴⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣶⣄⡉⠉⠉⠉⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠉⠉⠉⠉⣡⣴⡾⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠷⢦⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣠⣴⠶⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";

        javax.swing.Timer mt = new javax.swing.Timer(20, new ActionListener() {
            int l = 0; String[] lns = m.split("\n");
            public void actionPerformed(ActionEvent e) {
                if (l < lns.length) {
                    ma.append(lns[l++] + "\n");
                    ma.setCaretPosition(ma.getDocument().getLength());
                } else {
                    ((javax.swing.Timer)e.getSource()).stop();
                    showLoginFormComponents(ma);
                }
            }
        });
        f.add(new JScrollPane(ma), BorderLayout.CENTER);
        f.setVisible(true);
        mt.start();
    }

    private static void showLoginFormComponents(JTextArea ma) {
        JPanel lp = new JPanel(new GridBagLayout()); 
        lp.setOpaque(false); lp.setBackground(B);
        GridBagConstraints g = new GridBagConstraints();
        g.gridx=0; g.gridy=0; g.insets=new Insets(10,0,10,0);

        JLabel title = new JLabel("--- GHOST_ARCHITECT_v30 ---");
        title.setFont(new Font("Monospaced", 1, 24)); title.setForeground(G);
        
        JTextField u = new JTextField(id); 
        JPasswordField p = new JPasswordField(pass);
        sField(u); sField(p);
        
        JButton b = cBtn("[ INITIALIZE_BREACH ]", G);
        b.addActionListener(e -> {
            if(u.getText().equals(id) && new String(p.getPassword()).equals(pass)) {
                f.dispose(); showDash();
            }
        });

        lp.add(title, g); g.gridy++;
        lp.add(new JLabel("ID_KEY:") {{ setForeground(G); }}, g); g.gridy++;
        lp.add(u, g); g.gridy++;
        lp.add(new JLabel("PASS_TOKEN:") {{ setForeground(G); }}, g); g.gridy++;
        lp.add(p, g); g.gridy++;
        lp.add(b, g);

        f.add(lp, BorderLayout.SOUTH);
        f.revalidate();
        f.repaint();
    }

    public static void showDash() {
        f = new JFrame("GHOST_PROTOCOL_v30"); f.setExtendedState(6); f.setDefaultCloseOperation(3);
        f.setLayout(new BorderLayout());
        
        // --- SAAT EKLEMESİ VE NAVBAR ---
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(5, 5, 5));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, G));

        // Dijital Saat Etiketi
        JLabel clockLabel = new JLabel();
        clockLabel.setForeground(BL);
        clockLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        clockLabel.setBorder(new EmptyBorder(0, 20, 0, 20));
        
        // Saat Güncelleyici Timer
        javax.swing.Timer clockTimer = new javax.swing.Timer(1000, e -> {
            String time = new SimpleDateFormat("HH:mm:ss | dd.MM.yyyy").format(new Date());
            clockLabel.setText("SYS_TIME: " + time);
        });
        clockTimer.start();

        JPanel nb = new JPanel(new GridLayout(1, 11)); 
        nb.setBackground(new Color(5, 5, 5));
        nb.setPreferredSize(new Dimension(0, 75)); 
        String[] n = {"DASH", "CALC", "RECORDS", "SCHED", "ANALYTICS", "VAULT", "NETWORK", "SYS_LOG", "EXPORT", "CONFIG", "EXIT"};
        for(String t : n) nb.add(cNBtn(t));

        topPanel.add(clockLabel, BorderLayout.WEST);
        topPanel.add(nb, BorderLayout.CENTER);

        cl = new CardLayout(); cp = new JPanel(cl); cp.setBackground(B);
        cp.add(cPag("> SYSTEM_UPLINK_STABLE"), "DASH");
        cp.add(cCalc(), "CALC"); cp.add(cRec(), "RECORDS"); cp.add(cSched(), "SCHED");
        cp.add(cAnaly(), "ANALYTICS"); cp.add(cVault(), "VAULT"); cp.add(cNet(), "NETWORK");
        cp.add(cLog(), "SYS_LOG"); cp.add(cExp(), "EXPORT"); cp.add(cCfg(), "CONFIG");
        
        f.add(topPanel, BorderLayout.NORTH); 
        f.add(cp, BorderLayout.CENTER); 
        f.setVisible(true);
    }

    private static void exitSequence() {
        JFrame ef = new JFrame(); 
        ef.setUndecorated(true); 
        ef.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        ef.getContentPane().setBackground(B);
        
        JTextArea ea = new JTextArea(); 
        ea.setBackground(B); 
        ea.setForeground(R);
        ea.setFont(new Font("Monospaced", Font.PLAIN, 7)); 
        ea.setEditable(false);
        
        JScrollPane sp = new JScrollPane(ea);
        sp.setBorder(null);
        ef.add(sp);
        ef.setVisible(true);

        String[] gs = {
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣿⣧⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣿⣿⣿⣿⣿⣿⣛⡛⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣹⣽⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣷⣦⣌⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣯⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⡹⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⣴⣿⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣌⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⣾⣷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣿⣿⡬⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣿⡈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⣿⣉⣭⣭⣭⡿⣿⣻⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⣿⡏⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⣿⣿⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⡃",
            "⢸⣿⣿⣿⣿⣿⣿⣿⣿⡿⢋⣤⢶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢹⣷⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠛⠻⠿⠿⢿⣿⣿⣟⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣾⡇",
            "⢸⣿⣿⣿⣿⣿⣿⣿⠏⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⡏⢹⣿⣿⣿⡿⠟⠛⠛⠿⣿⣿⣿⣿⣿⠀⠐⠛⠛⠃⠀⢢⠀⢹⣿⡟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢳⣾⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⣿⡏⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣹⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⢸⡟⣿⠀⣿⡿⠋⠀⠂⠀⠀⠀⠹⣿⡖⣿⣿⠀⠀⠀⠀⠀⠀⢸⠿⠀⣿⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⡇",
            "⢸⣿⣿⣿⣿⣿⡏⢠⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⢳⣻⣶⡟⠀⠀⠀⠀⠀⢸⠃⠀⣿⠧⠛⢿⣄⡀⠀⠀⣀⢀⠾⠀⢸⣿⣶⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢻⣿⣿⣿⠇",
            "⢸⣿⣿⣿⣿⣿⠁⠋⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠹⣻⡇⠀⠀⠀⠀⠀⠘⠀⣰⡏⠀⠀⠀⠻⣿⣶⣤⣉⣉⣠⣴⣿⣿⣿⢁⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣼⡿⠋⠀⠀",
            "⢸⣿⣿⣿⣿⣿⡇⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠱⢾⡄⠀⠀⠀⠀⠀⣠⣿⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⡍⢡⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡼⡄⠀⠀⠀⠀",
            "⢸⣿⣿⣿⣿⣿⠀⢰⠋⠉⠀⠀⠀⠀⠈⣿⣿⣿⡿⠿⢿⣿⣿⣿⡿⣡⣿⡟⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⢾⣿⣶⣀⣀⣶⣿⣿⣿⣦⣀⣤⢦⣤⣿⣿⣿⣿⣿⠟⢋⡿⢇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠙⣄⠀⠀⠀",
            "⢸⣿⣿⣿⣿⡿⠃⡄⠀⠀⠀⠰⠀⠀⣠⡯⣽⡛⠀⠀⡀⠈⠻⣿⡧⣾⠏⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡌⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣿⠃⢸⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣼⣟⡶⡆",
            "⢸⣿⣿⣿⣿⡇⠸⣿⣦⡀⠀⣀⣠⣾⠟⠃⢿⣧⠀⠀⠁⠘⠀⠘⣇⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⡀⠘⢿⡿⣿⣿⣿⣿⣿⣿⠻⣿⣿⣿⡟⢃⣡⡧⠀⣾⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣮⣙⠳⡇",
            "⢸⣿⣿⣿⣿⣿⡶⢈⢛⣿⣿⣿⡿⠋⢀⡆⢸⣿⡀⠀⠦⠄⠀⣸⡇⣴⣿⣿⣿⣿⣿⣿⣿⣿⣛⣿⣷⣶⣷⣶⣾⣍⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠈⠓⠿⡿⣿⡟⣻⢩⣯⣽⣷⠙⠃⠈⠁⢠⠴⡞⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄",
            "⢀⠸⣿⣿⣿⣿⠃⡼⢻⣿⣿⣟⣣⣀⡈⠁⢸⣿⣿⣿⣶⣾⢯⣿⢻⣿⣿⣿⣿⣿⣿⣿⢳⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡌⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠁⠑⡓⠛⠃⠉⣈⠉⠀⠀⠀⠀⠀⣀⣾⣾⡐⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⠸⠆⢻⣿⣿⡟⢰⣷⠀⠪⢝⡻⢿⣿⣿⣿⣿⣿⣿⢿⣩⡷⢂⣼⣿⣿⣿⣿⣿⣿⡟⠉⠋⠁⠈⢿⣿⠃⠀⠈⠙⢿⣿⣿⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣀⠀⠀⢳⣀⠀⡀⢀⠀⣀⣠⣖⢺⣟⣛⢸⣿⠁⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⠀⠀⢸⣿⣿⣧⠘⣿⣇⢀⠀⠁⠘⠐⠗⠾⠿⠿⠧⣼⣿⠇⣾⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⣠⣀⣀⣹⣷⡀⠀⠀⠀⠀⢻⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠐⣍⣧⣽⣬⣧⣼⣿⣿⣿⣿⣿⡿⠟⠀⡛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⢸⢃⣸⣿⣿⣿⣧⠸⣿⣿⣤⣀⣆⠠⢠⠤⠤⣤⣶⣼⡟⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⡌⡹⠋⠉⠽⠿⣿⣿⡄⠺⠣⠀⣾⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠹⣾⣿⣿⣿⣿⣿⣿⣿⠟⠋⠀⣠⡞⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇",
            "⠘⣸⣿⣿⣿⣿⣿⣆⠻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⢉⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡁⠀⠀⠀⠀⠈⠙⠃⠀⣇⡐⠃⣼⣿⣿⣿⣿⢿⣷⣦⣍⣻⡛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⡯⣝⣿⣿⣷⣶⣶⠛⣿⣿⣧⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣿⣟⣻⣟⛛⠛⠿⡇",
            "⢰⣿⣿⣿⣿⣿⣿⣿⣷⠀⢩⣟⡛⠿⠿⠛⢉⣠⡔⠒⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⡄⢠⠀⠀⠀⠀⢸⠟⠉⠈⣿⣿⣿⣿⠇⣘⣻⣻⣿⢻⣿⣷⡿⠿⡛⢿⣟⣿⣿⣿⡿⣛⣻⣿⡇⠉⠀⠀⠉⠁⢠⣿⡏⢹⣿⣷⣾⣿⣍⢻⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣷⡆",
            "⢨⣭⣉⣿⡿⠟⠋⠐⠺⠂⣿⣤⣏⢙⣿⣿⣿⠛⠃⠀⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⠁⠈⠀⠀⠀⢠⡾⢶⠋⡀⢹⣿⣿⣏⣿⣿⣿⣿⣿⣉⡁⠹⣿⡌⣿⣿⡿⠉⠉⠀⣀⣀⡀⠈⠁⠨⠀⠀⠀⠀⠊⠙⢃⠈⠍⠉⣿⣿⡿⠟⠛⠛⠛⢉⣉⣭⣿⣿⣿⡆⢉⠉⠁⡄",
            "⠈⠻⢿⣟⠁⠀⠀⠀⠀⠒⠈⠙⠻⠿⣿⣿⣿⠏⠉⠉⠑⢶⣦⡉⢻⣿⣿⣿⣿⡿⠿⠿⣿⣿⡀⠀⠀⠃⢀⣾⡏⠉⠙⠀⠈⣿⣿⣇⣹⣿⣿⣿⣿⣏⠀⠂⢸⣿⣿⣼⠀⠀⠀⠀⠀⠠⠄⠀⠀⠀⣀⣀⣀⡀⠂⢀⣩⣴⣶⠿⠛⠉⠀⢠⣤⡄⠯⣾⣿⣿⣿⣿⣿⠇⠀⠻⠀⠀",
            "⠀⠀⣀⠙⣿⣶⣤⣀⡈⢀⣿⣿⣶⣶⣤⣴⣾⠀⠀⠀⠀⠀⣻⣿⣤⣿⣷⣶⣿⣿⣿⣷⣷⣷⣦⣥⠆⣠⣾⣿⠟⠓⠀⠀⡀⠀⠈⠍⠛⢉⣿⣿⣿⣿⣿⡆⠀⣶⡻⣿⡿⠙⢻⣿⣶⣿⣶⣶⣶⣤⣾⣿⣿⣿⣿⣿⠿⠛⡉⠀⠀⠀⠊⢀⣼⣿⠻⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⡀⠀",
            "⢀⠀⢻⣇⠙⣽⠛⠿⢿⣾⣿⣿⣿⣿⣿⡏⢀⣤⣴⣾⣿⣿⣿⣿⣿⡛⠋⠉⠉⠉⠉⠛⣿⣿⣿⡁⢈⠉⢁⣀⠀⠀⠘⠒⢂⡀⠄⠉⢹⣿⠿⠟⠛⠁⠀⠀⢻⣷⡆⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⠹⠿⠿⠛⠉⠀⠐⠋⠡⠀⡀⠀⣠⣾⡟⢻⣷⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠁⠀",
            "⠀⠀⠈⠛⣷⣤⣀⡀⣾⣿⣿⣿⣿⣿⣿⣧⠸⡿⠟⠛⠉⠁⢠⣿⣿⠃⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⠀⠈⣿⣿⡷⠉⢙⣩⠅⢠⣤⣤⣿⣿⠆⣠⠀⠀⡀⠀⠀⠹⣷⡀⠙⢿⣿⣿⣿⣿⣿⠏⢁⡀⠀⠀⠀⠀⠀⠀⢀⣐⣉⣴⣾⣿⠟⠀⠀⣿⣿⣧⣿⣿⣿⣫⠟⢻⣷⠀⠀⡀",
            "⠀⠀⠀⠀⢌⠙⠻⣿⡏⠁⣀⠀⠙⠛⠋⠁⠀⠀⠀⢀⣠⣴⣿⣿⠃⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣃⣀⣀⠙⠟⢀⣀⡀⠀⣀⡸⢿⣿⣿⠇⣼⣷⣇⣰⠀⠀⠀⠀⠻⢷⡀⠈⢿⣿⠛⠛⠁⢠⣾⣿⣿⣿⡿⠻⡿⠿⠟⠛⣉⠙⢉⣀⣀⠀⢸⣿⡗⢸⣿⣿⡿⠃⡄⣿⣿⣇⠈⠁",
            "⢸⣦⣀⠀⠀⠀⠀⠈⣷⣿⣿⣿⣷⣦⢿⣿⣶⡿⠿⠟⠛⠋⠉⢳⣧⠀⠀⠀⡠⠖⠋⣿⡿⣿⣿⠈⢍⠻⣿⠇⠘⠀⠈⠉⠀⢠⣾⣿⡏⠀⣿⣿⡿⢿⣀⡀⠀⣀⣠⣤⣧⣤⡀⠀⠀⠀⠐⠟⠛⠉⠁⠀⠀⠀⠂⠘⠓⠚⢁⠔⠀⠀⠈⢁⣼⣿⠟⡿⣿⡏⢀⣾⣇⢸⣿⣿⡄⠀",
            "⠈⢿⠿⢿⣦⣤⡀⠺⠛⠿⢿⣿⡿⠋⠀⣀⠘⠉⠀⠀⠀⠀⠀⣸⣿⠀⢀⠎⣠⣾⢰⣿⡽⣿⣿⠀⠤⠠⣤⡆⠀⠲⠶⢶⣶⣾⣿⣿⣥⣞⡁⢹⣷⣈⣿⣷⣿⣿⣿⣿⣿⣿⣿⣷⣶⡦⠀⢠⡶⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠐⢃⣸⣶⣿⣿⣯⡿⣱⣿⡇⢼⣿⣿⢸⣿⣿⡷⠀",
            "⠐⠢⠀⠀⠉⠉⠛⣷⣦⣄⣸⣥⣀⣠⣦⣤⣤⣤⣤⣶⣦⣾⣿⡿⠃⢀⡌⢰⣿⡿⢸⣿⡇⣿⣿⣇⣀⣀⠈⠉⠀⣀⡀⠀⢠⣿⣿⡏⢨⢹⣷⢸⣿⣿⡌⠙⠿⠿⢿⣿⣏⣿⣿⣿⣧⠀⡆⢸⣿⣄⠀⠀⠀⠀⠈⢓⣀⣤⣴⣾⣿⣿⡿⣿⠟⠁⠀⢹⣿⣿⡌⣿⣿⢸⣿⣿⡇⡄"
        };

        javax.swing.Timer t = new javax.swing.Timer(30, new ActionListener() {
            int i = 0;
            public void actionPerformed(ActionEvent e) {
                if (i < gs.length) { 
                    ea.append(gs[i++] + "\n"); 
                    ea.setCaretPosition(ea.getDocument().getLength()); 
                }
                else { 
                    ((javax.swing.Timer)e.getSource()).stop();
                    new javax.swing.Timer(3000, ev -> System.exit(0)).start();
                }
            }
        }); t.start();
    }

    private static JPanel cCalc() {
        JPanel p = new JPanel(new BorderLayout()); p.setBackground(B); p.setBorder(new EmptyBorder(40,40,40,40));
        JTextArea term = new JTextArea(); term.setBackground(B); term.setForeground(G);
        term.setFont(new Font("Monospaced", 1, 16)); term.setEditable(false);
        JTextField cmd = new JTextField(); sField(cmd);
        term.setText("> ARCHITECT_CALC_v30\n> /calc [ders] [vize] [final]\n> ");
        cmd.addActionListener(e -> {
            String in = cmd.getText(); cmd.setText("");
            if (in.startsWith("/calc ")) {
                try {
                    String[] pts = in.split(" ");
                    double res = Double.parseDouble(pts[2])*0.3 + Double.parseDouble(pts[3])*0.7;
                    term.append(in + "\n> CALCULATING_SUCCESS: " + res + "\n> ");
                    recordModel.addRow(new Object[]{pts[1], pts[2], pts[3], (int)res});
                } catch(Exception ex) { term.append("\n> ERR_INVALID_DATA\n> "); }
            }
        });
        p.add(new JScrollPane(term), BorderLayout.CENTER); p.add(cmd, BorderLayout.SOUTH); return p;
    }

    private static JPanel cRec() {
        JPanel p = new JPanel(new BorderLayout()); p.setBackground(B);
        recordModel = new DefaultTableModel(new String[]{"ID", "V", "F", "R"}, 0);
        JTable t = new JTable(recordModel); t.setBackground(B); t.setForeground(G); t.setGridColor(G);
        p.add(new JScrollPane(t)); return p;
    }

    private static JPanel cSched() {
        JPanel p = new JPanel(new BorderLayout()); p.setBackground(B);
        String[] h = {"T", "M", "T", "W", "T", "F", "S"};
        Object[][] d = {{"08:00", "CS101", "AI", "NET", "MATH", "ENG", "LAB"}};
        JTable t = new JTable(new DefaultTableModel(d, h)); t.setBackground(B); t.setForeground(G); t.setGridColor(G);
        p.add(new JScrollPane(t)); return p;
    }

    private static JPanel cNet() {
        JPanel p = new JPanel(new BorderLayout()); p.setBackground(B);
        JTextArea s = new JTextArea(); s.setBackground(B); s.setForeground(G); s.setFont(new Font("Monospaced", 1, 12)); s.setEditable(false);
        JButton b = cBtn("[ EXECUTE_PENETRATION ]", BL);
        b.addActionListener(e -> { s.setText(""); 
            javax.swing.Timer ft = new javax.swing.Timer(5, new ActionListener() {
                int lines = 0;
                public void actionPerformed(ActionEvent evt) {
                    if (lines < 300) { s.append(Long.toBinaryString(new Random().nextLong()) + "\n"); lines++; s.setCaretPosition(s.getDocument().getLength()); }
                    else { ((javax.swing.Timer)evt.getSource()).stop(); s.append("\n>>> ACCESS_GRANTED.\n"); }
                }
            }); ft.start();
        });
        p.add(new JScrollPane(s), BorderLayout.CENTER); p.add(b, BorderLayout.SOUTH); return p;
    }

    private static JPanel cAnaly() { return new JPanel(new BorderLayout()){{setBackground(B); add(new JTextArea("> ANALYSIS_ACTIVE"){{setBackground(B);setForeground(BL);}});}}; }
    private static JPanel cVault() { return new JPanel(new BorderLayout()){{setBackground(B); add(new JTextArea(">> VAULT_LOCKED"){{setBackground(B);setForeground(BL);}});}}; }
    private static JPanel cLog() { return new JPanel(new BorderLayout()){{setBackground(B); add(new JList<>(logs){{setBackground(B);setForeground(G);}});}}; }
    private static JPanel cExp() { JPanel p = new JPanel(new GridBagLayout()); p.setBackground(B); p.add(cBtn("[ EXPORT ]", BL)); return p; }
    private static JPanel cCfg() { JPanel p = new JPanel(new GridBagLayout()); p.setBackground(B); p.add(new JLabel("ADMIN_MODE"){{setForeground(G);}}); return p; }
    private static JPanel cPag(String t) { JPanel p = new JPanel(new GridBagLayout()); p.setBackground(B); p.add(new JLabel(t){{setForeground(G);setFont(new Font("Monospaced",1,40));}}); return p; }

    private static JButton cNBtn(String t) {
        JButton b = new JButton(t); b.setForeground(Color.WHITE); b.setBackground(new Color(25,25,25));
        b.setBorderPainted(false); b.setFocusPainted(false);
        b.addActionListener(e -> { if(t.equals("EXIT")) { f.dispose(); exitSequence(); } else cl.show(cp, t); });
        return b;
    }

    private static JButton cBtn(String t, Color c) {
        JButton b = new JButton(t); b.setBackground(B); b.setForeground(c);
        b.setBorder(BorderFactory.createLineBorder(c, 2)); b.setFocusPainted(false); return b;
    }

    private static void sField(JTextField f) {
        f.setBackground(new Color(15,15,15)); f.setForeground(G); f.setCaretColor(G);
        f.setBorder(BorderFactory.createLineBorder(G)); f.setPreferredSize(new Dimension(300, 35));
    }
}