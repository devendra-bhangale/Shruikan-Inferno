package shruikan.gameplay;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

import shruikan.framework.Animation;
import shruikan.framework.Triangle;
import shruikan.framework.Line;



public class Dragon {

	public final static int COUNTER = 100;
	
	final int HIGHMARGIN	= 50;
	final int LOWMARGIN		= 550;
	final int RIGHTMARGIN	= 550;
	final int LEFTMARGIN	= 135;
	final int SPEEDX	 	= 5;
	final int SPEEDY 		= 10;
	final int MAXVALUE		= 100;
	final int ENERGYUPDATE	= 25;
	
	private static int gameScore = 0, fireCounter = COUNTER, breadthCounter = 10*COUNTER;
	
	private int cornerX, cornerY;
	
	private int centerX		= LEFTMARGIN;
	private int centerY		= LOWMARGIN;
	private int speedX		= 0;
	private int speedY		= 0;
	
	private int powerEnergy = 0;
	private int health		= 5*MAXVALUE;
	private int breadth		= 5*MAXVALUE; 
	private int burn;
	
	private static boolean facingRight 	= true;
	private static boolean facingLeft 	= false;
	private static boolean facinglocked = false;
	private static boolean fireReady	= true;
	
	private static boolean movingUp 	= false;
    private static boolean movingDown 	= false;
    private static boolean movingLeft 	= false;
    private static boolean movingRight	= false;

	private static boolean firing 		= false;
	public static boolean powerUpdate	= false;
	public static boolean healthUpdate	= false;
	public static boolean hit			= false;
	
	private Background bg1 = StartingClass.getBg1();
	private Background bg2 = StartingClass.getBg2();

	private Zombie zombie1	= StartingClass.getZombie1();		
	private Zombie zombie2	= StartingClass.getZombie2();		
	private Zombie zombie3	= StartingClass.getZombie3();		
	private Zombie zombie4	= StartingClass.getZombie4();		
	private Zombie zombie5	= StartingClass.getZombie5();		
	private Zombie zombie6	= StartingClass.getZombie6();		
	private Zombie zombie7	= StartingClass.getZombie7();		
	private Zombie zombie8	= StartingClass.getZombie8();		
	
	private HangingZombie hangZombie1	= StartingClass.getHangZombie1();		
	private HangingZombie hangZombie2	= StartingClass.getHangZombie2();		
	private HangingZombie hangZombie3	= StartingClass.getHangZombie3();		
	private HangingZombie hangZombie4	= StartingClass.getHangZombie4();		
	
	private Animation animFireBreadthFwd = StartingClass.getAnimFireBreadthFwd();
	private Animation animFireBreadthBwd = StartingClass.getAnimFireBreadthBwd();
	
	private ArrayList<Projectiles> projectiles = new ArrayList<Projectiles>();
	
	public static Rectangle bound	= new Rectangle(0, 0, 0, 0);	
	public static Rectangle	body	= new Rectangle(0, 0, 0, 0);
	public static Triangle	head;
	public static Triangle	wingsUp;
	public static Triangle	wingsDown;
	public static Line		tail;
	
	public static Triangle[]	firebreadth		= new Triangle[5];
	public static Triangle		fireBreadth		= new Triangle(0, 0, 0, 0, 0, 0);

	
	
	public void update() {			
		
		//HORIZONTAL MOVEMENT
		if((speedX < 0) && (isMovingLeft() == true || isMovingRight() == true))
			centerX += speedX;		
		if(speedX <= 0 || isMovingLeft() == false || isMovingRight() == false || isMovingLeft() == true){
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);
		}		
		
		if((speedX > 0 && centerX <= RIGHTMARGIN) && (isMovingLeft() == true || isMovingRight() == true))
			centerX += speedX;
		if((speedX > 0 && centerX > RIGHTMARGIN) && (isMovingLeft() == true || isMovingRight() == true)){
			bg1.setSpeedX(-SPEEDX);
			bg2.setSpeedX(-SPEEDX);
		}		
		
