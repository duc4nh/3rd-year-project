package Tests;


import database.BehaviourDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;

public class DatabaseTest {

	public static void main(String[] args) {
		//CatDatabase.openDatabase();
		EnvironmentDatabase.openDatabase();
		InteractionDatabase.openDatabase();
		BehaviourDatabase.openDatabase();
		
		System.out.println("PRINT ALL DATABASE");

		InteractionDatabase.printAllDetails();
		EnvironmentDatabase.printAllDetails();
		BehaviourDatabase.printAllDetails();
		
		//InteractionDatabase.close();
		//EnvironmentDatabase.close();
		//BehaviourDatabase.close();
	}
	
	//private static reader.close();
}