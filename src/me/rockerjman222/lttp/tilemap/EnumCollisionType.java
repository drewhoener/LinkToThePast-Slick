package me.rockerjman222.lttp.tilemap;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public enum EnumCollisionType {

	NONE(0),
	FULL(1, new Rectangle(0, 0, 16, 16)),
	LADDER(3, new Rectangle(0, 0, 16, 16)),
	WATER(2, new Rectangle(0, 0, 16, 16)),
	LEFT_HALF(1, new Rectangle(0, 0, 8, 16)),
	RIGHT_HALF(1, new Rectangle(8, 0, 8, 16)),
	TOP_HALF(1, new Rectangle(0, 0, 16, 8)),
	BOTTOM_HALF(1, new Rectangle(0, 8, 16, 8)),
	TOP_LEFT(1, new Rectangle(0, 0, 8, 8)),
	TOP_RIGHT(1, new Rectangle(8, 0, 8, 8)),
	BOTTOM_LEFT(1, new Rectangle(0, 8, 8, 8)),
	BOTTOM_RIGHT(1, new Rectangle(8, 8, 8, 8)),
	TOP_LEFT_TRIANGLE(1, new float[]{0, 16, 0, 0, 16, 0}),
	TOP_RIGHT_TRIANGLE(1, new float[]{0, 0, 16, 0, 16, 16}),
	BOTTOM_LEFT_TRIANGLE(1, new float[]{0, 0, 0, 16, 16, 16}),
	BOTTOM_RIGHT_TRIANGLE(1, new float[]{0, 16, 16, 16, 16, 0});

	/*
	 * 0: General
	 * 1: Block
	 * 2: Water
	 * 3: Ladder
	 */

	int type;
	Shape shape;
	float[] points = new float[7];

	EnumCollisionType(int type, float[] points) {
		this.type = type;
		this.points = points;
		this.shape = null;
	}

	EnumCollisionType(int type, Shape shape) {
		this.type = type;
		this.shape = shape;
		this.points = null;
	}

	EnumCollisionType(int type) {
		this.type = type;
		this.shape = null;
		this.points = null;
	}

	public int getType() {
		return this.type;
	}

	public Shape getShape() {
		return this.shape;
	}

	public boolean intersects(Shape check) {
		if(this.shape != null) {
			if (this.shape.intersects(check))
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean intersects(float[] points) {
		if(this.points != null) {
			Polygon current = new Polygon(this.points);
			Polygon check = new Polygon(points);
			if(current.intersects(check))
				return true;
			else
				return false;
		} else
			return false;
	}

}
