package users.Exception;

public class AccBalanceException extends Exception
{
	   String msg;
	   AccBalanceException() throws AccBalanceException
	   {
		   this.msg=msg;
	   }
	   public String toString()
		{
			return "AccBalanceException [message=" +msg+"]";
		}
}
