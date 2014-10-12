package UI;

import java.util.Scanner;

import database.EnvironmentDatabase;
import object.Environment;

public class EnvironmentGenerator {

	public static Environment create() {
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = reader.nextLine();
		System.out.print("Hot(1) or Cold: ");
		int temperature = reader.nextInt();
		System.out.print("Humid(1) or Dry: ");
		int humidity = reader.nextInt();
		System.out.print("Dark(1) or Light: ");
		int light = reader.nextInt();
		System.out.print("Noisy(1) or Quite: ");
		int noise = reader.nextInt();

		Environment environment = new Environment(name, temperature, humidity, light, noise);
		
		//Save new thing to database
		EnvironmentDatabase.add(environment);
		
		return environment;
	}

}
