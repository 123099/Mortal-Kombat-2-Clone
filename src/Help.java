/*     */ package mortalkombat;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ 
/*     */ public class Help extends javax.swing.JFrame {
/*     */   private javax.swing.JDialog Controls;
/*     */   private javax.swing.JDialog Port;
/*     */   private javax.swing.JButton btn;
/*     */   private javax.swing.JButton ctrlBtn;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel10;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel5;
/*     */   private javax.swing.JLabel jLabel6;
/*     */   private javax.swing.JLabel jLabel7;
/*     */   private javax.swing.JLabel jLabel8;
/*     */   private javax.swing.JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel3;
/*     */   private javax.swing.JPanel jPanel4;
/*     */   private javax.swing.JDialog music;
/*     */   private javax.swing.JButton musicBtn;
/*     */   private javax.swing.JButton portBtn;
/*     */   
/*     */   public Help() {
/*  29 */     super("Help.");
/*  30 */     initComponents();
/*  31 */     setDefaultCloseOperation(1);
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
/*  43 */     this.Controls = new javax.swing.JDialog();
/*  44 */     this.jPanel1 = new javax.swing.JPanel();
/*  45 */     this.jLabel1 = new javax.swing.JLabel();
/*  46 */     this.jLabel2 = new javax.swing.JLabel();
/*  47 */     this.jLabel3 = new javax.swing.JLabel();
/*  48 */     this.jLabel4 = new javax.swing.JLabel();
/*  49 */     this.jLabel5 = new javax.swing.JLabel();
/*  50 */     this.Port = new javax.swing.JDialog();
/*  51 */     this.jPanel3 = new javax.swing.JPanel();
/*  52 */     this.jLabel6 = new javax.swing.JLabel();
/*  53 */     this.btn = new javax.swing.JButton();
/*  54 */     this.jLabel7 = new javax.swing.JLabel();
/*  55 */     this.music = new javax.swing.JDialog();
/*  56 */     this.jPanel4 = new javax.swing.JPanel();
/*  57 */     this.jLabel8 = new javax.swing.JLabel();
/*  58 */     this.jLabel9 = new javax.swing.JLabel();
/*  59 */     this.jLabel10 = new javax.swing.JLabel();
/*  60 */     this.jPanel2 = new javax.swing.JPanel();
/*  61 */     this.ctrlBtn = new javax.swing.JButton();
/*  62 */     this.portBtn = new javax.swing.JButton();
/*  63 */     this.musicBtn = new javax.swing.JButton();
/*     */     
/*  65 */     this.Controls.setResizable(false);
/*     */     
/*  67 */     this.jPanel1.setBackground(new java.awt.Color(0, 0, 204));
/*     */     
/*  69 */     this.jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
/*  70 */     this.jLabel1.setForeground(new java.awt.Color(255, 204, 0));
/*  71 */     this.jLabel1.setText("A -> Punch");
/*     */     
/*  73 */     this.jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
/*  74 */     this.jLabel2.setForeground(new java.awt.Color(255, 204, 0));
/*  75 */     this.jLabel2.setText("S -> Kick 1");
/*     */     
/*  77 */     this.jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
/*  78 */     this.jLabel3.setForeground(new java.awt.Color(255, 204, 0));
/*  79 */     this.jLabel3.setText("D -> Kick 2");
/*     */     
/*  81 */     this.jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
/*  82 */     this.jLabel4.setForeground(new java.awt.Color(255, 204, 0));
/*  83 */     this.jLabel4.setText("Ctrl -> Duck");
/*     */     
/*  85 */     this.jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
/*  86 */     this.jLabel5.setForeground(new java.awt.Color(255, 204, 0));
/*  87 */     this.jLabel5.setText("Z -> Duck kick");
/*     */     
/*  89 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  90 */     this.jPanel1.setLayout(jPanel1Layout);
/*  91 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5)).addContainerGap(36, 32767)));
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
/* 103 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel5).addContainerGap(28, 32767)));
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
/* 119 */     GroupLayout ControlsLayout = new GroupLayout(this.Controls.getContentPane());
/* 120 */     this.Controls.getContentPane().setLayout(ControlsLayout);
/* 121 */     ControlsLayout.setHorizontalGroup(ControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 125 */     ControlsLayout.setVerticalGroup(ControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 130 */     this.Port.setResizable(false);
/*     */     
/* 132 */     this.jPanel3.setBackground(new java.awt.Color(255, 153, 0));
/*     */     
/* 134 */     this.jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 135 */     this.jLabel6.setForeground(new java.awt.Color(0, 153, 0));
/* 136 */     this.jLabel6.setText("Click");
/*     */     
/* 138 */     this.btn.setBackground(new java.awt.Color(255, 153, 0));
/* 139 */     this.btn.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 140 */     this.btn.setForeground(new java.awt.Color(0, 102, 102));
/* 141 */     this.btn.setText("here");
/* 142 */     this.btn.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 144 */         Help.this.btnActionPerformed(evt);
/*     */       }
/*     */       
/* 147 */     });
/* 148 */     this.jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 149 */     this.jLabel7.setForeground(new java.awt.Color(0, 153, 0));
/* 150 */     this.jLabel7.setText("for a guide to open ports");
/*     */     
/* 152 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 153 */     this.jPanel3.setLayout(jPanel3Layout);
/* 154 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel7).addContainerGap(-1, 32767)));
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
/* 165 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.btn).addComponent(this.jLabel7)).addContainerGap(31, 32767)));
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
/* 176 */     GroupLayout PortLayout = new GroupLayout(this.Port.getContentPane());
/* 177 */     this.Port.getContentPane().setLayout(PortLayout);
/* 178 */     PortLayout.setHorizontalGroup(PortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 182 */     PortLayout.setVerticalGroup(PortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -2, -1, -2));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 187 */     this.music.setResizable(false);
/*     */     
/* 189 */     this.jPanel4.setBackground(new java.awt.Color(51, 102, 0));
/*     */     
/* 191 */     this.jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 192 */     this.jLabel8.setForeground(new java.awt.Color(204, 255, 204));
/* 193 */     this.jLabel8.setText("If you want to add your own music to the game, then you");
/*     */     
/* 195 */     this.jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 196 */     this.jLabel9.setForeground(new java.awt.Color(204, 255, 204));
/* 197 */     this.jLabel9.setText("have to convert it to .wav files and then put them in the");
/*     */     
/* 199 */     this.jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 200 */     this.jLabel10.setForeground(new java.awt.Color(204, 255, 204));
/* 201 */     this.jLabel10.setText("bgm folder -> menu or battle folder.");
/*     */     
/* 203 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 204 */     this.jPanel4.setLayout(jPanel4Layout);
/* 205 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel10)).addContainerGap(20, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 215 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel8).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel10).addContainerGap(-1, 32767)));
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
/* 227 */     GroupLayout musicLayout = new GroupLayout(this.music.getContentPane());
/* 228 */     this.music.getContentPane().setLayout(musicLayout);
/* 229 */     musicLayout.setHorizontalGroup(musicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 233 */     musicLayout.setVerticalGroup(musicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -2, -1, -2));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 238 */     setDefaultCloseOperation(3);
/*     */     
/* 240 */     this.jPanel2.setBackground(new java.awt.Color(255, 255, 204));
/*     */     
/* 242 */     this.ctrlBtn.setBackground(new java.awt.Color(0, 204, 204));
/* 243 */     this.ctrlBtn.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 244 */     this.ctrlBtn.setForeground(new java.awt.Color(255, 0, 0));
/* 245 */     this.ctrlBtn.setText("Controls");
/* 246 */     this.ctrlBtn.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 248 */         Help.this.ctrlBtnActionPerformed(evt);
/*     */       }
/*     */       
/* 251 */     });
/* 252 */     this.portBtn.setBackground(new java.awt.Color(0, 204, 204));
/* 253 */     this.portBtn.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 254 */     this.portBtn.setForeground(new java.awt.Color(255, 0, 0));
/* 255 */     this.portBtn.setText("Ports Help");
/* 256 */     this.portBtn.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 258 */         Help.this.portBtnActionPerformed(evt);
/*     */       }
/*     */       
/* 261 */     });
/* 262 */     this.musicBtn.setBackground(new java.awt.Color(0, 204, 204));
/* 263 */     this.musicBtn.setFont(new java.awt.Font("Tahoma", 0, 14));
/* 264 */     this.musicBtn.setForeground(new java.awt.Color(255, 0, 0));
/* 265 */     this.musicBtn.setText("Add My Music");
/* 266 */     this.musicBtn.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 268 */         Help.this.musicBtnActionPerformed(evt);
/*     */       }
/*     */       
/* 271 */     });
/* 272 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 273 */     this.jPanel2.setLayout(jPanel2Layout);
/* 274 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.ctrlBtn).addGap(18, 18, 18).addComponent(this.portBtn)).addGroup(jPanel2Layout.createSequentialGroup().addGap(44, 44, 44).addComponent(this.musicBtn))).addContainerGap(22, 32767)));
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
/* 288 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.portBtn).addComponent(this.ctrlBtn)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.musicBtn).addContainerGap(-1, 32767)));
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
/* 300 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 301 */     getContentPane().setLayout(layout);
/* 302 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 306 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 311 */     pack();
/*     */   }
/*     */   
/*     */   private void ctrlBtnActionPerformed(java.awt.event.ActionEvent evt) {
/* 315 */     this.Controls.setSize(150, 200);
/* 316 */     this.Controls.setVisible(true);
/*     */   }
/*     */   
/*     */   private void portBtnActionPerformed(java.awt.event.ActionEvent evt) {
/* 320 */     this.Port.setSize(280, 80);
/* 321 */     this.Port.setVisible(true);
/*     */   }
/*     */   
/*     */   private void btnActionPerformed(java.awt.event.ActionEvent evt) {
/*     */     try {
/*     */       try {
/* 327 */         java.awt.Desktop.getDesktop().browse(new java.net.URI("http://forums.afterdawn.com/thread_view.cfm/223583"));
/*     */       } catch (java.net.URISyntaxException ex) {
/* 329 */         System.err.println("Wrong url");
/*     */       }
/*     */     } catch (java.io.IOException ex) {
/* 332 */       System.err.println("Can't open url");
/*     */     }
/*     */   }
/*     */   
/*     */   private void musicBtnActionPerformed(java.awt.event.ActionEvent evt) {
/* 337 */     this.music.setSize(400, 100);
/* 338 */     this.music.setVisible(true);
/*     */   }
/*     */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\Help.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */