package shruikan.gameplay;

import java.awt.Rectangle;

import shruikan.framework.Collision;



public class Projectiles {

	public final int DRAGON			= 1;
	public final int ZOMBIE			= 2;
	public final int HANGINGZOMBIE	= 3;
	
	public int centerX, centerY, cornerX, cornerY, speedX, speedY, characterID, characterNumber;
	private static int burn;
	
	private boolean visible;
	private boolean fireUp		= false;
	private boolean fireDown	= false;
	private boolean fireLeft	= false;
	private boolean fireRight	= false;
	
	public boolean powerUpdate	= false;
	
	private Background bg	= StartingClass.getBg1();
	private Dragon dragon	= StartingClass.getDragon();
	
	private Zombie zombie1	= StartingClass.getZombie1();		private final int ZOMBIE1 = 1;
	private Zombie zombie2	= StartingClass.getZombie2();		private final int ZOMBIE2 = 2;
	private Zombie zombie3	= StartingClass.getZombie3();		private final int ZOMBIE3 = 3;
	private Zombie zombie4	= StartingClass.getZombie4();		private final int ZOMBIE4 = 4;
	private Zombie zombie5	= StartingClass.getZombie5();		private final int ZOMBIE5 = 5;
	private Zombie zombie6	= StartingClass.getZombie6();		private final int ZOMBIE6 = 6;
	private Zombie zombie7	= StartingClass.getZombie7();		private final int ZOMBIE7 = 7;
	private Zombie zombie8	= StartingClass.getZombie8();		private final int ZOMBIE8 = 8;
	
	private HangingZombie hangZombie1	= StartingClass.getHangZombie1();		private final int HANGINGZOMBIE1 = 1;
	private HangingZombie hangZombie2	= StartingClass.getHangZombie2();		private final int HANGINGZOMBIE2 = 2;
	private HangingZombie hangZombie3	= StartingClass.getHangZombie3();		private final int HANGINGZOMBIE3 = 3;
	private HangingZombie hangZombie4	= StartingClass.getHangZombie4();		private final int HANGINGZOMBIE4 = 4;
	
	public Rectangle[] fireballBound = new Rectangle[8];
	
	
	
	public Projectiles(int centerX, int centerY, int characterID) {

		this.centerX 		= centerX;
		this.centerY 		= centerY;
		
		this.characterID	= characterID / 10;
		characterNumber		= characterID % 10;

		speedX = 5;
		speedY = 5;
		
		visible = true;
		
		if(this.characterID == DRAGON)
			powerUpdate = StartingClass.dragon.powerUpdate;
		
		fireballBound[this.characterID] = new Rectangle(0, 0, 0, 0);
		setBounds();
		
		setDirection();
	}
	
	
	
	public void update(){
		
		switch(characterID){
		
		case DRAGON: 
			if(isFireLeft() == true){
				moveLeft();
				moveDown();
			}
			else if(isFireRight() == true){
				moveRight();
				moveDown();		
			}
			break;
		
		case ZOMBIE:	
			setDirection();
			if(isFireLeft() == true){
				moveLeft();
				moveUp();
			}		
			else if(isFireRight() == true){
				moveRight();
				moveUp();
			}
			break;
		
		case HANGINGZOMBIE:
			if(isFireUp() == true){
				moveUp();
				moveLeft();
			}		
			else if(isFireDown() == true){
				moveDown();
				moveLeft();
			}
			break;
		}
		
		if(centerX < 0 || centerX > 1280 || centerY < 0 || centerY > 720)
			setVisible(false);
		
		setBounds();
		checkCollision();
	}
	
	
	
	public void setDirection(){
		
		if(characterID == DRAGON){
			if(dragon.isFacingLeft() == true)
				setFireLeft(true);
			else if(dragon.isFacingRight() == true)
				setFireRight(true);
		}
		
		if(characterID == ZOMBIE){		
			
			switch(characterNumber){
			
			case ZOMBIE3:
				if(zombie3.isAttackLeft() == true)
					setFireLeft(true);
				else if(zombie3.isAttackRight() == true)
					setFireRight(true);
				break;
				
			case ZOMBIE4:
				if(zombie4.isAttackLeft() == true)
					setFireLeft(true);
				else if(zombie4.isAttackRight() == true)
					setFireRight(true);
				break;
				
			case ZOMBIE7:
				if(zombie7.isAttackLeft() == true)
					setFireLeft(true);
				else if(zombie7.isAttackRight() == true)
					setFireRight(true);
				break;
				
			case ZOMBIE8:
				if(zombie8.isAttackLeft() == true)
					setFireLeft(true);
				else if(zombie8.isAttackRight() == true)
					setFireRight(true);
				break;
			}
			
		}
		
		if(characterID == HANGINGZOMBIE){
			
			switch(characterNumber){
			
			case HANGINGZOMBIE2:
				if(hangZombie2.isAttackUp() == true)
					setFireUp(true);
				else if(hangZombie2.isAttackDown() == true)
					setFireDown(true);
				break;
				
			case HANGINGZOMBIE4:
				if(hangZombie4.isAttackUp() == true)
					setFireUp(true);
				else if(hangZombie4.isAttackDown() == true)
					setFireDown(true);
				break;
			}
		}
	}
	
	
	
