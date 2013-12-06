import java.io.*;
import java.util.*;

public class Friend
{
	int numPeople;
	Person[] peopleArr = null;
	AdjLL peopleAdjLL = null;
	Scanner scan;

	public Friend()
	{

	}

	public void buildGraph(Scanner file) throws IOException
	{
		Scanner sc = file;
		this.scan= file;
		Person newPerson;

		String line = sc.nextLine();
		String temp = line.toString();
		numPeople = Integer.parseInt(temp);

		Person[] people= new Person[numPeople];

		for(int i = 0; i < numPeople; i++)
		{
			line = sc.nextLine();
			String [] lineArr = SplitUsingTokenizer(line,"|");
			if(lineArr[1].contains("y"))
			{
				newPerson = new Person(lineArr[0], lineArr[2], null);

			}
			else
				newPerson = new Person(lineArr[0], null, null);

			people[i] = newPerson;
		}
		peopleArr= people;
		peopleAdjLL = new AdjLL(numPeople, peopleArr);
		Map<String,Person> peopleMap = peopleAdjLL.peopleMap;

		//build relationships
		while(sc.hasNext())
		{
			line = sc.nextLine();
			String [] lineArr = SplitUsingTokenizer(line,"|");
			Person p1 = peopleMap.get(lineArr[0]);
			Person p2 = peopleMap.get(lineArr[1]);

			peopleAdjLL.buildRelationship(p1,p2);

		}
		sc.close();
	}

	public static String[] SplitUsingTokenizer(String Subject, String Delimiters)
	{
		StringTokenizer StrTkn = new StringTokenizer(Subject, Delimiters);
		ArrayList<String> ArrLis = new ArrayList<String>(Subject.length());
		while(StrTkn.hasMoreTokens())
		{
			ArrLis.add(StrTkn.nextToken());
		}
		return ArrLis.toArray(new String[0]);
	}

	public AdjLL subGraph(String school, AdjLL graph)
	{
		ArrayList<Person> sameSchoolList = new ArrayList<Person>();
		String schoolLower= school.toLowerCase();
		for(String s : graph.peopleMap.keySet())
		{
			Person curr = graph.peopleMap.get(s);
			Person currNew = null;
			try
			{
				if(curr.school.equals(school))
				{
					Person newPerson = new Person(curr.name, curr.school, null);
					System.out.println(curr.name + "|y|" + curr.school);
					sameSchoolList.add(newPerson);
					Person curr2 = newPerson;
					currNew = newPerson;
					curr = curr.next;
					do
					{
						try
						{
							if(curr.school.equals(schoolLower))
							{
								newPerson = new Person(curr.name, curr.school, null);
								currNew.next = newPerson;
								currNew = currNew.next;
							}
						}
						catch(Exception e) {}
						curr = curr.next;
					} while(curr != null);

					do
					{
						curr2 = curr2.next;
					}
					while(curr2 != null);
				}
			}
			catch(Exception e) {}


		}

		Person[] sameSchoolArr = sameSchoolList.toArray(new Person[sameSchoolList.size()]);
		AdjLL sameSchoolAdjLL = new AdjLL(sameSchoolList.size(), sameSchoolArr);

		return sameSchoolAdjLL;

		/*String school2= school.toLowerCase();

for(String s : graph.peopleMap.keySet())
{
Person curr = graph.peopleMap.get(s);
if (curr.school == null || !curr.school.equals(school))
continue;
else
System.out.println(peopleAdjLL.search(school2, s, curr));
}*/
	}


	public Person shortestPath(String name) throws NoSuchPath {


		return null;
	}

	public class NoSuchPath extends Exception {

		private static final long serialVersionUID = 1L;

		public void noPath() {
			System.out.println("There is no path to this person");
			return;
		}

	}
}
