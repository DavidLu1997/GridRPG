package grid;

public class Point {
	
	public int x;
	public int y;
	
	public Point()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public boolean isAdjacent(Point p)
	{
		if(p.x + 1 == x && p.y == y)
			return true;
		if(p.x - 1 == x && p.y == y)
			return true;
		if(p.y + 1 == y && p.x == x)
			return true;
		if(p.y - 1 == y && p.x == x)
			return true;
		if(p.x + 1 == x && p.y + 1 == y)
			return true;
		if(p.x + 1 == x && p.y - 1 == y)
			return true;
		if(p.x - 1 == x && p.y + 1 == y)
			return true;
		if(p.x - 1 == x && p.y - 1 == y)
			return true;
		return false;
	}
	
	public int shortestDistance(Point p)
	{
		return (int) Math.sqrt((p.x-x)*(p.x-x) + (p.y-y)*(p.y-y));
	}
	
	public Point nextInShortestPath(Point p)
	{
		Point t = new Point();
		t.x = x;
		t.y = y;
		
		int minX = x, minY = y;
		int minDist = shortestDistance(p);
		for(int i = x - 1; i <= x + 1; i++)
		{
			for(int j = y - 1; j <= y + 1; j++)
			{
				t.x = i;
				t.y = j;
				
				if(t.shortestDistance(p) < minDist)
				{
					minDist = t.shortestDistance(p);
					minX = i;
					minY = j;
				}
			}
		}
		
		t.x = minX;
		t.y = minY;
		
		return t;
	}
}
