package subPrograms;

import database.BehaviourDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;

/**
 * Test all databases. Not for user.
 * 
 * @author DucAnh
 *
 */
public class DatabaseTest
{
	public static void main(String[] args)
	{
		// CatDatabase.openDatabase();
		EnvironmentDatabase.openDatabase();
		InteractionDatabase.openDatabase();
		BehaviourDatabase.openDatabase();

		System.out.println("PRINT ALL DATABASE");

		InteractionDatabase.printAllDetails();
		EnvironmentDatabase.printAllDetails();
		BehaviourDatabase.printAllDetails();
	}
}