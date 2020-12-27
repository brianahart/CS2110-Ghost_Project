/*package edu.virginia.cs2110.ghostproject;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.media.Image;

public class MyGraphics 
{
	private AssetManager assets;
	private Bitmap frameBuffer;
	Canvas c;
	private Paint p;
	
	public static enum ImageFormat {
		ARGB8888, ARGB4444, RGB565,
	}
	
	public MyGraphics(AssetManager assets, Bitmap frameBuffer) 
	{
		this.assets = assets;
		this.frameBuffer = frameBuffer;
		this.c = new Canvas(frameBuffer);
		this.p = new Paint();
	}
	
	public MyImage newImage(String fileName, ImageFormat format)
	{   
		Config config = null;
        if (format == ImageFormat.RGB565)
            config = Config.RGB_565;
        else if (format == ImageFormat.ARGB4444)
            config = Config.ARGB_4444;
        else
            config = Config.ARGB_8888;

        Options options = new Options();
        options.inPreferredConfig = config;
        
        
        InputStream in = null;
        Bitmap bitmap = null;
        try {
            in = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                        + fileName + "'");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"
                    + fileName + "'");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }

        if (bitmap.getConfig() == Config.RGB_565)
            format = ImageFormat.RGB565;
        else if (bitmap.getConfig() == Config.ARGB_4444)
            format = ImageFormat.ARGB4444;
        else
            format = ImageFormat.ARGB8888;

        return new MyImage(bitmap, format);
	}
	
	public void clearScreen(int color)
	{
		c.drawRGB(0, 0, 0);
	}
	
	public void drawLine(float x, float y, float x2, float y2, int color)
	{
		p.setColor(color);
		c.drawLine(x, y, x2, y2, p);
	}
	
	public void drawRect(float x, float y, float width, float height, int color)
	{
		p.setColor(color);
		p.setStyle(Style.FILL);
		c.drawRect(x, y, x + width - 1, y + height - 1, p);
	}
	
	public void drawARGB(int a, int r, int g, int b)
	{
		p.setStyle(Style.FILL);
		c.drawARGB(a, r, g, b);
	}
	
	public void drawString(String text, float x, float y, Paint paint)
	{
		c.drawText(text, x, y, paint);
	}
	
	public void drawImage(Image i, float x, float y)
	{
		c.drawBitmap(i.bm, x, y, null);
	}
	
	public int getWidth() {
		return frameBuffer.getWidth();
	}
	
	public int getHeight() {
		return frameBuffer.getHeight();
	}
}*/
