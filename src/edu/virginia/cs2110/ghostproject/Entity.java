package edu.virginia.cs2110.ghostproject;

import android.graphics.Rect;

public class Entity 
{
	private float xInitial;
	private float yInitial;
	protected float xCurrent; //x and y pos equal to top left corner of image/sprite
	protected float yCurrent;
	
	private Rect hitbox;
	private int hitboxWidth; //len from x/y pos to its opposite corner
	private int hitboxHeight;
	
	private boolean visible; //true if currently active, false otherwise
	
	protected MyImage image;
	
	public float getxInitial() {
		return xInitial;
	}

	public void setxInitial(float xInitial) {
		this.xInitial = xInitial;
	}

	public float getyInitial() {
		return yInitial;
	}

	public void setyInitial(float yInitial) {
		this.yInitial = yInitial;
	}

	public float getxCurrent() {
		return xCurrent;
	}

	public void setxCurrent(float xCurrent) {
		this.xCurrent = xCurrent;
	}

	public float getyCurrent() {
		return yCurrent;
	}

	public void setyCurrent(float yCurrent) {
		this.yCurrent = yCurrent;
	}

	public Rect getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rect hitbox) {
		this.hitbox = hitbox;
	}
	
	public int getHitboxWidth() {
		return hitboxWidth;
	}

	public void setHitboxWidth(int hitboxWidth) {
		this.hitboxWidth = hitboxWidth;
	}

	public int getHitboxHeight() {
		return hitboxHeight;
	}

	public void setHitboxHeight(int hitboxHeight) {
		this.hitboxHeight = hitboxHeight;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void kill() {
		visible = false;
	}

	/*
	 * Constructs an entity
	 */
	public Entity(float xInitial, float yInitial, MyImage mi)
	{
		this.setxInitial(xInitial);
		this.setyInitial(yInitial);
		this.setxCurrent(xInitial);
		this.setyCurrent(yInitial);
		
		visible = true;
		setImage(mi);
	}
	
	/*
	 * This method moves the object's hitbox with it
	 */
	public void moveHitbox(){

		this.setHitbox(new Rect((int)xCurrent, (int)yCurrent, 
				(int)(xCurrent + hitboxWidth), (int)(yCurrent - hitboxHeight)));
	}
	
	/*
	 * This method tests whether the human is intersecting with an obstacle.
	 * 
	 * @param the rectangular obstacle being checked
	 * 
	 */
	public boolean checkCollision(Entity obstacle)
	{
		if (Rect.intersects(hitbox, obstacle.getHitbox()))
		{
			handleCollision(this, obstacle);
			return true;
		}
		
		return false;
	}
	
	private void handleCollision(Entity e1, Entity e2)
	{
		if (e1 instanceof Human && e2 instanceof Ghost)
		{
			Human h = (Human)e1;
			Ghost g = (Ghost)e2;
			h.setHealth(h.getHealth() - 25);
			g.kill();
		}
		else if (e1 instanceof Human && e2 instanceof Repellent)
		{
			Human h = (Human)e1;
			h.setRepellent(true);
			e2.kill();
		}
		else if (e1 instanceof Human && e2 instanceof Stun)
		{
			Human h = (Human)e1;
			h.setStun(true);
			e2.kill();
		}
		else if (e1 instanceof Human && e2 instanceof Bomb)
		{
			Human h = (Human)e1;
			h.setBombs(true);
			e2.kill();
		}
		
		return;
	}

	public MyImage getImage() {
		return image;
	}

	public void setImage(MyImage image) {
		this.image = image;
	}

}