		//VERTICAL MOVEMENT
		if((speedY < 0 && centerY >= HIGHMARGIN) && (isMovingUp() == true || isMovingDown() == true))
			centerY += speedY;
		if((speedY > 0 && centerY <= LOWMARGIN) && (isMovingUp() == true || isMovingDown() == true))
			centerY += speedY;
				
		//AVOIDING GOING BEYONG SCREEN (UP & LEFT SIDE)
		if(centerX + speedX <= LEFTMARGIN)
			centerX = LEFTMARGIN + 1;
		if(centerY + speedY <= HIGHMARGIN)
			centerY = HIGHMARGIN + 1;
			
		setBounds();
		if(isFiring() == true && getBreadth() > 0){
			checkCollision();
			breadth--;
		}
		else if(getBreadth() <= 0){
			breadthCounter--;
			if(breadthCounter <= 0){
				breadth = 5*MAXVALUE; 
				breadthCounter = 10*COUNTER;
			}
		}
		                           
	}



	public void moveUp() {
		
		speedY = -SPEEDY;
	}
	
	
	
	public void moveDown() {

		speedY = SPEEDY;
	}
	
	
	
	public void moveLeft() {
		
		speedX = -SPEEDX;

		if(isFacinglocked() == false){
			setFacingLeft(true);
			setFacingRight(false);
		}
	}
	
	
	
	public void moveRight() {

		speedX = SPEEDX;
		
		if(isFacinglocked() == false){
			setFacingLeft(false);
			setFacingRight(true);
		}
	}
	
	
	
	public void fire(){
		
		if(isFireReady() == true){
			Projectiles fire = null;
			if(isFacingRight() == true)
				fire = new Projectiles(centerX + 135, centerY + 34, 10);	//10=>	1:characterID(dragon)		0:characterNumber(only 1 dragon)
			else if(isFacingLeft() == true)
				fire = new Projectiles(centerX - 135, centerY + 34, 10);	//10=>	1:characterID(dragon)		0:characterNumber(only 1 dragon)
			
			projectiles.add(fire);
			
			if(powerEnergy > 0)
				powerEnergy--;
			if(powerEnergy <= 0)
				setPowerUpdate(false, 0);
		}
	}
	
	
	
	public void setBounds(){
	
		cornerX = centerX - 135;
		cornerY = centerY - 96;
		
		bound.setRect(cornerX-5, cornerY-5, 280, 202);
		
		if(isFacingRight() == true){
			body		= new Rectangle(cornerX+135, cornerY+100, 65, 40);
			
			head		= new Triangle(cornerX+195, cornerY+105, cornerX+245, cornerY+65, cornerX+265, cornerY+105);
			
			wingsUp		= new Triangle(cornerX+110, cornerY+25, cornerX+185, cornerY+100, cornerX+110, cornerY+100);
			wingsDown	= new Triangle(cornerX+195, cornerY+85, cornerX+130, cornerY+165, cornerX+130, cornerY+85);
			
			tail		= new Line(cornerX+135, cornerY+120, cornerX+50, cornerY+145, cornerX+0, cornerY+180);
			
			cornerX = centerX + 125;
			cornerY = centerY + 5;
			
			firebreadth[0]	= new Triangle (cornerX+0, cornerY+0, cornerX+0, cornerY+65, cornerX+70, cornerY+65);
			firebreadth[1]	= new Triangle (cornerX+0, cornerY+0, cornerX+0, cornerY+105, cornerX+100, cornerY+105);
			firebreadth[2]	= new Triangle (cornerX+0, cornerY+0, cornerX+40, cornerY+160, cornerX+130, cornerY+160);
			firebreadth[3]	= new Triangle (cornerX+0, cornerY+0, cornerX+75, cornerY+256, cornerX+180, cornerY+256);
			firebreadth[4]	= new Triangle (cornerX+0, cornerY+0, cornerX+0, cornerY+0, cornerX+0, cornerY+0);		//fireBreadthPause
			
			fireBreadth		= firebreadth[animFireBreadthFwd.getSpriteID()];
		}
		else if(isFacingLeft() == true){
			body		= new Rectangle(cornerX+70, cornerY+100, 65, 40);
			
			head		= new Triangle(cornerX+75, cornerY+105, cornerX+25, cornerY+65, cornerX+5, cornerY+105);
			
			wingsUp		= new Triangle(cornerX+160, cornerY+25, cornerX+85, cornerY+100, cornerX+160, cornerY+100);
			wingsDown	= new Triangle(cornerX+80, cornerY+85, cornerX+145, cornerY+165, cornerX+145, cornerY+85);
			
			tail		= new Line(cornerX+135, cornerY+120, cornerX+220, cornerY+145, cornerX+270, cornerY+180);
			
			cornerX = centerX - 305;
			cornerY = centerY + 5;
			
			firebreadth[0] = new Triangle (cornerX+180, cornerY+0, cornerX+180, cornerY+65, cornerX+110, cornerY+65);
			firebreadth[1] = new Triangle (cornerX+180, cornerY+0, cornerX+180, cornerY+105, cornerX+80, cornerY+105);
			firebreadth[2] = new Triangle (cornerX+180, cornerY+0, cornerX+140, cornerY+160, cornerX+50, cornerY+160);
			firebreadth[3] = new Triangle (cornerX+180, cornerY+0, cornerX+105, cornerY+256, cornerX+0, cornerY+256);
			firebreadth[4] = new Triangle (cornerX+0, cornerY+0, cornerX+0, cornerY+0, cornerX+0, cornerY+0);		//fireBreadthPause
			
			fireBreadth		= firebreadth[animFireBreadthBwd.getSpriteID()];
		}
	}
	
	
	
	public void checkCollision(){
		
		burn = -5;
		
		if(fireBreadth.intersects(StartingClass.zombie1.body[StartingClass.zombie1.zombieID]) || fireBreadth.intersects(StartingClass.zombie1.head[StartingClass.zombie1.zombieID])){
			StartingClass.zombie1.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.zombie2.body[StartingClass.zombie2.zombieID]) || fireBreadth.intersects(StartingClass.zombie2.head[StartingClass.zombie2.zombieID])){
			StartingClass.zombie2.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.zombie3.body[StartingClass.zombie3.zombieID]) || fireBreadth.intersects(StartingClass.zombie3.head[StartingClass.zombie3.zombieID])){
			StartingClass.zombie3.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.zombie4.body[StartingClass.zombie4.zombieID]) || fireBreadth.intersects(StartingClass.zombie4.head[StartingClass.zombie4.zombieID])){
			StartingClass.zombie4.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.zombie5.body[StartingClass.zombie5.zombieID]) || fireBreadth.intersects(StartingClass.zombie5.head[StartingClass.zombie5.zombieID])){
			StartingClass.zombie5.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.zombie6.body[StartingClass.zombie6.zombieID]) || fireBreadth.intersects(StartingClass.zombie6.head[StartingClass.zombie6.zombieID])){
			StartingClass.zombie6.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.zombie7.body[StartingClass.zombie7.zombieID]) || fireBreadth.intersects(StartingClass.zombie7.head[StartingClass.zombie7.zombieID])){
			StartingClass.zombie7.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.zombie8.body[StartingClass.zombie8.zombieID]) || fireBreadth.intersects(StartingClass.zombie8.head[StartingClass.zombie8.zombieID])){
			StartingClass.zombie8.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.hangZombie1.body[StartingClass.hangZombie1.hangingZombieID])){
			StartingClass.hangZombie1.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.hangZombie2.body[StartingClass.hangZombie2.hangingZombieID])){
			StartingClass.hangZombie2.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.hangZombie3.body[StartingClass.hangZombie3.hangingZombieID])){
			StartingClass.hangZombie3.setHealth(burn);
		}
		
		else if(fireBreadth.intersects(StartingClass.hangZombie4.body[StartingClass.hangZombie4.hangingZombieID])){
			StartingClass.hangZombie4.setHealth(burn);
		}
	}
	
	
	
	public void stopUp() {

		setMovingUp(false);
        stop();
	}
	
	
	
	public void stopDown() {

		setMovingDown(false);
        stop();
	}
	
	
	
	public void stopLeft() {

		setMovingLeft(false);
        stop();
	}
	
	
	
	public void stopRight() {
		
		setMovingRight(false);
        stop();
	}
	
	
	
	public void stopFire(){
		
		setFiring(false);
		stop();
	}



	public void stop(){
		
		if(isMovingUp() == false && isMovingDown() == false)
			speedX = 0;
		if(isMovingLeft() == false && isMovingRight() == false)
			speedY = 0;
		
		if(isMovingUp() == true && isMovingDown() == false)
			moveUp();
		if(isMovingUp() == false && isMovingDown() == true)
			moveDown();
		
		if(isMovingLeft() == true && isMovingRight() == false)
			moveLeft();
		if(isMovingLeft() == false && isMovingRight() == true)
			moveRight();
		
	}



	//--------------------GETTERS--------------------
	public int getCenterX() {
		return centerX;
	}



	public int getCenterY() {
		return centerY;
	}



	public int getSpeedX() {
		return speedX;
	}



	public int getSpeedY() {
		return speedY;
	}



	public static int getFireCounter() {
		return fireCounter;
	}



	public static boolean isFacingRight() {
		return facingRight;
	}



	public static boolean isFacingLeft() {
		return facingLeft;
	}



	public boolean isFacinglocked() {
		return facinglocked;
	}



	public boolean isMovingUp() {
		return movingUp;
	}



	public boolean isMovingDown() {
		return movingDown;
	}



	public boolean isMovingLeft() {
		return movingLeft;
	}



	public boolean isMovingRight() {
		return movingRight;
	}



	public boolean isFiring() {
		return firing;
	}



	public boolean isPowerUpdate() {
		return powerUpdate;
	}



	public boolean isFireReady() {
		return fireReady;
	}



	public ArrayList<Projectiles> getProjectiles() {
		return projectiles;
	}



	public boolean isHealthUpdate() {
		return healthUpdate;
	}



	public static boolean isHit() {
		return hit;
	}



	public int getHealth() {
		return health;
	}



	public int getBreadth() {
		return breadth;
	}



	public int getGameScore() {
		return gameScore;
	}



	public int getPowerEnergy() {
		return powerEnergy;
	}



	//--------------------SETTERS--------------------
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}



	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}



	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}



	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}



	public static void setFireCounter(int fireCounter) {
		Dragon.fireCounter = fireCounter;
	}



	public static void setFacingRight(boolean facingRight) {
		Dragon.facingRight = facingRight;
	}



	public static void setFacingLeft(boolean facingLeft) {
		Dragon.facingLeft = facingLeft;
	}



	public void setFacinglocked(boolean facinglocked) {
		this.facinglocked = facinglocked;
	}



	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}



	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}



	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}



	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}



	public void setFiring(boolean firing) {
		this.firing = firing;
	}



	public void setPowerUpdate(boolean powerUpdate, int powerEnergy) {
		this.powerUpdate = powerUpdate;
		this.powerEnergy += powerEnergy;
		if(this.powerEnergy >= MAXVALUE)
			this.powerEnergy = MAXVALUE;
	}



	public void setFireReady(boolean fireReady) {
		this.fireReady = fireReady;
	}



	public void setProjectiles(ArrayList<Projectiles> projectiles) {
		this.projectiles = projectiles;
	}



	public void setHealthUpdate(boolean healthUpdate, int powerEnergy) {
		this.healthUpdate = healthUpdate;
		this.health += powerEnergy;
		if(this.health >= 5*MAXVALUE)
			this.health = 5*MAXVALUE;
	}



	public static void setHit(boolean hit) {
		Dragon.hit = hit;
	}



	public void setHealth(int health) {
		this.health = health;
	}



	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}



	public void setGameScore(int gameScore) {
		this.gameScore += gameScore;
	}



	public void setPowerEnergy(int powerEnergy) {
		this.powerEnergy = powerEnergy;
	}

}
