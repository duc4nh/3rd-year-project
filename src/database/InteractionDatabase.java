package database;

import object.Interaction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class InteractionDatabase {

	private static List<Interaction> interactionDatabase = new ArrayList<Interaction>();

	@SuppressWarnings("unchecked")
	public static void openDatabase() {

		// Wrap all in a try/catch block to trap I/O errors.
		try {
			// Open file to read from
			FileInputStream saveFile = new FileInputStream("resource/database/interaction.sav");
			// Create an ObjectInputStream to get objects from save file.
			ObjectInputStream restore = new ObjectInputStream(saveFile);
			// restore
			interactionDatabase = (List<Interaction>) restore.readObject();
			restore.close();
		} catch (Exception exc) {
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

	public static void printAll() {
		int i = 1;
		for (Interaction interaction : interactionDatabase) {
			System.out.println(i + ". " + interaction.getName());
			i++;
		}
	}

	public static void printAllDetails() {
		int i = 1;
		System.out.println("INTER DATABASE: ");
		for (Interaction interaction : interactionDatabase) {
			System.out.println(i + ". " + interaction.getId() + "\t" + interaction.getName() + "\t\t\t" + interaction.getExcited() + "\t" + interaction.getFearful() + "\t" + interaction.getRelieved() + "\t" + interaction.getAngry() + "\t" + interaction.getCate() + "\t" + interaction.getInfo());
			i++;
		}
	}

	public static String[] getArray() {
		int i = 1;
		String[] s = new String[interactionDatabase.size()];
		for (Interaction interaction : interactionDatabase) {
			s[i - 1] = i + ". " + interaction.getName();
			i++;
		}
		return s;
	}

	public static Interaction get(int id) {
		return interactionDatabase.get(id - 1);
	}

	public static void add(Interaction inter) {
		interactionDatabase.add(inter);
	}

	public static void delete(int id) {
		interactionDatabase.remove(id - 1);
	}

	public static int getSize() {
		return interactionDatabase.size();
	}

	public static void save() {
		try {
			// Open a file to write to
			FileOutputStream saveFile = new FileOutputStream("resource/database/interaction.sav");
			// Create an ObjectOutputStream to put objects into save file.
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(interactionDatabase);
			// Close the file.
			save.close(); // This also closes saveFile.
		} catch (Exception exc) {
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

}
