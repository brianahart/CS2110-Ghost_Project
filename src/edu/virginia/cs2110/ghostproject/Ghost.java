package edu.virginia.cs2110.ghostproject;

public class Ghost extends Entity 
{
	private int difficultyMoveChange;
	
	public Ghost(float x, float y, MyImage mi, int difficulty)
	{
		super(x, y, mi);
		difficultyMoveChange = difficulty;
	}

	public void move(float x, float y) 
	{
		if (xCurrent != x && yCurrent != y)
		{
			if (xCurrent < x && yCurrent < y)
			{
				xCurrent += difficultyMoveChange;
				yCurrent += difficultyMoveChange;
			}
			else if (xCurrent < x && yCurrent > y)
			{
				xCurrent += difficultyMoveChange;
				yCurrent -= difficultyMoveChange;
			}
			else if (xCurrent > x && yCurrent < y)
			{
				xCurrent -= difficultyMoveChange;
				yCurrent += difficultyMoveChange;
			}
			else if (xCurrent > x && yCurrent > y)
			{
				xCurrent -= difficultyMoveChange;
				yCurrent -= difficultyMoveChange;
			}
		}
	}
	
}
