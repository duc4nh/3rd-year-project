package UI;

import database.EnvironmentDatabase;
import database.InteractionDatabase;
import object.Environment;
import object.Interaction;
import object.InteractionCategory;

import java.util.Scanner;

/**
 * Part of the UI in text
 *
 * @author DucAnh
 */
public class Library {

	private static Scanner reader = new Scanner(System.in);

	public static void ViewLibrary() {
		int input = 0;
		System.out.println("-------------------------------");
		System.out.print("LIBRARY MENU: View Environment(1), View Interaction(2), BACK(3): ");
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
			System.out.println("INTERACTION LIBRARY MENU");
			InteractionDatabase.printAll();
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
		InteractionDatabase.delete(reader.nextInt());
	}

	private static void deleteEnvi() {
		System.out.print("Which one to delete? ");
		EnvironmentDatabase.delete(reader.nextInt());
	}

	private static Environment createEnvi() {

		System.out.print("Name: ");
		Scanner stringReader = new Scanner(System.in);
		String name = stringReader.nextLine();

		System.out.print("Hot or Cold (-5 to 5): ");
		int temperature = reader.nextInt();
		System.out.print("Humid or Dry(-5 to 5): ");
		int humidity = reader.nextInt();
		System.out.print("Dark or Light(-5 to 5): ");
		int light = reader.nextInt();
		System.out.print("Noisy or Normal(-5 to 5): ");
		int noise = reader.nextInt();

		Environment environment = new Environment(EnvironmentDatabase.getSize() + 1, name, temperature, humidity, light, noise);

		// Save new thing to database
		EnvironmentDatabase.add(environment);

		return environment;
	}

	private static Interaction createObj() {

		System.out.print("Name: ");
		Scanner stringReader = new Scanner(System.in);
		String name = stringReader.nextLine();

		System.out.print("Type: OBJECT(1), ANIMAL(2), FOOD(3), HUMAN(4):");
		int typeInput = reader.nextInt();
		InteractionCategory type;
		switch (typeInput) {
			case 1:
				type = InteractionCategory.OBJECT;
				break;
			case 2:
				type = InteractionCategory.ANIMAL;
				break;
			case 3:
				type = InteractionCategory.FOOD;
				break;
			default:
				type = InteractionCategory.HUMAN;
				break;
		}

		System.out.println("When the cat sees this, how likely do you think it will feel:");
		System.out.print("Excited (between -2 and 2)? ");
		int excited = reader.nextInt();
		System.out.print("Fearful (between -2 and 2)? ");
		int fearful = reader.nextInt();
		System.out.print("Relieved (between -2 and 2)? ");
		int relieved = reader.nextInt();
		System.out.print("Angry (between -2 and 2)? ");
		int angry = reader.nextInt();

		Interaction obj = new Interaction(InteractionDatabase.getSize() + 1, name, type, excited, fearful, relieved, angry, "FAKE INFO");

		// Save new thing to database
		InteractionDatabase.add(obj);

		return obj;
	}

}
