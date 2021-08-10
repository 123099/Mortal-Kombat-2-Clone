/*     */ package mortalkombat;
/*     */ 
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.io.File;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class MortalKombat extends JFrame
/*     */ {
/*     */   private mainPanel p;
/*     */   private int w;
/*     */   private int h;
/*     */   private int bgX;
/*     */   private int bgW;
/*     */   private int bgH;
/*     */   private Image bg;
/*     */   private Player p1;
/*     */   private Player p2;
/*     */   private Thread p1Thread;
/*     */   private Thread p2Thread;
/*     */   private Options opt;
/*     */   private Audio[] bgm;
/*     */   private float dB;
/*     */   private int songNum;
/*     */   private int song;
/*     */   private String[] files;
/*     */   private Info info;
/*     */   
/*     */   public MortalKombat(String window_name, Options opt, Info inf)
/*     */   {
/*  33 */     super(window_name);
/*     */     
/*  35 */     this.w = opt.getResW();
/*  36 */     this.h = opt.getResH();
/*     */     
/*  38 */     this.p = new mainPanel();
/*  39 */     this.p.setSize(this.w, this.h);
/*  40 */     add(this.p);
/*     */     
/*  42 */     setSize(this.w, this.h);
/*  43 */     setResizable(false);
/*  44 */     setDefaultCloseOperation(3);
/*  45 */     this.bgX = 0;
/*  46 */     this.p1 = null;
/*  47 */     this.p2 = null;
/*     */     
/*  49 */     this.opt = opt;
/*     */     
/*  51 */     this.info = inf;
/*     */     
/*  53 */     this.info.stopMusic();
/*  54 */     this.files = new File("bgm/battle").list();
/*  55 */     this.bgm = new Audio[this.files.length];
/*  56 */     for (int i = 0; i < this.files.length; i++)
/*  57 */       this.bgm[i] = new Audio("battle/" + this.files[i]);
/*  58 */     this.song = ((int)(Math.random() * (this.bgm.length - 1 + 1) + 1.0D));
/*  59 */     this.bgm[(this.song - 1)].playSound(false);
/*  60 */     if (opt.getVolumeSet() == 0.0F) {
/*  61 */       this.dB = -80.0F;
/*     */     } else
/*  63 */       this.dB = ((float)(Math.log(opt.getVolumeSet()) / Math.log(10.0D) * 20.0D));
/*  64 */     this.bgm[(this.song - 1)].setVolume(this.dB);
/*     */   }
/*     */   
/*     */   public void addBackground(String map_name) {
/*     */     try {
/*  69 */       this.bg = javax.imageio.ImageIO.read(new File("images/maps/" + map_name));
/*  70 */       this.bgW = ((this.bg.getWidth(null) + 200) * (this.w / 600));
/*  71 */       this.bgH = this.h;
/*     */     } catch (java.io.IOException ex) {
/*  73 */       Logger.getLogger(MortalKombat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*  77 */   public int getFrameH() { return this.h; }
/*     */   
/*     */ 
/*  80 */   public int getFrameW() { return this.w; }
/*     */   
/*     */   public void addPlayer(Player p, int pNum, boolean startThread) {
/*  83 */     if (pNum == 1) {
/*  84 */       this.p1 = p;
/*  85 */       if (startThread) {
/*  86 */         this.p1Thread = new Thread(this.p1);
/*  87 */         this.p1Thread.start();
/*     */       }
/*     */     }
/*  90 */     else if (pNum == 2) {
/*  91 */       this.p2 = p;
/*  92 */       if (startThread) {
/*  93 */         this.p2Thread = new Thread(this.p2);
/*  94 */         this.p2Thread.start();
/*     */       }
/*     */     }
/*     */     else {
/*  98 */       System.err.println("Player nums are 1 or 2."); } }
/*     */   
/*     */   class mainPanel extends JPanel { mainPanel() {}
/*     */     
/* 102 */     public void paintComponent(Graphics g) { super.paintComponent(g);
/*     */       
/* 104 */       if (MortalKombat.this.bgX <= 0) {
/* 105 */         g.drawImage(MortalKombat.this.bg, MortalKombat.this.bgW + MortalKombat.this.bgX, 0, MortalKombat.this.bgW, MortalKombat.this.bgH, null);
/*     */       }
/* 107 */       if (MortalKombat.this.bgX >= 0) {
/* 108 */         g.drawImage(MortalKombat.this.bg, MortalKombat.this.bgX - MortalKombat.this.bgW, 0, MortalKombat.this.bgW, MortalKombat.this.bgH, null);
/*     */       }
/* 110 */       if ((MortalKombat.this.bgX <= -MortalKombat.this.bgW) || (MortalKombat.this.bgX >= MortalKombat.this.bgW))
/* 111 */         MortalKombat.this.bgX = 0;
/* 112 */       g.drawImage(MortalKombat.this.bg, MortalKombat.this.bgX, 0, MortalKombat.this.bgW, MortalKombat.this.bgH, null);
/*     */       
/* 114 */       MortalKombat.this.p1.drawMe(g);
/* 115 */       MortalKombat.this.p2.drawMe(g);
/*     */     }
/*     */   }
/*     */   
/* 119 */   public mainPanel getPanel() { return this.p; }
/*     */   
/*     */   public Image getBackgroundImg() {
/* 122 */     return this.bg;
/*     */   }
/*     */   
/* 125 */   public void setBgX(int n) { this.bgX = n; }
/*     */   
/*     */   public int getBgX() {
/* 128 */     return this.bgX;
/*     */   }
/*     */   
/*     */   public void startBattleMusic() {
/* 132 */     if (this.opt.getVolumeSet() == 0.0F) {
/* 133 */       this.dB = -80.0F;
/*     */     } else
/* 135 */       this.dB = ((float)(Math.log(this.opt.getVolumeSet()) / Math.log(10.0D) * 20.0D));
/* 136 */     this.bgm[(this.song - 1)].setVolume(this.dB);
/* 137 */     if (this.bgm[(this.song - 1)].isOver())
/* 138 */       nextSong();
/*     */   }
/*     */   
/*     */   public void nextSong() {
/* 142 */     this.song = ((int)(Math.random() * (this.bgm.length - 1 + 1) + 1.0D));
/* 143 */     while (this.song == this.songNum)
/* 144 */       this.song = ((int)(Math.random() * (this.bgm.length - 1 + 1) + 1.0D));
/* 145 */     this.bgm[(this.song - 1)].playSound(false);
/*     */   }
/*     */   
/*     */   public Options getOpt() {
/* 149 */     return this.opt;
/*     */   }
/*     */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\MortalKombat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */