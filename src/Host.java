/*     */ package mortalkombat;
/*     */ 
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class Host extends javax.swing.JFrame implements Runnable
/*     */ {
/*     */   private ServerSocket serverSocket;
/*     */   private Socket clientSocket;
/*  28 */   private int port = 123;
/*     */   private MortalKombat mk;
/*     */   private Player servPlayer;
/*  31 */   private Player clientPlayer; private PrintStream out = null;
/*  32 */   private DataInputStream in = null;
/*     */   private Thread t;
/*     */   private String[] data;
/*     */   private String name;
/*     */   private String player;
/*     */   private String[] players;
/*     */   private Options opt;
/*     */   
/*     */   public Host(String name, String player, Options opt, Info inf) throws IOException
/*     */   {
/*  42 */     super("Mortal Kombat Host - By Alex Hazov a.k.a Kurosaki_San.");
/*  43 */     initComponents();
/*  44 */     this.name = name;
/*  45 */     this.player = player;
/*  46 */     this.opt = opt;
/*  47 */     this.inf = inf;
/*  48 */     this.start.setVisible(false);
/*  49 */     this.connectedMsg.setText("Waiting for clients...");
/*     */     try {
/*  51 */       java.net.URL URL = new java.net.URL("http://www.whatismyip.org/");
/*  52 */       java.net.HttpURLConnection Conn = (java.net.HttpURLConnection)URL.openConnection();
/*  53 */       java.io.InputStream InStream = Conn.getInputStream();
/*  54 */       java.io.InputStreamReader Isr = new java.io.InputStreamReader(InStream);
/*  55 */       java.io.BufferedReader Br = new java.io.BufferedReader(Isr);
/*  56 */       this.IpLbl.setText("Your Ip Address: " + Br.readLine());
/*     */     } catch (Exception e) {
/*     */       try {
/*  59 */         InetAddress Ip = InetAddress.getLocalHost();
/*  60 */         this.IpLbl.setText("Your Ip Address: " + Ip.getHostAddress() + " - Local Network only!");
/*     */       }
/*     */       catch (Exception ex) {}
/*     */     }
/*  64 */     this.serverSocket = null;
/*  65 */     this.mk = new MortalKombat("Mortal Kombat Host - By Alex a.k.a Kurosaki_San.", opt, inf);
/*  66 */     this.mk.addBackground(this.mapBox.getSelectedIndex() + ".png");
/*  67 */     this.t = new Thread(this);
/*  68 */     this.t.start();
/*  69 */     repaint();
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  74 */     super.paint(g);
/*     */     try {
/*  76 */       g.clearRect(60, 100, 160, 100);
/*  77 */       g.drawImage(javax.imageio.ImageIO.read(new java.io.File("images/maps/" + this.mapBox.getSelectedIndex() + ".png")), 60, 100, 160, 100, null);
/*     */     } catch (IOException ex) {
/*  79 */       Logger.getLogger(Host.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  92 */     this.jPanel1 = new JPanel();
/*  93 */     this.start = new JButton();
/*  94 */     this.IpLbl = new JLabel();
/*  95 */     this.mapBox = new JComboBox();
/*  96 */     this.mapLbl = new JLabel();
/*  97 */     this.connectedMsg = new JLabel();
/*     */     
/*  99 */     setDefaultCloseOperation(3);
/* 100 */     setResizable(false);
/* 101 */     addFocusListener(new java.awt.event.FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 103 */         Host.this.formFocusGained(evt);
/*     */       }
/*     */       
/* 106 */     });
/* 107 */     this.jPanel1.setBackground(new java.awt.Color(204, 204, 0));
/*     */     
/* 109 */     this.start.setBackground(new java.awt.Color(204, 0, 51));
/* 110 */     this.start.setText("start");
/* 111 */     this.start.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 113 */         Host.this.startActionPerformed(evt);
/*     */       }
/*     */       
/* 116 */     });
/* 117 */     this.IpLbl.setText("IpAddress");
/*     */     
/* 119 */     this.mapBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prison", "Moon Walk", "Palace Gates", "The Courtyard", "Throne Room", "Warrior Shrine", "The Armory", "Living Forest", "The Tower", "The Portal", "The Portal 2", "Waste Land", "Waste Land 2", "The Dead Pool", "Kahn's Arena", "The Pit 2", "Smokes Portal", "Graveyard 1", "Graveyard 2", "Graveyard 3", "The Bank 1", "The Bank 2", "The Bank 3", "Whirlpool", "Jades Desert", "Scorpion's Lair Entrance", "Scorpion's Lair", "Doom", "Ice Pit" }));
/* 120 */     this.mapBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/* 122 */         Host.this.mapBoxPropertyChange(evt);
/*     */       }
/*     */       
/* 125 */     });
/* 126 */     this.mapLbl.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 127 */     this.mapLbl.setText("Map");
/*     */     
/* 129 */     this.connectedMsg.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 130 */     this.connectedMsg.setForeground(new java.awt.Color(102, 51, 0));
/* 131 */     this.connectedMsg.setText("Connected player");
/*     */     
/* 133 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 134 */     this.jPanel1.setLayout(jPanel1Layout);
/* 135 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.mapLbl).addGap(18, 18, 18).addComponent(this.mapBox, -2, 170, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.IpLbl, -1, -1, 32767)).addComponent(this.connectedMsg, -2, 362, -2)).addContainerGap(172, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(430, 32767).addComponent(this.start, -2, 83, -2).addGap(31, 31, 31)));
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
/* 153 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.connectedMsg, -2, 21, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.mapLbl).addComponent(this.IpLbl).addComponent(this.mapBox, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, 32767).addComponent(this.start).addContainerGap()));
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
/* 168 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 169 */     getContentPane().setLayout(layout);
/* 170 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 174 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 179 */     pack();
/*     */   }
/*     */   
/*     */   private void startActionPerformed(ActionEvent evt) {
/* 183 */     this.mk.addPlayer(this.servPlayer, 1, true);
/* 184 */     this.mk.addPlayer(this.clientPlayer, 2, false);
/* 185 */     this.mk.addBackground(this.mapBox.getSelectedIndex() + ".png");
/* 186 */     this.out.println("added," + this.mapBox.getSelectedIndex() + ".png");
/*     */     try {
/* 188 */       if (this.in.readLine().equals("added")) {
/* 189 */         this.out.println("setvisible");
/* 190 */         this.mk.setVisible(true);
/* 191 */         this.t = new Thread(this);
/* 192 */         this.t.start();
/*     */       }
/*     */     } catch (IOException ex) {
/* 195 */       Logger.getLogger(Host.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 197 */     this.mk.setVisible(true);
/* 198 */     this.mk.startBattleMusic();
/* 199 */     setVisible(false);
/* 200 */     System.err.println("Game starting..");
/*     */   }
/*     */   
/*     */ 
/*     */   private void formFocusGained(FocusEvent evt) {}
/*     */   
/*     */   private void mapBoxPropertyChange(PropertyChangeEvent evt)
/*     */   {
/* 208 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */   private Info inf;
/*     */   
/*     */   private JLabel IpLbl;
/*     */   
/*     */   private JLabel connectedMsg;
/*     */   
/*     */   private JPanel jPanel1;
/*     */   
/*     */   private JComboBox mapBox;
/*     */   private JLabel mapLbl;
/*     */   private JButton start;
/*     */   public void run()
/*     */   {
/* 225 */     if (this.serverSocket == null) {
/*     */       try {
/* 227 */         this.serverSocket = new ServerSocket(this.port);
/*     */       } catch (IOException e) {
/* 229 */         System.err.println("Could not listen on port: " + this.port + ".");
/* 230 */         System.exit(1);
/*     */       }
/*     */       try {
/* 233 */         System.err.println("Waiting for client...");
/* 234 */         this.clientSocket = this.serverSocket.accept();
/* 235 */         this.clientSocket.setTcpNoDelay(true);
/* 236 */         this.connectedMsg.setText(this.clientSocket.getInetAddress().getHostAddress() + " - has joined the game.");
/* 237 */         this.out = new PrintStream(this.clientSocket.getOutputStream(), true);
/* 238 */         this.in = new DataInputStream(this.clientSocket.getInputStream());
/* 239 */         this.servPlayer = new Player(this.player, this.name, this.mk, (int)(8.33D * this.mk.getFrameW() / 100.0D), (int)(this.mk.getFrameH() - 67.85D * this.mk.getFrameH() / 100.0D), (int)(8.33D * this.mk.getFrameW() / 100.0D), (int)(10.7D * this.mk.getFrameH() / 100.0D), true);
/* 240 */         this.out.println(this.player + "," + this.name);
/* 241 */         this.players = this.in.readLine().split(",");
/* 242 */         this.clientPlayer = new Player(this.players[0], this.players[1], this.mk, this.mk.getFrameW() - 25 * this.mk.getFrameW() / 100, (int)(this.mk.getFrameH() - 67.85D * this.mk.getFrameH() / 100.0D), this.mk.getFrameW() - 25 * this.mk.getFrameW() / 100, (int)(10.7D * this.mk.getFrameH() / 100.0D), false);
/* 243 */         this.servPlayer.addOtherPlayer(this.clientPlayer);
/* 244 */         this.start.setVisible(true);
/* 245 */         this.t.stop();
/*     */       } catch (IOException e) {
/* 247 */         System.err.println("Accept failed.");
/* 248 */         System.exit(1);
/*     */       }
/*     */     } else {
/*     */       for (;;) {
/* 252 */         this.out.println(this.servPlayer.getX() + "," + this.servPlayer.getY() + "," + this.servPlayer.getState() + "," + this.servPlayer.getStateNum(this.servPlayer.getState()) + "," + this.clientPlayer.getHPFIeld().getHP() + "," + this.servPlayer.restart() + ",playMusic");
/*     */         try {
/* 254 */           this.data = this.in.readLine().trim().split(",");
/* 255 */           this.clientPlayer.setX(Integer.decode(this.data[0]).intValue());
/* 256 */           this.clientPlayer.setY(Integer.decode(this.data[1]).intValue());
/* 257 */           if (this.data[2].contains("beingHit")) {
/* 258 */             this.servPlayer.setState(this.data[2], Integer.decode(this.data[3]).intValue());
/*     */           } else
/* 260 */             this.clientPlayer.setState(this.data[2], Integer.decode(this.data[3]).intValue());
/* 261 */           if (this.servPlayer.getHPFIeld().getHP() != Integer.decode(this.data[4]).intValue())
/* 262 */             this.servPlayer.getHPFIeld().setHP(Integer.decode(this.data[4]).intValue());
/* 263 */           if (this.data[5].equals("true")) {
/* 264 */             this.servPlayer = new Player(this.player, this.name, this.mk, 50, this.mk.getFrameH() - 190, 50, 30, true);
/* 265 */             this.clientPlayer = new Player(this.players[0], this.players[1], this.mk, this.mk.getFrameW() - 150, this.mk.getFrameH() - 190, this.mk.getFrameW() - 150, 30, false);
/* 266 */             this.servPlayer.addOtherPlayer(this.clientPlayer);
/* 267 */             this.servPlayer.setRestart(false);
/*     */           }
/* 269 */           if (this.data[6].equals("playMusic")) {
/* 270 */             this.mk.startBattleMusic();
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         catch (IOException ex)
/*     */         {
/*     */ 
/*     */           try
/*     */           {
/*     */ 
/* 281 */             this.out.close();
/* 282 */             this.in.close();
/* 283 */             this.clientSocket.close();
/* 284 */             this.serverSocket.close();
/* 285 */             System.exit(1);
/*     */           } catch (IOException ex1) {
/* 287 */             Logger.getLogger(Host.class.getName()).log(Level.SEVERE, null, ex1);
/*     */           }
/* 289 */           System.err.println("End of stream.");
/* 290 */           System.exit(1);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\Host.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */