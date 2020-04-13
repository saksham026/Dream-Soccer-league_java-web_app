package teams.beans;

public class Player 
{
	private String name;
	private int age;
	private String position;
	private int credits;
	
	public Player()
	{
		
	}
	
	public Player(String name, int age, String position, int credits) 
	{
		super();
		this.name = name;
		this.age = age;
		this.position = position;
		this.credits = credits;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public int getCredits() {
		return credits;
	}



	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() 
	{
		return "Player [name=" + name + ", age=" + age + ", position=" + position + ", credits=" + credits + "]";
	}
	
	
}
