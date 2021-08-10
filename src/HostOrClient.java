/*     */ package mortalkombat;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class HostOrClient extends JFrame
/*     */ {
/*     */   private String name;
/*     */   private String player;
/*     */   private Options opt;
/*     */   private Info info;
/*     */   private JButton connect;
/*     */   private JButton host;
/*     */   private JLabel jLabel1;
/*     */   private JPanel jPanel1;
/*     */   
/*     */   public HostOrClient(String pName, String player, Options opt, Info inf)
/*     */   {
/*  28 */     super("Mortal Kombat by Alex a.k.a Kurosaki_San.");
/*  29 */     initComponents();
/*  30 */     this.name = pName;
/*  31 */     this.player = player;
/*  32 */     this.opt = opt;
/*  33 */     this.info = inf;
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
/*  45 */     this.jPanel1 = new JPanel();
/*  46 */     this.connect = new JButton();
/*  47 */     this.host = new JButton();
/*  48 */     this.jLabel1 = new JLabel();
/*     */     
/*  50 */     setDefaultCloseOperation(3);
/*  51 */     setResizable(false);
/*     */     
/*  53 */     this.jPanel1.setBackground(new Color(0, 204, 0));
/*     */     
/*  55 */     this.connect.setBackground(new Color(0, 0, 0));
/*  56 */     this.connect.setFont(new Font("Tahoma", 0, 24));
/*  57 */     this.connect.setForeground(new Color(255, 0, 0));
/*  58 */     this.connect.setText("Connect");
/*  59 */     this.connect.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  61 */         HostOrClient.this.connectActionPerformed(evt);
/*     */       }
/*     */       
/*  64 */     });
/*  65 */     this.host.setBackground(new Color(0, 0, 0));
/*  66 */     this.host.setFont(new Font("Tahoma", 0, 24));
/*  67 */     this.host.setForeground(new Color(255, 51, 0));
/*  68 */     this.host.setText("Host");
/*  69 */     this.host.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  71 */         HostOrClient.this.hostActionPerformed(evt);
/*     */       }
/*     */       
/*  74 */     });
/*  75 */     this.jLabel1.setFont(new Font("Tahoma", 2, 18));
/*  76 */     this.jLabel1.setForeground(new Color(0, 0, 255));
/*  77 */     this.jLabel1.setText("Mortal Kombat by Alex a.k.a Kurosaki_San.");
/*     */     
/*  79 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  80 */     this.jPanel1.setLayout(jPanel1Layout);
/*  81 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(40, 40, 40).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.host, -2, 128, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, 32767).addComponent(this.connect, -2, 128, -2))).addGap(38, 38, 38)));
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
/*  93 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(18, 32767).addComponent(this.jLabel1).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.connect, -2, 50, -2).addComponent(this.host, -2, 50, -2)).addGap(25, 25, 25)));
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
/* 105 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 106 */     getContentPane().setLayout(layout);
/* 107 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 111 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 116 */     pack();
/*     */   }
/*     */   
/*     */   private void hostActionPerformed(ActionEvent evt) {
/*     */     try {
/* 121 */       new Host(this.name, this.player, this.opt, this.info).setVisible(true);
/* 122 */       setVisible(false);
/*     */     } catch (java.io.IOException ex) {
/* 124 */       java.util.logging.Logger.getLogger(HostOrClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private void connectActionPerformed(ActionEvent evt) {
/* 129 */     new Client(this.name, this.player, this.opt, this.info).setVisible(true);
/* 130 */     setVisible(false);
/*     */   }
/*     */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\HostOrClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */