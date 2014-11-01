package Tests;

import java.util.Scanner;

import database.CatDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;
import object.Cat;
import object.Emotion;
import object.Environment;
import object.Interaction;

public class Objectgen {

	public static void main(String[] args) {
		CatDatabase.openDatabase();
		EnvironmentDatabase.openDatabase();
		InteractionDatabase.openDatabase();
		
		System.out.println("Welcome to Cat Simulator!");

		CatDatabase.printAll();
		
		Cat cat = CatDatabase.get(0);
		System.out.println("CAT STATUS:");
		System.out.println(cat.getName() + ": Age: " + cat.getAge()
				+ "/ Emotion: " + cat.getEmotion());
		
		/*Scanner reader = new Scanner(System.in);
		System.out.print("read:");
		int a = reader.nextInt();
		System.out.println(a);
		int b = reader.nextInt();
		System.out.println(b);
		ObjectDatabase.add(obj);
		ObjectDatabase.add(obj);
		ObjectDatabase.add(obj);
		ObjectDatabase.add(obj);
		ObjectDatabase.printAll();
		ObjectDatabase.save();
		ObjectDatabase.openDatabase();
		ObjectDatabase.printAll();
		
		ObjectDatabase.save();
		EnvironmentDatabase.save();
		
		*/
		
		InteractionDatabase.printAll();
		EnvironmentDatabase.printAll();
	}
	
	//private static reader.close();
}