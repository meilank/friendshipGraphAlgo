import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdjLL
{
	int size;
	HashMap<String, Person> peopleMap = new HashMap<String,Person>();
	
	public AdjLL(int numPeople, Person[] peopleArr)
	{
		this.size = numPeople;
		
		for(int i = 0; i <peopleArr.length; i++)
		{
			String name = peopleArr[i].name;
			System.out.println(name);
			peopleMap.put(name, peopleArr[i]);
		}
	
	}
	
	
	public void buildRelationship(Person p1, Person p2)
	{
		//locate p1 in array
		//go to next person node, and all there
		// before: p1 --> px --> py --> pz
		// after:  p1 --> p2 --> px --> py --> pz
		
		//size= peopleMap.size();
		for(int i = 0; i < size; i++)
		{
			Person temp= peopleMap.get(p1);
			p2.next= temp.next;
			temp.next= p2;
			if(p1.equals(peopleMap.get(p2.name)))
			{
				p2.next = p1.next;
				p1.next = p2;
				break;
			}
		}
		
	}
	public void checkStuff(Person p1) {
		
	}

}
