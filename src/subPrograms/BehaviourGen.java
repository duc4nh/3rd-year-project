package subPrograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import object.Behaviour;
import object.InteractionCategory;
import database.BehaviourDatabase;

public class BehaviourGen {

	public static void main(String[] args) {
	    try {
            File file = new File("beha.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                String[] catStr = str[6].split("/");
                for (int i = 0; i < catStr.length; i++)
                {
                    InteractionCategory c;
                    if (catStr[i].charAt(0) == 'A') c = InteractionCategory.ANIMAL;
                    else if (catStr[i].charAt(0) == 'F') c = InteractionCategory.FOOD;
                    else if (catStr[i].charAt(0) == 'H') c = InteractionCategory.HUMAN;
                    else c = InteractionCategory.OBJECT;
                    BehaviourDatabase.add(new Behaviour(Integer.parseInt(str[0]), str[1], c, Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]), Integer.parseInt(str[5])));
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

		BehaviourDatabase.printAllDetails();
		BehaviourDatabase.save();
	}
}