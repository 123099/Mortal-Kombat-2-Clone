/*     */ package mortalkombat;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.net.Socket;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class Client extends javax.swing.JFrame implements Runnable
/*     */ {
/*     */   private Socket socket;
/*     */   private String IP;
/*     */   private int port;
/*     */   private String[] data;
/*     */   private MortalKombat mk;
/*     */   private Player clientPlayer;
/*     */   private Player serverPlayer;
/*  29 */   private PrintStream out = null;
/*  30 */   private DataInputStream in = null;
/*     */   private Thread t;
/*     */   private String name;
/*     */   private String player;
/*     */   private String[] players;
/*     */   private Options opt;
/*     */   private Info inf;
/*     */   
/*     */   public Client(String name, String player, Options opt, Info inf) {
/*  39 */     super("Mortal Kombat Client - By Alex a.k.a Kurosaki_San.");
/*  40 */     initComponents();
/*  41 */     this.StatLbl.setText("");
/*  42 */     this.name = name;
/*  43 */     this.player = player;
/*  44 */     this.opt = opt;
/*  45 */     this.inf = inf;
/*     */   }
/*     */   
/*     */   private JButton Connect;
/*     */   private JLabel StatLbl;
/*     */   private JLabel ipLbl;
/*     */   private JTextField ipText;
/*     */   private JPanel jPanel1;
/*     */   private JLabel portLbl;
/*     */   private JTextField portText;
/*     */   private void initComponents()
/*     */   {
/*  57 */     this.jPanel1 = new JPanel();
/*  58 */     this.Connect = new JButton();
/*  59 */     this.portText = new JTextField();
/*  60 */     this.ipText = new JTextField();
/*  61 */     this.ipLbl = new JLabel();
/*  62 */     this.portLbl = new JLabel();
/*  63 */     this.StatLbl = new JLabel();
/*     */     
/*  65 */     setDefaultCloseOperation(3);
/*  66 */     setResizable(false);
/*     */     
/*  68 */     this.jPanel1.setBackground(new Color(0, 255, 255));
/*     */     
/*  70 */     this.Connect.setBackground(new Color(0, 255, 102));
/*  71 */     this.Connect.setForeground(new Color(204, 0, 0));
/*  72 */     this.Connect.setText("Connect");
/*  73 */     this.Connect.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  75 */         Client.this.ConnectActionPerformed(evt);
/*     */       }
/*     */       
/*  78 */     });
/*  79 */     this.portText.setText("123");
/*     */     
/*  81 */     this.ipLbl.setText("IP/Comp name");
/*     */     
/*  83 */     this.portLbl.setText("Port");
/*     */     
/*  85 */     this.StatLbl.setForeground(new Color(255, 0, 0));
/*  86 */     this.StatLbl.setText("Status");
/*  87 */     this.StatLbl.setHorizontalTextPosition(0);
/*     */     
/*  89 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  90 */     this.jPanel1.setLayout(jPanel1Layout);
/*  91 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.ipLbl, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 2, -2).addComponent(this.portLbl))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.portText).addComponent(this.ipText, -2, 128, -2))).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 2, -2).addComponent(this.StatLbl, -1, 279, 32767))).addGap(18, 18, 18).addComponent(this.Connect).addGap(73, 73, 73)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 113 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.ipText, -2, 22, -2).addComponent(this.ipLbl)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.portText, -2, -1, -2).addComponent(this.portLbl)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Connect).addComponent(this.StatLbl)).addContainerGap(14, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 132 */     getContentPane().setLayout(layout);
/* 133 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 137 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 142 */     pack();
/*     */   }
/*     */   
/*     */   private void ConnectActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try {
/* 148 */       this.Connect.setEnabled(false);
/* 149 */       this.IP = this.ipText.getText();
/* 150 */       this.port = Integer.decode(this.portText.getText()).intValue();
/* 151 */       this.socket = null;
/* 152 */       this.mk = new MortalKombat("Mortal Kombat Client - By Alex.", this.opt, this.inf);
/* 153 */       this.StatLbl.setText("Trying to connect to " + this.IP + "...");
/* 154 */       this.t = new Thread(this);
/* 155 */       this.t.start();
/*     */     } catch (Exception e) {
/* 157 */       javax.swing.JOptionPane.showMessageDialog(null, "Error: Fields are empty or port contains illegal characters.");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void connect()
/*     */   {
/*     */     try
/*     */     {
/* 168 */       if (this.socket == null) {
/* 169 */         System.err.println("Trying to connect to host...");
/* 170 */         this.socket = new Socket(this.IP, this.port);
/* 171 */         this.out = new PrintStream(this.socket.getOutputStream(), true);
/* 172 */         this.in = new DataInputStream(this.socket.getInputStream());
/* 173 */         this.clientPlayer = new Player(this.player, this.name, this.mk, this.mk.getFrameW() - 25 * this.mk.getFrameW() / 100, (int)(this.mk.getFrameH() - 67.85D * this.mk.getFrameH() / 100.0D), this.mk.getFrameW() - 25 * this.mk.getFrameW() / 100, (int)(10.7D * this.mk.getFrameH() / 100.0D), true);
/* 174 */         this.out.println(this.player + "," + this.name);
/* 175 */         this.players = this.in.readLine().split(",");
/* 176 */         this.serverPlayer = new Player(this.players[0], this.players[1], this.mk, (int)(8.33D * this.mk.getFrameW() / 100.0D), (int)(this.mk.getFrameH() - 67.85D * this.mk.getFrameH() / 100.0D), (int)(8.33D * this.mk.getFrameW() / 100.0D), (int)(10.7D * this.mk.getFrameH() / 100.0D), false);
/* 177 */         this.clientPlayer.addOtherPlayer(this.serverPlayer);
/* 178 */         System.err.println("Waiting for host to start game...");
/*     */       }
/* 180 */       this.StatLbl.setText("");
/* 181 */       this.ipText.setVisible(false);
/* 182 */       this.portText.setVisible(false);
/* 183 */       this.Connect.setVisible(false);
/* 184 */       this.ipLbl.setText("Connected to " + this.IP);
/* 185 */       this.portLbl.setText("Waiting for host to start the game...");
/* 186 */       setSize(getWidth(), getHeight() - 50);
/*     */     } catch (java.net.UnknownHostException e) {
/* 188 */       this.StatLbl.setText("Couldn't find host/ip " + this.IP);
/* 189 */       this.Connect.setEnabled(true);
/*     */     } catch (IOException e) {
/* 191 */       this.StatLbl.setText("Couldn't Connect to host/ip " + this.IP + ", server may be off.");
/* 192 */       this.Connect.setEnabled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/* 198 */     connect();
/*     */     try {
/* 200 */       this.socket.setTcpNoDelay(true);
/* 201 */       String s = this.in.readLine();
/* 202 */       if (s.contains("added"))
/*     */       {
/* 204 */         this.mk.addPlayer(this.serverPlayer, 1, false);
/* 205 */         this.mk.addPlayer(this.clientPlayer, 2, true);
/* 206 */         this.mk.addBackground(s.split(",")[1]);
/* 207 */         this.out.println("added");
/* 208 */         if (this.in.readLine().equals("setvisible")) {
/* 209 */           this.mk.setVisible(true);
/* 210 */           setVisible(false);
/*     */         }
/*     */       }
/*     */     } catch (IOException ex) {
/* 214 */       Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     for (;;) {
/* 217 */       this.out.println(this.clientPlayer.getX() + "," + this.clientPlayer.getY() + "," + this.clientPlayer.getState() + "," + this.clientPlayer.getStateNum(this.clientPlayer.getState()) + "," + this.serverPlayer.getHPFIeld().getHP() + "," + this.clientPlayer.restart() + ",playMusic");
/*     */       try {
/* 219 */         this.data = this.in.readLine().trim().split(",");
/* 220 */         this.serverPlayer.setX(Integer.decode(this.data[0]).intValue());
/* 221 */         this.serverPlayer.setY(Integer.decode(this.data[1]).intValue());
/* 222 */         if (this.data[2].contains("beingHit")) {
/* 223 */           this.clientPlayer.setState(this.data[2], Integer.decode(this.data[3]).intValue());
/*     */         } else
/* 225 */           this.serverPlayer.setState(this.data[2], Integer.decode(this.data[3]).intValue());
/* 226 */         if (this.clientPlayer.getHPFIeld().getHP() != Integer.decode(this.data[4]).intValue())
/* 227 */           this.clientPlayer.getHPFIeld().setHP(Integer.decode(this.data[4]).intValue());
/* 228 */         if (this.data[5].equals("true"))
/*     */         {
/* 230 */           this.clientPlayer = new Player(this.player, this.name, this.mk, this.mk.getFrameW() - 150, this.mk.getFrameH() - 190, this.mk.getFrameW() - 150, 30, true);
/* 231 */           this.serverPlayer = new Player(this.players[0], this.players[1], this.mk, 50, this.mk.getFrameH() - 190, 50, 30, false);
/* 232 */           this.clientPlayer.addOtherPlayer(this.serverPlayer);
/* 233 */           this.clientPlayer.setRestart(false);
/*     */         }
/* 235 */         if (this.data[6].equals("playMusic")) {
/* 236 */           this.mk.startBattleMusic();
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       catch (IOException ex)
/*     */       {
/*     */ 
/*     */         try
/*     */         {
/*     */ 
/* 247 */           this.out.close();
/* 248 */           this.in.close();
/* 249 */           this.socket.close();
/* 250 */           System.exit(1);
/*     */         } catch (IOException ex1) {
/* 252 */           Logger.getLogger(Host.class.getName()).log(java.util.logging.Level.SEVERE, null, ex1);
/*     */         }
/* 254 */         System.err.println("End of stream.");
/* 255 */         System.exit(1);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */