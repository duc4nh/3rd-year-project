package database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import object.Environment;

public class EnvironmentDatabase {

	private static List<Environment> environmentDatabase = new ArrayList<Environment>();

	public static void openDatabase() {

		// Wrap all in a try/catch block to trap I/O errors.
		try {
			// Open file to read from
			FileInputStream saveFile = new FileInputStream("environment.sav");
			// Create an ObjectInputStream to get objects from save file.
			ObjectInputStream restore = new ObjectInputStream(saveFile);
			// restore
			environmentDatabase = (List<Environment>) restore.readObject();
			restore.close();
		} catch (Exception exc) {
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

	public static void printAllDetails() {
		// TODO: if empty
		int i = 1;
		System.out.println("ENVI DATABASE: ");
		for (Environment envi : environmentDatabase) {
			System.out.println(i + ". " + envi.getName() + "\t\t\t"
					+ envi.getTemperature() + "\t" + envi.getHumidity() + "\t"
					+ envi.getLight() + "\t" + envi.getNoise());
			i++;
		}
	}

	public static void printAll() {
		// TODO: if empty
		int i = 1;
		for (Environment envi : environmentDatabase) {
			System.out.println(i + ". " + envi.getName());
			i++;
		}
	}

	public static Environment get(int id) {
		return environmentDatabase.get(id - 1);
	}

	public static void add(Environment envi) {
		environmentDatabase.add(envi);
	}

	public static void delete(int id) {
		environmentDatabase.remove(id - 1);
	}

	public static void close() {
		try {
			// Open a file to write to
			FileOutputStream saveFile = new FileOutputStream("environment.sav");
			// Create an ObjectOutputStream to put objects into save file.
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(environmentDatabase);
			// Close the file.
			save.close(); // This also closes saveFile.
		} catch (Exception exc) {
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

}
