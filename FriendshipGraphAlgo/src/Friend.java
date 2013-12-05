import java.io.*;
import java.util.*;

public class Friend
{
	int numPeople;
	Person[] peopleArr = null;
	AdjLL peopleAdjLL = null;
	
	public Friend()
	{
		
	}
	
	public void buildGraph(Scanner file) throws IOException
	{
		Scanner sc = file;
		Person newPerson;

		String line = sc.nextLine();
		String temp = line.toString();
		numPeople = Integer.parseInt(temp);
		
		Person[] peopleArr= new Person[numPeople];
		
		for(int i = 0; i < numPeople; i++)
		{
			line = sc.nextLine();
			line= line.replace("|", ">");

			String [] lineArr = line.split(">");

			if(lineArr[1].contains("y"))
			{
				newPerson = new Person(lineArr[0], lineArr[2], null);
				
			}
			else
				newPerson = new Person(lineArr[0], null, null);

			peopleArr[i] = newPerson;
		}
		
		peopleAdjLL = new AdjLL(numPeople, peopleArr);
		Map<String,Person> peopleMap = peopleAdjLL.peopleMap;

		//build relationships
		while(sc.hasNext())
		{
			line = sc.nextLine();
			line= line.replace("|", ">");
			String[] lineArr = line.split(">");
			Person p1 = peopleMap.get(lineArr[0]);
			Person p2 = peopleMap.get(lineArr[1]);
			
			peopleAdjLL.buildRelationship(p1,p2);
		}
	}

	/*
	public final boolean containsDigit(String s)
	{  
		boolean containsDigit = false;
		if(s != null)
			for(char c : s.toCharArray())
				if(containsDigit = Character.isDigit(c))
					break;

		return containsDigit;
	}
	 */

	public void createPerson()
	{

	}

}
