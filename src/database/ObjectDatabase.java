package database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import object.InteractionObject;

public class ObjectDatabase {

	private static List<InteractionObject> objectDatabase = new ArrayList<InteractionObject>();

	public static void openDatabase() {

		// Wrap all in a try/catch block to trap I/O errors.
		try {
			// Open file to read from
			FileInputStream saveFile = new FileInputStream("object.sav");
			// Create an ObjectInputStream to get objects from save file.
			ObjectInputStream restore = new ObjectInputStream(saveFile);
			// restore
			objectDatabase = (List<InteractionObject>) restore.readObject();
			restore.close();
		} catch (Exception exc) {
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

	public static void printAll() {
		int i = 1;
		for (InteractionObject object : objectDatabase) {
			System.out.println(i + ". " + object.getName() + ": Size: "
					+ object.getSize() + "/ Move: " + object.getMove());
			i++;
		}
	}

	public static InteractionObject get(int id) {
		return objectDatabase.get(id-1);
	}

	public static void add(InteractionObject obj) {
		objectDatabase.add(obj);
	}

	public static void close() {
		try {
			// Open a file to write to
			FileOutputStream saveFile = new FileOutputStream("object.sav");
			// Create an ObjectOutputStream to put objects into save file.
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(objectDatabase);
			// Close the file.
			save.close(); // This also closes saveFile.
		} catch (Exception exc) {
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

}
