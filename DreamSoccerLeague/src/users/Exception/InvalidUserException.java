package users.Exception;

public class InvalidUserException extends Exception
{
	String msg;
	InvalidUserException() 
	{
	    this.msg=msg;
	}
	public String toString()
	{
		return "InvalidUserException [message=" +msg+"]";
	}
}
