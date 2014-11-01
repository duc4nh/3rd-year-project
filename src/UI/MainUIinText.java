package UI;

import java.util.Scanner;

import object.Cat;
import object.Emotion;
import object.Environment;
import object.Interaction;
import database.CatDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;
import simulator.Simulator;

public class MainUIinText {
	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		// Initialise the program
		// CatDatabase.openDatabase();
		EnvironmentDatabase.openDatabase();
		InteractionDatabase.openDatabase();

		System.out.println("-------------------------------");
		System.out.println("Welcome to Cat Simulator!");
		System.out.println("-------------------------------");

		Emotion emo = new Emotion(0, 0, 0, 0);
		Cat cat = new Cat("Common Domestic Cat", 1, emo);
		Simulator.printStatus(cat);

		boolean exit = false;
		while (!exit) {

			// PRE-SIMULATION
			System.out.println("-------------------------------");
			System.out
					.print("MAIN MENU: Start simulation(1), View Library(2), Exit(0): ");
			int input = reader.nextInt();
			if (input == 2) {
				Library.ViewLibrary();
			} else if (input == 1) {
				// SIMULATION
				System.out.println("-------------------------------");
				System.out.println("START SIMULATION");
				Environment environment = inputEnvironment();
				Interaction object = inputObject();

				Simulator.simulation(cat, environment, object);

				// POST-SIMULATION
				System.out.println("-------------------------------");
				System.out.print("Continue the simulation?(1) ");
				if (reader.nextInt() != 1)
					exit = true;
			} else
				exit = true;
		}

		// CLOSE DATABASE
		InteractionDatabase.close();
		EnvironmentDatabase.close();
		// CatDatabase.close();
	}

	/*
	 * private static Cat inputCat() {
	 * System.out.println("Below is a list of available cats:");
	 * 
	 * CatDatabase.printAll(); System.out.print("Which do you want?:"); Cat cat
	 * = CatDatabase.get(reader.nextInt());
	 * 
	 * return cat; }
	 */

	private static Environment inputEnvironment() {
		System.out.println("-------------------------------");
		System.out.println("Choose an environment:");
		EnvironmentDatabase.printAll();
		System.out.print("Which do you want?: ");
		Environment environment = EnvironmentDatabase.get(reader.nextInt());

		return environment;
	}

	private static Interaction inputObject() {
		System.out.println("-------------------------------");
		System.out.println("Choose an interaction object:");
		InteractionDatabase.printAll();
		System.out.print("Which do you want?: ");
		Interaction object = InteractionDatabase.get(reader.nextInt());

		return object;
	}
}
