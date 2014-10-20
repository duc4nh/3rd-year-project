package UI;

import java.util.Scanner;

import object.Environment;
import object.InteractionObject;
import database.EnvironmentDatabase;
import database.ObjectDatabase;

public class Library {

	private static Scanner reader = new Scanner(System.in);

	public static void ViewLibrary() {
		int input = 0;
		while (input != 3) {
			System.out.println("-------------------------------");
			System.out
					.print("LIBRARY MENU: View Environment(1), View Object(2), BACK(3): ");
			input = reader.nextInt();
			switch (input) {
			case 1:
				enviLibrary();
				break;
			case 2:
				objLibrary();
				break;
			default:
				break;
			}
		}
	}

	private static void enviLibrary() {
		int input = 0;
		while (input != 3) {
			System.out.println("-------------------------------");
			System.out.println("ENVIRONMENT LIBRARY MENU");
			EnvironmentDatabase.printAll();
			System.out.print("OPTION: Add(1), Delete(2), BACK(3): ");
			input = reader.nextInt();
			switch (input) {
			case 1:
				createEnvi();
				break;
			case 2:
				deleteEnvi();
				break;
			default:
				break;
			}
		}
	}

	private static void objLibrary() {
		int input = 0;
		while (input != 3) {
			System.out.println("-------------------------------");
			System.out.println("OBJECT LIBRARY MENU");
			ObjectDatabase.printAll();
			System.out.print("OPTION: Add(1), Delete(2), BACK(3): ");
			input = reader.nextInt();
			switch (input) {
			case 1:
				createObj();
				break;
			case 2:
				deleteObj();
				break;
			default:
				break;
			}
		}
	}
	
	private static void deleteObj() {
		System.out.print("Which one to delete? ");
		ObjectDatabase.delete(reader.nextInt());
	}
	
	private static void deleteEnvi() {
		System.out.print("Which one to delete? ");
		EnvironmentDatabase.delete(reader.nextInt());
	}

	private static Environment createEnvi() {

		System.out.print("Name: ");
		String name = reader.nextLine();
		System.out.print("Hot(1) or Neutral(0) or Cold(-1): ");
		int temperature = reader.nextInt();
		System.out.print("Humid(1) or Dry(0): ");
		int humidity = reader.nextInt();
		System.out.print("Dark(1) or Light(0): ");
		int light = reader.nextInt();
		System.out.print("Noisy(1) or Normal(0): ");
		int noise = reader.nextInt();

		Environment environment = new Environment(name, temperature, humidity,
				light, noise);

		// Save new thing to database
		EnvironmentDatabase.add(environment);

		return environment;
	}

	private static InteractionObject createObj() {

		System.out.print("Object Name: ");
		String name = reader.nextLine();
		System.out.println("When the cat sees this, how likely do you think it will feel:");
		System.out.print("Excited (between -2 and 2)? ");
		int excited = reader.nextInt();
		System.out.print("Fearful (between -2 and 2)? ");
		int fearful = reader.nextInt();
		System.out.print("Relieved (between -2 and 2)? ");
		int relieved = reader.nextInt();
		System.out.print("Angry (between -2 and 2)? ");
		int angry = reader.nextInt();

		InteractionObject obj = new InteractionObject(name, excited, fearful, relieved, angry);

		// Save new thing to database
		ObjectDatabase.add(obj);

		return obj;
	}

}
