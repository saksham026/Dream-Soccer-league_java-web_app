package teams.Exception;

public class TeamLimitExceedException extends Exception
{ 
	String msg;
	TeamLimitExceedException() 
	{
		this.msg=msg;
	}
	public String toString()
	{
		return "TeamLimitExceedException [message=" +msg+"]";
		
	}
}
