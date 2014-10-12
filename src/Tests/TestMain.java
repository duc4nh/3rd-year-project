package Tests;

import java.util.Scanner;

import database.CatDatabase;
import database.EnvironmentDatabase;
import database.ObjectDatabase;
import object.Cat;
import object.Emotion;
import object.Environment;
import object.InteractionObject;
import UI.EnvironmentGenerator;
import UI.InteractionObjectGenerator;

public class TestMain {

	public static void main(String[] args) {
		/*//Test EnvironmentGen
		System.out.println("test envi generator");
		Environment ele = EnvironmentGenerator.create();
		System.out.println(ele.getName() + ele.getLight() + ele.getHumidity());
		
		//test obj gen
		System.out.println("test obj generator");
		InteractionObject obj = InteractionObjectGenerator.create();
		System.out.println(obj.getName() + obj.getSize() + obj.getMove());*/
		
		//gen cat
		Cat cat = new Cat("Common Domestic Cat", 1, Emotion.NEUTRAL);
		CatDatabase.add(cat);
		CatDatabase.close();
		
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
		ObjectDatabase.openDatabase();
		EnvironmentDatabase.openDatabase();
		
		ObjectDatabase.printAll();
		EnvironmentDatabase.printAll();
	}
	
	//private static reader.close();
}