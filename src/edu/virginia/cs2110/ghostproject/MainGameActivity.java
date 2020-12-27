package edu.virginia.cs2110.ghostproject;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class MainGameActivity extends Activity {
	
	//maps that store all the in-game objects matched with their respective images
	private ArrayList<Entity> nonHumanOrGhosts; 
	private ArrayList<Entity> humanAndGhosts;
	
	//only human object needed
	private Human player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.fragment_main_game);
		
		nonHumanOrGhosts = new ArrayList<Entity>();
		humanAndGhosts = new ArrayList<Entity>();
		
		MyImage myGirl = new MyImage(this, "girl");
		myGirl.setX(0);
		myGirl.setY(0);
		player = new Human(myGirl.getX(), myGirl.getY(), myGirl); 
		humanAndGhosts.add(player);
		
		setContentView(myGirl);
		ChangeImage ci = new ChangeImage();
		ci.execute(myGirl);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public boolean onTouchEvent(MotionEvent event)
	{
		super.onTouchEvent(event);
		int action = event.getAction();
		switch (action)
		{
			case MotionEvent.ACTION_DOWN:
				float x = event.getX();
				float y = event.getY();
				Log.d("coors", Float.toString(x) + Float.toString(y));
				handleTouchEvent(x, y);
				break;
		}
		
		return true;
	}

	public void handleTouchEvent(float x, float y)
	{
		for (int i = 0; i < nonHumanOrGhosts.size(); i++)
		{
			if (nonHumanOrGhosts.get(i).getHitbox().contains((int)x, (int)y))
				return;
		}

		player.move(x, y);
		Log.d("player", "moving");
	}
	
	public void initializeImages(ArrayList<MyImage> ims)
	{
		//images.add(new MyImage(this, "ghost"));
		//images.get(1).setImageResource(R.drawable.ghost);
		/*images.add(new MyImage(this));
		images.get(2).setImageResource(R.drawable.bomb);
		images.add(new MyImage(this));
		images.get(3).setImageResource(R.drawable.repellent);
		images.add(new MyImage(this));
		images.get(4).setImageResource(R.drawable.stun);
		images.add(new MyImage(this));
		images.get(5).setImageResource(R.drawable.money);*/
	}
}
