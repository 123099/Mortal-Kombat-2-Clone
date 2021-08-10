/*    */ package mortalkombat;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Image;
/*    */ import java.io.IOException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class Health
/*    */ {
/*    */   private int Health;
/*    */   private int x;
/*    */   private int y;
/*    */   private String PlayerName;
/*    */   private Image lifebar;
/*    */   
/*    */   public Health(String name, int hp, int x, int y)
/*    */   {
/* 23 */     this.Health = hp;
/* 24 */     this.PlayerName = name;
/*    */     try {
/* 26 */       this.lifebar = ImageIO.read(new java.io.File("images/props/lifebar/0.gif"));
/*    */     } catch (IOException ex) {
/* 28 */       Logger.getLogger(Health.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/* 30 */     this.x = x;
/* 31 */     this.y = y;
/*    */   }
/*    */   
/* 34 */   public int getHP() { return this.Health; }
/*    */   
/*    */   public void setHP(int hp) {
/* 37 */     if ((hp >= 0) && (hp <= 100))
/* 38 */       this.Health = hp;
/*    */   }
/*    */   
/* 41 */   public void drawMe(Graphics g) { Graphics2D g2d = (Graphics2D)g;
/* 42 */     g2d.drawImage(this.lifebar, this.x - 1, this.y - 1, 102, 11, null);
/* 43 */     g2d.setColor(Color.green);
/* 44 */     g2d.fillRect(this.x, this.y, this.Health, 9);
/* 45 */     g2d.setColor(Color.white);
/* 46 */     g2d.setFont(new Font("Arial", 1, 12));
/* 47 */     g2d.drawString(this.PlayerName, this.x + 20, this.y / 2);
/*    */   }
/*    */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\Health.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */