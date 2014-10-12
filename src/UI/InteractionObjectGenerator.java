package UI;

import java.util.Scanner;

import database.ObjectDatabase;
import object.InteractionObject;

public class InteractionObjectGenerator {

	public static InteractionObject create() {
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = reader.nextLine();
		System.out.print("Big(1) or Small: ");
		int size = reader.nextInt();
		System.out.print("Moving(1) or Stay: ");
		int move = reader.nextInt();

		InteractionObject obj = new InteractionObject(name, size, move);
		
		//Save new thing to database
		ObjectDatabase.add(obj);
		
		return obj;
	}

}
