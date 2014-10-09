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
		int input;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Welcome to Cat Simulator!");
		System.out.printf("Before simulator:\n");
		
		// QUESTION 1
		System.out.printf("Choose a preset cat(1) or Define new cat(2):");
		input = reader.nextInt();
		
		Cat cat;
		if (input == 1) {
			CatDatabase.printAll();
			//TODO choose 1
		}
		else {
			//TODO input information
			cat = new Cat();
		}
			
		// QUESTION 2
		System.out.printf("Choose preset environment(1) or Define new environment(2):");
		input = reader.nextInt();
		
		Environment environment;
		if (input == 1) {
			EnvironmentDatabase.printAll();
			//TODO choose 1
		}
		else {
			//TODO input information
			environment = new Environment();
		}
		
		// QUESTION 3
		System.out.printf("Choose a preset interaction object(1) or Define new interaction object(2):");
		input = reader.nextInt();
		
		InteractionObject object;
		if (input == 1) {
			ObjectDatabase.printAll();
			//TODO choose 1
		}
		else {
			//TODO input information
			object = new InteractionObject();
		}
			
		System.out.println("Start simulation");
		Simulator.simulation(cat, environment, object);
		System.out.println(input);

		
	}
	
}
