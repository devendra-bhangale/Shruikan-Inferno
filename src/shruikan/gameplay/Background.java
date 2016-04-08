package shruikan.gameplay;

public class Background {
	
	private static final int COUNTER = 2;
	private static int change	= COUNTER;
	private static int bg		= 0;
	
	private int bgX, bgY, speedX;
	
	
	

	public Background(int x, int y){
		
		bgX = x;
		bgY = y;
		speedX = 0;
	}
	
	
	
	public void update(){
		
		bgX += speedX;
		
		if(bgX <= -1280){			
			bgX += 2560;
			changeBackground();
		}			
	}
	
	
	
	public void changeBackground(){
		
		change--;
		if(change == 0 && bg == 0){
			setBg(1);
			setChange(COUNTER);
		}
		if(change == 0 && bg == 1){
			setBg(0);
			setChange(COUNTER);
		}
	}

	
	
	//--------------------GETTERS--------------------
	public int getBgX() {

		return bgX;
	}



	public int getBgY() {

		return bgY;
	}



	public int getSpeedX() {

		return speedX;
	}


	
	public static int getChange() {
		return change;
	}



	public static int getBg() {
		return bg;
	}



	//--------------------SETTERS--------------------
	public void setBgX(int bgX) {

		this.bgX = bgX;
	}



	public void setBgY(int bgY) {

		this.bgY = bgY;
	}



	public void setSpeedX(int speedX) {

		this.speedX = speedX;
	}



	public static void setChange(int change) {
		Background.change = change;
	}



	public static void setBg(int bg) {
		Background.bg = bg;
	}
		
}
