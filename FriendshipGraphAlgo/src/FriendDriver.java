import java.io.*;
import java.util.Scanner;

public class FriendDriver
{
	static BufferedReader br, file;
	public static final int studSchool = 1;
	public static final int intro = 2;
	public static final int cliques = 3;
	public static final int connectors = 4;
	public static final int quit = 5;

	static Friend newFriend = new Friend();

	public static void main(String[] args) throws IOException
	{
		String string = "sam|y|rutgers";
		String[] parts = string.split("|");
		String part1 = parts[0]; // 004
		String part2 = parts[1]; // 034556
		System.out.println(parts[0] + " " +parts[1] + " " +parts[2]);


		System.out.println("Welcome to the Friendship Graph Algorithm program.");
		System.out.println("Please input the name of a file that you would like to generate a graph from.");
		System.out.println("The first line of the file should contain the number (n) of friends in the list.");
		System.out.println("The following n lines should contain the names of your friends and the schools that they attend.");
		System.out.println("The format for a friend who attends a university should be sharlina|y|rutgers.");
		System.out.println("The format for a friend who does not attend a university should be ellen|n");
		System.out.println("The lines below that should list out the relationships between your friends.");
		System.out.println("An example would be sharlina|ellen. This indicates that sharlina and ellen have a relationship.");


		//how to read file in
		br = new BufferedReader(new InputStreamReader(System.in));
		file = new BufferedReader(new FileReader(br.readLine()));
		Scanner scan= new Scanner(file);
		newFriend.buildGraph(scan);

		int choice = getChoice();
		while (choice != quit)
		{
			if (choice < 1 || choice > quit)
				System.out.println("\tIncorrect choice " + choice);
			else
				switch (choice)
				{
				case studSchool: studSchool(); break;
				case intro: intro(); break;
				case cliques: cliques(); break;
				case connectors: connectors(); break;
				default: break;
				}
			choice = getChoice();
		}

	}

	public static int getChoice() throws IOException
	{
		System.out.println();
		System.out.println(studSchool + ". Subgraph");
		System.out.println(intro + ". Introduction");
		System.out.println(cliques + ". Cliques");
		System.out.println(connectors + ". Connectors");
		System.out.println(quit + ". QUIT");
		System.out.print("\tEnter choice # => ");
		return (Integer.parseInt(br.readLine()));
	}

	public static void studSchool() throws IOException
	{
		System.out.println("Please input the name of the school you would like to see subgraph for.");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String school = in.readLine();
		newFriend.subGraph(school);
		//System.out.println(newFriend.subGraph(newFriend.peopleAdjLL, school));
	}

	public static void intro()
	{

	}

	public static void cliques()
	{

	}

	public static void connectors()
	{

	}


}


