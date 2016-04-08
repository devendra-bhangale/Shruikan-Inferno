package shruikan.gameplay;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;



public class Clouds {

	public final static int COUNTER = 2;
	
	public final int CLOUD 			= 0;
	public final int POWERCLOUD		= 1;
	public final int NIMBUSCLOUD	= 2;
	public final int PHOENIX		= 3;
	
	final int HIGHMARGIN	= 50;
	final int LOWMARGIN		= 350;
	final int RIGHTMARGIN	= 1280;
	final int LEFTMARGIN	= 320;
	final int SPEEDX		= -2;
	
	private static int powerCloudCounter, nimbusCloudCounter, phoenixCounter, dragonBall = 0;
	
	private int centerX, centerY, cornerX, cornerY, cloudID;		
	private Random randX, randY, randCounter;
	
	private Background bg	= StartingClass.getBg1();
	private Dragon dragon	= StartingClass.getDragon();
	
	public static Rectangle powercloudBound		= new Rectangle(0, 0, 0, 0);
	public static Rectangle nimbuscloudBound	= new Rectangle(0, 0, 0, 0);
	public static Rectangle dragonballBound		= new Rectangle(0, 0, 0, 0);
	public static Rectangle phoenixBound		= new Rectangle(0, 0, 0, 0);
	
	public static boolean[] ballCollection		= new boolean[8];
	
	
	
	public Clouds(int cloudID) {

		this.centerX = randomX() + randomX() + RIGHTMARGIN;
		this.centerY = randomY() + HIGHMARGIN;
		this.cloudID = cloudID;
		
		powerCloudCounter	= 2*COUNTER + randomCounter();
		nimbusCloudCounter	= 5*COUNTER + randomCounter();
		phoenixCounter		= 3*COUNTER + randomCounter();
	}
	
	
	
	public void update() {		
		
		moveLeft();

		if(centerX <= -300){
			
			updateCenter();
			updateDragonBall();
			updateCounter();
		}
		
		setBounds();
		
		if((getCloudID() == POWERCLOUD || getCloudID() == NIMBUSCLOUD || getCloudID() == PHOENIX) && (powercloudBound.intersects(dragon.bound) || nimbuscloudBound.intersects(dragon.bound) || dragonballBound.intersects(dragon.bound) || phoenixBound.intersects(dragon.bound)) ){
			
			checkCollision();
		}
	}

	
	
	public void moveLeft(){
		
		if(getCloudID() == CLOUD)
			centerX += SPEEDX + bg.getSpeedX();
		else if(getCloudID() == POWERCLOUD || getCloudID() == NIMBUSCLOUD || getCloudID() == PHOENIX)
			centerX += (6*SPEEDX) + bg.getSpeedX();
	}
	
	
	
	public void updateCenter(){
		
		centerX = randomX() + randomX() + RIGHTMARGIN;
		centerY = randomY() + HIGHMARGIN;
	}
	
	
	
	public void updateDragonBall(){
		
		if(getCloudID() == NIMBUSCLOUD){
			if(dragonBall < 7){}
				dragonBall++;
		}
	}
	
	
	
	public void updateCounter(){
		
		powerCloudCounter--;
		nimbusCloudCounter--;
		phoenixCounter--;
		
		if(powerCloudCounter <= 0 && cloudID == POWERCLOUD)
			powerCloudCounter = 2*COUNTER + randomCounter();
		
		if(nimbusCloudCounter <= 0 && cloudID == NIMBUSCLOUD)
			nimbusCloudCounter = 5*COUNTER + randomCounter();
		
		if(phoenixCounter <= 0 && cloudID == PHOENIX)
			phoenixCounter = 3*COUNTER + randomCounter();
	}

	
	
