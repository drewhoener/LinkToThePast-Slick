package me.rockerjman222.lttp.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.tiled.TiledMap;

public class Camera {

	protected TiledMap map;

	protected int numTilesX;
	protected int numTilesY;

	protected int tileWidth;
	protected int tileHeight;
	protected int mapHeight;
	protected int mapWidth;

	protected float cameraX;
	protected float cameraY;

	protected GameContainer gc;

	public Camera(GameContainer gc, TiledMap map) {
		this.gc = gc;
		this.map = map;

		this.numTilesX = this.map.getWidth();
		this.numTilesY = this.map.getHeight();

		this.tileWidth = this.map.getTileWidth();
		this.tileHeight = this.map.getTileHeight();

		this.mapWidth = this.numTilesX * this.tileWidth;
		this.mapHeight = this.numTilesY * this.tileHeight;

	}

	public void centerOn(float x, float y) {
		this.cameraX = x - this.gc.getWidth() / 2;
		this.cameraY = y - this.gc.getHeight() / 2;

		if(this.cameraX < 0)
			this.cameraX = 0;

		if(this.cameraX + this.gc.getWidth() > this.mapWidth)
			this.cameraX = this.mapWidth - this.gc.getWidth();

		if(this.cameraY < 0)
			this.cameraY = 0;

		if(this.cameraY + this.gc.getHeight() > this.mapHeight)
			this.cameraY = this.mapHeight - this.gc.getHeight();

		drawMap((int) this.cameraX, (int) this.cameraY);

	}

	public void centerOn(float x, float y, float height, float width){
		this.centerOn(x + width / 2, y + height / 2);
	}

	public void centerOn(Shape shape) {
		this.centerOn(shape.getCenterX(), shape.getCenterY());
	}

	public void drawMap(int offsetX, int offsetY) {
		int tileOffsetX = (int) -(this.cameraX % this.tileWidth);
		int tileOffsetY = (int) -(this.cameraY % this.tileHeight);

		int tileIndexX = (int) (this.cameraX / this.tileWidth);
		int tileIndexY = (int) (this.cameraY / this.tileHeight);

		this.map.render(
				tileOffsetX + offsetX,
				tileOffsetY + offsetY,
				tileIndexX,
				tileIndexY,
				(this.gc.getWidth() - tileOffsetX) / this.tileWidth + 1,
				(this.gc.getHeight() - tileOffsetY) / this.tileHeight + 1);

	}

	public void drawMap() {
		this.drawMap(0, 0);
	}

	public void translateGraphics() {
		this.gc.getGraphics().translate(-this.cameraX, -this.cameraY);
	}

	public void untranslateGraphics() {
		this.gc.getGraphics().translate(this.cameraX, this.cameraY);
	}

}
