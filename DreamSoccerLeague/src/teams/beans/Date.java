package teams.beans;

public class Date 
{
	private int dd;
	private int mm;
	private int yy;
	
	//parameterized constructor
	public Date()
	{
		
	}
	
	public Date(int dd,int mm,int yy)
	{
		this.dd=dd;
		this.mm=mm;
		this.yy=yy;
	}
	
	//setter methods
	public void setdd(int dd)
	{
		this.dd=dd;
	}
	
	public void setmm(int mm)
	{
		this.mm=mm;
	}
	
	public void setyy(int yy)
	{
		this.yy=yy;
	}
	
	//getter methods
	public int getDd()
	{
		return dd;
	}
	
	public int getMm()
	{
		return mm;
	}
	
	public int getYy()
	{
		return yy;
	}
	
	//toString method
	public String toString()
	{
		return "Date is"+dd+"/"+"/"+mm+"/"+yy;
	}
}
