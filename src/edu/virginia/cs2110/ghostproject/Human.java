package edu.virginia.cs2110.ghostproject;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Human extends Entity 
{
	private int humanWidth;
	private int humanHeight;
	private int health; //int 0-100 
	private boolean repellent; //true = repellent currently on, false = not
	private boolean stun; //true = stun queued to happen, false = not
	private boolean bomb; //true = bomb queued to happen, false = not
	
	public Human(float x, float y, MyImage mi)
	{
		super(x, y, mi);
		repellent = false;
		stun = false;
		bomb = false;
		health = 100;
	}
	
	public void move(float x, float y)
	{
		/*
		while (xCurrent != x && yCurrent != y)
		{
			if (xCurrent < x && yCurrent < y)
			{
				xCurrent += 5;
				yCurrent += 5;
			}
			else if (xCurrent < x && yCurrent > y)
			{
				xCurrent += 5;
				yCurrent -= 5;
			}
			else if (xCurrent > x && yCurrent < y)
			{
				xCurrent -= 5;
				yCurrent += 5;
			}
			else if (xCurrent > x && yCurrent > y)
			{
				xCurrent -= 5;
				yCurrent -= 5;
			}
		}*/
		
		/*
		xCurrent = x / 2;
		yCurrent = y / 2;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		xCurrent = x;
		yCurrent = y;
		
		image.setX(this.xCurrent);
		image.setY(this.yCurrent);
		ChangeImage changer = new ChangeImage();
		changer.execute(image);
		Log.d("player x", Float.toString(x));
		Log.d("player y", Float.toString(y));
	}
	
	public int getHumanWidth() {
		return humanWidth;
	}

	public void setHumanWidth(int humanWidth) {
		this.humanWidth = humanWidth;
	}
	
	public int getHumanHeight() {
		return humanHeight;
	}

	public void setHumanHeight(int humanHeight) {
		this.humanHeight = humanHeight;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public boolean isAlive() {
		return (!(health <= 0));
	}

	public boolean isRepellentActive() {
		return repellent;
	}

	public void setRepellent(boolean repellent) {
		this.repellent = repellent;
	}

	public boolean isStunActive() {
		return stun;
	}

	public void setStun(boolean stun) {
		this.stun = stun;
	}
	
	public boolean isBombActive() {
		return bomb;
	}

	public void setBombs(boolean bomb) {
		this.bomb = bomb;
	}
}
