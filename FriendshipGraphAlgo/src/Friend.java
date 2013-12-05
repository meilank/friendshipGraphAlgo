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
			/*if (isFirstLine) {

                        }*/
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

		/*                //check relationships
                for(String p : peopleAdjLL.peopleMap.keySet())
                {
                        Person curr = peopleMap.get(p);
                        do
                        {
                                System.out.println(curr.name);
                                curr = curr.next;
                        }
                        while(curr != null);
                        System.out.println("--");
                }*/
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

	public void createPerson()
	{

	}
	//--------------------------------------------------------------------------------------------------------------
	class Neighbor {
		public int vertexNum;
		public Neighbor next;
		public Neighbor(int vnum, Neighbor nbr) {
			this.vertexNum = vnum;
			next = nbr;
		}
	}

	class Vertex {
		String name;
		Neighbor adjList;
		Vertex(String name, Neighbor neighbors) {
			this.name = name;
			this.adjList = neighbors;
		}
	}

	public void subGraph(String school) {
		String school2= school.toLowerCase();
		String cool;
		HashMap<String,Person> schoolMap = new HashMap<String,Person>();
		ArrayList<Person> personList = new ArrayList<Person>();
		cool= peopleAdjLL.search(school2);
	}

	public HashMap<String,Person> subGraphy(AdjLL graph, String school)
	{
		HashMap<String,Person> schoolMap = new HashMap<String,Person>();
		ArrayList<Person> personList = new ArrayList<Person>();
		for(String s : graph.peopleMap.keySet())
		{
			Person tempPerson = graph.peopleMap.get(s);
			String tempSchool = tempPerson.school;

			//below algorithm is to copy person that attends parameter school
			//and all of his neighbors into a new hashmap called schoolMap
			//MUST BE MORE EFFICIENT WAY TO DO THIS
			//loop through peopleMap and find those that have matching schools
			//when you find a match, copy it and all of its neighbors into an array
			//then loop through array and connect them all into a linked list.
			//lastly, put first node in the array into schoolMap
			if(tempSchool.equals(school))
			{

				int i = 0;
				Person curr = tempPerson;
				do
				{
					Person newPerson = new Person(curr.name, curr.school, null);
					personList.add(newPerson);
					i++;
					curr = curr.next;
				} while (curr != null);

				for(int j = 0; j < personList.size(); j++)
					if(j != personList.size()-2)
						if(personList.get(j+1).school.equals(school))
							personList.get(j).next = personList.get(j+1);
						else personList.remove(j+1);
					else personList.get(j).next = null;

				schoolMap.put(personList.get(0).name, personList.get(0));

			}
		}




		return null;
	}
}
