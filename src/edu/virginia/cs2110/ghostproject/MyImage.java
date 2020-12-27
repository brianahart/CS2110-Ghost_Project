package edu.virginia.cs2110.ghostproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

public class MyImage extends ImageView
{
	private String name;
	
	public MyImage(Context context, String name) 
	{
		super(context);
		this.name = name;
	}
	
	@Override
	public void onDraw(Canvas c)
	{
		super.onDraw(c);
		Paint p = new Paint();
		p.setColor(Color.GREEN);
		c.drawCircle(0, 0, 10, p);

		
		c.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.girl), this.getX(), this.getY(), null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
