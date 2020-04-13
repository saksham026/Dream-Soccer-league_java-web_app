package users.Exception;

public class CreditLimitException extends Exception
{
   String msg;
   CreditLimitException() 
   {
	   this.msg=msg;
   }
   public String toString()
	{
		return "CreditLimitException [message=" +msg+"]";	
	}
}
