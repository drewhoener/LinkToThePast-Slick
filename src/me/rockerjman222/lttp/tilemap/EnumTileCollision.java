package me.rockerjman222.lttp.tilemap;

public enum EnumTileCollision {

	//TODO: This is exactly as it looks like...
	//WELCOME TO HELL! This is where all of the tiles ids and their associated collision are stored
	//Btw, there is over 2000 tiles which all need this. This is gonna take some time.

	GRASS(1),
	GRASS_BOTTOM_LEFT(2),
	GRASS_BOTTOM_RIGHT(3),
	GRASS_TOP_LEFT(4),
	GRASS_TOP_RIGHT(5),
	HILL_1(6),
	HILL_2(7, EnumCollisionType.BOTTOM_HALF),
	HILL_3(8, EnumCollisionType.BOTTOM_HALF),
	HILL_4(9, EnumCollisionType.BOTTOM_HALF),
	HILL_5(10),
	HILL_6(11),
	HILL_7(12),
	HILL_8(13),
	HILL_9(14),
	HILL_10(15),
	WATER_1(16, EnumCollisionType.WATER),
	HILL_11(17, EnumCollisionType.FULL),
	HILL_12(18),
	HILL_13(19),
	HILL_14(20),
	HILL_15(21),
	HILL_16(22),
	HILL_17(23, EnumCollisionType.FULL),
	WATER_2(24, EnumCollisionType.WATER),
	HILL_18(25, EnumCollisionType.TOP_LEFT_TRIANGLE),
	HILL_19(26, EnumCollisionType.BOTTOM_RIGHT_TRIANGLE),
	HILL_20(27, EnumCollisionType.FULL),
	HILL_21(28, EnumCollisionType.FULL),
	HILL_22(29, EnumCollisionType.TOP_RIGHT_TRIANGLE),
	LARGE_STONE_1(30, EnumCollisionType.FULL),
	LARGE_STONE_2(31, EnumCollisionType.FULL);

	private int id;
	private EnumCollisionType type;
	private boolean canJump;

	EnumTileCollision(int id, EnumCollisionType type, boolean canJump) {
		this.id = id;
		this.type = type;
		this.canJump = canJump;
	}

	EnumTileCollision(int id, EnumCollisionType type) {
		this(id, type, false);
	}

	EnumTileCollision(int id) {
		this(id, EnumCollisionType.NONE);
	}

	public int getId() {
		return this.id;
	}

	public EnumCollisionType getType() {
		return this.type;
	}

	public boolean isCanJump() {
		return this.canJump;
	}
}
