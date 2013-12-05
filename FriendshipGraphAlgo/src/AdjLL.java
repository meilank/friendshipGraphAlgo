import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class AdjLL
{
	int size;
	HashMap<String,Person> peopleMap = new HashMap<String,Person>();

	public AdjLL(int numPeople, Person[] peopleArr)
	{
		this.size = numPeople;
		peopleMap= new HashMap<String,Person>();

		for(int i = 0; i <peopleArr.length; i++)
		{
			String name = peopleArr[i].name;
			peopleMap.put(name, peopleArr[i]);
		}

	}


	public void buildRelationship(Person p1, Person p2)
	{
		//locate p1 in array
		//go to next person node, and all there
		// before: p1 --> px --> py --> pz
		// after: p1 --> p2 --> px --> py --> pz

		//PROBLEM HERE -- REFERENCES NOT COPIES
		Person newNeighbor1 = new Person(p1.name, p1.school, p2.next);
		Person newNeighbor2 = new Person(p2.name, p2.school, p1.next);
		p2.next = newNeighbor1;
		p1.next = newNeighbor2;
	}
	
	public String search(String string) {
		Person prev= null;
		boolean ifFirst= true;
		//Iterator<Map.Entry<String, Person>> entries = peopleMap.entrySet().iterator();
		for (String s : peopleMap.keySet()) {

			Person curr = peopleMap.get(s);
			do {
				if (ifFirst) {
					Person newPerson = new Person(curr.name, curr.school, null);
					prev= newPerson;
					ifFirst= false;
					curr= curr.next;
					continue;
				}
				if (curr.school== null) {
					prev= curr;
					curr= curr.next;
					continue;
				}
				if (curr.school.equals(string)) {
					Person newPerson = new Person(curr.name, curr.school, null);
					buildRelationship(prev, newPerson);
					System.out.println(curr.name + "|y|" + curr.school);
					//return curr.name + "|y|" + curr.school;
				}
				prev= curr;
				curr= curr.next;
			} while(curr!= null);
			ifFirst= true;
		}
		return null;
	}
	
	public String dfsSearch(String string) {
		Person prev= null;
		Set<String> keys = peopleMap.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext();) {
			String key = (String) i.next();
			Person curr = (Person) peopleMap.get(key);
			System.out.println(curr.school);
			if (curr.school.equals(string)) {
				buildRelationship(prev, curr);
				String stringy= curr.name + "|" + "y" + curr.school;
				prev= curr;
				return stringy;
			}
		}
		return null;
	}

}
