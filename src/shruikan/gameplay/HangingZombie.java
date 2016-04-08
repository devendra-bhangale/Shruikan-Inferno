package shruikan.gameplay;

import java.awt.Rectangle;

import shruikan.framework.Animation;
import shruikan.framework.Collision;



public class HangingZombie extends Enemy {
	
	public int hangingZombieID;
	
	protected Clouds cloud1 = StartingClass.getCloud1();
	protected Clouds cloud4 = StartingClass.getCloud4();
	protected Clouds cloud5 = StartingClass.getCloud5();
	protected Clouds cloud8 = StartingClass.getCloud8();
	
	protected Animation animPowerfulHangingZombie = StartingClass.getAnimPowerfulHangingZombie();
	
	public static Rectangle[] body		= new Rectangle[5];
	public static Rectangle[] sprite	= new Rectangle[21];
	
	
	
	public HangingZombie(int centerX, int centerY, int hangingZombieID, boolean power) {

		setCenterX(centerX);
		setCenterY(centerY);
		setHangingZombieID(hangingZombieID);
		setPower(power);
		
		if(power == true)
			health = 5*MAXVALUE;
		else if(power == false)
			health = 2*MAXVALUE;
		
		if(dragon.getCenterY() < centerY)
			setAttackUp(true);
		else if(dragon.getCenterY() > centerY)
			setAttackDown(true);
		
		setAttackReady(true);
		
		body[hangingZombieID] = new Rectangle(0, 0, 0, 0);
	}
	
	
	
	public void update() {
		
		cornerX = centerX-100;
		cornerY = centerY-100;
		
		if(health <= 0){
			death();
		}
		
		else if(health > 0){
			super.update();
			updateCenterX();
			
			super.attack();
			attack();
			setAttackReady(false);
			
			setBounds();
			
			if(body[hangingZombieID].intersects(dragon.bound)){
				checkCollision();
			}
		}
	}



	public void updateCenterX(){
		
		if(getCenterX() <= -200){
			if(hangingZombieID == 1){
				centerX = cloud1.getCenterX();
				centerY = cloud1.getCenterY() + 100;
				health = 2*MAXVALUE;
			}
			
			if(hangingZombieID == 2){
				centerX = cloud4.getCenterX();
				centerY = cloud4.getCenterY() + 100;
				health = 5*MAXVALUE;
			}
			
			if(hangingZombieID == 3){
				centerX = cloud5.getCenterX();
				centerY = cloud5.getCenterY() + 100;
				health = 2*MAXVALUE;
			}
			
			if(hangingZombieID == 4){
				centerX = cloud8.getCenterX();
				centerY = cloud8.getCenterY() + 100;
				health = 5*MAXVALUE;
			}
		}
		
		if(isPower() == true){
			if(dragon.getCenterY() < getCenterY()){
				setAttackUp(true);
				setAttackDown(false);
			}
			if(dragon.getCenterY() > getCenterY()){
				setAttackUp(false);
				setAttackDown(true);
			}
		}
	}



	public void attack(){
		
		if(isAttackReady() == true){
			Projectiles fire = null;
			fire = new Projectiles(centerX + 5, centerY - 15, 30 + hangingZombieID);	//30 + hangingZombieID=>	3:characterID(hangingZombie)		hangingZombieID: characterNumber(2, 4)
			projectiles.add(fire);
		}
	}
	
	
	
	public void death(){
			
		if(getCenterX() == -1000){						//first pass through death() will skip this since centerX is NOT equal to -1000
			StartingClass.dragon.setGameScore(1);		//second pass through death() increases score by 1 and sets centeX to -500
			setCenterX(-500);							//this way, score is updated only once for each death
		}
		
		body[hangingZombieID].setRect(0, 0, 0, 0);
				
		if(dragon.getCenterY() < centerY)
			setAttackUp(true);
		else if(dragon.getCenterY() > centerY)
			setAttackDown(true);
		
		setAttackReady(true);
		
		if(getCenterX() != -500)						//first pass through death() sets centerX to -1000 since it is not equal to -500 
			setCenterX(-1000);							//second pass through death() will skip this since centerX IS equal to -500
		
		if(hangingZombieID == 1 && cloud1.getCenterX() <= -100){
			health = 2*MAXVALUE;
		}
		
		else if(hangingZombieID == 2 && cloud4.getCenterX() <= -100){
			health = 5*MAXVALUE;
		}
		
		else if(hangingZombieID == 3 && cloud5.getCenterX() <= -100){
			health = 2*MAXVALUE;
		}
		
		else if(hangingZombieID == 4 && cloud8.getCenterX() <= -100){
			health = 5*MAXVALUE;
		}
	}
	
	
	
	public void setBounds(){
		
		sprite[0] = new Rectangle(cornerX+70, cornerY+45, 70, 65);
		sprite[1] = new Rectangle(cornerX+70, cornerY+35, 70, 65);
		sprite[2] = new Rectangle(cornerX+70, cornerY+30, 70, 65);
		sprite[3] = new Rectangle(cornerX+70, cornerY+20, 70, 65);
		sprite[4] = new Rectangle(cornerX+70, cornerY+10, 70, 65);
		sprite[5] = new Rectangle(cornerX+70, cornerY+0, 70, 65);
		sprite[6] = new Rectangle(cornerX+70, cornerY+0, 70, 60);
		sprite[7] = new Rectangle(cornerX+60, cornerY+0, 90, 45);
		sprite[8] = new Rectangle(cornerX+65, cornerY+0, 85, 10);
		sprite[9] = new Rectangle(cornerX, cornerY, 0, 0);
		sprite[10] = new Rectangle(cornerX, cornerY, 0, 0);
		sprite[11] = new Rectangle(cornerX, cornerY, 0, 0);
		sprite[12] = new Rectangle(cornerX+65, cornerY+0, 85, 10);
		sprite[13] = new Rectangle(cornerX+60, cornerY+0, 90, 45);
		sprite[14] = new Rectangle(cornerX+70, cornerY+0, 70, 60);
		sprite[15] = new Rectangle(cornerX+70, cornerY+0, 70, 65);
		sprite[16] = new Rectangle(cornerX+70, cornerY+10, 70, 65);
		sprite[17] = new Rectangle(cornerX+70, cornerY+20, 70, 65);
		sprite[18] = new Rectangle(cornerX+70, cornerY+30, 70, 65);
		sprite[19] = new Rectangle(cornerX+70, cornerY+35, 70, 65);
		sprite[20] = new Rectangle(cornerX+70, cornerY+45, 70, 65);
		
		body[hangingZombieID] = sprite[animPowerfulHangingZombie.getSpriteID()];
	}
	
	
	
	public void checkCollision(){
		
		if(dragon.body.intersects(body[hangingZombieID]) || dragon.head.intersects(body[hangingZombieID]) || dragon.tail.intersects(body[hangingZombieID]) ){
			StartingClass.dragon.setHit(true);
		}
		else if(StartingClass.dragon.isHit() == true){
			StartingClass.dragon.setHealthUpdate(true, -2);
			StartingClass.dragon.setHit(false);
		}
	}
	
	
	
	//--------------------GETTERS--------------------
	public int getHangingZombieID() {
		return hangingZombieID;
	}



	//--------------------SETTERS--------------------
	public void setHangingZombieID(int hangingZombieID) {
		this.hangingZombieID = hangingZombieID;
	}
}