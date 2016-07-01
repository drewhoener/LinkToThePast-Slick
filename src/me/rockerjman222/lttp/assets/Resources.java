package me.rockerjman222.lttp.assets;

import me.rockerjman222.lttp.Main;
import org.newdawn.slick.Sound;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class Resources {

	protected Resources(){}

	/** Storage **/
	public static HashMap<File, Sound> sfx;
	public static HashMap<File, Sound> music;
	public static HashMap<File, Sound> link;
	public static HashMap<File, Sound> menu;

	/** Window **/
	public static final BufferedImage windowIcon = loadImage("/window/icon.png");

	/** Fonts **/
	public static final BufferedImage fontSheet = loadImage("/fonts/font.png");

	/** Title **/
	public static final String nintendo = "/res/titleScreen/nintendo.png";
	public static final String copyright = "/res/titleScreen/copyright.png";
	public static final String triforce = "/titleScreen/triforce.png";
	public static final String triforceSprites = "/titleScreen/triforceSprites.png";
	public static final String background = "/titleScreen/background.png";
	public static final String titleNoSword = "/titleScreen/title_no_sword.png";
	public static final String logo = "/titleScreen/title.png";
	public static final String sword = "/titleScreen/sword.png";

	/** Intro **/
	public static final BufferedImage introSlides = loadImage("/intro/intro_slides.png");
	public static final BufferedImage backgroundOne = loadImage("/intro/bg_1.png");
	public static final BufferedImage backgroundTwo = loadImage("/intro/bg_2.png");

	/** Maps **/
	public static final File test = loadFile("/maps/Test.tmx");
	//public static final File linksHouse = loadFile("/maps/linksHouse.tmx");

	/** TileSets **/
	public static final BufferedImage overworldTiles = loadImage("/tileSets/overworldTileSet.png");
	//public static final BufferedImage interiorTileSet = loadImage("/tileSets/interiorTileSet.png");

	/** TileSheets **/
	public static final BufferedImage[] overworldTileSet = getSheet(overworldTiles, 16);

	/** Sprites **/

	/** Tiles **/
	public static final BufferedImage grass01 = overworldTileSet[0];
	public static final BufferedImage path01 = overworldTileSet[1];
	public static final BufferedImage bush01 = overworldTileSet[100];
	public static final BufferedImage flower01 = overworldTileSet[101];


	/** Music **/

	/** Items **/


	/** Link **/
	public static final File linkDash = loadFile("/audio/sfx/link/Link_Dash.wav");
	public static final File linkDying = loadFile("/audio/sfx/link/Link_Dying.wav");
	public static final File linkFall = loadFile("/audio/sfx/link/Link_Fall.wav");
	public static final File linkHurt = loadFile("/audio/sfx/link/Link_Hurt.wav");
	public static final File linkJump = loadFile("/audio/sfx/link/Link_Jump.wav");
	public static final File linkLand = loadFile("/audio/sfx/link/Link_Land.wav");
	public static final File linkPickup = loadFile("/audio/sfx/link/Link_Pickup.wav");
	public static final File linkPush = loadFile("/audio/sfx/link/Link_Push.wav");
	public static final File linkShock = loadFile("/audio/sfx/link/Link_Shock.wav");
	public static final File linkShockFast = loadFile("/audio/sfx/link/Link_Shock_Fast.wav");
	public static final File linkThrow = loadFile("/audio/sfx/link/Link_Throw.wav");

	/** Menus **/
	public static final File map = loadFile("/audio/sfx/menus/Map.wav");
	public static final File menuCursor = loadFile("/audio/sfx/menus/Menu_Cursor.wav");
	public static final File menuErase = loadFile("/audio/sfx/menus/Menu_Erase.wav");
	public static final File menuSelect = loadFile("/audio/sfx/menus/Menu_Select.wav");
	public static final File pauseClose = loadFile("/audio/sfx/menus/Pause_Close.wav");
	public static final File pauseOpen = loadFile("/audio/sfx/menus/Pause_Open.wav");
	public static final File saveQuit = loadFile("/audio/sfx/menus/Save_Quit.wav");
	public static final File textDone = loadFile("/audio/sfx/menus/Text_Done.wav");
	public static final File textLetter = loadFile("/audio/sfx/menus/Text_Letter.wav");

	static {
		sfx = new HashMap<>();
		music = new HashMap<>();
		link = new HashMap<>();
		menu = new HashMap<>();

		/*sfx.put(arrowHit, new Sound(arrowHit));
		sfx.put(arrowShoot, new Sound(arrowShoot));
		sfx.put(bombBlow, new Sound(bombBlow));
		sfx.put(bombDrop, new Sound(bombDrop));
		sfx.put(bookOfMudora, new Sound(bookOfMudora));
		sfx.put(boomerang, new Sound(boomerang));
		sfx.put(cane, new Sound(cane));
		sfx.put(caneMagic, new Sound(caneMagic));
		sfx.put(ether, new Sound(ether));
		sfx.put(fireRod, new Sound(fireRod));
		sfx.put(flute, new Sound(flute));
		sfx.put(fluteExtended, new Sound(fluteExtended));
		sfx.put(getFairy, new Sound(getFairy));
		sfx.put(getHeartContainer, new Sound(getHeartContainer));
		sfx.put(getHeartPiece, new Sound(getHeartPiece));
		sfx.put(getHeartPieceStereoL, new Sound(getHeartPieceStereoL));
		sfx.put(getGetHeartPieceStereoR, new Sound(getGetHeartPieceStereoR));
		sfx.put(getKey, new Sound(getKey));
		sfx.put(getKeyStereoL, new Sound(getKeyStereoL));
		sfx.put(getKeyStereoR, new Sound(getKeyStereoR));
		sfx.put(hammar, new Sound(hammar));
		sfx.put(hammarPost, new Sound(hammarPost));
		sfx.put(hookshot, new Sound(hookshot));
		sfx.put(iceRod, new Sound(iceRod));
		sfx.put(item, new Sound(item));
		sfx.put(itemFanfare, new Sound(itemFanfare));
		sfx.put(itemFanfareStereo, new Sound(itemFanfareStereo));
		sfx.put(lamp, new Sound(lamp));
		sfx.put(magicCapeOn, new Sound(magicCapeOn));
		sfx.put(magicCapeOff, new Sound(magicCapeOff));
		sfx.put(mushroom, new Sound(mushroom));
		sfx.put(net, new Sound(net));
		sfx.put(rupee1, new Sound(rupee1));
		sfx.put(rupee2, new Sound(rupee2));
		sfx.put(shield, new Sound(shield));
		sfx.put(shovel, new Sound(shovel));
		sfx.put(sword1, new Sound(sword1));
		sfx.put(sword2, new Sound(sword2));
		sfx.put(sword3, new Sound(sword3));
		sfx.put(sword4, new Sound(sword4));
		sfx.put(swordCharge, new Sound(swordCharge));
		sfx.put(swordMagic, new Sound(swordMagic));
		sfx.put(swordMagicLoop, new Sound(swordMagicLoop));
		sfx.put(swordSpin, new Sound(swordSpin));
		sfx.put(swordSpinMagic, new Sound(swordSpinMagic));
		sfx.put(swordTap, new Sound(swordTap));

		music.put(bossBackground, new Sound(bossBackground));
		music.put(bossClear, new Sound(bossClear));
		music.put(cave, new Sound(cave));
		music.put(church, new Sound(church));
		music.put(crystal, new Sound(crystal));
		music.put(darkMountainForest, new Sound(darkMountainForest));
		music.put(darkWorld, new Sound(darkWorld));
		music.put(darkWorldDungeon, new Sound(darkWorldDungeon));
		music.put(ending, new Sound(ending));
		music.put(fallingRain, new Sound(fallingRain));
		music.put(forest, new Sound(forest));
		music.put(fortuneHouse, new Sound(fortuneHouse));
		music.put(ganonBattle, new Sound(ganonBattle));
		music.put(ganonsMessage, new Sound(ganonsMessage));
		music.put(goddessAppears, new Sound(goddessAppears));
		music.put(guessingGameHouse, new Sound(guessingGameHouse));
		music.put(hyruleCastle, new Sound(hyruleCastle));
		music.put(kakariko, new Sound(kakariko));
		music.put(kakarikoSoldiers, new Sound(kakarikoSoldiers));
		music.put(masterSwordDemo, new Sound(masterSwordDemo));
		music.put(opening, new Sound(opening));
		music.put(overworld, new Sound(overworld));
		music.put(priest, new Sound(priest));
		music.put(priestTransform, new Sound(priestTransform));
		music.put(rabbitTransform, new Sound(rabbitTransform));
		music.put(sanctuaryDungeon, new Sound(sanctuaryDungeon));
		music.put(selectScreen, new Sound(selectScreen));
		music.put(title, new Sound(title));
		music.put(triforceChamber, new Sound(triforceChamber));
		music.put(zeldasRescue, new Sound(zeldasRescue));

		link.put(linkDash, new Sound(linkDash));
		link.put(linkDying, new Sound(linkDying));
		link.put(linkFall, new Sound(linkFall));
		link.put(linkHurt, new Sound(linkHurt));
		link.put(linkJump, new Sound(linkJump));
		link.put(linkLand, new Sound(linkLand));
		link.put(linkPickup, new Sound(linkPickup));
		link.put(linkPush, new Sound(linkPush));
		link.put(linkShock, new Sound(linkShock));
		link.put(linkShockFast, new Sound(linkShockFast));
		link.put(linkThrow, new Sound(linkThrow));

		menu.put(map, new Sound(map));
		menu.put(menuCursor, new Sound(menuCursor));
		menu.put(menuErase, new Sound(menuErase));
		menu.put(menuSelect, new Sound(menuSelect));
		menu.put(pauseClose, new Sound(pauseClose));
		menu.put(pauseOpen, new Sound(pauseOpen));
		menu.put(saveQuit, new Sound(saveQuit));
		menu.put(textDone, new Sound(textDone));
		menu.put(textLetter, new Sound(textLetter));*/
	}

	private static BufferedImage loadImage(String s) {
		URL url = Main.class.getResource(s);
		BufferedImage image = null;

		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}

	public static File loadFile(String s) {
		return new File(Main.class.getResource(s).getFile());
	}

	private static BufferedImage[] getSheet(BufferedImage image, int tileSize) {
		int rows = image.getHeight() / tileSize;
		int cols = image.getWidth() / tileSize;
		BufferedImage[] sprites = new BufferedImage[rows * cols];

		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < cols; y++) {
				sprites[(y * rows) + x] = image.getSubimage(x * tileSize, y * tileSize, tileSize, tileSize);
			}
		}

		return sprites;

	}

}
