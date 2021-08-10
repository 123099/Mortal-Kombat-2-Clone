/*    */ package mortalkombat;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import javax.sound.sampled.AudioInputStream;
/*    */ import javax.sound.sampled.AudioSystem;
/*    */ import javax.sound.sampled.Clip;
/*    */ import javax.sound.sampled.FloatControl;
/*    */ import javax.sound.sampled.FloatControl.Type;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Audio
/*    */ {
/*    */   private String url;
/*    */   private Clip clip;
/*    */   private FloatControl volumeControl;
/*    */   
/*    */   public Audio(String url)
/*    */   {
/* 21 */     this.url = url;
/*    */     try {
/* 23 */       this.clip = AudioSystem.getClip();
/* 24 */       AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("bgm/" + url));
/* 25 */       this.clip.open(inputStream);
/* 26 */       this.volumeControl = ((FloatControl)this.clip.getControl(FloatControl.Type.MASTER_GAIN));
/*    */     } catch (Exception e) {
/* 28 */       System.err.println(e.getMessage());
/*    */     }
/*    */   }
/*    */   
/*    */   public synchronized void playSound(final boolean loop) {
/* 33 */     new Thread(new Runnable() {
/*    */       public void run() {
/*    */         try {
/* 36 */           if (loop) {
/* 37 */             Audio.this.clip.loop(-1);
/*    */           } else
/* 39 */             Audio.this.clip.start();
/*    */         } catch (Exception e) {
/* 41 */           System.err.println(e.getMessage());
/*    */         }
/*    */       }
/*    */     }).start();
/*    */   }
/*    */   
/*    */   public void stopSound() {
/* 48 */     this.clip.stop();
/*    */   }
/*    */   
/*    */   public void setVolume(float volume)
/*    */   {
/* 53 */     this.volumeControl.setValue(volume);
/*    */   }
/*    */   
/*    */   public boolean isOver() {
/* 57 */     return this.clip.getFramePosition() == this.clip.getFrameLength();
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 61 */     return this.url;
/*    */   }
/*    */   
/*    */   public float getVolume() {
/* 65 */     return this.volumeControl.getValue();
/*    */   }
/*    */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\Audio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */