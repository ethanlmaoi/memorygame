package cpp.edu.cs.cs141.memory;

public class GridFinal {

	public GridFinal()
	{
		
	}
	
	public void printGrid()
	{
		for (int x = 0; x < 9; ++x)
		{
			for (int y = 0; y < 9; ++y)
			{
				if (x == Player.getPositionX() && y == Player.getPositionY())
				{
					System.out.print("P ");
					if (x == 8)
					{
						System.out.print("\n");
					}
				}
				else
				{
					System.out.print("X ");
					if (x == 8)
					{
						System.out.print("\n");
					}
				}
			}
				
		}
	}
}
