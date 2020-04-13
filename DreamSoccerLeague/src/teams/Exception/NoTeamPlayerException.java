package teams.Exception;

public class NoTeamPlayerException extends Exception
{
	String msg;
	public NoTeamPlayerException()
	{
		this.msg=msg;
	}
	public String toString()
	{
		return "NoTeamPlayerException [message=" +msg+"]";
		
	}
}
