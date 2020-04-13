package users.Exception;

public class FivePlayerException extends Exception
{
	String msg;
   FivePlayerException() throws FivePlayerException
   {
	   this.msg=msg;
   }
   public String toString()
	{
		return "FivePlayerException [message=" +msg+"]";
		
	}
}
