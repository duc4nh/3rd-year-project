package subPrograms;

import database.EnvironmentDatabase;
import object.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Generate environment database from the csv file. Not for user.
 *
 * @author DucAnh
 */
public class EnviGen2 {
	public static void main(String[] args) {
		try {
			File file = new File("resource/envi.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] str = line.split(",");
				EnvironmentDatabase.add(new Environment(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]), Integer.parseInt(str[5])));
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		EnvironmentDatabase.printAllDetails();
		System.out.println("Size: " + EnvironmentDatabase.getSize());
		EnvironmentDatabase.save();
	}
}