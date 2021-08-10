/*     */ package mortalkombat;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class Options extends javax.swing.JFrame
/*     */ {
/*     */   private int oldVolume;
/*     */   private String oldResW;
/*     */   private String oldResH;
/*     */   private javax.swing.JButton applyBtn;
/*     */   private javax.swing.JButton cancelBtn;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JComboBox resBox;
/*     */   private javax.swing.JLabel resLbl;
/*     */   private javax.swing.JLabel volumeCount;
/*     */   private javax.swing.JLabel volumeLbl;
/*     */   private javax.swing.JSlider volumeSlider;
/*     */   
/*     */   public Options()
/*     */   {
/*  22 */     super("Options");
/*  23 */     initComponents();
/*  24 */     this.volumeCount.setText(Integer.toString(this.volumeSlider.getValue()));
/*  25 */     this.oldVolume = this.volumeSlider.getValue();
/*  26 */     this.oldResW = this.resBox.getSelectedItem().toString().split("x")[0];
/*  27 */     this.oldResH = this.resBox.getSelectedItem().toString().split("x")[1];
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
/*  39 */     this.jPanel1 = new javax.swing.JPanel();
/*  40 */     this.volumeLbl = new javax.swing.JLabel();
/*  41 */     this.volumeSlider = new javax.swing.JSlider();
/*  42 */     this.volumeCount = new javax.swing.JLabel();
/*  43 */     this.resLbl = new javax.swing.JLabel();
/*  44 */     this.resBox = new javax.swing.JComboBox();
/*  45 */     this.applyBtn = new javax.swing.JButton();
/*  46 */     this.cancelBtn = new javax.swing.JButton();
/*     */     
/*  48 */     setResizable(false);
/*     */     
/*  50 */     this.jPanel1.setBackground(new java.awt.Color(204, 204, 0));
/*     */     
/*  52 */     this.volumeLbl.setFont(new java.awt.Font("Tahoma", 0, 14));
/*  53 */     this.volumeLbl.setForeground(new java.awt.Color(102, 102, 102));
/*  54 */     this.volumeLbl.setText("Volume");
/*     */     
/*  56 */     this.volumeSlider.setBackground(new java.awt.Color(204, 204, 0));
/*  57 */     this.volumeSlider.setForeground(new java.awt.Color(0, 153, 102));
/*  58 */     this.volumeSlider.setPaintTicks(true);
/*  59 */     this.volumeSlider.setValue(100);
/*  60 */     this.volumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/*  62 */         Options.this.volumeSliderStateChanged(evt);
/*     */       }
/*  64 */     });
/*  65 */     this.volumeSlider.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
/*     */       public void propertyChange(java.beans.PropertyChangeEvent evt) {
/*  67 */         Options.this.volumeSliderPropertyChange(evt);
/*     */       }
/*     */       
/*  70 */     });
/*  71 */     this.volumeCount.setFont(new java.awt.Font("Tahoma", 0, 14));
/*  72 */     this.volumeCount.setText("count");
/*     */     
/*  74 */     this.resLbl.setFont(new java.awt.Font("Tahoma", 0, 14));
/*  75 */     this.resLbl.setForeground(new java.awt.Color(0, 0, 255));
/*  76 */     this.resLbl.setText("Resolution");
/*     */     
/*  78 */     this.resBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "700x280" }));
/*     */     
/*  80 */     this.applyBtn.setBackground(new java.awt.Color(204, 204, 0));
/*  81 */     this.applyBtn.setText("Apply");
/*  82 */     this.applyBtn.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  84 */         Options.this.applyBtnActionPerformed(evt);
/*     */       }
/*     */       
/*  87 */     });
/*  88 */     this.cancelBtn.setBackground(new java.awt.Color(204, 204, 0));
/*  89 */     this.cancelBtn.setText("Cancel");
/*  90 */     this.cancelBtn.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  92 */         Options.this.cancelBtnActionPerformed(evt);
/*     */       }
/*     */       
/*  95 */     });
/*  96 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  97 */     this.jPanel1.setLayout(jPanel1Layout);
/*  98 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.volumeLbl).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.volumeSlider, -2, 179, -2).addContainerGap(83, 32767)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.volumeCount).addGap(39, 39, 39)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.resLbl).addGap(18, 18, 18).addComponent(this.resBox, -2, 112, -2).addContainerGap())).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.applyBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cancelBtn).addContainerGap()))));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 126 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.volumeSlider, -2, -1, -2).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.volumeLbl).addComponent(this.volumeCount))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.resLbl).addComponent(this.resBox, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.applyBtn).addComponent(this.cancelBtn)).addContainerGap(-1, 32767)));
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
/* 146 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 147 */     getContentPane().setLayout(layout);
/* 148 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 152 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 157 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */   private void volumeSliderPropertyChange(java.beans.PropertyChangeEvent evt) {}
/*     */   
/*     */   private void volumeSliderStateChanged(javax.swing.event.ChangeEvent evt)
/*     */   {
/* 165 */     this.volumeCount.setText(Integer.toString(this.volumeSlider.getValue()));
/*     */   }
/*     */   
/*     */   private void applyBtnActionPerformed(java.awt.event.ActionEvent evt) {
/* 169 */     this.oldVolume = this.volumeSlider.getValue();
/* 170 */     this.oldResW = this.resBox.getSelectedItem().toString().split("x")[0];
/* 171 */     this.oldResH = this.resBox.getSelectedItem().toString().split("x")[1];
/* 172 */     setVisible(false);
/*     */   }
/*     */   
/*     */   private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
/* 176 */     this.volumeSlider.setValue(this.oldVolume);
/* 177 */     this.resBox.setSelectedItem(this.oldResW + "x" + this.oldResH);
/* 178 */     setVisible(false);
/*     */   }
/*     */   
/*     */   public float getVolumeSet() {
/* 182 */     return this.oldVolume / 100.0F;
/*     */   }
/*     */   
/*     */   public int getResW() {
/* 186 */     return Integer.parseInt(this.oldResW);
/*     */   }
/*     */   
/*     */   public int getResH() {
/* 190 */     return Integer.parseInt(this.oldResH);
/*     */   }
/*     */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\Options.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */