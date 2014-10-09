package UI;

import java.util.Scanner;

import database.CatDatabase;
import database.EnvironmentDatabase;
import database.ObjectDatabase;
import simulator.Cat;
import simulator.CatGenerator;
import simulator.Environment;
import simulator.EnvironmentGenerator;
import simulator.InteractionObject;
import simulator.InteractionObjectGenerator;
import simulator.Simulator;

public class TextUI {
	public static void main(String[] args) {
		System.out.println("Welcome to Cat Simulator!");
		System.out.printf("Before simulation:\n");
		
		int input = 1;
		while (input == 1) {
		// PRE-SIMULATION
		Cat cat = inputCat();
		Environment environment = inputEnvironment();
		InteractionObject object = inputObject();

		//SIMULATION
		System.out.println("Start simulation");
		String result = Simulator.simulation(cat, environment, object);
		System.out.println(result);
		
		//POST-SIMULATION
		System.out.println("New simulation(1)?");
		input = read();		
		}
	}
	
	private static int read() {
		Scanner reader = new Scanner(System.in);
		int input = reader.nextInt();
		return input;
	}
	
	private static Cat inputCat() {
		System.out.print("Choose a preset cat(1) or Define new cat(2):");
		int input = read();
		
		Cat cat;
		if (input == 1) {
			CatDatabase.printAll();
			System.out.print("Which do you want?:");
			cat = CatDatabase.get(read());
		}
		else {
			cat = CatGenerator.create();
		}
		
		return cat;
	}
	
	private static Environment inputEnvironment() {
		System.out.print("Choose preset environment(1) or Define new environment(2):");
		int input = read();
		
		Environment environment;
		if (input == 1) {
			EnvironmentDatabase.printAll();
			System.out.print("Which do you want?:");
			environment = EnvironmentDatabase.get(read());
		}
		else {
			environment = EnvironmentGenerator.create();
		}
		
		return environment;
	}

	private static InteractionObject inputObject() {
		System.out.print("Choose a preset interaction object(1) or Define new interaction object(2):");
		int input = read();
		
		InteractionObject object;
		if (input == 1) {
			ObjectDatabase.printAll();
			System.out.print("Which do you want?:");
			object = ObjectDatabase.get(read());
		}
		else {
			object = InteractionObjectGenerator.create();
		}
		
		return object;
	}
}
