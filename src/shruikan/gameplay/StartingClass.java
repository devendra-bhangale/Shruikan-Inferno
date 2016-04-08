package shruikan.gameplay;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

import shruikan.framework.Animation;



public class StartingClass extends Applet implements Runnable, KeyListener {

	private URL base;
	private Graphics second;
	private Font font1 = new Font(null, Font.PLAIN, 10), font2 = new Font(null, Font.BOLD, 30);
	
	private Image image, backgroundSprite, starSprite, dragonSprite, fireSprite, powerfulBlackZombieSprite1, powerfulBlackZombieSprite2, powerfulBlueZombieSprite1, powerfulBlueZombieSprite2, zombieFireballSprite1, zombieFireballSprite2, zombieFireballSprite3, zombieFireballSprite4, hangingZombieFireballSprite1, hangingZombieFireballSprite2;
	private Image background, background1, sun, moon;
	private Image blackCloud, greyCloud, powerCloud1, powerCloud2, powerCloud3, powerCloud4, powerCloud5, powerCloud6, powerCloud7, powerCloud8, phoenix1, phoenix2, phoenix3, phoenix4, phoenix5, nimbus;
	private Image oneStarBall1, oneStarBall2, twoStarBall1, twoStarBall2, threeStarBall1, threeStarBall2, fourStarBall1, fourStarBall2, fiveStarBall1, fiveStarBall2, sixStarBall1, sixStarBall2, sevenStarBall1, sevenStarBall2; 
	private Image dragon1, dragon2, dragon3, dragon4, deadDragon, powerUp1, powerUp2, powerUp3, powerUp4, powerUp5, powerUp6;
	private Image fireBall, powerBall1, powerBall2, powerBall3, fireBreadth1, fireBreadth2, fireBreadth3, fireBreadth4, fireBreadth5, fireBreadth6, fireBreadth7, fireBreadth8, fireBreadthPause, zombieFireball1, zombieFireball2, zombieFireball3, zombieFireball4, hangingZombieFireball1, hangingZombieFireball2, hangingZombieFireball3, hangingZombieFireball4, burningFire1, burningFire2, burningFire3, burningFire4, burningFire5, burningFire6, burningFire7, burningFire8;
	private Image blackZombie1, blackZombie2, blackZombie3, blackZombie4, blackZombie5, blackZombie6, blackZombie7, blackZombie8, blackZombie9, blackZombie10, blackZombie11, blackZombie12;
	private Image blueZombie1, blueZombie2, blueZombie3, blueZombie4, blueZombie5, blueZombie6, blueZombie7, blueZombie8, blueZombie9, blueZombie10, blueZombie11, blueZombie12;
	private Image powerfulBlackZombie1, powerfulBlackZombie2, powerfulBlackZombie3, powerfulBlackZombie4, powerfulBlackZombie5, powerfulBlackZombie6, powerfulBlackZombie7, powerfulBlackZombie8, powerfulBlackZombie9, powerfulBlackZombie10, powerfulBlackZombie11, powerfulBlackZombie12, powerfulBlackZombie13, powerfulBlackZombie14, powerfulBlackZombie15, powerfulBlackZombie16, powerfulBlackZombie17, powerfulBlackZombie18, powerfulBlackZombie19, powerfulBlackZombie20, powerfulBlackZombie21, powerfulBlackZombie22, powerfulBlackZombie23, powerfulBlackZombie24;
	private Image powerfulBlueZombie1, powerfulBlueZombie2, powerfulBlueZombie3, powerfulBlueZombie4, powerfulBlueZombie5, powerfulBlueZombie6, powerfulBlueZombie7, powerfulBlueZombie8, powerfulBlueZombie9, powerfulBlueZombie10, powerfulBlueZombie11, powerfulBlueZombie12, powerfulBlueZombie13, powerfulBlueZombie14, powerfulBlueZombie15, powerfulBlueZombie16, powerfulBlueZombie17, powerfulBlueZombie18, powerfulBlueZombie19, powerfulBlueZombie20, powerfulBlueZombie21, powerfulBlueZombie22, powerfulBlueZombie23, powerfulBlueZombie24;
	private Image hangingZombie1, hangingZombie2, hangingZombie3, hangingZombie4, hangingZombie5, hangingZombie6, hangingZombie7, hangingZombie8, hangingZombie9, hangingZombie10, hangingZombie11, hangingZombie12, hangingZombie13, hangingZombie14, hangingZombie15, hangingZombie16, hangingZombie17, hangingZombie18, hangingZombie19, hangingZombie20, hangingZombie21;
	private Image powerfulHangingZombie1, powerfulHangingZombie2, powerfulHangingZombie3, powerfulHangingZombie4, powerfulHangingZombie5, powerfulHangingZombie6, powerfulHangingZombie7, powerfulHangingZombie8, powerfulHangingZombie9, powerfulHangingZombie10, powerfulHangingZombie11, powerfulHangingZombie12, powerfulHangingZombie13, powerfulHangingZombie14, powerfulHangingZombie15, powerfulHangingZombie16, powerfulHangingZombie17, powerfulHangingZombie18, powerfulHangingZombie19, powerfulHangingZombie20, powerfulHangingZombie21;
	private Image heart, breadth, power;
	private Image[] starON = new Image[8]; 
	private Image[] starOFF = new Image[8];
	
	private static Background bg1, bg2;
	public static Clouds cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7, cloud8, powerCloud, nimbusCloud, phoenix;
	public static Dragon dragon;
	public static Zombie zombie1, zombie2, zombie3, zombie4, zombie5, zombie6, zombie7, zombie8;
	public static HangingZombie hangZombie1, hangZombie2, hangZombie3, hangZombie4;
	
	private static Animation animPowerCloud, animPhoenix, animStarBall1, animStarBall2, animStarBall3, animStarBall4, animStarBall5, animStarBall6, animStarBall7, animDragonFwd, animDragonBwd, animPowerUpFwd, animPowerUpBwd, animPowerBall, animFireBreadthFwd, animFireBreadthBwd, animBurningFire1, animBurningFire2, animBurningFire3, animBurningFire4, animBurningFire5, animBurningFire6, animBurningFire7, animBurningFire8, animZombieFireballLeft, animZombieFireballRight, animHangingZombieFireballUp, animHangingZombieFireballDown, animBlackZombie, animBlueZombie, animPowerfulBlackZombieFwd, animPowerfulBlackZombieBwd, animPowerfulBlueZombieFwd, animPowerfulBlueZombieBwd, animHangingZombie, animPowerfulHangingZombie;
	private ArrayList<Animation> animDragonBall		= new ArrayList<Animation>();

	
	
