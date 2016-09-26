package assignment6;

public class TheaterConfig {
	protected Seat[][] seatArray = new Seat[26][26];
	
	public TheaterConfig()
	{
		for(int x = 0; x < 26; x++)
		{
			char c = (char) (x + 65);
			for(int y = 0; y < 26; y++)
			{
				seatArray[x][y] = new Seat(c, y + 1);
			}
		}
	}
	
	public synchronized void markAvailableSeatTaken(Seat s)
	{
		s.taken = true;
	}
	
	public synchronized Seat bestAvailableSeat(TheaterConfig t)
	{
		Seat s = null;
		for (int x = 0; x < 26; x++)
		{
			for(int y = 8; y < 17; y++)
			{
				if(t.seatArray[x][y].taken == false)
				{
					s = t.seatArray[x][y];
					return s;
				}
			}
			for(int y = 7; y >= 0; y--)
			{
				if(t.seatArray[x][y].taken == false)
				{
					s = t.seatArray[x][y];
					return s;
				}
			}
			for(int y = 17; y < 26; y++)
			{
				if(t.seatArray[x][y].taken == false)
				{
					s = t.seatArray[x][y];
					return s;
				}
			}
		}
		return s;
	}
	
	public synchronized void printTicketSeat(Seat s, ThreadedTicketClient c, boolean sold)
	{
		if(sold)
			System.out.println("SOLD OUT");
		else
			System.out.println(c.hostname + ": " + c.threadname + " - Seat " + s.row + s.num);
	}
}
