/*     */ package mortalkombat;
/*     */ 
/*     */ import java.awt.Image;
/*     */ 
/*     */ public class Player implements Runnable, java.awt.event.KeyListener
/*     */ {
/*     */   private String name;
/*     */   private MortalKombat mk;
/*     */   private int x;
/*     */   private int y;
/*     */   private int nameX;
/*     */   private int hpX;
/*     */   private int hpY;
/*     */   private int walkingSpeed;
/*     */   private String pName;
/*     */   private Health hp;
/*     */   private Player oPlayer;
/*     */   private boolean standing;
/*     */   private boolean walkingLeft;
/*     */   private boolean walkingRight;
/*     */   private boolean ducking;
/*     */   private boolean punchingA;
/*     */   private boolean kickingA;
/*     */   private boolean kickingB;
/*     */   private boolean kickingC;
/*     */   private boolean beingHit1;
/*     */   private boolean addListener;
/*     */   private boolean lookingRight;
/*     */   private boolean lookingLeft;
/*     */   private boolean restart;
/*     */   private Image[] standImgs;
/*     */   private int curStandImg;
/*     */   private Image[] walkImgs;
/*     */   private int curWalkImg;
/*     */   private Image[] duckImgs;
/*     */   private int curDuckImg;
/*     */   private Image[] punchAImgs;
/*     */   private int curPunchAImg;
/*     */   private Image[] kickAImgs;
/*     */   private int curKickAImg;
/*     */   private Image[] kickBImgs;
/*     */   private int curKickBImg;
/*     */   private Image[] kickCImgs;
/*     */   private int curKickCImg;
/*     */   private Image[] beingHit1Imgs;
/*     */   private int curBeingHit1Img;
/*     */   private int[] standW;
/*     */   private int[] standH;
/*     */   private int[] walkW;
/*     */   private int[] walkH;
/*     */   private int[] duckW;
/*     */   private int[] duckH;
/*     */   private int[] punchAW;
/*     */   private int[] punchAH;
/*     */   private int[] kickAW;
/*     */   private int[] kickAH;
/*     */   private int[] kickBW;
/*     */   private int[] kickBH;
/*     */   private int[] kickCW;
/*     */   private int[] kickCH;
/*     */   private int[] beingHit1W;
/*     */   private int[] beingHit1H;
/*     */   private int tempY;
/*     */   private int defaultX;
/*     */   private int defaultY;
/*     */   
/*     */   public Player(String name, String playersName, MortalKombat mk, int x, int y, int hpX, int hpY, boolean addListener) {
/*  68 */     this.name = name;
/*  69 */     this.pName = playersName;
/*  70 */     this.mk = mk;
/*  71 */     this.x = x;
/*  72 */     this.y = y;
/*  73 */     this.hpX = hpX;
/*  74 */     this.hpY = hpY;
/*  75 */     this.addListener = addListener;
/*  76 */     this.defaultX = x;
/*  77 */     this.defaultY = y;
/*  78 */     this.nameX = ((int)(x + 3.33D * mk.getFrameW() / 100.0D));
/*  79 */     this.walkingSpeed = 5;
/*  80 */     this.standing = true;
/*  81 */     this.walkingLeft = false;
/*  82 */     this.walkingRight = false;
/*  83 */     this.ducking = false;
/*  84 */     this.punchingA = false;
/*  85 */     this.kickingA = false;
/*  86 */     this.kickingB = false;
/*  87 */     this.kickingC = false;
/*  88 */     this.beingHit1 = false;
/*  89 */     this.lookingRight = false;
/*  90 */     this.lookingLeft = false;
/*  91 */     this.restart = false;
/*  92 */     name = name.toLowerCase();
/*     */     
/*  94 */     this.tempY = y;
/*     */     
/*  96 */     this.hp = new Health(playersName, 100, hpX, hpY);
/*     */     
/*     */ 
/*  99 */     this.standImgs = new Image[new java.io.File("images/players/" + name + "/stand").list().length];
/* 100 */     this.standW = new int[this.standImgs.length];
/* 101 */     this.standH = new int[this.standImgs.length];
/* 102 */     this.curStandImg = 0;
/* 103 */     for (int i = 0; i < this.standImgs.length; i++) {
/* 104 */       loadImg(this.standImgs, i, "images/players/" + name + "/stand/" + i + ".gif", this.standW, this.standH);
/*     */     }
/* 106 */     this.walkImgs = new Image[new java.io.File("images/players/" + name + "/walk").list().length];
/* 107 */     this.walkW = new int[this.walkImgs.length];
/* 108 */     this.walkH = new int[this.walkImgs.length];
/* 109 */     this.curWalkImg = 0;
/* 110 */     for (int i = 0; i < this.walkImgs.length; i++) {
/* 111 */       loadImg(this.walkImgs, i, "images/players/" + name + "/walk/" + i + ".gif", this.walkW, this.walkH);
/*     */     }
/* 113 */     this.duckImgs = new Image[new java.io.File("images/players/" + name + "/duck").list().length];
/* 114 */     this.duckW = new int[this.duckImgs.length];
/* 115 */     this.duckH = new int[this.duckImgs.length];
/* 116 */     this.curDuckImg = 0;
/* 117 */     for (int i = 0; i < this.duckImgs.length; i++) {
/* 118 */       loadImg(this.duckImgs, i, "images/players/" + name + "/duck/" + i + ".gif", this.duckW, this.duckH);
/*     */     }
/* 120 */     this.punchAImgs = new Image[new java.io.File("images/players/" + name + "/punch/punchA").list().length];
/* 121 */     this.punchAW = new int[this.punchAImgs.length];
/* 122 */     this.punchAH = new int[this.punchAImgs.length];
/* 123 */     this.curPunchAImg = 0;
/* 124 */     for (int i = 0; i < this.punchAImgs.length; i++) {
/* 125 */       loadImg(this.punchAImgs, i, "images/players/" + name + "/punch/punchA/" + i + ".gif", this.punchAW, this.punchAH);
/*     */     }
/* 127 */     this.kickAImgs = new Image[new java.io.File("images/players/" + name + "/kick/kickA").list().length];
/* 128 */     this.kickAW = new int[this.kickAImgs.length];
/* 129 */     this.kickAH = new int[this.kickAImgs.length];
/* 130 */     this.curKickAImg = 0;
/* 131 */     for (int i = 0; i < this.kickAImgs.length; i++) {
/* 132 */       loadImg(this.kickAImgs, i, "images/players/" + name + "/kick/kickA/" + i + ".gif", this.kickAW, this.kickAH);
/*     */     }
/* 134 */     this.kickBImgs = new Image[new java.io.File("images/players/" + name + "/kick/kickB").list().length];
/* 135 */     this.kickBW = new int[this.kickBImgs.length];
/* 136 */     this.kickBH = new int[this.kickBImgs.length];
/* 137 */     this.curKickBImg = 0;
/* 138 */     for (int i = 0; i < this.kickBImgs.length; i++) {
/* 139 */       loadImg(this.kickBImgs, i, "images/players/" + name + "/kick/kickB/" + i + ".gif", this.kickBW, this.kickBH);
/*     */     }
/* 141 */     this.kickCImgs = new Image[new java.io.File("images/players/" + name + "/kick/kickC").list().length];
/* 142 */     this.kickCW = new int[this.kickCImgs.length];
/* 143 */     this.kickCH = new int[this.kickCImgs.length];
/* 144 */     this.curKickCImg = 0;
/* 145 */     for (int i = 0; i < this.kickCImgs.length; i++) {
/* 146 */       loadImg(this.kickCImgs, i, "images/players/" + name + "/kick/kickC/" + i + ".gif", this.kickCW, this.kickCH);
/*     */     }
/* 148 */     this.beingHit1Imgs = new Image[new java.io.File("images/players/" + name + "/beingHit/beingHit1").list().length];
/* 149 */     this.beingHit1W = new int[this.beingHit1Imgs.length];
/* 150 */     this.beingHit1H = new int[this.beingHit1Imgs.length];
/* 151 */     this.curBeingHit1Img = 0;
/* 152 */     for (int i = 0; i < this.beingHit1Imgs.length; i++)
/* 153 */       loadImg(this.beingHit1Imgs, i, "images/players/" + name + "/beingHit/beingHit1/" + i + ".gif", this.beingHit1W, this.beingHit1H);
/* 154 */     if (addListener)
/* 155 */       mk.addKeyListener(this);
/*     */   }
/*     */   
/* 158 */   public void setRestart(boolean b) { this.restart = b; }
/*     */   
/*     */   public void addOtherPlayer(Player p) {
/* 161 */     this.oPlayer = p;
/*     */   }
/*     */   
/* 164 */   public String getPlayersName() { return this.pName; }
/*     */   
/*     */   public int getHpX() {
/* 167 */     return this.hpX;
/*     */   }
/*     */   
/* 170 */   public int getHpY() { return this.hpY; }
/*     */   
/*     */ 
/* 173 */   public boolean isAlive() { return this.hp.getHP() > 0; }
/*     */   
/*     */   public void drawMe(java.awt.Graphics g) {
/* 176 */     g.setColor(java.awt.Color.white);
/* 177 */     g.setFont(new java.awt.Font("Arial", 1, 13));
/* 178 */     if (getLookDirection().equals("left")) {
/* 179 */       g.drawString(this.pName, this.x + this.standW[0], this.y - 10);
/*     */     } else
/* 181 */       g.drawString(this.pName, this.x, this.y - 10);
/* 182 */     this.hp.drawMe(g);
/* 183 */     if (this.standing)
/* 184 */       g.drawImage(this.standImgs[this.curStandImg], this.x, this.y, this.standW[this.curStandImg], this.standH[this.curStandImg], null);
/* 185 */     if ((this.walkingLeft) || (this.walkingRight))
/* 186 */       g.drawImage(this.walkImgs[this.curWalkImg], this.x, this.y, this.walkW[this.curWalkImg], this.walkH[this.curWalkImg], null);
/* 187 */     if (this.ducking)
/* 188 */       g.drawImage(this.duckImgs[this.curDuckImg], this.x, this.y, this.duckW[this.curDuckImg], this.duckH[this.curDuckImg], null);
/* 189 */     if (this.punchingA)
/* 190 */       g.drawImage(this.punchAImgs[this.curPunchAImg], this.x, this.y, this.punchAW[this.curPunchAImg], this.punchAH[this.curPunchAImg], null);
/* 191 */     if (this.kickingA)
/* 192 */       g.drawImage(this.kickAImgs[this.curKickAImg], this.x, this.y, this.kickAW[this.curKickAImg], this.kickAH[this.curKickAImg], null);
/* 193 */     if (this.kickingB)
/* 194 */       g.drawImage(this.kickBImgs[this.curKickBImg], this.x, this.y, this.kickBW[this.curKickBImg], this.kickBH[this.curKickBImg], null);
/* 195 */     if (this.kickingC)
/* 196 */       g.drawImage(this.kickCImgs[this.curKickCImg], this.x, this.y, this.kickCW[this.curKickCImg], this.kickCH[this.curKickCImg], null);
/* 197 */     if (this.beingHit1)
/* 198 */       g.drawImage(this.beingHit1Imgs[this.curBeingHit1Img], this.x, this.y, this.beingHit1W[this.curBeingHit1Img], this.beingHit1H[this.curBeingHit1Img], null);
/* 199 */     if ((!isAlive()) && (this.oPlayer != null) && (this.oPlayer.isAlive())) {
/* 200 */       g.setFont(new java.awt.Font("Arial", 1, 20));
/* 201 */       g.setColor(java.awt.Color.red);
/* 202 */       g.drawString("You have lost...", this.mk.getFrameW() / 2 - 160, this.mk.getFrameH() / 2 - 10);
/* 203 */     } else if ((this.oPlayer != null) && (!this.oPlayer.isAlive()) && (isAlive())) {
/* 204 */       g.setFont(new java.awt.Font("Arial", 1, 20));
/* 205 */       g.setColor(java.awt.Color.red);
/* 206 */       g.drawString("You Have Won!!!", this.mk.getFrameW() / 2 - 160, this.mk.getFrameH() / 2 - 10);
/* 207 */     } else if ((this.oPlayer != null) && (!this.oPlayer.isAlive()) && (!isAlive())) {
/* 208 */       g.setFont(new java.awt.Font("Arial", 1, 20));
/* 209 */       g.setColor(java.awt.Color.red);
/* 210 */       g.drawString("Tie!!", this.mk.getFrameW() / 2 - 160, this.mk.getFrameH() / 2 - 10);
/*     */     }
/*     */   }
/*     */   
/* 214 */   public int getMaxStateNum(String state) { if (state.equals("standing"))
/* 215 */       return this.standImgs.length;
/* 216 */     if ((state.equals("walkingLeft")) || (state.equals("walkingRight")))
/* 217 */       return this.walkImgs.length;
/* 218 */     if (state.equals("punchingA"))
/* 219 */       return this.punchAImgs.length;
/* 220 */     if (state.equals("kickingA"))
/* 221 */       return this.kickAImgs.length;
/* 222 */     if (state.equals("kickingB"))
/* 223 */       return this.kickBImgs.length;
/* 224 */     if (state.equals("kickingC"))
/* 225 */       return this.kickCImgs.length;
/* 226 */     if (state.equals("beingHit1")) {
/* 227 */       return this.beingHit1Imgs.length;
/*     */     }
/* 229 */     return this.duckImgs.length;
/*     */   }
/*     */   
/* 232 */   public void setLookDirection(String dir) { if (dir.equals("left")) {
/* 233 */       for (int i = 0; i < this.standW.length; i++)
/* 234 */         this.standW[i] = (-this.standImgs[this.curStandImg].getWidth(null));
/* 235 */       for (int i = 0; i < this.walkW.length; i++)
/* 236 */         this.walkW[i] = (-this.walkImgs[this.curWalkImg].getWidth(null));
/* 237 */       for (int i = 0; i < this.duckW.length; i++)
/* 238 */         this.duckW[i] = (-this.duckImgs[this.curDuckImg].getWidth(null));
/* 239 */       for (int i = 0; i < this.punchAW.length; i++)
/* 240 */         this.punchAW[i] = (-this.punchAImgs[this.curPunchAImg].getWidth(null));
/* 241 */       for (int i = 0; i < this.kickAW.length; i++)
/* 242 */         this.kickAW[i] = (-this.kickAImgs[this.curKickAImg].getWidth(null));
/* 243 */       for (int i = 0; i < this.kickBW.length; i++)
/* 244 */         this.kickBW[i] = (-this.kickBImgs[this.curKickBImg].getWidth(null));
/* 245 */       for (int i = 0; i < this.kickCW.length; i++)
/* 246 */         this.kickCW[i] = (-this.kickCImgs[this.curKickCImg].getWidth(null));
/* 247 */       for (int i = 0; i < this.beingHit1W.length; i++)
/* 248 */         this.beingHit1W[i] = (-this.beingHit1Imgs[this.curBeingHit1Img].getWidth(null));
/* 249 */       if (!this.lookingLeft) {
/* 250 */         this.x -= this.standW[0];
/* 251 */         this.lookingLeft = true;
/* 252 */         this.lookingRight = false;
/*     */       }
/*     */     } else {
/* 255 */       if (!this.lookingRight) {
/* 256 */         this.x += this.standW[0];
/* 257 */         this.lookingRight = true;
/* 258 */         this.lookingLeft = false;
/*     */       }
/* 260 */       for (int i = 0; i < this.standW.length; i++)
/* 261 */         this.standW[i] = this.standImgs[this.curStandImg].getWidth(null);
/* 262 */       for (int i = 0; i < this.walkW.length; i++)
/* 263 */         this.walkW[i] = this.walkImgs[this.curWalkImg].getWidth(null);
/* 264 */       for (int i = 0; i < this.duckW.length; i++)
/* 265 */         this.duckW[i] = this.duckImgs[this.curDuckImg].getWidth(null);
/* 266 */       for (int i = 0; i < this.punchAW.length; i++)
/* 267 */         this.punchAW[i] = this.punchAImgs[this.curPunchAImg].getWidth(null);
/* 268 */       for (int i = 0; i < this.kickAW.length; i++)
/* 269 */         this.kickAW[i] = this.kickAImgs[this.curKickAImg].getWidth(null);
/* 270 */       for (int i = 0; i < this.kickBW.length; i++)
/* 271 */         this.kickBW[i] = this.kickBImgs[this.curKickBImg].getWidth(null);
/* 272 */       for (int i = 0; i < this.kickCW.length; i++)
/* 273 */         this.kickCW[i] = this.kickCImgs[this.curKickCImg].getWidth(null);
/* 274 */       for (int i = 0; i < this.beingHit1W.length; i++)
/* 275 */         this.beingHit1W[i] = this.beingHit1Imgs[this.curBeingHit1Img].getWidth(null);
/*     */     }
/*     */   }
/*     */   
/* 279 */   public int getWidth() { return this.standW[0]; }
/*     */   
/*     */ 
/* 282 */   public int getY() { return this.y; }
/*     */   
/*     */   public String getState() {
/* 285 */     if (this.walkingLeft)
/* 286 */       return "walkingLeft";
/* 287 */     if (this.walkingRight)
/* 288 */       return "walkingRight";
/* 289 */     if (this.punchingA)
/* 290 */       return "punchingA";
/* 291 */     if (this.ducking)
/* 292 */       return "ducking";
/* 293 */     if (this.kickingA)
/* 294 */       return "kickingA";
/* 295 */     if (this.kickingB)
/* 296 */       return "kickingB";
/* 297 */     if (this.kickingC)
/* 298 */       return "kickingC";
/* 299 */     if (this.beingHit1) {
/* 300 */       return "beingHit1";
/*     */     }
/* 302 */     return "standing";
/*     */   }
/*     */   
/* 305 */   public int getStateNum(String state) { if (state.equals("standing"))
/* 306 */       return this.curStandImg;
/* 307 */     if ((state.equals("walkingLeft")) || (state.equals("walkingRight")))
/* 308 */       return this.curWalkImg;
/* 309 */     if (state.equals("punchingA"))
/* 310 */       return this.curPunchAImg;
/* 311 */     if (state.equals("kickingA"))
/* 312 */       return this.curKickAImg;
/* 313 */     if (state.equals("kickingB"))
/* 314 */       return this.curKickBImg;
/* 315 */     if (state.equals("kickingC"))
/* 316 */       return this.curKickCImg;
/* 317 */     if (state.equals("beingHit1")) {
/* 318 */       return this.curBeingHit1Img;
/*     */     }
/* 320 */     return this.curDuckImg;
/*     */   }
/*     */   
/* 323 */   public void setY(int y) { this.y = y; }
/*     */   
/*     */   public void setState(String state, int stateNum) {
/* 326 */     if (state.equals("standing")) {
/* 327 */       this.standing = true;
/* 328 */       this.walkingLeft = false;
/* 329 */       this.walkingRight = false;
/* 330 */       this.punchingA = false;
/* 331 */       this.ducking = false;
/* 332 */       this.kickingA = false;
/* 333 */       this.kickingB = false;
/* 334 */       this.kickingC = false;
/* 335 */       this.beingHit1 = false;
/* 336 */       this.curStandImg = stateNum;
/*     */     }
/* 338 */     else if (state.equals("walkingLeft"))
/*     */     {
/* 340 */       this.standing = false;
/* 341 */       this.walkingLeft = true;
/* 342 */       this.walkingRight = false;
/* 343 */       this.punchingA = false;
/* 344 */       this.ducking = false;
/* 345 */       this.kickingA = false;
/* 346 */       this.kickingB = false;
/* 347 */       this.kickingC = false;
/* 348 */       this.beingHit1 = false;
/* 349 */       this.curWalkImg = stateNum;
/*     */     }
/* 351 */     else if (state.equals("walkingRight"))
/*     */     {
/* 353 */       this.standing = false;
/* 354 */       this.walkingLeft = false;
/* 355 */       this.walkingRight = true;
/* 356 */       this.punchingA = false;
/* 357 */       this.ducking = false;
/* 358 */       this.kickingA = false;
/* 359 */       this.kickingB = false;
/* 360 */       this.kickingC = false;
/* 361 */       this.beingHit1 = false;
/* 362 */       this.curWalkImg = stateNum;
/*     */     }
/* 364 */     else if (state.equals("punchingA"))
/*     */     {
/* 366 */       this.standing = false;
/* 367 */       this.walkingLeft = false;
/* 368 */       this.walkingRight = false;
/* 369 */       this.punchingA = true;
/* 370 */       this.ducking = false;
/* 371 */       this.kickingA = false;
/* 372 */       this.kickingB = false;
/* 373 */       this.kickingC = false;
/* 374 */       this.beingHit1 = false;
/* 375 */       this.curPunchAImg = stateNum;
/*     */     }
/* 377 */     else if (state.equals("ducking")) {
/* 378 */       this.standing = false;
/* 379 */       this.walkingLeft = false;
/* 380 */       this.walkingRight = false;
/* 381 */       this.punchingA = false;
/* 382 */       this.ducking = true;
/* 383 */       this.kickingA = false;
/* 384 */       this.kickingB = false;
/* 385 */       this.kickingC = false;
/* 386 */       this.beingHit1 = false;
/* 387 */       this.curDuckImg = stateNum;
/*     */     }
/* 389 */     else if (state.equals("kickingA")) {
/* 390 */       this.standing = false;
/* 391 */       this.walkingLeft = false;
/* 392 */       this.walkingRight = false;
/* 393 */       this.punchingA = false;
/* 394 */       this.ducking = false;
/* 395 */       this.kickingA = true;
/* 396 */       this.kickingB = false;
/* 397 */       this.kickingC = false;
/* 398 */       this.beingHit1 = false;
/* 399 */       this.curKickAImg = stateNum;
/*     */     }
/* 401 */     else if (state.equals("kickingB")) {
/* 402 */       this.standing = false;
/* 403 */       this.walkingLeft = false;
/* 404 */       this.walkingRight = false;
/* 405 */       this.punchingA = false;
/* 406 */       this.ducking = false;
/* 407 */       this.kickingA = false;
/* 408 */       this.kickingB = true;
/* 409 */       this.kickingC = false;
/* 410 */       this.beingHit1 = false;
/* 411 */       this.curKickBImg = stateNum;
/*     */     }
/* 413 */     else if (state.equals("kickingC")) {
/* 414 */       this.standing = false;
/* 415 */       this.walkingLeft = false;
/* 416 */       this.walkingRight = false;
/* 417 */       this.punchingA = false;
/* 418 */       this.ducking = false;
/* 419 */       this.kickingA = false;
/* 420 */       this.kickingB = false;
/* 421 */       this.kickingC = true;
/* 422 */       this.beingHit1 = false;
/* 423 */       this.curKickCImg = stateNum;
/*     */     }
/* 425 */     else if (state.equals("beingHit1"))
/*     */     {
/* 427 */       this.standing = false;
/* 428 */       this.walkingLeft = false;
/* 429 */       this.walkingRight = false;
/* 430 */       this.punchingA = false;
/* 431 */       this.ducking = false;
/* 432 */       this.kickingA = false;
/* 433 */       this.kickingB = false;
/* 434 */       this.kickingC = false;
/* 435 */       this.beingHit1 = true;
/* 436 */       this.curBeingHit1Img = stateNum;
/*     */     }
/*     */   }
/*     */   
/*     */   public Player getOtherPlayer() {
/* 441 */     return this.oPlayer;
/*     */   }
/*     */   
/* 444 */   public Health getHPFIeld() { return this.hp; }
/*     */   
/*     */   public String getLookDirection() {
/* 447 */     if (this.standW[0] < 0) {
/* 448 */       return "left";
/*     */     }
/* 450 */     return "right";
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     for (;;) {
/* 455 */       if ((!this.ducking) && (!this.kickingC) && ((this.y < this.defaultY) || (this.y > this.defaultY)))
/* 456 */         this.y = this.defaultY;
/* 457 */       if (this.ducking)
/* 458 */         this.y = ((int)(this.tempY + 5.35D * this.mk.getHeight() / 100.0D));
/* 459 */       if (this.kickingC)
/* 460 */         this.y = ((int)(this.tempY + 12.5D * this.mk.getHeight() / 100.0D));
/* 461 */       if (this.x > this.oPlayer.getX()) {
/* 462 */         setLookDirection("left");
/* 463 */         this.oPlayer.setLookDirection("right");
/*     */       }
/*     */       else {
/* 466 */         setLookDirection("right");
/* 467 */         this.oPlayer.setLookDirection("left");
/*     */       }
/*     */       
/* 470 */       if ((this.standing) && (!this.beingHit1))
/* 471 */         if (this.curStandImg + 1 < this.standImgs.length) {
/* 472 */           this.mk.repaint();
/* 473 */           this.curStandImg += 1;
/* 474 */           sleep(85);
/*     */         } else {
/* 476 */           this.curStandImg = 0;
/*     */         }
/* 478 */       if ((this.walkingLeft) && (!this.beingHit1)) {
/* 479 */         moveLeft();
/* 480 */         sleep(20);
/*     */       }
/* 482 */       if ((this.walkingRight) && (!this.beingHit1)) {
/* 483 */         moveRight();
/* 484 */         sleep(20);
/*     */       }
/* 486 */       if ((this.ducking) && (!this.beingHit1)) {
/* 487 */         if (this.curDuckImg + 1 < this.duckImgs.length) {
/* 488 */           this.curDuckImg += 1;
/*     */         } else
/* 490 */           this.curDuckImg = (this.duckImgs.length - 1);
/* 491 */         this.mk.repaint();
/* 492 */         sleep(80);
/*     */       }
/* 494 */       if ((this.punchingA) && (!this.beingHit1)) {
/* 495 */         setState("punchingA", this.curPunchAImg);
/* 496 */         if (this.curPunchAImg + 1 < this.punchAImgs.length) {
/* 497 */           this.curPunchAImg += 1;
/*     */         } else {
/* 499 */           sleep(250);
/* 500 */           this.curPunchAImg = 0;
/* 501 */           this.curStandImg = 0;
/* 502 */           this.curWalkImg = 0;
/* 503 */           this.curDuckImg = 0;
/* 504 */           setState("standing", this.curStandImg);
/*     */         }
/* 506 */         this.mk.repaint();
/* 507 */         sleep(100);
/*     */       }
/* 509 */       if ((this.kickingA) && (!this.beingHit1)) {
/* 510 */         setState("kickingA", this.curKickAImg);
/* 511 */         if (this.curKickAImg + 1 < this.kickAImgs.length) {
/* 512 */           this.curKickAImg += 1;
/*     */         } else {
/* 514 */           sleep(250);
/* 515 */           this.curKickAImg = 0;
/* 516 */           this.curKickBImg = 0;
/* 517 */           this.curKickCImg = 0;
/* 518 */           this.curStandImg = 0;
/* 519 */           this.curWalkImg = 0;
/* 520 */           this.curDuckImg = 0;
/* 521 */           setState("standing", this.curStandImg);
/*     */         }
/* 523 */         this.mk.repaint();
/* 524 */         sleep(100);
/*     */       }
/* 526 */       if ((this.kickingB) && (!this.beingHit1)) {
/* 527 */         setState("kickingB", this.curKickBImg);
/* 528 */         if (this.curKickBImg + 1 < this.kickBImgs.length) {
/* 529 */           this.curKickBImg += 1;
/*     */         } else {
/* 531 */           sleep(250);
/* 532 */           this.curKickAImg = 0;
/* 533 */           this.curKickBImg = 0;
/* 534 */           this.curKickCImg = 0;
/* 535 */           this.curStandImg = 0;
/* 536 */           this.curWalkImg = 0;
/* 537 */           this.curDuckImg = 0;
/* 538 */           setState("standing", this.curStandImg);
/*     */         }
/* 540 */         this.mk.repaint();
/* 541 */         sleep(100);
/*     */       }
/* 543 */       if ((this.kickingC) && (!this.beingHit1)) {
/* 544 */         setState("kickingC", this.curKickCImg);
/* 545 */         if (this.curKickCImg + 1 < this.kickCImgs.length) {
/* 546 */           this.curKickCImg += 1;
/*     */         } else {
/* 548 */           sleep(500);
/* 549 */           this.curKickAImg = 0;
/* 550 */           this.curKickBImg = 0;
/* 551 */           this.curKickCImg = 0;
/* 552 */           this.curStandImg = 0;
/* 553 */           this.curWalkImg = 0;
/* 554 */           this.curDuckImg = (this.duckImgs.length - 1);
/* 555 */           setState("ducking", this.curDuckImg);
/*     */         }
/* 557 */         this.mk.repaint();
/* 558 */         sleep(100);
/*     */       }
/* 560 */       if ((this.oPlayer != null) && (this.oPlayer.getState().equals("beingHit1"))) {
/* 561 */         this.oPlayer.setState("beingHit1", this.curBeingHit1Img);
/* 562 */         if (this.oPlayer.getStateNum("beingHit1") + 1 < this.oPlayer.getMaxStateNum("beingHit1")) {
/* 563 */           this.oPlayer.setState("beingHit1", this.oPlayer.getStateNum("beingHit1") + 1);
/*     */         } else {
/* 565 */           sleep(100);
/* 566 */           this.oPlayer.setState("standing", 0);
/*     */         }
/* 568 */         this.mk.repaint();
/* 569 */         sleep(100);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/* 574 */   public boolean restart() { return this.restart; }
/*     */   
/*     */   public String getName() {
/* 577 */     return this.pName;
/*     */   }
/*     */   
/*     */ 
/*     */   public void keyTyped(java.awt.event.KeyEvent e) {}
/*     */   
/*     */   public void keyPressed(java.awt.event.KeyEvent e)
/*     */   {
/* 585 */     if ((!this.punchingA) && (!this.kickingA) && (!this.kickingB) && (!this.kickingC)) {
/* 586 */       if (!this.ducking) {
/* 587 */         if (e.getKeyCode() == 39)
/*     */         {
/* 589 */           this.ducking = false;
/* 590 */           this.standing = false;
/* 591 */           this.walkingRight = true;
/*     */         }
/* 593 */         if (e.getKeyCode() == 37)
/*     */         {
/* 595 */           this.ducking = false;
/* 596 */           this.standing = false;
/* 597 */           this.walkingLeft = true;
/*     */         }
/*     */       }
/* 600 */       if (e.getKeyCode() == 17)
/*     */       {
/* 602 */         this.standing = false;
/* 603 */         this.walkingLeft = false;
/* 604 */         this.walkingRight = false;
/* 605 */         this.ducking = (!this.ducking);
/*     */       }
/* 607 */       if (e.getKeyCode() == 65)
/*     */       {
/* 609 */         if (!this.punchingA) {
/* 610 */           if (this.oPlayer.getLookDirection().equals("right")) {
/* 611 */             if ((this.x + this.punchAW[this.curPunchAImg] >= this.oPlayer.getX()) && (this.x + this.punchAW[this.curPunchAImg] <= this.oPlayer.getX() + this.oPlayer.getWidth()) && (!this.oPlayer.getState().equals("ducking")) && (!this.oPlayer.getState().equals("kickingC")))
/*     */             {
/* 613 */               decreaseHp(10, this.oPlayer);
/* 614 */               this.oPlayer.setState("beingHit1", 0);
/*     */             }
/*     */           }
/* 617 */           else if ((this.x + this.punchAW[this.curPunchAImg] >= this.oPlayer.getX() + this.oPlayer.getWidth()) && (this.x + this.punchAW[this.curPunchAImg] <= this.oPlayer.getX()) && (!this.oPlayer.getState().equals("ducking")) && (!this.oPlayer.getState().equals("kickingC")))
/*     */           {
/* 619 */             decreaseHp(10, this.oPlayer);
/* 620 */             this.oPlayer.setState("beingHit1", 0);
/*     */           }
/*     */         }
/*     */         
/* 624 */         this.standing = false;
/* 625 */         this.ducking = false;
/* 626 */         this.walkingLeft = false;
/* 627 */         this.walkingRight = false;
/* 628 */         this.kickingC = false;
/* 629 */         this.kickingA = false;
/* 630 */         this.kickingB = false;
/* 631 */         this.punchingA = true;
/*     */       }
/* 633 */       if (e.getKeyCode() == 83)
/*     */       {
/* 635 */         if (!this.kickingA) {
/* 636 */           if (this.oPlayer.getLookDirection().equals("right")) {
/* 637 */             if ((this.x + this.kickAW[this.curKickAImg] >= this.oPlayer.getX()) && (this.x + this.kickAW[this.curKickAImg] <= this.oPlayer.getX() + this.oPlayer.getWidth()) && (!this.oPlayer.getState().equals("ducking")) && (!this.oPlayer.getState().equals("kickingC"))) {
/* 638 */               decreaseHp(15, this.oPlayer);
/*     */             }
/* 640 */           } else if ((this.x + this.kickAW[this.curKickAImg] >= this.oPlayer.getX() + this.oPlayer.getWidth()) && (this.x + this.kickAW[this.curKickAImg] <= this.oPlayer.getX()) && (!this.oPlayer.getState().equals("ducking")) && (!this.oPlayer.getState().equals("kickingC")))
/* 641 */             decreaseHp(15, this.oPlayer);
/*     */         }
/* 643 */         this.standing = false;
/* 644 */         this.ducking = false;
/* 645 */         this.walkingLeft = false;
/* 646 */         this.walkingRight = false;
/* 647 */         this.punchingA = false;
/* 648 */         this.kickingA = true;
/* 649 */         this.kickingC = false;
/* 650 */         this.kickingB = false;
/*     */       }
/* 652 */       if (e.getKeyCode() == 68)
/*     */       {
/* 654 */         if (!this.kickingB) {
/* 655 */           if (this.oPlayer.getLookDirection().equals("right")) {
/* 656 */             if ((this.x + this.kickBW[this.curKickBImg] >= this.oPlayer.getX()) && (this.x + this.kickBW[this.curKickBImg] <= this.oPlayer.getX() + this.oPlayer.getWidth()) && (!this.oPlayer.getState().equals("ducking")) && (!this.oPlayer.getState().equals("kickingC"))) {
/* 657 */               decreaseHp(13, this.oPlayer);
/*     */             }
/* 659 */           } else if ((this.x + this.kickBW[this.curKickBImg] >= this.oPlayer.getX() + this.oPlayer.getWidth()) && (this.x + this.kickBW[this.curKickBImg] <= this.oPlayer.getX()) && (!this.oPlayer.getState().equals("ducking")) && (!this.oPlayer.getState().equals("kickingC")))
/* 660 */             decreaseHp(13, this.oPlayer);
/*     */         }
/* 662 */         this.standing = false;
/* 663 */         this.ducking = false;
/* 664 */         this.walkingLeft = false;
/* 665 */         this.walkingRight = false;
/* 666 */         this.punchingA = false;
/* 667 */         this.kickingA = false;
/* 668 */         this.kickingC = false;
/* 669 */         this.kickingB = true;
/*     */       }
/* 671 */       if ((e.getKeyCode() == 90) && (this.ducking) && (!this.name.equalsIgnoreCase("goro")))
/*     */       {
/* 673 */         if (!this.kickingC) {
/* 674 */           if (this.oPlayer.getLookDirection().equals("right")) {
/* 675 */             if ((this.x + this.kickCW[this.curKickCImg] >= this.oPlayer.getX()) && (this.x + this.kickCW[this.curKickCImg] <= this.oPlayer.getX() + this.oPlayer.getWidth())) {
/* 676 */               decreaseHp(8, this.oPlayer);
/*     */             }
/* 678 */           } else if ((this.x + this.kickCW[this.curKickCImg] >= this.oPlayer.getX() + this.oPlayer.getWidth()) && (this.x + this.kickCW[this.curKickCImg] <= this.oPlayer.getX())) {
/* 679 */             decreaseHp(8, this.oPlayer);
/*     */           }
/*     */         }
/* 682 */         this.standing = false;
/* 683 */         this.ducking = false;
/* 684 */         this.walkingLeft = false;
/* 685 */         this.walkingRight = false;
/* 686 */         this.punchingA = false;
/* 687 */         this.kickingA = false;
/* 688 */         this.kickingB = false;
/* 689 */         this.kickingC = true;
/*     */       }
/*     */     }
/* 692 */     if (((this.oPlayer != null) && (!isAlive())) || ((!this.oPlayer.isAlive()) && 
/* 693 */       (e.getKeyCode() == 82))) {
/* 694 */       this.restart = true;
/*     */     }
/* 696 */     if (e.getKeyCode() == 27) {
/* 697 */       this.mk.getOpt().setVisible(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public void keyReleased(java.awt.event.KeyEvent e) {
/* 702 */     if ((!this.ducking) && (!this.punchingA) && (!this.kickingA) && (!this.kickingB) && (!this.kickingC)) {
/* 703 */       this.curStandImg = 0;
/* 704 */       this.curWalkImg = 0;
/* 705 */       this.curDuckImg = 0;
/* 706 */       this.walkingLeft = false;
/* 707 */       this.walkingRight = false;
/* 708 */       this.standing = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private void sleep(int num) {
/* 713 */     try { Thread.sleep(num);
/*     */     } catch (Exception e) {}
/*     */   }
/*     */   
/*     */   private void loadImg(Image[] arr, int cell, String img, int[] w, int[] h) {
/* 718 */     try { arr[cell] = javax.imageio.ImageIO.read(new java.io.File(img));
/* 719 */       w[cell] = (arr[cell].getWidth(null) * (this.mk.getFrameW() / 600));
/* 720 */       h[cell] = (arr[cell].getHeight(null) * (this.mk.getFrameH() / 280));
/*     */     } catch (java.io.IOException ex) {
/* 722 */       System.err.println("Failed to load img: " + img);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setX(int x) {
/* 727 */     this.x = x;
/*     */   }
/*     */   
/*     */ 
/* 731 */   public int getX() { return this.x; }
/*     */   
/*     */   private void moveLeft() {
/* 734 */     if (this.standW[0] > 0) {
/* 735 */       if (this.curWalkImg - 1 >= 0) {
/* 736 */         this.curWalkImg -= 1;
/*     */       } else {
/* 738 */         this.curWalkImg = (this.walkImgs.length - 1);
/*     */       }
/* 740 */     } else if (this.curWalkImg + 1 < this.walkImgs.length) {
/* 741 */       this.curWalkImg += 1;
/*     */     } else {
/* 743 */       this.curWalkImg = 0;
/*     */     }
/*     */     
/* 746 */     if ((this.x - this.walkingSpeed >= 40) && (getLookDirection().equals("right"))) {
/* 747 */       this.x -= this.walkingSpeed;
/* 748 */     } else if ((this.x - this.walkingSpeed + getWidth() >= 40) && (getLookDirection().equals("left")))
/* 749 */       this.x -= this.walkingSpeed;
/* 750 */     if ((this.x <= 50) && (getLookDirection().equals("right"))) {
/* 751 */       this.mk.setBgX(this.mk.getBgX() + this.walkingSpeed);
/* 752 */     } else if ((this.x + getWidth() <= 50) && (getLookDirection().equals("left")))
/* 753 */       this.mk.setBgX(this.mk.getBgX() + this.walkingSpeed);
/* 754 */     this.mk.repaint();
/* 755 */     sleep(35);
/*     */   }
/*     */   
/* 758 */   private void moveRight() { if (this.standW[0] > 0) {
/* 759 */       if (this.curWalkImg + 1 < this.walkImgs.length) {
/* 760 */         this.curWalkImg += 1;
/*     */       } else {
/* 762 */         this.curWalkImg = 0;
/*     */       }
/* 764 */     } else if (this.curWalkImg - 1 >= 0) {
/* 765 */       this.curWalkImg -= 1;
/*     */     } else {
/* 767 */       this.curWalkImg = (this.walkImgs.length - 1);
/*     */     }
/* 769 */     if ((this.x + this.walkingSpeed + getWidth() <= 560) && (getLookDirection().equals("right"))) {
/* 770 */       this.x += this.walkingSpeed;
/* 771 */     } else if ((this.x + this.walkingSpeed <= 560) && (getLookDirection().equals("left")))
/* 772 */       this.x += this.walkingSpeed;
/* 773 */     if ((this.x + getWidth() >= 550) && (getLookDirection().equals("right"))) {
/* 774 */       this.mk.setBgX(this.mk.getBgX() - this.walkingSpeed);
/* 775 */     } else if ((this.x >= 550) && (getLookDirection().equals("left")))
/* 776 */       this.mk.setBgX(this.mk.getBgX() - this.walkingSpeed);
/* 777 */     this.mk.repaint();
/* 778 */     sleep(35);
/*     */   }
/*     */   
/* 781 */   private void decreaseHp(int hp, Player p) { if ((this.oPlayer != null) && (this.oPlayer.isAlive()) && (isAlive())) {
/* 782 */       if (p.getHPFIeld().getHP() - hp < 0) {
/* 783 */         p.getHPFIeld().setHP(0);
/*     */       } else {
/* 785 */         p.getHPFIeld().setHP(p.getHPFIeld().getHP() - hp);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\MK2\dist\MortalKombat.jar!\mortalkombat\Player.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */