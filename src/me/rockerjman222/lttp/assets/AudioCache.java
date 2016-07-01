package me.rockerjman222.lttp.assets;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

@SuppressWarnings("unused")
public class AudioCache {

	public enum MusicEffect{

		BOSS_BACKGROUND("/res/audio/music/Boss_Background.wav"),
		BOSS_CLEAR("/res/audio/music/Boss_Clear_Fanfare.wav"),
		CAVE("/res/audio/music/Cave.wav"),
		CHURCH("/res/audio/music/Church.wav"),
		CRYSTAL("/res/audio/music/Crystal.wav"),
		DARK_MOUNTAIN_FOREST("/res/audio/music/Dark_Mountain_Forest.wav"),
		DARK_WORLD("/res/audio/music/Dark_World.wav"),
		DARK_WORLD_DUNGEON("/res/audio/music/Dark_World_Dungeon.wav"),
		ENDING("/res/audio/music/Ending.wav"),
		FALLING_RAIN("/res/audio/music/Falling_Rain.wav"),
		FOREST("/res/audio/music/Forest.wav"),
		FORTUNE_HOUSE("/res/audio/music/Fortune_Telling_House.wav"),
		GANON_BATTLE("/res/audio/music/Ganon_Battle.wav"),
		GANNON_MESSAGE("/res/audio/music/Ganons_Message.wav"),
		GODDESS_APPEARS("/res/audio/music/Goddess_Appears.wav"),
		GUESSING_GAME_HOUSE("/res/audio/music/Guessing_Game_House.wav"),
		HYRULE_CASTLE("/res/audio/music/Hyrule_Castle.wav"),
		KAKARIKO_VILLAGE("/res/audio/music/Kakariko_Village.wav"),
		KAKARIKO_SOLDIERS("/res/audio/music/Soldiers_Of_Kakariko.wav"),
		MASTER_SWORD_DEMO("/res/audio/music/Master_Sword_Demo.wav"),
		OPENING("/res/audio/music/Opening.wav"),
		OVERWORLD("/res/audio/music/Overworld.wav"),
		PRIEST("/res/audio/music/Priest.wav"),
		PRIEST_TRANSFORM("/res/audio/music/Priest_Transformation.wav"),
		RABBIT_TRANSFORM("/res/audio/music/Rabbit_Transformation.wav"),
		SANCTUARY_DUNGEON("/res/audio/music/Sanctuary_Dungeon.wav"),
		SELECT_SCREEN("/res/audio/music/Select_Screen.wav"),
		TITLE("/res/audio/music/Title.wav"),
		TRIFORCE_CHAMBER("/res/audio/music/Triforce_Chamber.wav"),
		ZELDA_RESCUE("/res/audio/music/Zeldas_Rescue.wav");

		private Music music;
		private float secondsTime;

		MusicEffect(String resourceURL){
			this(resourceURL, -1);
		}

		MusicEffect(String resourceURL, float secondsTime){
			try {
				music = new Music(resourceURL);
			} catch (SlickException e) {
				e.printStackTrace();
			}

			this.secondsTime = secondsTime;

		}
		
		public Music getMusic() {
			return music;
		}

		public float getSecondsTime() {
			return secondsTime;
		}
	}
	
	public enum LinkEffect{
		
		
	}
	
	public enum MenuEffect{
		
		
	}
	
	public enum ItemEffect{
		ARROW_HIT("/res/audio/sfx/items/Arrow_Hit.wav"),
		arrowShoot("/res/audio/sfx/items/Arrow_Shoot.wav"),
		BOMB_BLOW("/res/audio/sfx/items/Bomb_Blow.wav"),
		BOMB_DROP("/res/audio/sfx/items/Bomb_Drop.wav"),
		BOOK_OF_MUDORA("/res/audio/sfx/items/Book_Of_Mudora.wav"),
		BOOMERANG("/res/audio/sfx/items/Boomerang.wav"),
		CANE("/res/audio/sfx/items/Cane.wav"),
		CANE_MAGIC("/res/audio/sfx/items/Cane_Magic.wav"),
		ETHER("/res/audio/sfx/items/Ether.wav"),
		FIRE_ROD("/res/audio/sfx/items/Fire_Rod.wav"),
		FLUTE("/res/audio/sfx/items/Flute.wav"),
		FLUTE_EXTENDED("/res/audio/sfx/items/Flute_Extended.wav"),
		GET_FAIRY("/res/audio/sfx/items/Get_Fairy.wav"),
		GET_HEART_CONTAINER("/res/audio/sfx/items/Get_Heart_Container.wav"),
		GET_HEART_PIECE("/res/audio/sfx/items/Get_Heart_Piece.wav"),
		GET_HEART_PIECE_STEREO_LEFT("/res/audio/sfx/items/Get_Heart_Piece_StereoL.wav"),
		GET_HEART_PIECE_STEREO_RIGHT("/res/audio/sfx/items/Get_Heart_Piece_StereoR.wav"),
		GET_KEY("/res/audio/sfx/items/Get_Key.wav"),
		GET_KEY_STEREO_LEFT("/res/audio/sfx/items/Get_Key_StereoL.wav"),
		GET_KEY_STEREO_RIGHT("/res/audio/sfx/items/Get_Key_StereoR.wav"),
		HAMMER("/res/audio/sfx/items/Hammar.wav"),
		HAMMER_POST("/res/audio/sfx/items/Hammar_Post.wav"),
		HOOKSHOT("/res/audio/sfx/items/Hookshot.wav"),
		ICE_ROD("/res/audio/sfx/items/Ice_Rod.wav"),
		ITEM("/res/audio/sfx/items/Item.wav"),
		ITEM_FANFARE("/res/audio/sfx/items/Item_Fanfare.wav"),
		ITEM_FANFARE_STEREO("/res/audio/sfx/items/Item_Fanfare_Stereo.wav"),
		LAMP("/res/audio/sfx/items/Lamp.wav"),
		MAGIC_CAPE_ON("/res/audio/sfx/items/Magic_Cape_On.wav"),
		MAGIC_CAPE_OFF("/res/audio/sfx/items/Magic_Cape_Off.wav"),
		MAGIC_POWDER("/res/audio/sfx/items/Magic_Powder.wav"),
		MUSHROOM("/res/audio/sfx/items/Mushroom.wav"),
		NET("/res/audio/sfx/items/Net.wav"),
		RUPEE_1("/res/audio/sfx/items/Rupee1.wav", 20),
		RUPEE_2("/res/audio/sfx/items/Rupee2.wav"),
		SHIELD("/res/audio/sfx/items/Shield.wav"),
		SHOVEL("/res/audio/sfx/items/Shovel.wav"),
		SWORD_1("/res/audio/sfx/items/Sword1.wav"),
		SWORD_2("/res/audio/sfx/items/Sword2.wav"),
		SWORD_3("/res/audio/sfx/items/Sword3.wav"),
		SWORD_4("/res/audio/sfx/items/Sword4.wav"),
		SWORD_CHARGE("/res/audio/sfx/items/Sword_Charge.wav"),
		SWORD_MAGIC("/res/audio/sfx/items/Sword_Magic.wav"),
		SWORD_MAGIC_LOOP("/res/audio/sfx/items/Sword_Magic_Loop.wav"),
		SWORD_SPIN("/res/audio/sfx/items/Sword_Spin.wav"),
		SWORD_SPIN_MAGIC("/res/audio/sfx/items/Sword_Spin_Magic.wav"),
		SWORD_TAP("/res/audio/sfx/items/Sword_Tap.wav");
		
		private Sound sound;
		private int counts = 1;
		ItemEffect(String resourceURL){
			this(resourceURL, 1);
		}
		ItemEffect(String resourceURL, int counts){
			try {
				sound = new Sound(resourceURL);
			} catch (SlickException e) {
				e.printStackTrace();
			}
			this.counts = counts;
		}

		public int getCounts() {
			return counts;
		}

		public Sound getSound() {
			return sound;
		}
	}

}
