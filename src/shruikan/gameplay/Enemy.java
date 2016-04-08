package shruikan.gameplay;

import java.util.ArrayList;
import java.util.Random;
import shruikan.framework.Collision;



public class Enemy{
	
	public final static int COUNTER = 100;
	
	protected final int RIGHTMARGIN		= 1280;
	protected final int LEFTMARGIN		= 320;
	protected final static int GROUND	= 530;
	protected final int SPEEDX			= -2; 
	protected final int MAXVALUE		= 10;
	protected static int attackCounter	= COUNTER;
	
	
	protected int speedX, centerX, centerY, cornerX, cornerY, health;
			
	protected boolean alive, power, attackReady;
	public boolean attackUp		= false;
	public boolean attackDown	= false;
	public boolean attackLeft	= false;
	public boolean attackRight	= false;
	
	protected ArrayList<Projectiles> projectiles	= new ArrayList<Projectiles>();
	protected Random randX;
	
	protected Background bg		= StartingClass.getBg1();
	protected Dragon dragon		= StartingClass.getDragon();
	
	
	
	public void update() {
		
		speedX = SPEEDX + bg.getSpeedX();
		centerX += speedX;		
	}
	
	
	
	public int randomX(){
		
		randX = new Random();
		return randX.nextInt(RIGHTMARGIN);
	}
	
	
	
	public void attack() {
	
		if(centerX >= 0 || centerX <= 1180 ){
			if(attackCounter % 205 == 0)
				setAttackReady(true);
				
			attackCounter--;
		}
	}



	public void death() {
		
	}
	
	
	
	//--------------------GETTERS--------------------
	public int getHealth() {
		return health;
	}



	public int getSpeedX() {
		return speedX;
	}



	public int getCenterX() {
		return centerX;
	}



	public int getCenterY() {
		return centerY;
	}



	public boolean isPower() {
		return power;
	}



	public boolean isAttackUp() {
		return attackUp;
	}



	public boolean isAttackDown() {
		return attackDown;
	}



	public boolean isAttackLeft() {
		return attackLeft;
	}



	public boolean isAttackRight() {
		return attackRight;
	}



	public boolean isAttackReady() {
		return attackReady;
	}



	public ArrayList<Projectiles> getProjectiles() {
		return projectiles;
	}



	public int getCornerX() {
		return cornerX;
	}



	public int getCornerY() {
		return cornerY;
	}



	public boolean isAlive() {
		return alive;
	}



	//--------------------SETTERS--------------------
	public void setHealth(int health) {		
		this.health += health;		//negative value of health is passed; hence addition 
	}



	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}



	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}



	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}



	public void setPower(boolean power) {
		this.power = power;
	}



	public void setAttackUp(boolean attackUp) {
		this.attackUp = attackUp;
	}



	public void setAttackDown(boolean attackDown) {
		this.attackDown = attackDown;
	}



	public void setAttackLeft(boolean attackLeft) {
		this.attackLeft = attackLeft;
	}



	public void setAttackRight(boolean attackRight) {
		this.attackRight = attackRight;
	}



	public void setAttackReady(boolean attackReady) {
		this.attackReady = attackReady;
	}



	public void setProjectiles(ArrayList<Projectiles> projectiles) {
		this.projectiles = projectiles;
	}



	public void setCornerX(int cornerX) {
		this.cornerX = cornerX;
	}



	public void setCornerY(int cornerY) {
		this.cornerY = cornerY;
	}



	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
}