	public void setBounds(){
		
		if(characterID == DRAGON){
			cornerX = centerX-25;
			cornerY = centerY-25;
			fireballBound[characterID].setRect(cornerX+10, cornerY+10, 30, 30);
		}
		else if(characterID == ZOMBIE || characterID == HANGINGZOMBIE){
			cornerX = centerX-15;
			cornerY = centerY-15;
			fireballBound[characterID].setRect(cornerX+7, cornerY+7, 16, 16);
		}
	}
	
	
	
	public void checkCollision(){			
		
		if((characterID == ZOMBIE || characterID == HANGINGZOMBIE) && fireballBound[characterID].intersects(dragon.bound)){
			if(dragon.body.intersects(fireballBound[characterID]) || dragon.head.intersects(fireballBound[characterID]) || dragon.wingsUp.intersects(fireballBound[characterID]) || dragon.wingsDown.intersects(fireballBound[characterID]) || dragon.tail.intersects(fireballBound[characterID]) ){
				setVisible(false);
				StartingClass.dragon.setHealthUpdate(true, -5);
			}
		}
		
		else if(characterID == DRAGON){
			
			if(StartingClass.dragon.isPowerUpdate() == false)
				burn = -5;
			else if(StartingClass.dragon.isPowerUpdate() == true)
				burn = -10;
			
			if(fireballBound[characterID].intersects(zombie1.body[zombie1.zombieID]) || fireballBound[characterID].intersects(zombie1.head[zombie1.zombieID])){
				setVisible(false);
				StartingClass.zombie1.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(zombie2.body[zombie2.zombieID]) || fireballBound[characterID].intersects(zombie2.head[zombie2.zombieID])){
				setVisible(false);
				StartingClass.zombie2.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(zombie3.body[zombie3.zombieID]) || fireballBound[characterID].intersects(zombie3.head[zombie3.zombieID])){
				setVisible(false);
				StartingClass.zombie3.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(zombie4.body[zombie4.zombieID]) || fireballBound[characterID].intersects(zombie4.head[zombie4.zombieID])){
				setVisible(false);
				StartingClass.zombie4.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(zombie5.body[zombie5.zombieID]) || fireballBound[characterID].intersects(zombie5.head[zombie5.zombieID])){
				setVisible(false);
				StartingClass.zombie5.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(zombie6.body[zombie6.zombieID]) || fireballBound[characterID].intersects(zombie6.head[zombie6.zombieID])){
				setVisible(false);
				StartingClass.zombie6.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(zombie7.body[zombie7.zombieID]) || fireballBound[characterID].intersects(zombie7.head[zombie7.zombieID])){
				setVisible(false);
				StartingClass.zombie7.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(zombie8.body[zombie8.zombieID]) || fireballBound[characterID].intersects(zombie8.head[zombie8.zombieID])){
				setVisible(false);
				StartingClass.zombie8.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(hangZombie1.body[hangZombie1.hangingZombieID])){
				setVisible(false);
				StartingClass.hangZombie1.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(hangZombie2.body[hangZombie2.hangingZombieID])){
				setVisible(false);
				StartingClass.hangZombie2.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(hangZombie3.body[hangZombie3.hangingZombieID])){
				setVisible(false);
				StartingClass.hangZombie3.setHealth(burn);
			}
			
			else if(fireballBound[characterID].intersects(hangZombie4.body[hangZombie4.hangingZombieID])){
				setVisible(false);
				StartingClass.hangZombie4.setHealth(burn);
			}
		}
		
	}
	
	
	
	public void moveUp(){
		
		centerY -= (speedY);
	}



	public void moveDown(){
		
		centerY += (speedY);
	}



	public void moveLeft(){		
		
		if(characterID == ZOMBIE)
			centerX -= (speedX - bg.getSpeedX());
		else if(characterID == DRAGON)
			centerX -= speedX;
		else if(characterID == HANGINGZOMBIE)
			if(characterNumber == HANGINGZOMBIE2)
				centerX += hangZombie2.getSpeedX();
			else if(characterNumber == HANGINGZOMBIE4)
				centerX += hangZombie4.getSpeedX();
	}
	
	
	
	public void moveRight(){	
		
		centerX += speedX;
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



	public int getCharacterID() {
		return characterID;
	}



	public boolean isFireUp() {
		return fireUp;
	}



	public boolean isFireDown() {
		return fireDown;
	}



	public boolean isFireLeft() {
		return fireLeft;
	}



	public boolean isFireRight() {
		return fireRight;
	}



	public boolean isVisible() {
		return visible;
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



	public void setCharacterID(int characterID) {
		this.characterID = characterID;
	}



	public void setFireUp(boolean fireUp) {
		this.fireUp = fireUp;
	}



	public void setFireDown(boolean fireDown) {
		this.fireDown = fireDown;
	}



	public void setFireLeft(boolean fireLeft) {
		this.fireLeft = fireLeft;
	}



	public void setFireRight(boolean fireRight) {
		this.fireRight = fireRight;
	}



	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