	@Override
	public void init() {

		setSize(1280, 720);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Shruikan Inferno");
		
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Image setups
		heart				= getImage(base, "resources/statistics/heart.png");
		breadth				= getImage(base, "resources/statistics/breadth.png");
		power				= getImage(base, "resources/statistics/power.png");
		
		starOFF[1]			= getImage(base, "resources/statistics/1star1.png");
		starON[1]			= getImage(base, "resources/statistics/1star2.png");
		starOFF[2]			= getImage(base, "resources/statistics/2star1.png");
		starON[2]			= getImage(base, "resources/statistics/2star2.png");
		starOFF[3]			= getImage(base, "resources/statistics/3star1.png");
		starON[3]			= getImage(base, "resources/statistics/3star2.png");
		starOFF[4]			= getImage(base, "resources/statistics/4star1.png");
		starON[4]			= getImage(base, "resources/statistics/4star2.png");
		starOFF[5]			= getImage(base, "resources/statistics/5star1.png");
		starON[5]			= getImage(base, "resources/statistics/5star2.png");
		starOFF[6]			= getImage(base, "resources/statistics/6star1.png");
		starON[6]			= getImage(base, "resources/statistics/6star2.png");
		starOFF[7]			= getImage(base, "resources/statistics/7star1.png");
		starON[7]			= getImage(base, "resources/statistics/7star2.png");
		
		background			= getImage(base, "resources/background/background.png");
		background1			= getImage(base, "resources/background/background1.png");
		
		sun					= getImage(base, "resources/background/sun.png");
		moon				= getImage(base, "resources/background/moon.png");
		
		blackCloud			= getImage(base, "resources/clouds/blackCloud.png");
		greyCloud			= getImage(base, "resources/clouds/greyCloud.png");
		
		powerCloud1			= getImage(base, "resources/clouds/powercloud1.png");
		powerCloud2			= getImage(base, "resources/clouds/powercloud2.png");
		powerCloud3			= getImage(base, "resources/clouds/powercloud1.png");
		powerCloud4			= getImage(base, "resources/clouds/powercloud2.png");
		powerCloud5			= getImage(base, "resources/clouds/powercloud1.png");
		powerCloud6			= getImage(base, "resources/clouds/powercloud2.png");
		powerCloud7			= getImage(base, "resources/clouds/powercloud1.png");
		powerCloud8			= getImage(base, "resources/clouds/powercloud2.png");
		
		phoenix1			= getImage(base, "resources/clouds/phoenix1.png");
		phoenix2			= getImage(base, "resources/clouds/phoenix2.png");
		phoenix3			= getImage(base, "resources/clouds/phoenix3.png");
		phoenix4			= getImage(base, "resources/clouds/phoenix4.png");
		phoenix5			= getImage(base, "resources/clouds/phoenix5.png");
		
		nimbus				= getImage(base, "resources/clouds/nimbuscloud.png");
		
		oneStarBall1		= getImage(base, "resources/dragonballs/1StarBall1.png");
		oneStarBall2		= getImage(base, "resources/dragonballs/1StarBall2.png");
		twoStarBall1		= getImage(base, "resources/dragonballs/2StarBall1.png");
		twoStarBall2		= getImage(base, "resources/dragonballs/2StarBall2.png");
		threeStarBall1		= getImage(base, "resources/dragonballs/3StarBall1.png");
		threeStarBall2		= getImage(base, "resources/dragonballs/3StarBall2.png");
		fourStarBall1		= getImage(base, "resources/dragonballs/4StarBall1.png");
		fourStarBall2		= getImage(base, "resources/dragonballs/4StarBall2.png");
		fiveStarBall1		= getImage(base, "resources/dragonballs/5StarBall1.png");
		fiveStarBall2		= getImage(base, "resources/dragonballs/5StarBall2.png");
		sixStarBall1		= getImage(base, "resources/dragonballs/6StarBall1.png");
		sixStarBall2		= getImage(base, "resources/dragonballs/6StarBall2.png");
		sevenStarBall1		= getImage(base, "resources/dragonballs/7StarBall1.png");
		sevenStarBall2		= getImage(base, "resources/dragonballs/7StarBall2.png");
		
		dragon1				= getImage(base, "resources/dragon/dragon1.png");
		dragon2				= getImage(base, "resources/dragon/dragon2.png");
		dragon3				= getImage(base, "resources/dragon/dragon3.png");
		dragon4				= getImage(base, "resources/dragon/dragon4.png");
		deadDragon			= getImage(base, "resources/dragon/deadDragon.png");
		
		powerUp1			= getImage(base, "resources/dragon/powerUp1.png");
		powerUp2			= getImage(base, "resources/dragon/powerUp2.png");
		powerUp3			= getImage(base, "resources/dragon/powerUp3.png");
		powerUp4			= getImage(base, "resources/dragon/powerUp4.png");
		powerUp5			= getImage(base, "resources/dragon/powerUp5.png");
		powerUp6			= getImage(base, "resources/dragon/powerUp6.png");
		
		fireBall			= getImage(base, "resources/fireball/fireball.png");
		
		powerBall1			= getImage(base, "resources/fireball/powerball1.png");
		powerBall2			= getImage(base, "resources/fireball/powerball2.png");
		powerBall3			= getImage(base, "resources/fireball/powerball3.png");
		
		fireBreadth1		= getImage(base, "resources/firebreadth/fireBreadth1.png");
		fireBreadth2		= getImage(base, "resources/firebreadth/fireBreadth2.png");
		fireBreadth3		= getImage(base, "resources/firebreadth/fireBreadth3.png");
		fireBreadth4		= getImage(base, "resources/firebreadth/fireBreadth4.png");
		fireBreadth5		= getImage(base, "resources/firebreadth/fireBreadth5.png");
		fireBreadth6		= getImage(base, "resources/firebreadth/fireBreadth6.png");
		fireBreadth7		= getImage(base, "resources/firebreadth/fireBreadth7.png");
		fireBreadth8		= getImage(base, "resources/firebreadth/fireBreadth8.png");		
		fireBreadthPause	= getImage(base, "resources/firebreadth/fireBreadthPause.png");
		
		zombieFireball1		= getImage(base, "resources/fireball/zombieFireball1.gif");
		zombieFireball2		= getImage(base, "resources/fireball/zombieFireball2.gif");
		zombieFireball3		= getImage(base, "resources/fireball/zombieFireball3.gif");
		zombieFireball4		= getImage(base, "resources/fireball/zombieFireball4.gif");
		
		hangingZombieFireball1 = getImage(base, "resources/fireball/hangingZombieFireball1.png");
		hangingZombieFireball2 = getImage(base, "resources/fireball/hangingZombieFireball2.png");
		hangingZombieFireball3 = getImage(base, "resources/fireball/hangingZombieFireball3.png");
		hangingZombieFireball4 = getImage(base, "resources/fireball/hangingZombieFireball4.png");
		
		burningFire1		= getImage(base, "resources/burningfire/burningFire1.gif");
		burningFire2		= getImage(base, "resources/burningfire/burningFire2.gif");
		burningFire3		= getImage(base, "resources/burningfire/burningFire3.gif");
		burningFire4		= getImage(base, "resources/burningfire/burningFire4.gif");
		burningFire5		= getImage(base, "resources/burningfire/burningFire5.gif");
		burningFire6		= getImage(base, "resources/burningfire/burningFire6.gif");
		burningFire7		= getImage(base, "resources/burningfire/burningFire7.gif");
		burningFire8		= getImage(base, "resources/burningfire/burningFire8.gif");
		
		blackZombie1		= getImage(base, "resources/zombies/blackZombie/blackZombie1.gif");
		blackZombie2		= getImage(base, "resources/zombies/blackZombie/blackZombie2.gif");
		blackZombie3		= getImage(base, "resources/zombies/blackZombie/blackZombie3.gif");
		blackZombie4		= getImage(base, "resources/zombies/blackZombie/blackZombie4.gif");
		blackZombie5		= getImage(base, "resources/zombies/blackZombie/blackZombie5.gif");
		blackZombie6		= getImage(base, "resources/zombies/blackZombie/blackZombie6.gif");
		blackZombie7		= getImage(base, "resources/zombies/blackZombie/blackZombie7.gif");
		blackZombie8		= getImage(base, "resources/zombies/blackZombie/blackZombie8.gif");
		blackZombie9		= getImage(base, "resources/zombies/blackZombie/blackZombie9.gif");
		blackZombie10		= getImage(base, "resources/zombies/blackZombie/blackZombie10.gif");
		blackZombie11		= getImage(base, "resources/zombies/blackZombie/blackZombie11.gif");
		blackZombie12		= getImage(base, "resources/zombies/blackZombie/blackZombie12.gif");
		
		blueZombie1			= getImage(base, "resources/zombies/blueZombie/blueZombie1.gif");
		blueZombie2			= getImage(base, "resources/zombies/blueZombie/blueZombie2.gif");
		blueZombie3			= getImage(base, "resources/zombies/blueZombie/blueZombie3.gif");
		blueZombie4			= getImage(base, "resources/zombies/blueZombie/blueZombie4.gif");
		blueZombie5			= getImage(base, "resources/zombies/blueZombie/blueZombie5.gif");
		blueZombie6			= getImage(base, "resources/zombies/blueZombie/blueZombie6.gif");
		blueZombie7			= getImage(base, "resources/zombies/blueZombie/blueZombie7.gif");
		blueZombie8			= getImage(base, "resources/zombies/blueZombie/blueZombie8.gif");
		blueZombie9			= getImage(base, "resources/zombies/blueZombie/blueZombie9.gif");
		blueZombie10		= getImage(base, "resources/zombies/blueZombie/blueZombie10.gif");
		blueZombie11		= getImage(base, "resources/zombies/blueZombie/blueZombie11.gif");
		blueZombie12		= getImage(base, "resources/zombies/blueZombie/blueZombie12.gif");

		powerfulBlackZombie1		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie1.gif");
		powerfulBlackZombie2		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie2.gif");
		powerfulBlackZombie3		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie3.gif");
		powerfulBlackZombie4		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie4.gif");
		powerfulBlackZombie5		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie5.gif");
		powerfulBlackZombie6		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie6.gif");
		powerfulBlackZombie7		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie7.gif");
		powerfulBlackZombie8		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie8.gif");
		powerfulBlackZombie9		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie9.gif");
		powerfulBlackZombie10		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie10.gif");
		powerfulBlackZombie11		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie11.gif");
		powerfulBlackZombie12		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie12.gif");
		powerfulBlackZombie13		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie13.gif");
		powerfulBlackZombie14		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie14.gif");
		powerfulBlackZombie15		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie15.gif");
		powerfulBlackZombie16		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie16.gif");
		powerfulBlackZombie17		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie17.gif");
		powerfulBlackZombie18		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie18.gif");
		powerfulBlackZombie19		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie19.gif");
		powerfulBlackZombie20		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie20.gif");
		powerfulBlackZombie21		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie21.gif");
		powerfulBlackZombie22		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie22.gif");
		powerfulBlackZombie23		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie23.gif");
		powerfulBlackZombie24		= getImage(base, "resources/zombies/powerfulBlackZombie/powerfulBlackZombie24.gif");
		
		powerfulBlueZombie1			= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie1.gif");
		powerfulBlueZombie2			= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie2.gif");
		powerfulBlueZombie3			= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie3.gif");
		powerfulBlueZombie4			= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie4.gif");
		powerfulBlueZombie5			= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie5.gif");
		powerfulBlueZombie6			= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie6.gif");
		powerfulBlueZombie7			= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie7.gif");
		powerfulBlueZombie8			= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie8.gif");
		powerfulBlueZombie9			= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie9.gif");
		powerfulBlueZombie10		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie10.gif");
		powerfulBlueZombie11		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie11.gif");
		powerfulBlueZombie12		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie12.gif");
		powerfulBlueZombie13		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie13.gif");
		powerfulBlueZombie14		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie14.gif");
		powerfulBlueZombie15		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie15.gif");
		powerfulBlueZombie16		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie16.gif");
		powerfulBlueZombie17		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie17.gif");
		powerfulBlueZombie18		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie18.gif");
		powerfulBlueZombie19		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie19.gif");
		powerfulBlueZombie20		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie20.gif");
		powerfulBlueZombie21		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie21.gif");
		powerfulBlueZombie22		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie22.gif");
		powerfulBlueZombie23		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie23.gif");
		powerfulBlueZombie24		= getImage(base, "resources/zombies/powerfulBlueZombie/powerfulBlueZombie24.gif");
		
		hangingZombie1				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie1.gif");
		hangingZombie2				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie2.gif");
		hangingZombie3				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie3.gif");
		hangingZombie4				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie4.gif");
		hangingZombie5				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie5.gif");
		hangingZombie6				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie6.png");
		hangingZombie7				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie7.png");
		hangingZombie8				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie8.png");
		hangingZombie9				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie9.png");
		hangingZombie10				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie10.png");
		hangingZombie11				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie11.png");
		hangingZombie12				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie10.png");
		hangingZombie13				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie9.png");
		hangingZombie14				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie8.png");
		hangingZombie15				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie7.png");
		hangingZombie16				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie6.png");
		hangingZombie17				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie5.gif");
		hangingZombie18				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie4.gif");
		hangingZombie19				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie3.gif");
		hangingZombie20				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie2.gif");
		hangingZombie21				= getImage(base, "resources/zombieshanging/hangingZombie/hangingZombie1.gif");
		
		powerfulHangingZombie1		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie1.gif");
		powerfulHangingZombie2		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie2.gif");
		powerfulHangingZombie3		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie3.gif");
		powerfulHangingZombie4		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie4.gif");
		powerfulHangingZombie5		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie5.gif");
		powerfulHangingZombie6		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie6.png");
		powerfulHangingZombie7		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie7.png");
		powerfulHangingZombie8		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie8.png");
		powerfulHangingZombie9		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie9.png");
		powerfulHangingZombie10		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie10.png");
		powerfulHangingZombie11		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie11.png");
		powerfulHangingZombie12		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie10.png");
		powerfulHangingZombie13		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie9.png");
		powerfulHangingZombie14		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie8.png");
		powerfulHangingZombie15		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie7.png");
		powerfulHangingZombie16		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie6.png");
		powerfulHangingZombie17		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie5.gif");
		powerfulHangingZombie18		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie4.gif");
		powerfulHangingZombie19		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie3.gif");
		powerfulHangingZombie20		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie2.gif");
		powerfulHangingZombie21		= getImage(base, "resources/zombieshanging/powerfulHangingZombie/powerfulHangingZombie1.gif");
		
		
		animPowerCloud = new Animation();
						animPowerCloud.addFrame(powerCloud1, 150);
						animPowerCloud.addFrame(powerCloud2, 150);
						animPowerCloud.addFrame(powerCloud3, 150);
						animPowerCloud.addFrame(powerCloud4, 150);
						animPowerCloud.addFrame(powerCloud5, 150);
						animPowerCloud.addFrame(powerCloud6, 150);
						animPowerCloud.addFrame(powerCloud7, 150);
						animPowerCloud.addFrame(powerCloud8, 150);
						
		animPhoenix = new Animation();
						animPhoenix.addFrame(phoenix1, 150);
						animPhoenix.addFrame(phoenix2, 150);
						animPhoenix.addFrame(phoenix3, 150);
						animPhoenix.addFrame(phoenix4, 150);
						animPhoenix.addFrame(phoenix5, 150);
						animPhoenix.addFrame(phoenix4, 150);
						animPhoenix.addFrame(phoenix3, 150);
						animPhoenix.addFrame(phoenix2, 150);
						
		animStarBall1 = new Animation();
						animStarBall1.addFrame(oneStarBall1, 100);
						animStarBall1.addFrame(oneStarBall2, 100);
		
		animStarBall2 = new Animation();
						animStarBall2.addFrame(twoStarBall1, 100);
						animStarBall2.addFrame(twoStarBall2, 100);
		
		animStarBall3 = new Animation();
						animStarBall3.addFrame(threeStarBall1, 100);
						animStarBall3.addFrame(threeStarBall2, 100);
		
		animStarBall4 = new Animation();
						animStarBall4.addFrame(fourStarBall1, 100);
						animStarBall4.addFrame(fourStarBall2, 100);
		
		animStarBall5 = new Animation();
						animStarBall5.addFrame(fiveStarBall1, 100);
						animStarBall5.addFrame(fiveStarBall2, 100);
		
		animStarBall6 = new Animation();
						animStarBall6.addFrame(sixStarBall1, 100);
						animStarBall6.addFrame(sixStarBall2, 100);
		
		animStarBall7 = new Animation();
						animStarBall7.addFrame(sevenStarBall1, 100);
						animStarBall7.addFrame(sevenStarBall2, 100);
						
		animDragonFwd = new Animation();
						animDragonFwd.addFrame(dragon1, 50);
						animDragonFwd.addFrame(dragon2, 50);
						animDragonFwd.addFrame(dragon1, 50);
						animDragonFwd.addFrame(dragon2, 50);
		
		animDragonBwd = new Animation();
						animDragonBwd.addFrame(dragon3, 50);
						animDragonBwd.addFrame(dragon4, 50);
						animDragonBwd.addFrame(dragon3, 50);
						animDragonBwd.addFrame(dragon4, 50);
						
		animPowerUpFwd = new Animation();
						animPowerUpFwd.addFrame(dragon1, 50);
						animPowerUpFwd.addFrame(powerUp1, 50);
						animPowerUpFwd.addFrame(dragon2, 50);
						animPowerUpFwd.addFrame(powerUp2, 50);
						animPowerUpFwd.addFrame(dragon1, 50);
						animPowerUpFwd.addFrame(powerUp3, 50);
						animPowerUpFwd.addFrame(dragon2, 50);
						
		animPowerUpBwd = new Animation();
						animPowerUpBwd.addFrame(powerUp4, 100);
						animPowerUpBwd.addFrame(dragon4, 100);
						animPowerUpBwd.addFrame(powerUp5, 100);
						animPowerUpBwd.addFrame(dragon4, 100);
						animPowerUpBwd.addFrame(powerUp6, 100);
						animPowerUpBwd.addFrame(dragon4, 100);
		
		animPowerBall = new Animation();
						animPowerBall.addFrame(powerBall1, 100);
						animPowerBall.addFrame(powerBall2, 100);
						animPowerBall.addFrame(powerBall3, 100);
				
		animFireBreadthFwd = new Animation();
						animFireBreadthFwd.addFrame(fireBreadth1, 100);
						animFireBreadthFwd.addFrame(fireBreadth2, 100);
						animFireBreadthFwd.addFrame(fireBreadth3, 100);
						animFireBreadthFwd.addFrame(fireBreadth4, 100);
						animFireBreadthFwd.addFrame(fireBreadthPause, 200);
		
		animFireBreadthBwd = new Animation();
						animFireBreadthBwd.addFrame(fireBreadth5, 100);
						animFireBreadthBwd.addFrame(fireBreadth6, 100);
						animFireBreadthBwd.addFrame(fireBreadth7, 100);
						animFireBreadthBwd.addFrame(fireBreadth8, 100);
						animFireBreadthBwd.addFrame(fireBreadthPause, 200);
		
		animZombieFireballLeft = new Animation();
						animZombieFireballLeft.addFrame(zombieFireball1, 100);
						animZombieFireballLeft.addFrame(zombieFireball2, 100);
						
		animZombieFireballRight = new Animation();
						animZombieFireballRight.addFrame(zombieFireball3, 100);
						animZombieFireballRight.addFrame(zombieFireball4, 100);
		
		animHangingZombieFireballUp = new Animation();
						animHangingZombieFireballUp.addFrame(hangingZombieFireball3, 100);
						animHangingZombieFireballUp.addFrame(hangingZombieFireball4, 100);
						
		animHangingZombieFireballDown = new Animation();
						animHangingZombieFireballDown.addFrame(hangingZombieFireball1, 100);
						animHangingZombieFireballDown.addFrame(hangingZombieFireball2, 100);
						
		
			
		animBurningFire1 = new Animation();
						animBurningFire1.addFrame(burningFire1, 100);
						animBurningFire1.addFrame(burningFire2, 100);
						animBurningFire1.addFrame(burningFire3, 100);
						animBurningFire1.addFrame(burningFire4, 100);
						animBurningFire1.addFrame(burningFire5, 100);
						animBurningFire1.addFrame(burningFire6, 100);
						animBurningFire1.addFrame(burningFire7, 100);
						animBurningFire1.addFrame(burningFire8, 100);
						
		animBurningFire2 = new Animation();
						animBurningFire2.addFrame(burningFire1, 200);
						animBurningFire2.addFrame(burningFire2, 200);
						animBurningFire2.addFrame(burningFire3, 200);
						animBurningFire2.addFrame(burningFire4, 200);
						animBurningFire2.addFrame(burningFire5, 200);
						animBurningFire2.addFrame(burningFire6, 200);
						animBurningFire2.addFrame(burningFire7, 200);
						animBurningFire2.addFrame(burningFire8, 200);
		animBurningFire3 = new Animation();
						animBurningFire3.addFrame(burningFire1, 300);
						animBurningFire3.addFrame(burningFire2, 300);
						animBurningFire3.addFrame(burningFire3, 300);
						animBurningFire3.addFrame(burningFire4, 300);
						animBurningFire3.addFrame(burningFire5, 300);
						animBurningFire3.addFrame(burningFire6, 300);
						animBurningFire3.addFrame(burningFire7, 300);
						animBurningFire3.addFrame(burningFire8, 300);
						
		animBurningFire4 = new Animation();
						animBurningFire4.addFrame(burningFire1, 400);
						animBurningFire4.addFrame(burningFire2, 400);
						animBurningFire4.addFrame(burningFire3, 400);
						animBurningFire4.addFrame(burningFire4, 400);
						animBurningFire4.addFrame(burningFire5, 400);
						animBurningFire4.addFrame(burningFire6, 400);
						animBurningFire4.addFrame(burningFire7, 400);
						animBurningFire4.addFrame(burningFire8, 400);
						
		animBurningFire5 = new Animation();
						animBurningFire5.addFrame(burningFire1, 500);
						animBurningFire5.addFrame(burningFire2, 500);
						animBurningFire5.addFrame(burningFire3, 500);
						animBurningFire5.addFrame(burningFire4, 500);
						animBurningFire5.addFrame(burningFire5, 500);
						animBurningFire5.addFrame(burningFire6, 500);
						animBurningFire5.addFrame(burningFire7, 500);
						animBurningFire5.addFrame(burningFire8, 500);
						
		animBurningFire6 = new Animation();
						animBurningFire6.addFrame(burningFire1, 600);
						animBurningFire6.addFrame(burningFire2, 600);
						animBurningFire6.addFrame(burningFire3, 600);
						animBurningFire6.addFrame(burningFire4, 600);
						animBurningFire6.addFrame(burningFire5, 600);
						animBurningFire6.addFrame(burningFire6, 600);
						animBurningFire6.addFrame(burningFire7, 600);
						animBurningFire6.addFrame(burningFire8, 600);
						
		animBurningFire7 = new Animation();
						animBurningFire7.addFrame(burningFire1, 700);
						animBurningFire7.addFrame(burningFire2, 700);
						animBurningFire7.addFrame(burningFire3, 700);
						animBurningFire7.addFrame(burningFire4, 700);
						animBurningFire7.addFrame(burningFire5, 700);
						animBurningFire7.addFrame(burningFire6, 700);
						animBurningFire7.addFrame(burningFire7, 700);
						animBurningFire7.addFrame(burningFire8, 700);
						
		animBurningFire8 = new Animation();
						animBurningFire8.addFrame(burningFire1, 800);
						animBurningFire8.addFrame(burningFire2, 800);
						animBurningFire8.addFrame(burningFire3, 800);
						animBurningFire8.addFrame(burningFire4, 800);
						animBurningFire8.addFrame(burningFire5, 800);
						animBurningFire8.addFrame(burningFire6, 800);
						animBurningFire8.addFrame(burningFire7, 800);
						animBurningFire8.addFrame(burningFire8, 800);
						
		animBlackZombie = new Animation();
						animBlackZombie.addFrame(blackZombie1, 75);
						animBlackZombie.addFrame(blackZombie2, 75);
						animBlackZombie.addFrame(blackZombie3, 75);
						animBlackZombie.addFrame(blackZombie4, 75);
						animBlackZombie.addFrame(blackZombie5, 75);
						animBlackZombie.addFrame(blackZombie6, 75);
						animBlackZombie.addFrame(blackZombie7, 75);
						animBlackZombie.addFrame(blackZombie8, 75);
						animBlackZombie.addFrame(blackZombie9, 75);
						animBlackZombie.addFrame(blackZombie10, 75);
						animBlackZombie.addFrame(blackZombie11, 75);
						animBlackZombie.addFrame(blackZombie12, 75);
		
		animBlueZombie = new Animation();
						animBlueZombie.addFrame(blueZombie1, 75);
						animBlueZombie.addFrame(blueZombie2, 75);
						animBlueZombie.addFrame(blueZombie3, 75);
						animBlueZombie.addFrame(blueZombie4, 75);
						animBlueZombie.addFrame(blueZombie5, 75);
						animBlueZombie.addFrame(blueZombie6, 75);
						animBlueZombie.addFrame(blueZombie7, 75);
						animBlueZombie.addFrame(blueZombie8, 75);
						animBlueZombie.addFrame(blueZombie9, 75);
						animBlueZombie.addFrame(blueZombie10, 75);
						animBlueZombie.addFrame(blueZombie11, 75);
						animBlueZombie.addFrame(blueZombie12, 75);
						
		animPowerfulBlackZombieFwd = new Animation();
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie1, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie2, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie3, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie4, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie5, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie6, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie7, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie8, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie9, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie10, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie11, 75);
						animPowerfulBlackZombieFwd.addFrame(powerfulBlackZombie12, 75);
						
