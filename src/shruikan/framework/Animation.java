package shruikan.framework;

import java.awt.Image;
import java.util.ArrayList;

public class Animation{

	private ArrayList frames;		//array of frame images
	private int currentFrame;		//current frame number in the "frames" array
	private long frameTime;			//elapsed time of current frame
	private long frameDuration;		//total duration for which frame is to be displayed
	
	
	
	public Animation(){

		frames = new ArrayList();
		frameDuration = 0;
		
		synchronized(this){
			frameTime = 0;
			currentFrame = 0;
		}
	}
	
	
	
	public synchronized void update(long elapsedTime){
	
		if(frames.size() > 1){
			frameTime += elapsedTime;
			if(frameTime >= frameDuration){
				frameTime %= frameDuration;
				currentFrame = 0;
			}
			
			while(frameTime > getFrame(currentFrame).frameDuration){
				currentFrame++;
			}
		}
	}
	
	
	
	public synchronized void addFrame(Image image, long duration){
		
		frameDuration += duration;
		frames.add(new AnimFrame(image, frameDuration));
	}
	
	
	
	public synchronized Image getImage(){
		
		if(frames.size() == 0)
			return null;
		else
			return getFrame(currentFrame).image;			
	}
	
	
	
	public AnimFrame getFrame(int currentFrame){
		
		return (AnimFrame) frames.get(currentFrame);
	}
	
	
	
	public Image getSprite(int i){
		
		return getFrame(i).image;
	}
	
	
	public int getSpriteID(){
		
		return currentFrame;
	}
	
	
	
	/**********NESTED CLASS**********/
	private class AnimFrame {

		Image image;
		long frameDuration;

		public AnimFrame(Image image, long frameDuration) {
			this.image = image;
			this.frameDuration = frameDuration;
		}
	}

}