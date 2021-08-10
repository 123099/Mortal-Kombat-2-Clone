/*     */ package mortalkombat;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class Info extends javax.swing.JFrame implements Runnable
/*     */ {
/*     */   private Audio[] bgm;
/*     */   private int songNum;
/*     */   private int song;
/*     */   private Options opt;
/*     */   private float dB;
/*     */   private Thread t;
/*     */   private JButton helpBtn;
/*     */   private JLabel nameLbl;
/*     */   private JTextField nameTxt;
/*     */   private JButton nextBtn;
/*     */   private JButton optBtn;
/*     */   private JComboBox playerBox;
/*     */   private JLabel playerLbl;
/*     */   
/*     */   public Info()
/*     */   {
/*  33 */     super("Mortal Kombat - by Alex Hazov.");
/*  34 */     initComponents();
/*  35 */     this.opt = new Options();
/*  36 */     String[] files = new java.io.File("bgm/menu").list();
/*  37 */     this.bgm = new Audio[files.length];
/*  38 */     for (int i = 0; i < files.length; i++)
/*  39 */       this.bgm[i] = new Audio("menu/" + files[i]);
/*  40 */     this.song = ((int)(Math.random() * (this.bgm.length - 1 + 1) + 1.0D));
/*  41 */     this.bgm[(this.song - 1)].playSound(false);
/*  42 */     if (this.opt.getVolumeSet() == 0.0F) {
/*  43 */       this.dB = -80.0F;
/*     */     } else
/*  45 */       this.dB = ((float)(Math.log(this.opt.getVolumeSet()) / Math.log(10.0D) * 20.0D));
/*  46 */     this.bgm[(this.song - 1)].setVolume(this.dB);
/*  47 */     this.t = new Thread(this);
/*  48 */     this.t.start();
/*     */   }
/*     */   
/*     */   public void nextSong() {
/*  52 */     this.song = ((int)(Math.random() * (this.bgm.length - 1 + 1) + 1.0D));
/*  53 */     while (this.song == this.songNum)
/*  54 */       this.song = ((int)(Math.random() * (this.bgm.length - 1 + 1) + 1.0D));
/*  55 */     this.bgm[(this.song - 1)].playSound(false);
/*     */   }
/*     */   
/*     */   public void stopMusic() {
/*  59 */     this.bgm[(this.song - 1)].stopSound();
/*  60 */     this.t.stop();
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
/*  72 */     this.nameTxt = new JTextField();
/*  73 */     this.nameLbl = new JLabel();
/*  74 */     this.playerLbl = new JLabel();
/*  75 */     this.playerBox = new JComboBox();
/*  76 */     this.nextBtn = new JButton();
/*  77 */     this.helpBtn = new JButton();
/*  78 */     this.optBtn = new JButton();
/*     */     
/*  80 */     setDefaultCloseOperation(3);
/*  81 */     setResizable(false);
/*  82 */     addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
/*     */       public void mouseMoved(java.awt.event.MouseEvent evt) {
/*  84 */         Info.this.formMouseMoved(evt);
/*     */       }
/*     */       
/*  87 */     });
/*  88 */     this.nameLbl.setText("Name");
/*     */     
/*  90 */     this.playerLbl.setText("Player");
/*     */     
/*  92 */     this.playerBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Scorpion", "Sub-Zero", "Johnny-Cage", "Kano", "Goro", "Sonya", "Liukang" }));
/*  93 */     this.playerBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
/*     */       public void propertyChange(java.beans.PropertyChangeEvent evt) {
/*  95 */         Info.this.playerBoxPropertyChange(evt);
/*     */       }
/*     */       
/*  98 */     });
/*  99 */     this.nextBtn.setText("Next");
/* 100 */     this.nextBtn.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 102 */         Info.this.nextBtnActionPerformed(evt);
/*     */       }
/*     */       
/* 105 */     });
/* 106 */     this.helpBtn.setText("Help");
/* 107 */     this.helpBtn.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 109 */         Info.this.helpBtnActionPerformed(evt);
/*     */       }
/*     */       
/* 112 */     });
/* 113 */     this.optBtn.setText("Options");
/* 114 */     this.optBtn.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 116 */         Info.this.optBtnActionPerformed(evt);
/*     */       }
/*     */       
/* 119 */     });
/* 120 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 121 */     getContentPane().setLayout(layout);
/* 122 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.nameLbl).addGap(18, 18, 18).addComponent(this.nameTxt, -1, 148, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.playerLbl).addGap(18, 18, 18).addComponent(this.playerBox, 0, 145, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.helpBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.nextBtn).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.optBtn, -1, 73, 32767))).addGap(133, 133, 133)));
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
/* 143 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.nameLbl).addComponent(this.nameTxt, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.playerLbl).addComponent(this.playerBox, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.helpBtn).addComponent(this.nextBtn).addComponent(this.optBtn)).addContainerGap(14, 32767)));
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
/* 162 */     pack();
/*     */   }
/*     */   
/*     */   private void nextBtnActionPerformed(ActionEvent evt) {
/* 166 */     if (this.nameTxt.getText().equals("")) {
/* 167 */       javax.swing.JOptionPane.showMessageDialog(null, "Please fill in your name/nickname.");
/*     */     } else {
/* 169 */       new HostOrClient(this.nameTxt.getText(), this.playerBox.getSelectedItem().toString(), this.opt, this).setVisible(true);
/* 170 */       setVisible(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void helpBtnActionPerformed(ActionEvent evt) {
/* 175 */     new Help().setVisible(true);
/*     */   }
/*     */   
/*     */   private void playerBoxPropertyChange(java.beans.PropertyChangeEvent evt) {
/* 179 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void formMouseMoved(java.awt.event.MouseEvent evt) {}
/*     */   
/*     */ 
/* 187 */   private void optBtnActionPerformed(ActionEvent evt) { this.opt.setVisible(true); }
/*     */   
/*     */   public void paint(java.awt.Graphics g) {
/* 190 */     super.paint(g);
/*     */     try {
/* 192 */       g.clearRect(210, 0, 100, 200);
/* 193 */       g.drawImage(javax.imageio.ImageIO.read(new java.io.File("images/players/" + this.playerBox.getSelectedItem().toString() + "/show/0.gif")), 230, 30, 70, 130, null);
/*     */     } catch (java.io.IOException ex) {
/* 195 */       Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 208 */       for (javax.swing.UIManager.LookAndFeelInfo info : ) {
/* 209 */         if ("Nimbus".equals(info.getName())) {
/* 210 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 211 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 215 */       Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 217 */       Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 219 */       Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 221 */       Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 226 */     java.awt.EventQueue.invokeLater(new Runnable()
/*     */     {
/*     */       public void run() {
/* 229 */         new Info().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void run()
/*     */   {
/*     */     for (;;)
/*     */     {
/* 246 */       repaint();
/*     */       try {
/* 248 */         if (this.opt.getVolumeSet() == 0.0F) {
/* 249 */           this.dB = -80.0F;
/*     */         } else
/* 251 */           this.dB = ((float)(Math.log(this.opt.getVolumeSet()) / Math.log(10.0D) * 20.0D));
/* 252 */         this.bgm[(this.song - 1)].setVolume(this.dB);
/* 253 */         if (this.bgm[(this.song - 1)].isOver())
/* 254 */           nextSong();
/* 255 */         Thread.sleep(300L);
/*     */       } catch (InterruptedException ex) {
/* 257 */         Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\Info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */