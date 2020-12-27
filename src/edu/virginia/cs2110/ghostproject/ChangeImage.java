package edu.virginia.cs2110.ghostproject;

import android.os.AsyncTask;

public class ChangeImage extends AsyncTask<MyImage, MyImage, Double> 
{

	MyImage view;
	
	@Override
	protected Double doInBackground(MyImage... arg0) 
	{
		while (!this.isCancelled())
		{
			this.publishProgress(arg0);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0.0;
	}
	
	@Override
	protected void onProgressUpdate(MyImage... arg0)
	{
		for (MyImage mi : arg0)
			mi.invalidate();
	}
	
	@Override
	protected void onPostExecute(Double result) {}
	
	@Override
	protected void onCancelled() {}
	
	@Override
	protected void onPreExecute() {}

}
