package teams.Exception;

public class NoTeamFoundException extends Exception
{
	String msg;
       NoTeamFoundException() 
       {
    	   this.msg=msg;
       }
       public String toString()
   	{
   		return "NoTeamFoundException [message=" +msg+"]";
   		
   	}
}
