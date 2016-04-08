package shruikan.gameplay;

import java.awt.Rectangle;

import shruikan.framework.Collision;



public class Zombie extends Enemy {
	
	public int zombieID;
	public static int i = 0;
	public static int[][] burnCenter = new int[9][2]; 
	
	public static Rectangle[] body = new Rectangle[9];
	public static Rectangle[] head = new Rectangle[9];
	
	
	
	public Zombie(int zombieID, boolean power) {

		setCenterX(LEFTMARGIN + randomX() + randomX());
		setCenterY(GROUND);
				
		setZombieID(zombieID);
		setAlive(true);
		setPower(power);
		
		burnCenter[zombieID][0] = centerX;			//x co-ordinate for burning fire
		burnCenter[zombieID][1] = centerY;			//y co-ordinate for burning fire
				
		if(power == true)
			health = 5*MAXVALUE;
		else if(power == false)
			health = 2*MAXVALUE;
		
		setAttackLeft(true);
		setAttackReady(true);
		
		body[zombieID] = new Rectangle(0, 0, 0, 0);
		head[zombieID] = new Rectangle(0, 0, 0, 0);
		setBounds();
	}
	
	
	
	public void update() {		
	
		cornerX = centerX-100;
		cornerY = centerY-100;
		
		if(health <= 0){
			death();
		}
		
		else if(health > 0){
			
			if(isAttackLeft() == true){
				super.update();
				updateCenterX();			
			}
			else if(isAttackRight() == true){
				speedX = SPEEDX;
				centerX -= speedX;
				updateCenterX();
			}
			
			super.attack();
			attack();
			setAttackReady(false);
			
			setBounds();
			
			if(body[zombieID].intersects(dragon.bound) || head[zombieID].intersects(dragon.bound)){
				checkCollision();
			}
		}
	}

	
	
	public void updateCenterX(){		

		if(isPower() == false){
			if(getCenterX() <= -200 && zombieID % 2 == 0){
				centerX = randomX() + randomX() + RIGHTMARGIN;
				health = 2*MAXVALUE;
			}
			else if(getCenterX() <= -200 && zombieID % 2 != 0){
				centerX = randomX() + randomX() + 2*RIGHTMARGIN;
				health = 2*MAXVALUE;
			}
		}
		else if(isPower() == true){	
			if(getCenterX() <= 0){
				setAttackLeft(false);
				setAttackRight(true);
			}
			if(getCenterX() >= 1280 && getCenterX() <= 1380){
				setAttackLeft(true);
				setAttackRight(false);
			}
			if(getCenterX() > 3840){
				setAttackLeft(true);
				setAttackRight(false);
			}
		}
	}
	
	
	
	public void attack(){
		
		if(isAttackReady() == true){
			Projectiles fire = null;
			fire = new Projectiles(centerX, centerY - 55, 20 + zombieID);	//20 + zombieID=>	2:characterID(zombie)		zombieID:characterNumber(3, 4, 7, 8)
			projectiles.add(fire);
		}
	}



	public void death(){  
	
		StartingClass.dragon.setGameScore(1);
		setAlive(false);
		
		burnCenter[zombieID][0] = centerX;			//update only x cor-ordinate for burning fire
				
		setCenterX(RIGHTMARGIN + randomX() + randomX());
		
		setAttackLeft(isAttackLeft());
		setAttackRight(isAttackRight());
		setAttackReady(false);
		
		if(isPower() == true)
			health = 5*MAXVALUE;
		else if(isPower() == false)
			health = 2*MAXVALUE;
	}
	
	
	
	public void setBounds(){
		
		if(isAttackLeft() == true){
			body[zombieID].setRect(cornerX+55, cornerY+70, 70, 90);
			head[zombieID].setRect(cornerX+90, cornerY+40, 25, 30);
		}
		else if(isAttackRight() == true){
			body[zombieID].setRect(cornerX+75, cornerY+70, 70, 90);
			head[zombieID].setRect(cornerX+85, cornerY+40, 25, 30);	
		}
	}
	
	
	
	public void checkCollision(){	
		
		if(dragon.body.intersects(body[zombieID]) || dragon.head.intersects(body[zombieID]) || dragon.tail.intersects(body[zombieID]) ){
			StartingClass.dragon.setHit(true);
		}
		else if(StartingClass.dragon.isHit() == true){
			StartingClass.dragon.setHealthUpdate(true, -2);
			StartingClass.dragon.setHit(false);
		}
	}
	
	
	
	//--------------------GETTERS--------------------
	public int getZombieID() {
		return zombieID;
	}



	public static int getBurnCenter(int zombieID, int index) {
		return burnCenter[zombieID][index];
	}



	//--------------------SETTERS--------------------
	public void setZombieID(int zombieID) {
		this.zombieID = zombieID;
	}



	public void setBurnCenter(int[][] burnCenter) {
		this.burnCenter = burnCenter;
	}

}