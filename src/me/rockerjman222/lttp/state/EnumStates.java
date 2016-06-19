package me.rockerjman222.lttp.state;

public enum EnumStates {

	TITLE(0), CONTROLLER(1);

	private int id;

	EnumStates(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

}
