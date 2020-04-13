package teams.beans;

public class Record 
{
	private int wins;
	private int losses;
	private int draws;
	private int points;
	
	public Record()
	{
		
	}
	
	public Record(int wins, int losses, int draws, int points) 
	{
		super();
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
		this.points = points;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Record [wins=" + wins + ", losses=" + losses + ", draws=" + draws + ", points=" + points + "]";
	}
}
