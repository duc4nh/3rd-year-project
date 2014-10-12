package UI;

import java.util.Scanner;

import object.Cat;
import object.Environment;
import object.InteractionObject;
import database.CatDatabase;
import database.EnvironmentDatabase;
import database.ObjectDatabase;
import simulator.Simulator;

public class MainUIinText {
	private static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Cat Simulator!");
		System.out.printf("BEFORE SIMULATION:\n");

		int input = 1;
		while (input == 1) {
			// Initialise the program
			CatDatabase.openDatabase();
			EnvironmentDatabase.openDatabase();
			ObjectDatabase.openDatabase();
			
			// PRE-SIMULATION
			Cat cat = inputCat();
			Environment environment = inputEnvironment();
			InteractionObject object = inputObject();

			// SIMULATION
			System.out.print("START SIMULATION: ");
			String result = Simulator.simulation(cat, environment, object);
			System.out.println(result);
			
			// POST-SIMULATION
			ObjectDatabase.close();
			EnvironmentDatabase.close();
			CatDatabase.close();
			
			// Play it again
			System.out.print("New simulation(1)?");
			input = reader.nextInt();
			
		}
	}

	private static Cat inputCat() {
		System.out.println("Below is a list of available cats:");

		CatDatabase.printAll();
		System.out.print("Which do you want?:");
		Cat cat = CatDatabase.get(reader.nextInt());

		return cat;
	}

	private static Environment inputEnvironment() {
		System.out
				.print("Choose preset environment(1) or Define new environment(2):");
		int input = reader.nextInt();

		Environment environment;
		if (input == 1) {
			EnvironmentDatabase.printAll();
			System.out.print("Which do you want?:");
			environment = EnvironmentDatabase.get(reader.nextInt());
		} else {
			environment = EnvironmentGenerator.create();
		}

		return environment;
	}

	private static InteractionObject inputObject() {
		System.out
				.print("Choose a preset interaction object(1) or Define new interaction object(2):");
		int input = reader.nextInt();

		InteractionObject object;
		if (input == 1) {
			ObjectDatabase.printAll();
			System.out.print("Which do you want?:");
			object = ObjectDatabase.get(reader.nextInt());
		} else {
			object = InteractionObjectGenerator.create();
		}

		return object;
	}
}
