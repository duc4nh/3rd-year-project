package database;

import object.Cat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CatDatabase {

	private static List<Cat> catDatabase = new ArrayList<Cat>();

	@SuppressWarnings("unchecked")
	public static void openDatabase() {
		// Wrap all in a try/catch block to trap I/O errors.
		try {
			// Open file to read from
			FileInputStream saveFile = new FileInputStream("resource/cat.sav");
			// Create an ObjectInputStream to get objects from save file.
			ObjectInputStream restore = new ObjectInputStream(saveFile);
			// restore
			catDatabase = (List<Cat>) restore.readObject();
			restore.close();
		} catch (Exception exc) {
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

	public static void printAll() {
		int i = 1;
		for (Cat cat : catDatabase) {
			System.out.println(i + ". " + cat.getName() + "/ Emotion: " + cat.getEmotion());
			i++;
		}
	}

	public static Cat get(int id) {
		return catDatabase.get(id - 1);
	}

	public static void add(Cat cat) {
		catDatabase.add(cat);
	}

	public static void save() {
		try {
			// Open a file to write to
			FileOutputStream saveFile = new FileOutputStream("resource/cat.sav");
			// Create an ObjectOutputStream to put objects into save file.
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(catDatabase);
			// Close the file.
			save.close(); // This also closes saveFile.
		} catch (Exception exc) {
			exc.printStackTrace(); // If there was an error, print the info.
		}
	}

}
