package UI;

import java.util.Scanner;

import database.CatDatabase;
import database.EnvironmentDatabase;
import database.ObjectDatabase;
import simulator.Cat;
import simulator.Environment;
import simulator.InteractionObject;
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
		Scanner reader = new Scanner(System.in);
		System.out.println("New simulation(1)?");
		input = reader.nextInt();		
		}
	}
	
	private static Cat inputCat() {
		Scanner reader = new Scanner(System.in);
		
		System.out.printf("Choose a preset cat(1) or Define new cat(2):");
		int input = reader.nextInt();
		
		Cat cat;
		if (input == 1) {
			CatDatabase.printAll();
			//TODO choose 1
			cat = new Cat();
		}
		else {
			//TODO input information
			cat = new Cat();
		}
		
		return cat;
	}
	
	private static Environment inputEnvironment() {
		Scanner reader = new Scanner(System.in);
		
		System.out.printf("Choose preset environment(1) or Define new environment(2):");
		int input = reader.nextInt();
		
		Environment environment;
		if (input == 1) {
			EnvironmentDatabase.printAll();
			//TODO choose 1
			environment = new Environment();
		}
		else {
			//TODO input information
			environment = new Environment();
		}
		
		return environment;
	}

	private static InteractionObject inputObject() {
		Scanner reader = new Scanner(System.in);
		
		System.out.printf("Choose a preset interaction object(1) or Define new interaction object(2):");
		int input = reader.nextInt();
		
		InteractionObject object;
		if (input == 1) {
			ObjectDatabase.printAll();
			//TODO choose 1
			object = new InteractionObject();
		}
		else {
			//TODO input information
			object = new InteractionObject();
		}
		
		return object;
	}
}