	public void setBounds(){

		if(getCloudID() == POWERCLOUD){
			cornerX = centerX - 100;
			cornerY = centerY - 44;
			powercloudBound		= new Rectangle(cornerX+50, cornerY+20, 100, 40);
		}
		else if(getCloudID() == NIMBUSCLOUD){
			cornerX = centerX - 75;
			cornerY = centerY - 25;
			nimbuscloudBound	= new Rectangle(cornerX+20, cornerY+10, 75, 30);
			
			cornerX = centerX - 45;
			cornerY = centerY - 40;
			dragonballBound		= new Rectangle(cornerX+5, cornerY+5, 30, 30);
		}
		else if(getCloudID() == PHOENIX){
			cornerX = centerX - 150;
			cornerY = centerY - 150;
			phoenixBound		= new Rectangle(cornerX+25, cornerY+135, 95, 40);
		}
	}
	
	
	
	public void checkCollision(){
		
		if(getCloudID() == POWERCLOUD && (dragon.body.intersects(powercloudBound) || dragon.head.intersects(powercloudBound)) ){
			StartingClass.powerCloud.centerX = randomX() + randomX() + RIGHTMARGIN;
			StartingClass.powerCloud.centerY = randomY() + HIGHMARGIN;
			StartingClass.powerCloud.powerCloudCounter = 2*COUNTER + randomCounter();
			StartingClass.dragon.setPowerUpdate(true, StartingClass.dragon.ENERGYUPDATE);
		}
		
		if(getCloudID() == NIMBUSCLOUD && (dragon.body.intersects(nimbuscloudBound) || dragon.head.intersects(nimbuscloudBound) || dragon.body.intersects(dragonballBound) || dragon.head.intersects(dragonballBound)) ){	
			StartingClass.nimbusCloud.centerX = randomX() + randomX() + RIGHTMARGIN;
			StartingClass.nimbusCloud.centerY = randomY() + HIGHMARGIN;
			StartingClass.nimbusCloud.nimbusCloudCounter = 5*COUNTER + randomCounter();
			StartingClass.nimbusCloud.dragonBall++;
			StartingClass.nimbusCloud.setBallCollection(dragonBall, true);
		}
		
		if(getCloudID() == PHOENIX && (dragon.body.intersects(phoenixBound) || dragon.head.intersects(phoenixBound)) ){
			StartingClass.phoenix.centerX = randomX() + randomX() + RIGHTMARGIN;
			StartingClass.phoenix.centerY = randomY() + HIGHMARGIN;
			StartingClass.phoenix.phoenixCounter = 3*COUNTER + randomCounter();
			StartingClass.dragon.setHealthUpdate(true, 5*StartingClass.dragon.ENERGYUPDATE);
		}					
	}
	
	
	
	public int randomX(){
		
		randX = new Random();
		return randX.nextInt(RIGHTMARGIN);
	}
	
	
	
	public int randomY(){
		
		randY = new Random();
		return randY.nextInt(LOWMARGIN - HIGHMARGIN);
	}
	
	
	
	public int randomCounter(){
		
		randCounter = new Random();
		return randCounter.nextInt(COUNTER);
	}
	
	

	//--------------------GETTERS--------------------
	public int getCenterX() {
		return centerX;
	}



	public int getCenterY() {
		return centerY;
	}



	public static int getPowerCloudCounter() {
		return powerCloudCounter;
	}



	public static int getNimbusCloudCounter() {
		return nimbusCloudCounter;
	}



	public int getDragonBall() {
		return dragonBall;
	}



	public int getCloudID() {
		return cloudID;
	}



	public static int getPhoenixCounter() {
		return phoenixCounter;
	}



	public static boolean getBallCollection(int dragonBall) {
		return ballCollection[dragonBall];
	}



	//--------------------SETTERS--------------------
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}



	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}



	public static void setPowerCloudCounter(int powerCloudCounter) {
		Clouds.powerCloudCounter = powerCloudCounter;
	}



	public static void setNimbusCloudCounter(int nimbusCloudCounter) {
		Clouds.nimbusCloudCounter = nimbusCloudCounter;
	}



	public void setDragonBall(int dragonBall) {
		this.dragonBall = dragonBall;
	}
	
	
	
	public void setCloudID(int cloudID) {
		this.cloudID = cloudID;
	}



	public static void setPhoenixCounter(int phoenixCounter) {
		Clouds.phoenixCounter = phoenixCounter;
	}



	public static void setBallCollection(int dragonBall, boolean value) {
		Clouds.ballCollection[dragonBall] = value;
	}

}
