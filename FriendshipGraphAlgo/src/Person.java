
public class Person
{
	String name;
	String school;
	Person next;
	
	public Person (String name, String school, Person next)
	{
		this.name = name;
		this.school = school;
		this.next = next;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getSchool() 
	{
		return school;
	}

	public void setSchool(String school) 
	{
		this.school = school;
	}

	
}