		animPowerfulBlackZombieBwd = new Animation();
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie13, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie14, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie15, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie16, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie17, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie18, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie19, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie20, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie21, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie22, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie23, 75);
						animPowerfulBlackZombieBwd.addFrame(powerfulBlackZombie24, 75);
		
		animPowerfulBlueZombieFwd = new Animation();
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie1, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie2, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie3, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie4, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie5, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie6, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie7, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie8, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie9, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie10, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie11, 75);
						animPowerfulBlueZombieFwd.addFrame(powerfulBlueZombie12, 75);
						
		animPowerfulBlueZombieBwd = new Animation();
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie13, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie14, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie15, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie16, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie17, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie18, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie19, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie20, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie21, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie22, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie23, 75);
						animPowerfulBlueZombieBwd.addFrame(powerfulBlueZombie24, 75);
		
		animHangingZombie = new Animation();
						animHangingZombie.addFrame(hangingZombie1, 75);
						animHangingZombie.addFrame(hangingZombie2, 75);
						animHangingZombie.addFrame(hangingZombie3, 75);
						animHangingZombie.addFrame(hangingZombie4, 75);
						animHangingZombie.addFrame(hangingZombie5, 75);
						animHangingZombie.addFrame(hangingZombie6, 75);
						animHangingZombie.addFrame(hangingZombie7, 75);
						animHangingZombie.addFrame(hangingZombie8, 75);
						animHangingZombie.addFrame(hangingZombie9, 75);
						animHangingZombie.addFrame(hangingZombie10, 75);
						animHangingZombie.addFrame(hangingZombie11, 75);
						animHangingZombie.addFrame(hangingZombie12, 75);
						animHangingZombie.addFrame(hangingZombie13, 75);
						animHangingZombie.addFrame(hangingZombie14, 75);
						animHangingZombie.addFrame(hangingZombie15, 75);
						animHangingZombie.addFrame(hangingZombie16, 75);
						animHangingZombie.addFrame(hangingZombie17, 75);
						animHangingZombie.addFrame(hangingZombie18, 75);
						animHangingZombie.addFrame(hangingZombie19, 75);
						animHangingZombie.addFrame(hangingZombie20, 75);
						animHangingZombie.addFrame(hangingZombie21, 75);
						
		animPowerfulHangingZombie = new Animation();
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie1, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie2, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie3, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie4, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie5, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie6, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie7, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie8, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie9, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie10, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie11, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie12, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie13, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie14, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie15, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie16, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie17, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie18, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie19, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie20, 75);
						animPowerfulHangingZombie.addFrame(powerfulHangingZombie21, 75);
						
		
		
		backgroundSprite	= background;
		starSprite			= sun;
		dragonSprite		= animDragonFwd.getImage();
		fireSprite			= fireBall;
		
		animDragonBall.add(animStarBall1);		animDragonBall.add(animStarBall2);		animDragonBall.add(animStarBall3);		animDragonBall.add(animStarBall4);	
		animDragonBall.add(animStarBall5);		animDragonBall.add(animStarBall6);		animDragonBall.add(animStarBall7);		
	}
	
	
	
	@Override
	public void start() {

		bg1 = new Background(0, 0);
		bg2 = new Background(1280, 0);
		
		cloud1 = new Clouds(0);
		cloud2 = new Clouds(0);
		cloud3 = new Clouds(0);
		cloud4 = new Clouds(0);
		cloud5 = new Clouds(0);
		cloud6 = new Clouds(0);
		cloud7 = new Clouds(0);
		cloud8 = new Clouds(0);
		
		powerCloud		= new Clouds(1);
		nimbusCloud		= new Clouds(2);
		phoenix			= new Clouds(3);
		
		dragon = new Dragon();
		
		zombie1 = new Zombie(1, false);
		zombie2 = new Zombie(2, false);
		zombie3 = new Zombie(3, true);
		zombie4 = new Zombie(4, true);
		zombie5 = new Zombie(5, false);
		zombie6 = new Zombie(6, false);
		zombie7 = new Zombie(7, true);
		zombie8 = new Zombie(8, true);
				
		hangZombie1 = new HangingZombie(cloud1.getCenterX(), cloud1.getCenterY() + 100, 1, false);
		hangZombie2 = new HangingZombie(cloud4.getCenterX(), cloud4.getCenterY() + 100, 2, true);
		hangZombie3 = new HangingZombie(cloud5.getCenterX(), cloud5.getCenterY() + 100, 3, false);
		hangZombie4 = new HangingZombie(cloud8.getCenterX(), cloud8.getCenterY() + 100, 4, true);
		
		Thread thread1 = new Thread(this);
		thread1.start();
	}
	
	
	
	@Override
	public void stop() {

	}
	
	
	
	@Override
	public void destroy() {

	}
	
	
	
	@Override
	public void run() {

		if(dragon.getHealth() > 0){
			
			while (true) {
				bg1.update();
				bg2.update();
				
				if(bg1.getBg() == 0){
					backgroundSprite = background;
					starSprite = sun;
				}
				else if(bg1.getBg() == 1){
					backgroundSprite = background1;
					starSprite = moon;
				}
				
				cloud1.update();			cloud2.update();			cloud3.update();			cloud4.update();
				cloud5.update();			cloud6.update();			cloud7.update();			cloud8.update();
				
				if(powerCloud.getPowerCloudCounter() <= 0)
					powerCloud.update();
				
				if(nimbusCloud.getNimbusCloudCounter() <= 0 && nimbusCloud.getDragonBall() < 7)
					nimbusCloud.update();
				
				if(phoenix.getPhoenixCounter() <= 0)
					phoenix.update();
				
				dragon.update();
							
				if(dragon.isFacingRight() == true)
					dragonSprite	= animDragonFwd.getImage();
				if(dragon.isFacingLeft() == true)
					dragonSprite	= animDragonBwd.getImage();
				
				ArrayList<Projectiles> dragonProjectiles = dragon.getProjectiles();
				for (int i = 0; i < dragonProjectiles.size(); i++) {
					Projectiles p = (Projectiles) dragonProjectiles.get(i);
					if (p.isVisible() == true) {
						p.update();
					} else {
						dragonProjectiles.remove(i);
					}
				}
							
				zombie1.update();			zombie2.update();			zombie3.update();			zombie4.update();
				zombie5.update();			zombie6.update();			zombie7.update();			zombie8.update();
					
				if(zombie3.isAttackLeft() == true){
					powerfulBlackZombieSprite1 = animPowerfulBlackZombieFwd.getImage();
					zombieFireballSprite1 = animZombieFireballLeft.getImage();
				}
				else if(zombie3.isAttackRight() == true){
					powerfulBlackZombieSprite1 = animPowerfulBlackZombieBwd.getImage();
					zombieFireballSprite1 = animZombieFireballRight.getImage();
				}
							
				if(zombie4.isAttackLeft() == true){
					powerfulBlueZombieSprite1 = animPowerfulBlueZombieFwd.getImage();
					zombieFireballSprite2 = animZombieFireballLeft.getImage();
				}
				else if(zombie4.isAttackRight() == true){
					powerfulBlueZombieSprite1 = animPowerfulBlueZombieBwd.getImage();
					zombieFireballSprite2 = animZombieFireballRight.getImage();
				}
							
				if(zombie7.isAttackLeft() == true){
					powerfulBlackZombieSprite2 = animPowerfulBlackZombieFwd.getImage();
					zombieFireballSprite3 = animZombieFireballLeft.getImage();
				}
				else if(zombie7.isAttackRight() == true){
					powerfulBlackZombieSprite2 = animPowerfulBlackZombieBwd.getImage();
					zombieFireballSprite3 = animZombieFireballRight.getImage();
				}
							
				if(zombie8.isAttackLeft() == true){
					powerfulBlueZombieSprite2 = animPowerfulBlueZombieFwd.getImage();
					zombieFireballSprite4 = animZombieFireballLeft.getImage();
				}
				else if(zombie8.isAttackRight() == true){
					powerfulBlueZombieSprite2 = animPowerfulBlueZombieBwd.getImage();
					zombieFireballSprite4 = animZombieFireballRight.getImage();
				}
				
				ArrayList<Projectiles> zombie3Projectiles = zombie3.getProjectiles();
				for (int i = 0; i < zombie3Projectiles.size(); i++) {
					Projectiles p = (Projectiles) zombie3Projectiles.get(i);
					if (p.isVisible() == true) {
						p.update();
					} else {
						zombie3Projectiles.remove(i);
					}
				}
				
				ArrayList<Projectiles> zombie4Projectiles = zombie4.getProjectiles();
				for (int i = 0; i < zombie4Projectiles.size(); i++) {
					Projectiles p = (Projectiles) zombie4Projectiles.get(i);
					if (p.isVisible() == true) {
						p.update();
					} else {
						zombie4Projectiles.remove(i);
					}
				}
				
				ArrayList<Projectiles> zombie7Projectiles = zombie7.getProjectiles();
				for (int i = 0; i < zombie7Projectiles.size(); i++) {
					Projectiles p = (Projectiles) zombie7Projectiles.get(i);
					if (p.isVisible() == true) {
						p.update();
					} else {
						zombie7Projectiles.remove(i);
					}
				}
				
				ArrayList<Projectiles> zombie8Projectiles = zombie8.getProjectiles();
				for (int i = 0; i < zombie8Projectiles.size(); i++) {
					Projectiles p = (Projectiles) zombie8Projectiles.get(i);
					if (p.isVisible() == true) {
						p.update();
					} else {
						zombie8Projectiles.remove(i);
					}
				}
				
				hangZombie1.update();			hangZombie2.update();
				hangZombie3.update();			hangZombie4.update();
					
				if(hangZombie2.isAttackUp() == true){
					hangingZombieFireballSprite1 = animHangingZombieFireballUp.getImage();
				}
				else if(hangZombie2.isAttackDown() == true){
					hangingZombieFireballSprite1 = animHangingZombieFireballDown.getImage();
				}
				
				if(hangZombie4.isAttackUp() == true){
					hangingZombieFireballSprite2 = animHangingZombieFireballUp.getImage();
				}
				else if(hangZombie4.isAttackDown() == true){
					hangingZombieFireballSprite2 = animHangingZombieFireballDown.getImage();
				}
				
				ArrayList<Projectiles> hangZombie2Projectiles = hangZombie2.getProjectiles();
				for (int i = 0; i < hangZombie2Projectiles.size(); i++) {
					Projectiles p = (Projectiles) hangZombie2Projectiles.get(i);
					if (p.isVisible() == true) {
						p.update();
					} else {
						hangZombie2Projectiles.remove(i);
					}
				}
				
				ArrayList<Projectiles> hangZombie4Projectiles = hangZombie4.getProjectiles();
				for (int i = 0; i < hangZombie4Projectiles.size(); i++) {
					Projectiles p = (Projectiles) hangZombie4Projectiles.get(i);
					if (p.isVisible() == true) {
						p.update();
					} else {
						hangZombie4Projectiles.remove(i);
					}
				}
				
				animate();
				
				repaint();
	
				try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else if(dragon.getHealth() <= 0){
			
		}
	}
	
	
	
	public void animate() {

		animPowerCloud.update(50);
		animPhoenix.update(50);
		if(nimbusCloud.getDragonBall() < 7)
			animDragonBall.get(nimbusCloud.getDragonBall()).update(10);
		
		animDragonFwd.update(5);
		animDragonBwd.update(5);
		
		animPowerUpFwd.update(30);
		animPowerUpBwd.update(30);
		
		animPowerBall.update(10);
		
		animFireBreadthFwd.update(25);
		animFireBreadthBwd.update(25);
		
		animZombieFireballLeft.update(10);
		animZombieFireballRight.update(10);
		animHangingZombieFireballUp.update(10);
		animHangingZombieFireballDown.update(10);
		
		animBurningFire1.update(50);
		animBurningFire2.update(50);
		animBurningFire3.update(50);
		animBurningFire4.update(50);
		animBurningFire5.update(50);
		animBurningFire6.update(50);
		animBurningFire7.update(50);
		animBurningFire8.update(50);
		
		animBlackZombie.update(25);
		animBlueZombie.update(25);
		animPowerfulBlackZombieFwd.update(25);
		animPowerfulBlackZombieBwd.update(25);
		animPowerfulBlueZombieFwd.update(25);
		animPowerfulBlueZombieBwd.update(25);
		
		animHangingZombie.update(25);
		animPowerfulHangingZombie.update(25);
		
	}
	
	
	
	@Override
	public void update(Graphics g) {

		if (image == null) {			
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		
		if(dragon.getHealth() > 0){
			g.drawImage(backgroundSprite, bg1.getBgX(), bg1.getBgY(), this);
			g.drawImage(backgroundSprite, bg2.getBgX(), bg2.getBgY(), this);
			g.drawImage(starSprite, 1100, 50, this);
			
			g.drawImage(animHangingZombie.getImage(), hangZombie1.getCenterX()-100, hangZombie1.getCenterY()-100, this);
			g.drawImage(animPowerfulHangingZombie.getImage(), hangZombie2.getCenterX()-100, hangZombie2.getCenterY()-100, this);				
			g.drawImage(animHangingZombie.getImage(), hangZombie3.getCenterX()-100, hangZombie3.getCenterY()-100, this);
			g.drawImage(animPowerfulHangingZombie.getImage(), hangZombie4.getCenterX()-100, hangZombie4.getCenterY()-100, this);
			
			ArrayList<Projectiles> hangZombie2Projectiles = hangZombie2.getProjectiles();
			for (int i = 0; i < hangZombie2Projectiles.size(); i++) {
				Projectiles p = (Projectiles) hangZombie2Projectiles.get(i);
				g.drawImage(hangingZombieFireballSprite1, p.getCenterX() - 15, p.getCenterY() - 15, this);
			}
			
			ArrayList<Projectiles> hangZombie4Projectiles = hangZombie4.getProjectiles();
			for (int i = 0; i < hangZombie4Projectiles.size(); i++) {
				Projectiles p = (Projectiles) hangZombie4Projectiles.get(i);
				g.drawImage(hangingZombieFireballSprite2, p.getCenterX() - 15, p.getCenterY() - 15, this);
			}
			
			g.drawImage(blackCloud, cloud1.getCenterX() - 100, cloud1.getCenterY() - 44, this);
			g.drawImage(greyCloud, cloud2.getCenterX() - 100, cloud2.getCenterY() - 35, this);
			g.drawImage(blackCloud, cloud3.getCenterX() - 100, cloud3.getCenterY() - 44, this);
			g.drawImage(greyCloud, cloud4.getCenterX() - 100, cloud4.getCenterY() - 35, this);
			g.drawImage(blackCloud, cloud5.getCenterX() - 100, cloud5.getCenterY() - 44, this);
			g.drawImage(greyCloud, cloud6.getCenterX() - 100, cloud6.getCenterY() - 35, this);
			g.drawImage(blackCloud, cloud7.getCenterX() - 100, cloud7.getCenterY() - 44, this);
			g.drawImage(greyCloud, cloud8.getCenterX() - 100, cloud8.getCenterY() - 35, this);
			
			if(powerCloud.getPowerCloudCounter() <= 0){
				g.drawImage(animPowerCloud.getImage(), powerCloud.getCenterX() - 100, powerCloud.getCenterY() - 44, this);
			}
			
			if(nimbusCloud.getNimbusCloudCounter() <= 0 && nimbusCloud.getDragonBall() < 7){
				g.drawImage(nimbus, nimbusCloud.getCenterX() - 75, nimbusCloud.getCenterY() - 25, this);
				g.drawImage(animDragonBall.get(nimbusCloud.getDragonBall()).getImage(), nimbusCloud.getCenterX() - 45, nimbusCloud.getCenterY() - 40, this);
			}
			
			if(phoenix.getPhoenixCounter() <= 0){
				g.drawImage(animPhoenix.getImage(), phoenix.getCenterX() - 150, phoenix.getCenterY() - 150, this);
			}
			
			g.drawImage(animBlackZombie.getImage(), zombie1.getCenterX() - 100, zombie1.getCenterY() - 100, this);
			g.drawImage(animBlueZombie.getImage(), zombie2.getCenterX() - 100, zombie2.getCenterY() - 100, this);
			g.drawImage(animBlackZombie.getImage(), zombie5.getCenterX() - 100, zombie5.getCenterY() - 100, this);
			g.drawImage(animBlueZombie.getImage(), zombie6.getCenterX() - 100, zombie6.getCenterY() - 100, this);
			
			g.drawImage(powerfulBlackZombieSprite1, zombie3.getCenterX() - 100, zombie3.getCenterY() - 100, this);					
			g.drawImage(powerfulBlueZombieSprite1, zombie4.getCenterX() - 100, zombie4.getCenterY() - 100, this);
			g.drawImage(powerfulBlackZombieSprite2, zombie7.getCenterX() - 100, zombie7.getCenterY() - 100, this);
			g.drawImage(powerfulBlueZombieSprite2, zombie8.getCenterX() - 100, zombie8.getCenterY() - 100, this);	
			
			if(zombie1.isAlive() == false){
				g.drawImage(animBurningFire1.getImage(), zombie1.getBurnCenter(zombie1.zombieID, 0)-100, Enemy.GROUND-100, this);
				if(animBurningFire1.getSpriteID() >= 7)
					zombie1.setAlive(true);
			}
			
			if(zombie2.isAlive() == false){
				g.drawImage(animBurningFire2.getImage(), zombie2.getBurnCenter(zombie2.zombieID, 0)-100, Enemy.GROUND-100, this);
				if(animBurningFire2.getSpriteID() >= 7)
					zombie2.setAlive(true);
			}
			
			if(zombie3.isAlive() == false){
				g.drawImage(animBurningFire3.getImage(), zombie3.getBurnCenter(zombie3.zombieID, 0)-100, Enemy.GROUND-100, this);
				if(animBurningFire3.getSpriteID() >= 7)
					zombie3.setAlive(true);
			}
			
			if(zombie4.isAlive() == false){
				g.drawImage(animBurningFire4.getImage(), zombie4.getBurnCenter(zombie4.zombieID, 0)-100, Enemy.GROUND-100, this);
				if(animBurningFire4.getSpriteID() >= 7)
					zombie4.setAlive(true);
			}
			
			if(zombie5.isAlive() == false){
				g.drawImage(animBurningFire5.getImage(), zombie5.getBurnCenter(zombie5.zombieID, 0)-100, Enemy.GROUND-100, this);
				if(animBurningFire5.getSpriteID() >= 7)
					zombie5.setAlive(true);
			}
			
			if(zombie6.isAlive() == false){
				g.drawImage(animBurningFire6.getImage(), zombie6.getBurnCenter(zombie6.zombieID, 0)-100, Enemy.GROUND-100, this);
				if(animBurningFire6.getSpriteID() >= 7)
					zombie6.setAlive(true);
			}
			
			if(zombie7.isAlive() == false){
				g.drawImage(animBurningFire7.getImage(), zombie7.getBurnCenter(zombie7.zombieID, 0)-100, Enemy.GROUND-100, this);
				if(animBurningFire7.getSpriteID() >= 7)
					zombie7.setAlive(true);
			}
			
			if(zombie8.isAlive() == false){
				g.drawImage(animBurningFire8.getImage(), zombie8.getBurnCenter(zombie8.zombieID, 0)-100, Enemy.GROUND-100, this);
				if(animBurningFire8.getSpriteID() >= 7)
					zombie8.setAlive(true);
			}
			
			ArrayList<Projectiles> zombie3Projectiles = zombie3.getProjectiles();
			for (int i = 0; i < zombie3Projectiles.size(); i++) {
				Projectiles p = (Projectiles) zombie3Projectiles.get(i);
				g.drawImage(zombieFireballSprite1, p.getCenterX() - 15, p.getCenterY() - 15, this);
			}
	
			ArrayList<Projectiles> zombie4Projectiles = zombie4.getProjectiles();
			for (int i = 0; i < zombie4Projectiles.size(); i++) {
				Projectiles p = (Projectiles) zombie4Projectiles.get(i);
				g.drawImage(zombieFireballSprite2, p.getCenterX() - 15, p.getCenterY() - 15, this);
			}
	
			ArrayList<Projectiles> zombie7Projectiles = zombie7.getProjectiles();
			for (int i = 0; i < zombie7Projectiles.size(); i++) {
				Projectiles p = (Projectiles) zombie7Projectiles.get(i);
				g.drawImage(zombieFireballSprite3, p.getCenterX() - 15, p.getCenterY() - 15, this);
			}
	
			ArrayList<Projectiles> zombie8Projectiles = zombie8.getProjectiles();
			for (int i = 0; i < zombie8Projectiles.size(); i++) {
				Projectiles p = (Projectiles) zombie8Projectiles.get(i);
				g.drawImage(zombieFireballSprite4, p.getCenterX() - 15, p.getCenterY() - 15, this);
			}
			
			g.drawImage(dragonSprite, dragon.getCenterX() - 135, dragon.getCenterY() - 96, this);
			
			ArrayList<Projectiles> dragonProjectiles = dragon.getProjectiles();
			for (int i = 0; i < dragonProjectiles.size(); i++) {
				Projectiles p = (Projectiles) dragonProjectiles.get(i);
				if(p.powerUpdate == false)
					fireSprite = fireBall;
				else if(p.powerUpdate == true)
					fireSprite = animPowerBall.getImage();
				g.drawImage(fireSprite, p.getCenterX() - 25, p.getCenterY() - 25, this);
			}
			
			if(dragon.isFiring() == true && dragon.getBreadth() > 0 && dragon.isFacingRight() == true ){
				g.drawImage(animFireBreadthFwd.getImage(), dragon.getCenterX() + 125, dragon.getCenterY() + 5, this);
			}
			else if(dragon.isFiring() == true && dragon.getBreadth() > 0 && dragon.isFacingLeft() == true){
				g.drawImage(animFireBreadthBwd.getImage(), dragon.getCenterX() - 305, dragon.getCenterY() + 5, this);
			}
						
						/*****************************/			
						/************SCORE************/
						/*****************************/
			g.setColor(Color.GRAY);
			
			g.setFont(font2);
			//Score
			g.drawString(Integer.toString(dragon.getGameScore()), 30, 30);								
			
			g.setFont(font1);
			g.drawString(Integer.toString(dragon.getHealth()/5), 135, 40);
			g.drawString(Integer.toString(dragon.getBreadth()/5), 135, 60);
			g.drawString(Integer.toString(dragon.getPowerEnergy()), 135, 80);
			
			//health
			g.drawImage(heart, 5, 30, this);
			g.setColor(Color.GREEN);
			g.drawRect(30, 35, 100, 10);
			g.fillRect(30, 35, 100-(100-(dragon.getHealth()/5)), 10);		
			
			//breadth
			g.drawImage(breadth, 5, 50, this);
			g.setColor(Color.RED);
			g.drawRect(30, 55, 100, 10);
			g.fillRect(30, 55, 100-(100-(dragon.getBreadth()/5)), 10);	
			
			//power
			g.drawImage(power, 5, 70, this);
			g.setColor(Color.BLUE);
			g.drawRect(30, 75, 100, 10);
			g.fillRect(30, 75, 100-(100-dragon.getPowerEnergy()), 10);	
			
			//dragonballs collected
			for(int i=1; i<8; i++){
				g.drawImage(starOFF[i], 460+i*40, 5, this);
				if(nimbusCloud.getBallCollection(i))
					g.drawImage(starON[i], 460+i*40, 5, this);
			}
			
						/*****************************/
						/************SCORE************/
						/*****************************/
		}
		else if(dragon.getHealth() <= 0){
			g.setFont(font2);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1280, 720);
			g.setColor(Color.GRAY);
			g.drawString("SHRUIKAN IS DEAD!!!", 500, 260);
			g.drawImage(deadDragon, 610, 270, this);
		}
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()){
		
			case KeyEvent.VK_UP:
				dragon.moveUp();
				dragon.setMovingUp(true);
				break;
				
			case KeyEvent.VK_DOWN:
				dragon.moveDown();
				dragon.setMovingDown(true);
				break;
				
			case KeyEvent.VK_LEFT:
				dragon.moveLeft();
				dragon.setMovingLeft(true);
				break;
				
			case KeyEvent.VK_RIGHT:
				dragon.moveRight();
				dragon.setMovingRight(true);
				break;
				
			case KeyEvent.VK_C:				
				if(dragon.getBreadth() > 0)
					dragon.setFiring(true);
				break;
	
			case KeyEvent.VK_X:
				dragon.setFacinglocked(true);
				break;
			
			case KeyEvent.VK_V:
				dragon.fire();
				dragon.setFireReady(false);
				dragon.setFireCounter(dragon.getFireCounter() - 1);
				if(dragon.getFireCounter() % 15 == 0)
					dragon.setFireReady(true);
				break;
		}

	}
	
	
	
	@Override
	public void keyReleased(KeyEvent e) {

		switch(e.getKeyCode()){
				
			case KeyEvent.VK_UP:
				dragon.setMovingUp(false);
				dragon.stopUp();
				break;
				
			case KeyEvent.VK_DOWN:
				dragon.setMovingDown(false);
				dragon.stopDown();
				break;
				
			case KeyEvent.VK_LEFT:
				dragon.setMovingLeft(false);
				dragon.stopLeft();
				break;
				
			case KeyEvent.VK_RIGHT:
				dragon.setMovingRight(false);
				dragon.stopRight();
				break;
				
			case KeyEvent.VK_C:				
				dragon.setFiring(false);
				break;
	
			case KeyEvent.VK_X:
				dragon.setFacinglocked(false);
				break;
			
			case KeyEvent.VK_V:
				dragon.stopFire();
				dragon.setFireReady(true);
				break;
		}

	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}



	//--------------------GETTERS--------------------
	public static Background getBg1() {
		return bg1;
	}



	public static Background getBg2() {
		return bg2;
	}



	public static Dragon getDragon() {
		return dragon;
	}



	public static Clouds getCloud1() {
		return cloud1;
	}



	public static Clouds getCloud4() {
		return cloud4;
	}



	public static Clouds getCloud5() {
		return cloud5;
	}



	public static Clouds getCloud8() {
		return cloud8;
	}



	public static Zombie getZombie3() {
		return zombie3;
	}



	public static Zombie getZombie4() {
		return zombie4;
	}



	public static Zombie getZombie7() {
		return zombie7;
	}



	public static Zombie getZombie8() {
		return zombie8;
	}



	public static HangingZombie getHangZombie2() {
		return hangZombie2;
	}



	public static HangingZombie getHangZombie4() {
		return hangZombie4;
	}



	public static Animation getAnimPowerfulHangingZombie() {
		return animPowerfulHangingZombie;
	}



	public static Zombie getZombie1() {
		return zombie1;
	}



	public static Zombie getZombie2() {
		return zombie2;
	}



	public static Zombie getZombie5() {
		return zombie5;
	}



	public static Zombie getZombie6() {
		return zombie6;
	}



	public static HangingZombie getHangZombie1() {
		return hangZombie1;
	}



	public static HangingZombie getHangZombie3() {
		return hangZombie3;
	}



	public static Animation getAnimFireBreadthFwd() {
		return animFireBreadthFwd;
	}



	public static Animation getAnimFireBreadthBwd() {
		return animFireBreadthBwd;
	}



	//--------------------SETTERS--------------------
	public static void setBg1(Background bg1) {
		StartingClass.bg1 = bg1;
	}



	public static void setBg2(Background bg2) {
		StartingClass.bg2 = bg2;
	}



	public static void setDragon(Dragon dragon) {
		StartingClass.dragon = dragon;
	}



	public static void setCloud1(Clouds cloud1) {
		StartingClass.cloud1 = cloud1;
	}



	public static void setCloud4(Clouds cloud4) {
		StartingClass.cloud4 = cloud4;
	}



	public static void setCloud5(Clouds cloud5) {
		StartingClass.cloud5 = cloud5;
	}



	public static void setCloud8(Clouds cloud8) {
		StartingClass.cloud8 = cloud8;
	}



	public static void setZombie3(Zombie zombie3) {
		StartingClass.zombie3 = zombie3;
	}



	public static void setZombie4(Zombie zombie4) {
		StartingClass.zombie4 = zombie4;
	}



	public static void setZombie7(Zombie zombie7) {
		StartingClass.zombie7 = zombie7;
	}



	public static void setZombie8(Zombie zombie8) {
		StartingClass.zombie8 = zombie8;
	}



	public static void setHangZombie2(HangingZombie hangZombie2) {
		StartingClass.hangZombie2 = hangZombie2;
	}



	public static void setHangZombie4(HangingZombie hangZombie4) {
		StartingClass.hangZombie4 = hangZombie4;
	}



	public static void setAnimPowerfulHangingZombie(
			Animation animPowerfulHangingZombie) {
		StartingClass.animPowerfulHangingZombie = animPowerfulHangingZombie;
	}



	public static void setZombie1(Zombie zombie1) {
		StartingClass.zombie1 = zombie1;
	}



	public static void setZombie2(Zombie zombie2) {
		StartingClass.zombie2 = zombie2;
	}



	public static void setZombie5(Zombie zombie5) {
		StartingClass.zombie5 = zombie5;
	}



	public static void setZombie6(Zombie zombie6) {
		StartingClass.zombie6 = zombie6;
	}



	public static void setHangZombie1(HangingZombie hangZombie1) {
		StartingClass.hangZombie1 = hangZombie1;
	}



	public static void setHangZombie3(HangingZombie hangZombie3) {
		StartingClass.hangZombie3 = hangZombie3;
	}



	public static void setAnimFireBreadthFwd(Animation animFireBreadthFwd) {
		StartingClass.animFireBreadthFwd = animFireBreadthFwd;
	}



	public static void setAnimFireBreadthBwd(Animation animFireBreadthBwd) {
		StartingClass.animFireBreadthBwd = animFireBreadthBwd;
	}

}
